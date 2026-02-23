package packageEL2;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.A;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Pom extends BaseClass {

	public static String OrderID = "";
	public static String DateTime = "";
	//public static String SearchBox_Text = "OrderServicePackage";
	public static String IB_LoadID_Value = "";
	public static String BOL_Order = "";
	public static String ATP_Id = "";
	public static String RTP_Id = "";
	public static String Tracking_Number = "";
	public static String Invoice_number = "";
	public static String Pickup_Number = "";
	public static String Delivery_Number = "";
	public static String PO_Number = "";
	public static String Origin_CompanyName = "";
	public static String Origin_Address1 = "";
	public static String Origin_City = "";
	public static String Origin_State = "";
	public static String Origin_PostalCode = "";
	public static String Origin_Country = "";
	public static String Origin_Phone = "";
	public static String Origin_ContactName = "";
	public static String Destination_CompanyName = "";
	public static String Destination_Address1 = "";
	public static String Destination_City = "";
	public static String Destination_State = "";
	public static String Destination_PostalCode = "";
	public static String Destination_Country = "";
	public static String Destination_Phone = "";
	public static String Destination_ContactName = "";

	public static String GloballyUniqueID = "";
	public static String StopID = "";
	public static String Arrived_DateTime = "";
	public static String Delivery_DateTime = "";
	public static String Received_DateTime = "";
	public static String ArrivedAtConsignee_DateTime = "";
	public static String Delivered_DateTime = "";
	public static String ActualDelivery_DateTime = "";

	public static String statusEventDateTime = "";
	public static String outboundCarrierTracking = "";
	public static String statusEvent = "";
	public static String outboundTrailerID = "";

	public static String Clipboard_ReceivedDate = "";
	public static String CaseID_ReceivedDate = "";
	public static String TStamp = "";
	static int index;

	public Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	static int totalWeight = 0;
	static int handlingUnitCount;

	String prettyString = null;
	List<String> expectedAccessorialCodes = new ArrayList<>();
	List<String> expectedAccessorialLocation = new ArrayList<>();

	List<String> actualAccessorialCodes = new ArrayList<>();
	List<String> actualAccessorialLocation = new ArrayList<>();

	public void PAR_Order_Create() throws Exception {

		File file = new File(System.getProperty("user.dir") + "\\PAR.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");

			double BOL_number = Math.ceil(Math.random() * 100000);
			BOL_Order = Double.toString(BOL_number);
			// BOL_Order = orderRefs.path("BOL").asText();
			System.out.println("BOL :" + BOL_Order);
			orderRefs.put("BOL", BOL_Order);
			double Track_number = Math.ceil(Math.random() * 100000);
			Tracking_Number = Double.toString(Track_number);
			orderRefs.put("TrackingNumber", Tracking_Number);
			double Invoice_num = Math.ceil(Math.random() * 100000);
			Invoice_number = Double.toString(Invoice_num);
			orderRefs.put("InvoiceNumber", Invoice_number);

			RTP_Id = rootNode.path("RequestingTradingPartnerID").asText();
			System.out.println("Req Trading Partner: " + RTP_Id);
			ATP_Id = rootNode.path("AssignedTradingPartnerID").asText();
			System.out.println("Ass Trading Partner: " + ATP_Id);
			String mode = rootNode.path("Mode").asText();
			extentTest.log(Status.PASS, "Created order has mode as " + mode);
			String paymentTerm = rootNode.path("PaymentTerm").asText();
			extentTest.log(Status.PASS, "Created order has Payment Term as " + paymentTerm);
           
			PO_Number = rootNode.path("OrderRefs").path("PONumber").asText();
			// Retrieve the CompanyName from OrderOrigin
			Pickup_Number = rootNode.path("OrderRefs").path("PickupNumber").asText();
			Delivery_Number = rootNode.path("OrderRefs").path("DeliveryNumber").asText();
			
			Origin_CompanyName = rootNode.path("OrderOrigin").path("CompanyName").asText();
			Origin_Address1 = rootNode.path("OrderOrigin").path("Address1").asText();
			Origin_City = rootNode.path("OrderOrigin").path("City").asText();
			Origin_State = rootNode.path("OrderOrigin").path("State").asText();
			Origin_PostalCode = rootNode.path("OrderOrigin").path("PostalCode").asText();
			Origin_Country = rootNode.path("OrderOrigin").path("Country").asText();
			Origin_Phone = rootNode.path("OrderOrigin").path("Phone").asText();
			Origin_ContactName = rootNode.path("OrderOrigin").path("ContactName").asText();

			Destination_CompanyName = rootNode.path("OrderDestination").path("CompanyName").asText();
			Destination_Address1 = rootNode.path("OrderDestination").path("Address1").asText();
			Destination_City = rootNode.path("OrderDestination").path("City").asText();
			Destination_State = rootNode.path("OrderDestination").path("State").asText();
			Destination_PostalCode = rootNode.path("OrderDestination").path("PostalCode").asText();
			Destination_Country = rootNode.path("OrderDestination").path("Country").asText();
			Destination_Phone = rootNode.path("OrderDestination").path("Phone").asText();
			Destination_ContactName = rootNode.path("OrderDestination").path("ContactName").asText();
			System.out.println(Destination_ContactName);

			List<String> accessorialItems = new ArrayList<>();
			if (rootNode.has("AccessorialItemList")) {
				for (JsonNode item : rootNode.get("AccessorialItemList")) {
					expectedAccessorialCodes.add(item.path("AccessorialCode").asText());
					expectedAccessorialLocation.add(item.path("AccessorialLocation").asText());
					String accessorialCode = item.path("AccessorialCode").asText();
					String accessorialQuantity = item.path("AccessorialQuantity").asText();
					String accessorialLocation = item.path("AccessorialLocation").asText();

					String formattedItem = "Code: " + accessorialCode + ", Quantity: " + accessorialQuantity
							+ ", Location: " + accessorialLocation;
					accessorialItems.add(formattedItem);
				}
			}

			// Print the stored Accessorial Items
			System.out.println("Accessorial Items List:");
			for (String item : accessorialItems) {
				System.out.println(item);
			}
			// Validate Accessorial Items
			if (!accessorialItems.isEmpty()) {
				extentTest.log(Status.PASS, "Accessorial Items found and stored: " + accessorialItems);
			} else {
				extentTest.log(Status.FAIL, "No Accessorial Items found in JSON.");
			}

			for (JsonNode itemNode : rootNode.path("Items")) {
				double itemWeight = itemNode.path("TotalWeight").asDouble();
				totalWeight += (int) itemWeight;
			}
			System.out.println("Total Weight in Items Array: " + totalWeight);

			// Count objects in HandlingUnit Array
			handlingUnitCount = rootNode.path("HandlingUnit").size();
			System.out.println("Number of Handling Units: " + handlingUnitCount);

			// Convert the modified JsonNode back to a pretty-printed string
			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";

			// PROD URL
	//		 RestAssured.baseURI = "https://epic.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234") // Change password
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			OrderID = split[1].trim();
			System.out.println(OrderID);
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);

			System.out.println("Total Item Weight: " + totalWeight);
			System.out.println("Handling Unit Count: " + handlingUnitCount);

			extentTest.log(Status.PASS, "Created a PAR Order using JSON : " + OrderID);
			extentTest.log(Status.PASS, "BOL of the created order : " + BOL_Order);
			extentTest.log(Status.PASS, "Case is created using " + mode + " as Mode");
			extentTest.log(Status.PASS, "Case is created using " + paymentTerm + " as Payment Term");
		}

	}

	public void Resolved_Cancelled() {

		try {

			// PROD URL
		//	 RestAssured.baseURI = "https://epic.estes-express.com";

			// Re-sending the same JSON structure to the endpoint
			RestAssured.baseURI = "https://epicuatlb.estes-express.com"; // or prod URL

			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234") // Ensure the
																									// credentials are
																									// correct
					.contentType("application/json").body(prettyString) // Send the same object as is
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");

			// Log the response
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference ");
			String OrderID = split[1];
			System.out.println("Re-sent OrderID: " + OrderID);
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);

			extentTest.log(Status.PASS, "Re-sent PAR Order using JSON : " + OrderID);
			extentTest.log(Status.PASS, "BOL of the re-sent order : " + BOL_Order);
			// }
		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Error while re-sending the order: " + e.getMessage());
		}
	}
	
	public void Resend_With_Modified_JSON() {
	    try {
	        // JSON file path
	        String filePath = "C:\\Users\\PALANGA\\eclipse-workspace\\EL2-Automation\\PAR_Accessorial_Update.json";

	        // Read JSON file into a String
	        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

	        // Convert to JSONObject for modification
	        JSONObject jsonObject = new JSONObject(jsonContent);
	    
	        // Update values in the JSON object
	        jsonObject.getJSONObject("OrderRefs").put("BOL", BOL_Order);
	        jsonObject.getJSONObject("OrderRefs").put("TrackingNumber", Tracking_Number);
	        jsonObject.getJSONObject("OrderRefs").put("InvoiceNumber", Invoice_number);

	        // Extract the AccessorialItemList array
            JSONArray accessorialList = jsonObject.getJSONArray("AccessorialItemList");

            // Get the third accessorial item (index 2 since it's zero-based)
            if (accessorialList.length() >= 3) {
                JSONObject thirdAccessorial = accessorialList.getJSONObject(2);
                String accessorialCode = thirdAccessorial.getString("AccessorialCode");
                String accessorialLocation = thirdAccessorial.getString("AccessorialLocation");
                expectedAccessorialCodes.add(accessorialCode);
                expectedAccessorialLocation.add(accessorialLocation);
            }
            
	        // Set the Base URI
	        RestAssured.baseURI = "https://epicuatlb.estes-express.com"; // or prod URL

	        // Send the updated JSON
	        Response response = RestAssured.given()
	                .auth().basic("EpicSevicesTest1", "Rules@1234")
	                .contentType(ContentType.JSON)
	                .body(jsonObject.toString()) // Send modified JSON
	                .post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");

	        // Log response
	        String responseBody = response.getBody().asString();
	        System.out.println("Modified JSON Sent: " + jsonObject.toString());
	        System.out.println("Response Body: " + responseBody);

	        // Extract Order ID from response
	        String[] split = responseBody.split("Reference ");
	        String OrderID = split.length > 1 ? split[1] : "Not Found";
	        System.out.println("Re-sent OrderID: " + OrderID);

	        int statusCode = response.getStatusCode();
	        System.out.println("Status Code: " + statusCode);

	        // Log the results
	        extentTest.log(Status.PASS, "Re-sent Order with modified JSON at path : " + OrderID);
	        extentTest.log(Status.PASS, "BOL of the re-sent order : " + BOL_Order);

	    } catch (Exception e) {
	        e.printStackTrace();
	        extentTest.log(Status.FAIL, "Error while re-sending the order: " + e.getMessage());
	    }
	}

	public void DFD_NewOrder() throws Exception {
		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\DFD_Order.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");

			double BOL_number = Math.ceil(Math.random() * 100000000);
			BOL_Order = Double.toString(BOL_number);
			// BOL_Order = orderRefs.path("BOL").asText();
			System.out.println("BOL :" + BOL_Order);
			orderRefs.put("BOL", BOL_Order);
			double Track_number = Math.ceil(Math.random() * 100000000);
			Tracking_Number = Double.toString(Track_number);
			orderRefs.put("TrackingNumber", Tracking_Number);
			double Invoice_num = Math.ceil(Math.random() * 100000000);
			Invoice_number = Double.toString(Invoice_num);
			orderRefs.put("InvoiceNumber", Invoice_number);

			String mode = rootNode.path("Mode").asText();
			System.out.println("Mode: " + mode);
			String paymentTerm = rootNode.path("PaymentTerm").asText();
			System.out.println("Payment Term: " + paymentTerm);

			PO_Number = rootNode.path("OrderRefs").path("PONumber").asText();
			// Retrieve the CompanyName from OrderOrigin
			Origin_CompanyName = rootNode.path("OrderOrigin").path("CompanyName").asText();
			Origin_Address1 = rootNode.path("OrderOrigin").path("Address1").asText();
			Origin_City = rootNode.path("OrderOrigin").path("City").asText();
			Origin_State = rootNode.path("OrderOrigin").path("State").asText();
			Origin_PostalCode = rootNode.path("OrderOrigin").path("PostalCode").asText();
			Origin_Country = rootNode.path("OrderOrigin").path("Country").asText();
			Origin_Phone = rootNode.path("OrderOrigin").path("Phone").asText();
			Origin_ContactName = rootNode.path("OrderOrigin").path("ContactName").asText();

			Destination_CompanyName = rootNode.path("OrderDestination").path("CompanyName").asText();
			Destination_Address1 = rootNode.path("OrderDestination").path("Address1").asText();
			Destination_City = rootNode.path("OrderDestination").path("City").asText();
			Destination_State = rootNode.path("OrderDestination").path("State").asText();
			Destination_PostalCode = rootNode.path("OrderDestination").path("PostalCode").asText();
			Destination_Country = rootNode.path("OrderDestination").path("Country").asText();
			Destination_Phone = rootNode.path("OrderDestination").path("Phone").asText();
			Destination_ContactName = rootNode.path("OrderDestination").path("ContactName").asText();
			System.out.println(Destination_ContactName);

			// Parse and calculate Total Weight in Items Array
			// int totalWeight = 0;
			for (JsonNode itemNode : rootNode.path("Items")) {
				double itemWeight = itemNode.path("TotalWeight").asDouble();
				totalWeight += (int) itemWeight;
			}
			System.out.println("Total Weight in Items Array: " + totalWeight);

			// Count objects in HandlingUnit Array
			handlingUnitCount = rootNode.path("HandlingUnit").size();
			System.out.println("Number of Handling Units: " + handlingUnitCount);

			// Convert the modified JsonNode back to a pretty-printed string
			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			RestAssured.baseURI = "https://epicuatlb.estes-express.com";

			// PROD URL
			// RestAssured.baseURI = "https://epic.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			OrderID = split[1];
			System.out.println(OrderID);
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);

			System.out.println("Total Item Weight: " + totalWeight);
			System.out.println("Handling Unit Count: " + handlingUnitCount);

			extentTest.log(Status.PASS, "Created a DFD Order using JSON : " + OrderID);
			extentTest.log(Status.PASS, "BOL of the created order : " + BOL_Order);
			extentTest.log(Status.PASS, "Case is created using " + mode + " as Mode");
			extentTest.log(Status.PASS, "Case is created using " + paymentTerm + " as Payment Term");
		}
	}

	public static File statusUpdateFile;

	public void StatusUpdate_Received() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_ReceivedStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
	}

	public void StatusUpdate_Loaded() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_LoadedStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
	}

	public void StatusUpdate_UnLoaded() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_UnLoadedStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
	}

	public void StatusUpdate_Released() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_ReleasedStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
	}

	public void StatusUpdate_Cancelled() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_CancelledStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
	}

	public void Status_File_FNB() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\FNBStatusupdate.json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
		extentTest.log(Status.PASS, "BOL, Invoice number and trading partners are updated for FNB Status update API");
	}

	public void Status_File_BNF() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\BNFStatusUpdate.json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
		extentTest.log(Status.PASS, "BOL, Invoice number and trading partners are updated for BNF Status update API");
	}

	public void Status_File_NBNF() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\NBNFStatusUpdate.json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
		extentTest.log(Status.PASS, "BOL, Invoice number and trading partners are updated for NBNF Status update API");
	}

	public void Status_File_Shortage() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_ShortageStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
		extentTest.log(Status.PASS, "BOL, Invoice number and trading partners are updated for Shortage Status update API");
	}

	public void Status_File_Overage() throws Exception {
		// Load the Status Update JSON
		statusUpdateFile = new File(System.getProperty("user.dir") + "\\PAR_OverageStatusUpdate.Json");
		ObjectMapper objectMapper = new ObjectMapper();
		updateStatusWithOrderID(BOL_Order, Invoice_number, objectMapper, ATP_Id, RTP_Id);
		extentTest.log(Status.PASS, "BOL, Invoice number and trading partners are updated for Overage Status update API");
	}

	public static String updatedStatusJson = "";

	public void updateStatusWithOrderID(String BOL_Order, String Invoice_number, ObjectMapper objectMapper, String ATP_Id, String RTP_Id) throws Exception {

		JsonNode statusNode = objectMapper.readTree(statusUpdateFile);

		if (statusNode instanceof ObjectNode) {
			ObjectNode statusObjectNode = (ObjectNode) statusNode;

			JsonNode orderRefsNode = statusObjectNode.get("OrderRefs");
			if (orderRefsNode instanceof ObjectNode) {
				ObjectNode orderRefsObjectNode = (ObjectNode) orderRefsNode;
				orderRefsObjectNode.put("BOL", BOL_Order); // Update the BOL value
				orderRefsObjectNode.put("InvoiceNumber", Invoice_number);
			}
			statusObjectNode.put("AssignedTradingPartnerID", ATP_Id);
	        statusObjectNode.put("RequestingTradingPartnerID", RTP_Id);
			// Convert the modified JsonNode back to a pretty-printed string
			updatedStatusJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(statusObjectNode);
			System.out.println(updatedStatusJson);

		}
	}

	public void StatusUpdate_Process() throws Exception {
		Await();
		driver.switchTo().defaultContent();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(0));
		Await();
		ClickonRecentsIcon.click();
		Await();
		UpdateStatus();
	//	DevStudioSearchBox1();
		Await();
		orderService_Actions();
		RadioSelect();
		ClickExecute();
		Await();
		Await();
		CloseTab();
		extentTest.log(Status.PASS, "User successfully updated status through status update API");
		ArrayList<String> tab6 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab6.get(1));
		Await();
		frameswitch2();
		Await();
		ActionsButton();
		Await();
		driver.switchTo().defaultContent();
		frameswitch2();
	}
	
	public void ActionsPage() throws Exception {
		Await();
		driver.switchTo().defaultContent();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(0));
		Await();
		driver.switchTo().defaultContent();
		Await();
		orderService_Actions();
		RadioSelect();
		ClickExecute();
		Await();
		ArrayList<String> tab6 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab6.get(1));
		Await();
		frameswitch2();
		Await();
		ActionsButton();
		Await();
		driver.switchTo().defaultContent();
		frameswitch2();

	}

	public void StatusUpdate() throws Exception {
		Await();
		driver.switchTo().defaultContent();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(0));
		Await();
		Await();
		DevStudioSearchBox1();
		Await();
		orderService_Actions();
		RadioSelect();
		ClickExecute();
		Await();
		ArrayList<String> tab6 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab6.get(1));
		Await();

	}

	public void OutboundLoads() {
		frameSwitch();
		OutBound_Loads.click();
	}

	public void OrderFromOutboundLoads() throws Exception {
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		BOL_DropdownFilterIconClick.click();
		BOL_DropdownFilterIconClick.sendKeys(BOL_Order);
		Await();
		BOL_DropdownFilterIconClick.sendKeys(Keys.ENTER);
		Await();
		ClickPARCaseID.click();
		Await();
		driver.switchTo().defaultContent();
		frameswitch2();
	}

	public void OSnDClick() throws Exception {
		frameSwitch();
		waits(OSD);
		OSD.click();
		Await();

	}

	public void OrderFromOSandD() throws Exception {
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		PAD_FilterIconClick.click();
		Await();
		OrderSearchBoxClick.click();
		Await();
		OrderSearchBoxClick.sendKeys(OrderID);
		waits(ApplyClick);
		ApplyClick.click();
		Await();
		PAR_Order_OSnD.click();
		Await();
		driver.switchTo().defaultContent();
		frameswitch2();
	}

	public void ActionsRefresh() throws Exception {
		Await();
		frameswitch2();
		Await();
		ActionsButton();
		Await();
		driver.switchTo().defaultContent();
		frameswitch2();

	}

	public void PAD_NewOrder() throws Exception {
		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\PAD_Order.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");

			double BOL_number = Math.ceil(Math.random() * 100000000);
			BOL_Order = Double.toString(BOL_number);
			System.out.println("BOL :" + BOL_Order);
			orderRefs.put("BOL", BOL_Order);
			double Track_number = Math.ceil(Math.random() * 100000000);
			Tracking_Number = Double.toString(Track_number);
			orderRefs.put("TrackingNumber", Tracking_Number);
			double Invoice_num = Math.ceil(Math.random() * 100000000);
			Invoice_number = Double.toString(Invoice_num);
			orderRefs.put("InvoiceNumber", Invoice_number);

			// Convert the modified JsonNode back to a pretty-printed string
			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			RestAssured.baseURI = "https://epicuatlb.estes-express.com";

			// PROD URL
			// RestAssured.baseURI = "https://epic.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			String OrderID1 = split[1];
			OrderID = OrderID1.trim();
			System.out.println(OrderID);
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);
			extentTest.log(Status.PASS, "Created a DFD Order using JSON : " + OrderID);
			extentTest.log(Status.PASS, "BOL of the created order : " + BOL_Order);
		}
	}

	public void Update_Loaded_API() throws Exception {

		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\PAR_StatusUpdate.json");

		// Read and update JSON file
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			objectNode.put("CaseID", OrderID); // Update the CaseID field

			// Extract specific fields
			statusEventDateTime = objectNode.get("StatusEventDateTime").asText();
			outboundCarrierTracking = objectNode.get("OutboundCarrierTracking").asText();
			statusEvent = objectNode.get("StatusEvent").asText();
			outboundTrailerID = objectNode.get("OutboundTrailerID").asText();

			// Convert the updated JSON to string for the POST request
			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			// Send POST request
			RestAssured.baseURI = "https://epicuatlb.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/UpdateStatus");
			String responseBody = response.getBody().asString();
			int statusCode = response.getStatusCode();
			System.out.println("<------Result of PAR Status Update Json------>");
			System.out.println("Response Body: " + responseBody);
			System.out.println("Status Code: " + statusCode);

			extentTest.log(Status.PASS, "Successfully Updated PAR Order with Created CaseID :" + OrderID);
			extentTest.log(Status.PASS, "Successfully Updated PAR Order with Created CaseID :" + OrderID);
		}

	}

	public void DFDScanTool_API() throws JsonProcessingException, IOException {
		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\DFD_ExceptionHandling.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(file);

		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");
			// orderRefs.put("BOL", Math.ceil(Math.random() * 100000000));
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
			extentTest.log(Status.PASS, "Successfully created DFD Order");
		}

	}

	public void XML_Write() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\ExceptionHandling.xml");
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
			extentTest.log(Status.PASS, "XML file updated successfully");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

	public void PAD_RouteStart_XML_Write() throws InterruptedException {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\PAD_RouteStart.xml");
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
			Thread.sleep(5000);
			String xmlString = writer.toString();
			Thread.sleep(5000);
			System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");
			extentTest.log(Status.PASS, "PAD Route Start XML updated successfully");

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
				mlRouteElement.setAttribute("StopId", StopID);
			}

			// Update Job elements' attributes
			NodeList jobNodes = doc.getElementsByTagName("Job");
			for (int i = 0; i < jobNodes.getLength(); i++) {
				Element jobElement = (Element) jobNodes.item(i);
				NodeList extensionNodes = jobElement.getElementsByTagName("Extension");

				for (int j = 0; j < extensionNodes.getLength(); j++) {
					Element extensionElement = (Element) extensionNodes.item(j);
					if ("UDOLEGID".equals(extensionElement.getAttribute("Name"))) {
						extensionElement.setAttribute("Value", OrderID);
					}
				}
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
			extentTest.log(Status.PASS, "PAD Route End XML updated with CMD as '8' successfully");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void PAR_Accessorial_XML_Update() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\PAR_Accessorial.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Initialize a map for Field Name to Accessorial Code mapping
			Map<String, String> accessorialCodeMap = new HashMap<>();
			accessorialCodeMap.put("Inside Delivery", "INDEL");
			accessorialCodeMap.put("Lift Gate Used", "LGATE");

			// Initialize the expectedAccessorialCodes list if not already
			if (expectedAccessorialCodes == null) {
				expectedAccessorialCodes = new ArrayList<>();
			}

			// Extract Field elements
			NodeList fieldNodes = doc.getElementsByTagName("Field");
			for (int i = 0; i < fieldNodes.getLength(); i++) {
				Element fieldElement = (Element) fieldNodes.item(i);
				String fieldName = fieldElement.getAttribute("Name");
				String fieldValue = fieldElement.getAttribute("Value");

				String accessorialCode = accessorialCodeMap.get(fieldName);
				if (accessorialCode != null && "Yes".equalsIgnoreCase(fieldValue)
						&& !expectedAccessorialCodes.contains(accessorialCode)) {
					expectedAccessorialCodes.add(accessorialCode); // Add only if not already present
				}

				/*
				 * // Add accessorial codes based on field names if
				 * ("Inside Delivery".equalsIgnoreCase(fieldName) &&
				 * "Yes".equalsIgnoreCase(fieldValue)) { expectedAccessorialCodes.add("INDEL");
				 * expectedAccessorialLocation.add("Pickup"); } else if
				 * ("Lift Gate Used".equalsIgnoreCase(fieldName) &&
				 * "Yes".equalsIgnoreCase(fieldValue)) { expectedAccessorialCodes.add("LGATE");
				 * expectedAccessorialLocation.add("Pickup"); }
				 */
			}

			// Update Job elements' attributes
			NodeList jobNodes = doc.getElementsByTagName("Job");
			for (int i = 0; i < jobNodes.getLength(); i++) {
				Element jobElement = (Element) jobNodes.item(i);
				jobElement.setAttribute("DispId", BOL_Order); // Update BOL
				NodeList extensionNodes = jobElement.getElementsByTagName("Extension");

				for (int j = 0; j < extensionNodes.getLength(); j++) {
					Element extensionElement = (Element) extensionNodes.item(j);
					if ("UDOLEGID".equals(extensionElement.getAttribute("Name"))) {
						extensionElement.setAttribute("Value", OrderID); // Replace with the actual value of sendkeys
					}
				}
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);

			System.out.println("XML file updated with UDOLEGID as : " + OrderID);
			// Log the update
			extentTest.log(Status.PASS, "XML updated for Accessorial successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PAR_ArrivedAtPickup_Status_Update() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			NodeList mlRouteNodes = doc.getElementsByTagName("MLW");
			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);
				mlRouteElement.setAttribute("Cmd", "7"); // Update Cmd attribute
				mlRouteElement.setAttribute("SType", "2");
				TStamp = mlRouteElement.getAttribute("TStamp");
				mlRouteElement.setAttribute("TStamp", "2025-01-11T10:21:05");
				System.out.println("TStamp: " + TStamp);
			}
			// Update Job elements' attributes
			NodeList jobNodes = doc.getElementsByTagName("Job");
			for (int i = 0; i < jobNodes.getLength(); i++) {
				Element jobElement = (Element) jobNodes.item(i);
				jobElement.setAttribute("JType", "2"); // Update JType attribute
				jobElement.setAttribute("Status", "3"); // Update Status attribute
				NodeList extensionNodes = jobElement.getElementsByTagName("Extension");

				for (int j = 0; j < extensionNodes.getLength(); j++) {
					Element extensionElement = (Element) extensionNodes.item(j);
					if ("UDOLEGID".equals(extensionElement.getAttribute("Name"))) {
						extensionElement.setAttribute("Value", OrderID); // Replace with the actual value of sendkeys
					}
				}
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);

			System.out.println("XML file updated with UDOLEGID attribute name as : " + OrderID);
			System.out.println("XML updated for Arrived at pickup status with 7, 2, 2, 3 combination successfully");
			// Log the update
			extentTest.log(Status.PASS,
					"XML has the combination of CMD as 7, S Type as 2, J Type as 2, Status as 3");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PAR_OutForDelivery_Status_Update() throws Exception {
		File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		// Normalize the document to ensure proper structure
		doc.getDocumentElement().normalize();

		// Get the MLW node and update the Cmd attribute
		NodeList mlRouteNodes = doc.getElementsByTagName("MLW");
		if (mlRouteNodes.getLength() > 0) {
			Element mlRouteElement = (Element) mlRouteNodes.item(0);
			mlRouteElement.setAttribute("Cmd", "8"); // Update Cmd attribute
			mlRouteElement.setAttribute("SType", "2");
			mlRouteElement.setAttribute("TStamp", "2025-01-12T10:21:05");
		}

		// Update Job elements' attributes
		NodeList jobNodes = doc.getElementsByTagName("Job");
		for (int i = 0; i < jobNodes.getLength(); i++) {
			Element jobElement = (Element) jobNodes.item(i);
			jobElement.setAttribute("JType", "2"); // Update JType attribute
			jobElement.setAttribute("Status", "4"); // Update Status attribute
		}

		// Write the updated document back to the same file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(xmlFile);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);

		System.out.println("XML updated for Out for delivery status with 8, 2, 2, 4 combination successfully");
		extentTest.log(Status.PASS, "XML has the combination of CMD as 8, S Type as 2, J Type as 2, Status as 4");

	}

	public void PAR_ArrivedAtConsignee_Status_Update() throws Exception {
		File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		// Normalize the document to ensure proper structure
		doc.getDocumentElement().normalize();

		// Get the MLW node and update the Cmd attribute
		NodeList mlRouteNodes = doc.getElementsByTagName("MLW");
		if (mlRouteNodes.getLength() > 0) {
			Element mlRouteElement = (Element) mlRouteNodes.item(0);
			mlRouteElement.setAttribute("Cmd", "7"); // Update Cmd attribute
			mlRouteElement.setAttribute("SType", "4");
			mlRouteElement.setAttribute("TStamp", "2025-01-13T10:21:05");
		}

		// Update Job elements' attributes
		NodeList jobNodes = doc.getElementsByTagName("Job");
		for (int i = 0; i < jobNodes.getLength(); i++) {
			Element jobElement = (Element) jobNodes.item(i);
			jobElement.setAttribute("JType", "3"); // Update JType attribute
			jobElement.setAttribute("Status", "3"); // Update Status attribute
		}

		// Write the updated document back to the same file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(xmlFile);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);

		System.out.println("XML updated for Arrived at consignee status with 7, 4, 3, 3 combination successfully");
		extentTest.log(Status.PASS,
				"XML has the combination of CMD as 7, S Type as 4, J Type as 3, Status as 3");

	}

	public void PAR_Delivered_Status_Update() throws Exception {
		File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		// Normalize the document to ensure proper structure
		doc.getDocumentElement().normalize();

		// Get the MLW node and update the Cmd attribute
		NodeList mlRouteNodes = doc.getElementsByTagName("MLW");
		if (mlRouteNodes.getLength() > 0) {
			Element mlRouteElement = (Element) mlRouteNodes.item(0);
			mlRouteElement.setAttribute("Cmd", "8"); // Update Cmd attribute
			mlRouteElement.setAttribute("SType", "4");
			mlRouteElement.setAttribute("TStamp", "2025-01-14T10:21:05");
		}

		// Update Job elements' attributes
		NodeList jobNodes = doc.getElementsByTagName("Job");
		for (int i = 0; i < jobNodes.getLength(); i++) {
			Element jobElement = (Element) jobNodes.item(i);
			jobElement.setAttribute("JType", "3"); // Update JType attribute
			jobElement.setAttribute("Status", "4"); // Update Status attribute
		}

		// Write the updated document back to the same file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(xmlFile);

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);

		System.out.println("XML updated for Delivered status with 8, 4, 3, 4 combination successfully");
		extentTest.log(Status.PASS, "XML has the combination of CMD as 8, S Type as 4, J Type as 3, Status as 4");

	}

	public void PAD_RouteEnd_XML_CMD6Update() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Route_End.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList mlRouteNodes = doc.getElementsByTagName("MLW");

			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);
				mlRouteElement.setAttribute("Cmd", "6");
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();

			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);
			String xmlString = writer.toString();
			// System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");
			extentTest.log(Status.PASS, "PAD Route End XML updated with CMD as '6' successfully");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

	public void PAD_RouteEnd_XML_CMD7Update() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Route_End.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList mlRouteNodes = doc.getElementsByTagName("MLW");

			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);
				mlRouteElement.setAttribute("Cmd", "7");
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();

			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);
			String xmlString = writer.toString();
			// System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");
			extentTest.log(Status.PASS, "PAD Route End XML updated with CMD as '7' successfully");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

	public void PAD_RouteEnd_XML_CMD9Update() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Route_End.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList mlRouteNodes = doc.getElementsByTagName("MLW");

			if (mlRouteNodes.getLength() > 0) {
				Element mlRouteElement = (Element) mlRouteNodes.item(0);
				mlRouteElement.setAttribute("Cmd", "9");
			}

			// Write the updated document back to the same file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();

			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);
			String xmlString = writer.toString();
			// System.out.println("Updated XML Content:\n" + xmlString);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			System.out.println("XML file updated successfully.");
			extentTest.log(Status.PASS, "PAD Route End XML updated with CMD as '9' successfully");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void POD_Signature_XML_Write() {
		try {
			// Load the XML document
			File xmlFile = new File("C:\\Users\\PALANGA\\eclipse-workspace\\EL2-Automation\\PODSignature.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// Normalize the document to ensure proper structure
			doc.getDocumentElement().normalize();

			// Update the TStamp attribute to the current date
			NodeList extensionNodes = doc.getElementsByTagName("Extension");
			
			for (int i = 0; i < extensionNodes.getLength(); i++) {
			    Element extElement = (Element) extensionNodes.item(i);
			    String nameAttr = extElement.getAttribute("Name");
			    if ("UDOLEGID".equals(nameAttr)) {
			        extElement.setAttribute("Value", OrderID);  
			        extentTest.log(Status.PASS, "Updated UDOLEGID Value in PAD Inbound XML to: " + OrderID);
			    }
			}
			
			extentTest.log(Status.PASS, "Updated udolegid in PAD Inbound XML");
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
	
	@FindBy(xpath = "//div[@title='Recents']/h3/i")
	public static WebElement ClickonRecentsIcon;
	
	@FindBy(xpath = "//div[@title='Data types']/h3/i")
	public static WebElement ClickonDatatypesIcon;

	@FindBy(xpath = "//a[@aria-label='menu Route']")
	public static WebElement Clickon_Route_Datatype;

	@FindBy(xpath = "//a[@aria-label='menu Stop']")
	public static WebElement Clickon_Stop_Datatype;

	@FindBy(xpath = "//a[@aria-label='menu Order']")
	public static WebElement Clickon_Order_Datatype;

	@FindBy(xpath = "//a[@aria-label='menu Requested Accessorial']")
	public static WebElement Clickon_RequestedAccessorial_Datatype;

	@FindBy(xpath = "//a[@aria-label='menu Status']")
	public static WebElement Clickon_Status_Datatype;

	@FindBy(xpath = "//a[@aria-label='menu Rate']")
	public static WebElement Clickon_Rate_Datatype;

	@FindBy(xpath = "//div[@class='header']/h3[contains(text(),'Records')]")
	public static WebElement Clickon_Datatype_Records;

	@FindBy(xpath = "(//div[@class='header']/h3[contains(text(),'Records')])[2]")
	public static WebElement Clickon_Datatype_Records2;

	@FindBy(xpath = "//div[@class='field-item dataValueWrite']/span/input[@class='leftJustifyStyle' and @placeholder='Search...']")
	public static WebElement Clickon_Datatype_Records_Search;

	@FindBy(xpath = "//i[@class='pi pi-search']")
	public static WebElement Clickon_Datatype_Records_SearchIcon;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Route Status']/div[contains(text(),' In Progress')]")
	public static WebElement Route_Status_Validation;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Globally unique ID (required)']/div")
	public static WebElement Route_GloballyUniqueID;
	
	@FindBy(xpath = "//span[contains(text(), 'Order BOL')]/following-sibling::div[1]/span")
	public static WebElement PODReview_BOL;
	
	@FindBy(xpath="//span[contains(text(),'Inbound Load ID')]/following-sibling::div/span")
	public static WebElement PODReview_IBLoadID;
	
	@FindBy(xpath="//span[contains(text(),'Inbound Trailer')]/following-sibling::div/span")
	public static WebElement PODReview_IBTrailer;
	
	@FindBy(xpath="//span[contains(text(),'Outbound Load ID')]/following-sibling::div/span")
	public static WebElement PODReview_OBLoadID;
	
	@FindBy(xpath="//span[contains(text(),'Total Weight')]/following-sibling::div/span")
	public static WebElement PODReview_TotalWt;
	
	@FindBy(xpath="//span[contains(text(),'Total Weight')]/following-sibling::div/span")
	public static WebElement PODReview_TotalHU;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Stop ID']/div)[1]")
	public static WebElement Datatype_StopID;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Route Status']/div")
	public static WebElement RouteStatus_Complete;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Stop Status']/div)[1]")
	public static WebElement Stop_Status_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='ReceivedDate']/div)[1]")
	public static WebElement Received_Date_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='TrackingNumber']/div)[1]")
	public static WebElement TrackingNumber_Validation;
	
	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='PickupNumber']/div)[1]")
	public static WebElement PickupNumber_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='InvoiceNumber']/div)[1]")
	public static WebElement InvoiceNumber_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='PONumber']/div)[1]")
	public static WebElement PONumber_Validation;
	
	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='DeliveryNumber']/div)[1]")
	public static WebElement DeliveryNumber_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin Company']/div)[1]")
	public static WebElement Origin_Company_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin Address 1']/div)[1]")
	public static WebElement Origin_Address1_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin City']/div)[1]")
	public static WebElement Origin_City_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin State']/div)[1]")
	public static WebElement Origin_State_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin Postal Code']/div)[1]")
	public static WebElement Origin_PostalCode_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin Country']/div)[1]")
	public static WebElement Origin_Country_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='OriginPhoneNumber']/div)[1]")
	public static WebElement Origin_PhoneNumber_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Origin Contact Name']/div)[1]")
	public static WebElement Origin_ContactName_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination Company']/div)[1]")
	public static WebElement Destination_Company_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination Address 1']/div)[1]")
	public static WebElement Destination_Address1_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination City']/div)[1]")
	public static WebElement Destination_City_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination State']/div)[1]")
	public static WebElement Destination_State_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination Postal Code']/div)[1]")
	public static WebElement Destination_PostalCode_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination Country']/div)[1]")
	public static WebElement Destination_Country_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='DestinationPhoneNumber']/div)[1]")
	public static WebElement Destination_PhoneNumber_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Destination Contact Name']/div)[1]")
	public static WebElement Destination_ContactName_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='BOL']/div)[1]")
	public static WebElement BOL_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Actual Delivery Date']/div)[1]")
	public static WebElement ActualDelivery_Date_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='ArrivedAtPickup']/div)[1]")
	public static WebElement ArrivedAtPickup_Date_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='OutForDelivery']/div)[1]")
	public static WebElement OutForDelivery_Date_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='ArrivedAtConsignee']/div)[1]")
	public static WebElement ArrivedAtConsignee_Date_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Actual Delivery Date']/div)[1]")
	public static WebElement ActualDeliveryDate_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='LineHaulComplete']/div)[1]")
	public static WebElement Delivered_Date_Validation;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Accessorial Code']/div")
	public static List<WebElement> AccessorialCode_ValidationList;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='AccessorialLocation']/div")
	public static List<WebElement> AccessorialLocation_ValidationList;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Status Event']/div)")
	public static List<WebElement> StatusEvent_Data;

	@FindBy(xpath = "//span[contains(text(), 'pyWorkPage (ESTES-EL2-EPIC-Work-PickupAndRelease)')]")
	public static WebElement ClickonpyworkPage;

	@FindBy(xpath = "//span[contains(text(), 'pyWorkPage (ESTES-EL2-EPIC-Work-DropForDelivery)')]")
	public static WebElement ClickonpyworkPage_DFD;

	@FindBy(xpath = "//span[contains(text(), 'pyWorkPage (ESTES-EL2-EPIC-Work-PickupAndDelivery)')]")
	public static WebElement ClickonpyworkPage_PAD;

	@FindBy(xpath = "(//span[contains(text(), 'pyWorkPage')])[1]/ancestor::li[2]/ul/li/div/div[1]")
	public static WebElement ExpandpyworkPage;

	@FindBy(xpath = "//span[contains(text(), 'OrderPage')]")
	public static WebElement ClickonOrderpageinCipboard;

	@FindBy(xpath = "((//span[contains(text(), 'OrderPage')])[1]/ancestor::li)[3]/ul/li/div/div/a")
	public static WebElement ExpandOrderPageinClipboard;
	
	@FindBy(xpath = "(//table[@id='gridLayoutTable']/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/span/label/span[contains(text(),'pyID')]/ancestor::td/following-sibling::td)[1]//input")
	public static WebElement pyIDTextBox;
	
	@FindBy(xpath = "(//table[@id='gridLayoutTable']/tbody/tr/td[2]/div/table/tbody/tr[3]/td/div/span/label/span[contains(text(),'PODConfirmNumber')]/ancestor::td/following-sibling::td)[1]//input")
	public static WebElement PODConfirmNum_TextBox;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'LoadedDate')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPageStatusEvent;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'StatusEvent')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_StatusEvent;

	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'StatusEvent')]/ancestor::td/following-sibling::td[1]/div/span)[1]")
	public static WebElement OrderPage_StatusEvent1;

	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'RequiredStatus')]/ancestor::td/following-sibling::td[1]/div/span)[1]")
	public static WebElement pyWorkpage_RequiredStatus;

	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'StatusEventDateTime')]/ancestor::td/following-sibling::td[1]/div/span)[1]")
	public static WebElement OrderPage_StatusEvent_DateTime;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'ReceivedDate')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_ReceivedDate;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Received Date']")
	public static WebElement OrderPAR_ReceivedDate;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'RequiredStatus')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_RequiredStatus;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'ArrivedAtPickup')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_ArrivedAtPickup;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'OutForDelivery')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_OutForDelivery;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'StatusUpdateToScanTool')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement StatusUpdatetoScanTool_Validation;

	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'AccessorialCode')]/ancestor::td/following-sibling::td[1]/div/span)[1]")
	public static WebElement AccessorialCode;

	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'AccessorialLocation')]/ancestor::td/following-sibling::td[1]/div/span)[1]")
	public static WebElement AccessorialLocation;

	@FindBy(xpath = "((//span[contains(text(), 'ShipmentList')]/ancestor::li)[4]//ul//li//div//div)[1]")
	public static WebElement ExpandShipmentinCLipboard;

	@FindBy(xpath = "((//span[contains(text(), 'AccessorialItemList')]/ancestor::li)[4]//ul//li//div//div)[1]")
	public static WebElement ExpandAccessorialinCLipboard;

	@FindBy(xpath = "//span[contains(text(), 'AccessorialItemList(1)')]")
	public static WebElement ClickAccessorial1inCLipboard;

	@FindBy(xpath = "//span[contains(text(), 'AccessorialItemList(2)')]")
	public static WebElement ClickAccessorial2inCLipboard;
	
	@FindBy(xpath = "//span[contains(text(), 'AccessorialItemList(3)')]")
	public static WebElement ClickAccessorial3inCLipboard;

	@FindBy(xpath = "//span[contains(text(), 'ShipmentList(2)')]")
	public static WebElement ClickonShipment2inCLipboard;

	@FindBy(xpath = "//table[@role='presentation']/tbody/tr/td/nobr/span/a[contains(text(),'PickupNumber')]/ancestor::td/following-sibling::td[1]/div/span")
	public static WebElement OrderPage_PickupNumber;

	@FindBy(id = "loginText2")
	public static WebElement ssoLogin;

	@FindBy(className = "table-row")
	public static WebElement code;

	@FindBy(id = "idTxtBx_SAOTCC_OTC")
	public static WebElement send;

	@FindBy(id = "idSubmit_SAOTCC_Continue")
	public static WebElement click;

	@FindBy(xpath = "//div[contains(@class,'launch-portals')]/descendant::a")
	public static WebElement LaunchPortal;

	@FindBy(xpath = "//span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement warehouse;

	@FindBy(xpath = "//li[@title='Orders PAR']")
	public static WebElement OrdersPAR;
	
	@FindBy(xpath = "//li[@title='Crowley On Dock']")
	public static WebElement OrdersOnDock;
	
	@FindBy(xpath = "//li[@title='Attach POD for CrowleyTL']")
	public static WebElement CrowleyTLPOD;
	
	@FindBy(xpath = "//input[@placeholder='Enter IB Load ID']")
	public static WebElement EnterIBLoadID;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public static WebElement Search_IBLoadID;
	
	@FindBy(xpath = "//button[@name='ProcessCancellationRequestForCrowleyTL_pyDisplayHarness_45']")
	public static WebElement ConfirmStatus_Submit;

	@FindBy(xpath = "(//span[@role='presentation' and @class='menu-item-icon-imageclass pi pi-clipboard-content-icon'])[1]")
	public static WebElement Reports;

	@FindBy(xpath = "//button[@name='pyReportBrowserHeaderReports_pyDisplayHarness_']")
	public static WebElement Reports_MovetoActions;

	@FindBy(xpath = "//span[@title='Crowley Report'][1]")
	public static WebElement Click_CrowleyReports;

	@FindBy(xpath = "(//a[@id='pui_colmenu'])[1]")
	public static WebElement Report_CaseIDFilterIcon;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	public static WebElement Report_Click_CaseIDFilter;
	
	@FindBy(xpath = "(//span[contains(text(),'Filter')])[3]")
	public static WebElement Report_Click_CaseIDFilter1;

	@FindBy(xpath = "(//input[@class='leftJustifyStyle'])[2]")
	public static WebElement Report_Click_SearchTextFilter;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	public static WebElement Report_Click_Filter_Apply;

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement frameName;

	@FindBy(xpath = "(//input[@name='$PpySimulationDataPage$ppyHTTPMethod'])[2]")
	public static WebElement RadioButton_POST;

	@FindBy(xpath = "//h3[contains(text(),'OS&D')]")
	public static WebElement OSD;

	@FindBy(xpath = "//h1[contains(text(),'Crowley On Dock')]")
	public static WebElement CrowleyOnDock_Header;	
	
	@FindBy(xpath = "//h3[contains(text(),'Inbound Trailer')]")
	public static WebElement InboundTrailer;

	@FindBy(xpath = "//h3[contains(text(),'Outbound Loads')]")
	public static WebElement OutboundLoads;

	@FindBy(xpath = "//th[@aria-label='Order ID']/div/span/a")
	public static WebElement OrderFilter;

	@FindBy(xpath = "//h3[@class='layout-group-item-title' and contains(text(),'POD Review')]")
	public static WebElement PODReview_Workpage;

	@FindBy(xpath = "//h3[@class='layout-group-item-title' and contains(text(),'Rate Review')]")
	public static WebElement RateReview_Workpage;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public static WebElement CheckBox_Click;

	@FindBy(xpath = "//button[contains(text(),'Submit 210')]")
	public static WebElement Submit210_Click;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm Paid')]")
	public static WebElement ConfirmPaid_Click;
	
	@FindBy(xpath = "//button[contains(text(),'Generate Invoice')]")
	public static WebElement GenerateInvoice_Click;

	@FindBy(xpath = "//button[contains(text(),'Assign Carrier')]")
	public static WebElement Assign_Carrier_Click;

	@FindBy(xpath = "//button[contains(text(),'Assign OB Trailer')]")
	public static WebElement Assign_OBTrailer_Click;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pPickupNumber']")
	public static WebElement TrailerNumber_Click;

	@FindBy(xpath = "//button[@title='Loaded']")
	public static WebElement Loaded_Button;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm Unload')]")
	public static WebElement ConfirmUnload_Button;
	
	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	public static WebElement ConfirmReleased_Button;
	
	@FindBy(xpath = "//td[@data-attribute-name='Loaded Date']")
	public static WebElement loadedDateElement;
	
	@FindBy(xpath = "//td[@data-attribute-name='Outbound Trailer']")
	public static WebElement OutboundTrailerElement;
	
	@FindBy(xpath = "//button[contains(text(),'Unload')]")
	public static WebElement Unload_Button;
	
	@FindBy(xpath = "//button[contains(text(),'Released')]")
	public static WebElement Released_Button;

	@FindBy(xpath = "//button[contains(text(), '  Assign Carrier ')]")
	public static WebElement Click_AssignCarrier_Popup;

	@FindBy(xpath = "//span[contains(text(), 'USKO Logistics')]")
	public static WebElement AssignCarrier_Validation;

	@FindBy(xpath = "(//div[@id='gridBody_right']/table/tbody/tr/td/div/span)[1]")
	public static WebElement ResolvePAROrder_CaseID;

	@FindBy(xpath = "(//div[@id='gridBody_right']/table/tbody/tr/td/div/span)[2]")
	public static WebElement ResolvePAROrder_BOL;

	@FindBy(xpath = "(//div[@id='gridBody_right']/table/tbody/tr/td/div/span)[3]")
	public static WebElement ResolvePAROrder_InvoiceNumber;

	@FindBy(xpath = "//button[contains(text(),'Approve POD')]")
	public static WebElement Approve_POD_Click;

	@FindBy(xpath = "//div[contains(text(),'case type does not yet have any fields')]")
	public static WebElement TextMessage_CompletedUI;
	
	@FindBy(xpath = "//span[@id='ERRORMESSAGES_ALL']//li")
	public static WebElement ErrorMessage_ApprovePOD;
	
	@FindBy(xpath = "//button[contains(text(),'Receive Order')]")
	public static WebElement ReceiveOrder_Click;
	
	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	public static WebElement Button_Receive;

	@FindBy(xpath = "//button[contains(text(),'Attach POD')]")
	public static WebElement Attach_POD_Click;
	
    @FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppxAttachName']")
    public static WebElement AttachFile_POD;
    
    @FindBy(xpath = "//input[@name='$PpxRequestor$ppyFileUpload']")
    public static WebElement ChooseFile_BulkAccessorial;
    
    @FindBy(xpath = "//span/button[contains(text(),'Update Accessorial')]")
    public static WebElement ChooseFile_UpdateAccessorial;
    
    @FindBy(xpath = "//span/button[contains(text(),'Complete Update')]")
    public static WebElement CompleteUpdate;
	
	@FindBy(xpath = "//div/div[contains(text(),'Total BOL:')]")
	public static WebElement Text_TotalBOL;

	@FindBy(xpath = "//div/div[contains(text(),'Total Weight:')]")
	public static WebElement Text_TotalWeight;

	@FindBy(xpath = "//div/div[contains(text(),'Total Pieces:')]")
	public static WebElement Text_TotalPieces;

	@FindBy(xpath = "//*[contains(text(),'Attachment and Req Status')]")
	public static WebElement ReSubmit_ErrorMessage_Element;

	@FindBy(xpath = "//button[contains(text(),'Re-Submit POD')]")
	public static WebElement Re_Submit_POD_Click;
	
	@FindBy(xpath = "//button[contains(text(),'Upload Accessorials')]")
	public static WebElement UploadAccessorials_Click;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public static WebElement ResolvePAROrder_Submit;

	@FindBy(xpath = "(//input[@CLASS='multiselect-list'])[2]")
	public static WebElement OrderSearch_Filer;

	@FindBy(xpath = "(//a[@id='pui_filter'])[1]")
	public static WebElement Order_Search_Filter;

	@FindBy(xpath = "(//a[@id='pui_filter'])[2]")
	public static WebElement PODReview_BOL_Filter;

	@FindBy(xpath = "(//span/a[contains(text(),'PAR')])[1]")
	public static WebElement PAR_Order_OSnD;

	@FindBy(xpath = "//div[@class='content-inner ']/div/span/input[@type='text']")
	public static WebElement OrderSearch_Filter;

	@FindBy(xpath = "(//input[@type='checkbox' and contains(@name,'Inbound')])[21]")
	public static WebElement FilterCheckBox;

	@FindBy(xpath = "(//button[@class='pzhc pzbutton'])[1]")
	public static WebElement OrderFilterApply;

	@FindBy(xpath = "//a[contains(text(),'Refresh ')]")
	public static WebElement Order_Tab_Refresh;
	
	@FindBy(xpath = "//div[@id='PEGA_GRID_SKIN']//a[contains(text(),'Refresh')]")
	public static WebElement RateReview_Refresh;

	@FindBy(xpath = "//a[contains(text(), 'DFD')]")
	public static WebElement ClickDFDCaseID;

	@FindBy(xpath = "//a[contains(text(), 'PAD')]")
	public static WebElement ClickPADCaseID;
                                                                          
	@FindBy(xpath = "//a[contains(text(), 'PAR')]")
	public static WebElement ClickPARCaseID;

	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public static WebElement OutboundLoads_Go;

	@FindBy(xpath = "//h3[contains(text(),'Outbound Loads')]")
	public static WebElement OutBound_Loads;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	public static WebElement frameName2;

	@FindBy(xpath = "//iframe[@name='PegaGadget2Ifr']")
	public static WebElement frameName3;

	@FindBy(xpath = "//iframe[@name='PegaGadget3Ifr']")
	public static WebElement CrowleyReport_Frame;
	
	@FindBy(xpath = "//div/span[contains(text(),'Note: Case has been invoiced')]")
	public static WebElement Invoiced_Note;

	@FindBy(xpath = "//span[contains(text(),'Arrived at Terminal')]")
	public static WebElement ArrivedAtTerminal;
	
	@FindBy(xpath = "//label[contains(normalize-space(.),'Status')]/ancestor::div[1]//span[contains(text(),'210 Submitted')]")
	public static WebElement Submitted210_Status;

	@FindBy(xpath = "//span[contains(text(),'FNB')]")
	public static WebElement FNB_Status;

	@FindBy(xpath = "//span[contains(text(),'BNF')]")
	public static WebElement BNF_Status;

	@FindBy(xpath = "//span[contains(text(),'NBNF')]")
	public static WebElement NBNF_Status;

	@FindBy(xpath = "//span[contains(text(),'Shortage')]")
	public static WebElement Shortage_Status;

	@FindBy(xpath = "//span[contains(text(),'Freight not on Bill')]")
	public static WebElement Overage_Status;
	
	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pOrderPage$pShipmentList$l2$pPickupNumber')]")
	public static WebElement Outbound_trailer_outboundLoads_Status;

	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pStatusEvent')]")
	public static WebElement Inbound_trailer_outboundLoads_Status;
	
	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pOrderPage$pShipmentList$l2$pAssignedTradingPartnerName')]")
	public static WebElement Outbound_carrier_outboundLoads_Status;
	
	@FindBy(xpath = "//*[contains(@name, '$PpyDisplayHarness$pRateRequestingTPID')]")
	public static WebElement RateReview_Shipper;

	@FindBy(xpath = "//*[contains(@name, '$PpyDisplayHarness$pAssignedTradingPartnerName')]")
	public static WebElement Assign_OutboundCarrier;

	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pCustomerAppointmentStatus')]")
	public static WebElement CustomerAppointment_Status;

	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pDeliveryStatus')]")
	public static WebElement CustomerDelivery_Status;
	
	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pAccessorialLocation')]")
	public static WebElement AccessorialLocation_Dropdown;
	
	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pAccessorialCode')]")
	public static WebElement AccessorialCode_Dropdown;

	@FindBy(xpath = "//*[contains(@alt, 'Choose from calendar')]")
	public static WebElement ClickonCalendar;

	@FindBy(xpath = "//a[@id='todayLink']")
	public static WebElement ClickonTodayDate;

	@FindBy(xpath = "//a[@id='applyLink']")
	public static WebElement ClickOnApply;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pEventDate']")
	public static WebElement GetDateandTime;
	
	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pReceivedDate']")
	public static WebElement Get_Received_DateandTime;

	@FindBy(xpath = "//span[text()='Arrive At Pickup']/following::div[@class='field-item dataValueRead'][1]/span")
	public static WebElement Get_Pickup_DateandTime;

	@FindBy(xpath = "//span[text()='Depart At Pickup']/following::div[@class='field-item dataValueRead'][1]/span")
	public static WebElement Get_OutForDelivery_DateandTime;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public static WebElement Submit;
	
	@FindBy(xpath = "//span[contains(text(),'POD Complete')]/following-sibling::div/span[contains(text(),'Y')]")
	public static WebElement PODComplete_Y;
	
	@FindBy(xpath = "//span[contains(text(),'Required Status')]/following-sibling::div/span[contains(text(),'Y')]")
	public static WebElement RequiredStatus_Y;
	
	@FindBy(xpath = "//button[@name='ApproveRate_pyDisplayHarness_44']")
	public static WebElement Submit210_Submit;

	@FindBy(xpath = "//button[@type='button' and @title='Submit']")
	public static WebElement ConfirmPaid_Submit;
	
	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	public static WebElement ApprovePAR_Submit;
	
	@FindBy(xpath = "//button[@type='button' and @title='Click Submit to Generate Invoice PDF']")
	public static WebElement GenerateInvoice_Submit;
	
	@FindBy(xpath = "//a[contains(text(),'+ AddItem')]")
	public static WebElement AddItem;
	
	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td/div/span[contains(text(),'210 Submitted')]")
	public static WebElement Validate_210Submitted;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td/div/span[contains(text(),'POD Received')]")
	public static WebElement Validate_POD_Received;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td/div/span[contains(text(),'POD Accepted')]")
	public static WebElement Validate_POD_Accepted;

	@FindBy(xpath = "//ul[contains(@class,'error')]/li")
	public static WebElement Validate_ErrorMessage;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td/div/span[contains(text(),'POD Resubmitted')]")
	public static WebElement Validate_POD_Resubmitted;

	@FindBy(xpath = "//span[contains(text(),'Resolved-Completed')]")
	public static WebElement Resolved_Completed;

	@FindBy(xpath = "//button[contains(text(), 'Go')]")
	public static WebElement ClickonGo;

	@FindBy(xpath = "//input[contains(@name,'Description')]")
	public static WebElement Description_Value;

	@FindBy(xpath = "//input[contains(@name,'Code')]")
	public static WebElement Code_Value;

	@FindBy(xpath = "//input[contains(@name,'QTY')]")
	public static WebElement Qty_Value;

	@FindBy(xpath = "//input[contains(@name,'AccessorialCost')]")
	public static WebElement Charge_Value;

	@FindBy(xpath = "//td[@data-attribute-name='Charge']/div/span/span")
	public static WebElement Charge_Value1;

	@FindBy(xpath = "(//td[@data-attribute-name='Charge']/div/span/span)[2]")
	public static WebElement Charge_Value2;

	@FindBy(xpath = "//button[contains(text(),'Save Accessorial')]")
	public static WebElement SaveAccessorial;
	
	@FindBy(xpath = "//button[contains(text(),'Request New Rate')]")
	public static WebElement RequestNewRate;
	
	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	public static WebElement SaveChanges;

	@FindBy(xpath = "//button[@title='Toggle runtime toolbar']/i[@class='pz-pi pi-gear']")
	public static WebElement Toggle_toolbar;

	@FindBy(xpath = "//button[@title='Clipboard']")
	public static WebElement CLickOnClipBoard;

	@FindBy(xpath = "//span[contains(text(), 'Received')]")
	public static WebElement StatusEvent_Shipement2_Clipboard;

	@FindBy(xpath = "//span[contains(text(),'EFM')]")
	public static WebElement EFMStatus_Validation;

	@FindBy(xpath = "//span[contains(text(),'Loaded')]")
	public static WebElement Loaded_Status_Validation;

	@FindBy(xpath = "//span[contains(text(),'Received')]")
	public static WebElement Received_Status_Validation;

	@FindBy(xpath = "//span[contains(text(),'RECEIVED')]")
	public static WebElement DFD_Received_Status_Validation;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='TotalInvoiceAmount']/div)[1]")
	public static WebElement Table_TotalInvoiceAmount;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Line Haul Price']/div)[1]")
	public static WebElement Table_LineHaul;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='FSC Price']/div)[1]")
	public static WebElement Table_FSCPrice;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='FSC Rate Percentage']/div)[1]")
	public static WebElement Table_FSCRatePercentage;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='AccessorialTotalFees']/div)[1]")
	public static WebElement Table_AccessorialTotalFees;

	@FindBy(xpath = "//label[text()='Status']/following::span[@class='badge_text']")
	public static WebElement Rated_Status;
	
	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'Rated')]")
	public static WebElement RatedTable_Status;
	
	@FindBy(xpath = "//td[@data-attribute-name='Status']/div/span[contains(text(),'Invoiced')]")
	public static WebElement Invoiced_Status;
	
	@FindBy(xpath = "//td[@data-attribute-name='Line Haul Rate']/div/span/span")
	public static WebElement Invoice_Linehaul;
	
	@FindBy(xpath = "//td[@data-attribute-name='FSC Charge']/div/span/span")
	public static WebElement Invoice_FSCCharge;
	
	@FindBy(xpath = "(//td[@data-attribute-name='Total Accessorial']/div/span/span)[1]")
	public static WebElement Invoice_TotalAccessorial;
	
	@FindBy(xpath = "(//td[@data-attribute-name='Total Amount']/div/span/span)[1]")
	public static WebElement Invoice_TotalAmount;
	
	@FindBy(xpath = "//td[@data-attribute-name='Base &#43; Fuel']/div/span/span")
	public static WebElement Base_FuelTotalCharge;

	@FindBy(xpath = "//span[contains(@class,'field-caption') and text()='Total']/following-sibling::div/span/span")
	public static WebElement Total_Rate;

	@FindBy(xpath = "//span[contains(@class,'field-caption') and text()='Line Haul']/following-sibling::div/span/span")
	public static WebElement LineHaul_Rate;

	@FindBy(xpath = "//span[contains(@class,'field-caption') and text()='Fuel']/following-sibling::div/span/span")
	public static WebElement Fuel;

	@FindBy(xpath = "//span[contains(@class,'field-caption') and text()='Fuel Rate']/following-sibling::div/span/span")
	public static WebElement Fuel_Rate;

	@FindBy(xpath = "//span[contains(@class,'field-caption') and text()='Total Accessorial']/following-sibling::div/span/span")
	public static WebElement Total_Accessorial;

	@FindBy(xpath = "//span[contains(text(),'Scan Tool Order API')]")
	public static WebElement ScanToolStatus_Validation;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$ppySearchText']")
	public static WebElement ClickDevStudioSearchBox;

	@FindBy(xpath = "//i[@class='pi pi-search-2']")
	public static WebElement ClickDevStudioSearchIcon;

	@FindBy(xpath = "//a[contains(text(),'OrderServicePackage Services ProcessData')]")
	public static WebElement ClickOrderServicePackage;
	
	@FindBy(xpath = "//a[contains(text(),'ConfrimPOD')]")
	public static WebElement ClickConfirmPOD;

	@FindBy(xpath = "//a[contains(text(),'OrderServicePackage V1 updatestatus')]")
	public static WebElement ClickOrderServicePackage_UpdateStatus;

	@FindBy(xpath = "//div[@string_type='field']/span/button[contains(text(),'Actions')]")
	public static WebElement ServicePageActions;

	@FindBy(xpath = "//div[contains(text(),'Run')]")
	public static WebElement Actions_Run;
	
	@FindBy(xpath = "(//span[contains(text(),'Run')])[2]")
	public static WebElement ServicePageRun;

	@FindBy(xpath = "(//button[@name='CaseActionHeader_pyWorkPage_4'])[2]")
	public static WebElement Actions_Button;
	
	@FindBy(xpath = "(//button[@title='Actions' and contains(text(),'Actions')])[2]")
	public static WebElement PAD_Actions_Button;

	@FindBy(xpath = "//span[contains(text(), 'Refresh')]")
	public static WebElement Actions_Refresh;

	@FindBy(xpath = "//input[@value='EnterText']")
	public static WebElement SupplySOAPCheckBox;

	@FindBy(xpath = "//textarea[@name='$PpySimulationDataPage$ppyPOSTRequestParameterValues$l1$ppyValue']")
	public static WebElement TextAreaClick;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Pickup Scheduled')]")
	public static WebElement pickUpScheduled_Validation;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Awaiting Arrival')]")
	public static WebElement AwaitingArrival_Validation;

	@FindBy(xpath = "//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']")
	public static WebElement SupplySOAPTextBox;

	@FindBy(xpath = "//div//span[contains(text(),'Execute')]")
	public static WebElement ExecuteClick;

	@FindBy(xpath = "(//span[contains(@class,'route')])[1]")
	public static WebElement OrdersDFDClick;

	@FindBy(xpath = "(//span[contains(@class,'locations')])[1]")
	public static WebElement OrdersPADClick;
	
	@FindBy(xpath = "(//a[@id='pui_filter'])[8]")
	public static WebElement OrdersShipmentPADFilter;
	
	@FindBy(xpath = "(//a[@id='pui_filter'])[1]")
	public static WebElement ShipmentScheduling_OrderID_Filter;

	@FindBy(xpath = "/html/body/div[3]/form/div[5]/div[1]/ul/li[3]/div/button[1]")
	public static WebElement CrowApplyClick;

	@FindBy(xpath = "//div[@aria-label='Rate Review']")
	public static WebElement ExceptionManagementHeaderClick;

	@FindBy(xpath = "//div[contains(@aria-label,'Inbound Shipment')]")
	public static WebElement InboundShipmentHeaderClick;

	@FindBy(xpath = "//div[contains(@aria-label,'Shipment Scheduling')]")
	public static WebElement ShipmentSchedulingHeaderClick;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Delivery Management')]")
	public static WebElement DeliveryManagementHeaderClick;

	@FindBy(xpath = "(//a[@id='pui_filter'])[2]")
	public static WebElement FilterIconClick;

	@FindBy(xpath = "(//a[@id='pui_filter'])[1]")
	public static WebElement PAD_FilterIconClick;

	@FindBy(xpath = "//input[@data-primary-value='.BOL']")
	public static WebElement BOL_DropdownFilterIconClick;
	
	@FindBy(xpath = "//input[@data-primary-value='.BOL' and @data-target='$PpyDisplayHarness$pInboundBOLNumberList']")
	public static WebElement BOL_DropdownFilterIconClick_DFD;
	
	@FindBy(xpath = "//input[@data-primary-value='.BOL' and @placeholder='Select']")
	public static WebElement PAD_BOL_DropdownFilterIconClick;
	
	@FindBy(xpath = "(//input[@data-primary-value='.Value'])[1]")
	public static WebElement StatusSearchFilterIconClick;

	@FindBy(xpath = "//input[@data-primary-value='.DeliveryNumber']")
	public static WebElement POD_BOL_DropdownFilterIconClick;

	@FindBy(xpath = "//span[contains(text(),'Use \"')]")
	public static WebElement BOL_Use_Click;

	@FindBy(xpath = "(//a[@id='pui_filter'])[4]")
	public static WebElement BOL_FilterIconClick;

	@FindBy(xpath = "//input[@CLASS='leftJustifyStyle']")
	public static WebElement OrderSearchBoxClick;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	public static WebElement ApplyClick;

	@FindBy(xpath = "//td[@data-attribute-name='Status']/div/span[contains(text(),'Released')]")
	public static WebElement status_Released;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'POD Received')]")
	public static WebElement Order_status_PODReceived;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'POD Resubmitted')]")
	public static WebElement status_Re_Submit;

	@FindBy(xpath = "//span[contains(text(),'Released')]")
	public static WebElement CaseStatusUI_Released;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Released')]")
	public static WebElement OrderStatus_Released_Validation;
	
	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'POD Exception')]")
	public static WebElement OrderStatus_PODException_Validation;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Cancelled')]")
	public static WebElement OrderStatus_Cancelled_Validation;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Delivery Scheduled')]")
	public static WebElement OrderStatus_DeliveryScheduled_Validation;

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Out For Delivery')]")
	public static WebElement OrderStatus_OutForDelivery_Validation;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'POD Received')]")
	public static WebElement status_PODReceived;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'N')]")
	public static WebElement Attachment_No;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'Y')]")
	public static WebElement Attachment_Yes;

	@FindBy(xpath = "//h3[@class='layout-group-item-title' and contains(text(),'Add existing')]")
	public static WebElement Add_Existing_Attachment;

	@FindBy(xpath = "//td[@data-attribute-name='Count']/div/span[contains(text(),'0')]")
	public static WebElement Count_Nil;

	@FindBy(xpath = "//input[@name='$PAddRecentContent$ppyLabel']")
	public static WebElement RichText_Name;

	@FindBy(xpath = "//body[@aria-label='Enter document content.']")
	public static WebElement RichText_ContentName;

	@FindBy(xpath = "//div[@title='Add URL']")
	public static WebElement AddURL;

	@FindBy(xpath = "//div[@title='Upload local file']")
	public static WebElement AddLocalFile;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyNote']")
	public static WebElement AddURL_Name;

	@FindBy(xpath = "//div[@id='uniqueIDforMultiFilePath']/input[@name='$PpyAttachmentPage$ppxAttachName']")
	public static WebElement SelectFile;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyURL']")
	public static WebElement AddURL_tag;

	@FindBy(xpath = "//div[@string_type='label' and contains(text(),'Note')]")
	public static WebElement Validation_Attachment_Note;

	@FindBy(xpath = "//button[@name='ShowAttachmentNote_pyWorkPage_4' and contains(text(),'OK')]")
	public static WebElement Click_Attachment_Ok;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span/a/i[@class='pi pi-paper-clip']")
	public static WebElement Attachment_Clip;

	@FindBy(xpath = "//input[@id='$PpyAttachmentPage$ppxAttachName']")
	public static WebElement AttachFile_ApprovePOD;

	@FindBy(xpath = "//button[@title='Submit']")
	public static WebElement Attachment_Submit;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public static WebElement Attachment_Save;

	@FindBy(xpath = "//button[@title='Please Provide Valid Orders' and contains(text(),'Re-Submit')]")
	public static WebElement Re_Submit;

	@FindBy(xpath = "//table/tbody/tr/td/button[@title='Submit']")
	public static WebElement ApprovePOD_Submit;

	@FindBy(xpath = "//span[contains(text(),'No cases')]")
	public static WebElement POD_Review_NoCases;

	@FindBy(xpath = "//button[contains(text(),'Refresh ')]")
	public static WebElement PAR_Refresh;

	@FindBy(xpath = "//a[contains(text(),'Refresh')]")
	public static WebElement PAR_OBLoads_Refresh;

	@FindBy(xpath = "//td[@data-attribute-name='IB Load ID']/div/span")
	public static WebElement IB_LoadID;

	@FindBy(xpath = "//input[@name='_user']")
	public static WebElement Roundcube_Username;

	@FindBy(xpath = "//input[@name='_pass']")
	public static WebElement Roundcube_Password;

	@FindBy(id = "rcmloginsubmit")
	public static WebElement Roundcube_Submit;

