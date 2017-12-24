//import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolsQaDemo {

	WebDriver driver;
	String baseURl = "http://toolsqa.com/automation-practice-form/";

	@BeforeClass
	public void startBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Selenium\\practice\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testQaDemo() throws InterruptedException {

		// go to test page
		driver.get(baseURl);

		// because on on my test page tab
		// reference variable to test page
		// String testPageTab = driver.getWindowHandle();

		System.out.println("Verifying homepage title...\n");
		String homepageTitle = driver.getTitle();
		System.out.println("Current page title: " + homepageTitle);
		Assert.assertEquals(homepageTitle,
				"Demo Form for practicing Selenium Automation");

		System.out.println("Verifying homepage url...");
		String homepageURL = driver.getCurrentUrl();
		System.out.println("Current page url: " + homepageURL);
		Assert.assertEquals(homepageURL,
				"http://toolsqa.com/automation-practice-form/");

		System.out.println("Verifying if the homepage image is showing\n");

		WebElement homePageImage = driver.findElement(By
				.className("preload-me"));

		boolean isHomepageisDisplayed = homePageImage.isDisplayed();
		System.out.println("Homepage image displayed: " + isHomepageisDisplayed
				+ "\n");

		// System.out.println("verifying social media bars");

		WebElement contactAddress = driver.findElement(By.className("address"));

		boolean isAddressEnabled = contactAddress.isEnabled();

		System.out.println("Contact address enabled: " + isAddressEnabled
				+ "\n");

		if (isAddressEnabled == true) {

			System.out.println("The location is " + contactAddress.getText()
					+ "\n");
			// contactAddress.click();
			// driver.navigate().back();
			// Thread.sleep(5000);

		}

		WebElement contactPhone = driver.findElement(By.className("phone"));

		boolean isPhoneEnabled = contactPhone.isEnabled();

		System.out.println("Phone number enabled: " + isPhoneEnabled + "\n");

		if (isPhoneEnabled == true) {

			System.out.println("The phone number is " + contactPhone.getText()
					+ "\n");
			// contactPhone.click();
			// driver.navigate().back();
			// Thread.sleep(5000);

		}
		WebElement contactEmail = driver.findElement(By.className("email"));

		boolean isemailEnable = contactEmail.isEnabled();

		System.out.println("Email enabled: " + isemailEnable + "\n");

		if (isemailEnable == true) {

			System.out.println("The email is " + contactEmail.getText() + "\n");

		}

		WebElement facebookHeaderLink = driver.findElement(By
				.className("facebook"));

		boolean isFacebookLinkEnabled = facebookHeaderLink.isEnabled();

		System.out.println("Facebook header enabled: " + isFacebookLinkEnabled
				+ "\n");

		if (isFacebookLinkEnabled == true) {

			facebookHeaderLink.click();
			Thread.sleep(5000);
			// reference to facebook tab
			String facebookTab = driver.getWindowHandle();

			System.out.println("Facebook tab window handle value: "
					+ facebookTab);

			driver.switchTo().window(facebookTab);

			Thread.sleep(5000);

		}

		WebElement twitterHeaderLink = driver.findElement(By
				.className("twitter"));

		boolean isTwitterHeaderLinkEnabled = twitterHeaderLink.isEnabled();
		System.out.println("twitter header enabled: "
				+ isTwitterHeaderLinkEnabled + "\n");

		if (isTwitterHeaderLinkEnabled == true) {

			twitterHeaderLink.click();

			Thread.sleep(5000);

			String twitterTab = driver.getWindowHandle();

			System.out.println("Twitter tab window handle value: " + twitterTab
					+ "\n");

			driver.switchTo().window(twitterTab);

			Thread.sleep(5000);

		}

		WebElement googleHeaderLink = driver
				.findElement(By.className("google"));

		boolean isGoogleHeaderLinkEnabled = googleHeaderLink.isEnabled();

		if (isGoogleHeaderLinkEnabled == true) {

			// reference tab for google
			// String googleTab = driver.getWindowHandle();

			googleHeaderLink.click();

			Thread.sleep(5000);

			String googleTab = driver.getWindowHandle();

			System.out.println("Google tab window handle value: " + googleTab
					+ "\n");
			// driver.switchTo().window(googleTab).close();
			// driver.get(baseURl);

			Thread.sleep(5000);

		}

		// ///////////////////////////// START HERE TODAY
		// /////////////////////////////////////

		ArrayList<String> windowTabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(3));
		Thread.sleep(5000);

		File facebookPageImage = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {

			org.apache.commons.io.FileUtils
					.copyFile(
							facebookPageImage,
							new File(
									"C:\\Users\\SABBIR CHOWDHURY\\Desktop\\DemoSiteImages\\facebookImage.png"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		driver.close();

		driver.switchTo().window(windowTabs.get(2));
		Thread.sleep(5000);

		File TwitterPageImage = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {
			org.apache.commons.io.FileUtils
					.copyFile(
							TwitterPageImage,
							new File(
									"C:\\Users\\SABBIR CHOWDHURY\\Desktop\\DemoSiteImages\\twitterImage.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();

		driver.switchTo().window(windowTabs.get(1));
		Thread.sleep(5000);

		File googlePageImage = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {

			org.apache.commons.io.FileUtils
					.copyFile(
							googlePageImage,
							new File(
									"C:\\Users\\SABBIR CHOWDHURY\\Desktop\\DemoSiteImages\\googleImage.png"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		driver.close();

		driver.switchTo().window(windowTabs.get(0));

		// driver.switchTo().window(testPageTab);

		// number of tabs opened

		int numberOfTabsOpened = driver.getWindowHandles().size();

		System.out.println("Number of tabs opened: " + numberOfTabsOpened
				+ "\n");

		Thread.sleep(2000);

		WebElement firstNameInput = driver.findElement(By.name("firstname"));

		firstNameInput.clear();

		firstNameInput.sendKeys("John");

		Thread.sleep(2000);

		WebElement lastNameInput = driver.findElement(By.name("lastname"));

		lastNameInput.clear();

		lastNameInput.sendKeys("Doe");

		Thread.sleep(2000);
		/*
		 * WebElement SexMale = driver.findElement(By.id("sex-0"));
		 * SexMale.click(); Thread.sleep(2000);
		 * 
		 * System.out.println("Male is selected?" + SexMale.isSelected());
		 * 
		 * WebElement SexFemale = driver.findElement(By.id("sex-1"));
		 * SexFemale.click(); Thread.sleep(2000);
		 * 
		 * System.out.println("Male is selected?" + SexFemale.isSelected());
		 * 
		 * /* driver.switchTo().window(mainWindowHandle);
		 * driver.findElement(By.cssSelector("body")) .sendKeys(Keys.CONTROL +
		 * "\t"); driver.switchTo().defaultContent();
		 */
		// for(int i = 0; i < navBar.size(); i++){

		// }

		boolean isChecked = false;

		List<WebElement> yearExperienceRadio = driver
				.findElements(By
						.xpath("//input [contains (@type , 'radio') and contains (@name, 'exp')]"));

		int size = yearExperienceRadio.size();

		for (int i = 0; i < size; i++) {
			isChecked = yearExperienceRadio.get(i).isSelected();

			if (!isChecked) {
				yearExperienceRadio.get(i).click();
				Thread.sleep(2000);

			}

		}

		WebElement datePicker = driver.findElement(By.id("datepicker"));

		boolean isDatePickerDisplayed = datePicker.isDisplayed();

		if (isDatePickerDisplayed == true) {

			datePicker.clear();

			datePicker.sendKeys("10/05/2020");

		}

		boolean isProfessionChecked = false;

		List<WebElement> professionCheckBox = driver
				.findElements(By
						.xpath("//input[contains(@name, 'profession') and contains(@type, 'checkbox')]"));

		int numberOfProfessions = professionCheckBox.size();

		for (int i = 0; i < numberOfProfessions; i++) {

			isProfessionChecked = professionCheckBox.get(i).isSelected();

			if (!isProfessionChecked)
				professionCheckBox.get(i).click();
			Thread.sleep(2000);
		}

		boolean isAutomationChecked = false;

		List<WebElement> automationCheckBoxes = driver
				.findElements(By
						.xpath("//input[contains(@name,'tool') and contains(@type,'checkbox')]"));

		int numberofTools = automationCheckBoxes.size();

		for (int i = 0; i < numberofTools; i++)

		{
			if (!isAutomationChecked)
				automationCheckBoxes.get(i).click();
			Thread.sleep(2000);
		}

		Select continentDropdown = new Select(driver.findElement(By
				.id("continents")));

		// List<Select> continentDropdown = new
		// List<Select>(driver.findElements(By.id("continent")));

		continentDropdown.selectByVisibleText("South America");

		continentDropdown.selectByVisibleText("Europe");

		WebElement submitButton = driver.findElement(By.id("submit"));

		boolean isSubmitButtonEnabled = submitButton.isEnabled();

		if (isSubmitButtonEnabled == true) {

			System.out.println("Submit button is enalbed: "
					+ isSubmitButtonEnabled);

			submitButton.click();

		} else {

			System.out.println("Submit button is disabled at this time");

		}

	}

	@AfterClass
	public void endbrowser() {
		driver.quit();
	}

}
