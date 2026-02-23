package packageEL2;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrdersDFD extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	public void DFD_Rating() throws Exception {

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
		login.frameswitch2();
		login.Received_Status_Validation();
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

		ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab0.get(0));
		Await();
		Await();
		login.ClickonRecentsIcon.click();
		// pom.DevStudioSearchBox();
		login.OrderServicePage();
		login.orderService_Actions();
		login.SOAPServicePopup();
		login.PAR_ArrivedAtPickup_Status_Update();
		WebElement textArea = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		login.sendKeysJavascript(driver, textArea, filePath);
		login.ClickExecute();
		Await();
		Await();
		login.CloseTab();

		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Order_Datatype.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		login.waitForElementToBeVisibleAndClickable(driver, login.Clickon_Datatype_Records, 6);
		login.Clickon_Datatype_Records.click();
		Await();
		login.Clickon_Datatype_Records.click();
		login.waitForElementToBeVisibleAndClickable(driver, login.Clickon_Datatype_Records_Search, 8);
		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		login.ArrivedAtPickup_Date();
		Await();
		Await();
		login.Pickup_Date_Validation();
		Await();
//		login.Order_Data_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		login.CloseTab();

		Await();
		login.ClickonRecentsIcon.click();
		// pom.DevStudioSearchBox();
		login.OrderServicePage();
		login.orderService_Actions();
		login.SOAPServicePopup();
		login.PAR_OutForDelivery_Status_Update();
		WebElement textArea1 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath1 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		login.sendKeysJavascript(driver, textArea1, filePath1);
		login.ClickExecute();
		Await();
		login.CloseTab();
		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Order_Datatype.click();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		login.Clickon_Datatype_Records.click();
		Await();
		Await();
		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		Await();
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		login.OutForDelivery_Date();
		Await();
		login.Delivery_Date_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		login.CloseTab();

		Await();
		login.ClickonRecentsIcon.click();
		// pom.DevStudioSearchBox();
		login.OrderServicePage();
		login.orderService_Actions();
		login.SOAPServicePopup();
		login.PAR_ArrivedAtConsignee_Status_Update();
		WebElement textArea3 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath3 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		login.sendKeysJavascript(driver, textArea3, filePath3);
		login.ClickExecute();
		Await();
		login.CloseTab();
		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Order_Datatype.click();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		login.Clickon_Datatype_Records.click();
		Await();
		Await();
		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		Await();
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		login.ArrivedAtConsignee_Date();
		Await();
		login.Consignee_Date_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		login.CloseTab();

		Await();
		login.ClickonRecentsIcon.click();
		// pom.DevStudioSearchBox();
		login.OrderServicePage();
		login.orderService_Actions();
		login.SOAPServicePopup();
		login.PAR_Delivered_Status_Update();
		WebElement textArea4 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath4 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\Status_Update.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		login.sendKeysJavascript(driver, textArea4, filePath4);
		login.ClickExecute();
		Await();
		login.CloseTab();
		login.ClickonDatatypesIcon.click();
		Await();
		login.Clickon_Order_Datatype.click();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameSwitch();
		Await();
		login.Clickon_Datatype_Records.click();
		Await();
		Await();
		login.Clickon_Datatype_Records_Search.sendKeys(login.OrderID);
		Await();
		login.Clickon_Datatype_Records_SearchIcon.click();
		Await();
		Await();
		Await();
		Await();
		Await();
		login.ActualDelivery_Date();
		Await();
		login.Actual_Delivery_Date_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		login.CloseTab();
		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
		Thread.sleep(7000);
		Await();
		login.ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.ClickonGo.click();
		Await();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();

		login.Rated_Status_Validation();
		Await();
		String TotalRate1 = login.Total_Rate.getText();
		System.out.println("TotalRate: "+ TotalRate1);
		String LineHaul1 = login.LineHaul_Rate.getText();
		System.out.println("LineHaul: "+LineHaul1);
		String Fuel1 = login.Fuel.getText();
		System.out.println("Fuel:" +Fuel1);
		String TotalAccessorial1 = login.Total_Accessorial.getText();
        System.out.println("TotalAccessorial: "+ TotalAccessorial1);
		
		login.driver.switchTo().defaultContent();   
		login.switchTo_OrdersDFD.click();     
		login.frameSwitch();
		login.RateReview_Workpage.click();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.SubmitPOD_Validation();
		login.RateReview_Rated_Status_Validation();
		login.driver.switchTo().defaultContent();
		Await();
		login.SwitchtoOrderPage();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		login.PODComplete_Edit.click();
		Await();
		login.PODComplete_Status_Y();
		Await();
		scrollToElementAndClick(driver, login.SaveChanges);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		login.updateExcelBeforeUpload();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		login.Order_Tab_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.ReadyToInvoice_Validation();
		Await();
		login.UploadAccessorials_Click.click();
		Await();
		login.ChooseFile_BulkAccessorial.sendKeys("C:\\Users\\PALANGA\\Downloads\\accessorialbulkuploadtemplate (30).xlsx");
		Await();
		login.ChooseFile_UpdateAccessorial.click();
		Await();
		login.CompleteUpdate.click();
		Await();
		Await();
		login.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		
		Await();
		Await();
		login.ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.ClickonGo.click();
		Await();
		
		login.Rated_Status_Validation();
		Await();
		String TotalRate = login.Total_Rate.getText();
		System.out.println("TotalRate: "+ TotalRate);
		String LineHaul = login.LineHaul_Rate.getText();
		System.out.println("LineHaul: "+LineHaul);
		String Fuel = login.Fuel.getText();
		System.out.println("Fuel:" +Fuel);
		String TotalAccessorial = login.Total_Accessorial.getText();
        System.out.println("TotalAccessorial: "+ TotalAccessorial);
		
		login.PODComplete_Edit.click();
		Await();
		login.PODComplete_Status_N();
		Await();
		Await();
		scrollToElementAndClick(driver, login.SaveChanges);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		login.Order_Tab_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.SubmitPOD_Validation();
		driver.switchTo().defaultContent();
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(0));   
		Await();
		login.ClickonRecentsIcon.click();
		login.OrderServicePage();
		login.orderService_Actions();
		login.SOAPServicePopup();
		login.POD_Signature_XML_Write();
		WebElement textArea2 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath2 = "C:\\Users\\PALANGA\\eclipse-workspace\\EL2-Automation\\PODSignature.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		login.sendKeysJavascript(driver, textArea2, filePath2);
		login.ClickExecute();
		Await();
		Await();
		login.CloseTab();
		Await();
		ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab3.get(1));
		login.driver.switchTo().defaultContent();
		Await();
		login.SwitchtoOrderPage();
		Await();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		Await();
		login.ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.ClickonGo.click();
		Await();
		login.PODComplete_Status_Validation();
		login.Required_Status_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.ToggleToolBar();
		login.Clipboard_Click_DFD();
		login.pyWOrkPage_RequiredStatus_Validation();
		login.OrderPage_StatusEvent_Delivered_StatusValidation();
		Await();
		driver.close();
		Await();
		ArrayList<String> tab4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab4.get(1));
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		Await();
		login.RateReview_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.selectShipper();
		login.select_StatusSearch();
		Await();
		WebElement OrderId_CheckBox_Click = driver.findElement(By.xpath(
				"(//tr[.//a[normalize-space(text())='" + login.OrderID.trim() + "']]//input[@type='checkbox'])[1]"));
		OrderId_CheckBox_Click.click();
		Await();
		login.GenerateInvoice_Click.click();
		Await();
		String Linehaul_popup = login.Invoice_Linehaul.getText();
		String FSCCharge_popup = login.Invoice_FSCCharge.getText();
		String TotalAccessorial_popup = login.Invoice_TotalAccessorial.getText();
		String TotalAmount_popup = login.Invoice_TotalAmount.getText();

		assertEquals(LineHaul, Linehaul_popup);
		assertEquals(Fuel, FSCCharge_popup);
		assertEquals(TotalAccessorial, TotalAccessorial_popup);
		assertEquals(TotalRate, TotalAmount_popup);
		System.out.println("Successfully validated charges");
		login.GenerateInvoice_Submit.click(); //-------------------------------------Failure
		Await();
		login.CloseTab();
		Await();
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersDFD.click();
		login.frameSwitch();
		Await();
		login.RateReview_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.Invoiced_Status_Validation();
		Await();
