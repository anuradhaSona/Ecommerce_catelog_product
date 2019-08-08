package com.ecom.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.LoginDto;
import com.ecom.app.dto.UserDto;
import com.ecom.app.entity.Catelog;
import com.ecom.app.entity.CatelogCount;
import com.ecom.app.entity.ProductCountEntity;
import com.ecom.app.entity.ProductEntity;
import com.ecom.app.service.Product_CartService;

@RestController
@RequestMapping("/product_cart")
public class ProductCartController {

	private static final Logger logger = LoggerFactory.getLogger(ProductCartController.class);

	@Autowired
	Product_CartService productCartService;

	@GetMapping("/analytics/{catelogId}")
	public ResponseEntity<Integer> getAnalytics(@PathVariable int catelogId) {
		return new ResponseEntity<>(productCartService.getAnalytics(catelogId), HttpStatus.OK);
	}

	@GetMapping("/catelogAnalytics")
	public ResponseEntity<List<CatelogCount>> getCatalogAnalytics() {
		List<CatelogCount> catelogCount = productCartService.showCatelogAnaLytics();
		return new ResponseEntity<>(catelogCount, HttpStatus.OK);
	}

	@GetMapping("/productAnalytics")
	public ResponseEntity<List<ProductCountEntity>> getProductAnalytics() {
		List<ProductCountEntity> listProduct = productCartService.showProductAnaLytics();
		return new ResponseEntity<>(listProduct, HttpStatus.OK);
	}

	@GetMapping("/productAnalytics/{productId}")
	public ResponseEntity<Integer> getProductAnalytics(@PathVariable int productId) {
		return new ResponseEntity<>(productCartService.showProductAnalytics(productId), HttpStatus.OK);
	}

	@PutMapping("/login")
	public ResponseEntity<List<Catelog>> login(@RequestBody LoginDto logindto) {
		List<Catelog> listCAtelog = productCartService.login(logindto);
		return new ResponseEntity<>(listCAtelog, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDto userdto) {

		logger.info("Inside register method...................");
		String status = productCartService.registerUser(userdto);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping("/catelog/{id}")
	public ResponseEntity<List<ProductEntity>> showProduct(@PathVariable int id) {
		List<ProductEntity> listProduct = productCartService.showProduct(id);
		return new ResponseEntity<>(listProduct, HttpStatus.OK);
	}

	@PostMapping("/catelog/{categoryId}/product/{productId}")
	public ResponseEntity<ProductEntity> showProductDetails(@PathVariable int categoryId, @PathVariable int productId) {
		return new ResponseEntity<>(productCartService.showProductDetail(categoryId, productId), HttpStatus.OK);
	}
}
