package paccarcreateorder;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class PageObjectModel extends BaseClass {

	static String reqTradingPartnerText;
	String assTradingPartnerText;
	String modeText;
	String equipmentText;
	String paymentTermText;
	String serviceLevelText;
	String Bol_number;
	String originCompanyText;
	String originAddress1Text;
	String originStateText;
	String originPostalCodeText;
	String destinationCompanyText;
	String destinationAddress1Text;
	String destinationCity;
	String destinationStateText;
	String destinationPostalCodeText;
	String billToCompanyText;
	String billToAddressText;
	String billToCityText;
	String billToStateText;
	String billToPostalCodeText;
	String totalWeight;
	String orderID;

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

	@FindBy(xpath = "//span/span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement WareHousePortal;

	@FindBy(xpath = "//li[@title='Order Create']")
	public static WebElement PacaarOrderCreate;

	@FindBy(xpath = "//label[contains(text(),'Create order from template')]")
	public static WebElement templateLabel;

	@FindBy(xpath = "//select[@name='$PpyDisplayHarness$pPaccarTemplate']")
	public static WebElement PacaarTemplateDropdown;

	@FindBy(xpath = "//span[normalize-space()='RequestingTradingPartnerName']/following-sibling::div//span")
	public static WebElement requestingTradingPartnerName;

	@FindBy(xpath = "//span[normalize-space()='AssignedTradingPartnerName']/following-sibling::div/span")
	public static WebElement assignedTradingPartnerName;

	@FindBy(xpath = "//div/label[normalize-space()='Mode']/following-sibling::div/select[@name='$PpyDisplayHarness$pOrderPage$pMode']")
	public static WebElement pacaarOrderCreate_Mode;

	@FindBy(xpath = "//div/label[normalize-space()='Equipment']/following-sibling::div/select[@name='$PpyDisplayHarness$pOrderPage$pEquipment']")
	public static WebElement pacaarOrderCreate_Equipment;

	@FindBy(xpath = "//div/label[normalize-space()='Payment Term']/following-sibling::div/select[@name='$PpyDisplayHarness$pOrderPage$pPaymentTerm']")
	public static WebElement pacaarOrderCreate_PaymentTerm;

	@FindBy(xpath = "//div/label[normalize-space()='Service level']/following-sibling::div/select[@name='$PpyDisplayHarness$pOrderPage$pServiceLevel']")
	public static WebElement pacaarOrderCreate_ServiceLevel;

	@FindBy(xpath = "//div/label[normalize-space()='BOL']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pBOL']")
	public static WebElement pacaarOrderCreate_BOL;

	@FindBy(xpath = "//div/label[normalize-space()='Origin Company']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginCompany']")
	public static WebElement pacaarOrderCreate_OriginCompany;

	@FindBy(xpath = "//div/label[normalize-space()='Origin Address1']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginAddress1']")
	public static WebElement pacaarOrderCreate_OriginAddress1;

	@FindBy(xpath = "//div/label[normalize-space()='Origin City']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginCity']")
	public static WebElement pacaarOrderCreate_OriginCity;

	@FindBy(xpath = "//div/label[normalize-space()='Origin State']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginState']")
	public static WebElement pacaarOrderCreate_OriginState;

	@FindBy(xpath = "//div/label[normalize-space()='Origin PostalCode']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginPostalCode']")
	public static WebElement pacaarOrderCreate_OriginPostalCode;

	@FindBy(xpath = "//div/label[normalize-space()='Origin Contact Name']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pOriginContactName']")
	public static WebElement pacaarOrderCreate_OriginContactName;

	@FindBy(xpath = "//div/label[normalize-space()='Pickup Number']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pPickupNumber']")
	public static WebElement pacaarOrderCreate_PickupNumber;

	@FindBy(xpath = "//div/label[normalize-space()='Pickup Notes']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pPickupNotes']")
	public static WebElement pacaarOrderCreate_PickupNotes;

	@FindBy(xpath = "//div/label[normalize-space()='Destination Company']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationCompany']")
	public static WebElement pacaarOrderCreate_DestinationCompany;

	@FindBy(xpath = "//div/label[normalize-space()='Destination Address1']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationAddress1']")
	public static WebElement pacaarOrderCreate_DestinationAddress1;

	@FindBy(xpath = "//div/label[normalize-space()='Destination City']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationCity']")
	public static WebElement pacaarOrderCreate_DestinationCity;

	@FindBy(xpath = "//div/label[normalize-space()='Destination State']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationState']")
	public static WebElement pacaarOrderCreate_DestinationState;

	@FindBy(xpath = "//div/label[normalize-space()='Destination Postal Code']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationPostalCode']")
	public static WebElement pacaarOrderCreate_DestinationPostalCode;

	@FindBy(xpath = "//div/label[normalize-space()='Destination Contact Name']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDestinationContactName']")
	public static WebElement pacaarOrderCreate_DestinationContactName;

	@FindBy(xpath = "//div/label[normalize-space()='Delivery Number']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDeliveryNumber']")
	public static WebElement pacaarOrderCreate_DeliveryNumber;

	@FindBy(xpath = "//div/label[normalize-space()='Delivery Notes']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pDeliveryNotes']")
	public static WebElement pacaarOrderCreate_DeliveryNotes;

	@FindBy(xpath = "//div/label[normalize-space()='BillTo Company']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pCompanyName']")
	public static WebElement pacaarOrderCreate_BillToCompany;

	@FindBy(xpath = "//div/label[normalize-space()='BillTo Address1']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pAddress1']")
	public static WebElement pacaarOrderCreate_BillToAddress1;

	@FindBy(xpath = "//div/label[normalize-space()='BillTo City']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pCity']")
	public static WebElement pacaarOrderCreate_BillToCity;

	@FindBy(xpath = "//div/label[normalize-space()='BillTo State']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pState']")
	public static WebElement pacaarOrderCreate_BillToState;

	@FindBy(xpath = "//div/label[normalize-space()='BillTo Postal Code']/following-sibling::div/span/input[@name='$PpyDisplayHarness$pOrderPage$pPostalCode']")
	public static WebElement pacaarOrderCreate_BillToPostalCode;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pPickupRequestTWStart']/following-sibling::img")
	public static WebElement pacaarOrderCreate_PickupRequestTWStart;

	@FindBy(xpath = "//a[@class='today-link']")
	public static WebElement pacaarOrderCreate_Today;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$ppyTempTimeOfDay']/following-sibling::img")
	public static WebElement pacaarOrderCreate_PickupSelectStartTime;

	@FindBy(xpath = "//a[@id='applyLink']")
	public static WebElement pacaarOrderCreate_ApplyTime;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$ppySummaryTimeOfDay']/following-sibling::img")
	public static WebElement pacaarOrderCreate_SelectEndTime;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDeliveryAppointmentDate']/following-sibling::img")
	public static WebElement pacaarOrderCreate_DeliveryRequestTWStart;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pSelectStartTime']/following-sibling::img")
	public static WebElement pacaarOrderCreate_DeliverySelectStartTime;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pSelectEndTime']/following-sibling::img")
	public static WebElement pacaarOrderCreate_DeliverySelectEndTime;

	@FindBy(xpath = "//a[contains(text(),'Add Items')]")
	public static WebElement pacaarOrderCreate_AddItems;

	@FindBy(xpath = "//div/select[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pHandlingUnitTypeList']")
	public static WebElement pacaarOrderCreate_HandlingUnitType;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pSkuName']")
	public static WebElement pacaarOrderCreate_ItemName;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pTotalWeight']")
	public static WebElement pacaarOrderCreate_TotalWeight;

	@FindBy(xpath = "//button[contains(text(),'Preview Order')]")
	public static WebElement pacaarOrderCreate_PreviewOrder;

	// ----------------------------------Process Pacaar Order
	// -----------------------------------------

	@FindBy(xpath = "(//span[normalize-space()='RequestingTradingPartnerName']/following-sibling::div//span)[1]")
	public static WebElement processPacaarOrder_RequestingTradingPartner;

	@FindBy(xpath = "(//span[normalize-space()='AssignedTradingPartnerName']/following-sibling::div/span[normalize-space()='EL2-Manteca'])[1]")
	public static WebElement processPacaarOrder_AssignedTradingPartner;

	@FindBy(xpath = "//div/span[normalize-space()='Mode']/following-sibling::div/span")
	public static WebElement processPacaarOrder_Mode;

	@FindBy(xpath = "//div/span[normalize-space()='Equipment']/following-sibling::div/span")
	public static WebElement processPacaarOrder_Equipment;

	@FindBy(xpath = "//div/span[normalize-space()='Payment Term']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PaymentTerm;

	@FindBy(xpath = "//div/span[normalize-space()='Service level']/following-sibling::div/span")
	public static WebElement processPacaarOrder_ServiceLevel;

	@FindBy(xpath = "//div/span[normalize-space()='BOL']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BOL;

	@FindBy(xpath = "//div/span[normalize-space()='Origin Company']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginCompany;

	@FindBy(xpath = "//div/span[normalize-space()='Origin Address1']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginAddress1;

	@FindBy(xpath = "//div/span[normalize-space()='Origin City']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginCity;

	@FindBy(xpath = "//div/span[normalize-space()='Origin State']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginState;

	@FindBy(xpath = "//div/span[normalize-space()='Origin PostalCode']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginPostalCode;

	@FindBy(xpath = "//div/span[normalize-space()='Origin Contact Name']/following-sibling::div/span")
	public static WebElement processPacaarOrder_OriginContactName;

	@FindBy(xpath = "//div/span[normalize-space()='Pickup Request Date']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PickupRequestDate;

	@FindBy(xpath = "//div/span[normalize-space()='Select Start Time']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PickupSelectStartTime;

	@FindBy(xpath = "//div/span[normalize-space()='Select End Time']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PickupSelectEndTime;

	@FindBy(xpath = "//div/span[normalize-space()='Pickup Number']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PickupNumber;

	@FindBy(xpath = "//div/span[normalize-space()='Pickup Notes']/following-sibling::div/span")
	public static WebElement processPacaarOrder_PickupNotes;

	@FindBy(xpath = "//div/span[normalize-space()='Destination Company']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationCompany;

	@FindBy(xpath = "//div/span[normalize-space()='Destination Address1']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationAddress1;

	@FindBy(xpath = "//div/span[normalize-space()='Destination City']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationCity;

	@FindBy(xpath = "//div/span[normalize-space()='Destination State']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationState;

	@FindBy(xpath = "//div/span[normalize-space()='Destination Postal Code']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationPostalCode;

	@FindBy(xpath = "//div/span[normalize-space()='Destination Contact Name']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DestinationContactName;

	@FindBy(xpath = "//div/span[normalize-space()='Delivery Request Date']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DeliveryRequestDate;

	@FindBy(xpath = "(//div/span[normalize-space()='Select Start Time']/following-sibling::div/span)[2]")
	public static WebElement processPacaarOrder_DeliverySelectStartTime;

	@FindBy(xpath = "(//div/span[normalize-space()='Select End Time']/following-sibling::div/span)[2]")
	public static WebElement processPacaarOrder_DeliverySelectEndTime;

	@FindBy(xpath = "//div/span[normalize-space()='Delivery Number']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DeliveryNumber;

	@FindBy(xpath = "//div/span[normalize-space()='Delivery Notes']/following-sibling::div/span")
	public static WebElement processPacaarOrder_DeliveryNotes;

	@FindBy(xpath = "//div/span[normalize-space()='BillTo Company']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BillToCompany;

	@FindBy(xpath = "//div/span[normalize-space()='BillTo Address1']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BillToAddress1;

	@FindBy(xpath = "//div/span[normalize-space()='BillTo City']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BillToCity;

	@FindBy(xpath = "//div/span[normalize-space()='BillTo State']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BillToState;

	@FindBy(xpath = "//div/span[normalize-space()='BillTo Postal Code']/following-sibling::div/span")
	public static WebElement processPacaarOrder_BillToPostalCode;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='HU Type']/div)[1]")
	public static WebElement processPacaarOrder_HUType;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Item Name']/div)[1]")
	public static WebElement processPacaarOrder_ItemName;

	@FindBy(xpath = "(//table[@class='gridTable ']/tbody/tr/td[@data-attribute-name='Total Weight']/div)[1]")
	public static WebElement processPacaarOrder_TotalWeight;

	@FindBy(xpath = "//button[contains(text(),'Confirm Order')]")
	public static WebElement processPacaarOrder_ConfrimOrder;

	@FindBy(xpath = "//div/span[contains(text(),'Reference is')]")
	public static WebElement OrderId_Text;

	@FindBy(xpath = "//div/span[contains(text(),'Already Exists with same BOL')]")
	public static WebElement OrderId_ErrorMessageText;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public static WebElement Submit;

	@FindBy(id = "container_close")
	public static WebElement close;

	@FindBy(id = "close")
	public static WebElement closeThisTab;

	// ----------------Orders PAD ---------------------

	@FindBy(xpath = "(//span[contains(@class,'locations')])[1]")
	public static WebElement OrdersPADClick;
	
	@FindBy(xpath = "//div[@aria-label='Rate Review']")
	public static WebElement RateReviewHeaderClick;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Shipment Scheduling')]")
	public static WebElement ShipmentSchedulingHeaderClick;

	@FindBy(xpath = "(//a[@id='pui_filter'])[1]")
	public static WebElement ShipmentScheduling_OrderID_Filter;
	
	@FindBy(xpath = "//input[@CLASS='leftJustifyStyle']")
	public static WebElement OrderSearchBoxClick;
	
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	public static WebElement ApplyClick;
	
	
	// ---------------Frames -------------------------

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement Frame_PegaGadget0Ifr;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	public static WebElement Frame_PegaGadget1Ifr;

	Actions actions = new Actions(driver);

	public PageObjectModel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void LoginToThePegaUsingValidCredentials() throws InterruptedException {
		extentTest.log(Status.PASS, "User can able to launch Pega application in chrome");

		getParentWindow();
		ssoLogin.click();
		webDriverWaitByWebElement(code);
		code.click();

		// Scanner class to handle OTP
		String scannar = Scannar();
		send.sendKeys(scannar);
		webDriverWaitByWebElement(click);
		click.click();
		extentTest.log(Status.PASS, "Successfully logged into PEGA Application using valid credentials");
		extentTest.log(Status.PASS, "User should allowed to launch warehouse portal");
	}

	public void LaunchWarehousePortal() throws InterruptedException {
		webDriverWaitByWebElement(LaunchPortal);
		LaunchPortal.click();
		webDriverWaitByWebElement(WareHousePortal);
		WareHousePortal.click();
		Await();
		windowToBeSwitchToCurrentWindow();
		extentTest.log(Status.PASS, "Warehouse portal is launched in a new tab after clicking warehouse portal");
	}

	public void CentreMouseClick() throws Exception {
		Await();
		Dimension size = driver.manage().window().getSize();

		// Find center coordinates
		int centerX = size.getWidth() / 2;
		int centerY = size.getHeight() / 2;

		// Click at center of screen
		Actions actions = new Actions(driver);
		actions.moveByOffset(centerX, centerY).click().perform();
		Await();

	}

	public void templateLabelShouldBePresent() throws Exception {
		Await();
		String templateLabelText = templateLabel.getText();
		Assert.assertEquals(templateLabelText, "Create order from template");
	}

	public static void switchToFrame_PegaGadget0Ifr() {
		driver.switchTo().frame(Frame_PegaGadget0Ifr);
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();

	}

	public void PAD_TestKent() throws Exception {
		SelectClass(PacaarTemplateDropdown, "TEST KENT");
		Await();
		extentTest.log(Status.PASS, "Test Kent Template has been selected successfully from dropdown");
	}

	public void requestingTradingPartnerNameValidate() {
		reqTradingPartnerText = requestingTradingPartnerName.getText();
		System.out.println(reqTradingPartnerText);
		Assert.assertEquals(reqTradingPartnerText, "Paccar");
		extentTest.log(Status.PASS, "NAPA has been displayed as Requesting trading partner");
	}

	public void assignedTradingPartnerNameValidate() {
		assTradingPartnerText = assignedTradingPartnerName.getText();
		Assert.assertEquals(assTradingPartnerText, "EL2-Kent");
	}

	public void pacaarOrderCreate_Mode() {
		SelectClass(pacaarOrderCreate_Mode, "CrowleyTL");
		modeText = pacaarOrderCreate_Mode.getAttribute("value");
		Assert.assertEquals(modeText, "CrowleyTL");
	}

	public void pacaarOrderCreate_Equipment() {
		SelectClass(pacaarOrderCreate_Equipment, "Air Ride");
		equipmentText = pacaarOrderCreate_Equipment.getAttribute("value");
		Assert.assertEquals(equipmentText, "Air Ride");
	}

	public void pacaarOrderCreate_PaymentTerm() {
		SelectClass(pacaarOrderCreate_PaymentTerm, "Third Party");
		paymentTermText = pacaarOrderCreate_PaymentTerm.getAttribute("value");
		Assert.assertEquals(paymentTermText, "Third Party");
	}

	public void pacaarOrderCreate_ServiceLevel() throws Exception {
		Await();
		SelectClass(pacaarOrderCreate_ServiceLevel, "Inside Service");
		serviceLevelText = pacaarOrderCreate_ServiceLevel.getAttribute("value");
		Assert.assertEquals(serviceLevelText, "Inside Service");
	}

	public void pacaarOrderCreate_BOL() throws Exception {
		Await();
		Bol_number = pacaarOrderCreate_BOL.getAttribute("value");
		// Assert.assertEquals(Bol_number, "MT-1005-26");
	}

	public void pacaarOrderCreate_OriginCompany() throws Exception {
		Await();
		originCompanyText = pacaarOrderCreate_OriginCompany.getAttribute("value");
		Assert.assertEquals(originCompanyText, "Domtar 7831");
	}

	public void pacaarOrderCreate_OriginAddress1() {
		originAddress1Text = pacaarOrderCreate_OriginAddress1.getAttribute("value");
		Assert.assertEquals(originAddress1Text, "South 198th St Kent,");
	}

	public void pacaarOrderCreate_OriginCity() throws Exception {
		Await();
		pacaarOrderCreate_OriginCity.isDisplayed();
		Await();
		pacaarOrderCreate_OriginCity.sendKeys("Test City");
	}

	public void pacaarOrderCreate_OriginState() throws Exception {
		Await();
		originStateText = pacaarOrderCreate_OriginState.getAttribute("value");
		Assert.assertEquals(originStateText, "WA");
	}

	public void pacaarOrderCreate_OriginPostalCode() throws Exception {
		Await();
		originPostalCodeText = pacaarOrderCreate_OriginPostalCode.getAttribute("value");
		Assert.assertEquals(originPostalCodeText, "98032");
	}

	public void pacaarOrderCreate_OriginContactName() throws Exception {
		Await();
		pacaarOrderCreate_OriginContactName.sendKeys("Test Contact Name");
	}

	public void pacaarOrderCreate_PickupNumber() throws Exception {
		Await();
		pacaarOrderCreate_PickupNumber.sendKeys("Test Pickup number");
	}

	public void pacaarOrderCreate_PickupNotes() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_PickupNotes).perform();
		pacaarOrderCreate_PickupNotes.sendKeys("Test Pickup notes");
	}

	public void pacaarOrderCreate_DestinationCompany() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DestinationCompany).perform();
		destinationCompanyText = pacaarOrderCreate_DestinationCompany.getAttribute("value");
		Assert.assertEquals(destinationCompanyText, "Aloha Marine Lines");
	}

	public void pacaarOrderCreate_DestinationAddress1() throws Exception {
		Await();
		destinationAddress1Text = pacaarOrderCreate_DestinationAddress1.getAttribute("value");
		Assert.assertEquals(destinationAddress1Text, "6700 West Marginal Way");
	}

	public void pacaarOrderCreate_DestinationCity() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DestinationCity).perform();
		destinationCity = pacaarOrderCreate_DestinationCity.getAttribute("value");
		Assert.assertEquals(destinationCity, "Marginal Way SW");
	}

	public void pacaarOrderCreate_DestinationState() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DestinationState).perform();
		destinationStateText = pacaarOrderCreate_DestinationState.getAttribute("value");
		Assert.assertEquals(destinationStateText, "WA");
	}

	public void pacaarOrderCreate_DestinationPostalCode() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DestinationPostalCode).perform();
		destinationPostalCodeText = pacaarOrderCreate_DestinationPostalCode.getAttribute("value");
		Assert.assertEquals(destinationPostalCodeText, "98188");
	}

	public void pacaarOrderCreate_DestinationContactName() throws Exception {
		Await();

		actions.moveToElement(pacaarOrderCreate_DestinationContactName).perform();
		pacaarOrderCreate_DestinationContactName.sendKeys("Test dest contact name");
	}

	public void pacaarOrderCreate_DeliveryNumber() {
		pacaarOrderCreate_DeliveryNumber.sendKeys("Test Delivery number");
	}

	public void pacaarOrderCreate_DeliveryNotes() {
		pacaarOrderCreate_DeliveryNotes.sendKeys("Test Delivery notes");
	}

	public void pacaarOrderCreate_BillToCompany() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_BillToCompany).perform();
		billToCompanyText = pacaarOrderCreate_BillToCompany.getAttribute("value");
		Assert.assertEquals(billToCompanyText, "StarCorp");
	}

	public void pacaarOrderCreate_BillToAddress1() throws Exception {
		Await();
		billToAddressText = pacaarOrderCreate_BillToAddress1.getAttribute("value");
		Assert.assertEquals(billToAddressText, "5161 Hwy 42");
	}

	public void pacaarOrderCreate_BillToCity() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_BillToCity).perform();
		billToCityText = pacaarOrderCreate_BillToCity.getAttribute("value");
		System.out.println(billToCityText);
		Assert.assertEquals(billToCityText, "Ellenwood");
	}

	public void pacaarOrderCreate_BillToState() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_BillToState).perform();
		billToStateText = pacaarOrderCreate_BillToState.getAttribute("value");
		Assert.assertEquals(billToStateText, "GA");
	}

	public void pacaarOrderCreate_BillToPostalCode() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_BillToPostalCode).perform();
		billToPostalCodeText = pacaarOrderCreate_BillToPostalCode.getAttribute("value");
		Assert.assertEquals(billToPostalCodeText, "30294");
	}

	public void pacaarOrderCreate_PickUpRequestDate() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_PickupRequestTWStart).perform();
		pacaarOrderCreate_PickupRequestTWStart.click();
		Await();
		pacaarOrderCreate_Today.click();
	}

	public void pacaarOrderCreate_SelectStartTime() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_PickupSelectStartTime).perform();
		pacaarOrderCreate_PickupSelectStartTime.click();
		Await();
		pacaarOrderCreate_ApplyTime.click();
	}

	public void pacaarOrderCreate_SelectEndTime() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_SelectEndTime).perform();
		pacaarOrderCreate_SelectEndTime.click();
		Await();
		pacaarOrderCreate_ApplyTime.click();
	}

	public void pacaarOrderCreate_DeliveryRequestTWStart() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DeliveryRequestTWStart).perform();
		pacaarOrderCreate_DeliveryRequestTWStart.click();
		Await();
		pacaarOrderCreate_Today.click();
	}

	public void pacaarOrderCreate_DeliverySelectStartTime() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DeliverySelectStartTime).perform();
		pacaarOrderCreate_DeliverySelectStartTime.click();
		Await();
		pacaarOrderCreate_ApplyTime.click();
	}

	public void pacaarOrderCreate_DeliverySelectEndTime() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_DeliverySelectEndTime).perform();
		pacaarOrderCreate_DeliverySelectEndTime.click();
		Await();
		pacaarOrderCreate_ApplyTime.click();
	}

	public void pacaarOrderCreate_AddItemsClick() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_AddItems).perform();
		pacaarOrderCreate_AddItems.click();
	}

	public void pacaarOrderCreate_HandlingUnitType() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_HandlingUnitType).perform();
		SelectClass(pacaarOrderCreate_HandlingUnitType, "Case(s)");
	}

	public void pacaarOrderCreate_ItemName() throws Exception {
		Await();
		pacaarOrderCreate_ItemName.click();
		Await();
		pacaarOrderCreate_ItemName.sendKeys("TestItemName");
	}

	public void pacaarOrderCreate_TotalWeight() throws Exception {
		Await();
		pacaarOrderCreate_BillToPostalCode.click();
		Await();
		totalWeight = pacaarOrderCreate_TotalWeight.getAttribute("value");
		System.out.println(totalWeight);
		Assert.assertEquals(totalWeight, "1000");
		Await();
	}

	public void pacaarOrderCreate_PreviewOrder() throws Exception {
		Await();
		actions.moveToElement(pacaarOrderCreate_PreviewOrder).perform();
		pacaarOrderCreate_PreviewOrder.click();
		Await();
	}

	public void processPacaarOrder_RequestingTradingPartnerValidation() throws Exception {
		Await();
		Await();
		// String expRTP =
		// processPacaarOrder_RequestingTradingPartner.getAttribute("value");
		String expRTP = processPacaarOrder_RequestingTradingPartner.getText();
		System.out.println(expRTP);
		assertEquals(expRTP, reqTradingPartnerText);
	}

	public void pacaarOrderCreate_AssignedTradingPartnerValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_AssignedTradingPartner.getText(), assTradingPartnerText);
	}

	public void pacaarOrderCreate_ModeValidation() throws Exception {
		Await();
		String Pacaar = processPacaarOrder_Mode.getText();
		System.out.println(Pacaar);
		assertEquals(processPacaarOrder_Mode.getText(), modeText);
	}

	public void pacaarOrderCreate_EquipmentValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_Equipment.getText(), equipmentText);
	}

	public void pacaarOrderCreate_PaymentTermValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_PaymentTerm.getText(), paymentTermText);
	}

	public void pacaarOrderCreate_ServiceLevelValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_ServiceLevel.getText(), serviceLevelText);
	}

	public void pacaarOrderCreate_BOLValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BOL.getText(), Bol_number);
	}

	public void pacaarOrderCreate_OriginCompanyValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_OriginCompany.getText(), originCompanyText);
	}

	public void pacaarOrderCreate_OriginAddress1Validation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_OriginAddress1.getText(), originAddress1Text);
	}

