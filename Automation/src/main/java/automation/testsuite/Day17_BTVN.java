package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_BTVN extends CommonBase{
	@BeforeMethod
	@Parameters("browser")
	public void openWebPage(@Optional("firefox")String browserSetup)
	{
		//driver=initFirefoxDrivers(CT_PageURL.MEADIAMART_URL);
		setupDriver(browserSetup);
		driver.get(CT_PageURL.MEADIAMART_URL);
	}
	
	@Test
	public void clickZalo_runWithFF()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số Lượng iframe la: "+size);
		
		driver.switchTo().frame(findElement_fluent(By.xpath("//ifram[contains(@src,'page.widget.zalo.me')]")));
		click(By.xpath("//div[@class='za-chat__head-box']"));
		assertTrue(isDisplay_fluent(By.xpath("//p[text()='Siêu thị điện máy MediaMart']")));
		
	}
	
	@Test
	public void clickZalo_RunWithChrome()
	{
		try {
			
		    // 1. Accessing the Element within the Shadow DOM
		    // Assuming 'my-component' is the shadow host
		    WebElement shadowHost = driver.findElement(By.cssSelector("easychatgpt-widget"));
		    SearchContext shadowRoot = shadowHost.getShadowRoot();

		    // Assuming '.hover-target' is the element inside the shadow DOM to hover over
		    WebElement targetElement = shadowRoot.findElement(By.cssSelector("div.chat-widget.position-right"));

		    //click button close voi csss selector button.w-5.h-5
		    WebElement closeButton = shadowRoot.findElement(By.cssSelector("button.w-5.h-5"));
		    JavascriptExecutor js =  (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", closeButton);
		    js.executeScript("arguments[0].click();", closeButton);
		    
		    driver.switchTo().frame(findElement_fluent(By.xpath("//ifram[contains(@src,'page.widget.zalo.me')]")));
			click(By.xpath("//div[@class='za-chat__head-box']"));
			assertTrue(isDisplay_fluent(By.xpath("//p[text()='Siêu thị điện máy MediaMart']")));
		    
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
	
	@Test
	public void clickZaloChrome() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    int size = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Số lượng iframe là: " + size);

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(
	        "document.querySelector('#easychatgpt-widget')" +
	        ".shadowRoot.querySelector('div.px-3.pt-3')" +
	        ".click();"
	    );

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	    js.executeScript(
	        "document.querySelector('#easychatgpt-widget')" +
	        ".shadowRoot.querySelector(\"button[aria-label='eac-close-chat']\")" +
	        ".click();"
	    );

	    driver.switchTo().frame(findElement_fluent(By.xpath("//iframe[contains(@src,'page.widget.zalo.me')]")));
	    click(By.xpath("//div[@class='za-chat__head-box']"));
	    assertTrue(isDisplay_fluent(By.xpath("//p[text()='Siêu thị điện máy MediaMart']")));
	}

	/*public void chatZalo_Successfully() {
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
	}*/
	public void closeDriver()
	{
		closeDriver();
	}

}
