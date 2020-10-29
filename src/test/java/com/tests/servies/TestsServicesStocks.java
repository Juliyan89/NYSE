package com.tests.servies;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Stock;
import com.example.services.StockServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


@SpringBootTest
@ContextConfiguration(classes=com.example.app.App.class)
public class TestsServicesStocks {
	
	@Autowired
	StockServices ss;
	
	@Autowired
	Gson gson;

//	@Test
//	@Order(1)
//	public void createStock() {
//		Stock s = new Stock();
//		s.setSymbol("AAA");
//		s.setName("AAAAGILENT TECHNOLOGIES");
//		s.setCurrentPrice(106.515);
//		s.setYearlow(61.13);
//		s.setYearhigh(107.62);
//		Stock stockystok = ss.createStock(s);
//		System.out.println(stockystok);
//	}
	
//	@Test
//	@Order(2)
//	void getStockByID() {
//		Stock s = ss.getStockBySymbol("A");
//		System.out.println(s);
//	}
//	
//	@Test
//	@Order(3)
//	void getStockAllStocks() {
//		List<Stock> s = ss.getAllStocks();
//		for(Stock stock : s) {
//		System.out.println(stock);
//		}
//	}
	
//	@Test
//	@Order(1)
//	public void createListOfStocks() throws IOException {
//		List<Stock> stocks = new ArrayList<Stock>(); 
//		//stocks = gson.fromJson(new FileReader("C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt"), List.class);
//		
//		try (Reader reader = new FileReader("C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt")) {
//
//            // Convert JSON File to Java Object
//            stocks.add(gson.fromJson(reader, Stock.class));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		
//        for(Stock st : stocks) {
//        	System.out.println(st);
//        }
//	
//		
//		
//		 String fileName = "C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt";
//	        
//	        BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
//	        StringBuilder sb = new StringBuilder();
//	    	String line = null;
//			String ls = System.getProperty("line.separator");
//			System.getProperty("tab");
//	         
//	        try {
//	            while ((line = br.readLine()) != null) {
//	            	stocks.add(gson.fromJson(new FileReader("C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt"), Stock.class));
//	        		sb.append(line);
//	        		//System.out.println(line);
//	        		
//	    			sb.append(ls);   
//	            }
//	        }
//	        finally {
//	            br.close();
//	        }
//	        
//	        String rawString = sb.toString();
//	        ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString); 
//	         
//	        String message = StandardCharsets.UTF_8.decode(buffer).toString();
//	       // System.out.println(message);
//	        
//
//		
//	
//	}
	
	@Test
	@Order(4)
	void getAllStocksFromJSON() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
        
        
        String fileName = "C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
    	String line = null;
		String ls = System.getProperty("line.separator");
		System.getProperty("tab");
         
        try {
            while ((line = br.readLine()) != null) {
            	sb.append(line);
    			sb.append(ls);   
            }
        }
        finally {
            br.close();
        }
        
        String json = sb.toString();
        

        try {

//            // 1. convert JSON array to Array objects
//            Stock[] pp1 = mapper.readValue(json, Stock[].class);
//
//            System.out.println("JSON array to Array objects...");
//            for (Stock stock : pp1) {
//                System.out.println(stock);
//            }

            // 2. convert JSON array to List of objects
            List<Stock> stocks = Arrays.asList(mapper.readValue(json, Stock[].class));

		     for (Stock stock : stocks) {
		          System.out.println(stock);
		          ss.createStock(stock);
		      }

//            // 3. alternative
//            List<Stock> pp3 = mapper.readValue(json, new TypeReference<List<Stock>>() {});
//
//            System.out.println("\nAlternative...");
//            pp3.stream().forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	


}
