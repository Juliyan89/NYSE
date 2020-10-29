package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.Stock;
import com.example.repositories.StockRepositories;

@Component
@Service
public class StockServicesImpl implements StockServices {
	
	@Autowired
	StockRepositories sr;

	@Override
	public Stock createStock(Stock s) {
		return sr.save(s);
	}

	@Override
	public Stock getStockBySymbol(String symbol) {
		return sr.findBySymbol(symbol);
	}

//	@Override
//	public Stock getStockByName(String stock_name) {
//		return sr.findBystock_name(stock_name);
//	}

	@Override
	public List<Stock> getAllStocks() {
		return sr.findAll();
	}

	@Override
	public Stock updateStock(Stock s) {
		return sr.save(s);
	}

	@Override
	public boolean deleteStock(Stock s) {
		sr.delete(s);
		return true;
	}

}
