package packageEL2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@SuppressWarnings("unused")
public class NewToResolve_PAR extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(priority = 2)
	public void PARCrowleyTL() throws Exception {
		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // CrowleyTL
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		driver.switchTo().defaultContent();

		ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab0.get(0));
		Await();
		Await();
		pom.ClickonRecentsIcon.click();
		// pom.DevStudioSearchBox();
		pom.OrderServicePage();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_ArrivedAtPickup_Status_Update();
		WebElement textArea = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea, filePath);
		pom.ClickExecute();
		Await();
		Await();
		pom.CloseTab();

		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		pom.waitForElementToBeVisibleAndClickable(driver, pom.Clickon_Datatype_Records, 6);
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
	//	pom.Clickon_Datatype_Records.click();
		pom.waitForElementToBeVisibleAndClickable(driver, pom.Clickon_Datatype_Records_Search, 8);
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.ArrivedAtPickup_Date();
		Await();
		Await();
		// pom.Pickup_Date_Validation();
		Await();
		// pom.Order_Data_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		Await();
		pom.ClickonRecentsIcon.click();
		pom.OrderServicePage();
//		pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_OutForDelivery_Status_Update();
		WebElement textArea1 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath1 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea1, filePath1);
		pom.ClickExecute();
		Await();
		pom.CloseTab();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		Await();
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.OutForDelivery_Date();
		Await();
		// pom.Delivery_Date_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		Await();
		pom.ClickonRecentsIcon.click();
		pom.OrderServicePage();
		// pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_ArrivedAtConsignee_Status_Update();
		WebElement textArea3 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath3 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea3, filePath3);
		pom.ClickExecute();
		Await();
		pom.CloseTab();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		Await();
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.ArrivedAtConsignee_Date();
		Await();
//		pom.Consignee_Date_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		Await();
		pom.ClickonRecentsIcon.click();
		pom.OrderServicePage();
//		pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_Delivered_Status_Update();
		WebElement textArea4 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath4 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea4, filePath4);
		pom.ClickExecute();
		Await();
		pom.CloseTab();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		Await();
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Delivered_Date();
		Await();
		// pom.Delivered_Date_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		pom.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		Thread.sleep(7000);
		Await();
		pom.ActionsButton();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.Arrived_At_Terminal_Validation();
		Await();

		pom.Status_File_FNB();
		pom.StatusUpdate_Process();
		pom.FNB_Status_Validation();
		Await();
		
		pom.ClickonGo.click();
		Await();
		pom.BOL_Received_Status();
		Await();
		pom.ClickonCalendar.click();
		pom.ClickonTodayDate.click();
		Await();
		scrollToElementAndClick(driver, pom.Submit);
		pom.Submit.click();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.Loaded_Status();
		Await();
		pom.Outbound_Trailer();
		Await();
		pom.Outbound_Carrier();

		scrollToElementAndClick(driver, pom.Submit);

		pom.Submit.click();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.Loaded_Status_Validation();
		Await();
		pom.Released_Status();
		Await();
		pom.ClickonCalendar.click();
		pom.ClickonTodayDate.click();
		Await();
		scrollToElementAndClick(driver, pom.Submit);
		pom.Submit.click();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.StatusUI_Released_Portal();

		// ------------------------
		Await();
		driver.switchTo().defaultContent();
		Await();
		pom.SwitchtoOrdersPAR();

		// ---------------------------------------------------------stop here
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.SwitchtoPODReview();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
//------------------------------------------------------

		pom.Validate_Status_Released();
		pom.Validate_Attachment_No();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.CrowleyTLPOD.click();
		// pom.frameSwitch();
		pom.frames3();
		pom.SelectIBLoadID.sendKeys(Keys.ENTER);
		pom.SelectIBLoadID.sendKeys(pom.Invoice_number);
		Await();
		pom.SelectIBLoadID.sendKeys(Keys.ENTER);
		Await();
		Dimension size = driver.manage().window().getSize();

		// Find center coordinates
		int centerX = size.getWidth() / 2;
		int centerY = size.getHeight() / 2;

		// Click at center of screen
		Actions actions = new Actions(driver);
		actions.moveByOffset(centerX, centerY).click().perform();
		Await();
		pom.Attach_POD_Click.click();
		Await();
		pom.Enter_IBLoadID.click();
		pom.Enter_IBLoadID.sendKeys(pom.Invoice_number);
		pom.Search_IBLoadID.click();
		Await();
		pom.Submit.click();
		Await();
		pom.AttachFile_POD
				.sendKeys("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\File\\List of Outbound Loads (4).pdf");
		Await();
		pom.Submit.click();
		Await();
		pom.driver.switchTo().defaultContent();

		pom.SwitchtoOrdersPAR();
		pom.frameSwitch();
		Await();
		pom.Order_Tab_Refresh.click();
		Await();
		pom.driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='PegaGadget0Ifr']")));
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.Validate_Attachment_Yes();

		Await();
		pom.POD_Received();
		Await();
		pom.CheckBox_Click.click();
		Await();
		Await();
		pom.Re_Submit_POD_Click.click();
		Await();
		pom.Re_Submit.click();
		Await();
		pom.Re_Submit_Validation();

		Await();

		pom.Validate_Attachment_Yes();
		Await();
		pom.Click_ViewDoc();
		Await();
		pom.Download_and_Delete_Document_Attached();
		pom.Validate_Status_Released();
		Await();

		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.CrowleyTLPOD.click();
		pom.frames3();
		pom.CrowleyTL_Refresh.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frames3();
		pom.SelectIBLoadID.sendKeys(Keys.ENTER);
		pom.SelectIBLoadID.sendKeys(pom.Invoice_number);
		Await();
		pom.SelectIBLoadID.sendKeys(Keys.ENTER);
		Await();

		pom.Attach_POD_Click.click();
		Await();
		pom.Enter_IBLoadID.click();
		pom.Enter_IBLoadID.sendKeys(pom.Invoice_number);
		pom.Search_IBLoadID.click();
		Await();
		pom.Submit.click();
		Await();
		pom.AttachFile_POD
				.sendKeys("C:\\Users\\palanga\\eclipse-workspace\\Sprint-35\\File\\List of Outbound Loads (4).pdf");
		Await();
		pom.Submit.click();
		Await();

		pom.driver.switchTo().defaultContent();
		pom.SwitchtoOrdersPAR();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.Order_Tab_Refresh.click();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.Validate_Attachment_Yes();
		Await();

		pom.POD_Received();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Validate_ApprovePOD();
		Await();
		pom.ResolvePAROrder();
		Await();
		pom.Validate_ResolvePAROrder_ErrorMessage();
		Await();
		pom.Close_AttachmentList_Box.click();
		driver.switchTo().defaultContent();
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(0));
		Await();
		Await();

		pom.ClickonRecentsIcon.click();
		pom.CrowleyConfirmPOD();
		pom.orderService_Actions();

