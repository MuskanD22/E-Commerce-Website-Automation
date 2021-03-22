package com.tests.serachproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.registration.LoginPage;


public class SearchProductTests extends LoginPage{
	
	@Test
	public void searchProductFieldTests() throws InterruptedException {
		logger=extent.createTest( this.getClass().getSimpleName()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(Status.INFO, "Start verifying search field section");
		
		Actions act=new Actions(driver);
		String signin=pro.getSignUp();
		driver.findElement(By.xpath(signin)).click();
		logger.log(Status.INFO, "CLicked on the signin button");
		
		Assert.assertEquals(driver.getTitle(),"Login - My Store");
		logger.log(Status.PASS,"verified Sign in page title");
		
		String accountText=pro.getAlreadyAccountText();
		logger.log(Status.INFO,"Already have account text is displayed :"+driver.findElement(By.xpath(accountText)).isDisplayed());
		
		String emailText=pro.getAlreadyEmailText();
		logger.log(Status.INFO,"email text is displayed :"+driver.findElement(By.xpath(emailText)).isDisplayed());
		
		String alreadyEmailTextField=pro.getAlreadyEmailTextField();
		WebElement emailField=driver.findElement(By.xpath(alreadyEmailTextField));
		logger.log(Status.INFO,"Email Textfield is displayed :"+emailField.isEnabled());
		emailField.sendKeys("Sham199@gmail.com");
		logger.log(Status.INFO,"entered Sham199@gmail.com in email textfield");
			
		
		String passwordText=pro.getAlreadyPasswordText();
		logger.log(Status.INFO,"Password text is displayed :"+driver.findElement(By.xpath(passwordText)).isDisplayed());
	
		act.sendKeys(Keys.TAB,"ram123",Keys.TAB).build().perform();
		logger.log(Status.INFO,"Entered ram123 as password in password field");
		
		act.sendKeys(Keys.TAB,Keys.ENTER).build().perform();
		
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
		logger.log(Status.PASS, "Login Sucessfully");
		
		String womenMenuLink=pro.getWomenMenu();
		WebElement womenMenu=driver.findElement(By.xpath(womenMenuLink));
		act.moveToElement(womenMenu).build().perform();
		logger.log(Status.INFO,"Clicked on the women Menu");
		
		String summerDressesSubMenuLink=pro.getsummerDressesSubMenuLink();
		WebElement womenSummerDresses=driver.findElement(By.xpath(summerDressesSubMenuLink));
		act.moveToElement(womenSummerDresses).click().build().perform();
		logger.log(Status.INFO,"Clicked on summer dresses sub menu");
		
		Assert.assertEquals(driver.getTitle(), "Summer Dresses - My Store");
		logger.log(Status.PASS,"Verify summer dresss page Title");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		
		Thread.sleep(3000);
		String secondDressLink=pro.getSecondDress();
		driver.findElement(By.xpath(secondDressLink));
		
		String productName=pro.getProductName();
		String productNameText=driver.findElement(By.xpath(productName)).getText();
		logger.log(Status.INFO,"Capture the name of the product to be searched");
		
		String searchField=pro.getSearchField();
		driver.findElement(By.xpath(searchField)).sendKeys(productNameText);
		logger.log(Status.INFO,"Entered the name of the product to be searched");
		
		act.sendKeys(Keys.ENTER).build().perform();
		String searchProductname=pro.getSearchProductname();
		String searchResultProductname=driver.findElement(By.xpath(searchProductname)).getText();
		logger.log(Status.INFO,"Capture the name of the searched product");
		
		if(productNameText.equalsIgnoreCase(searchResultProductname)) {
			logger.log(Status.PASS,"Test passed searched field working fine");
		}
		else {
			System.out.print("fail");
		}
		
	}
	
}
