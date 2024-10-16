import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchTab_windows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
//		Switch windows/tab
		driver.switchTo().newWindow(WindowType.TAB);
//		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> w=driver.getWindowHandles();
		Iterator<String> it=w.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		List<WebElement> link=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		String name=link.get(1).getText();
		System.out.println(name);
		driver.switchTo().window(parentWindow);
		WebElement e=driver.findElement(By.cssSelector("input[name='name']"));
		e.sendKeys(name);
		
//		Screenshot
		File file=e.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
//		Dimensions
		System.out.println(e.getRect().getDimension().getHeight());
		System.out.println(e.getRect().getDimension().getWidth());
		
		driver.quit();
		

	}

}
