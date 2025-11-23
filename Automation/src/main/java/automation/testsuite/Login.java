package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Login extends CommonBase {
	
	public void LoginFunction(String email, String pass) {
	    WebElement txtEmail = driver.findElement(By.id("email"));
	    if (txtEmail.isDisplayed()) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }


	    WebElement txtPass = driver.findElement(By.id("password"));
	    if (txtPass.isDisplayed()) {
	        txtPass.clear();
	        txtPass.sendKeys(pass);
	    }

	    WebElement btnSubmit = driver.findElement(By.name("signin"));
	    if (btnSubmit.isDisplayed()) {
	        btnSubmit.click();
	    }
	    // accept alert
	    
	    driver.switchTo().alert().accept();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    WebElement textQuanLyND=driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
	    assertTrue(textQuanLyND.isDisplayed());
	}
	
	@Test
	public void loginFail_INcorrectUsername(String email, String pass)
	{
		WebElement txtEmail = driver.findElement(By.id("email"));
	    if (txtEmail.isDisplayed()) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }


	    WebElement txtPass = driver.findElement(By.id("password"));
	    if (txtPass.isDisplayed()) {
	        txtPass.clear();
	        txtPass.sendKeys(pass);
	    }

	    WebElement btnSubmit = driver.findElement(By.name("signin"));
	    if (btnSubmit.isDisplayed()) {
	        btnSubmit.click();
	    }
	    
	   // driver.switchTo().alert().accept();
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    
	    WebElement textDangNhap=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    assertTrue(textDangNhap.isDisplayed());
	}
	@Test
	public void loginFail_INcorrectPassword(String email, String pass)
	{
		WebElement txtEmail = driver.findElement(By.id("email"));
	    if (txtEmail.isDisplayed()) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }


	    WebElement txtPass = driver.findElement(By.id("password"));
	    if (txtPass.isDisplayed()) {
	        txtPass.clear();
	        txtPass.sendKeys(pass);
	    }

	    WebElement btnSubmit = driver.findElement(By.name("signin"));
	    if (btnSubmit.isDisplayed()) {
	        btnSubmit.click();
	    }
	    
	    
	    //driver.switchTo().alert().accept();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    //WebElement textDangNhap=driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']"));
	    WebElement textDangNhap=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    assertTrue(textDangNhap.isDisplayed());
	}
	
}
