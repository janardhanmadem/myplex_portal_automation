package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class keywords {
	
	//private static final String pass = null;
	public static WebDriver driver=null;
	public  keywords key=null;
	public static Properties prop=null;
	//key=new keywords();
	public static Logger logs=null;
	public  static final String Pass="pass";
	public  static final String fail="fail";
	public static String result=null;
	public keywords() throws Throwable{
		prop=new Properties();
		FileInputStream fp=new FileInputStream("G:\\workspace\\myplex_portal\\src\\com\\properties\\or.properties");
		prop.load(fp);
		
	}
	public void browser(String browser_name){
		if(browser_name.equalsIgnoreCase("firefox")){
			FirefoxProfile pro=new FirefoxProfile();
			pro.setEnableNativeEvents(true);
			driver = new FirefoxDriver(pro);
			//System.out.println("Testing in :"+browser_name);
			logs("Testing in :"+browser_name);
		}
		else if(browser_name.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\chromedriver.exe");
			driver=new ChromeDriver();
			//System.out.println("Testing in :"+browser_name);
			logs("Testing in :"+browser_name);
		}
	}
	public void open_browser(String url){
		driver.navigate().to(url);
		//System.out.println("Browser is open");
		logs("Browser is open");
	}
	public String get_window_title(){
		return driver.getTitle();
	}
	
	
	
	
	
	public void send_text(String xpath,String value){
		
		driver.findElement(By.xpath(prop.getProperty(xpath))).sendKeys(value);
		
	}
public void send_text_css(String css,String value){
		driver.findElement(By.cssSelector(prop.getProperty(css))).clear();
		driver.findElement(By.cssSelector(prop.getProperty(css))).sendKeys(value);
		driver.findElement(By.cssSelector(prop.getProperty(css))).sendKeys(Keys.ENTER);
		
	}
	
	
	public void click_xpath(String xpath){
		driver.findElement(By.xpath(prop.getProperty(xpath))).click();
	}
	
	public void click_xpath_dynamic(String xpath_1,String xpath_2,int i){
		driver.findElement(By.xpath(prop.getProperty(xpath_1)+i+prop.getProperty(xpath_2))).click();
	}
	
	public void click_css(String css){
		driver.findElement(By.cssSelector(prop.getProperty(css))).click();
	}
	/*public void java_script_click(String id_name){
		((JavaScriptExecutor)driver).executescript("document.getelementbyid('sharebtn').click()");
	}*/
	public void close_browser(){
		driver.close();
	}
	public void quit_all_browsers(){
		driver.quit();
	}
	
	public void implicit_wait(int value){
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	}
    public void window_maxmise(){
    	driver.manage().window().maximize();
    }
    
    public void sleep(long value) throws Throwable{
    	Thread.sleep(value);
    }
    
    public void keyboard_enter(String xpath){
    	driver.findElement(By.xpath(prop.getProperty(xpath))).sendKeys(Keys.ENTER);
    }
    
    public void keyboard_enter_css(String css){
    	driver.findElement(By.cssSelector(prop.getProperty(css))).sendKeys(Keys.ENTER);
    }
    
    
    
    public void explicit_wait(int value,String xpath){
    	WebDriverWait wait=new WebDriverWait(driver,value);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
    public String get_text_xpath(String xpath){
    	return driver.findElement(By.xpath(prop.getProperty(xpath))).getText();
    }
    public String get_text_dynamic_xpath(String xpath_1,String xpath_2,int i){
    	return driver.findElement(By.xpath((prop.getProperty(xpath_1)+i+(prop.getProperty(xpath_2))))).getText();
    }
    
    
    
    
    public String get_text_css(String css){
    	return driver.findElement(By.cssSelector(prop.getProperty(css))).getText();
    }
    public void logs(String value){
    	logs=Logger.getLogger("devpinoyLogger");
    	logs.debug(value);
    	
    }
    public void test_status(boolean d){
    	if(d==true){
    	      result=Pass;
    	
    	}else{
    		result=fail;
    	}
    	logs.debug("Test result is :"+result );
    }
    
    public void getscreenshot(String data) throws Throwable{
    	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(srcfile,new File("G://workspace//myplex_portal//src//com//screenshots//"+data+".png"));
    }
    
    public int find_elements_count(String xpath){
    	int count=0;
    	count=driver.findElements(By.xpath(prop.getProperty(xpath))).size();
    	return count;
    }
    
    public int find_elements_count_dynamic(String xpath_1,String xpath_2,int i){
    	int count=0;
    	count=driver.findElements(By.xpath(prop.getProperty(xpath_1)+i+prop.getProperty(xpath_2))).size();
    	return count;
    }
    public String jquery_element_click_dropdown(String rootnode_xpath,String element_xpath_1,String element_xpath_2,int i) throws Throwable{
  	 
    	WebElement rootnode=driver.findElement(By.xpath(prop.getProperty(rootnode_xpath)));
  	  Actions act=new Actions(driver);
  	  act.moveToElement(rootnode).build().perform();
  	  Thread.sleep(1000L);
  	  // driver.findElement(By.xpath(prop.getProperty(element_xpath_1)+i+prop.getProperty(element_xpath_2))).click();
  	    
  	String s=driver.findElement(By.xpath(prop.getProperty(element_xpath_1)+i+prop.getProperty(element_xpath_2))).getText();
  	driver.findElement(By.xpath(prop.getProperty(element_xpath_1)+i+prop.getProperty(element_xpath_2))).click();
  	   
  	  return s;
    }
    public void javascript_click(String id){
    	((JavascriptExecutor)driver).executeScript("document.getElementById('"+prop.getProperty(id)+"').click()");
    }
    public void invisibility_elements(String xpath){
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
   
   public void switch_next_window(){
	   Set<String> winids=driver.getWindowHandles();
	   Iterator<String> itr=winids.iterator();
	   String main_window=itr.next();
	   String second_window=itr.next();
	   driver.switchTo().window(second_window);
	   
   }
   public void switch_previous_window(){
	   Set<String> winids=driver.getWindowHandles();
	   Iterator<String> itr=winids.iterator();
	   String main_window=itr.next();
	   String second_window=itr.next();
	   driver.switchTo().window(main_window);
	   
   }
   public void point_click(String root_xpath,String node_xpath){
	   WebElement rootnode=driver.findElement(By.xpath(prop.getProperty(root_xpath)));
	   Actions act=new Actions(driver);
	 //  int x=rootnode.getLocation().x;
	  // int y=rootnode.getLocation().y;
	   driver.findElement(By.xpath(prop.getProperty(root_xpath))).click();
	   act.moveToElement(rootnode).build().perform();
	   driver.findElement(By.xpath(prop.getProperty(node_xpath))).click();
   }
   public void player(String id) throws Throwable{
	   FlexWebDriver flashapp=new FlexWebDriver(driver,id);
	   sleep(3000L);
	   flashapp.call("stop");
	   flashapp.call("resume");
	   flashapp.call("seeTo", "100","true");
	   flashapp.call("play");
	   sleep(2000L);
	   flashapp.call("stop");
	   
	   
   }
   
}
