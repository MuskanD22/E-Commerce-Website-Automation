package com.pages.registration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyPage {
	Properties pro;
	public PropertyPage()  {
		try{
		File src=new File("C:\\Users\\muskan.dureja\\eclipse-workspace\\E-commerceWebsite\\src\\main\\resources\\Property.properties");
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		// Load file so we can use into our script
		pro.load(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String URL() {
		return pro.getProperty("URL");
	}
	public String getSignUp() {
		return pro.getProperty("signUp.xpath");
	}
	public String getAuthenticationText() {
		return pro.getProperty("authentication.xpath");
	}
	public String getCreateAnAccountText() {
		return pro.getProperty("createAnAccount.xpath");
	}
	public String getEmailAddressText() {
		return pro.getProperty("emailAddress.xpath");
	}
	public String getEmailTextField() {
		return pro.getProperty("emailTextField.xpath");
	}
	public String getSubmitButtonText() {
		return pro.getProperty("submitButtonText.xpath");
	}
	public String getInvalidEmailText() {
		return pro.getProperty("invalidEmail.xpath");
	}
	public String getPersonalInfoText() {
		return pro.getProperty("personalInfoText.xpath");
	}
	public String getFirstname() {
		return pro.getProperty("firstname.xpath");
	}
	
	 public String getGenderRadioButton() {
		return pro.getProperty("gender.xpath");
	}
	 public String getFirstnameTextField() {
		return pro.getProperty("firstnameTextField.xpath");
	}
	public String getLastname() {
		return pro.getProperty("lastname.xpath");
	}
	public String getEmail() {
		return pro.getProperty("email.xpath");
	}
	public String getPassword() {
		return pro.getProperty("password.xpath");
	}
	public String getDateOfBirth() {
		return pro.getProperty("dateOfBirth.xpath");
	}
	public String getDaysDD() {
		return pro.getProperty("days.xpath");
	}
	public String getMonthDD() {
		return pro.getProperty("month.xpath");
	}
	public String getYearDD() {
		return pro.getProperty("year.xpath");
	}
	public String getAddressHeading() {
		return pro.getProperty("addressHeading.xpath");
	}
	public String getCompanyText() {
		return pro.getProperty("companyText.xpath");
	}
	public String getCompanyTextField() {
		return pro.getProperty("companyTextField.xpath");
	}
	public String getAddressText() {
		return pro.getProperty("addressText.xpath");
	}
	public String getCityText() {
		return pro.getProperty("cityText.xpath");
	}
	public String getStateText() {
		return pro.getProperty("stateText.xpath");
	}
	public String getZipText() {
		return pro.getProperty("zipText.xpath");
	}
	public String getCountryText() {
		return pro.getProperty("countryText.xpath");
	}
	public String getAdditionalInfoText() {
		return pro.getProperty("additionalInfoText.xpath");
	}
	public String getHomePhoneText() {
		return pro.getProperty("homePhoneText.xpath");
	}
	public String getMobilePhoneText() {
		return pro.getProperty("mobilePhoneText.xpath");
	}
	public String getAssignAddressText() {
		return pro.getProperty("assignAddressText.xpath");
	}
	public String getRegisterText() {
		return pro.getProperty("registerText.xpath");
	}
	public String getSignOut() {
		return pro.getProperty("signout.xpath");
	}
//////////////////////////////////////////////////////////BuyProductTests
	public String getAlreadyAccountText() {
		return pro.getProperty("alreadyAccountText.xpath");
	}
	public String getAlreadyPasswordText() {
		return pro.getProperty("alreadyPasswordText.xpath");
	}
	public String getAlreadyEmailText() {
		return pro.getProperty("alreadyEmailText.xpath");
	}
	public String getAlreadyEmailTextField() {
		return pro.getProperty("alreadyEmailTextField.xpath");
	}
	public String getWomenMenu() {
		return pro.getProperty("womenMenu.xpath");
	}
	public String getsummerDressesSubMenuLink() {
		return pro.getProperty("summerDressesSubMenuLink.xpath");
	}
	public String getSecondDress() {
		return pro.getProperty("secondDress.xpath");
	}
	public String getMoreButton() {
		return pro.getProperty("moreButton.xpath");
	}
	public String getQuantity() {
		return pro.getProperty("quantity.xpath");
	}
	public String getSize() {
		return pro.getProperty("size.xpath");
	}
	public String getColorBox() {
		return pro.getProperty("colorBox.xpath");
	}
	public String getAddToCart() {
		return pro.getProperty("addToCart.xpath");
	}
	public String getProceedButton() {
		return pro.getProperty("proceedButton.xpath");
	}
	public String getSummaryPageProceedButton() {
		return pro.getProperty("summaryPageProceedButton.xpath");
	}
	public String getAddressPageProceedButton() {
		return pro.getProperty("addressPageProceedButton.xpath");
	}
	public String getTermsLink() {
		return pro.getProperty("termsLink.xpath");
	}
	public String getShippingPageProceedButton() {
		return pro.getProperty("shippingPageProceedButton.xpath");
	}
	public String getPayViaBankOption() {
		return pro.getProperty("payViaBankOption.xpath");
	}
	public String getConfirmOrderButton() {
		return pro.getProperty("confirmOrderButton.xpath");
	}
	public String getAddToWishList() {
		return pro.getProperty("addToWishList.xpath");
	}
	public String getProductName() {
		return pro.getProperty("productName.xpath");
	}
	public String getSearchField() {
		return pro.getProperty("searchField.xpath");
	}
	public String getSearchProductname() {
		return pro.getProperty("searchProductname.xpath");
	}
	
}
