package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Stock;
import com.example.services.StockServices;


@Component
@CrossOrigin("*")
@RestController
public class StockController {
	
	@Autowired
	StockServices ss;
	
	@PostMapping(value = "/stocks")
	public Stock createStock(@RequestBody Stock s) {
		return this.ss.createStock(s);
	}
	
	@GetMapping(value = "/stocks/{symbol}")
	public Stock getStockBySymbol(@PathVariable String symbol) {
		return this.ss.getStockBySymbol(symbol);
	}
	
	@GetMapping(value = "/stocks")
	public List<Stock> getAllSymbol() {
		return this.ss.getAllStocks();
	}
	
	@PutMapping(value = "/stocks")
	public Stock updateStock(@RequestBody Stock stock) {
		return this.ss.updateStock(stock);
	}
	

}
