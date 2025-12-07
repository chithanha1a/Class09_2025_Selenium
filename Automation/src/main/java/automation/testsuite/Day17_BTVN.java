package automation.testsuite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_BTVN extends CommonBase{
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDrivers(CT_PageURL.MEADIAMART_URL);
		
	}
	
	@Test
	public void chatZalo_Successfully() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // 1) Ẩn popup EasyChat phía ngoài
	    js.executeScript(
	        "document.querySelectorAll('#easychatgpt-widget, .chat-widget, .chat-button-group')" +
	        ".forEach(e => e.style.display = 'none');"
	    );
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    // 2) Switch vào iframe Zalo
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	            By.cssSelector("iframe[src*='zalo']"))
	    );

	    // ❌ BỎ DÒNG NÀY (không có alert)
	    
	     WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
	    // 3) Click icon Zalo (Logo.svg)
	     wait2.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("img[src*='Logo.svg']"))).click();
	   
	    // 4) Click nút "Chat bằng Zalo"
	    wait2.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[contains(@class,'zbtn-normal') and contains(text(),'Chat nhanh')]")
	    )).click();
	}

}
