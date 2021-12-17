
//push and pull
//package com.flipkart.home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.flipkart.generic.FileLibrary;
import com.flipkart.generic.IAutoConsts;

public class ActiInvalid implements IAutoConsts
{
	
	public static void main(String[] args) throws Throwable
	{
		//hi 
		//hello
		FileLibrary flib=
		new FileLibrary();
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://desktop-6ofrcdd/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SoftAssert sa =new SoftAssert();
		for(int i=0;i<=3;i++)
		{
			//System.out.println(i);
			//driver.navigate().refresh();
		WebElement un=driver.findElement(By.xpath("//input[@name='username']"));
		
	un.sendKeys(flib.getCellData("./data/testdata.xlsx","Sheet1", i, 0));

		WebElement pd=driver.findElement(By.xpath("//input[@name='pwd']"));
		pd.sendKeys(flib.getCellData("./data/testdata.xlsx","Sheet1",i , 1));
		WebElement lc=driver.findElement(By.id("loginButton"));
		lc.click();
		Thread.sleep(2000);
	    
	WebElement em=driver.findElement(By.xpath("//span[.='Username or Password is invalid. Please try again.']"));
	String text=em.getText();
	
	sa.assertEquals(text, "Username or Password is invalid. Please try again.");
	//un.clear();		
	
		
	}
		sa.assertAll();
}

}
