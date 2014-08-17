package com.utils;

import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class resuable_functions {
	public static keywords key=null;
	public static resuable_functions rf=null;
	
	public void login(String browser_name) throws Throwable{
		try{
			key=new keywords();
		key.browser(browser_name);
		System.out.println("Testing in Browser :"+ browser_name);
		key.implicit_wait(20);
		key.window_maxmise();
		key.open_browser("http:\\www.myplex.com");
		System.out.println("Browser is open");
			if(key.get_window_title().equals("Watch Movies Online, Watch TV Shows Seasons Online | Myplex.com"))
		{
		
				
		//login Test
	    key.click_xpath("login_link_xpath");
	    key.click_xpath("login_link_xpath");
	    key.send_text("username_xpath", "mademvv@gmail.com");
	    key.send_text("password_xpath", "apalya01");
	    key.click_xpath("submitbutton_xpath");
	    
		}
		
		}catch(Exception e){
			System.out.println("error :"+e.getMessage());
			e.printStackTrace();
			key.getscreenshot("error");
		}
	
	}
    public boolean iselement_found(String xpath){
    	int count=0;
    	count=key.find_elements_count(xpath);
    	if(count!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    	public boolean iselement_found_dynamic(String xpath_1,String xpath_2,int i){
        	int count=0;
        	count=key.find_elements_count_dynamic(xpath_1,xpath_2,i);
        	if(count!=0){
        		return true;
        	}else{
        		return false;
        	}
    	
    		
    }

   public void log_out(){
	   key.click_xpath("logout_xpath");
   }
    public void search(String search_text,String browser) throws Throwable{
    	rf=new resuable_functions();
    	key.sleep(2000L);
		key.click_css("search_box_css");
		key.send_text_css("search_box_css", search_text);
		if(browser.equals("firefox")){
		key.jquery_element_click_dropdown("search_box_xpath","search_result_xpath_1","search_result_xpath_2", 4);
		}
		
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
				 key.click_xpath_dynamic("element_xpath_1", "element_xpath_2", i);
			 }
			i++;
		}
		System.out.println("**************************************");

    }
 
}
