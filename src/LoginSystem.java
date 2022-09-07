import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSystem {
	
	public void fblogin() throws InterruptedException{	
		System.setProperty("webdriver.chrome.driver", "F:\\Work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.facebook.com");
		driver.manage().deleteAllCookies();
		
		String urlFromWebpage=driver.getCurrentUrl();
		if (urlFromWebpage.equals("https://www.facebook.com/")) {
			System.out.println("CURRENT URL PASSED");			
		} else {
			System.out.println("CURRENT URL FAILED");	
		}
		
		String checkTitle=driver.getTitle();
		if (checkTitle.equals("Facebook – log in or sign up")) {
			System.out.println("TITLE PASSED");			
		} else {
			System.out.println("TITLE FAILED");
		}
		//System.out.println(driver.getPageSource())
		
		////tagname[@attribute='value'] -xpath 
		
		/*driver.findElement(By.xpath("//input[@name='email']")).sendKeys("null");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("null");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='pam _3-95 _9ay3 uiBoxRed']")).getText());*/  
		
		////tagname[attribute='value'] -cssselector syntax
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("demo");	//Enter your username	
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("demo"); //Enter your password
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		WebElement textFromWebpage=driver.findElement(By.xpath("//*[@class='duz7z0vm gl8l4oiz i6mu40yr']"));
		if (textFromWebpage.isDisplayed()) {
			System.out.println("LOGIN PASSED");		
		} 
		else {
			System.out.println("LOGIN FAILED");
		}
		Thread.sleep(5000);
		driver.close();			
	}
}
