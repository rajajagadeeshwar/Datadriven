package datadrivenwithexcel;
/**
 * @author Jagadeeshwar
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datadrivenwithdataprovider.Screenshot;

public class Wordpresslogin {

	WebDriver driver;

	@BeforeMethod()
	public void browser() {

		System.setProperty("webdriver.chrome.driver", "G:\\selenium\\webdriver\\browser drivers\\chromedriver2.33.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("http://demosite.center/wordpress/wp-login.php");

		Screenshot.screenshottaken(driver, "wp-loginpage");
	}

	@Test(dataProvider = "testdata")
	public void logintoword(String uname, String paswd) throws Exception {

		driver.findElement(By.id("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_pass")).sendKeys(paswd);
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		System.out.println(driver.getTitle());

		Assert.assertTrue(driver.getTitle().contains("Dashboard"));
		Screenshot.screenshottaken(driver, "wp-login successfull");

		Thread.sleep(5000);

	}

	@DataProvider(name = "testdata")

	public Object[][] testdata1() {

		
	Excelutil obj= new Excelutil("C:\\Users\\welcome\\workspace\\datadrivenframework\\Testdata\\Testdata.xlsx");
		
	int rows=obj.getrowcount(0)	;
	Object[][] data = new Object[rows][2];

		
		for(int i=0;i<rows;i++){
		data[i][0] = obj.readingdata(0, i, 0);
		data[i][1] = obj.readingdata(0, i, 1);

		
		
	}
		return data;
	}
	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.quit();

	}

}
