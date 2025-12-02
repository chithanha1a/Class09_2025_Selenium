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

public class Day16_Bai3 extends CommonBase{
	
	// === LOCATOR CÁC TAB ===
    private static final By TAB_ALERT_OK         = By.xpath("//a[normalize-space()='Alert with OK']");
    private static final By TAB_ALERT_OK_CANCEL  = By.xpath("//a[normalize-space()='Alert with OK & Cancel']");
    private static final By TAB_ALERT_TEXTBOX    = By.xpath("//a[normalize-space()='Alert with Textbox']");

    // === LOCATOR 3 NÚT CHÍNH ===
    private static final By BTN_ALERT_BOX     = By.xpath("//button[@onclick='alertbox()']");
    private static final By BTN_CONFIRM_BOX   = By.xpath("//button[@onclick='confirmbox()']");
    private static final By BTN_PROMPT_BOX    = By.xpath("//button[@onclick='promptbox()']");
    
    
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDriver(CT_PageURL.DEMOALERT_URL);
		
	}
	@Test
	public void pressSucessful() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		
		//click(By.xpath("//a[normalize-space()='Alert with OK']"));
		
		//click(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));	
		// 1. Alert with OK
        click(TAB_ALERT_OK);
        click(BTN_ALERT_BOX);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    // Lấy text và verify
	    String actualMessage = alert.getText().trim();
	    
	    System.out.println("Nội dung thông báo 1: " + actualMessage);
	    alert.accept();

        // 2. Alert with OK & Cancel (Confirm)
        click(TAB_ALERT_OK_CANCEL);
        click(BTN_CONFIRM_BOX);

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());

	    // Lấy text và verify
	    String actualMessage2 = alert2.getText().trim();
	    
	    System.out.println("Nội dung thông báo 2: " + actualMessage2);
	    alert2.accept();

        // 3. Alert with Textbox (Prompt)
        click(TAB_ALERT_TEXTBOX);
        click(BTN_PROMPT_BOX);

        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());

	    // Lấy text và verify
	    String actualMessage3 = alert3.getText().trim();
	    
	    System.out.println("Nội dung thông báo 3: " + actualMessage3);
	   

        String name = "Code Start Automation";
        alert3.sendKeys(name);
        alert3.accept();

        System.out.println("Prompt box đã nhập tên và verify thành công");
		
	}
}
