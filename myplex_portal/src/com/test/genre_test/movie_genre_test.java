package com.test.genre_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;
import com.utils.resuable_functions;

public class movie_genre_test {
	public static  resuable_functions rf=null;
	public static keywords key=null;
	
	@Test(dataProvider="registerdata")
	public void genre(int selection_option) throws Throwable{
		
		try {
			rf=new resuable_functions();
			key=new keywords();
			rf.login("firefox");
			//key.click_xpath("root_node_xpath");
			//key.sleep(4000L);
			String s=key.jquery_element_click_dropdown("movie_root_node_xpath", "movie_child_element_xpath_1","movie_child_element_xpath_2",selection_option);
			System.out.println("selected option is:"+s);
			String t=key.get_text_xpath("child_element_text_path");
			if(s.equals(t)){
				System.out.println("opened genre is :"+t+" and clicked genre is :"+s);
				System.out.println("Test Pass");
			}else{
				System.out.println("opened genre is :"+t+" and clicked genre is :"+s);
				System.out.println("Test Fail");
			}
			rf.log_out();
			key.quit_all_browsers();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	@DataProvider
	public Object[][] registerdata(){
		Object[][] data=new Object[1][1];
		data[0][0]=10;
		return data;
	}

}