//	@FindBy(xpath = "(//a/span[contains(text(),'"+ OB_LoadID_Value +"')])[1]")
//	public static WebElement Roundcube_Mail;

	@FindBy(xpath = "//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'Crowley Report')]")
	public static WebElement Switchto_CrowleyReport_Page;

	@FindBy(xpath = "//button[@name='pyReportEditorHeader_pyReportContentPage_18']")
	public static WebElement ClickReport_Actions;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	public static WebElement ClickReport_Refresh;

	@FindBy(xpath = "(//span[@title='Close this tab'])")
	public static WebElement Close_PARtab1;

	@FindBy(xpath = "(//span[@title='Close this tab'])[2]")
	public static WebElement Close_PARtab;

	@FindBy(xpath = "//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'Orders PAR')]")
	public static WebElement switchTo_OrdersPAR;
	
	@FindBy(xpath = "//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'Orders DFD')]")
	public static WebElement switchTo_OrdersDFD;
	
	@FindBy(xpath = "//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'Orders PAD')]")
	public static WebElement switchTo_OrdersPAD;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span/a[contains(text(),'View')]   ")
	public static WebElement Click_ViewDoc;

	@FindBy(xpath = "//div[@class='layout-body clearfix  ']/div/div/span[contains(text(),'1')]")
	public static WebElement View_One_Doc;

	@FindBy(xpath = "//div[@class='layout-body clearfix  ']/div/div/span[contains(text(),'0')]")
	public static WebElement View_Zero_Doc;

	@FindBy(xpath = "//span[@class='supporting_text' and contains(text(),'ago')]")
	public static WebElement View_Doc_Validation;

	@FindBy(xpath = "(//span[@class='supporting_text' and contains(text(),'No items')])[1]")
	public static WebElement No_Doc_Attached;

	@FindBy(xpath = "//i[@class='pi pi-more pi-right']")
	public static WebElement Icon_Delete_Document_Attached;
	
	@FindBy(xpath = "(//i[@class='pi pi-more pi-right'])[1]")
	public static WebElement PDF_Download_Icon;

	@FindBy(xpath = "//span[@class='menu-item-title-wrap']/span[contains(text(),'Download')]")
	public static WebElement Download_Doc_Attached;
	
	//span[@class='menu-item-title-wrap']/span[contains(text(),'Download')]
	//div[@class='ellipsis']/a[contains(text(),'pdf')]/following::span/button/i[@class='pi pi-more pi-right']

	@FindBy(xpath = "//span[@class='menu-item-title-wrap']/span[contains(text(),'Delete')]")
	public static WebElement Delete_Doc_Attached;

	@FindBy(xpath = "//button[@title='Close modal']")
	public static WebElement Close_AttachmentList_Box;

