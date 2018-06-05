import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\436793\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hometown.in");
		
		 List<String> weeklyDeals = new ArrayList<String>();
		
		
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 
		 List<WebElement> list = driver.findElements(By.xpath("//div[@id='weeklyDeal']//a"));

		 for (int i=0;i<list.size();i++) {
			 System.out.println("Values " + list.get(i).getAttribute("href"));
			 // driver.navigate().to(list.get(i).getAttribute("href"));
			 weeklyDeals.add(list.get(i).getAttribute("href"));
			 //driver.navigate().to(weeklyDeals.get(i));
	         // Here we will verify if link (item) is equal to Java Script
	         // break the loop or come out of loop
	 
	           //  break;
		 }
		 
		 for (int i=0;i<weeklyDeals.size();i++)
		 { 
	     driver.navigate().to(weeklyDeals.get(i));}
			 
	}

}
