package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_BAI2 extends CommonBase{
	private static final By BTN_TRY_IT = By.xpath("//button[normalize-space()='Try it']");

	private static final Duration EXPLICIT_WAIT_TIMEOUT = Duration.ofSeconds(30);
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDriver(CT_PageURL.SEALERT_URL);
		
	}
	@Test
	public void pressSucessful() 
	{
		// 1. Click button "Try it"
	    click(BTN_TRY_IT);

	    // 2. Chờ và xử lý alert thành công
	    WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);

	    // Chờ đến khi alert xuất hiện
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    // Lấy text và verify
	    String actualMessage = alert.getText().trim();
	    
	    System.out.println("Nội dung thông báo: " + actualMessage);
	    //assertEquals(actualMessage,  "Thông báo alert: " + actualMessage );

	    // Đóng alert
	    alert.accept();

	    		
	}
}
