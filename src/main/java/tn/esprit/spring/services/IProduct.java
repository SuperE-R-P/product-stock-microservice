package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Product;

public interface IProduct {
	List<Product> retrieveAllProducts();

	Product addProduct(Product p,Long idStock);

	void deleteProduct(Long id);

	Product updateProduct(Product p);

	Product retrieveProduct(Long id);

}