//		pom.DevStudioSearchBox("ConfrimPOD", pom.ClickConfirmPOD);  
//		pom.orderService_Actions();
		driver.switchTo().defaultContent();
		Await();
		System.out.println(driver.getWindowHandles().size());
		pom.getWindow_Parent();
		Await();
		pom.switchToLatestWindow();
		Await();
		pom.pyIDTextBox.click();
		System.out.println("Clicked");
		pom.pyIDTextBox.sendKeys(pom.OrderID);
		pom.PODConfirmNum_TextBox.click();
		double POD_number = Math.ceil(Math.random() * 1000000);
		String POD_ConfirmNumber = Double.toString(POD_number);
		pom.PODConfirmNum_TextBox.sendKeys(POD_ConfirmNumber);
		System.out.println("Order ID entered");
		pom.Actions_Run.click();
		Await();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.switchTo().defaultContent();
		ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab3.get(1));
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		pom.Order_Tab_Refresh.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.Validate_POD_Accepted();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Validate_ApprovePOD();
		Await();
		//TC40: Verify that the user can approve the case when the required status and attachment type is in Y status.
		extentTest.log(Status.PASS, "User can approve the case when the required status and attachment type is in Y status");
		pom.ApprovePAR_Submit.click();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.switchtoOrdersPage();
		pom.frameswitch2();
		Thread.sleep(7000);
		Await();
		pom.ActionsButton();
		Await();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.Resolved_Completed();
		
		pom.driver.switchTo().defaultContent();
		Await();
		pom.Clipboard_Validation();
		pom.Click_PAR_PyWorkpage();
		Await();

		driver.close();

		

	}

	@SuppressWarnings("static-access")
	@Test
	public void PAR_LTL() throws Exception {

		Pom pom = new Pom(driver);
	//	pom.PAR_Order_Create(); // LTL or Truckload
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		driver.switchTo().defaultContent();
		ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab0.get(0));
		Await();
		Await();

		pom.ClickonRecentsIcon.click();
		pom.OrderServicePage();
		pom.orderService_Actions();

