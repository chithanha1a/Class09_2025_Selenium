package automation.testsuite;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_HandleIframe extends CommonBase {
	
	@BeforeMethod
	@Parameters("browser")
	public void openWebPage(@Optional("firefox")String browserSetup)
	{
		//driver=initFirefoxDriver(CT_PageURL.CODESTART2_URL);
		setupDriver(browserSetup);
		driver.get(CT_PageURL.CODESTART2_URL);
		
		
	}
	
	@Test
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
    /*@Test
    public void checkboxHandle() {
        // Case1: Kiểm tra giá trị mặc định (theo yêu cầu REQ), ví dụ: vào trang web thì các checkbox chưa được check
        
        // 1. Tìm các element input checkbox
        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1")); // input element
        WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2")); // input element
        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3")); // input element
        
        // 2. Mong đợi cả 3 checkbox đều chưa được check (theo REQ)
        boolean checkSport = sportCheckbox.isSelected();
        boolean checkReading = readCheckbox.isSelected();
        boolean checkMusic = musicCheckbox.isSelected();
        
        // 3. Thực hiện Assert (Kiểm chứng)
        // Lưu ý: ảnh gốc lặp lại checkMusic 2 lần, tôi giữ nguyên
        assertFalse(checkMusic);
        assertFalse(checkReading);
        assertFalse(checkMusic);
    }*/
    
	
	/*@Test 
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
	public void closeDriver()
	{
		closeDriver();
	}
}
