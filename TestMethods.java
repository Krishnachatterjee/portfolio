package AmazonPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
	WebDriver driver;
	AmazonPage ap;
	
	@BeforeTest
	public void beforeTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	@Test(priority = 0)
	public void searchOnGoogle() {
		GoogleSearch gs = new GoogleSearch(driver);
		gs.searchInGoogle("amazon");
		gs.linkinGoogle();
	}
	
	@Test(priority = 1)
	public void logIn(){
		ap = new AmazonPage(driver);
		ap.login();
	}
	
	@Test(priority = 2)
	public void searchItem(){
		ap = new AmazonPage(driver);
		ap.searchItem();
	}
	
	@Test(priority = 3)
	public void buyingAnItem(){
		ap = new AmazonPage(driver);
		ap.SwitchWindow();
		ap.buyNowButton();
	}
	
	@Test(priority = 4)
	public void signOut(){
		ap = new AmazonPage(driver);
		ap.logOut();
	}
	
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}