//	public void pacaarOrderCreate_OriginCityValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_OriginCity.getText(), originCityText);
//	}

	public void pacaarOrderCreate_OriginStateValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_OriginState.getText(), originStateText);
	}

	public void pacaarOrderCreate_OriginPostalCodeValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_OriginPostalCode.getText(), originPostalCodeText);
	}

//	public void pacaarOrderCreate_OriginContactNameValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_OriginContactName.getText(), originContactNameText);
//	}

//	public void pacaarOrderCreate_PickupNumberValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_PickupNumber.getText(), pickupNumberText);
//	}
//
//	public void pacaarOrderCreate_PickupNotesValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_PickupNotes.getText(), pickupNotesText);
//	}

	public void pacaarOrderCreate_DestinationCompanyValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_DestinationCompany.getText(), destinationCompanyText);
	}

	public void pacaarOrderCreate_DestinationAddress1Validation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_DestinationAddress1.getText(), destinationAddress1Text);
	}

	public void pacaarOrderCreate_DestinationCityValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_DestinationCity.getText(), destinationCity);
	}

	public void pacaarOrderCreate_DestinationStateValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_DestinationState.getText(), destinationStateText);
	}

	public void pacaarOrderCreate_DestinationPostalCodeValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_DestinationPostalCode.getText(), destinationPostalCodeText);
	}

