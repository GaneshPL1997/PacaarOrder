package packageEL2;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AccessorialUpdate extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	public void DescartesUpdate() throws Exception {
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
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_Accessorial_XML_Update();
		WebElement textArea = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\PAR_Accessorial.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea, filePath);
		pom.ClickExecute();
		Await();
		Await();
		pom.CloseTab();
		pom.driver.switchTo().defaultContent();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();

		pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_Accessorial_XML_Update();
		WebElement textArea1 = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath1 = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\PAR_Accessorial.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea1, filePath1);
		pom.ClickExecute();
		Await();
		Await();
		pom.CloseTab();
		pom.driver.switchTo().defaultContent();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
	}

	@SuppressWarnings("static-access")
	@Test
	public void OrderAPIUpdate() throws Exception {
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
		ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab0.get(0));
		Await();
		Await();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
	//	pom.Resolved_Cancelled(); 
		
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		pom.driver.switchTo().defaultContent();
		Await();
		pom.PAR_Refresh();
		pom.OrderFromOutboundLoads();
		pom.driver.switchTo().defaultContent();
		pom.Clipboard_Validation();
		pom.Click_PAR_PyWorkpage();
		Await();
		pom.ExpandpyworkPage.click();
		Await();
		pom.ExpandOrderPageinClipboard.click();
		Await();
		pom.ExpandAccessorialinCLipboard.click();
		Await();
		pom.ClickAccessorial1inCLipboard.click();
		Await();
		String text = pom.AccessorialCode.getText();
		System.out.println(text);
		String text2 = pom.AccessorialLocation.getText();
		System.out.println(text2);
		Await();
		pom.ClickAccessorial2inCLipboard.click();
		Await();
		String text3 = pom.AccessorialCode.getText();
		System.out.println(text3);
		Await();
		String text4 = pom.AccessorialLocation.getText();
		System.out.println(text4);
		pom.actualAccessorialCodes.clear();
	    pom.actualAccessorialLocation.clear();
		pom.actualAccessorialCodes.add(text);
		pom.actualAccessorialCodes.add(text3);
		pom.actualAccessorialLocation.add(text2);
		pom.actualAccessorialLocation.add(text4);
		pom.CloseTab();
        pom.validateAccessorialDetails();
        Await();
		pom.driver.switchTo().defaultContent();	
		ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		pom.driver.switchTo().defaultContent();
		pom.Close_PARtab.click();
		pom.Resend_With_Modified_JSON();
		Await();
		pom.PAR_Refresh();
		pom.OrderFromOutboundLoads();
		pom.driver.switchTo().defaultContent();
		pom.Clipboard_Click_Validation();
		pom.Click_PAR_PyWorkpage();
		Await();
		pom.ExpandpyworkPage.click();
		Await();
		pom.ExpandOrderPageinClipboard.click();
		Await();
		pom.ExpandAccessorialinCLipboard.click();
		Await();
		pom.ClickAccessorial3inCLipboard.click();
		Await();
		String text5 = pom.AccessorialCode.getText();
		System.out.println(text5);
		String text6 = pom.AccessorialLocation.getText();
		System.out.println(text6);
		pom.actualAccessorialCodes.add(text5);
		pom.actualAccessorialLocation.add(text6);
        pom.validateAccessorialDetails();
        Await();
        ArrayList<String> tab7 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab7.get(0));
		Await();
		pom.ClickonDatatypesIcon.click();
		Await();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.actualAccessorialCodes.clear();
		pom.actualAccessorialLocation.clear();
		pom.validateAccessorialDetails();
		Await();
		pom.driver.switchTo().defaultContent();
		pom.CloseTab();
		
		pom.DevStudioSearchBox();
		pom.orderService_Actions();
		pom.SOAPServicePopup();
		pom.PAR_Accessorial_XML_Update();
		WebElement textArea = driver
				.findElement(By.xpath("//textarea[@name='$PpySimulationDataPage$ppyRequestTextData']"));
		// Specify the file path
		String filePath = "C:\\Users\\palanga\\eclipse-workspace\\EL2-Automation\\PAR_Accessorial.xml";

		// Call the sendKeysJavascript method with the appropriate arguments
		pom.sendKeysJavascript(driver, textArea, filePath);
		pom.ClickExecute();
		Await();
		Await();
		pom.CloseTab();
		pom.driver.switchTo().defaultContent();
		pom.Clickon_RequestedAccessorial_Datatype.click();
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
		pom.validateAccessorialDetails();
		
	}

}
