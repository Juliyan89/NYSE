package com.example.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Stock;
import com.example.services.StockServices;

@SpringBootTest
@ContextConfiguration(classes=com.example.app.App.class)
public class Runner {
	
	public static WebDriver driver;
	
	@Autowired
	StockServices ss;
	
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void getAllStocks() throws InterruptedException, AWTException, IOException {
		Thread.sleep(100);
		driver.get("https://www.nyse.com/listings_directory/stock");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Listings Directory for NYSE Stocks"));
		Thread.sleep(100);
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>NYSE</title>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		sb.append("<style>" +
				"table { font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif; border-collapse: collapse; width: 100%; background-color: grey;}" +
				"table td, table th { border: 1px solid; padding: 8px;}" +
				"table tr:nth-child(even){background-color: #f2f2f2;}" +
				"table tr:hover {background-color: #ddd;}" +
				"table th { padding-top: 12px; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;}" +
				"</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<table>");
		sb.append("<th>Date</th>");
		sb.append("<th> Symbol </th>");
		sb.append("<th> Name </th>");
		sb.append("<th> Current Price </th>");
		sb.append("<th> change </th>");
		sb.append("<th> % change </th>");
		sb.append("<th> open </th>");
		sb.append("<th> 52 high</th>");
		sb.append("<th> 52highdate </th>");
		sb.append("<th> 52 low </th>");
		sb.append("<th> 52lowdate </th>");
		sb.append("<th> volume </th>");
		sb.append("<th> tradesize </th>");
		sb.append("<th> exchange </th>");
		
		StringBuffer json = new StringBuffer();
		

		
//		Thread.sleep(100);
//		Robot r = new Robot();                          
//		r.keyPress(KeyEvent.VK_CONTROL); 
//		r.keyPress(KeyEvent.VK_T); 
//		r.keyRelease(KeyEvent.VK_CONTROL); 
//		r.keyRelease(KeyEvent.VK_T);    
//		//To switch to the new tab
//		Thread.sleep(100);
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		Thread.sleep(100);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		//List<Stock> listOfStocks = new ArrayList<Stock>();

		json.append("[");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);  
		
