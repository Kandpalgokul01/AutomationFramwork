package qspider.WebElement;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import qspider.utility.FileUtility;

public class BaseClass
{
	public WebDriver driver;
	
	public FileUtility fileUtil= new FileUtility();
	
	
	@BeforeClass
     public void bc() throws IOException {
		String browserName= fileUtil.fetchDetailsFromPropertiyFile("browser");
		String url= fileUtil.fetchDetailsFromPropertiyFile("url");
		
		if(browserName.equals("google"))
		{
			driver= new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("Launch thr browser");
		
		driver.get(url);
	    System.out.println("Navigate to url");
	    
			
	}
	
	@AfterClass
	public void ac() {
		driver.quit();
		System.out.println("Close the browser");
	}
	
}
