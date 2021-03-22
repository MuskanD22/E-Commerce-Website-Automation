package com.tests.buyproducts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.registration.LoginPage;


public class BuyProductTests extends LoginPage{
	
	@Test
	public void loginTests() throws InterruptedException {
		logger=extent.createTest( this.getClass().getSimpleName()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(Status.INFO, "Start verifying Buy section");
		
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
		WebElement secondDress=driver.findElement(By.xpath(secondDressLink));
		
		//js.executeScript("arguments[0].moveToElement()",secondDress);
		
		act.moveToElement(secondDress).click().build().perform();
		logger.log(Status.INFO,"go to the any dress image");
		
		String moreButtonLink=pro.getMoreButton();
		WebElement moreButton=driver.findElement(By.xpath(moreButtonLink));
		js.executeScript("arguments[0].click()",moreButton);
		//act.moveToElement(moreButton).click().build().perform();
		Assert.assertEquals(driver.getTitle(), "Printed Summer Dress - My Store");
		logger.log(Status.PASS,"on the specific dress page");
		
		String quantity=pro.getQuantity();
		act.moveToElement(driver.findElement(By.xpath(quantity))).click().build().perform();
		logger.log(Status.INFO,"Increase the quanitity of the product");
		
		String sizeLink=pro.getSize();
		Select size=new Select(driver.findElement(By.xpath(sizeLink)));
		size.selectByVisibleText("L");
		logger.log(Status.INFO,"Select the specific size");
		
		js.executeScript("window.scrollBy(0,400)");
		String colorBox=pro.getColorBox();
		act.moveToElement(driver.findElement(By.xpath(colorBox))).click().build().perform();
		logger.log(Status.INFO,"Select the specific color of dress");
		
		String addToCart=pro.getAddToCart();
		driver.findElement(By.xpath(addToCart)).click();
		logger.log(Status.INFO,"Clicked on add to cart button ");
		
		String proceedButton=pro.getProceedButton();
		driver.findElement(By.xpath(proceedButton)).click();
		Assert.assertEquals(driver.getTitle(), "Order - My Store");
		logger.log(Status.PASS,"Landed on order's page");
		//summary
		String summaryPageProceedButton=pro.getSummaryPageProceedButton();
		driver.findElement(By.xpath(summaryPageProceedButton)).click();
		logger.log(Status.INFO,"Clicked on the proceed to checkout button");
		//address
		String addressPageProceedButton=pro.getAddressPageProceedButton();
		driver.findElement(By.xpath(addressPageProceedButton)).click();
		
		//terms and condition
		String termsLink=pro.getTermsLink();
		driver.findElement(By.xpath(termsLink)).click();
		logger.log(Status.INFO,"Accept the terms and condition box");
		//shipping
		String shippingPageProceedButton=pro.getShippingPageProceedButton();
		driver.findElement(By.xpath(shippingPageProceedButton)).click();
		logger.log(Status.INFO,"Clicked on shipping button");
		//pay bank click
		String payViaBankOption=pro.getPayViaBankOption();
		driver.findElement(By.xpath(payViaBankOption)).click();
		logger.log(Status.INFO,"Choose the payment option");
		//confirm order
		String confirmOrderButton=pro.getConfirmOrderButton();
		driver.findElement(By.xpath(confirmOrderButton)).click();
		logger.log(Status.INFO,"clicked on the confirm order button");
		Assert.assertEquals(driver.getTitle(), "Order confirmation - My Store");
		logger.log(Status.PASS,"Placed the order sucessfully");
	}
	
	/*
	 * Verify that 'Add to Wishlist' only works after login.
	 */
	@Test
	public void invalidTest() throws InterruptedException {
		logger=extent.createTest( this.getClass().getSimpleName()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(Status.INFO, "Start working on negative test cases");
		
		Actions act=new Actions(driver);
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
		WebElement secondDress=driver.findElement(By.xpath(secondDressLink));
		act.moveToElement(secondDress).click().build().perform();
		logger.log(Status.INFO,"go to the any dress image");
		
		String moreButtonLink=pro.getMoreButton();
		WebElement moreButton=driver.findElement(By.xpath(moreButtonLink));
		js.executeScript("arguments[0].click()",moreButton);
		
		//act.moveToElement(moreButton).click().build().perform();
		Assert.assertEquals(driver.getTitle(), "Printed Summer Dress - My Store");
		logger.log(Status.PASS,"on the specific dress page");
		
		String addToWishList=pro.getAddToWishList();
		driver.findElement(By.xpath(addToWishList)).click();
		logger.log(Status.INFO,"Clicked on add to wishList button ");
		
		js.executeScript("window.scrollBy(0,100)");
		WebElement error=driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a"));
		if(error.isDisplayed()) {
			logger.log(Status.ERROR,"Please sign in first");
			
			Assert.assertTrue(!error.isDisplayed());
			
			error.click();
		}
		
	}
	/*
	 *  Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page.
	 */
//	@Test
	/*public void verifySummaryPage() throws InterruptedException {
		Actions act=new Actions(driver);
		String signin=pro.getSignUp();
		driver.findElement(By.xpath(signin)).click();
		
		String accountText=pro.getAlreadyAccountText();
		driver.findElement(By.xpath(accountText)).isDisplayed();
		
		String emailText=pro.getAlreadyEmailText();
		driver.findElement(By.xpath(emailText)).isDisplayed();
		
		String alreadyEmailTextField=pro.getAlreadyEmailTextField();
		WebElement emailField=driver.findElement(By.xpath(alreadyEmailTextField));
		emailField.isEnabled();
		emailField.sendKeys("Sham199@gmail.com");
		//ram123
		
		String passwordText=pro.getAlreadyPasswordText();
		driver.findElement(By.xpath(passwordText)).isDisplayed();
	
		act.sendKeys(Keys.TAB,"ram123",Keys.TAB).build().perform();
		
		act.sendKeys(Keys.TAB,Keys.ENTER).build().perform();
		String womenMenuLink=pro.getWomenMenu();
		WebElement womenMenu=driver.findElement(By.xpath(womenMenuLink));
		act.moveToElement(womenMenu).build().perform();
		
		String summerDressesSubMenuLink=pro.getsummerDressesSubMenuLink();
		WebElement womenSummerDresses=driver.findElement(By.xpath(summerDressesSubMenuLink));
		act.moveToElement(womenSummerDresses).click().build().perform();
		Assert.assertEquals(driver.getTitle(), "Summer Dresses - My Store");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		
		Thread.sleep(3000);
		String secondDressLink=pro.getSecondDress();
		WebElement secondDress=driver.findElement(By.xpath(secondDressLink));
		//js.executeScript("arguments[0].moveToElement()",secondDress);
		
		act.moveToElement(secondDress).click().build().perform();
		
		String moreButtonLink=pro.getMoreButton();
		WebElement moreButton=driver.findElement(By.xpath(moreButtonLink));
		js.executeScript("arguments[0].click()",moreButton);
		//act.moveToElement(moreButton).click().build().perform();
		Assert.assertEquals(driver.getTitle(), "Printed Summer Dress - My Store");
		
		String quantity=pro.getQuantity();
		act.moveToElement(driver.findElement(By.xpath(quantity))).click().build().perform();
		
		String sizeLink=pro.getSize();
		Select size=new Select(driver.findElement(By.xpath(sizeLink)));
		size.selectByVisibleText("L");
		js.executeScript("window.scrollBy(0,400)");
		String colorBox=pro.getColorBox();
		act.moveToElement(driver.findElement(By.xpath(colorBox))).click().build().perform();
		
		String addToCart=pro.getAddToCart();
		driver.findElement(By.xpath(addToCart)).click();
		
		String proceedButton=pro.getProceedButton();
		driver.findElement(By.xpath(proceedButton)).click();
		Assert.assertEquals(driver.getTitle(), "Order - My Store");
		
		//driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_6_42_0_467734\"]/span/i")).click();
		//*[@id="product_6_42_0_467734"]/td[5]/input[2]
		WebElement prize=driver.findElement(By.xpath("//*[@id=\"product_price_6_42_467734\"]"));
		WebElement quanity=driver.findElement(By.xpath("//*[@id=\"product_6_42_0_467734\"]/td[5]/input[2]"));
		quanity.clear();
		quanity.sendKeys("4");
		String t2 = String.valueOf(Float.valueOf((prize.getText())) * (Float.valueOf(quanity.getText())));
		System.out.print(t2); 
		
	}*/
}
