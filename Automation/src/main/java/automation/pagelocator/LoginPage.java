package automation.pagelocator;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	 
	private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By SIGNIN_BUTTON = By.name("signin");
    private static final By LOGIN_HEADER = By.xpath("//h4[text()='Đăng nhập']");
    private static final By DROPDOWN_TOGGLE = By.xpath("//a[@id='dropdownMenuLink']");
    private static final By LOGOUT_BUTTON = By.xpath("//button[normalize-space()='Đăng xuất']");
    private static final By LOGOUT_MODAL_BUTTON = By.xpath("//div[@id='MyModal']//button[@form='logout' and contains(text(),'Đăng xuất')]");
    
    private static final int DEFAULT_TIMEOUT = 10;

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}
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

	    driver.findElement(By.name("signin")).click();
	    // accept alert	    
	    driver.switchTo().alert().accept();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
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
	    
	    driver.switchTo().alert().accept();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    
	    WebElement textDangNhap=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    assertTrue(textDangNhap.isDisplayed());
	}
	
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
	    
	    
	    driver.switchTo().alert().accept();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    //WebElement textDangNhap=driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']"));
	    WebElement textDangNhap=driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    assertTrue(textDangNhap.isDisplayed());
	}
	
	public void loginFail(String email, String password) {
        enterCredentials(email, password);
        clickSignIn();
        handleAlert();
        
        // Verify login page is still displayed (login failed)
        WebElement loginHeader = wait.until(
            ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADER)
        );
        assertTrue(loginHeader.isDisplayed(), "Login page should be displayed after failed login");
    }
	public void logoutFunction() {
        try {
            // Click dropdown toggle
            WebElement dropdownElement = wait.until(
                ExpectedConditions.elementToBeClickable(DROPDOWN_TOGGLE)
            );
            dropdownElement.click();
            
            // Click logout button in dropdown
            WebElement logoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON)
            );
            logoutBtn.click();
            
            // Click logout button in modal
            WebElement logoutModalBtn = wait.until(
                ExpectedConditions.elementToBeClickable(LOGOUT_MODAL_BUTTON)
            );
            logoutModalBtn.click();
            
            // Verify login page appears after logout
            WebElement loginHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADER)
            );
            assertTrue(loginHeader.isDisplayed(), "Login page should be displayed after logout");
            
        } catch (Exception e) {
            throw new RuntimeException("Đăng xuất thất bại: " + e.getMessage(), e);
        }
    }
	
	private void enterCredentials(String email, String password) {
        WebElement emailInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT)
        );
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT)
        );
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
	
	private void clickSignIn() {
        WebElement signInBtn = wait.until(
            ExpectedConditions.elementToBeClickable(SIGNIN_BUTTON)
        );
        signInBtn.click();
    }
	
	 private void handleAlert() {
	        try {
	            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(3));
	            alertWait.until(ExpectedConditions.alertIsPresent());
	            driver.switchTo().alert().accept();
	        } catch (Exception e) {
	            // Alert not present, continue
	        }
	    }

}
