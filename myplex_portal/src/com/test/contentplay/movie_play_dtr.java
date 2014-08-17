package com.test.contentplay;

import java.awt.Robot;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opera.core.systems.internal.input.KeyEvent;
import com.utils.keywords;
import com.utils.resuable_functions;

public class movie_play_dtr {
	
	public static keywords key=null;
	public static resuable_functions rf=null;
	public movie_play_dtr() throws Throwable{
		key=new keywords();
		rf=new resuable_functions();
	}
	
	@BeforeTest
	public void normal_login() throws Throwable{
		rf.login("chrome");
	}
	
	@Test(dataProvider="register_data")
	public void content_movie_dtr_play(String movie_name){
		try{
		key.sleep(2000L);
		key.click_css("search_box_css");
		key.send_text_css("search_box_css", movie_name);
		//key.keyboard_enter_css("search_box_css");
		
		Robot r=new Robot();
		r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		key.sleep(2000L);
		
		int i=1;
		while(rf.iselement_found_dynamic("element_xpath_1","element_xpath_2", i)){
			 
			 
			 String name=key.get_text_dynamic_xpath("element_xpath_1", "element_xpath_2", i);
			 System.out.println(name);
			 int c=name.indexOf(movie_name);
			 if(c==-1){
				// System.out.println();
				 System.out.println("element is not found in :"+name);
			 }else{
				 System.out.println("element is found in :"+name);
				 key.click_xpath_dynamic("element_xpath_1", "element_xpath_2", i);
				 if(key.find_elements_count("price_box_xpath")!=0){
					 key.click_xpath("price_box_xpath");
					 key.send_text("buy_button_text_box_xpath", "coup751");
					 key.click_xpath("buy_submit_button_xpath");
					 key.click_xpath("price_button_xpath");
					 key.sleep(2000);
					 key.click_xpath("price_button_xpath");
					 key.click_xpath("subscribe_button_xpath");
					key.invisibility_elements("loading_screen_xpath");
					 key.sleep(3000);
					 key.click_xpath("confirm_button_xpath");
					 
				 }else{
				 
				 key.click_xpath("movie_play_button_xpath");
				 }
				 key.sleep(2000L);
				 
				 key.click_xpath("stream_option_xpath");
				 key.click_xpath("continue_button_xpath");
				// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\chromedriver.exe");
				 //WebDriver driver=new ChromeDriver();
				// FlexWebDriver flashapp=new FlexWebDriver(driver,"player_api");
				// flashapp.call("playVideo");
				 key.sleep(5000L);
				 //flashapp.call("pauseVideo");
				 
				 
				 
			 }
			i++;
		}}catch(Throwable e){
			System.out.println("error :"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("**************************************");
	}
	

	@DataProvider
	public Object[][] register_data(){
		Object[][] data=new Object[1][1];
		//1st set of data
		data[0][0]="a few good men";
		//2nd set of data
		//data[1][0]="click";
		return data;
	}
	/*
	@AfterTest
	public void normal_logout() throws Throwable{
		rf.log_out();
		System.out.println("User logged out successfully");
		key.quit_all_browsers();
	}*/
	
	
	
}
