package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage;
import automation.pagelocator.LogoutPage;

public class LoginTest extends CommonBase {
	private static final int DEFAULT_TIMEOUT = 10;
    private static final By LOGIN_HEADER_LOCATOR = By.xpath("//h4[text()='Đăng nhập']");
    
    private LoginPage loginPage;
    private WebDriverWait wait;
	 @BeforeMethod
	 public void openWebPage()
	 {
		 
		 driver=initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
		 loginPage = new LoginPage(driver);
	     wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	 }
	 
	 @Test(priority = 1, description = "Verify login fails with incorrect username")
	 public void loginSuccessfully()
	 {
		 loginPage =  new LoginPage(driver);
		 loginPage.LoginFunction("admin@gmail.com","12345678");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 loginPage.logoutFunction();
		 
	 }
	 @Test(priority = 1)
	 public void loginFail_user()
	 {
		 loginPage =  new LoginPage(driver);
		 loginPage.loginFail_INcorrectUsername("admin2@gmail.com","123456738");
		     
		 WebElement textQuanLyND=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 assertTrue(textQuanLyND.isDisplayed()," Failed username");
	 }
	 @Test(priority = 2)
	 public void loginFail_pass()
	 {
		 loginPage =  new LoginPage(driver);
		 loginPage.loginFail_INcorrectPassword("admin@gmail.com","1234536738");
		 
		 //driver.switchTo().alert().accept();
		    
		 WebElement textQuanLyND=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 assertTrue(textQuanLyND.isDisplayed(),"Failed pass");
	 }
	 @Test(priority = 3)
	 public void loginFail_user_pass()
	 {
		 loginPage =  new LoginPage(driver);
		 loginPage.loginFail("admi3n@gmail.com","12345836738");
		 
		 WebElement textQuanLyND=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 assertTrue(textQuanLyND.isDisplayed(),"Error User and pass");
	 }
		    
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
