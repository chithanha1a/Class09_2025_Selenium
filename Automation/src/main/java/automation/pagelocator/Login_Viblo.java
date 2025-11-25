package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Viblo {
	private WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Tên người dùng hoặc email']") WebElement textUserEmail;
	@FindBy(xpath = "//input[@placeholder='Mật khẩu']") WebElement textUserPass;
	@FindBy(xpath = "//button[contains(., 'Đăng nhập')]") WebElement btnDangNhap;
	@FindBy(xpath = "//a[.//small[contains(text(), 'Tạo tài khoản')]]")  WebElement btnRegistry;
	//@FindBy(xpath = "//input[contains(@placeholder, 'người dùng')]")
	@FindBy(xpath = "//input[@placeholder='Tên của bạn']") WebElement textTen;
	@FindBy(xpath = "//input[@placeholder='Địa chỉ email của bạn']") WebElement textEmail;
	@FindBy(xpath = "//input[@placeholder='Tên tài khoản']") WebElement textTaiKhoan;
	@FindBy(xpath = "//input[@placeholder='Mật khẩu']") WebElement textMatKhau;
	@FindBy(xpath = "//input[@placeholder='Xác nhận mật khẩu của bạn']") WebElement textMatKhauRe;
	@FindBy(xpath = "//span[contains(@class,'el-checkbox__input')]") WebElement checkboxDongY;
	@FindBy(xpath = "//span[normalize-space()='Đăng ký']/parent::button") WebElement btnDangKy;
	public Login_Viblo(WebDriver driverTest) {
		
		this.driver = driverTest;
		PageFactory.initElements(driverTest, this);
	}
	
	public void LoginFunction (String email, String password) {
		textUserEmail.sendKeys(email);
		textUserPass.sendKeys(password);
		btnDangNhap.click();
	}
	
	public void CreateAccount(String Ten,String email,  String TenTK, String password)
	{
		btnRegistry.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		textTen.sendKeys(Ten);
		textEmail.sendKeys(email);
		textTaiKhoan.sendKeys(TenTK);
		textMatKhau.sendKeys(password);
		textMatKhauRe.sendKeys(password);
		checkboxDongY.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		btnDangKy.click();
	}
}
