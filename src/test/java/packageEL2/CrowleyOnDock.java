package packageEL2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CrowleyOnDock extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	public void PAR_LTL() throws Exception {
		Pom pom = new Pom(driver);
		pom.PAR_Order_Create(); // LTL
		pom.Await(By.id("loginText2"));
		pom.PEGALogin();
		pom.LaunchWarehousePortal();
		pom.OnDock();
		driver.switchTo().defaultContent();
		pom.frameSwitch();
		Await();
		pom.OrderSearchandFilter();
		Await();
		pom.CheckBox_Click.click();
		
	}
	
}
