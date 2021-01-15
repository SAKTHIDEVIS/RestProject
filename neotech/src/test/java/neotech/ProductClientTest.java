package neotech;

import static org.testng.Assert.*;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.app.neotech.client.ProductClient;
import com.neotech.app.neotech.model.*;

public class ProductClientTest {
	ProductClient client;
	@BeforeMethod
	//Arrange
	public void userSetUPMethod() {
	client=new ProductClient();
	}
	@Test(description="get the product")
	public void testGetProduct(){
		//Act
		Response product = client.getProduct(3);
		System.out.println(product.readEntity(Product.class));
		//Assert
		assertNotNull(product);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void testGetBadRequest() {
		//Act
		Response response = client.getProduct(-2);
		//Assert
		assertEquals(Response.status(Status.BAD_REQUEST).build(),response);
	}
	
	@Test(expectedExceptions = RuntimeException.class,description="Adding product")
	public void testGetRequestNotFound() {
		//Act
		Response response = client.getProduct(9999999);
		//Assert
		assertEquals(Response.status(Status.NOT_FOUND).build(),response);
	}
	
	@Test(description="getting product")
	public void testGetAllProducts(){
		//Act
		List<Product> products = client.getAllProducts();
		//Assert
		assertNotNull(products);
	}
	
	@Test(description="Adding product",timeOut=10)
	public void testAddProduct() { 
		//Act
		Response added = client.addProduct(new Product(4, 20000f,"Hello moto", "Motrola")); 
		//Assert
		assertNotNull(added); 
	}
	  
	@Test public void testUpdateProduct() { 
		//Act
		Response updated = client.updateProduct(3, new Product(1, 35000f, "Innovation Never Stands hello Still", "Realme"));
		//Assert
		assertNotNull(updated);
	 }
	  
	 @Test(enabled = false)
	 public void testDeleteProduct() {
		//Act
		 Response deleted = client.deleteProduct(1);
		//Assert
		 assertNotNull(deleted);
	}
}
