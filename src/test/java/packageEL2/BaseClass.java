package packageEL2;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(TestListener.class)
public class BaseClass {

	public static WebDriver driver;
	private static Scanner scanner;
	public static String OrderID = "";
	public static String parentWindow = "";
	public static ExtentReports reports;
	public static ExtentTest extentTest;
	public static String BOL_Order = "";
	public static String generatedId;

	@BeforeClass
	
	public void extentReportInitialization() {
		String path = System.getProperty("user.dir");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path + "/10_01_2026_Report/testReport.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeMethod
	public static void BrowserLaunch() {


		String chromeVersion = "154"; // Your actual Chrome version
		WebDriverManager.chromedriver().browserVersion(chromeVersion).setup();

		driver = new ChromeDriver();
		// --------------> UAT URL <-------------------
		driver.get("https://epicuatlb.estes-express.com/prweb/PRAuth/app/epic/vQbSpdBva3zBDbMlMRMsHQ*/!STANDARD");

		// --------------> Production URL <-------------------
		//driver.get("https://epic.estes-express.com/prweb/PRAuth/app/epic_/vQbSpdBva3zBDbMlMRMsHQ*/!STANDARD");
		driver.manage().window().maximize();
		
	}


	public static void init(Object page) {
		PageFactory.initElements(driver, page);
	}

	public static String scanner() {
		scanner = new Scanner(System.in);
		String otp = scanner.nextLine();
		System.out.println(otp + " is the received OTP");
		return otp;

	}

	public void getParentWindow() {
		parentWindow = driver.getWindowHandle();
	}

	public static void Windows_Launch() {
		// String handle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		for (String eachwindow : allwindow) {
			if (!eachwindow.equals(parentWindow)) {
				driver.switchTo().window(eachwindow);
			}
		}
	}

	public void switchToLatestWindow() {
	    // Get all window handles
	    Set<String> allWindows = driver.getWindowHandles();

	    // Convert to a list to access the last one
	    List<String> windowList = new ArrayList<>(allWindows);

	    // Switch to the newest window
	    driver.switchTo().window(windowList.get(windowList.size() - 1));
	}
	
	public static void Windows() {
		String handle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		for (String eachwindow : allwindow) {
			if (!eachwindow.equals(handle)) {
				driver.switchTo().window(eachwindow);
			}
		}
	}

	public static void waits(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeVisibleAndClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.visibilityOf(element)); // Wait until element is visible
		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until element is clickable
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

	public static void SelectClass_Reson(WebElement status2, String Reason_Dropdown) {
		Select SelectStatus2 = new Select(status2);
		SelectStatus2.selectByVisibleText(Reason_Dropdown);
	}

	public static void Calendarss() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("d");
		String date = format.format(calendar.getTime());
		WebElement CalClick = driver.findElement(By.xpath("//a[text()= '" + date + "']"));
		CalClick.click();
	}

	public static void Select2DaysagoDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		SimpleDateFormat format = new SimpleDateFormat("d");
		String date = format.format(calendar.getTime());
		WebElement CalClick = driver.findElement(By.xpath("//a[text()= '" + date + "']"));
		CalClick.click();
	}
	