//	public void pacaarOrderCreate_DestinationContactNameValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DestinationContactName.getText(), destinationContactNameText);
//	}
//
//	public void pacaarOrderCreate_DeliveryRequestTWStartValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DeliveryRequestDate.getText(), deliveryRequestDateText);
//	}
//
//	public void pacaarOrderCreate_DeliverySelectStartTimeValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DeliverySelectStartTime.getText(), deliverySelectStartTimeText);
//	}
//
//	public void pacaarOrderCreate_DeliverySelectEndTimeValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DeliverySelectEndTime.getText(), deliverySelectEndTimeText);
//	}
//
//	public void pacaarOrderCreate_DeliveryNumberValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DeliveryNumber.getText(), deliveryNumberText);
//	}
//
//	public void pacaarOrderCreate_DeliveryNotesValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_DeliveryNotes.getText(), deliveryNotesText);
//	}

	public void pacaarOrderCreate_BillToCompanyValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BillToCompany.getText(), billToCompanyText);
	}

	public void pacaarOrderCreate_BillToAddress1Validation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BillToAddress1.getText(), billToAddressText);
	}

	public void pacaarOrderCreate_BillToCityValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BillToCity.getText(), billToCityText);
	}

	public void pacaarOrderCreate_BillToStateValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BillToState.getText(), billToStateText);
	}

	public void pacaarOrderCreate_BillToPostalCodeValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_BillToPostalCode.getText(), billToPostalCodeText);
	}

