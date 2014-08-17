package com.test.signup_flows;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;

public class myplex_signup_testcase {
	@BeforeTest
	public void beforetest(){
		System.out.println("########################################################");
		System.out.println("************* Myplex signup Login Test *****************");
		System.out.println("########################################################");
	}
	
	public WebDriver driver=null;
	public static keywords key=null;
	@Test(dataProvider="registerdata")
	public void facebook_login(String datavalidation,String username,String password,String cellnumber,String browser_name ) throws Throwable{
		
		try{
		Properties prop=new Properties();
		FileInputStream fp=new FileInputStream("G:\\workspace\\myplex_portal\\src\\com\\properties\\or.properties");
		prop.load(fp);
		key=new keywords();
		key.browser(browser_name);
		/*if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "G:\\workspace\\myplex_portal\\src\\chromedriver.exe");
			driver=new ChromeDriver();
		}else{
			System.out.println("you entered wrong browser name");
		}*/
		System.out.println("Testing in Browser :"+browser_name);
		key.implicit_wait(20);
		key.window_maxmise();
		key.open_browser("http:\\www.myplex.com");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.get("http:\\www.myplex.com");
		System.out.println("Browser is open");
		//System.out.println(driver.getTitle());
		//if(driver.getTitle().equals("Watch Movies Online, Watch TV Shows Seasons Online | Myplex.com"))
			if(key.get_window_title().equals("Watch Movies Online, Watch TV Shows Seasons Online | Myplex.com"))
		{
		//Sign Up  Test
		key.click_xpath("signup_xpath");
		key.click_xpath("signup_xpath");
		//driver.findElement(By.xpath(prop.getProperty("signup_xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("signup_xpath"))).click();
		if(username!=null){
		//driver.findElement(By.xpath(prop.getProperty("signup_username_xpath"))).sendKeys(username);
		key.send_text("signup_username_xpath", username);
		}else{
			System.out.println("user name is not there");
		}
		if(password!=null){
		//driver.findElement(By.xpath(prop.getProperty("signup_password_xpath"))).sendKeys(password);
		key.send_text("signup_password_xpath", password);
		}else{
			System.out.println("password is not there");
		}
		if(cellnumber!=null){
		//driver.findElement(By.xpath(prop.getProperty("signup_misdn_xpath"))).sendKeys(cellnumber);
		key.send_text("signup_misdn_xpath", cellnumber);
		}else{
			System.out.println("cellnumber is not there");
		}
		key.click_xpath("signup_submit_xpath");
		//driver.findElement(By.xpath(prop.getProperty("signup_submit_xpath"))).click();
		if(datavalidation.equals("valid_data_new_data")){
			System.out.println("Testing with Valid Data");
			key.sleep(4000L);
			//Thread.sleep(4000L);
		//String profile=driver.findElement(By.xpath(prop.getProperty("profile_xpath"))).getText();
		String profile=key.get_text_xpath("profile_xpath");
		if(profile.equalsIgnoreCase("profile")){
			System.out.println("Login is success");
			key.click_xpath("profile_xpath");
			//driver.findElement(By.xpath(prop.getProperty("profile_xpath"))).click();
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			System.out.println("cell number is :"+cellnumber);
			//String email=driver.findElement(By.xpath(prop.getProperty("validate_username_xpath"))).getText();
			String email=key.get_text_xpath("validate_username_xpath");
			if(email.equals(username)){
				System.out.println("Login success and correct user is logged in");
				System.out.println("Valid Data Test Pass");
			}else{
				System.out.println("Login success wrong user logged in");
				System.out.println(" Valid Data Test Failed");
				key.getscreenshot(datavalidation);
			}
			//driver.findElement(By.xpath(prop.getProperty("logout_xpath"))).click();
		
			key.click_xpath("logout_xpath");
			key.sleep(2000L);
			//Thread.sleep(2000L);
			
		}else{
			System.out.println("Valid Test Data Failed");
              key.getscreenshot(datavalidation);
		}
		}else if(datavalidation.equalsIgnoreCase("valid_data_exists_email")){
			//String x=driver.findElement(By.cssSelector(prop.getProperty("invalid_signup_css"))).getText();
			String x=key.get_text_css("invalid_signup_css");
			System.out.println("Testing with already exisited email id");
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			System.out.println("cell number is :"+cellnumber);
			System.out.println("tested condition is :"+x);
			if(x.equalsIgnoreCase("User with email "+username+" exists")){
				System.out.println("user entered already exists email id");
				System.out.println("user unable to sign up");
				System.out.println(" Valid Data Test Pass");
			
		}else{
			System.out.println("Valid Data Test Failed");
			key.getscreenshot(datavalidation);
		}
			}else if(datavalidation.equalsIgnoreCase("valid_data_exists_cellnumber")){
				//String n=driver.findElement(By.cssSelector(prop.getProperty("invalid_signup_css"))).getText();
				String n=key.get_text_css("invalid_signup_css");
				System.out.println("Testing with already existed number");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				System.out.println("cell number is :"+cellnumber);
				System.out.println("tested condition is :"+n);
				if(n.equalsIgnoreCase("User with mobile "+cellnumber+" exists")){
					System.out.println("user entered already exists cell number");
					System.out.println("user unable to sign up");
				    System.out.println("Valid data Test Pass");	
			}else{
				System.out.println("Valid data Test Failed");
				key.getscreenshot(datavalidation);
			}
				}else if(datavalidation.equalsIgnoreCase("invalid_email")){
			
				//String y=driver.findElement(By.cssSelector(prop.getProperty("invalid_signup_css"))).getText();
				String y=key.get_text_css("invalid_signup_css");
				System.out.println("Testing Invalid email case");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				System.out.println("cell number is :"+cellnumber);
				System.out.println("tested condition is :"+y);
				if(y.equals("* Invalid email address")){
					System.out.println("user entered invalid email id");
					System.out.println("user unable to sign up");
					System.out.println("Invalid Data Test Pass");
				}else if(y.equals("* This field is required"+"\n"+"* Invalid email address")){
				        System.out.println("user not entered email id");
						System.out.println("user unable to sign up");
						System.out.println("Invalid Data Test Pass");
				}else{
					System.out.println("Invalid Data Test Failed");
					key.getscreenshot(datavalidation);
				}
			}else if(datavalidation.equalsIgnoreCase("invalid_password")){
				
				//String z=driver.findElement(By.cssSelector(prop.getProperty("invalid_signup_css"))).getText();
				String z=key.get_text_css("invalid_signup_css");
				System.out.println("Testing Invalid password case");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				System.out.println("cell number is :"+cellnumber);
				System.out.println("tested condition is :"+z);
				if(z.equalsIgnoreCase("* This field is required")){
					System.out.println("user entered invalid password");
					System.out.println("user unable to sign up");
					System.out.println("Invalid Data Test Pass");
				}else{
					System.out.println("Invalid Data Test Failed");
					key.getscreenshot(datavalidation);
				}
			}else if(datavalidation.equalsIgnoreCase("invalid_mobilenumber")){
				//String m=driver.findElement(By.cssSelector(prop.getProperty("invalid_signup_css"))).getText();
				String m=key.get_text_css("invalid_signup_css");
				System.out.println("Testing invalid mobile number case");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				System.out.println("cell number is :"+cellnumber);
				System.out.println("tested condition is :"+m);
				if(m.equals("* Invalid mobile")){
					System.out.println("user entered invalid mobile number");
					System.out.println("user unable to sign up");
					System.out.println("Invalid Data Test Pass");
			}else{
				System.out.println("Invalid Data Test Failed");
				key.getscreenshot(datavalidation);
			}
				}
		}else{
			System.out.println("Internet connection is not active");
		}
		}catch(Exception e){
	System.out.println("error :"+e.getMessage());
	e.printStackTrace();
	key.getscreenshot(datavalidation);
}
//driver.quit();
key.quit_all_browsers();
System.out.println("************************************");
	}
	@DataProvider
	public Object[][] registerdata(){
		Object[][] data=new Object[8][5];
		//Random randomGenerator = new Random();
		
	//1st set of data
	    data[0][0]="valid_data_new_data";
		data[0][1]=Math.random()+"@gmail.com";
		data[0][2]="janardhan123";
		data[0][3]=String.valueOf((long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
		data[0][4]="chrome";
	//2nd set of data	
	     data[1][0]="valid_data_new_data";
	     data[1][1]=Math.random()+"@gmail.com";
		 data[1][2]="janardhan123";
		 data[1][4]="chrome";
	//3rd set of data		
	    data[2][0]="valid_data_exists_cellnumber";
		data[2][1]="mademvv98783se534@gmail.com";
		data[2][2]="janardhan123";
		data[2][3]="8179653520";
		data[2][4]="chrome";
    //4th set of data	
	    data[3][0]="valid_data_exists_email";
		data[3][1]="mademvv@gmail.com";
		data[3][2]="janardhan123";
		data[3][3]="8170053000";
		data[3][4]="chrome";
	//5th set of data
	    data[4][0]="invalid_email";
		data[4][1]="gytr";
		data[4][2]="apalya";
		data[4][3]="8100653520";
		data[4][4]="chrome";
	//6th set of data	
	    data[5][0]="invalid_email";
		data[5][2]="apalya";
		data[5][3]="8100653520";
		data[5][4]="chrome";
	//7th set of data	
		data[6][0]="invalid_password";
		data[6][1]="made@gmail.com";
		data[6][3]="8100053520";
		data[6][4]="chrome";
	//8th set of data
		data[7][0]="invalid_mobilenumber";
		data[7][1]="made1@gmail.com";
		data[7][2]="xyz897";
		data[7][3]="81796535vhvhhhc";
		data[7][4]="chrome";
		
		return data;
		
	}
	}
