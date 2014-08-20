package com.test.login_flows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.utils.keywords;

public class facebook_login_testcases {
	
	public static WebDriver driver=null;
	public static boolean  d;
	public static  keywords key=null;
	
	@Test(dataProvider="registerdata")
	public static void facebook_login(String datavalidation,String username,String password,String browser_name) throws Throwable{
		key=new keywords();
		key.logs("##################################################");
		key.logs("************* Facebook Login Test *****************");
		key.logs("##################################################");
		
		try{
		key.browser(browser_name);
		key.implicit_wait(20);
		key.window_maxmise();
		key.open_browser("http:\\www.myplex.com");
		
		if(key.get_window_title().equals("Watch Movies Online, Watch TV Shows Seasons Online | Myplex.com"))
		{
		//face book login Test
			key.click_xpath("login_link_xpath");
			//key.click_xpath("login_link_xpath");
		key.sleep(2000L);
		key.click_css("facebook_sign_css");
		key.sleep(2000L);
		key.send_text("facebook_username_xpath", username);
		key.send_text("facebook_password_xpath", password);
		key.keyboard_enter("facebook_password_xpath");
		
		key.logs(datavalidation);
		if(datavalidation.equals("valid_data")){
			key.logs("Testing with Valid Data");
			key.explicit_wait(20, "loading_facebook_xpath");
			key.sleep(2000L);
		String profile=key.get_text_xpath("profile_xpath");	
		if(profile.equalsIgnoreCase("profile")){
			key.logs("Login is success");
			key.click_xpath("profile_xpath");
			
			key.logs("user name is :"+username);
			key.logs("Password is :"+password);
			String email=key.get_text_xpath("validate_username_xpath");
			
			if(email.equals(username)){
				key.logs("Login success and correct user is logged in");
				key.click_xpath("logout_xpath");
				d=true;
				key.test_status(d); 
			}else{
				key.logs("Login success wrong user logged in");
				key.click_xpath("logout_xpath");
				
				d=false;
				key.test_status(d);
				key.getscreenshot(datavalidation);
			}     
		}
		}else if(datavalidation.equals("invalid_email")){
			key.logs("Testing with invalid email");
			key.logs("user name is :"+username);
			key.logs("Password is :"+password);
		    String x=key.get_text_css("incorrect_css");
			
		    key.logs("tested condition is :"+x);
			if(x.equalsIgnoreCase("Incorrect Email")){
				key.logs("user entered Incorrect email id");
				key.logs("user unable to login");
				key.sleep(2000L);
				d= true;
				key.test_status(d);
			}else{
				key.logs(datavalidation+" Test Failed");
				
				d=false;
				key.test_status(d);
				key.getscreenshot(datavalidation);
			}   
			}else if(datavalidation.equalsIgnoreCase("invalid_password")){
					key.logs("user name is :"+username);
					key.logs("Password is :"+password);
			    String y=key.get_text_css("incorrect_css");
				key.logs("tested condition is :"+y);
				//Assertion.assertTrue("","Please re-enter your password");
				if(y.equalsIgnoreCase("Please re-enter your password")){
					key.logs("user entered Incorrect password");
					key.logs("user unable to login");
					key.sleep(2000L);
					d=true;
					key.test_status(d);
			}else{
				key.logs(datavalidation+" Test Failed");
				
				d=false;
				key.test_status(d);
				key.getscreenshot(datavalidation);
			}
				}else if(datavalidation.equalsIgnoreCase("both_invalid_email_password")){
				key.logs("user name is :"+username);
				key.logs("Password is :"+password);
				String z=key.get_text_css("incorrect_css");
				key.logs("tested condition is :"+z );
				if(z.equalsIgnoreCase("Incorrect Email") || z.equalsIgnoreCase("Please re-enter your password")){
					key.logs("user entered Incorrect email and password");
					key.logs("user unable to login");
					key.sleep(2000L);
					d=true;
					key.test_status(d);
			}else{
				key.logs(datavalidation+" Test Failed");
				
				d=false;
				key.test_status(d);
				key.getscreenshot(datavalidation);
			}
		
		} 
		}
		}catch(Exception e){
			key.getscreenshot(datavalidation);
			key.logs("error :"+e.getMessage());
		    // key.logs(e.printStackTrace());
			d=false;
			key.test_status(d);
			
		}
		key.quit_all_browsers();
		key.logs("************************************");	
	}
	
		@DataProvider
		public Object[][] registerdata(){
			Object[][] data=new Object[4][4];
		//1st set of data
			data[0][0]="valid_data";
			data[0][1]="mademvv@gmail.com";
			data[0][2]="janardhan123";
			data[0][3]="chrome";
	//2nd set of data
			data[1][0]="invalid_email";
			data[1][1]="mademvvgmail.com";
			data[1][2]="janardhan123";
			data[1][3]="chrome";
		//3rd set of data
			data[2][0]="invalid_password";
			data[2][1]="mademvv@gmail.com";
			data[2][2]="janar";
			data[2][3]="chrome";
		//4th set of data
			data[3][0]="both_invalid_email_password";
			data[3][1]="mademvvgmail.com";
			data[3][2]="janardhan12";
			data[3][3]="chrome";
			return data;
			
		}

}