//		pom.DevStudioSearchBox("OrderServicePackage", pom.ClickOrderServicePackage);
//		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_ArrivedAtPickup_Status_Update();
		WebElement textArea = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea, filePath);
		pom.ClickExecute();
		Await();
		Await();
		pom.CloseTab();

		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		pom.waitForElementToBeVisibleAndClickable(driver, pom.Clickon_Datatype_Records, 6);
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
	//	pom.Clickon_Datatype_Records.click();
		pom.waitForElementToBeVisibleAndClickable(driver, pom.Clickon_Datatype_Records_Search, 8);
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.ArrivedAtPickup_Date();
		Await();
		Await();
		pom.Pickup_Date_Validation();
		Await();
	//	pom.Order_Data_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		// -------------------------------------------------------->
		pom.Clickon_RequestedAccessorial_Datatype.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		Await();
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		pom.ClickonRecentsIcon.click();
		pom.OrderServicePage();
		pom.orderService_Actions();

//		pom.DevStudioSearchBox("OrderServicePackage", pom.ClickOrderServicePackage);
//		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_OutForDelivery_Status_Update();
		WebElement textArea1 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath1 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea1, filePath1);
		pom.ClickExecute();
		Await();
		pom.CloseTab();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_Order_Datatype.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.Clickon_Datatype_Records_Search.sendKeys(pom.OrderID);
		Await();
		pom.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		pom.OutForDelivery_Date();
		Await();
		pom.Delivery_Date_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		pom.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		Thread.sleep(7000);
		Await();
		pom.ActionsButton();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.AwaitingArrival_Validation();
		Await();
		pom.Received_Status();
		Await();
		pom.ClickonCalendar.click();
		pom.ClickonTodayDate.click();
		Await();
		scrollToElementAndClick(driver, pom.Submit);
		// pom.Submit.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.Received_Status_Validation();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.SwitchtoOrdersPAR();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.OutboundLoads_Tab();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.AssignCarrier();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.AssignOBTrailer();
		Await();
		driver.switchTo().defaultContent();
		pom.SwitchtoOrderPage();
		pom.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();
		Thread.sleep(7000);
		Await();
		pom.ActionsButton();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.Loaded_Status_Validation();
		Await();
		pom.Released_Status();
		Await();
		pom.ClickonCalendar.click();
		pom.ClickonTodayDate.click();
		Await();
		scrollToElementAndClick(driver, pom.Submit);
		pom.Submit.click();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.StatusUI_Released_Portal();

		driver.switchTo().defaultContent();
		Await();
		pom.SwitchtoOrdersPAR();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.SwitchtoPODReview();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.Validate_Status_Released();
		pom.Validate_Attachment_No();
		Await();

		pom.CheckBox_Click.click();
		Await();
		pom.Attach_POD_Click.click();
		Await();
		pom.Attach_File();
		pom.Attachment_Save();
		Await();
//		pom.OrderSearchandFilter();
//		Await();
		pom.Validate_Attachment_Yes();
		Await();
//		pom.Attachment_Clip();
//		Await();
//		pom.Validation_Attachment_Note();
//		Await();
		pom.POD_Received();
//		Await();
//		pom.Validate_Attachment_Yes();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Re_Submit_POD_Click.click();
		Await();
		pom.Re_Submit.click();
		Await();
		pom.Re_Submit_Validation();
		Await();
		pom.Click_ViewDoc();
		Await();
		pom.Download_and_Delete_Document_Attached();
		Await();
		Await();
		pom.Validate_Status_Released();
		pom.Validate_Attachment_No();

		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Re_Submit_POD_Click.click();
		Await();
		pom.Re_Submit.click();
		Await();
		pom.Re_Submit_ErrorMessage();
		Await();
		pom.Close_AttachmentList_Box.click();
		Await();

		Await();
		pom.Attach_POD_Click.click();
		Await();
		pom.Attach_File();
		pom.Attachment_Save();
		Await();
		pom.Validate_Attachment_Yes();
		Await();
		pom.Order_Tab_Refresh.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();

		pom.CheckBox_Click.click();
		Await();
		pom.Re_Submit_POD_Click.click();
		Await();
		pom.Re_Submit.click();
//		Await();
//		pom.Close_AttachmentList_Box.click();
		Await();
		pom.Re_Submit_Validation();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Validate_ApprovePOD();
		Await();
		pom.ResolvePAROrder();
		Await();
		pom.Validate_ResolvePAROrder_ErrorMessage();
		Await();
		pom.Close_AttachmentList_Box.click();
		driver.switchTo().defaultContent();
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(0));
		Await();
		Await();
		pom.ClickonRecentsIcon.click();
		pom.CrowleyConfirmPOD();
		pom.orderService_Actions();

