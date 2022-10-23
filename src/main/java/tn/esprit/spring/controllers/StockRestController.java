package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Stock;

import tn.esprit.spring.services.IStock;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stock")

public class StockRestController {
	@Autowired
	IStock stockService;
	
	// http://localhost:8090/SpringMVC/stock/retrieve-all-stock
		@GetMapping("/retrieve-all-stock")
		@ResponseBody
		public List<Stock> getStock() {
		List<Stock> listStock = stockService.retrieveAllStocks();
		return listStock;
		}
		
		// http://localhost:8090/SpringMVC/stock/retrieve-stock/8
		@GetMapping("/retrieve-stock/{stock-id}")
		@ResponseBody
		public Stock retrieveStock(@PathVariable("stock-id") Long idStock) {
		return stockService.retrieveStock(idStock);
		}
		
		// http://localhost:8090/SpringMVC/stock/add-stock
		@PostMapping("/add-stock")
		@ResponseBody
		public Stock addStock(@RequestBody Stock s)
		{
			Stock stock = stockService.addStock(s);
		return stock;
		}
		
		// http://localhost:8090/SpringMVC/stock/remove-stock/{stock-id}
		@DeleteMapping("/remove-stock/{stock-id}")
		@ResponseBody
		public void removeStock(@PathVariable("stock-id") Long idStock) {
			stockService.deleteStock(idStock);
		}
		
		// http://localhost:8090/SpringMVC/stock/modify-stock
		@PutMapping("/modify-stock/{stock-id}")
		@ResponseBody
		public Stock modifyStock(@RequestBody Stock stock, @PathVariable("stock-id") Long idStock) {
			stock.setIdStock(idStock);
			return stockService.updateStock(stock);
		}
		
}
