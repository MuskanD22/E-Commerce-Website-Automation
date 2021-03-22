package com.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
	
	public void MenuSelector(WebDriver driver, String MenuName) {
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='menu']//ul//li//a"));
		for(WebElement ele:menuList) {
			String menuName=ele.getAttribute("innerHTML");
			if(menuName.contentEquals("Jobs")) {
				ele.click();
				break;
			}
		}
}
}
