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
       pom.PAD_TestKent();
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
       pom.pacaarOrderCreate_EquipmentValidation();
       pom.pacaarOrderCreate_PaymentTermValidation();
       pom.pacaarOrderCreate_ServiceLevelValidation();
       pom.pacaarOrderCreate_BOLValidation();
       pom.pacaarOrderCreate_OriginCompanyValidation();
       pom.pacaarOrderCreate_OriginAddress1Validation();
  //     pom.pacaarOrderCreate_OriginCityValidation();
       pom.pacaarOrderCreate_OriginStateValidation();
       pom.pacaarOrderCreate_OriginPostalCodeValidation();
//       pom.pacaarOrderCreate_OriginContactNameValidation();
//       pom.pacaarOrderCreate_PickUpRequestDateValidation();
//       pom.pacaarOrderCreate_SelectStartTimeValidation();
//       pom.pacaarOrderCreate_SelectEndTimeValidation();
//       pom.pacaarOrderCreate_PickupNumberValidation();
//       pom.pacaarOrderCreate_PickupNotesValidation();
       
       pom.pacaarOrderCreate_DestinationCompanyValidation();
       pom.pacaarOrderCreate_DestinationAddress1Validation();
//       pom.pacaarOrderCreate_DestinationCityValidation();
       pom.pacaarOrderCreate_DestinationStateValidation();
       pom.pacaarOrderCreate_DestinationPostalCodeValidation();
//       pom.pacaarOrderCreate_DestinationContactNameValidation();
//       pom.pacaarOrderCreate_DeliveryRequestTWStartValidation();
//       pom.pacaarOrderCreate_DeliverySelectStartTimeValidation();
//       pom.pacaarOrderCreate_DeliverySelectEndTimeValidation();
//       pom.pacaarOrderCreate_DeliveryNumberValidation();
//       pom.pacaarOrderCreate_DeliveryNotesValidation();
       
       pom.pacaarOrderCreate_BillToCompanyValidation();
       pom.pacaarOrderCreate_BillToAddress1Validation();
       pom.pacaarOrderCreate_BillToCityValidation();
       pom.pacaarOrderCreate_BillToStateValidation();
       pom.pacaarOrderCreate_BillToPostalCodeValidation();
       
//       pom.pacaarOrderCreate_AddItemsClickValidation();
//       pom.pacaarOrderCreate_HandlingUnitTypeValidation();
//       pom.pacaarOrderCreate_ItemNameValidation();
       pom.pacaarOrderCreate_TotalWeightValidation();
       pom.pacaarOrder_Confrim();
       pom.pacaarOrderIDValidation();
       pom.close();
       pom.pacaarOrderCreate_PreviewOrder();
       pom.pacaarOrder_Confrim();
       pom.pacaarOrderID_ErrorMessageValidation();
       pom.submit();
       pom.switchToDefaultContent();
       pom.closeThisTab();
       pom.ClickOrdersPAD();
       pom.switchToFrame_PegaGadget1Ifr();
       pom.clickRateReviewHeader();
       pom.clickShipmentSchedulingHeader();
       pom.ShipmentScheduling_OrderID_Filter();
	}

}