//		login.Click_ViewDoc();
//		Await();
//		login.Download_Attached_Doc();
//		Await();
		WebElement OrderId_CheckBox_Click1 = driver.findElement(By.xpath(
				"(//tr[.//a[normalize-space(text())='" + login.OrderID.trim() + "']]//input[@type='checkbox'])[1]"));
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
		
		
	/*	String BFTotalCharge = login.Base_FuelTotalCharge.getText();
		double linehaul = Double.parseDouble(LineHaul.replace("$", ""));
		double fscCharge = Double.parseDouble(Fuel.replace("$", ""));
		double totalBaseFuel = Double.parseDouble(BFTotalCharge.replace("$", ""));

		// Add the values
		double calculatedTotal = linehaul + fscCharge;

		// Compare
		if (calculatedTotal == totalBaseFuel) {
			System.out.println("Match: " + calculatedTotal + " equals " + totalBaseFuel);
		} else {
			System.out.println("Mismatch: Calculated = " + calculatedTotal + ", Expected = " + totalBaseFuel);
		}   */

	}

	@SuppressWarnings("static-access")
	@Test
	public void DFD_Rating_UI() throws Exception {
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
		login.frameswitch2();
		login.Received_Status_Validation();
		Await();
		login.DeliveryScheduled_Status();
		Await();
		login.ClickonCalendar_POD_review.click();
		login.Calendarss();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameswitch2();
		login.OrderStatus_DeliveryScheduled_Validation();
		Await();
		login.Delivered_Status();
		Await();
		login.CustomerDelivery_Calendar.click();
		login.Calendarss();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameswitch2();
		login.Rated_Status_Validation();
		Await();
		login.OldRate = login.Total_Rate.getText();
		scrollToElementAndClick(driver, login.AddItem);
		Await();
		login.Description_Value.sendKeys("TEST");
		login.Code_Value.sendKeys("T1");
		login.Qty_Value.sendKeys("2");
		login.Charge_Value.sendKeys("25");

		Await();
		scrollToElementAndClick(driver, login.SaveAccessorial);
		Await();
		login.ChargeAmount = login.Charge_Value1.getText();
		System.out.println(login.ChargeAmount);
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameswitch2();
		login.TotalRate = login.Total_Rate.getText();
		System.out.println(login.TotalRate);
		login.RateValidation();
		login.OldRate = login.Total_Rate.getText();
		scrollToElementAndClick(driver, login.AddItem);
		Await();
		login.Description_Value.sendKeys("TEST2");
		login.Code_Value.sendKeys("T2");
		login.Qty_Value.sendKeys("1");
		login.Charge_Value.sendKeys("50");
		Await();
		scrollToElementAndClick(driver, login.SaveAccessorial);
		Await();
		Await();
		login.ChargeAmount = login.Charge_Value2.getText();
		System.out.println(login.ChargeAmount);
		Await();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		login.frameswitch2();
		login.TotalRate = login.Total_Rate.getText();
		System.out.println(login.TotalRate);
		String LineHaul = login.LineHaul_Rate.getText();
		System.out.println(LineHaul);
		String Fuel = login.Fuel.getText();
		String FuelRate = login.Fuel_Rate.getText();
		String TotalAccessorial = login.Total_Accessorial.getText();

		login.RateValidation();

		login.driver.switchTo().defaultContent();
		Await();
		Await();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		Await();
		login.ClickonDatatypesIcon.click();
		Await();
		Await();
		login.Clickon_Rate_Datatype.click();
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
		

	}

}
