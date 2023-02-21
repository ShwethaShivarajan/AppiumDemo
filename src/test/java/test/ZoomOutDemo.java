package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZoomOutDemo {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void launchApp() throws MalformedURLException {

//		1. Launch app
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

	}

	@Test
	public void zoomOut() throws InterruptedException {
		
		Thread.sleep(8000);

		

		// swipe from right to left
		TouchAction<?> ta1 = new TouchAction<>(driver);
		ta1.press(PointOption.point(204, 1197)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(438, 1076)).release();

		

		// swipe from left to right
		TouchAction<?> ta2 = new TouchAction<>(driver);
		ta2.press(PointOption.point(1042, 1080)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(563, 1138)).release();
		
		
		MultiTouchAction ma = new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		
	}
}
