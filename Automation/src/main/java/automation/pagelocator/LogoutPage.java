package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LogoutPage(WebDriver _driver) {
		this.driver = _driver;
	}
	public void logoutFunction() {
        try {
            // Bước 1: Click vào nút mở dropdown (Tài khoản của tôi)
            By dropdownToggle = By.xpath("//a[contains(@class,'dropdown-toggle') and contains(text(),'Tài khoản')]");


            WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(dropdownToggle));
            toggle.click();

            // Bước 2: Đợi và click nút Đăng xuất
            By logoutButton = By.xpath("//button[normalize-space()='Đăng xuất']");

            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            logoutBtn.click();

            // (Tùy trang) Có thể cần đợi alert hoặc redirect sau khi logout
            // wait.until(ExpectedConditions.urlContains("login")); // nếu cần

        } catch (Exception e) {
            throw new RuntimeException("Đăng xuất thất bại: " + e.getMessage(), e);
        }
    }

}
