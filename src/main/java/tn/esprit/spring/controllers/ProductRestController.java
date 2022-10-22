package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.IProduct;


@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	IProduct productService;
	
	// http://localhost:8090/SpringMVC/product/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Product> getProducts() {
	List<Product> listProducts = productService.retrieveAllProducts();
	return listProducts;
	}
	
	// http://localhost:8090/SpringMVC/product/retrieve-product/8
	@GetMapping("/retrieve-product/{product-id}")
	@ResponseBody
	public Product retrieveProduct(@PathVariable("product-id") Long idProduct) {
	return productService.retrieveProduct(idProduct);
	}
	
	// http://localhost:8090/SpringMVC/servlet/add-product
	@PostMapping("/add-product/{idStock}")
	@ResponseBody
	public Product addProduct(@RequestBody Product p ,@PathVariable("idStock") Long idStock)
	{
		Product product = productService.addProduct(p,idStock);
		return product;
	}
	
	// http://localhost:8090/SpringMVC/product/remove-product/{product-id}
	@DeleteMapping("/remove-product/{product-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("product-id") Long idProduct) {
		productService.deleteProduct(idProduct);
	}
	
	// http://localhost:8080/SpringMVC/servlet/modify-product
	@PutMapping("/modify-product")
	@ResponseBody
	public Product modifyProduct(@RequestBody Product product) {
	return productService.updateProduct(product);
	}
	
}
