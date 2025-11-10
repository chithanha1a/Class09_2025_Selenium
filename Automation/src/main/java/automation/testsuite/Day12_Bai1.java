package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Bai1 extends CommonBase{
	@Test
	public void ContrySelect()
	{
		driver = initChromeDriver(CT_PageURL.GLOBAL_URL);
		Select dropCourse = new Select(driver.findElement(By.xpath("//div[@class='information closable']/following::select")));
		int size = dropCourse.getOptions().size();
        System.out.println("Size is: " + size);
		
     // Chọn AWS theo cách 1
        dropCourse.selectByVisibleText("Viet Nam");
        String VNM = dropCourse.getFirstSelectedOption().getText();
        System.out.println("Text sau khi chọn AWS: " + VNM);
	}

}
