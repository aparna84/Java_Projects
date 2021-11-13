package TravelPHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void Login() 
	{
		System.setProperty("webdriver.chrome.driver", "F://Aparna_Java//Projects//TravelPHP//libs//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("aparna.guttula@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Vijaya@10");
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block loginbtn\']")).click();
		
	}
}
