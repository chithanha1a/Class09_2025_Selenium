package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Bai16_Bai1 extends CommonBase{
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
		
	}
	@Test
	public void loginSucessful() {
		By BTN_LUU_TRONG_MODAL = By.xpath("//button[normalize-space()='Lưu']");
	    type(By.name("email"), "admin@gmail.com");
	    type(By.name("password"), "12345678");
	    click(By.xpath("//button[text()='Đăng nhập']"));
	    driver.switchTo().alert().accept();
	    // Chờ alert rồi accept
	    click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
	    
	    click(By.xpath("//button[text()='Thêm mới' and @type='button']"));
	    
	    type(By.name("work_areas_code"), "KV210053");
	    type(By.name("name"), "TEST AUTO 210053");
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(BTN_LUU_TRONG_MODAL));
	    click(BTN_LUU_TRONG_MODAL);
	   
	    click(By.xpath("//a[normalize-space()='Thêm']"));
	    
	    type(By.name("query"), "TEST AUTOMATION");
	    
	    click(By.xpath("//button[text()='Tìm kiếm' and @type='submit']"));
	    
	    driver.switchTo().alert().accept();
	    
	    //click(By.xpath("//tr[2]//a[contains(@onclick, 'return confirm')]"));
	    By BTN_XOA_CUA_TEST_AUTOMATION = By.xpath("//td[normalize-space()='TEST AUTOMATION']/following-sibling::td//a[normalize-space()='Xóa']");
	    click(BTN_XOA_CUA_TEST_AUTOMATION);
	    
	    driver.switchTo().alert().accept();
	    
	  
	}
}