//
//	public void pacaarOrderCreate_AddItemsClickValidation() throws Exception {
//	    Await();
//	    // Add Items WebElement was not provided in the XPath list.
//	}
//
//	public void pacaarOrderCreate_HandlingUnitTypeValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_HUType.getText(), handlingUnitTypeText);
//	}
//
//	public void pacaarOrderCreate_ItemNameValidation() throws Exception {
//	    Await();
//	    assertEquals(processPacaarOrder_ItemName.getText(), itemNameText);
//	}

	public void pacaarOrderCreate_TotalWeightValidation() throws Exception {
		Await();
		assertEquals(processPacaarOrder_TotalWeight.getText().replace(",", ""), totalWeight);
	}

	public void pacaarOrder_Confrim() throws Exception {
		Await();
		processPacaarOrder_ConfrimOrder.click();
	}

	public void pacaarOrderIDValidation() throws Exception {
		Await();
		String[] split = OrderId_Text.getText().split("Reference is");
		orderID = split[1].trim();
		System.out.println(orderID);
		assertEquals(OrderId_Text.getText(),
				originCompanyText + " Order is Created and the ID for Reference is " + orderID);
	}

	public void pacaarOrderID_ErrorMessageValidation() throws Exception {
		Await();
		String text = OrderId_ErrorMessageText.getText();
		assertEquals(text, "OrderID-" +orderID+ " is Already Exists with same BOL");
	}

	public void submit() throws Exception {
		Await();
		Submit.click();
	}

	public void close() throws Exception {
		Await();
		close.click();
	}

	public void closeThisTab() throws Exception {
		webDriverWaitByWebElement(closeThisTab);
		closeThisTab.click();
	}

	public void ClickOrdersPAD(){
		webDriverWaitByWebElement(OrdersPADClick);
		OrdersPADClick.click();
		extentTest.log(Status.PASS, "User successfully opened Orders PAD workqueue");
	}

	public void switchToFrame_PegaGadget1Ifr() {
		driver.switchTo().frame(Frame_PegaGadget1Ifr);
	}

	public void clickRateReviewHeader() throws Exception { 
		webDriverWaitByWebElement(RateReviewHeaderClick);
		RateReviewHeaderClick.click();
	}
	
	public void clickShipmentSchedulingHeader() {
		webDriverWaitByWebElement(ShipmentSchedulingHeaderClick);
		ShipmentSchedulingHeaderClick.click();
	}
	
	public void ShipmentScheduling_OrderID_Filter() {
		webDriverWaitByWebElement(ShipmentScheduling_OrderID_Filter);
		ShipmentScheduling_OrderID_Filter.click();
	}
	
	public void OrderSearchBoxClick() {
		webDriverWaitByWebElement(OrderSearchBoxClick);
		OrderSearchBoxClick.click();
		webDriverWaitByWebElement(OrderSearchBoxClick);
		OrderSearchBoxClick.sendKeys(orderID);
		webDriverWaitByWebElement(ApplyClick);
		ApplyClick.click();
		getOrderID(orderID).click();
		driver.switchTo().defaultContent();
	}
	
	
	public WebElement getOrderID(String orderID) {
	    return driver.findElement(By.xpath("//a[contains(text(),'" + orderID + "')]"));
	}

}
