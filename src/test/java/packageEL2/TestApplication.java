package packageEL2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestApplication {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://epicuatlb.estes-express.com/prweb/PRAuth/app/epic/vQbSpdBva3zBDbMlMRMsHQ*/!STANDARD");

		driver.manage().window().maximize();
	}

	

}
