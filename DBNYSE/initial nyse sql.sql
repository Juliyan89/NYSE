CREATE TABLE stock (
	stock_date VARCHAR(200),
	symbol VARCHAR(200) NOT NULL,
	stock_name VARCHAR(200) NOT NULL,
	current_price VARCHAR(200),
	price_change VARCHAR(200),
	change_percent VARCHAR(200),
	stock_open VARCHAR(200),
	year_high VARCHAR(200), 
	year_high_date VARCHAR(200), 
	year_low VARCHAR(200),
   year_low_date VARCHAR(200),
   volume VARCHAR(200),
   tradesize VARCHAR(200),
   stock_exchange VARCHAR(200),
	PRIMARY KEY (symbol)
)

INSERT INTO stock(symbol,name,currentprice,yearlow,yearhigh) VALUES ("ABC","ABC Company", 50, 100, 250);
INSERT INTO stock(symbol,name,currentprice,yearlow,yearhigh) VALUES ("DNC","DNC Company", 60, 130, 365);
INSERT INTO stock(symbol,name,currentprice,yearlow,yearhigh) VALUES ("TNT","TNT Company", 70, 360, 450);
INSERT INTO stock(symbol,name,currentprice,yearlow,yearhigh) VALUES ("POL","POL Company", 80, 450, 630);

DROP TABLE stock

