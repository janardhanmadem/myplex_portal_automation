package com.test.login_flows;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;

public class myplex_login_flow_testcase {
	@BeforeTest
	public void beforetest(){
		System.out.println("#################################################");
		System.out.println("************* Myplex Login Test *****************");
		System.out.println("#################################################");
	}
	public   static WebDriver driver=null;
	public static keywords key=null;
	@Test(dataProvider="registerdata")
	public void login(String datavalidation,String username,String password,String browser_name) throws Throwable{
		try{
			key=new keywords();
		key.browser(browser_name);
		System.out.println("Testing in Browser :"+browser_name);
		key.implicit_wait(20);
		key.window_maxmise();
		key.open_browser("http:\\www.myplex.com");
		System.out.println("Browser is open");
			if(key.get_window_title().equals("Watch Movies Online, Watch TV Shows Seasons Online | Myplex.com"))
		{
		
		//login Test
	    key.click_xpath("login_link_xpath");
	    key.click_xpath("login_link_xpath");
	    key.send_text("username_xpath", username);
	    key.send_text("password_xpath", password);
	    key.click_xpath("submitbutton_xpath");
		
		if(datavalidation.equalsIgnoreCase("valid_data")){
			System.out.println("Testing with Valid Data");
		
		String profile=key.get_text_xpath("profile_xpath");
		if(profile.equalsIgnoreCase("profile")){
			System.out.println("Login is success");
		
			key.click_xpath("profile_xpath");
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			
			String email=key.get_text_xpath("validate_username_xpath");
			if(email.equals("mademvv@gmail.com")){
				System.out.println("Login success and correct user is logged in");
			}else{
				System.out.println("Login success wrong user logged in");
			}
		
			key.click_xpath("logout_xpath");
		}else{
			System.out.println("User not logged in");
			key.getscreenshot(datavalidation);
		}
		}else if(datavalidation.equalsIgnoreCase("invalid_email")){
			System.out.println("Test for Invalid email id");
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			
			key.sleep(2000L);
		
			String x=key.get_text_css("invalid_email_xpath_1");
			System.out.println("Condition to test is :"+x);
			if(x.equalsIgnoreCase("* Invalid email address")){
				System.out.println("user enter wrong email id");
				System.out.println("Invalid email case : Pass");
			}}else if(datavalidation.equals("invalid_password")){
				System.out.println("Test for Invalid password");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
			
				key.sleep(2000L);
				
				String y=key.get_text_css("invalid_password_xpath");
				System.out.println("Condition to test is :"+y);
				if(y.equalsIgnoreCase("Login incorrect!")){
					System.out.println("user enter wrong password");
					System.out.println("Invalid password case : Pass");
				}
				
			}else if(datavalidation.equalsIgnoreCase("both_invalid_email_password")){
				System.out.println("Test for Invalid email id and password");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				
				key.sleep(2000L);
				
				String z=key.get_text_css("invalid_password_xpath");
				System.out.println("Condition to test is :"+z);
				if(z.equalsIgnoreCase("* Invalid email address")){
					System.out.println("user enter wrong email and password");
					System.out.println("Invalid email and password case : Pass");
				}	
			}
		}else{
			System.out.println("Internet connection is not active");
		}}catch(Exception e){
			System.out.println("error :"+e.getMessage());
			e.printStackTrace();
			key.getscreenshot(datavalidation);
		}
	
		key.quit_all_browsers();
		System.out.println("*********************************************");
	}
	@DataProvider
	public Object[][] registerdata(){
		Object[][] data=new Object[4][4];
		//1st set of data
		data[0][0]="valid_data";
		data[0][1]="mademvv@gmail.com";
		data[0][2]="apaly01";
		data[0][3]="chrome";
		//2nd set of data
		data[1][0]="invalid_email";
		data[1][1]="mademvv@gmail.com";
		data[1][2]="apalya01";
		data[1][3]="chrome";
		//3rd set of data
		data[2][0]="invalid_password";
		data[2][1]="mademvv@gmail.com";
		data[2][2]="apalya01";
		data[2][3]="chrome";
		//4th set of data
		data[3][0]="both_invalid_email_password";
		data[3][1]="mademvv@gmail.com";
		data[3][2]="apalya01";
		data[3][3]="chrome";
		return data;
		
	}

}
