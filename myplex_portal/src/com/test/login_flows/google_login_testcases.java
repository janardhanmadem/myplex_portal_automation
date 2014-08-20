package com.test.login_flows;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;

public class google_login_testcases {
	@BeforeTest
	public void beforetest(){
		System.out.println("################################################");
		System.out.println("************* Google Login Test *****************");
		System.out.println("################################################");
	}
	public WebDriver driver=null;
	public static keywords key=null;
	@Test(dataProvider="registerdata")
	public void facebook_login(String datavalidation,String username,String password,String browser_name ) throws Throwable{
		
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
		//face book login Test
				key.click_xpath("login_link_xpath");
				//key.click_xpath("login_link_xpath");
				key.sleep(2000L);
				key.click_css("google_sign_css");
				key.sleep(2000L);
				key.send_text("google_username_xpath", username);
				key.send_text("google_password_xpath", password);
				key.keyboard_enter("google_password_xpath");
				
		if(datavalidation.equals("valid_data")){
			System.out.println("Testing with Valid Data");
			key.explicit_wait(20, "loading_google_xpath");
			key.sleep(2000L);
		String profile=key.get_text_xpath("profile_xpath");
		if(profile.equalsIgnoreCase("profile")){
			System.out.println("Login is success");
			key.click_xpath("profile_xpath");
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			String email=key.get_text_xpath("validate_username_xpath");
			if(email.equals(username)){
				System.out.println("Login success and correct user is logged in");
			}else{
				System.out.println("Login success wrong user logged in");
				key.getscreenshot(datavalidation);
			}
			key.click_xpath("logout_xpath");
			key.sleep(2000L);
		}
		}else if(datavalidation.equals("invalid_email")){
			System.out.println("Testing with invalid email");
			System.out.println("user name is :"+username);
			System.out.println("Password is :"+password);
			String x=key.get_text_css("incorrect_css_google");
			System.out.println("tested condition is :"+x);
			if(x.equalsIgnoreCase("The email or password you entered is incorrect. ?")){
				System.out.println("user entered Incorrect email id");
				System.out.println("user unable to login");
				key.sleep(2000L);
			}else{
				
				System.out.println("user entered correct email id");
				System.out.println("user able to login");
				key.getscreenshot(datavalidation);
			}
			}else if(datavalidation.equalsIgnoreCase("invalid_password")){
				System.out.println("Testing with invalid password");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				String y=key.get_text_css("incorrect_css_google");
				System.out.println("tested condition is :"+y);
				if(y.equalsIgnoreCase("The email or password you entered is incorrect. ?")){
					System.out.println("user entered Incorrect password");
					System.out.println("user unable to login");
					key.sleep(2000L);
					
			}else{
				System.out.println("user entered correct password");
				System.out.println("user able to login");
				key.getscreenshot(datavalidation);
			}}
				else if(datavalidation.equalsIgnoreCase("both_invalid_email_password")){
			System.out.println("Testing with invalid email and password");
				System.out.println("user name is :"+username);
				System.out.println("Password is :"+password);
				String z=key.get_text_css("incorrect_css_google");
				System.out.println("tested condition is :"+z);
				if(z.equalsIgnoreCase("The email or password you entered is incorrect. ?")){
					System.out.println("user entered Incorrect email and password");
					System.out.println("user unable to login");
					key.sleep(2000L);
			}else {
				System.out.println("user entered correct password and email id");
				System.out.println("user able to login");
				key.getscreenshot(datavalidation);
			}
		
		
		
		
}else{
	System.out.println("Internet connection is not active");
}}}catch(Exception e){
	System.out.println("error :"+e.getMessage());
	e.printStackTrace();
	key.getscreenshot(datavalidation);
}
		key.quit_all_browsers();
System.out.println("************************************");

	}
	@DataProvider
	public Object[][] registerdata(){
		Object[][] data=new Object[4][4];
	//1st set of data
		data[0][0]="valid_data";
		data[0][1]="mademvv@gmail.com";
		data[0][2]="janardhan.venkat";
		data[0][3]="chrome";
   //2nd set of data
		data[1][0]="invalid_email";
		data[1][1]="mademvvgmail.com";
		data[1][2]="janardhan.venkat";
		data[1][3]="chrome";
	//3rd set of data
     	data[2][0]="invalid_password";
		data[2][1]="mademvv@gmail.com";
		data[2][2]="janardhan";
		data[2][3]="chrome";
	//4th set of data
		data[3][0]="both_invalid_email_password";
		data[3][1]="mademvvgmail.com";
		data[3][2]="janardhan";
		data[3][3]="chrome";
		return data;
		
	}	
}
	
