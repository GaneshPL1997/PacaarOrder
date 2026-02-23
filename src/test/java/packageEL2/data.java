package packageEL2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.codegen.model.ExceptionClause;
import io.github.bonigarcia.wdm.WebDriverManager;

public class data {
	
	public static WebElement spinner;
   
	public static void main(String[] args) throws InterruptedException, Exception {
		 String chromeVersion = "125.0.6422.113"; // Your actual Chrome version
         WebDriverManager.chromedriver().browserVersion(chromeVersion).setup();
         
         int count=1;
			
         WebDriver driver = new ChromeDriver();
			driver.get("https://cleointegration.cloud/refTablesV2/CoverageAreaTables_Estes");
			driver.manage().window().maximize();
			
			WebElement findElement = driver.findElement(By.xpath("//input[@id='email']"));
			findElement.sendKeys("ganesh.palaniappan@estes-express.com");
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
			submit.click();
			Thread.sleep(3000);
			WebElement findElement2 = driver.findElement(By.xpath("//input[@id='password']"));
			findElement2.sendKeys("Srin@1439");
			Thread.sleep(2000);
			WebElement submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
			submit2.click();
			Thread.sleep(3000);
		     Actions actions=new Actions(driver);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Assuming the table is within a scrollable div with id 'refTable'
		        WebElement scrollableDiv = driver.findElement(By.xpath("//div[@id='refTable']"));
		    	Thread.sleep(3000);
		        boolean found=false;
		        int cutoff=2;
		        
		        
		        int rowCount=3;
		        WebElement first = driver.findElement(By.xpath("//div[@aria-rowindex='3']/descendant::div[@col-id='includeziplist']/descendant::span"));
		        first.click();
		        while(true) {
		        try {
		        	//Thread.sleep(1000);
		        	actions.keyDown(Keys.ARROW_DOWN).build().perform();
		        	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-rowindex='" + (rowCount++) + "']/descendant::div[@col-id='includeziplist']/descendant::span")));
		        	String data = driver.findElement(By.xpath("//div[@aria-rowindex='"+(rowCount++)+"']/descendant::div[@col-id='includeziplist']/descendant::span")).getText();
		            System.out.println(data);
		          //  Thread.sleep(1000);
		          //  actions.keyDown(Keys.ARROW_DOWN).build().perform();
		          //  Thread.sleep(1000);
		            try {
            			spinner = driver.findElement(By.xpath("//div[@id='refTable']/following-sibling::img[@data-qa='grid-spinner']"));
		                if(spinner.isDisplayed()) {
		                	Thread.sleep(3000);
		                }
            		}
        			catch(Exception e){
        			//	System.out.println("no spinner");
        			}
		        }
		        catch(Exception e) {
		        	break;
		        }}
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		    /*    
		        while(true) {
		
		        List<WebElement> table = driver.findElements(By.xpath("//div[@col-id='includeziplist']/div/span"));
	           
		       
		        outerloop:
		        for (int i = 0; i < table.size(); i++) {
	                System.out.println(table.get(i).getText());
	                if(i==table.size()-1) {
	                	WebElement last = table.get(i);
	                	last.click();
	                	innerloop:
	                			try {
	                			for(int l=0;l<=i;l++) {
	                			actions.keyDown(Keys.ARROW_DOWN).build().perform();
	                			try {
		                			spinner = driver.findElement(By.xpath("//div[@id='refTable']/following-sibling::img[@data-qa='grid-spinner']"));
		    		                if(spinner.isDisplayed()) {
		    		                	Thread.sleep(5000);
		    		                }
		    		                break outerloop;
		                		}
	                			catch(Exception e){
	                			//	System.out.println("no spinner");
	                			}
	                	//		driver.findElement(By.xpath("(//div[@col-id='includeziplist']/div/span[@role='gridcell'])[1]"))
	                			if(l==i) {
	                				break;
	                			}
	                			}
	                			}
	                			catch(StaleElementReferenceException st) {
	                				break outerloop;
	                			}
	                		}
	                	}
	                }
	            
	         //   table.get(cutoff).click();
	            
	          
	            /*
	            while(!found) {
	            	try {
	            		WebElement spinner = driver.findElement(By.xpath("//div[@id='refTable']/following-sibling::img[@data-qa='grid-spinner']"));
		                if (spinner.isDisplayed()) {
		                    wait.until(ExpectedConditions.invisibilityOf(spinner));
		                    found=true;
		                }
	            	}
	            	catch(Exception efg) {
	            		try {
	            			Thread.sleep(2000);
	            	    table.get(cutoff++).click();	
	            		table.get(cutoff++).sendKeys(Keys.ARROW_DOWN);
	            		Thread.sleep(2000);
	            		}
	            		catch(Exception fsada) {
	            			Thread.sleep(2000);
	            			table.get(cutoff++).click();
	            			table.get(cutoff++).sendKeys(Keys.ARROW_DOWN);
	            			Thread.sleep(2000);
	            		}
	            	}
	            }
	            */
	            
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        }}


                 


































		        
		    
		        
	/*	        
		        int previousTableSize = 0;
		        driver.findElement(By.xpath("//div[@col-id='includeziplist']/div/span[contains(text(),'17055')]")).click();
		        Thread.sleep(2000);
		        boolean found=false;
		        while (!false) {
		            List<WebElement> table = driver.findElements(By.xpath("//div[@col-id='includeziplist']/div/span"));
		            
		            for (int i = previousTableSize; i < table.size(); i++) {
		                System.out.println(table.get(i).getText());
		            }
		            previousTableSize = table.size();
                    driver.findElement(By.xpath("(//div[@col-id='includeziplist'])["+(count++)+"]")).click();
                    while(true) {
		            try {
		                WebElement spinner = driver.findElement(By.xpath("//div[@id='refTable']/following-sibling::img[@data-qa='grid-spinner']"));
		                if (spinner.isDisplayed()) {
		                    wait.until(ExpectedConditions.invisibilityOf(spinner));
		                    break;
		                }
		            } catch (Exception e) {
		            	try {
		            	driver.findElement(By.xpath("(//div[@col-id='includeziplist'])["+(count++)+"]")).sendKeys(Keys.ARROW_DOWN);
		            	}
		            	catch(Exception gh) {
		            		driver.findElement(By.xpath("(//div[@col-id='includeziplist'])["+(count++)+"]")).sendKeys(Keys.ARROW_DOWN);
		            	}
		            }
                    }

		            // Scroll down the specific div containing the table
//		            js.executeScript("arguments[0].scrollBy(0, arguments[0].scrollHeight)", scrollableDiv);
//		            ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
//		            Thread.sleep(2000);
//		            
//		            Robot robot = new Robot();
//		            robot.keyPress(KeyEvent.VK_CONTROL);
//		            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		            robot.keyRelease(KeyEvent.VK_CONTROL);
//		            int currentTableSize = driver.findElements(By.xpath("//div[@col-id='coverageareaname']/div/span")).size();
//		            if (previousTableSize == currentTableSize) {
//		                break; // Exit loop if no more new elements are loaded
//		            }
		        }
*/
	