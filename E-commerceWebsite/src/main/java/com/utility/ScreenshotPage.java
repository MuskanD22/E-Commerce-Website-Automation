package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotPage {
	public static String captureScreenshots(WebDriver driver, String UserDefine) {
		String dest="";
		try {
			// firstly we create the interface and then type caste it to that interface
			TakesScreenshot ts=(TakesScreenshot)driver;
			// then we get the screenshot in form of file
			File source=ts.getScreenshotAs(OutputType.FILE);	
			dest="C:\\Users\\muskan.dureja\\eclipse-workspace\\E-commerceWebsite\\Screenshots"+UserDefine+".png";
			File destinstion=new File(dest);
			// then we copy the file and save it the location where we want
			FileUtils.copyFile(source, destinstion);
			System.out.println("Screenshot captured");
			
		}catch(Exception e) {
			System.out.println("Exception occur while taking screenshot "+e.getMessage());
		}
		return dest;
	}

}