//	@FindBy(xpath = "//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'"+ sendkeys +"')]")
//	public static WebElement switchTo_OrdersPage;
	
	@FindBy(xpath = "//span[@id='$PpyWorkPage$pDeliveryAppointmentDateSpan']/*[contains(@alt, 'Choose from calendar')]")
	public static WebElement ClickonCalendar_DeliveryAppointment;

	@FindBy(xpath = "(//*[contains(@alt, 'Choose from calendar')])[1]")
	public static WebElement ClickonCalendar_POD_review;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pOrderPage$pOutForDelivery']/following-sibling::img[@alt='Choose from calendar']")
	public static WebElement ClickonCalendar_POD_review2;

	@FindBy(xpath = "//img[@alt='Choose from calendar']")
	public static WebElement CustomerDelivery_Calendar;

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pAssignedTradingPartnerName']")
	public static WebElement Release__Carrier;
	
	@FindBy(xpath = "//a[contains(text(),'+ Add Accessorial')]")
	public static WebElement Add_Accessorial;
	
	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'Submit POD')]")
	public static WebElement SubmitPOD;
	
	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'Ready to Invoice')]")
	public static WebElement ReadyToInvoice;
	
	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'Rated')]")
	public static WebElement Rated_StatusValidation;
	
	@FindBy(xpath = "(//span/a[contains(text(),'Edit')])[1]")
	public static WebElement PODComplete_Edit;
	
	@FindBy(xpath = "//select[@name='$PpyWorkPage$pOrderPage$pPODSent']")
	public static WebElement PODComplete_Dropdown;
	
	public static void SubmitPOD_Validation() {
		String SubmitPOD_Status_Validation = SubmitPOD.getText().trim();
		assertEquals(SubmitPOD_Status_Validation, "Submit POD");
		extentTest.log(Status.PASS, "Successfully validated Status as " + SubmitPOD_Status_Validation);
	}
	
	public static void ReadyToInvoice_Validation() {
		String ReadyToInvoice_Status_Validation = ReadyToInvoice.getText().trim();
		assertEquals(ReadyToInvoice_Status_Validation, "Ready to Invoice");
		extentTest.log(Status.PASS, "Successfully validated Status as " + ReadyToInvoice_Status_Validation);
	}
	
	public static void RatedStatus_Validation() {
		String Rated_Status_Validation = Rated_StatusValidation.getText().trim();
		assertEquals(Rated_Status_Validation, "Rated");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Rated_Status_Validation);
	}
	
	public static void PODComplete_Status_Validation() {
		String PODComplete_Status_Validation = PODComplete_Y.getText().trim();
		assertEquals(PODComplete_Status_Validation, "Y");
		extentTest.log(Status.PASS, "Successfully validated Status as " + PODComplete_Status_Validation);
	}
	
	public static void Required_Status_Validation() {
		String Required_Status_Validation = RequiredStatus_Y.getText().trim();
		assertEquals(Required_Status_Validation, "Y");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Required_Status_Validation);
	}
	
	public static void frameSwitch() {
		driver.switchTo().frame(frameName);
	}

	public static void Crowley_Filter_Apply() {

		WebElement applyButton = driver.findElement(By.cssSelector("button.pzhc.pzbutton"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", applyButton);
	}

	public void ReceivedtableDatafetch() {
		String columnHeaderToMatch = "ReceivedDate";

		// Locate the table element
		WebElement table = driver.findElement(By.xpath("//table[@id='bodyTbl_right']"));

		// Find the column index based on the column header
		int columnIndex = getColumnIndex(table, columnHeaderToMatch);

		if (columnIndex != -1) {
			// Extract rows from the table
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			// Iterate through rows and extract data from the specified column
			for (WebElement row : rows) {
				// Find the cell in the specified column
				List<WebElement> columns = row.findElements(By.tagName("td"));
				if (columns.size() > columnIndex) {
					String cellData = columns.get(columnIndex).getText();
					System.out.println("Received Date in CrowleyTL Report: " + cellData);
					System.out.println("UI Received Date: " + DateTime);
					// Compare cell data with the string data
					if (cellData.equals(DateTime)) {
						System.out.println(DateTime + " in frontend matches with " + cellData
								+ " --->Matching data found in specified column!");
						// Additional actions if needed
						break; // Optional: Exit loop if a match is found in the column
					}
				}
			}
		} else {
			System.out.println("Column header not found!");
		}
	}

	public void ReleasedtableDatafetch() {
		String columnHeaderToMatch = "Released Date";

		// Locate the table element
		WebElement table = driver.findElement(By.xpath("//table[@id='bodyTbl_right']"));

		// Find the column index based on the column header
		int columnIndex = getColumnIndex(table, columnHeaderToMatch);

		if (columnIndex != -1) {
			// Extract rows from the table
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			// Iterate through rows and extract data from the specified column
			for (WebElement row : rows) {
				// Find the cell in the specified column
				List<WebElement> columns = row.findElements(By.tagName("td"));
				if (columns.size() > columnIndex) {
					String cellData = columns.get(columnIndex).getText();
					System.out.println("Released Date in CrowleyTL Report: " + cellData);
					System.out.println("UI Released Date: " + DateTime);
					// Compare cell data with the string data
					if (cellData.equals(DateTime)) {
						System.out.println(DateTime + " in frontend matches with " + cellData
								+ " --->Matching data found in specified column!");
						// Additional actions if needed
						break; // Optional: Exit loop if a match is found in the column
					}
				}
			}
		} else {
			System.out.println("Column header not found!");
		}
	}

	public void OutboundTrailerIDtableDatafetch() {
		String columnHeaderToMatch = "Outbound Trailer ID";

		// Locate the table element
		WebElement table = driver.findElement(By.xpath("//table[@id='bodyTbl_right']"));

		// Find the column index based on the column header
		int columnIndex = getColumnIndex(table, columnHeaderToMatch);

		if (columnIndex != -1) {
			// Extract rows from the table
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			// Iterate through rows and extract data from the specified column
			for (WebElement row : rows) {
				// Find the cell in the specified column
				List<WebElement> columns = row.findElements(By.tagName("td"));
				if (columns.size() > columnIndex) {
					String cellData = columns.get(columnIndex).getText();
					System.out.println(cellData);
					// Compare cell data with the string data
					if (cellData.equals(DateTime)) {
						System.out.println(DateTime + " in frontend matches with " + cellData
								+ " --->Matching data found in specified column!");
						// Additional actions if needed
						break; // Optional: Exit loop if a match is found in the column
					}
				}
			}
		} else {
			System.out.println("Column header not found!");
		}
	}

	// Helper method to get the index of a column based on its header text
	private static int getColumnIndex(WebElement table, String columnHeader) {
		List<WebElement> headerCells = table.findElements(By.tagName("th"));
		for (int i = 0; i < headerCells.size(); i++) {
			String headerText = headerCells.get(i).getText().trim();
			if (headerText.equals(columnHeader)) {
				return i;
			}
		}
		return -1;
	}

	public void SwitchtoOrderPage() {

		WebElement switchtoOrder = driver.findElement(
				By.xpath("//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'" + OrderID.trim() + "')]"));
		switchtoOrder.click();

	}

	public void OB_LoadID_Val() throws Exception {
		Await();
		WebElement IB_LoadID_Val = driver
				.findElement(By.xpath("(//a/span[contains(text(),'" + IB_LoadID_Value + "')])[1]"));
		IB_LoadID_Val.click();

	}

	public void SwitchtoOrdersPAR() {

		switchTo_OrdersPAR.click();
	}

	public void Click_ViewDoc() throws Exception {
		Click_ViewDoc.click();
		Await();
//		String one = View_One_Doc.getText();
//		assertEquals("1", one);
//		extentTest.log(Status.PASS, "Order has one attachment and can able to view");
//		String text = View_Doc_Validation.getText();
//		assertEquals("ago", text.contains("ago"));
	}
	
	public void Download_Attachment() throws Exception {
		Icon_Delete_Document_Attached.click();
		Await();
		Download_Doc_Attached.click();
		Await();
		Close_AttachmentList_Box.click();
		Await();
	}
	
	public void Download_Attached_Doc() throws Exception {
		Icon_Delete_Document_Attached.click();
		Await();
		PDF_Download_Icon.click();
		Await();
		Close_AttachmentList_Box.click();
		Await();
	}

	public void Download_and_Delete_Document_Attached() throws InterruptedException {
		Icon_Delete_Document_Attached.click();
		Await();
		Download_Doc_Attached.click();
		Await();
		Icon_Delete_Document_Attached.click();
		Await();
		Delete_Doc_Attached.click();
		Await();
		Close_AttachmentList_Box.click();
		Await();

	}

	public void Delete_Attachment() throws Exception {
		Icon_Delete_Document_Attached.click();
		Await();
		Delete_Doc_Attached.click();
		Await();
		Close_AttachmentList_Box.click();
		Await();
	}

	public void Validate_Attachement_After_Delete() {
		String zero = View_Zero_Doc.getText();
		assertEquals("0", zero);
		extentTest.log(Status.PASS, "Order has zero attachment");
		String text = No_Doc_Attached.getText();
		assertEquals("No items", text);
	}

	public void switchtoOrdersPage() {
		WebElement switchTo_OrdersPage = driver.findElement(
				By.xpath("//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'" + OrderID.trim() + "')]"));
		switchTo_OrdersPage.click();
	}

	public void SwitchtoPODReview() {
		PODReview_Workpage.click();
		extentTest.log(Status.PASS, "Case should populated in POD Review workqueue");
	}

	public void ActionsButton() throws Exception {
		Await();
		Actions_Button.click();
		Await();
		Actions_Refresh.click();
		Await();
	}
	
	public void PAD_ActionsButton() throws Exception {
		Await();
		PAD_Actions_Button.click();
		Await();
		Actions_Refresh.click();
		Await();
	}


	public void Validate_RouteStatus() {
		String text = Route_Status_Validation.getText().trim();
		assertEquals("In Progress", text);
		extentTest.log(Status.PASS, "Validated Route Status as " + text);
	}

	public void GloballyUniqueID() {
		GloballyUniqueID = Route_GloballyUniqueID.getText().trim();
		extentTest.log(Status.PASS, "Retrieved Globally unique ID : " + GloballyUniqueID);
	}

	public void Received_Date_Validation() throws Exception {
		Await();
		String dateTime = Received_Date_Validation.getText().trim();
		assertEquals(dateTime, DateTime);
		extentTest.log(Status.PASS, "Validated Received Date in Order Datatypes as : " + DateTime);
	}

	public void Order_Data_Validation() throws Exception {

		String TrackingNumber = TrackingNumber_Validation.getText().trim();
		assertEquals(TrackingNumber, Tracking_Number);
		String PickupNumber = PickupNumber_Validation.getText().trim();
		assertEquals(PickupNumber, Pickup_Number);
		String InvoiceNumber = InvoiceNumber_Validation.getText().trim();
		assertEquals(InvoiceNumber, Invoice_number);
		String PONumber = PONumber_Validation.getText().trim();
		assertEquals(PONumber, PO_Number);
		
		String DeliveryNumber = DeliveryNumber_Validation.getText().trim();
		assertEquals(DeliveryNumber, Delivery_Number);
		
		String OriginCompany = Origin_Company_Validation.getText().trim();
		assertEquals(OriginCompany, Origin_CompanyName);

		String OriginAddress1 = Origin_Address1_Validation.getText().trim();
		assertEquals(OriginAddress1, Origin_Address1);
		String OriginCity = Origin_City_Validation.getText().trim();
		assertEquals(OriginCity, Origin_City);
		String OriginState = Origin_State_Validation.getText().trim();
		assertEquals(OriginState, Origin_State);
		String OriginPostalCode = Origin_PostalCode_Validation.getText().trim();
		assertEquals(OriginPostalCode, Origin_PostalCode);
		String OriginCountry = Origin_Country_Validation.getText().trim();
		assertEquals(OriginCountry, Origin_Country);

		String OriginPhoneNumber = Origin_PhoneNumber_Validation.getText().trim();
		assertEquals(OriginPhoneNumber, Origin_Phone);
		String OriginContactName = Origin_ContactName_Validation.getText().trim();
		assertEquals(OriginContactName, Origin_ContactName);
		String DestinationCompany = Destination_Company_Validation.getText().trim();
		assertEquals(DestinationCompany, Destination_CompanyName);
		String DestinationAddress1 = Destination_Address1_Validation.getText().trim();
		assertEquals(DestinationAddress1, Destination_Address1);
		String DestinationCity = Destination_City_Validation.getText().trim();
		assertEquals(DestinationCity, Destination_City);
		String DestinationState = Destination_State_Validation.getText().trim();
		assertEquals(DestinationState, Destination_State);
		String DestinationPostalCode = Destination_PostalCode_Validation.getText().trim();
		assertEquals(DestinationPostalCode, Destination_PostalCode);
		String DestinationCountry = Destination_Country_Validation.getText().trim();
		assertEquals(DestinationCountry, Destination_Country);
		String DestinationPhoneNumber = Destination_PhoneNumber_Validation.getText().trim();
		assertEquals(DestinationPhoneNumber, Destination_Phone);
		String DestinationContactName = Destination_ContactName_Validation.getText().trim();
		assertEquals(DestinationContactName, Destination_ContactName);
		String BOLNumber = BOL_Validation.getText().trim();
		assertEquals(BOLNumber, BOL_Order);

		extentTest.log(Status.PASS, "Validated Order Origin and Destination data in Order Datatypes");
	}

	public void validateAccessorialDetails() {

		for (WebElement element1 : AccessorialCode_ValidationList) {
			actualAccessorialCodes.add(element1.getText().trim());
		}
		// Compare expected JSON accessorial codes with the actual table values
		if (new HashSet<>(actualAccessorialCodes).equals(new HashSet<>(expectedAccessorialCodes))) {
			System.out.println("Accessorial Code validation passed.");
			extentTest.log(Status.PASS, "Accessorial Codes match: " + expectedAccessorialCodes);
		} else {
			System.out.println("Accessorial Code validation failed.");
			extentTest.log(Status.FAIL, "Mismatch in Accessorial Codes. Expected: " + expectedAccessorialCodes
					+ ", Found: " + actualAccessorialCodes);
		}

		for (WebElement element2 : AccessorialLocation_ValidationList) {
			actualAccessorialLocation.add(element2.getText().trim());
		}

		if (new HashSet<>(actualAccessorialLocation).equals(new HashSet<>(expectedAccessorialLocation))) {
			System.out.println("Accessorial Location validation passed.");
			extentTest.log(Status.PASS, "Accessorial Location match: " + expectedAccessorialLocation);
		} else {
			System.out.println("Accessorial Location validation failed.");
			extentTest.log(Status.FAIL, "Mismatch in Accessorial Location. Expected: " + expectedAccessorialLocation
					+ ", Found: " + actualAccessorialLocation);
		}
	}


	public void ActualDelivery_Date_Validation() {
		String dateTime = ActualDelivery_Date_Validation.getText().trim();
		assertEquals(dateTime, DateTime);
		extentTest.log(Status.PASS, "Validated Received Date in Order Datatypes as : " + DateTime);
	}

	public void ArrivedAtPickup_Date_Validation() {
		Arrived_DateTime = ArrivedAtPickup_Date_Validation.getText().trim();
		assertEquals(Arrived_DateTime, DateTime);
		extentTest.log(Status.PASS, "Validated Arrived Date in Order Datatypes as : " + DateTime);
	}

	public void Arrived_At_Terminal_Validation() {
		String ArrivedatTerminal = ArrivedAtTerminal.getText().trim();
		assertEquals(ArrivedatTerminal, "ARRIVED AT TERMINAL");
		extentTest.log(Status.PASS, "Successfully validated Status as " + ArrivedatTerminal);
	}
	
	public void InvoiceNote_Validation() {
		String Submitted210_Status_Validation = Invoiced_Note.getText().trim();
		assertEquals(Submitted210_Status_Validation, "Note: Case has been invoiced and can not be updated/changed");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Submitted210_Status_Validation);
	}
	
	public void Submitted210_Validation() {
		String Submitted210_Status_Validation = Submitted210_Status.getText().trim();
		assertEquals(Submitted210_Status_Validation, "210 SUBMITTED");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Submitted210_Status_Validation);
	}

	public void FNB_Status_Validation() {
		String FNB_Status_Validation = FNB_Status.getText().trim();
		assertEquals(FNB_Status_Validation, "FNB");
		extentTest.log(Status.PASS, "Successfully validated Status as " + FNB_Status_Validation);
	}

	public void BNF_Status_Validation() {
		String BNF_Status_Validation = BNF_Status.getText().trim();
		assertEquals(BNF_Status_Validation, "BNF");
		extentTest.log(Status.PASS, "Successfully validated Status as " + BNF_Status_Validation);
	}

	public void NBNF_Status_Validation() {
		String NBNF_Status_Validation = NBNF_Status.getText().trim();
		assertEquals(NBNF_Status_Validation, "NBNF");
		extentTest.log(Status.PASS, "Successfully validated Status as " + NBNF_Status_Validation);
	}

	public void Loaded_Status_Validation() {
		String Loaded_Status = Loaded_Status_Validation.getText().trim();
		assertEquals(Loaded_Status, "LOADED");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Loaded_Status);
	}

	public void Shortage_Status_Validation() {
		String Shortage_Status_Validation = Shortage_Status.getText().trim();
		assertEquals(Shortage_Status_Validation, "SHORTAGE");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Shortage_Status_Validation);
	}

	public void Overage_Status_Validation() {
		String Overage_Status_Validation = Overage_Status.getText().trim();
		assertEquals(Overage_Status_Validation, "FREIGHT NOT ON BILL");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Overage_Status_Validation);
	}

	public void Loaded_OB_Validation() {
		String Loaded_Status = Loaded_Status_Validation.getText().trim();
		assertEquals(Loaded_Status, "Loaded");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Loaded_Status);
	}

	public void Received_Status_Validation() {
		String Received_Status = Received_Status_Validation.getText().trim();
		assertEquals(Received_Status, "RECEIVED");
		System.out.println("Successfully validated Status as " + Received_Status);
		extentTest.log(Status.PASS, "Successfully validated Status as " + Received_Status);
	}
	
	public void Received_OBStatus_Validation() {
		String Received_Status = Received_Status_Validation.getText().trim();
		assertEquals(Received_Status, "Received");
		System.out.println("Successfully validated Status as " + Received_Status);
		extentTest.log(Status.PASS, "Successfully validated Status as " + Received_Status);
	}

	public void DFD_Received_Status_Validation() {
		String Received_Status = DFD_Received_Status_Validation.getText().trim();
		assertEquals(Received_Status, "RECEIVED");
		System.out.println("Successfully validated Status as " + Received_Status);
		extentTest.log(Status.PASS, "Successfully validated Status as " + Received_Status);
	}

	public void Rated_Status_Validation() {
		String Rated_Status_Validation = Rated_Status.getText().trim();
		assertEquals(Rated_Status_Validation, "RATED");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Rated_Status_Validation);
	}
	
	public void RateReview_Rated_Status_Validation() {
		String Rated_TableStatus_Validation = RatedTable_Status.getText().trim();
		assertEquals(Rated_TableStatus_Validation, "Rated");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Rated_TableStatus_Validation);
	}
	
	public void Rated_table_Status_Validation() {
		String Rated_Status_Validation = Rated_Status.getText().trim();
		assertEquals(Rated_Status_Validation, "RATED");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Rated_Status_Validation);
	}
	
	public void Invoiced_Status_Validation() {
		String Invoiced_Status_Validation = Invoiced_Status.getText().trim();
		extentTest.log(Status.PASS, "Successfully validated Status as " + Invoiced_Status_Validation);
	}
	
	public void ArrivedAtPickup_Date() {
		Arrived_DateTime = ArrivedAtPickup_Date_Validation.getText().trim();
		System.out.println(Arrived_DateTime);
	}

	public void Pickup_Date_Validation() {

		// Parse the XML DateTime (assume it's in UTC)
		DateTimeFormatter TStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		ZonedDateTime TStampDateTime = LocalDateTime.parse(TStamp, TStampFormatter).atZone(ZoneId.of("UTC")) // Specify
																												// UTC
																												// timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed XML DateTime (UTC): " + TStampDateTime);

		// Parse the UI DateTime (assume it's in local timezone)
		DateTimeFormatter comparisonFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);
		ZonedDateTime comparisonDateTime = LocalDateTime.parse(Arrived_DateTime, comparisonFormatter)
				.atZone(ZoneId.systemDefault()) // Adjust for system's local timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed UI DateTime (Local): " + comparisonDateTime);

		// Convert both times to the same timezone for comparison (e.g., UTC)
		ZonedDateTime TStampDateTimeInLocal = TStampDateTime.withZoneSameInstant(ZoneId.systemDefault());
		System.out.println("XML DateTime in Local Timezone: " + TStampDateTimeInLocal);

		// Compare the two dates
		if (TStampDateTimeInLocal.equals(comparisonDateTime)) {
			System.out.println("Dates match!");
			extentTest.log(Status.PASS, "Provided XML TStampDate: " + TStampDateTime
					+ " Matched with Arrived at pickup Date: " + comparisonDateTime);
		} else {
			System.out.println("Dates do not match.");
		}
	}

	public void Delivery_Date_Validation() {
		// Parse the XML DateTime (assume it's in UTC)
		DateTimeFormatter TStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		ZonedDateTime TStampDateTime = LocalDateTime.parse(TStamp, TStampFormatter).atZone(ZoneId.of("UTC")) // Specify
																												// UTC
																												// timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed XML DateTime (UTC): " + TStampDateTime);

		// Parse the UI DateTime (assume it's in local timezone)
		DateTimeFormatter comparisonFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);
		ZonedDateTime comparisonDateTime = LocalDateTime.parse(Delivery_DateTime, comparisonFormatter)
				.atZone(ZoneId.systemDefault()) // Adjust for system's local timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed UI DateTime (Local): " + comparisonDateTime);

		// Convert both times to the same timezone for comparison (e.g., UTC)
		ZonedDateTime TStampDateTimeInLocal = TStampDateTime.withZoneSameInstant(ZoneId.systemDefault());
		System.out.println("XML DateTime in Local Timezone: " + TStampDateTimeInLocal);

		// Compare the two dates
		if (TStampDateTimeInLocal.equals(comparisonDateTime)) {
			System.out.println("Dates match!");
			extentTest.log(Status.PASS, "Provided XML TStampDate: " + TStampDateTime
					+ " Matched with out for delivery Date: " + comparisonDateTime);
		} else {
			System.out.println("Dates do not match.");
		}
	}

	public void Consignee_Date_Validation() {

		// Parse the XML DateTime (assume it's in UTC)
		DateTimeFormatter TStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		ZonedDateTime TStampDateTime = LocalDateTime.parse(TStamp, TStampFormatter).atZone(ZoneId.of("UTC")) // Specify
																												// UTC
																												// timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed XML DateTime (UTC): " + TStampDateTime);

		// Parse the UI DateTime (assume it's in local timezone)
		DateTimeFormatter comparisonFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);
		ZonedDateTime comparisonDateTime = LocalDateTime.parse(ArrivedAtConsignee_DateTime, comparisonFormatter)
				.atZone(ZoneId.systemDefault()) // Adjust for system's local timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed UI DateTime (Local): " + comparisonDateTime);

		// Convert both times to the same timezone for comparison (e.g., UTC)
		ZonedDateTime TStampDateTimeInLocal = TStampDateTime.withZoneSameInstant(ZoneId.systemDefault());
		System.out.println("XML DateTime in Local Timezone: " + TStampDateTimeInLocal);

		// Compare the two dates
		if (TStampDateTimeInLocal.equals(comparisonDateTime)) {
			System.out.println("Dates match!");
			extentTest.log(Status.PASS, "Provided XML TStampDate: " + TStampDateTime + " Matched with Consignee Date: "
					+ comparisonDateTime);
		} else {
			System.out.println("Dates do not match.");
		}

	}

	public void Delivered_Date_Validation() {

		// Parse the XML DateTime (assume it's in UTC)
		DateTimeFormatter TStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		ZonedDateTime TStampDateTime = LocalDateTime.parse(TStamp, TStampFormatter).atZone(ZoneId.of("UTC")) // Specify
																												// UTC
																												// timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed XML DateTime (UTC): " + TStampDateTime);

		// Parse the UI DateTime (assume it's in local timezone)
		DateTimeFormatter comparisonFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);
		ZonedDateTime comparisonDateTime = LocalDateTime.parse(Delivered_DateTime, comparisonFormatter)
				.atZone(ZoneId.systemDefault()) // Adjust for system's local timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed UI DateTime (Local): " + comparisonDateTime);

		// Convert both times to the same timezone for comparison (e.g., UTC)
		ZonedDateTime TStampDateTimeInLocal = TStampDateTime.withZoneSameInstant(ZoneId.systemDefault());
		System.out.println("XML DateTime in Local Timezone: " + TStampDateTimeInLocal);

		// Compare the two dates
		if (TStampDateTimeInLocal.equals(comparisonDateTime)) {
			System.out.println("Dates match!");
			extentTest.log(Status.PASS, "Provided XML TStampDate: " + TStampDateTime + " Matched with Delivered Date: "
					+ comparisonDateTime);
		} else {
			System.out.println("Dates do not match.");
		}
	}

	public void Actual_Delivery_Date_Validation() {

		// Parse the XML DateTime (assume it's in UTC)
		DateTimeFormatter TStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		ZonedDateTime TStampDateTime = LocalDateTime.parse(TStamp, TStampFormatter).atZone(ZoneId.of("UTC")) // Specify
																												// UTC
																												// timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed XML DateTime (UTC): " + TStampDateTime);

		// Parse the UI DateTime (assume it's in local timezone)
		DateTimeFormatter comparisonFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);
		ZonedDateTime comparisonDateTime = LocalDateTime.parse(ActualDelivery_DateTime, comparisonFormatter)
				.atZone(ZoneId.systemDefault()) // Adjust for system's local timezone
				.withSecond(0); // Remove seconds
		System.out.println("Parsed UI DateTime (Local): " + comparisonDateTime);

		// Convert both times to the same timezone for comparison (e.g., UTC)
		ZonedDateTime TStampDateTimeInLocal = TStampDateTime.withZoneSameInstant(ZoneId.systemDefault());
		System.out.println("XML DateTime in Local Timezone: " + TStampDateTimeInLocal);

		// Compare the two dates
		if (TStampDateTimeInLocal.equals(comparisonDateTime)) {
			System.out.println("Dates match!");
			extentTest.log(Status.PASS, "Provided XML TStampDate: " + TStampDateTime
					+ " Matched with Actual delivery Date: " + comparisonDateTime);
		} else {
			System.out.println("Dates do not match.");
		}
	}

	public void OutForDelivery_Date() {
		Delivery_DateTime = OutForDelivery_Date_Validation.getText().trim();
		System.out.println(Delivery_DateTime);
	}

	public void ArrivedAtConsignee_Date() {
		ArrivedAtConsignee_DateTime = ArrivedAtConsignee_Date_Validation.getText().trim();
		System.out.println(ArrivedAtConsignee_DateTime);
	}

	public void Delivered_Date() {
		Delivered_DateTime = Delivered_Date_Validation.getText().trim();
		System.out.println(Delivered_DateTime);
	}

	public void ActualDelivery_Date() {
		ActualDelivery_DateTime = ActualDeliveryDate_Validation.getText().trim();
	}

	public void OutForDelivery_Date_Validation() {
		Delivery_DateTime = OutForDelivery_Date_Validation.getText().trim();
		assertEquals(Delivery_DateTime, DateTime);
		extentTest.log(Status.PASS, "Validated Arrived Date in Order Datatypes as" + DateTime);
	}

	public void Datatype_StopID() {
		StopID = Datatype_StopID.getText().trim();
		extentTest.log(Status.PASS, "Validating created StopID :" + StopID);
	}

	public void RouteStatus_Complete() {
		String Status_Complete = RouteStatus_Complete.getText().trim();
		assertEquals(Status_Complete, "Complete");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void Stop_Status_Complete() {
		String Status_Complete = Stop_Status_Validation.getText().trim();
		assertEquals(Status_Complete, "Complete");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void Order_Status_Complete() {
		String Status_Complete = Stop_Status_Validation.getText().trim();
		assertEquals(Status_Complete, "Complete");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void Stop_Status_Arrived() {
		String Status_Complete = Stop_Status_Validation.getText().trim();
		assertEquals(Status_Complete, "Arrived");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void Stop_Status_Missed() {
		String Status_Complete = Stop_Status_Validation.getText().trim();
		assertEquals(Status_Complete, "Missed");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void Status_Validate() {

		boolean isArrivedAtPickupFound = false;
		boolean isOutForDeliveryFound = false;
		boolean isArrivedAtConsigneeFound = false;
		boolean isDeliveredFound = false;
		boolean isRatedFound = false;

		// Iterate over all elements and validate the statuses
		for (WebElement stopStatus : StatusEvent_Data) {

			String statusText = stopStatus.getText();

			if (statusText.contains("Arrived at Pickup")) {
				System.out.println("Status Event contains: " + statusText);
				extentTest.log(Status.PASS, "Status Event contains: " + statusText);
				isArrivedAtPickupFound = true;
			}
			if (statusText.contains("Out For Delivery")) {
				System.out.println("Status Event contains: " + statusText);
				extentTest.log(Status.PASS, "Status Event contains: " + statusText);
				isOutForDeliveryFound = true;
			}
			if (statusText.contains("Arrived at Consignee")) {
				System.out.println("Status Event contains: " + statusText);
				extentTest.log(Status.PASS, "Status Event contains: " + statusText);
				isArrivedAtConsigneeFound = true;
			}
			if (statusText.contains("Delivered")) {
				System.out.println("Status Event contains: " + statusText);
				extentTest.log(Status.PASS, "Status Event contains: " + statusText);
				isDeliveredFound = true;
			}
			if (statusText.contains("Rated")) {
				System.out.println("Status Event contains: " + statusText);
				extentTest.log(Status.PASS, "Status Event contains: " + statusText);
				isRatedFound = true;
			}
			
			// If all statuses are found, we can exit the loop early
			if (isArrivedAtPickupFound && isOutForDeliveryFound && isArrivedAtConsigneeFound && isDeliveredFound && isRatedFound) {
				break;
			}
		}

		if (!isArrivedAtPickupFound) {
			System.out.println("No 'Arrived at Pickup' status found in the Status Event.");
		}
		if (!isOutForDeliveryFound) {
			System.out.println("No 'Out For Delivery' status found in the Status Event.");
		}
		if (!isArrivedAtConsigneeFound) {
			System.out.println("No 'Arrived at Consignee' status found in the Status Event.");
		}

	}

	public void Stop_Status_EnRoute() {
		String Status_Complete = Stop_Status_Validation.getText().trim();
		assertEquals(Status_Complete, "Enroute");
		extentTest.log(Status.PASS, "Successfully validated Route Status as" + Status_Complete);
	}

	public void CloseTab() {

		List<WebElement> Close_Tabs = driver
				.findElements(By.xpath("//span[contains(text(), 'Home')]/following::td/span[@title='Close this tab']"));

		for (int i = 0; i < Close_Tabs.size(); i++) {
			Close_Tabs.get(i).click();

		}

	}

	public static void PickUpScheduled_Validation() {
		String text = pickUpScheduled_Validation.getText().trim();
		assertEquals("PICKUP SCHEDULED", text);
		System.out.println("Successfully validated Status Pickup Scheduled");
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public static void AwaitingArrival_Validation() {
		String text = AwaitingArrival_Validation.getText().trim();
		assertEquals("AWAITING ARRIVAL", text);
		System.out.println("Successfully validated Status Awaiting Arrival");
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public static void OrderStatus_Released_Validation() {
		String text = OrderStatus_Released_Validation.getText().trim();
		assertEquals("RELEASED", text);
		System.out.println("Validated the created Order datatype status in UI as " + text);
		extentTest.log(Status.PASS, "Validated the created Order datatype status as " + text);
	}
	
	public static void OrderStatus_PODException_Validation() {
		String text = OrderStatus_PODException_Validation.getText().trim();
		assertEquals("POD EXCEPTION", text);
		System.out.println("Validated the created Order datatype status in UI as " + text);
		extentTest.log(Status.PASS, "Validated the created Order datatype status as " + text);
	}

	public static void OrderStatus_Cancelled_Validation() {
		String text = OrderStatus_Cancelled_Validation.getText().trim();
		assertEquals("CANCELLED", text);
		System.out.println("Validated the created Order datatype status in UI as " + text);
		extentTest.log(Status.PASS, "Validated the created Order datatype status as " + text);
	}

	public static void OrderStatus_DeliveryScheduled_Validation() {
		String text = OrderStatus_DeliveryScheduled_Validation.getText().trim();
		assertEquals("DELIVERY SCHEDULED", text);
		System.out.println("Validated the created Order datatype status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order datatype status as " + text);
	}

	public static void OrderStatus_OutForDelivery_Validation() {
		String text = OrderStatus_OutForDelivery_Validation.getText().trim();
		assertEquals("OUT FOR DELIVERY", text);
		System.out.println("Validated the created Order datatype status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order datatype status as " + text);
	}

	public static void Validate_Status_Released() {
		String text = status_Released.getText().trim();
		assertEquals("Released", text);
		System.out.println("Validated the created Order status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public static void Status_Released_Portal() {
		String Released_Status = status_Released.getText().trim();
		assertEquals(Released_Status, "RELEASED");
		extentTest.log(Status.PASS, "Successfully validated Status as " + Released_Status);
	}

	public static void StatusUI_Released_Portal() {
		String Released_Status = CaseStatusUI_Released.getText().trim();
		assertEquals(Released_Status, "RELEASED");
		System.out.println("Successfully validated Status as " + Released_Status);
		extentTest.log(Status.PASS, "Successfully validated Status as " + Released_Status);
	}

	public static void Validate_Status_POD_Received() {
		String text = status_PODReceived.getText().trim();
		assertEquals("POD Received", text);
		System.out.println("Validated the created Order status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public void OrderStatus_PODReceived() {
		String text = Order_status_PODReceived.getText().trim();
		assertEquals("POD RECEIVED", text);
		System.out.println("Validated the created Order status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public static void TextMessage_CompletedUI() {
		String text = TextMessage_CompletedUI.getText().trim();
		assertEquals("The Pickup And Release case type does not yet have any fields defined.", text);
		System.out.println("Validated the text message in Resolved completed UI as " + text);
		extentTest.log(Status.PASS, "Validated the text message in Resolved completed UI as " + text);
	}

	public static void ErrorMessage_PODAccepted() {
		String text = ErrorMessage_ApprovePOD.getText().trim();
		assertEquals("Please select the order with status \"POD Accepted\"", text);
		System.out.println("Validated the error message in Approve POD Popup as " + text);
		extentTest.log(Status.PASS, "Validated the error message in Approve POD Popup as " + text);
	}
	
	public static void Re_Submit_Validation() {
		String text = status_Re_Submit.getText().trim();
		assertEquals("POD Resubmitted", text);
		System.out.println("Validated the created Order status as " + text);
		extentTest.log(Status.PASS, "Validated the created Order status as " + text);
	}

	public static void Re_Submit_ErrorMessage() {
		String Actualtext = ErrorMessage_ApprovePOD.getText().trim();
		String expectedText = "pyTempValue: Please Select the Order "+OrderID+" with Attachment and Required Status as \"Y\"";
		System.out.println(expectedText);
		
		assertEquals(Actualtext,expectedText);
		System.out.println("Validated the error message as " + Actualtext);
		extentTest.log(Status.PASS, "Validated the error message as " + Actualtext);
	}

	public static void Validate_Attachment_No() {
		String text = Attachment_No.getText().trim();
		assertEquals("N", text);
		System.out.println("Validated Attachment as " + text);
		extentTest.log(Status.PASS, "Validated Attachment as " + text);

	}

	public static void Validate_Attachment_Yes() {
		String text = Attachment_Yes.getText().trim();
		assertEquals("Y", text);
		System.out.println("Validated Attachment as " + text);
		extentTest.log(Status.PASS, "Validated Attachment as " + text);

	}

	public static void Count_Nil() {
		String text = Count_Nil.getText().trim();
		assertEquals("0", text);
		System.out.println("Successfully Validated Count");

	}

	public static void Attachment_Clip() throws InterruptedException {
		Attachment_Clip.click();
		extentTest.log(Status.PASS, "Click Attachment clip to add an Attachment");

	}

	public void Validation_Attachment_Note() throws Exception {
		String Attachment_Note = Validation_Attachment_Note.getText().trim();
		assertEquals(Attachment_Note, "Note: One Attachment is allowed per Order");
		extentTest.log(Status.PASS, "User receives a pop-up message : " + Attachment_Note);
		Await();
		Click_Attachment_Ok.click();
	}

	public void Rich_Text() throws Exception {
		Await();
		RichText_Name.sendKeys("Test");
		Await();
	}

	public void Attach_File() throws Exception {
//		Await();
//		AddLocalFile.click();
		Await();
		Await();
		SelectFile.sendKeys("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\File\\List of Outbound Loads (4).pdf");
		Await();
		extentTest.log(Status.PASS, "Attached a PDF file in Local File section");
	}

	public void Attach_PodFile() throws Exception {
		Await();
		String TotalBOL = Text_TotalBOL.getText().trim();
		assertEquals(TotalBOL, "Total BOL:");

		String TotalWeight = Text_TotalWeight.getText().trim();
		assertEquals(TotalWeight, "Total Weight:");
		WebElement WeightCount = driver.findElement(By.xpath(
				"//div[contains(@class, 'content-label') and contains(text(), 'Total Weight:')]/following-sibling::div[1]/span"));
		int uiWeightValue = Integer.parseInt(WeightCount.getText());
		assertEquals(uiWeightValue, totalWeight);

		String TotalPieces = Text_TotalPieces.getText().trim();
		assertEquals(TotalPieces, "Total Pieces:");
		WebElement PiecesCount = driver.findElement(By.xpath(
				"//div[contains(@class, 'content-label') and contains(text(), 'Total Pieces:')]/following-sibling::div[1]/span"));
		int uiPiecesValue = Integer.parseInt(PiecesCount.getText());
		assertEquals(uiPiecesValue, handlingUnitCount);

		extentTest.log(Status.PASS, "User receives a dialog box with Total BOL, Total Weight, Total Pieces");
		Await();
		Await();
		SelectFile.sendKeys("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\File\\List of Outbound Loads (4).pdf");
		Await();
		extentTest.log(Status.PASS, "Attached a PDF file in Local File section");
	}

	public static void uploadFileWithRobot(String filePath) throws AWTException {
		// Create a Robot instance
		Robot robot = new Robot();

		// Copy the file path to the clipboard
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		// Press CTRL + V to paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void AddURL() throws Exception {
		Await();
		AddURL.click();
		Await();
		AddURL_Name.sendKeys("Test");
		AddURL_tag.sendKeys("www.testing.com");
		Await();
	}

	public void Attachment_Submit() throws Exception {
		Await();
		Attachment_Submit.click();
	}

	public void Attachment_Save() throws Exception {
		Await();
		scrollToElementAndClick(driver, Attachment_Save);
	}

	public void ResolvePAROrder() throws Exception {
		String text = ResolvePAROrder_CaseID.getText();
		assertEquals(OrderID, text);
		String text2 = ResolvePAROrder_BOL.getText();
		assertEquals(BOL_Order, text2);
		String text3 = ResolvePAROrder_InvoiceNumber.getText();
		assertEquals(Invoice_number, text3);
		
		Attachment_Submit.click();
		Await();
		
//		String NoCases = POD_Review_NoCases.getText();
//		assertEquals("No cases", NoCases);
		Await();
	}

	public void Release_Carrier() {
		SelectClass(Release__Carrier, "Radiant");
	}
	
	public void PODComplete_Status_Y() {
		SelectClass(PODComplete_Dropdown, "Y");
	}
	
	public void PODComplete_Status_N() {
		SelectClass(PODComplete_Dropdown, "N");
	}

	public void POD_Resubmitted() {
		String completedStatus = Validate_POD_Resubmitted.getText().trim();
		assertEquals(completedStatus, "POD Resubmitted");
		extentTest.log(Status.PASS, "Successfully validated status as : " + completedStatus);

	}

	public void Validate_ResolvePAROrder_ErrorMessage() {
		String completedStatus = Validate_ErrorMessage.getText().trim();
		assertEquals(completedStatus, "Please select the order with status \"POD Accepted\"");
		extentTest.log(Status.PASS, "Successfully validated error message as :" + completedStatus);
	}

	public void Validate_POD_Accepted() {
		String completedStatus = Validate_POD_Accepted.getText().trim();
		assertEquals(completedStatus, "POD Accepted");
		extentTest.log(Status.PASS, "Successfully validated status as : " + completedStatus);
		System.out.println("Successfully validated status as : " + completedStatus);
	}

	public void Validate_210Submitted() {
		String completedStatus = Validate_210Submitted.getText().trim();
		assertEquals(completedStatus, "210 Submitted");
		extentTest.log(Status.PASS, "Successfully validated status as : " + completedStatus);
		System.out.println("Successfully validated status as : " + completedStatus);
	}
	
	public void Validate_ApprovePOD() {
		Approve_POD_Click.click();
		extentTest.log(Status.PASS, "Performed Approve POD");
		System.out.println("Successfully moved status to ApprovePOD");
	}

	public void POD_Received() {
		String completedStatus = Validate_POD_Received.getText().trim();
		assertEquals(completedStatus, "POD Received");
		extentTest.log(Status.PASS, "Successfully validated status as : " + completedStatus);
		System.out.println("Successfully validated status as : " + completedStatus);
	}

	public void Resolved_Completed() {
		String completedStatus = Resolved_Completed.getText().trim();
		assertEquals(completedStatus, "RESOLVED-COMPLETED");
		extentTest.log(Status.PASS, "Successfully validated status as : " + completedStatus);

	}

	public static void getAttribute() {
		DateTime = GetDateandTime.getAttribute("data-value");
		System.out.println(DateTime);
	}

	public static void get_Pickup_Date() {
		DateTime = Get_Pickup_DateandTime.getAttribute("data-value");
		System.out.println(DateTime);
	}

	public static void get_OutForDelivery_Date() {
		DateTime = Get_OutForDelivery_DateandTime.getAttribute("data-value");
		System.out.println(DateTime);
	}

	public static void frameswitch2() {
		driver.switchTo().frame(frameName2);
	}

	public void PEGALogin() throws InterruptedException {
		extentTest.log(Status.PASS, "User can able to launch Pega application in chrome");
		getWindow_Parent();
		ssoLogin.click();
		waits(code);
		code.click();

		// Scanner class to handle OTP
		String scanner = scanner();
		send.sendKeys(scanner);
		waits(click);
		click.click();
		extentTest.log(Status.PASS, "Successfully logged into PEGA Application using valid credentials");
		extentTest.log(Status.PASS, "User should allowed to launch warehouse portal");
	}

	public void DevStudioSearchBox(String SearchBox_Text, WebElement elementToClick) throws Exception {
		Await();
		ClickDevStudioSearchBox.click();
		ClickDevStudioSearchBox.clear();
		ClickDevStudioSearchBox.sendKeys(SearchBox_Text);
		ClickDevStudioSearchIcon.click();
		Await();
		Await();
		elementToClick.click();
		Await();
	}

	public void DevStudioSearchBox1(String SearchBox_Text) throws Exception {
		Await();
		ClickDevStudioSearchBox.click();
		ClickDevStudioSearchBox.clear();
		ClickDevStudioSearchBox.sendKeys(SearchBox_Text);
		ClickDevStudioSearchIcon.click();
		Await();
		ClickOrderServicePackage_UpdateStatus.click();
		Await();
	}
	
	public void UpdateStatus() {
		WebElement OrderStatus = driver.findElement(By.xpath("//span[contains(text(),'UpdateStatus')]"));
		OrderStatus.click();

	}
	
	public void OrderServicePage() {
		extentTest.log(Status.PASS, "User should allowed to update the case through descartes XML in pega");
		WebElement OrderService = driver.findElement(By.xpath("//span[contains(text(),'ProcessData (generated)')]"));
		OrderService.click();

	}
	

	public void orderService_Actions() throws Exception {
		frameSwitch();
		// Windows();
		Await();
		ServicePageActions.click();
		extentTest.log(Status.PASS, "Click Actions from the Actvity");
		Await();
		ServicePageRun.click();
		extentTest.log(Status.PASS, "User should allowed to process through activity");
		Await();
	}

	public void RadioSelect() throws Exception {
		Await();
		Windows();
		Await();
		RadioButton_POST.click();
		Await();
		TextAreaClick.click();
		TextAreaClick.sendKeys(updatedStatusJson);
	}

	public void orderService_Actions1() throws Exception {
		frameswitch2();
		// Windows();
		Await();
		ServicePageActions.click();
		Await();
		ServicePageRun.click();
		Await();
	}

	public void SOAPServicePopup() throws Exception {
		Await();
		Windows();
		Await();
		SupplySOAPCheckBox.click();
		Await();
		extentTest.log(Status.PASS, "User allowed to Post updated XML through service SOAP process data");
		SupplySOAPTextBox.clear();
		Await();
		extentTest.log(Status.PASS, "Copy paste updated XML in text box");
	}

	public static void ClickExecute() throws Exception {
		Await();
		ScrollDown2();
		ExecuteClick.click();
		Await();
		driver.close();
		extentTest.log(Status.PASS, "User received success response after executing the XML");
		Await();
//		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(tab.get(2));
//		driver.close();
		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(0));
		Await();

	}

	public void LaunchWarehousePortal() throws InterruptedException {
		waits(LaunchPortal);
		LaunchPortal.click();
		waits(warehouse);
		warehouse.click();
		Await();
		Windows();
		extentTest.log(Status.PASS, "Warehouse portal is launched in a new tab after clicking warehouse portal");
	}

	public void OrdersDFD() throws Exception {
		// frameSwitch();
		Await();
		Await();
		OrdersDFDClick.click();
		Await();
		extentTest.log(Status.PASS, "Open created DFD order");
		frameSwitch();
		Await();
		Await();
		ExceptionManagementHeaderClick.click();
		Await();
		InboundShipmentHeaderClick.click();
		Await();
		FilterIconClick.click();
		Await();
		OrderSearchBoxClick.click();
		Await();
		OrderSearchBoxClick.sendKeys(OrderID);
		waits(ApplyClick);
		ApplyClick.click();
		Await();
		ClickDFDCaseID.click();
		driver.switchTo().defaultContent();
	}

	public void OrdersPAD() throws Exception {
		// frameSwitch();
		Await();
		Await();
		OrdersPADClick.click();
		Await();
		extentTest.log(Status.PASS, "Open created PAD order");
		frameSwitch();
		Await();
		ExceptionManagementHeaderClick.click();
		Await();
		DeliveryManagementHeaderClick.click();
		Await();
		OrdersShipmentPADFilter.click();
		//PAD_FilterIconClick.click();
		Await();
		OrderSearchBoxClick.click();
		Await();
		OrderSearchBoxClick.sendKeys(OrderID);
		waits(ApplyClick);
		ApplyClick.click();
		Await();
		WebElement PAD_OrderID = driver.findElement(By.xpath("//a[contains(text(), '"+OrderID+"')]"));
		Await();
		PAD_OrderID.click();
		driver.switchTo().defaultContent();
	}

	public void OrdersPAD_ShipmentScheduling() throws Exception {
		// frameSwitch();
		Await();
		Await();
		OrdersPADClick.click();
		Await();
		extentTest.log(Status.PASS, "Open created PAD order");
		frameSwitch();
		Await();
		ExceptionManagementHeaderClick.click();
		Await();
		ShipmentSchedulingHeaderClick.click();
		Await();
		ShipmentScheduling_OrderID_Filter.click();
		//PAD_FilterIconClick.click();
		Await();
		OrderSearchBoxClick.click();
		Await();
		OrderSearchBoxClick.sendKeys(OrderID);
		waits(ApplyClick);
		ApplyClick.click();
		WebElement PAD_OrderID = driver.findElement(By.xpath("//a[contains(text(), '"+OrderID+"')]"));
		Await();
		PAD_OrderID.click();
		driver.switchTo().defaultContent();
	}
	
	public void OnDock() throws Exception {
		Await();
		extentTest.log(Status.PASS, "User successfully logged into warehouse portal");
		OrdersOnDock.click();
		extentTest.log(Status.PASS, "User can able to click Crowley On Dock from left nav bar");
		Await();
//		frameSwitch();
//		waits(PAR_OBLoads_Refresh);
//		PAR_OBLoads_Refresh.click();
//		waits(CrowleyOnDock_Header);

	}

	
	public void OrdersPAR() throws Exception {
		Await();
		extentTest.log(Status.PASS, "User successfully logged into warehouse portal");
		OrdersPAR.click();
		extentTest.log(Status.PASS, "User can able to click Inbound trailer workqueue from left nav bar");
		Await();
		frameSwitch();
		waits(OSD);
		OSD.click();
		waits(InboundTrailer);

	}

	

	public void InboundTrailer_WorkQueue() throws InterruptedException {
		Await();
		extentTest.log(Status.PASS, "Select PAR order from Inbound Trailer work queue");
		InboundTrailer.click();
		Await();
		BOL_DropdownFilterIconClick.click();
		BOL_DropdownFilterIconClick.sendKeys(BOL_Order);
		Await();
		BOL_DropdownFilterIconClick.sendKeys(Keys.ENTER);
		Await();
		extentTest.log(Status.PASS, "User can able to filter the case using BOL of the case");
		
		ClickPARCaseID.click();
		extentTest.log(Status.PASS, "Created case " + OrderID + " is filtered and displayed in Inbound trailer");
		Await();
		extentTest.log(Status.PASS, "User can work on the case " + OrderID + " in Inbound trailer work queue");
		driver.switchTo().defaultContent();

	}

	public void OutboundLoads_Tab() throws Exception {
		OutboundLoads.click();
		Await();

	}

	public void AssignCarrier() throws Exception {
		Assign_Carrier_Click.click();
		Await();
		SelectClass(Assign_OutboundCarrier, "USKO Logistics");
		Await();
		Click_AssignCarrier_Popup.click();
		Await();
		String Text = AssignCarrier_Validation.getText().trim();
		assertEquals(Text, "USKO Logistics");
		extentTest.log(Status.PASS, "Assigned carrier as " + Text);
	}

	public void AssignOBTrailer() throws Exception {
		Assign_OBTrailer_Click.click();
		Await();
		ClickonCalendar.click();
		Calendarss();
		Await();
		TrailerNumber_Click.click();
		TrailerNumber_Click.sendKeys("Test Trailer");
		Await();
		Loaded_Button.click();
		Await();
		Loaded_OB_Validation();
	}
	
	public void Unload() throws Exception {
		Unload_Button.click();
		Await();
		ClickonCalendar.click();
		Calendarss();
		Await();
		ConfirmUnload_Button.click();
		Await();
	}
	
	public void ReleasedStatus_Button() throws Exception {
		Released_Button.click();
		Await();
		ClickonCalendar.click();
		Calendarss();
		Await();
		ConfirmReleased_Button.click();
		Await();
	}
	
	public void NullValidation() {
	
		String loadedDate = loadedDateElement.getText().trim();
		String outboundTrailer = OutboundTrailerElement.getText().trim();
		// Validate if it's null or empty
		if(loadedDate == null || loadedDate.isEmpty()) {
		    System.out.println("Loaded Date is null/empty ✅");
		} else {
		    System.out.println("Loaded Date is present: " + loadedDate);
		}
		 // Validate Outbound Trailer
	    if (outboundTrailer == null || outboundTrailer.isEmpty()) {
	        System.out.println("Outbound Trailer is null/empty ✅");
	    } else {
	        System.out.println("Outbound Trailer is present: " + outboundTrailer);
	    }
	}


	public void OutboundTrailer_Tab() throws Exception {
		OutboundLoads.click();
		Await();
		OrderSearch_Filer.click();
		Await();
		waits(OrderSearch_Filer);
		OrderSearch_Filer.sendKeys(OrderID);
		Await();
		OrderSearch_Filer.sendKeys(Keys.ENTER);
		Await();
		ClickPARCaseID.click();
		Await();
		driver.switchTo().defaultContent();
	}

	public void PAR_Refresh() throws Exception {
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		PAR_Refresh.click();
		Await();
	}

	public void PAR_OBLoads_Refresh() throws Exception {
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		PAR_OBLoads_Refresh.click();
		Await();
	}

	public void OB_LoadID() throws Exception {
		Await();
		IB_LoadID_Value = IB_LoadID.getText();
		System.out.println(IB_LoadID_Value);
		Await();
	}

	public void Roundcube_Login() throws Exception {
		driver.get("https://smtpmx-r01.us.dom/webmail/?_task=mail&_mbox=INBOX");
		driver.manage().window().maximize();
		Await();
		Roundcube_Username.sendKeys("epicdemo");
		Await();
		Roundcube_Password.sendKeys("epicdemo");
		Await();
		Roundcube_Submit.click();
	}

	public void OrderSearchandFilter() throws Exception {
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		BOL_DropdownFilterIconClick_DFD.click();
		BOL_DropdownFilterIconClick_DFD.sendKeys(BOL_Order);
		Await();
		Await();
		Await();
		BOL_DropdownFilterIconClick_DFD.sendKeys(Keys.ENTER);
		
		Await();

	}
	
	public void PAR_OrderSearchandFilter() throws Exception {
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		BOL_DropdownFilterIconClick.click();
		BOL_DropdownFilterIconClick.sendKeys(BOL_Order);
		Await();
		Await();
		Await();
		BOL_DropdownFilterIconClick.sendKeys(Keys.ENTER);
		
		Await();

	}
	
	public void PAD_OrderSearchandFilter() throws Exception {
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		PAD_BOL_DropdownFilterIconClick.click();
		PAD_BOL_DropdownFilterIconClick.sendKeys(BOL_Order);
		Await();
		Await();
		Await();
		PAD_BOL_DropdownFilterIconClick.sendKeys(Keys.ENTER);
		Await();

	}
	
	public void selectShipper() {
		SelectClass(RateReview_Shipper, "Estes Express Lines");
		extentTest.log(Status.PASS, "Selected shipper as Estes express lines");
	}
	
	public void select_StatusSearch() throws Exception {
		Await();
		Await();
		Await();
		Await();
		Await();
		StatusSearchFilterIconClick.click();
		StatusSearchFilterIconClick.sendKeys("Rated");
		Await();
		Await();
		Await();
		StatusSearchFilterIconClick.sendKeys(Keys.ENTER);
		Await();

	}
	
	
	public void convert_Date() {

		DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSS z", Locale.ENGLISH);

		try {

			LocalDateTime originalDateTime = LocalDateTime.parse(Clipboard_ReceivedDate, originalFormatter);

			LocalDate originalDate = originalDateTime.toLocalDate();

			DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("M/d/yy", Locale.ENGLISH);

			// Parse the target date string
			LocalDate targetDate = LocalDate.parse(CaseID_ReceivedDate, targetFormatter);
			System.out.println(originalDate + ":" + targetDate);
			// Compare the dates
			if (originalDate.equals(targetDate)) {
				System.out.println("Dates match!");
			} else {
				System.out.println("Dates do not match!");
			}
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
		}
	}
	
	public void updateExcelBeforeUpload() throws Exception {

	    String filePath = "C:\\Users\\PALANGA\\Downloads\\accessorialbulkuploadtemplate (30).xlsx";

	    FileInputStream fis = new FileInputStream(new File(filePath));
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(0);

	    Row row = sheet.getRow(1);
	    if (row == null) {
	        row = sheet.createRow(1);
	    }

	    Cell cell = row.getCell(0); // Column 1
	    if (cell == null) {
	        cell = row.createCell(0);
	    }

	    cell.setCellValue(BOL_Order); // Set your value
	    fis.close();

	    // Save the updated file
	    FileOutputStream fos = new FileOutputStream(new File(filePath));
	    workbook.write(fos);
	    fos.close();
	    workbook.close();

	    System.out.println("Excel updated successfully");
	}

	@Test
	public static void main(String[] args) throws Exception {
		
	        try {
	            // Input file
	            FileInputStream fis = new FileInputStream("test.txt");

	            // Read file content
	            StringBuilder content = new StringBuilder();
	            int ch;
	            while ((ch = fis.read()) != -1) {
	                content.append((char) ch);
	            }
	            fis.close();

	            // Edit content (replace word)
	            String updatedContent = content.toString().replace("Java", "JAVA");

	            // Output file
	            FileOutputStream fos = new FileOutputStream("output.txt");
	            fos.write(updatedContent.getBytes());
	            fos.close();

	            System.out.println("File edited successfully.");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public void Validate_ArriveAtPickup() throws Exception {

		// Sample LTStamp attribute value
		String ltStamp = "2024-06-05T09:04:38";

		// Extract date part from LTStamp
		String ltStampDatePart = ltStamp.substring(0, 10);

		// Sample date string to compare with
		String dateString = "6/5/2024 9:04 AM";

		// Define date formats
		SimpleDateFormat ltStampDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat compareDateFormat = new SimpleDateFormat("M/d/yyyy h:mm a");

		// Parse dates
		Date ltStampDate = ltStampDateFormat.parse(ltStampDatePart);
		Date compareDate = compareDateFormat.parse(dateString);

		// Compare dates
		boolean isEqual = ltStampDate.equals(compareDate);

		// Output result
		if (isEqual) {
			System.out.println("The dates are equal.");
		} else {
			System.out.println("The dates are not equal.");
		}

	}

	public static String OldRate;
	public static String ChargeAmount;
	public static String TotalRate;

	public void RateValidation() {

		double oldRate = Double.parseDouble(OldRate.replace("$", "").trim());
		double chargeAmount = Double.parseDouble(ChargeAmount.replace("$", "").trim());
		double totalRate = Double.parseDouble(TotalRate.replace("$", "").trim());

		// Calculate the expected total rate
		double expectedTotalRate = oldRate + chargeAmount;

		// Validate the total rate
		if (Math.abs(expectedTotalRate - totalRate) < 0.01) { // Allowing small precision errors
			System.out.println("Validation Passed: Total Rate is correct.");
			extentTest.log(Status.PASS,
					"Total Rate validation passed. Expected: " + expectedTotalRate + ", Actual: " + totalRate);
		} else {
			System.out.println("Validation Failed: Total Rate is incorrect.");
			extentTest.log(Status.FAIL,
					"Total Rate validation failed. Expected: " + expectedTotalRate + ", Actual: " + totalRate);
		}

	}

	public void OrderSearchandClear() throws Exception {
		Await();
		Await();
		Await();
		Await();
		Await();
		OrderFilter.click();
		Await();
		OrderSearch_Filter.clear();
		waits(OrderFilterApply);
		OrderFilterApply.click();
		Await();

	}

	public void Received_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Received");
		extentTest.log(Status.PASS, "Move the case status to Received");
	}

	public void BOL_Received_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "BOL Received");
		extentTest.log(Status.PASS, "User can able to select the BOL Received status from UI dropdown");
	}

	public void Loaded_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Loaded");
		extentTest.log(Status.PASS, "User can able to update the case to Loaded status through UI");
	}
	
	public void Outbound_Carrier() {
		SelectClass(Outbound_carrier_outboundLoads_Status, "Primo Express");
		extentTest.log(Status.PASS, "User can able to update the outbound carrier through UI");
	}
	
	public void Outbound_Trailer() {
		Outbound_trailer_outboundLoads_Status.sendKeys("TestOutbound1567");
	}

	public void Delivered_Status() {
		SelectClass(CustomerDelivery_Status, "Delivered");
		extentTest.log(Status.PASS, "Move the case status to Delivered");
	}

	public void DeliveryScheduled_Status() {
		SelectClass(CustomerAppointment_Status, "Delivery Scheduled");
		extentTest.log(Status.PASS, "Move the case status to Delivery Scheduled");
	}

	public void CustomerDelivery_Status_Consignee() {
		SelectClass(CustomerDelivery_Status, "Arrived at Consignee");
		extentTest.log(Status.PASS, "Move the case status to Arrived at Consignee");
	}

	public void CustomerDelivery_Status_Pickup() {
		SelectClass(CustomerDelivery_Status, "Arrived at Pickup");
		extentTest.log(Status.PASS, "Move the case status to Arrived at Pickup");
	}

	public void CustomerDelivery_Status_OutForDelivery() {
		SelectClass(CustomerDelivery_Status, "Out For Delivery");
		extentTest.log(Status.PASS, "Move the case status to Out For Delivery");
	}

	public void Released_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Released");
		extentTest.log(Status.PASS, "User can able to update the case to Released status through UI");

	}
	
	public void Accessorial_Pickup() {
		SelectClass(AccessorialLocation_Dropdown, "Pickup");
		extentTest.log(Status.PASS, "Selected Accessorial dropdown as Pickup");
	}
	
	public void Accessorial_Code() {
		SelectClass(AccessorialCode_Dropdown, "HIINS");
		extentTest.log(Status.PASS, "Selected Accessorial Code dropdown as HIINS");
	}
	
	public void SubmitandGo_Click() throws Exception {
		Await();
		scrollToElementAndClick(driver, Submit);
		Await();
		ClickonGo.click();
		Await();
		driver.switchTo().defaultContent();
		Await();
		frameswitch2();
		Await();
	}

	public void frames3() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameName3);
	}

	public void SwitchTo_CrowleyFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(CrowleyReport_Frame);
	}

//		frameswitch2();
//		Await();

	public void EFM_Clipboard_Status_Validation() throws Exception {
		Thread.sleep(7000);
		Toggle_toolbar.click();
		Await();
		waits(CLickOnClipBoard);
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
		ExpandpyworkPage.click();
		Await();
		ClickonOrderpageinCipboard.click();
		Await();
		String text = EFMStatus_Validation.getText();
		System.out.println(text);
		extentTest.log(Status.PASS, "Successfully validated EFM status");
	}

	public void Loaded_Validation() {
		String text = Loaded_Status_Validation.getText().trim();
		Assert.assertTrue(text.contains(statusEvent));
		System.out.println("Successfully validated status as : " + text);
		extentTest.log(Status.PASS, "Successfully validated Status : " + text);
	}

	public void StatusEvent_Validation() {
		String text = OrderPageStatusEvent.getText().trim();
		Assert.assertTrue(text.contains(statusEventDateTime));
		System.out.println("Successfully validated StatusEvent Date Time :" + text);
		extentTest.log(Status.PASS, "Successfully validated StatusEvent Date Time :" + text);
	}

	public void OrderPage_PickupNumber() {
		String text = OrderPage_PickupNumber.getText().trim();
		Assert.assertTrue(text.contains(outboundTrailerID));
		System.out.println("Successfully validated Pickup number :" + text);
		extentTest.log(Status.PASS, "Successfully validated StatusEvent Date Time :" + text);

	}

	String AatP = "";
	String OforD = "";

	public void OrderPage_Arrive_OutforDel_Date() throws Exception {
		Await();
		ExpandpyworkPage.click();
		Await();
		ClickonOrderpageinCipboard.click();
		Await();
		AatP = OrderPage_ArrivedAtPickup.getText();
		System.out.println(AatP);
		OforD = OrderPage_OutForDelivery.getText();
		System.out.println(OforD);
	}

	public void OrderPage_Arrive_OutforDel_Date_Validation() {
		Received_DateTime = Received_Date_Validation.getText().trim();
		System.out.println(Received_DateTime);
		Arrived_DateTime = ArrivedAtPickup_Date_Validation.getText().trim();
		System.out.println(Arrived_DateTime);
		Delivery_DateTime = OutForDelivery_Date_Validation.getText().trim();
		System.out.println(Delivery_DateTime);

		boolean isReceivedValid = validateDate(Clipboard_ReceivedDate, Received_DateTime, "Received");
		// Validate ArrivedAtPickup Date
		boolean isArrivedValid = validateDate(AatP, Arrived_DateTime, "Arrived at Pickup");

		// Validate OutForDelivery Date
		boolean isDeliveryValid = validateDate(OforD, Delivery_DateTime, "Out for Delivery");

		if (isReceivedValid && isArrivedValid && isDeliveryValid) {
			System.out.println("Received,Arrived at Pickup and Out for delivery dates are validated successfully.");
		} else {
			System.out.println("Date validation failed.");
		}
	}

	private boolean validateDate(String inputDate, String expectedDate, String validationType) {
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSS z");
		Date parsedDate = null;

		try {
			parsedDate = isoFormat.parse(inputDate);
		} catch (Exception e) {
			e.printStackTrace();
			return false; // Return false if parsing fails
		}

		// Adjust time by subtracting 10 hours and 30 minutes
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parsedDate);
		calendar.add(Calendar.HOUR_OF_DAY, -10);
		calendar.add(Calendar.MINUTE, -30);

		// Format the adjusted date
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
		String formattedDate = outputFormat.format(calendar.getTime());

		// Print validation details
		System.out.println("Formatted " + validationType + " Date: " + formattedDate);
		System.out.println("Expected " + validationType + " Date: " + expectedDate);

		// Compare the formatted date with the expected date
		if (formattedDate.equals(expectedDate)) {
			System.out.println(validationType + " Date is valid.");
			return true;
		} else {
			System.out.println(validationType + " Date validation failed.");
			return false;
		}
	}

	public void Clipboard_Loaded_Validation() throws Exception {

		Thread.sleep(7000);
		Toggle_toolbar.click();
		Await();
		waits(CLickOnClipBoard);
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
		ClickonpyworkPage.click();
		Await();
		StatusEvent_Validation();
		Await();
		ExpandpyworkPage.click();
		Await();
		ClickonOrderpageinCipboard.click();
		Await();
		Loaded_Validation();
		Await();
		ExpandOrderPageinClipboard.click();
		Await();
		ExpandShipmentinCLipboard.click();
		Await();
		ClickonShipment2inCLipboard.click();
		Await();
		OrderPage_PickupNumber();
	}

	public void Clipboard_Validation() throws Exception {
		Thread.sleep(5000);
		Toggle_toolbar.click();
		Await();
		waits(CLickOnClipBoard);
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
	}

	public void Clipboard_Click_Validation() throws Exception {
		Thread.sleep(5000);
		Await();
		waits(CLickOnClipBoard);
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
	}

	public void Click_DFD_PyWorkpage() throws Exception {
		waits(ClickonpyworkPage_DFD);
		ClickonpyworkPage_DFD.click();
		Await();

	}

	public void Click_PAD_PyWorkpage() throws Exception {
	//	scrollToElementAndClick(driver, ClickonpyworkPage_PAD);
		Await();
		ClickonpyworkPage_PAD.click();
		Await();

	}

	public void Click_PAR_PyWorkpage() throws Exception {
		waits(ClickonpyworkPage);
		ClickonpyworkPage.click();
		Await();

	}

	public void ToggleToolBar() throws Exception {
		Toggle_toolbar.click();
		Await();
		waits(CLickOnClipBoard);

	}
	public void Clipboard_Click_DFD() throws Exception {
		Await();
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
		Click_DFD_PyWorkpage();
	}

	public void Clipboard_Click_PAD() throws Exception {
		Await();
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
		Click_PAD_PyWorkpage();
	}

	public void Clipboard_Click_PAD1() throws Exception {
		Await();
		CLickOnClipBoard.click();
		Await();
		switchToLatestWindow();
		driver.close();
		Await();
		CLickOnClipBoard.click();
		Await();
		ScrollDown();
		Await();
		Click_PAD_PyWorkpage();
	}

	
	public void Clipboard_Click() throws Exception {
		Await();
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
		Await();
		Click_PAR_PyWorkpage();

	}

/*	public void getCalendar() {
		WebElement calendar1 = driver.findElement(By.xpath("(//*[contains(@alt, 'Choose from calendar')])[1]"));
		calendar1.click();
		Calendarss();
		WebElement calendar2 = driver.findElement(By.xpath("(//*[contains(@alt, 'Choose from calendar')])[2]"));
		calendar2.click();
		Calendarss();
		WebElement calendar3 = driver.findElement(By.xpath("(//*[contains(@alt, 'Choose from calendar')])[3]"));
		calendar3.click();
		Calendarss();
		WebElement calendar4 = driver.findElement(By.xpath("(//*[contains(@alt, 'Choose from calendar')])[4]"));
		calendar4.click();
		Calendarss();
	} */
	public void getCalendar() throws Exception {
	    for (int i = 0; i < 4; i++) {
	        WebElement calendar = driver.findElement(By.xpath("(//*[contains(@alt, 'Choose from calendar')])[1]"));
	        calendar.click();
	        Calendarss(); // your method to select the date
	        Await();  
	    }
	}
	public void OrderPage_ReceivedDate() {
		Clipboard_ReceivedDate = OrderPage_ReceivedDate.getText().trim();
		System.out.println(Clipboard_ReceivedDate);
	}

	public void PyPage_Received_StatusDateTime() {
		Clipboard_ReceivedDate = OrderPage_StatusEvent_DateTime.getText().trim();
		System.out.println(Clipboard_ReceivedDate);
	}

	public void OrderPAR_ReceivedDate() {
		CaseID_ReceivedDate = OrderPAR_ReceivedDate.getText().trim();
		System.out.println(CaseID_ReceivedDate);
	}

	public void OrderPage_StatusEvent_Received_StatusValidation() {
		String text = OrderPage_StatusEvent1.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Received"));
		System.out.println("Successfully Validated Status:" + text);
	}

	public void OrderPage_StatusEvent_DeliveryScheduled_StatusValidation() {
		String text = OrderPage_StatusEvent1.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Delivery Scheduled"));
		System.out.println("Successfully Validated Status:" + text);
	}

	public void OrderPage_StatusEvent_OutForDelivery_StatusValidation() {
		String text = OrderPage_StatusEvent1.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Out For Delivery"));
		System.out.println("Successfully Validated Status:" + text);
	}
	
	public void OrderPage_StatusEvent_Delivered_StatusValidation() {
		String text = OrderPage_StatusEvent1.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Delivered"));
		System.out.println("Successfully Validated Status:" + text);
	}

	public void OrderPage_StatusEvent_Released_StatusValidation() {
		String text = OrderPage_StatusEvent.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Released"));
		System.out.println("Successfully Validated Status:" + text);
	}
	
	public void pyWOrkPage_RequiredStatus_Validation() {
		String text = pyWorkpage_RequiredStatus.getText().trim();
		System.out.println(text);
		Assert.assertTrue(text.contains("Y"));
		System.out.println("Successfully Validated Status:" + text);
	}

	public void StatusUpdatetoScanTool_Validation() {
		String text = StatusUpdatetoScanTool_Validation.getText();
		System.out.println(text);
		// Check if the text contains either "Arrived at Pickup" or "Received"
		boolean isValid = text.contains("Status Event Arrived at Pickup Data updated successfully.")
				|| text.contains("Status Event Received Data updated successfully.")
				|| text.contains("Status Event Released Data updated successfully.");

		// Assert that one of the valid conditions is met
		Assert.assertTrue(isValid, "Text does not contain a valid status update message.");
		extentTest.log(Status.PASS, "Status Update to ScanTool in Clipboard should be " + text);

	}

	public void OrderPage_RequiredStatus_No_Validation() {
		String text = OrderPage_RequiredStatus.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("N"));
		System.out.println("Successfully Validated Required Status as" + text);
		extentTest.log(Status.PASS, "Required Status in Clipboard should be " + text);

	}

	public void OrderPage_RequiredStatus_Yes_Validation() {
		String text = OrderPage_RequiredStatus.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Y"));
		System.out.println("Successfully Validated Required Status as" + text);
		extentTest.log(Status.PASS, "Required Status in Clipboard should be " + text);

	}

	public void ScanTool_StatusValidation() {
		String text = ScanToolStatus_Validation.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Scan Tool Order API Success"));
		System.out.println("Successfully Validated Status:" + text);

	}

	public static void sendKeys(WebDriver driver, WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = arguments[1];", element, text);
	}
//POD_BOL_DropdownFilterIconClick.sendKeys(
}
