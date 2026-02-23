package packageEL2;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrdersPAD extends BaseClass{
	
	@SuppressWarnings("static-access")
	@Test
	public void PADRating() throws Exception {
		Pom login = new Pom(driver);
		login.PAD_NewOrder();
		Await();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAD();
		Await();
		Pom.frameswitch2();
		Await();
		login.OrderStatus_DeliveryScheduled_Validation();
		Await();
		login.driver.switchTo().defaultContent();
		Await();
		login.Clipboard_Validation();
		login.Click_PAD_PyWorkpage();
		login.OrderPage_StatusEvent_DeliveryScheduled_StatusValidation();
		driver.close();
		Await();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		login.driver.switchTo().defaultContent();
		
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
		login.CustomerDelivery_Status_OutForDelivery();
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
		login.Clipboard_Click_PAD();
		login.OrderPage_StatusEvent_OutForDelivery_StatusValidation();
		Await();
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		login.driver.switchTo().defaultContent();
		Pom.frameswitch2();
		Await();
		
		login.CustomerDelivery_Status_Consignee();
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
		
		login.Delivered_Status();
		Await();
		scrollToElementAndClick(driver, login.Submit);
		Await();
		login.ClickonGo.click();
		login.driver.switchTo().defaultContent();
		Await();
		Pom.frameswitch2();
		Await();
	
		login.Rated_Status_Validation();
		Await();
		String TotalRate1 = login.Total_Rate.getText();
		System.out.println(TotalRate1);
		String LineHaul1 = login.LineHaul_Rate.getText();
		System.out.println(LineHaul1);
		String Fuel1 = login.Fuel.getText();
		System.out.println("Fuel:" +Fuel1);
		String TotalAccessorial1 = login.Total_Accessorial.getText();
		System.out.println("TotalAccessorial: "+ TotalAccessorial1);
	
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersPAD.click();
		login.frameSwitch();
		login.RateReview_Workpage.click();
		Await();
		login.PAD_OrderSearchandFilter();
		Await();
		//----------------------------------------------- New code added
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
		login.switchTo_OrdersPAD.click();
		login.frameSwitch();
		login.Order_Tab_Refresh.click();
		
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.PAD_OrderSearchandFilter();
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
		login.PAD_ActionsButton();
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
		login.switchTo_OrdersPAD.click();
		
		
		login.frameSwitch();
		login.Order_Tab_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.PAD_OrderSearchandFilter();
		Await();
		login.SubmitPOD_Validation();
		driver.switchTo().defaultContent();
		ArrayList<String> tab4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab4.get(0));   
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
		login.CloseTab();
		Await();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(1));
		login.driver.switchTo().defaultContent();
		Await();
		login.SwitchtoOrderPage();
		Await();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		Await();
		login.PAD_ActionsButton();
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
	//	login.ToggleToolBar();
		login.Clipboard_Click_PAD1();
		login.pyWOrkPage_RequiredStatus_Validation();
		login.OrderPage_StatusEvent_Delivered_StatusValidation();
		Await();
		driver.close();
		Await();
		ArrayList<String> tab6 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab6.get(1));
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersPAD.click();
		login.frameSwitch();
		Await();
		login.RateReview_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.PAD_OrderSearchandFilter();
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
		login.GenerateInvoice_Submit.click(); 
		Await();
		login.CloseTab();
		Await();
		login.driver.switchTo().defaultContent();
		login.switchTo_OrdersPAD.click();
		login.frameSwitch();
		Await();
		login.RateReview_Refresh.click();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameSwitch();
		Await();
		login.PAD_OrderSearchandFilter();
		Await();
		login.Invoiced_Status_Validation();
		Await();

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
		login.PAD_ActionsButton();
		Await();
		login.driver.switchTo().defaultContent();
		login.frameswitch2();
		Await();
		login.Resolved_Completed();
		//----------------------------------------------- New code end
		
		
		
	/*	login.selectShipper();
		login.select_StatusSearch();
		Await();
		WebElement OrderId_CheckBox_Click = driver.findElement(By.xpath("(//tr[.//a[normalize-space(text())='"+login.OrderID.trim()+"']]//input[@type='checkbox'])[1]"));
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
	
		login.GenerateInvoice_Submit.click();
		login.driver.switchTo().defaultContent();
		Await();
		
		Await();
		ArrayList<String> tab4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab4.get(2));
		login.driver.switchTo().defaultContent();
		Await();
		ArrayList<String> tab5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab5.get(1));
		
		Await();
		login.driver.switchTo().defaultContent();
		Await();   */
		login.frameSwitch();
		login.RateReview_Refresh.click();
		Await();
		login.frameSwitch();
		Await();
		login.OrderSearchandFilter();
		Await();
		login.Invoiced_Status_Validation();
		Await();
		login.Click_ViewDoc();
		Await();
		login.Download_Attachment();
		String BFTotalCharge = login.Base_FuelTotalCharge.getText();
		
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
		}
	}

}
