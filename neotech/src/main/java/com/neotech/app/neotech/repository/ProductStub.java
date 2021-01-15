package com.neotech.app.neotech.repository;
import com.neotech.app.neotech.model.*;

import java.util.ArrayList;
import java.util.List;
public class ProductStub implements ProductRepository {
	static List<Product> products = new ArrayList<Product>();

	
	  static{ 
		  products.add(new Product(products.size()+1, 25000f, "connecting people", "Samsung"));
		  products.add(new Product(products.size()+1, 30000f, "Create the future", "OnePlus"));
	  }
	 

	@Override
	public List<Product> getAllProducts() {
		return products;
	}
	public Product findProduct(int productId) {
		Product found = null;
		for(Product product : products) {
			if(product.getProductId()==productId) {
				found= product;
				break;
			}
		}
		return found;
	}
	
	@Override
	public Product getProduct(int productId) {
		for(Product product : products) {
			if(product.getProductId()==productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public int addProduct(Product product) {

		product.setProductId(products.size()+1);
		products.add(product);
		return products.size();
	}
	@Override
	public boolean updateProduct(int productId, Product product) {
		Product toUpdate = new ProductStub().findProduct(productId);
		int index = products.indexOf(toUpdate);
		if (index >= 0) {
			product.setProductId(productId);
			products.set(index, product);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product Delete = new ProductStub().findProduct(productId);
		int index = products.indexOf(Delete);
		if (index >= 0) {
			products.remove(index);
			return true;
		}
		return false;
	}
	

}
