package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.LoginDto;
import com.ecom.app.dto.UserDto;
import com.ecom.app.entity.Catelog;
import com.ecom.app.entity.CatelogCount;
import com.ecom.app.entity.ProductCountEntity;
import com.ecom.app.entity.ProductEntity;

public interface Product_CartService {

	public String registerUser(UserDto userDto);

	public List<Catelog> login(LoginDto loginDto);

	public List<ProductEntity> showProduct(int id);

	public ProductEntity showProductDetail(int categoryId, int productId);

	public List<CatelogCount> showCatelogAnaLytics();

	public int getAnalytics(int id);

	public int showProductAnalytics(int id);

	public List<ProductCountEntity> showProductAnaLytics();
}
