package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SpinnerDemo {

	AndroidDriver<MobileElement> driver;
	

	@BeforeTest
	public void launchApp() throws MalformedURLException {

//		1. Launch API demos app
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		cap.setCapability("noReset", true);
		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

	}
	
	@Test
	public void selectColourAndPlanetfromSpinner() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		2. Click on API Demos
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		
//		3. Click on Views
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
//		4. Click on Spinner
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
		
		
//		5. Select on 'Yellow' from 1st dropdown
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();
		
//		6. Select on 'Earth' from 2nd dropdown
		
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();
		
		
	}






}
