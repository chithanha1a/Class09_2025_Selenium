package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;

public class Day17_HandleIframe extends CommonBase {
	
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDriver(CT_PageURL.CODESTART2_URL);
		
	}
	/*@Test
	public void dangKyTuVan_NotSuccessfully()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int size= driver.findElements(By.tagName("iframe")).size();
		System.out.println("So Luong Iframe: "+size);
		scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
		driver.switchTo().frame(0);
		type(By.id("name"),"Test Name");
		type(By.id("phone_number"),"0909090909");
		type(By.id("email"),"email@gmail.com");
		assertTrue(isDisplay_fluent(By.id("name")));
	}
	
	@Test 
	public void  followFacebook() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String firstWindow = driver.getWindowHandle();
		int size= driver.findElements(By.tagName("iframe")).size();
		System.out.println("So Luong Iframe: "+size);
		scrollToElement(By.xpath("//p[text()='Về chúng tôi']"));
		driver.switchTo().frame(3);
		click(By.xpath("//a[text()='Follow Page']"));
		// Mở ra tab Window mới, lấy currentURL rồi assert.
		 
		Set<String> windows = driver.getWindowHandles();
	    for(String childWindow : windows)
	    {
	        if(!childWindow.equals(firstWindow))
	        {
	            driver.switchTo().window(childWindow);
	            Thread.sleep(5000);
	            String actualUrl = driver.getCurrentUrl();
	            System.out.println(" Link:"+actualUrl);
	            assertEquals(actualUrl, "https://www.facebook.com/CodeStarAcademy/?ref=embed_page");
	            driver.close(); // Close the child window after processing
	        }
	    }

	    // Go back to the first window to continue execution
	    driver.switchTo().window(firstWindow);	    
	}*/
}
