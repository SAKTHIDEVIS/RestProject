package com.neotech.app.neotech.repository;

import java.util.List;

import com.neotech.app.neotech.model.Product;

public interface ProductRepository {

	List<Product> getAllProducts();

	Product getProduct(int productId);
	
	int addProduct(Product product);
	
	boolean deleteProduct(int productId);
	
	boolean updateProduct(int productId, Product product);
	

}