//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolsQaDemo {

	WebDriver driver;
	String baseURl;

	@BeforeClass
	public void startBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Selenium\\practice\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURl = "http://toolsqa.com/automation-practice-form/";

	}

	@Test
	public void testQaDemo() throws InterruptedException {

		// go to test page
		driver.get(baseURl);

		// because on on my test page tab
		// reference variable to test page
		String testPageTab = driver.getWindowHandle();

		System.out.println("Verifying homepage title...");
		String homepageTitle = driver.getTitle();
		System.out.println("Current page title: " + homepageTitle);
		Assert.assertEquals(homepageTitle,
				"Demo Form for practicing Selenium Automation");

		System.out.println("Verifying homepage url...");
		String homepageURL = driver.getCurrentUrl();
		System.out.println("Current page url: " + homepageURL);
		Assert.assertEquals(homepageURL,
				"http://toolsqa.com/automation-practice-form/");

		System.out.println("Verifying if the homepage image is showing");

		WebElement homePageImage = driver.findElement(By
				.className("preload-me"));

		boolean isHomepageisDisplayed = homePageImage.isDisplayed();
		System.out
				.println("Homepage image displayed: " + isHomepageisDisplayed);

		// System.out.println("verifying social media bars");

		WebElement contactAddress = driver.findElement(By.className("address"));

		boolean isAddressEnabled = contactAddress.isEnabled();

		System.out.println("Contact address enabled: " + isAddressEnabled);

		if (isAddressEnabled == true) {

			System.out.println("The location is " + contactAddress.getText());
			// contactAddress.click();
			// driver.navigate().back();
			// Thread.sleep(5000);

		}

		WebElement contactPhone = driver.findElement(By.className("phone"));

		boolean isPhoneEnabled = contactPhone.isEnabled();

		System.out.println("Phone number enabled: " + isPhoneEnabled);

		if (isPhoneEnabled == true) {

			System.out.println("The phone number is " + contactPhone.getText());
			// contactPhone.click();
			// driver.navigate().back();
			// Thread.sleep(5000);

		}
		WebElement contactEmail = driver.findElement(By.className("email"));

		boolean isemailEnable = contactEmail.isEnabled();

		System.out.println("Email enabled: " + isemailEnable);

		if (isemailEnable == true) {

			System.out.println("The email is " + contactEmail.getText());

		}

		WebElement facebookHeaderLink = driver.findElement(By
				.className("facebook"));

		boolean isFacebookLinkEnabled = facebookHeaderLink.isEnabled();

		System.out.println("Facebook header enabled: " + isFacebookLinkEnabled);

		if (isFacebookLinkEnabled == true) {

			// reference to facebook tab
			String facebookTab = driver.getWindowHandle();
			facebookHeaderLink.click();
			Thread.sleep(2000);
			driver.switchTo().window(facebookTab).close();
			// driver.navigate().back();
			driver.get(baseURl);
			Thread.sleep(2000);
		}

		WebElement twitterHeaderLink = driver.findElement(By
				.className("twitter"));

		boolean isTwitterHeaderLinkEnabled = twitterHeaderLink.isEnabled();
		System.out.println("twitter header enabled: "
				+ isTwitterHeaderLinkEnabled);

		if (isTwitterHeaderLinkEnabled == true) {

			String twitterTab = driver.getWindowHandle();
			Thread.sleep(2000);
			twitterHeaderLink.click();
			driver.switchTo().window(twitterTab).close();
			// driver.navigate().back();
			driver.get(baseURl);
			Thread.sleep(5000);

		}

		WebElement googleHeaderLink = driver
				.findElement(By.className("google"));

		boolean isGoogleHeaderLinkEnabled = googleHeaderLink.isEnabled();

		if (isGoogleHeaderLinkEnabled == true) {

			//reference tab for google
			String googleTab = driver.getWindowHandle();
			Thread.sleep(2000);
			googleHeaderLink.click();
			driver.switchTo().window(googleTab).close();
			driver.get(baseURl);
			Thread.sleep(5000);

		}

		driver.switchTo().window(testPageTab);

		// number of tabs opened
		driver.getWindowHandles().size();

		// iver.switchTo().window(tabs ())

		WebElement firstNameInput = driver.findElement(By.name("firstname"));

		firstNameInput.clear();

		firstNameInput.sendKeys("John");

		WebElement lastNameInput = driver.findElement(By.name("lastname"));

		lastNameInput.clear();

		lastNameInput.sendKeys("Doe");

		/*
		 * driver.switchTo().window(mainWindowHandle);
		 * driver.findElement(By.cssSelector("body")) .sendKeys(Keys.CONTROL +
		 * "\t"); driver.switchTo().defaultContent();
		 */
		// for(int i = 0; i < navBar.size(); i++){

		// }

	}

	@AfterClass
	public void endbrowser() {
		driver.quit();
	}

}
