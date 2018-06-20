package basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
	    
		//For first problem
		
		driver.findElement(By.linkText("Basic Course")).click();// click on Basic Course Link
	    driver.findElement(By.className("greenbox")).click();// click on Green Box
	    
	    //For second problem
	    
	    driver.switchTo().frame("main");
	    String box1 = driver.findElement(By.id("answer")).getAttribute("class");// get first box color
	    
	    while(true){
	            
	            driver.findElement(By.cssSelector("a")).click(); //click on repaint box 2
	            driver.switchTo().frame("child"); //goto child frame for box2
	            String box2 = driver.findElement(By.id("answer")).getAttribute("class");// get second box color
	            driver.switchTo().parentFrame(); //go back to parent form for repainting box
	            if(box1.equals(box2))
	            {
	                driver.findElements(By.cssSelector("a")).get(1).click(); //clicking on proceed
	                break;
	            }
	        }
	    
	    //For third problem
	    
	    WebElement to=driver.findElement(By.id("dropbox"));
	    WebElement from=driver.findElement(By.id("dragbox"));
	    Actions action1=new Actions(driver);
	    action1.dragAndDrop(from,to).build().perform();
	    driver.findElement(By.cssSelector("a")).click();
	    
	    //For fourth problem
	    
	    String mainWindowHandler = driver.getWindowHandle(); // Store your parent window

	    driver.findElement(By.cssSelector("a")).click(); //click on popup window
	    String childWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    System.out.println(handles);
	    
	    Iterator<String> iterator = handles.iterator(); //creating iterator to get popup window
	    while (iterator.hasNext()){
	    childWindowHandler = iterator.next();
	    }
	    driver.switchTo().window(childWindowHandler); // switch to popup window
	    driver.findElement(By.id("name")).sendKeys("akshat");// writing in area
	    driver.findElement(By.id("submit")).click();// clicking on submit

	    driver.switchTo().window(mainWindowHandler);  // switch back to parent window
	    driver.findElements(By.cssSelector("a")).get(1).click(); //click on proceed
	    
	    //For fifth problem
	    
	    /*int n=1;
	    while(n>0)
	    {
	        try {
	            driver.findElement(By.cssSelector("a")).click(); //click on generate token
	            String value = driver.findElement(By.id("token")).getText().split("Token: ")[1];// get token value
	            n=0; // break the loop
	         } catch (Exception e) {
	            System.out.println(e);
	            driver.navigate().refresh(); //refresh page if generate token does not give result
	         }
	    }*/
	    
	    String value = driver.findElement(By.id("token")).getText().split("Token: ")[1];//get token value
	    driver.manage().addCookie( new Cookie("Token", value, "/")); //add cookie
	    driver.findElements(By.cssSelector("a")).get(1).click(); //click on proceed

	  


	    
	    
	    
	    
	    /*driver.findElement(By.linkText("Generate Token"));
	    String cookievalue=driver.findElement(By.id("token")).getText();
	    driver.manage().addCookie(new Cookie("Token",cookievalue));
	    driver.findElement(By.linkText("Proceed")); */
 	}
}