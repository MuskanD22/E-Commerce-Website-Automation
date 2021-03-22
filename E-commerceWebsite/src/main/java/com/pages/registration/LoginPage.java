package com.pages.registration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.ExcelDataConfig;
import com.utility.QuickBrowserOpening;
import com.utility.ScreenshotPage;

public class LoginPage {
	public WebDriver driver;
	public PropertyPage pro = new PropertyPage();
	public ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	int i = 0;
	public ExtentTest logger;

	public ExcelDataConfig config;

	/*
	 * This startup() method will create the instance of Extent report
	 */

	@BeforeSuite
	public void startup() {
		reporter = new ExtentHtmlReporter("D:\\ReportData\\Sample" + i + ".html");
		reporter.setAppendExisting(true);
		// Create object of ExtentReports class- This is main class which will create
		// report
		extent = new ExtentReports();

		// attach the reporter which we created in Step 1
		extent.attachReporter(reporter);

	}

	/*
	 * This beforeTest() method will open the browser and load the application
	 * before the test started
	 */

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		String URL = pro.URL();
		driver = QuickBrowserOpening.StartBrowser("Chrome", URL);
	}

	@BeforeMethod
	public void beforeMethod() {
		// String URL=pro.URL();
		// driver=QuickBrowserOpening.StartBrowser("Chrome",URL);
	}

	/*
	 * This testDataFeed() will provide the data when user is entering the data in
	 * registration form
	 */

	@DataProvider(name = "signup")
	public Object[][] testDataFeed() {
		int rows_count = 0;
		config = new ExcelDataConfig("D:\\Reports\\signUpData.xlsx");

		rows_count = config.getRowCount(0);

		Object[][] data = new Object[rows_count][14];

		for (int i = 1; i < rows_count; i++) {
			/*
			 * for(int j=0;j<rows_count;j++) { data[i][j]=config.getData(0, i, j); }
			 */
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
			data[i][3] = config.getData(0, i, 3);
			data[i][4] = config.getData(0, i, 4);

			data[i][5] = config.getData(0, i, 5);
			data[i][6] = config.getData(0, i, 6);
			data[i][7] = config.getData(0, i, 7);
			data[i][8] = config.getData(0, i, 8);
			data[i][9] = config.getData(0, i, 9);

			data[i][10] = config.getData(0, i, 10);
			data[i][11] = config.getData(0, i, 11);
			data[i][12] = config.getData(0, i, 12);
			data[i][13] = config.getData(0, i, 13);
		}
		return data;
	}

	/*
	 * This tearDown method will capture the screenshot when the test fails
	 */

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = ScreenshotPage.captureScreenshots(driver, "Screenshot" + i);

			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		}

		extent.flush();
		i++;
		// driver.quit();
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	/*
	 * this afterTest() method will close the driver when test is completed
	 */

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuite() {

	}

}
