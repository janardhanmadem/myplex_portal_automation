package com.test.search;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;
import com.utils.resuable_functions;







public class search_testcase {
	public static keywords key=null;
	public static resuable_functions rf=null;
	 
	public search_testcase() throws Throwable{
		key=new keywords();
		rf=new resuable_functions();

	}
	
	@BeforeTest
	public void normal_login() throws Throwable{
		rf.login("chrome");
	}
	
	
	
	
	@Test(dataProvider="register_data")	
	public void search(String search_text) throws Throwable{
		
		key.sleep(2000L);
		key.click_css("search_box_css");
		key.send_text_css("search_box_css", search_text);
		//key.keyboard_enter_css("search_box_css");
		//key.click_css("more_link_css");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		key.sleep(2000L);
		
		int i=1;
		while(rf.iselement_found_dynamic("element_xpath_1","element_xpath_2", i)){
			 
			 
			 String name=key.get_text_dynamic_xpath("element_xpath_1", "element_xpath_2", i);
			 System.out.println(name);
			 int c=name.indexOf(search_text);
			 if(c==-1){
				// System.out.println();
				 System.out.println("element is not found in :"+name);
			 }else{
				 System.out.println("element is found in :"+name);
			 }
			i++;
		}
		System.out.println("**************************************");
	}

	@DataProvider
	public Object[][] register_data(){
		Object[][] data=new Object[2][1];
		//1st set of data
		data[0][0]="captain";
		//2nd set of data
		data[1][0]="click";
		return data;
	}
	
	@AfterTest
	public void normal_logout() throws Throwable{
		rf.log_out();
		System.out.println("User logged out successfully");
		key.quit_all_browsers();
	}
	
}
