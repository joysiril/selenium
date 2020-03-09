package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class redbus_page2 {
	
	WebDriver dr;
	By typ=By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li[3]");
	By name=By.xpath("//*[@id=\"9033405\"]/div/div[1]/div[1]/div[1]/div[1]");
	 
	
	public redbus_page2(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void set_bustype()
	{
		
		dr.findElement(typ).click();
	}
	
	public void bus_name()
	{
		dr.findElement(name).getText();
	}
	 public void do_verify()
	 {
		 this.set_bustype();
		 this.bus_name();
	 }

}

