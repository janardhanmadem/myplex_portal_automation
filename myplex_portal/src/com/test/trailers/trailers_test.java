package com.test.trailers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;
import com.utils.resuable_functions;

public class trailers_test {
	public static keywords key=null;
	public static resuable_functions rf=null;
	@Test(dataProvider="register_data")
	public void share(String sharetype,String browser){
		try {
			rf=new resuable_functions();
			key=new keywords();
			rf.login(browser);
			rf.search("captain",browser);
			key.click_xpath("trialer_play_icon_xpath");
			key.player("player_api");
			//key.click_xpath("player_id_xpath");
			
			key.sleep(3000L);
			key.click_xpath("close_player_xpath");
							
				
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@DataProvider
	public Object[][] register_data(){
		Object[][] data=new Object[1][2];
		//1st set of data
		data[0][0]="facebook";
		data[0][1]="chrome";
		//2nd set of data
		//data[1][0]="click";
		return data;
	}

}
