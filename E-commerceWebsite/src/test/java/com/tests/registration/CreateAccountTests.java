package com.tests.registration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.registration.LoginPage;

public class CreateAccountTests extends LoginPage {
	@Test(priority = 1)
	public void titleVerification() {
		logger = extent.createTest(
				this.getClass().getSimpleName() + "_" + Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(Status.INFO, "Start verify E-commerce website");

		Assert.assertEquals(driver.getTitle(), "My Store");
		logger.log(Status.PASS, "Verify page title");
	}

	@Test(dataProvider = "signup", priority = 2)
	public void validLogin(String salutation, String fName, String lName, String emailID, String pass,
			String companyName, String address, String address2, String city, String zipCode,
			String addtionalInformation, String homePhone, String mobilePhone, String assignAddress)
			throws InterruptedException {
		logger = extent.createTest(
				this.getClass().getSimpleName() + "_" + Thread.currentThread().getStackTrace()[1].getMethodName());
		String signup = pro.getSignUp();
		WebElement signUpButton = driver.findElement(By.xpath(signup));
		Boolean display = signUpButton.isDisplayed();
		logger.log(Status.INFO, "signup button is  displayed " + display);
		signUpButton.click();
		logger.log(Status.INFO, "clicked on signup button");

		Assert.assertEquals(driver.getTitle(), "Login - My Store");
		logger.log(Status.PASS, "verified Sign up page title");

		String authenicationText = pro.getAuthenticationText();
		logger.log(Status.INFO,
				"Authentication text is displayed " + driver.findElement(By.xpath(authenicationText)).isDisplayed());

		String createAnAccountText = pro.getCreateAnAccountText();
		logger.log(Status.INFO, "create an account text is displayed "
				+ driver.findElement(By.xpath(createAnAccountText)).isDisplayed());

		String emailAddressText = pro.getEmailAddressText();
		logger.log(Status.INFO,
				"email address text is displayed " + driver.findElement(By.xpath(emailAddressText)).isDisplayed());

		logger.log(Status.INFO, "Start entering data in the sign up form ");
		// driver.navigate().refresh();
		String emailTextfield = pro.getEmailTextField();

		driver.findElement(By.xpath(emailTextfield)).sendKeys(emailID);
		logger.log(Status.INFO, "Entered " + emailID + " in email textfield");

		String submitButtonText = pro.getSubmitButtonText();
		WebElement createAccountButton = driver.findElement(By.xpath(submitButtonText));
		logger.log(Status.INFO, "submit button is enabled " + createAccountButton.isEnabled());
		createAccountButton.click();
		logger.log(Status.INFO, "clicked on the create account button");
		Thread.sleep(7000);

		if ((driver.getCurrentUrl().contains("controller=authentication&back=my-account#account-creation"))) {
			logger.log(Status.PASS, "User enter correct email address proceduce futher");
		} else {
			Assert.assertTrue(
					driver.getCurrentUrl().contains("controller=authentication&back=my-account#account-creation"));
			String invalidEmail = pro.getInvalidEmailText();
			logger.log(Status.ERROR, driver.findElement(By.xpath(invalidEmail)).getText());
		}
		String personalInfoText = pro.getPersonalInfoText();
		logger.log(Status.INFO, "personal inforamtion text is displayed "
				+ driver.findElement(By.xpath(personalInfoText)).isDisplayed());

		String genderRadioButton = pro.getGenderRadioButton();
		List<WebElement> gender = driver.findElements(By.xpath(genderRadioButton));
		for (WebElement gen : gender) {
			String str = gen.getText();
			System.out.println(str);
			if (str.contentEquals(salutation)) {
				gen.click();
				break;
			}
		}
		logger.log(Status.INFO, "Clicked on the Mrs. radio button");
		String firstname = pro.getFirstname();
		logger.log(Status.INFO, "firstname text is displayed " + driver.findElement(By.xpath(firstname)).isDisplayed());

		Actions act = new Actions(driver);
		String firstnameTextField = pro.getFirstnameTextField();
		driver.findElement(By.xpath(firstnameTextField)).sendKeys(fName);
		logger.log(Status.INFO, "entered " + fName + " as name in firstname");

		String lastname = pro.getLastname();
		logger.log(Status.INFO, "lastname text is displayed " + driver.findElement(By.xpath(lastname)).isDisplayed());
		act.sendKeys(Keys.TAB, lName).build().perform();
		logger.log(Status.INFO, "entered " + lName + " as lastname");

		String email = pro.getEmail();
		logger.log(Status.INFO, "Email text is displayed " + driver.findElement(By.xpath(email)).isDisplayed());
		act.sendKeys(Keys.TAB, emailID).build().perform();
		logger.log(Status.INFO, "entered " + emailID + " as email");

		String password = pro.getPassword();
		logger.log(Status.INFO, "password text is displayed " + driver.findElement(By.xpath(password)).isDisplayed());
		act.sendKeys(Keys.TAB, pass).build().perform();

		logger.log(Status.INFO, "entered " + pass + " as password");
		String dateOfBirth = pro.getDateOfBirth();
		logger.log(Status.INFO,
				"date of birth text is displayed " + driver.findElement(By.xpath(dateOfBirth)).isDisplayed());

		act.sendKeys(Keys.TAB).click().build().perform();
		String days = pro.getDaysDD();
		Select day = new Select(driver.findElement(By.xpath(days)));
		day.selectByValue("4");
		logger.log(Status.INFO, "Entered 4 as day");
		act.sendKeys(Keys.TAB).click().build().perform();

		String months = pro.getMonthDD();
		Select month = new Select(driver.findElement(By.xpath(months)));
		month.selectByVisibleText("April ");
		logger.log(Status.INFO, "Entered April as month");
		act.sendKeys(Keys.TAB).click().build().perform();

		String years = pro.getYearDD();
		Select year = new Select(driver.findElement(By.xpath(years)));
		year.selectByValue("1999");
		logger.log(Status.INFO, "Entered 1999 as year");

		// @Test(priority=4)
		// public void addressDetails() throws InterruptedException {
		// logger=extent.createTest(
		// this.getClass().getSimpleName()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(Status.INFO, "Start entering data in the address form ");

		String addressHeading = pro.getAddressHeading();
		logger.log(Status.INFO,
				"Address text is displayed " + driver.findElement(By.xpath(addressHeading)).isDisplayed());

		String companyText = pro.getCompanyText();
		logger.log(Status.INFO, "company text is displayed " + driver.findElement(By.xpath(companyText)).isDisplayed());
		String companyTextField = pro.getCompanyTextField();
		driver.findElement(By.xpath(companyTextField)).sendKeys(companyName);
		logger.log(Status.INFO, "Entered " + companyName + " as company name");

		String addressText = pro.getAddressText();
		logger.log(Status.INFO, "address text is displayed " + driver.findElement(By.xpath(addressText)).isDisplayed());
		act.sendKeys(Keys.TAB, address).build().perform();
		logger.log(Status.INFO, "Entered " + address + " as address");
		act.sendKeys(Keys.TAB, address2, Keys.TAB).build().perform();
		logger.log(Status.INFO, "Entered " + address2 + " as address 2");

		String cityText = pro.getCityText();
		logger.log(Status.INFO, "city text is displayed " + driver.findElement(By.xpath(cityText)).isDisplayed());
		act.sendKeys(city, Keys.TAB).build().perform();
		logger.log(Status.INFO, "Entered " + city + " as city");

		String stateText = pro.getStateText();
		logger.log(Status.INFO, "state text is displayed " + driver.findElement(By.xpath(stateText)).isDisplayed());
		Select state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
		state.selectByValue("5");

		logger.log(Status.INFO, "Entered California as State");

		String zipText = pro.getZipText();
		logger.log(Status.INFO, "zip code text is displayed " + driver.findElement(By.xpath(zipText)).isDisplayed());
		act.sendKeys(Keys.TAB, zipCode, Keys.TAB).build().perform();
		logger.log(Status.INFO, "Entered " + zipCode + " as zip code");

		String countryText = pro.getCountryText();
		logger.log(Status.INFO, "country text is displayed " + driver.findElement(By.xpath(countryText)).isDisplayed());

		String additionalInfoText = pro.getAdditionalInfoText();
		logger.log(Status.INFO, "additional Information text is displayed "
				+ driver.findElement(By.xpath(additionalInfoText)).isDisplayed());
		act.sendKeys(Keys.TAB, addtionalInformation).build().perform();
		logger.log(Status.INFO, "Entered " + addtionalInformation + " as additional information");

		String homePhoneText = pro.getHomePhoneText();
		logger.log(Status.INFO,
				"home phone text is displayed " + driver.findElement(By.xpath(homePhoneText)).isDisplayed());
		act.sendKeys(Keys.TAB, homePhone).build().perform();
		logger.log(Status.INFO, "Entered " + homePhone + " as home phone number");

		String mobilePhoneText = pro.getMobilePhoneText();
		logger.log(Status.INFO,
				"mobile phone text is displayed " + driver.findElement(By.xpath(mobilePhoneText)).isDisplayed());
		act.sendKeys(Keys.TAB, mobilePhone).build().perform();
		logger.log(Status.INFO, "Entered " + mobilePhone + " as mobile phone number");

		Thread.sleep(3000);
		String assignAddressText = pro.getAssignAddressText();
		logger.log(Status.INFO,
				"assign address text is displayed " + driver.findElement(By.xpath(assignAddressText)).isDisplayed());
		act.sendKeys(Keys.TAB, assignAddress).build().perform();
		logger.log(Status.INFO, "Entered " + assignAddress + " as assign address");
		Thread.sleep(3000);

		String registerText = pro.getRegisterText();
		logger.log(Status.INFO,
				"register button text is displayed " + driver.findElement(By.xpath(registerText)).isDisplayed());
		act.sendKeys(Keys.TAB, Keys.ENTER).build().perform();
		if (driver.getTitle().contentEquals("My account - My Store")) {
			logger.log(Status.PASS, "successfully created account");
			String signout = pro.getSignOut();
			driver.findElement(By.xpath(signout)).click();

		} else {
			// String invalid=pro.getInvalidEmailText();
			logger.log(Status.ERROR, driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).getText());

			Assert.assertTrue(driver.getTitle().contentEquals("My account - My Store"));
			Thread.sleep(3000);
		}

	}

}