//		pom.DevStudioSearchBox("OrderServicePackage", pom.ClickOrderServicePackage);
//		pom.orderService_Actions();
		driver.switchTo().defaultContent();
		Await();
		System.out.println(driver.getWindowHandles().size());
		pom.getWindow_Parent();
		Await();
		pom.switchToLatestWindow();
		Await();
		pom.pyIDTextBox.click();
		System.out.println("Clicked");
		pom.pyIDTextBox.sendKeys(pom.OrderID);
		pom.PODConfirmNum_TextBox.click();
		double POD_number = Math.ceil(Math.random() * 1000000);
		String POD_ConfirmNumber = Double.toString(POD_number);
		pom.PODConfirmNum_TextBox.sendKeys(POD_ConfirmNumber);
		System.out.println("Order ID entered");
		pom.Actions_Run.click();
		Await();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.switchTo().defaultContent();
		ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab3.get(1));
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		pom.Order_Tab_Refresh.click();
		Await();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.PAR_OrderSearchandFilter();
		Await();
		pom.Validate_POD_Accepted();
		Await();
		pom.CheckBox_Click.click();
		Await();
		pom.Validate_ApprovePOD();
		Await();
		pom.ApprovePAR_Submit.click();

	}

	@SuppressWarnings("static-access")
	@Test
	public void PAR_Status_Update_PositiveFlow() throws Exception {

		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // CrowleyTL
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		Await();

		pom.StatusUpdate_Received();
		pom.StatusUpdate_Process();
		pom.Received_Status_Validation();
		Await();

		pom.StatusUpdate_Loaded();
		pom.StatusUpdate_Process();
		pom.Loaded_Status_Validation();
		Await();

		pom.StatusUpdate_Released();
		pom.StatusUpdate_Process();
		pom.OrderStatus_Released_Validation();
		Await();
	}

	@SuppressWarnings("static-access")
	@Test
	public void DFD_RatedStatus() throws Exception {
		Pom login = new Pom(driver);
		login.DFD_NewOrder();
		Await();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersDFD();
		Await();
		login.frameswitch2();
		Await();
		login.Received_Status();
		Await();
		login.ClickonCalendar.click();
		login.Calendarss();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.DeliveryScheduled_Status();
		Await();
		login.ClickonCalendar_DeliveryAppointment.click();
		login.Calendarss();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.CustomerDelivery_Status_Pickup();
		Await();
		login.ClickonCalendar_POD_review.click();
		login.Calendarss();
		Await();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.OrderStatus_DeliveryScheduled_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.Clipboard_Validation();
		login.Click_DFD_PyWorkpage();
		login.OrderPage_StatusEvent_DeliveryScheduled_StatusValidation();
		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		login.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();

		login.CustomerDelivery_Status_OutForDelivery();
		Await();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.OrderStatus_OutForDelivery_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.Clipboard_Click_DFD();
		login.OrderPage_StatusEvent_OutForDelivery_StatusValidation();
		Await();
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		login.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();
		login.CustomerDelivery_Status_Consignee();
		Await();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.OrderStatus_OutForDelivery_Validation();
		login.driver.switchTo().defaultContent();
		Await();
		login.Clipboard_Click_DFD();
		login.OrderPage_StatusEvent_OutForDelivery_StatusValidation();
		Await();

		driver.close();
		Await();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		Await();
		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Status_Datatype.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		login.Clickon_Datatype_Records.click();
		Await();
		Await();
		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		login.Status_Validate();
		ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab3.get(1));
		login.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		login.Delivered_Status();
		Await();
		login.CustomerDelivery_Calendar.click();
		login.Calendarss();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameswitch2();
		login.Rated_Status_Validation();

		login.driver.switchTo().defaultContent();
		Await();

		ArrayList<String> tab4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab4.get(0));
		Await();
		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Status_Datatype.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		login.Clickon_Datatype_Records.click();
		Await();
		Await();
