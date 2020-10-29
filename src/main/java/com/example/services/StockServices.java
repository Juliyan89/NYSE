package com.example.services;

import java.util.List;
import com.example.entities.Stock;


public interface StockServices {
	
	//CREATE
	public Stock createStock(Stock s);
	
	//READ
	public Stock getStockBySymbol(String symbol);
	//public Stock  getStockByName(String stock_name);
	public List<Stock> getAllStocks();
	
	//UPDATE
	public Stock updateStock(Stock s);
	
	//DELETE
	public boolean deleteStock(Stock s);

}