//	public static void Select1DaysagoDate() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_MONTH, -1);
//		SimpleDateFormat format = new SimpleDateFormat("d");
//		String date = format.format(calendar.getTime());
//		WebElement CalClick = driver.findElement(By.xpath("//a[text()= '" + date + "']"));
//		CalClick.click();
//	}
	
	public static void Select1DaysagoDate() {

	    Calendar calendar = Calendar.getInstance();

	    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

	    if (currentDay == 1) {

	        // Move calendar UI to previous month
	        WebElement previousMonthButton = driver.findElement(
	            By.xpath("//span[@id='monthSpinner']//button[contains(@class,'spin-down')]")
	        );

	        previousMonthButton.click();

	        // Move Java calendar to previous month
	        calendar.add(Calendar.MONTH, -1);

	        // Get the last day of the previous month
	        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	        String date = String.valueOf(lastDay);

	        WebElement CalClick = driver.findElement(
	            By.xpath("//a[normalize-space(text())='" + date + "']")
	        );

	        CalClick.click();

	    } else {

	        // For day 2 onwards, simply select yesterday
	        int yesterday = currentDay - 1;

	        String date = String.valueOf(yesterday);

	        WebElement CalClick = driver.findElement(
	            By.xpath("//a[normalize-space(text())='" + date + "']")
	        );

	        CalClick.click();
	    }
	}

	public static void ScrollDown() {
		JavascriptExecutor ch = (JavascriptExecutor) driver;
		ch.executeScript("window.scrollBy(0,220)", " ");
		ch.executeScript("window.scrollBy(0,220)");
	}

	public static void ScrollDown2() {
		JavascriptExecutor ch = (JavascriptExecutor) driver;
		ch.executeScript("window.scrollBy(0,50)", " ");
		ch.executeScript("window.scrollBy(0,50)");
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

	public static void Action_Class(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void sendKeysJavascript(WebDriver driver, WebElement textArea, String filePath) {

		try {
			// Read the content of the XML file
			String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
			// Paste the XML content into the text area using JavaScript executor
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value = arguments[1];", textArea, fileContent);

			// Use JavaScript to confirm the textarea contains content
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(driver1 -> {
				String currentValue = (String) executor.executeScript("return arguments[0].value;", textArea);
				return currentValue != null && !currentValue.trim().isEmpty(); // Wait until it has content
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void webDriverWaitUsingLocator(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void Await() throws InterruptedException {
		Thread.sleep(4000);
	}

	public static void clickIgnoringStaleElementException(WebElement element) {
		int attempt = 0;
		while (attempt < 3) {
			try {
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempt++;
			}
		}
	}

	public String getdate(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat(format);
		return form.format(cal.getTime());
	}

	public void DFD_EFM_API() throws JsonProcessingException, IOException {
		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\DFD_EFM.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");
			// orderRefs.put("BOL", Math.ceil(Math.random() * 100000000));
			double ceil = Math.ceil(Math.random() * 100000000);
			BOL_Order = Double.toString(ceil);
			orderRefs.put("BOL", BOL_Order);

			orderRefs.put("TrackingNumber", Math.ceil(Math.random() * 100000000));
			orderRefs.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));

			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			RestAssured.baseURI = "https://epicuatlb.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			OrderID = split[1];
			System.out.println(OrderID);
			System.out.println("<------Result of DFD Json------>");
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);
		}

	}

	public void PADInbound_Order_API() throws JsonProcessingException, IOException {
		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\PAD_Inbound.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");
			// orderRefs.put("BOL", Math.ceil(Math.random() * 100000000));
			int bolNumber = (int) (Math.ceil(Math.random() * 100000000));
			BOL_Order = Integer.toString(bolNumber);
			orderRefs.put("BOL", BOL_Order);

			orderRefs.put("TrackingNumber", Math.ceil(Math.random() * 100000000));
			orderRefs.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));

			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			RestAssured.baseURI = "https://epicuatlb.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			OrderID = split[1];
			System.out.println(OrderID);
			System.out.println("<------Result of PAD Json------>");
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);
			extentTest.log(Status.PASS, "Created an PAD order: " + OrderID);
		}
	}

	public void PAD_XML_Write() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\PAD_Inbound.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList mlRouteNodes = doc.getElementsByTagName("MLRoute");
			Random randomID = new Random();
			int randomId1 = randomID.nextInt(10000);
			int randomId2 = randomID.nextInt(10000);
			generatedId = randomId1 + ":" + randomId2;
			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);
				String currentDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
				mlRouteElement.setAttribute("TStamp", currentDate);
				mlRouteElement.setAttribute("Id", generatedId);
			}

			// Update Job elements' attributes
			NodeList jobNodes = doc.getElementsByTagName("Job");
			for (int i = 0; i < jobNodes.getLength(); i++) {
				Element jobElement = (Element) jobNodes.item(i);
				jobElement.setAttribute("udolegid", BOL_Order);

				jobElement.setAttribute("Name", BOL_Order);

				jobElement.setAttribute("DispId", BOL_Order);
			}
			extentTest.log(Status.PASS, "Updated udolegid in PAD Inbound XML");
			extentTest.log(Status.PASS, "Updated Name in PAD Inbound XML");
			extentTest.log(Status.PASS, "Updated DispId in PAD Inbound XML");
			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();

			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);
			String xmlString = writer.toString();
			System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");
			extentTest.log(Status.PASS, "Updated PAD Inbound XML successfully");
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	
	public void PAD_RouteEnd_XML_Write() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\Route_End.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList mlRouteNodes = doc.getElementsByTagName("MLW");

			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);

				mlRouteElement.setAttribute("RouteId", generatedId);

			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();

			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);
			String xmlString = writer.toString();
			System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

	public void POD_SIGNATURE_XML_Write() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\EFM_POD_Signature.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			NodeList extensionNodes = doc.getElementsByTagName("Extension");
			for (int i = 0; i < extensionNodes.getLength(); i++) {
				Element extension = (Element) extensionNodes.item(i);
				// Find the element with the attribute "Name" equal to "UDOLEGID"
				String name = extension.getAttribute("Name");
				if (name.equals("UDOLEGID")) {
					// Change the value of the "Value" attribute
					extension.setAttribute("Value", OrderID);
				}
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

}
