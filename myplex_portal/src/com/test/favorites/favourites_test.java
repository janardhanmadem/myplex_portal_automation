package com.test.favorites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;
import com.utils.resuable_functions;

public class favourites_test {
	
	public static keywords key=null;
	public static resuable_functions rf=null;
	public favourites_test() throws Throwable{
		key=new keywords();
		rf=new resuable_functions();
	}
	
	@BeforeTest
	public void normal_login() throws Throwable{
		rf.login("chrome");
	}
	
	@Test(dataProvider="register_data")
	public void set_favorite(String search_text ){
		try{
		key.click_css("search_box_css");
		key.send_text_css("search_box_css", search_text);
		key.keyboard_enter_css("search_box_css");
		key.sleep(2000L);
		int i=1;
		//setting favourite
		while(rf.iselement_found_dynamic("element_xpath_1", "element_xpath_2", i)){
			 String name=key.get_text_dynamic_xpath("element_xpath_1", "element_xpath_2", i);
			 System.out.println("searched string in :"+name);
			 int c=name.indexOf(search_text);
			 if(c==-1){
				 System.out.println("element is not found in :"+name);
				 
			 }else{
				 System.out.println("element is found in :"+name);
				 System.out.println("Favourite setting movie is :"+name);
				 key.click_xpath_dynamic("element_xpath_1", "element_xpath_2", i);
				 key.sleep(2000L);
				 key.click_xpath("fav_icon_xpath");
				 
			 }
			i++;
		}
	//checking favourite or not	
		System.out.println("checking whether movie is set as favorite or not :"+search_text);
		key.click_xpath("profile_xpath");
		key.click_xpath("fav_profile_xpath");
		key.sleep(2000L);
		int j=1;
		//setting favourite
		while(rf.iselement_found_dynamic("fav_search_xpath_1", "fav_search_xpath_2", j)){
			 String name=key.get_text_dynamic_xpath("fav_search_xpath_1", "fav_search_xpath_2", j);
			 System.out.println("searched string in :"+name);
			 int d=name.indexOf(search_text);
			 if(d==-1){
				 System.out.println("element is not found in favorites :"+name);
				 //System.out.println("movie is not as a favourite :"+name);
				 
			 }else{
				 System.out.println("element is found in favorites :"+name);
				 System.out.println("Movie is set as favourite successfully:"+name);
				 break;
				 
			 }
			j++;
		}}catch(Throwable e){
			System.out.println("error"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	@DataProvider
	public Object[][] register_data(){
		Object[][] data=new Object[1][1];
		//1st set of data
		data[0][0]="click";
		//2nd set of data
		//data[1][0]="click";
		return data;
	}
	
	
	@Test(dataProvider="register_data")
	public void un_set_favourite(String search_text){
		
		try{
			
			key.click_css("search_box_css");
			key.send_text_css("search_box_css", search_text);
			key.keyboard_enter_css("search_box_css");
			key.sleep(2000L);
			int i=1;
			//setting favourite
			
			while(rf.iselement_found_dynamic("element_xpath_1", "element_xpath_2", i)){
				 String name=key.get_text_dynamic_xpath("element_xpath_1", "element_xpath_2", i);
				 System.out.println("searched string in :"+name);
				 int c=name.indexOf(search_text);
				 if(c==-1){
				
					 System.out.println("element is not found in :"+name);
					 
				 }else{
					 System.out.println("element is found in :"+name);
					 System.out.println("Favourite unsetting movie is :"+name);
					 key.click_xpath_dynamic("element_xpath_1", "element_xpath_2", i);
					 key.sleep(2000L);
					 key.click_xpath("fav_icon_xpath");
					 
				 }
				i++;
			}
		//checking unset favourite or not	
			System.out.println("checking whether movie is unset as favorite or not :"+search_text);
			key.click_xpath("profile_xpath");
			key.click_xpath("fav_profile_xpath");
			key.sleep(2000L);
			int j=1;
			//unsetting favourite
			while(rf.iselement_found_dynamic("fav_search_xpath_1", "fav_search_xpath_2", j)){
				 String name=key.get_text_dynamic_xpath("fav_search_xpath_1", "fav_search_xpath_2", j);
				 System.out.println("searched string in :"+name);
				 int d=name.indexOf(search_text);
				 if(d==-1){
					 System.out.println("element is not found in favorites :"+name);
					 System.out.println("movie is not as a favourite :"+name);
					 
				 }else{
					 System.out.println("element is found in favorites :"+name);
					 System.out.println("Movie is set as favourite successfully:"+name);
					 break;
				 }
				j++;
			}}catch(Throwable e){
				System.out.println("error :"+e.getMessage());
				e.printStackTrace();
			}
	}	
	
	
	
	@AfterTest
	public void normal_logout() throws Throwable{
		rf.log_out();
		System.out.println("User logged out successfully");
		key.quit_all_browsers();
	}
	
	
}
