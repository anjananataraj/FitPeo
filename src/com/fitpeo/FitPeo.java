package com.fitpeo;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fitpeo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement RevenueCal = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		RevenueCal.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 2000);");   		
		WebElement ScrollintoView = driver.findElement(By.xpath("//div[@class='MuiBox-root css-19zjbfs']"));
		jse.executeScript("arguments[0].scrollIntoView();",ScrollintoView);
		Actions act = new Actions(driver);
		WebElement slider820 = driver.findElement(By.xpath("//input[@data-index='0']"));
		Thread.sleep(2000);
        act.clickAndHold(slider820).moveToElement(slider820, 92, 0).release().perform();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_LEFT);
        r.keyPress(KeyEvent.VK_LEFT);
		WebElement textbox = driver.findElement(By.xpath("//input[@type='number']"));
		textbox.clear();
		textbox.sendKeys(Keys.NUMPAD5);
		WebElement ChckBox091 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));
		ChckBox091.click();
		WebElement ChckBox53 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
		ChckBox53.click();
		WebElement ChckBox54 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
		ChckBox54.click();
		WebElement ChckBox74 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));
		ChckBox74.click();
		String validation = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")).getText();
		System.out.println(validation);
		driver.quit();
	}

}
