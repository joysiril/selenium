package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class redbus_bkg_page {
	
	By src=By.xpath("//input[@id='src']");
	By dst=By.xpath("//input[@id='dest']");
	By ds=By.xpath("//li[@data-id='123']");
	By search=By.xpath("//button[@id='search_btn']");
	 
	WebDriver dr;

	public  redbus_bkg_page(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void set_src(String s1)
	{
		dr.findElement(src).sendKeys(s1);
		WebDriverWait wt=new WebDriverWait(dr,10);
		WebElement we=wt.until(ExpectedConditions.elementToBeClickable(src));
		we.click();
		//dr.findElement(src).sendKeys(s1);
	}
	
	public void set_dst(String d1)
	{
		dr.findElement(dst).sendKeys(d1);
		WebDriverWait wt=new WebDriverWait(dr,10);
		WebElement we=wt.until(ExpectedConditions.elementToBeClickable(ds));
		we.click();
	}
	
	public void Select_Date()
	{
		String curr_yr,exp_mon_yr="Apr 2020";
	dr.findElement(By.xpath("//label[@for='onward_cal']")).click();
	System.out.println();

	curr_yr=dr.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//following::td[1]")).getText();
	System.out.println(curr_yr);

	while(!curr_yr.equals(exp_mon_yr))
	{

	dr.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//following::td[2]")).click();
	curr_yr=dr.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//following::td[1]")).getText();
	}

	List<WebElement> li=dr.findElements(By.xpath("//*[@class='rb-monthTable first last']//following::td[1]"));
	for(WebElement ele: li)
	{
	String date=ele.getText();
	if(date.equals("15"))
	{
	ele.click();
	break;
	}
	}
	}

	public void clk_sch()
	{
		dr.findElement(search).click();
	}
	
	public void do_login(String s,String d)
	{
		this.set_src(s);
		this.set_dst(d);
		this.Select_Date();
		this.clk_sch();
	}
	
//	public String get_title()
//	{
//		return dr.getTitle();
//	}

}
