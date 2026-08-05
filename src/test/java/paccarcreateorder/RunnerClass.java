package paccarcreateorder;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RunnerClass extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Test
	public void PaccarOrderCreate() throws Exception {
		
       PageObjectModel pom = new PageObjectModel(driver);
       pom.webDriverWait(By.id("loginText2"));
       pom.LoginToThePegaUsingValidCredentials();
       pom.LaunchWarehousePortal();
       pom.PacaarOrderCreate.click();
       pom.CentreMouseClick();
       pom.switchToFrame_PegaGadget0Ifr();
       pom.templateLabelShouldBePresent();
       pom.PAD_DomtarTemplate();
       pom.requestingTradingPartnerNameValidate();
       pom.assignedTradingPartnerNameValidate();
       pom.pacaarOrderCreate_Mode();
       pom.pacaarOrderCreate_Equipment();
       pom.pacaarOrderCreate_PaymentTerm();
       pom.pacaarOrderCreate_ServiceLevel();
       pom.pacaarOrderCreate_BOL();
       pom.pacaarOrderCreate_OriginCompany();
       pom.pacaarOrderCreate_OriginAddress1();
       pom.pacaarOrderCreate_OriginCity();
       pom.pacaarOrderCreate_OriginState();
       pom.pacaarOrderCreate_OriginPostalCode();
       pom.pacaarOrderCreate_OriginContactName();
       pom.pacaarOrderCreate_PickUpRequestDate();
       pom.pacaarOrderCreate_SelectStartTime();
       pom.pacaarOrderCreate_SelectEndTime();
       pom.pacaarOrderCreate_PickupNumber();
       pom.pacaarOrderCreate_PickupNotes();
       
       pom.pacaarOrderCreate_DestinationCompany();
       pom.pacaarOrderCreate_DestinationAddress1();
       pom.pacaarOrderCreate_DestinationCity();
       pom.pacaarOrderCreate_DestinationState();
       pom.pacaarOrderCreate_DestinationPostalCode();
       pom.pacaarOrderCreate_DestinationContactName();
       pom.pacaarOrderCreate_DeliveryRequestTWStart();
       pom.pacaarOrderCreate_DeliverySelectStartTime();
       pom.pacaarOrderCreate_DeliverySelectEndTime();
       pom.pacaarOrderCreate_DeliveryNumber();
       pom.pacaarOrderCreate_DeliveryNotes();
       
       pom.pacaarOrderCreate_BillToCompany();
       pom.pacaarOrderCreate_BillToAddress1();
       pom.pacaarOrderCreate_BillToCity();
       pom.pacaarOrderCreate_BillToState();
       pom.pacaarOrderCreate_BillToPostalCode();
       
       pom.pacaarOrderCreate_AddItemsClick();
       pom.pacaarOrderCreate_HandlingUnitType();
       pom.pacaarOrderCreate_ItemName();
       pom.pacaarOrderCreate_TotalWeight();
       pom.pacaarOrderCreate_PreviewOrder();
       
       ScrollUp();
       Await();
       Await();
       pom.processPacaarOrder_RequestingTradingPartnerValidation();
       pom.pacaarOrderCreate_AssignedTradingPartnerValidation();
       pom.pacaarOrderCreate_ModeValidation();
	}

}
