package packageEL2;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class PARRated extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	public void PARCrowleyTL() throws Exception {
		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // CrowleyTL
		BaseClass.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OrdersPAR();
		pom.InboundTrailer_WorkQueue();
		Pom.frameswitch2();
		Thread.sleep(7000);
		pom.PickUpScheduled_Validation();
		driver.switchTo().defaultContent();
		ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab0.get(0));
		Await();
		Await();
		pom.DevStudioSearchBox();
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
		pom.Clickon_Datatype_Records.click();
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
	//	pom.Pickup_Date_Validation();
		Await();
		pom.Order_Data_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		pom.DevStudioSearchBox();
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
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		pom.Clickon_Datatype_Records.click();
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
	//	pom.Delivery_Date_Validation();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		pom.DevStudioSearchBox();
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
		pom.Clickon_Datatype_Records.click();
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

		pom.DevStudioSearchBox();
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
		pom.Clickon_Datatype_Records.click();
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
	//	pom.Delivered_Date_Validation();
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
		pom.Status_File_BNF();

		pom.StatusUpdate_Process();
		pom.BNF_Status_Validation();
		Await();

		pom.Status_File_NBNF();
		pom.StatusUpdate_Process();
		pom.NBNF_Status_Validation();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.BOL_Received_Status();
		Await();
		pom.ClickonCalendar.click();
		pom.ClickonTodayDate.click();
		Await();
		pom.SubmitandGo_Click();
		pom.Received_Status_Validation();
		Await();
		String POD_BOL = pom.PODReview_BOL.getText();
		assertEquals(pom.BOL_Order, POD_BOL);
		System.out.println("Validated BOL");
		
		String POD_IBLoadID =pom.PODReview_IBLoadID.getText();
		assertEquals(pom.Tracking_Number, POD_IBLoadID);
        System.out.println("Validated IBLoadID");
		
		String POD_IBTrailer = pom.PODReview_IBTrailer.getText();
		assertEquals(pom.Pickup_Number, POD_IBTrailer);
		System.out.println("Validated IBTrailer");
		
		String POD_OBLoadID =pom.PODReview_OBLoadID.getText();
		assertEquals(pom.Delivery_Number, POD_OBLoadID);
		System.out.println("Validated OBLoadID");
		
		String total = pom.PODReview_TotalWt.getText();
		int actualtotal = (int) Math.round(Double.parseDouble(total));
		System.out.println("PODTotalwt : "+actualtotal);
		int weightInt = (int) Double.parseDouble(total);
		System.out.println(weightInt);
		assertEquals(pom.totalWeight, weightInt);
		
		
		String totalHU = pom.PODReview_TotalHU.getText();
		assertEquals(pom.handlingUnitCount, totalHU);
		
		pom.Loaded_Status();
		Await();
		scrollToElementAndClick(driver, pom.Submit);
		pom.Submit.click();
		Await();
		pom.ClickonGo.click();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.frameswitch2();
		pom.Loaded_Status_Validation();
		
		assertEquals(pom.BOL_Order, POD_BOL);
		System.out.println("Validated BOL");
		
		assertEquals(pom.Tracking_Number, POD_IBLoadID);
        System.out.println("Validated IBLoadID");
		
		assertEquals(pom.Pickup_Number, POD_IBTrailer);
		System.out.println("Validated IBTrailer");
		
		assertEquals(pom.Delivery_Number, POD_OBLoadID);
		System.out.println("Validated OBLoadID");
		
		assertEquals(pom.totalWeight, weightInt);
		
		assertEquals(pom.handlingUnitCount, totalHU);
		
		driver.switchTo().defaultContent();
		Await();
		pom.SwitchtoOrdersPAR();
		pom.driver.switchTo().defaultContent();
		Await();
		pom.frameSwitch();
		Await();
		
		pom.OutboundTrailer_Tab();
		
		
	}
}