		for(int x = 2; x<4; x++) {
		for(int i =1; i<11; i++) {
			
			json.append("{");
			Thread.sleep(200);
			WebElement myelement = driver.findElement(By.xpath("//*[@id=\"content-aa395ece-e341-4621-9695-3642148ea198\"]/div/div[2]/div[1]/table/tbody/tr["+i+"]/td[1]/a"));
		
			jse2.executeScript("arguments[0].scrollIntoView()", myelement);
			Thread.sleep(100);
			//wait.until(ExpectedConditions.elementToBeClickable(myelement));
			
			Thread.sleep(100);
	                        
  
			//To switch to the new tab
			Thread.sleep(100);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			
			String url = myelement.getAttribute("href");
			driver.switchTo().window(tabs.get(1)).get(url);
		
			
			sb.append("<tr>");
			
			sb.append("<td>");
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");  
			  LocalDateTime now = LocalDateTime.now();  
			  String date = dtf.format(now).toString();
			sb.append(date);
			json.append("\"stock_date\": \"");
			json.append(date);
			json.append("\",");
			sb.append("</td>");
			
			
			Thread.sleep(100);
			sb.append("<td>");
			String td1 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/header/h1/span")).getText();
			sb.append(td1);
			
			json.append("\"symbol\": \"");
			json.append(td1);
			json.append("\",");
			
			sb.append("</td>");
			//System.out.println(td1);
			
			Thread.sleep(100);
			sb.append("<td>");                         
			String td2 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[1]/span[1]")).getAttribute("innerText");	
			sb.append(td2);
			
			json.append("\"stock_name\": \"");
			json.append(td2);
			json.append("\",");
			
			sb.append("</td>");
			//System.out.println(td2);
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content-aa395ece-e341-4621-9695-3642148ea198\"]/div/div[2]/div[1]/table/tbody/tr["+i+"]/td[1]/a")));
//			driver.findElement(By.xpath("//*[@id=\"content-aa395ece-e341-4621-9695-3642148ea198\"]/div/div[2]/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
//			Thread.sleep(1000);
			//driver.switchTo().window(tabs.get(1));
			//To navigate to new link/URL in 2nd new tab
			
			//driver.get("https://www.nyse.com/quote/XNYS:"+td1);
		
			sb.append("<td>");
			String td3 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/span[2]")).getText();	
			sb.append(td3);
			
			json.append("\"current_price\": \"");
			json.append(td3);
			json.append("\",");
			
			sb.append("</td>");
			//System.out.println(td3);
			
			Thread.sleep(100);
			sb.append("<td>");
			String td6 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/span[2]")).getText();	
			sb.append(td6);
			json.append("\"price_change\": \"");
			json.append(td6);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td7 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/span[2]")).getText();	
			sb.append(td7);
			json.append("\"change_percent\": \"");
			json.append(td7);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td13 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[9]/span[2]")).getText();	
			sb.append(td13);
			json.append("\"stock_open\": \"");
			json.append(td13);
			json.append("\",");
			sb.append("</td>");
			

			//System.out.println(td4);
			
			Thread.sleep(100);
			sb.append("<td>");
			String td5 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[12]/span[2]")).getText();	
			sb.append(td5);
			
			json.append("\"year_high\": \"");
			json.append(td5);
			json.append("\",");
			
			sb.append("</td>");
			//System.out.println(td5);
			
			Thread.sleep(100);
			sb.append("<td>");
			String td10 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[13]/span[2]")).getText();	
			sb.append(td10);
			json.append("\"year_high_date\": \"");
			json.append(td10);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td4 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[14]/span[2]")).getText();	
			sb.append(td4);
			json.append("\"year_low\": \"");
			json.append(td4);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td11 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[15]/span[2]")).getText();	
			sb.append(td11);
			json.append("\"year_low_date\": \"");
			json.append(td11);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td8 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[4]/span[2]")).getText();	
			sb.append(td8);
			json.append("\"volume\": \"");
			json.append(td8);
			json.append("\",");
			sb.append("</td>");
			
			Thread.sleep(100);
			sb.append("<td>");
			String td9 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[5]/span[2]")).getText();	
			sb.append(td9);
			json.append("\"tradesize\": \"");
			json.append(td9);
			json.append("\",");
			sb.append("</td>");
			
			
			Thread.sleep(100);
			sb.append("<td>");
			String td12 = driver.findElement(By.xpath("//*[@id=\"content-9d1f8b01-08a6-4db5-99fa-c40f5873615a\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[17]/span[2]")).getText();	
			sb.append(td12);
			json.append("\"stock_exchange\": \"");
			json.append(td12);
			json.append("\"");
			sb.append("</td>");
			

			
			//driver.switchTo().window(tabs.get(0));
			driver.navigate().back();
			sb.append("</tr>");
						
			Thread.sleep(100);
			
			//listOfStocks.add(new Stock(td1, td2, Double.parseDouble(td3), Double.parseDouble(td4), Double.parseDouble(td5)));
			json.append("},");
			
			driver.switchTo().window(tabs.get(0));
			
		}
		Thread.sleep(100);		  
		List<WebElement> pages = driver.findElements(By.xpath("//*[@id=\"content-aa395ece-e341-4621-9695-3642148ea198\"]/div/div[2]/div[2]/div/ul/li[*]/a[text()="+x+"]"));

		if(pages.size()>0) {
			jse2.executeScript("arguments[0].scrollIntoView()", pages.get(0));
			pages.get(0).click();
			
		}else {
		
			break;			
			
		}
	


		}
		
//		for(Stock st : listOfStocks) {
//			ss.createStock(st);
//			System.out.println(st);
//		}
		json.deleteCharAt( json.length() - 1 );
		json.append("]");
		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("C:\\Users\\juliy\\Desktop\\Projects\\nyse.html"), StandardCharsets.UTF_8));
		
	    String rawString = sb.toString();
	    ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString); 
	     
	    String text = StandardCharsets.UTF_8.decode(buffer).toString();
		
		
		 //write contents of StringBuffer to a file
		 bwr.write(text);
		 
		 //flush the stream
		 bwr.flush();
		 
		 //close the stream
		 bwr.close();
		 
			BufferedWriter bwr1 = new BufferedWriter(new FileWriter(new File("C:\\Users\\juliy\\Desktop\\Projects\\nyse.txt"), StandardCharsets.UTF_8));
			
		    String rawString1 = json.toString();
		    ByteBuffer buffer1 = StandardCharsets.UTF_8.encode(rawString1); 
		     
		    String text1 = StandardCharsets.UTF_8.decode(buffer1).toString();
			
			
			 //write contents of StringBuffer to a file
			 bwr1.write(text1);
			 
			 //flush the stream
			 bwr1.flush();
			 
			 //close the stream
			 bwr1.close();
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
