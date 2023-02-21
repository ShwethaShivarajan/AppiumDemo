package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void launchApplication() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity"); // main activity name
		cap.setCapability("noReset", true); // do not reset the app everytime we launch i.e.to avoid I accept agreement
											// everytime
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap); // host and port num of the appium
																					// server
	}

	@Test(priority=0)
	public void verifyAddition() {

		// enter digit 9
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();

		// click + symbol
		driver.findElementByAccessibilityId("plus").click();

		// enter digit 5
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();

		// press equals
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();

		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);

		String expectedResult = "14";
		System.out.println("Actual Result is " + actualResult);

		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority=1)
	public void verifyMultiplication() {

		// enter digit 5
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();

		// click * symbol
		driver.findElementByAccessibilityId("multiply").click();

		// enter digit 4
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();

		// press equals
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();

		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);

		String expectedResult = "20";
		System.out.println("Actual Result is " + actualResult);

		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority=2)
	public void verifyDeleteButtonisPresent() {
		boolean clearBtnPresent = driver.findElement(By.id("com.miui.calculator:id/btn_del_s")).isDisplayed();
		Assert.assertTrue(clearBtnPresent);
	}

	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
}
