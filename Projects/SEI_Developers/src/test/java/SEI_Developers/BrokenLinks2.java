package SEI_Developers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks2 {
	
	
	private static WebDriver driver = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    	String homePage = "https://developers.seic.com/browse/home";
    	String url="";
    	System.setProperty("webdriver.chrome.driver", "F:\\Aparna_Java\\Projects\\SEI_Developers\\Drivers\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePage);
        
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());
   
        //We will iterate through the list and will check the elements in the list.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
         url = iterator.next().getText();
         System.out.println(url);
        }
        
       //Close the browser session
        driver.quit();
      }
  }