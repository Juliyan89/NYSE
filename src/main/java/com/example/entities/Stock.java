package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
		
		@Column(name="stock_date")
		private String stock_date;

		@Id
		@Column(name = "symbol")
		private String symbol;
		@Column(name="stock_name")
		private String stock_name;
		@Column(name="current_price")
		private String current_price;	
		
		@Column(name="price_change")
		private String price_change;
		@Column(name="change_percent")
		private String change_percent;
		
		@Column(name="stock_open")
		private String stock_open;
		
		@Column(name="year_high")
		private String year_high;
		
		@Column(name="year_high_date")
		private String year_high_date;
		
		@Column(name="year_low")
		private double year_low;
		
		@Column(name="year_low_date")
		private String year_low_date;
		
		@Column(name="volume")
		private String volume;
		@Column(name="tradesize")
		private String tradesize;
		@Column(name="stock_exchange")
		private String stock_exchange;
		
			

		
		public Stock() {
			super();
			// TODO Auto-generated constructor stub
		}




		public Stock(String stock_date, String symbol, String stock_name, String current_price, String price_change,
				String change_percent, String stock_open, String year_high, String year_high_date, double year_low,
				String year_low_date, String volume, String tradesize, String stock_exchange) {
			super();
			this.stock_date = stock_date;
			this.symbol = symbol;
			this.stock_name = stock_name;
			this.current_price = current_price;
			this.price_change = price_change;
			this.change_percent = change_percent;
			this.stock_open = stock_open;
			this.year_high = year_high;
			this.year_high_date = year_high_date;
			this.year_low = year_low;
			this.year_low_date = year_low_date;
			this.volume = volume;
			this.tradesize = tradesize;
			this.stock_exchange = stock_exchange;
		}




		public String getStock_date() {
			return stock_date;
		}




		public void setStock_date(String stock_date) {
			this.stock_date = stock_date;
		}




		public String getSymbol() {
			return symbol;
		}




		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}




		public String getStock_name() {
			return stock_name;
		}




		public void setStock_name(String stock_name) {
			this.stock_name = stock_name;
		}




		public String getCurrent_price() {
			return current_price;
		}




		public void setCurrent_price(String current_price) {
			this.current_price = current_price;
		}




		public String getPrice_change() {
			return price_change;
		}




		public void setPrice_change(String price_change) {
			this.price_change = price_change;
		}




		public String getChange_percent() {
			return change_percent;
		}




		public void setChange_percent(String change_percent) {
			this.change_percent = change_percent;
		}




		public String getStock_open() {
			return stock_open;
		}




		public void setStock_open(String stock_open) {
			this.stock_open = stock_open;
		}




		public String getYear_high() {
			return year_high;
		}




		public void setYear_high(String year_high) {
			this.year_high = year_high;
		}




		public String getYear_high_date() {
			return year_high_date;
		}




		public void setYear_high_date(String year_high_date) {
			this.year_high_date = year_high_date;
		}




		public double getYear_low() {
			return year_low;
		}




		public void setYear_low(double year_low) {
			this.year_low = year_low;
		}




		public String getYear_low_date() {
			return year_low_date;
		}




		public void setYear_low_date(String year_low_date) {
			this.year_low_date = year_low_date;
		}




		public String getVolume() {
			return volume;
		}




		public void setVolume(String volume) {
			this.volume = volume;
		}




		public String getTradesize() {
			return tradesize;
		}




		public void setTradesize(String tradesize) {
			this.tradesize = tradesize;
		}




		public String getStock_exchange() {
			return stock_exchange;
		}




		public void setStock_exchange(String stock_exchange) {
			this.stock_exchange = stock_exchange;
		}




		@Override
		public String toString() {
			return "Stock [stock_date=" + stock_date + ", symbol=" + symbol + ", stock_name=" + stock_name
					+ ", current_price=" + current_price + ", price_change=" + price_change + ", change_percent="
					+ change_percent + ", stock_open=" + stock_open + ", year_high=" + year_high + ", year_high_date="
					+ year_high_date + ", year_low=" + year_low + ", year_low_date=" + year_low_date + ", volume="
					+ volume + ", tradesize=" + tradesize + ", stock_exchange=" + stock_exchange + "]";
		}




		
		
		
		

}
