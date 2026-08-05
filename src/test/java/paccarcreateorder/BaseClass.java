package paccarcreateorder;

import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(ListenersClass.class)
public class BaseClass {

	public static ExtentReports reports;
	public static WebDriver driver;
	public static String parentWindow = "";
	public static ExtentTest extentTest;
	
	@BeforeClass
	public void extentReportInitialization() {
		String path = System.getProperty("user.dir");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path + "/07_31_2026_Report/testReport.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeMethod
	public static void BrowserLaunch() {


		ChromeOptions options = new ChromeOptions();
		 
        // Set preferences to disable save passwords and address prompts
        options.addArguments("--disable-plugins");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "profile.password_manager_enabled", false,
                "profile.autofill_addresses", false,"profile.default_content_settings.popups", 0,"plugins.always_open_pdf_externally", true
                ,"download.prompt_for_download", false,"profile.password_manager_leak_detection", false
                ,"plugins.plugins_disabled", "Chrome PDF Viewer","credentials_enable_service", false,"autofill.profile_enabled", false
        ));
        

 
		String chromeVersion = "149"; // Your actual Chrome version
		WebDriverManager.chromedriver().browserVersion(chromeVersion).setup();

		driver = new ChromeDriver(options);
		// --------------> UAT URL <-------------------
		driver.get("https://epicuatlb.estes-express.com/prweb/PRAuth/app/epic/vQbSpdBva3zBDbMlMRMsHQ*/!STANDARD");

		driver.manage().window().maximize();
		
	}
	
	public static void init(Object page) {
		PageFactory.initElements(driver, page);
	}
	
	public static String Scannar() {
		Scanner scannar = new Scanner(System.in);
		String OTP = scannar.nextLine();
		System.out.println("Received OTP is - "+OTP);
		return OTP;
		
	}
	
	public static void webDriverWait(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void webDriverWaitByWebElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void getParentWindow() {
		parentWindow = driver.getWindowHandle();
	}
	
	public static void Await() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public static void windowToBeSwitchToCurrentWindow() {
		
		String handle = driver.getWindowHandle();
	Set<String> allwindow =	driver.getWindowHandles();
	
	for(String eachwindow : allwindow) {
		if (!eachwindow.equals(handle)) {
			driver.switchTo().window(eachwindow);
		}
	}

 }
	public static void scrollToElementAndClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
			Thread.sleep(500); // Wait for scrolling to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.click();
	}
	
	public static void SelectClass(WebElement status, String Dropdown) {
		try {
			Select SelectStatus = new Select(status);
			SelectStatus.selectByVisibleText(Dropdown);

		} catch (StaleElementReferenceException e) {
			Select SelectStatus = new Select(status);
			SelectStatus.selectByVisibleText(Dropdown);
		}
	}
	
	public static void ScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
	}

}
