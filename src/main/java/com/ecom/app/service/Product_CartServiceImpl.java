package com.ecom.app.service;	

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.LoginDto;
import com.ecom.app.dto.UserDto;
import com.ecom.app.entity.Catelog;
import com.ecom.app.entity.CatelogCount;
import com.ecom.app.entity.ProductCountEntity;
import com.ecom.app.entity.ProductEntity;
import com.ecom.app.entity.UserEntity;
import com.ecom.app.repository.CatelogCountRepository;
import com.ecom.app.repository.CatelogRepository;
import com.ecom.app.repository.ProductCountRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.repository.UserRepository;

@Service
public class Product_CartServiceImpl implements Product_CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CatelogRepository catelogRepository;

	@Autowired
	CatelogCountRepository catelogCountRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductCountRepository productCountRepository;

	@Override
	public int getAnalytics(int id) {
		CatelogCount catelogCountStore = new CatelogCount();
		Optional<CatelogCount> catelogCount = catelogCountRepository.findById(id);
		int count = 0;
		if (catelogCount.isPresent()) {
			catelogCountStore = catelogCount.get();
			count = catelogCountStore.getCount();
		}
		return count;
	}

	@Override
	public List<Catelog> login(LoginDto loginDto) {
		List<Catelog> listCateLog = null;

		UserEntity user = userRepository.findByName(loginDto.getName());

		if (user != null) {
			if (loginDto.getPassword().equals(user.getPassword())) {

				listCateLog = catelogRepository.findAll();
			}
		}
		return listCateLog;
	}

	@Override

	public String registerUser(UserDto userdto) {

		UserEntity user = new UserEntity();

		if (userdto.getPassword().equals(userdto.getConfirmPassword())) {

			BeanUtils.copyProperties(userdto, user);
			userRepository.save(user);
		}

		else

		{
			// throw new PasswordNotMatch();
			return "registration failed";
		}

		return "sucess";

	}

	@Override
	public List<CatelogCount> showCatelogAnaLytics() {
		List<CatelogCount> catelogCount = catelogCountRepository.findAll();
		return catelogCount;
	}

	@Override
	public List<ProductEntity> showProduct(int id) {
		// category id as id
		Catelog store = new Catelog();
		Optional<Catelog> category = catelogRepository.findById(id);
		CatelogCount catelogcountStore = new CatelogCount();
		System.out.println(category.isPresent());
		if (category.isPresent()) {
			System.out.println(category.get().getCategoryName());
			store = category.get();
			System.out.println(store);
			System.out.println(store.getProduct());
			Optional<CatelogCount> catelogCount = catelogCountRepository.findByCatelog(store);
			if (catelogCount.isPresent()) {
				catelogcountStore = catelogCount.get();
				catelogcountStore.setCatelog(store);
				catelogcountStore.setCount(catelogcountStore.getCount() + 1);
				catelogcountStore.setId(catelogcountStore.getId());
				catelogCountRepository.save(catelogcountStore);

			} else {
				catelogcountStore.setCatelog(store);
				catelogcountStore.setCount(1);
				catelogCountRepository.save(catelogcountStore);
			}

		}

		else

		{

		}

		System.out.println(store.getProduct());

		return store.getProduct();
	}

	@Override
	public int showProductAnalytics(int id) {
		ProductCountEntity productCountStore = new ProductCountEntity();
		Optional<ProductCountEntity> productCount = productCountRepository.findById(id);
		int count = 0;
		if (productCount.isPresent()) {
			productCountStore = productCount.get();
			count = productCountStore.getCount();
		}
		return count;
	}

	@Override
	public List<ProductCountEntity> showProductAnaLytics() {
		List<ProductCountEntity> listProduct = productCountRepository.findAll();
		return listProduct;
	}

	@Override
	public ProductEntity showProductDetail(int categoryId, int productId) {
		ProductCountEntity productCount = new ProductCountEntity();
		ProductEntity product = new ProductEntity();

		Catelog Catelog = new Catelog();

		Optional<Catelog> catelogRepo = catelogRepository.findById(categoryId);
		if (catelogRepo.isPresent()) {
			Catelog = catelogRepo.get();
			Optional<ProductEntity> productById = productRepository.findById(productId);
			if (productById.isPresent()) {
				product = productById.get();
				if (Catelog.getProduct().contains(product)) {
					Optional<ProductCountEntity> proCount = productCountRepository.findByProduct(product);
					if (proCount.isPresent()) {
						System.out.println("present---update");
						productCount = proCount.get();
						productCount.setCount(productCount.getCount() + 1);
						productCount.setProduct(product);
						productCount.setId(productCount.getId());
						productCountRepository.save(productCount);
						product = product;

					} else {
						System.out.println("not present ---insert");
						productCount.setCount(1);
						productCount.setProduct(product);
						productCountRepository.save(productCount);
						product = product;
					}
				}
			}
		}
		return product;
	}
}
