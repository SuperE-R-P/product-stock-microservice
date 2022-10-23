package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.StockRepository;

@Service

public class ProductServiceImpl implements IProduct{
	@Autowired
	ProductRepository productRepository;
	@Autowired 
	StockRepository stockRepository;
	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public Product addProduct(Product p, Long idStock) {
		Stock stock = stockRepository.findById(idStock).orElse(null);
		p.setStock(stock);
		productRepository.save(p);
		return p;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);	
		
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product retrieveProduct(Long id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;	
	}
	
	
	
}
