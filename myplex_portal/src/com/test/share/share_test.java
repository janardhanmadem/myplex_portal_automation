package com.test.share;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.keywords;
import com.utils.resuable_functions;

public class share_test {
	public static keywords key=null;
	public static resuable_functions rf=null;
	@Test(dataProvider="register_data")
	public void share(String sharetype,String browser){
		try {
			rf=new resuable_functions();
			key=new keywords();
			rf.login(browser);
			rf.search("captain",browser);
			if(sharetype.equalsIgnoreCase("facebook")){
				key.sleep(2000L);
				//key.point_click("share_button_xpath","facebook_button_xpath");
				key.click_xpath("share_button_xpath");
				key.click_xpath("share_button_xpath");
				//key.click_css("share_button_xpath");
				//key.click_xpath("facebook_button_xpath");
				//key.javascript_click("java_share_button");
				//key.javascript_click("java_facebook_button");
				key.click_xpath("publish_facebook_button_xpath");
				key.switch_next_window();
				key.send_text("facebook_login_username_xpath", "mademvv@gmail.com");
				key.send_text("facebook_login_password_xpath", "janardhan123");
				key.keyboard_enter("facebook_login_password_xpath");
				key.send_text("share_text_xpath", "This is very nice movie");
				key.click_xpath("share_button_xpath");
				key.switch_previous_window();
				rf.log_out();
				
			}
			
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
