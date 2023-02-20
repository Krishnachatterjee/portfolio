package AmazonPackage;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class AmazonPage {
	WebDriver driver;
	
	public AmazonPage(WebDriver driver){
		this.driver = driver;
	}
	
	By login_button = By.xpath("//a[@data-nav-role='signin']");
	By logInByEmail = By.id("ap_email");
	By continue_button = By.id("continue");
	By password_details = By.id("ap_password");
	By signIn_button = By.id("signInSubmit");
	By searchItem = By.id("twotabsearchtextbox");
	String item = "Samsung earbuds";
	By buyNow = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	By buyButton = By.name("submit.buy-now");
	By amazonLogo = By.partialLinkText("Amazon.in");
    By signout = By.xpath("//i[@class='hm-icon nav-sprite']");
	By signoutButton = By.xpath("//a[text()='Sign Out']");
	
	public void login(){
		//Finding login
		driver.findElement(login_button).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login box
        driver.findElement(logInByEmail).sendKeys("", Keys.ENTER);
		driver.findElement(signIn_button).click();
		//Entering password
		driver.findElement(password_details).sendKeys("");
		driver.findElement(signIn_button).click();
	}
	
	public void searchItem(){
		//Searching item in Amazon
		driver.findElement(searchItem).sendKeys(item, Keys.ENTER);
		driver.findElement(buyNow).click();
	}
	
	public void SwitchWindow(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//getting window handle of Parent Window
		String parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String str: windows){
			if(!str.equals(parent_window)){
				//switching to new Window
				driver.switchTo().window(str);
			}
		}
	}
	public void buyNowButton(){
        //Buying an item
		driver.findElement(buyButton).click();
		
	}
	
	public void logOut(){
		//Logging Out
		driver.findElement(amazonLogo).click();
		driver.findElement(signout).click();
		driver.findElement(signoutButton).click();
	}
	
 
}
