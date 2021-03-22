package com.utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandle {
	public WebDriver Test(WebDriver driver,String URL) {
	Set<String> list=driver.getWindowHandles();
    
    Iterator<String> i=list.iterator(); 
     
     while(i.hasNext()) {
    	 String child_window=i.next();
    	 if(!URL.equalsIgnoreCase(child_window)) {
    		 driver.switchTo().window(child_window).getCurrentUrl();
    		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }

         //return driver;
     }
     return driver;
	}
}
