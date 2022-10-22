package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements IStock{
	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stock = (List<Stock>) stockRepository.findAll();
		return stock;
	}

	@Override
	public Stock addStock(Stock s) {
		stockRepository.save(s);
		return s;
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);			
	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock stock = stockRepository.findById(id).orElse(null);
		return stock;	
	}

}
