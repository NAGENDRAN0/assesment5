package week5.day4;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mergeContacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge Contacts")).click();
        //fromcontact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'][1]")).click();
		String window1 = driver.getWindowHandle();
		Set<String> fromcontact = driver.getWindowHandles();
		for(String i:fromcontact) {
			if(!window1.equals(i));
			driver.switchTo().window(i);
			
			
		}
		WebElement tabl= driver.findElement(By.id("ext-gen156"));
		 List<WebElement>tab= tabl.findElements(By.tagName("tr"));
		WebElement txt = tab.get(4);
		WebElement str = txt.findElement(By.xpath("(//a[text()='DemoCustomer'])"));
		System.out.println(str.getText());
		str.click();
		driver.switchTo().window(window1);
		System.out.println(driver.getCurrentUrl());
		
		
		//tocontact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> tocontact = driver.getWindowHandles();
		for (String i : tocontact) {
			if(!tocontact .equals(i));
			driver.switchTo().window(i);
			
				
			
		}
		WebElement totab = driver.findElement(By.id("ext-gen246"));
		List<WebElement> to = totab.findElements(By.tagName("tr"));
		
		WebElement tx = to.get(2);
		WebElement strr = tx.findElement(By.xpath("//a[text()='DemoLBCust']"));
		System.out.println(strr.getText());
		driver.switchTo().window(window1);
		Alert alt=driver.switchTo().alert();
		Thread.sleep(5000);
		alt.accept();
		Thread.sleep(5000);
		driver.close();
		
		

	}

}