//		login.Clickon_Datatype_Records_Search.clear();
//		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		login.Status_Validate();
		login.driver.switchTo().defaultContent();
		login.CloseTab();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(1));
		login.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();
		login.PODComplete_Edit.click();
		Await();
		login.PODComplete_Status_Y();
		Await();
		Await();
		scrollToElementAndClick(driver, login.SaveChanges);
		Await();
		login.ClickonGo.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.Add_Accessorial.click();
		Await();
		login.Accessorial_Pickup();
		login.Accessorial_Code();
		login.SaveAccessorial.click();
		Await();
		login.RequestNewRate.click();
		Await();
		Await();
		scrollToElementAndClick(driver, login.SaveChanges);
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		login.RateReview_Workpage.click();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		WebElement OrderId_CheckBox_Click = driver.findElement(By.xpath(
				"(//tr[.//a[normalize-space(text())='" + login.OrderID.trim() + "']]//input[@type='checkbox'])[1]"));
		OrderId_CheckBox_Click.click();
		Await();
		login.Submit210_Click.click();
		Await();
		login.Submit210_Submit.click();
		Await();
		login.Validate_210Submitted(); // failure
		login.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		login.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.Submitted210_Validation();
		Await();
		login.ClickonGo.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		login.InvoiceNote_Validation();
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		WebElement OrderId_CheckBox_Click1 = driver.findElement(By.xpath(
				"(//tr[.//a[normalize-space(text())='" + login.OrderID.trim() + "']]//input[@type='checkbox'])[2]"));
		OrderId_CheckBox_Click1.click();
		Await();
		login.ConfirmPaid_Click.click();
		Await();
		login.ConfirmPaid_Submit.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		login.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.Resolved_Completed();
	}

	@SuppressWarnings("static-access")
	@Test
	public void PAR_Status_Update_ExceptionFlow() throws Exception {

		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // CrowleyTL
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		Await();

		/*
		 * pom.Status_File_FNB(); pom.StatusUpdate_Process();
		 * pom.FNB_Status_Validation(); Await();
		 */

		pom.Status_File_BNF();
		pom.StatusUpdate_Process();
		pom.BNF_Status_Validation();
		Await();

		/*
		 * pom.Status_File_NBNF(); pom.StatusUpdate_Process();
		 * pom.NBNF_Status_Validation(); Await();
		 * 
		 * pom.Status_File_Shortage(); pom.StatusUpdate_Process();
		 * pom.Shortage_Status_Validation(); Await();
		 * 
		 * pom.Status_File_Overage(); pom.StatusUpdate_Process();
		 * pom.Overage_Status_Validation(); Await();
		 */

		pom.StatusUpdate_Received();
		pom.StatusUpdate_Process();
		pom.Received_Status_Validation();

		pom.StatusUpdate_Loaded();
		pom.StatusUpdate_Process();
		pom.Loaded_Status_Validation();
		Await();

		pom.StatusUpdate_UnLoaded();
		pom.StatusUpdate_Process();
		pom.Received_Status_Validation();
		Await();

		pom.StatusUpdate_Loaded();
		pom.StatusUpdate_Process();
		pom.Loaded_Status_Validation();
		Await();

//		pom.StatusUpdate_Cancelled();
//		pom.StatusUpdate_Process();
//		pom.OrderStatus_Cancelled_Validation();      // failure
//		Await();

		pom.StatusUpdate_Released();
		pom.StatusUpdate_Process();
		pom.OrderStatus_Released_Validation();

	}

	@SuppressWarnings("static-access")
	@Test
	public void PAR_ReviveResolvedCancelled() throws Exception {

		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // CrowleyTL
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled(); // Change credentials for PROD
		pom.PAR_Refresh();
		pom.StatusUpdate_Received();
		pom.StatusUpdate();
		pom.OutboundLoads();
		pom.OrderFromOutboundLoads();
		pom.Received_Status_Validation();

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		Await();
		pom.PAR_OBLoads_Refresh();
		pom.StatusUpdate_Loaded();
		pom.StatusUpdate();
		pom.OrderFromOutboundLoads();
		pom.Loaded_Status_Validation();

	/*	Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.Status_File_FNB();
		pom.StatusUpdate();
		pom.OSnDClick();
		pom.OrderFromOSandD();
		pom.FNB_Status_Validation();

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.Status_File_BNF();
		pom.StatusUpdate();
		pom.PAR_OBLoads_Refresh();
		pom.OrderFromOSandD();
		pom.BNF_Status_Validation();

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.Status_File_NBNF();
		pom.StatusUpdate();
		pom.PAR_OBLoads_Refresh();
		pom.OrderFromOSandD();
		pom.NBNF_Status_Validation();

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.Status_File_Shortage();
		pom.StatusUpdate();
		pom.PAR_OBLoads_Refresh();
		pom.OrderFromOSandD();
		pom.Shortage_Status_Validation();

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.Status_File_Overage();
		pom.StatusUpdate();
		pom.PAR_OBLoads_Refresh();
		pom.OrderFromOSandD();
		pom.Overage_Status_Validation(); */

		Await();
		driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resolved_Cancelled();
		pom.PAR_OBLoads_Refresh();
		pom.StatusUpdate_UnLoaded();
		pom.StatusUpdate();
		pom.PAR_OBLoads_Refresh();
	//	pom.OutboundLoads();
		pom.OrderFromOutboundLoads();
		pom.Received_Status_Validation();
	}
}
