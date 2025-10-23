package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;

public final class TS_PracticeLocateElement extends CommonBase {

    @BeforeMethod
    public void init() {
        driver = initWebDriver("https://bepantoan.vn/danh-muc/may-hut-mui");
    }
	
    @Test
    public void Demo_Testcase() throws InterruptedException
	{
		Thread.sleep(3000); 
		driver.findElement(By.partialLinkText("Hút Mùi Ống Khói"));
		System.out.println(" Link test is ok");
		driver.close();
	}
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}