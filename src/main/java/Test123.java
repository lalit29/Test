import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utility.Xls_Reader;

public class Test123 {
	public static void main(String[] args) throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\436793\\Desktop\\Book1.xlsx");
		String fName=reader.getCellData("data", "name", 2);
       System.out.println(fName);
       
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\436793\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome  
		driver.get("https://www.hometown.in/Living-Essence-White-Plate-293724.html");
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 WebElement element = driver.findElement(By.xpath("//a[@id=\"ProductRatingLink\"]/span"));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("scroll(436,567)");
		 driver.findElement(By.xpath("//a[@id=\"ProductRatingLink\"]/span")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//label[@for=\"ProductRatingFormOption_rating_4\"]//span[@title=\"4\"]")).click();
			driver.findElement(By.xpath("//input[@id=\"RatingForm_name\"]")).sendKeys(fName);
			driver.findElement(By.xpath("//textarea[@id=\"RatingForm_comment\"]")).sendKeys("Test");
			driver.findElement(By.xpath("//input[@id=\"ProductRatingFormAction_submit\"]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class=\"box s-success mbs msgBox\"]")).isDisplayed();
			
			driver.get("https://www.hometown.in/Living-Essence-White-Plate-293724.html");
}
}