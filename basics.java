package basics;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class basics {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akshatrai\\Desktop\\softwares\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); 
        driver.get("http://10.0.1.86/tatoc"); 
        driver.findElement(By.linkText("Basic Course")).click();
        driver.findElement(By.className("greenbox")).click();

		
	}

}

