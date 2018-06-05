import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utility.Xls_Reader;

public class DataDrivenTest {
	public static void main(String[] args) throws InterruptedException {

		//get test data from excel:
		
		
        //webdriver code:
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\436793\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.hometown.in/Living-Essence-White-Plate-293724.html");
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		
				
				//get test data from excel:
				Xls_Reader reader = new Xls_Reader("C:\\Users\\436793\\Desktop\\Final Testimonial2 HT 1.1.18 to Mar 18 (2).xlsx");
				int rowCount = reader.getRowCount("Rating&Reviews");
				
				reader.addColumn("Rating&Reviews", "Status");
				
				//Parameterization:
				for(int rowNum = 2; rowNum<=rowCount; rowNum++){
					System.out.println("=====");
					String SKU = reader.getCellData("Rating&Reviews", "SKU", rowNum);
					System.out.println(SKU);
					
					String Name = reader.getCellData("Rating&Reviews", "Name", rowNum);
					System.out.println(Name);
					
					String Review = reader.getCellData("Rating&Reviews", "Review", rowNum);
					System.out.println(Review);
			
					//enter data:
					WebElement element = driver.findElement(By.xpath("//a[@id=\"ProductRatingLink\"]/span"));
					JavascriptExecutor js =(JavascriptExecutor)driver;
					js.executeScript("scroll(436,567)");
					// Actions action = new Actions(driver);
					// action.moveToElement(element).click().perform();
					driver.findElement(By.xpath("//a[@id=\"ProductRatingLink\"]/span")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//label[@for=\"ProductRatingFormOption_rating_4\"]//span[@title=\"4\"]")).click();
					driver.findElement(By.xpath("//input[@id=\"RatingForm_name\"]")).sendKeys("Test");
					driver.findElement(By.xpath("//textarea[@id=\"RatingForm_comment\"]")).sendKeys("Test");
					driver.findElement(By.xpath("//input[@id=\"ProductRatingFormAction_submit\"]")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//div[@class=\"box s-success mbs msgBox\"]")).isDisplayed();
					reader.setCellData("Rating&Reviews", "Status", rowNum, "Pass"); //write the data into a cell
					driver.get("https://www.hometown.in/Living-Essence-White-Plate-293724.html");
					
				}
				
	
	}


}
