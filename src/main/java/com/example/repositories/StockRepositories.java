package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Stock;



public interface StockRepositories extends JpaRepository<Stock,String>{
	
	Stock findBySymbol(String symbol);
	
//	Stock findBystock_name(String stock_name);

}
