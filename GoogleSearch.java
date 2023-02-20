package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
	
	WebDriver driver;
	
	public GoogleSearch(WebDriver driver){
		this.driver = driver;
	}
	
	By searchBox = By.xpath("//input[@name='q']");
	By searchButton = By.name("btnK");
	By link_amazon = By.xpath("//*[@id='tads']/div/div/div/div/div[1]/a/div[1]");
	
	public void searchInGoogle(String search){
		try{
		driver.findElement(searchBox).sendKeys(search);
		driver.findElement(searchButton).click();
		
		}
		catch (Exception e) {
			System.out.println("Exception caught"+e.getMessage());
		}
	}
	public void linkinGoogle(){
		try {
			driver.findElement(link_amazon).click();
			
		} catch (Exception e) {
			System.out.println("Exception caught"+e.getMessage());

		}
	}

}
