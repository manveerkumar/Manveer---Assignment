package com.trello.assignment.tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCoordinatesTask {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://trello.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user")).sendKeys("imanveer.00017@gmail.com");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(3000);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("Trll@M17##");
		
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Trll@M17##");
//		waitToSendKeys(driver, 10, pass, "Trll@M17##");
		
		
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		driver.findElement(By.xpath("//*[text()='Create new board']")).click();
		
		driver.findElement(By.xpath("//*[@data-test-id = 'create-board-title-input']")).sendKeys("Full_Assignment 1");
		
//		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		WebElement elem1 = driver.findElement(By.xpath("//*[@data-test-id='create-board-submit-button']"));
//		actions.moveToElement(elem1);
		elem1.click();
		
		
		String ListTitleA="List A";
		String ListTitleB="List B";
		
		
		driver.findElement(By.xpath("//*[text()='Add another list']")).click();
		
		
		
		driver.findElement(By.className("list-name-input")).sendKeys(ListTitleA);
		driver.findElement(By.xpath("//*[@value='Add list']")).click();
		driver.findElement(By.className("list-name-input")).sendKeys(ListTitleB);
		driver.findElement(By.xpath("//*[@value='Add list']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"board\"]/div[5]/div/div[3]/a/span[2]")).click();
		
		
		String TitleofCard = "TestTitle A";
		driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']")).sendKeys(TitleofCard);
		driver.findElement(By.xpath("//*[@value='Add card']")).click();
		
		
		WebElement elem2 = driver.findElement(By.xpath("//*[text()='"+TitleofCard+"']"));
		WebElement elem3 = driver.findElement(By.xpath("//*[text()='"+ListTitleA+"']//parent::div"));
		
		actions.dragAndDrop(elem2, elem3).build().perform();
		
		WebElement elem4 = driver.findElement(By.xpath("//*[text()='"+TitleofCard+"']"));
		Point Locpoint = elem4.getLocation();
		System.out.println("X coordinate: "+Locpoint.getX());
		System.out.println("Y coordinate: "+Locpoint.getY());
			
		
		
		driver.findElement(By.xpath("//button[@title='Manveer Kumar (imanveer00017)']")).click();
		driver.findElement(By.xpath("//*[text()='Log out']")).click();
		
		
		
	}
	
public static void waitToClick(WebDriver driver, int timeOut, WebElement elemToWait) {
		
		WebDriverWait waitExplicitely1 = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		waitExplicitely1.until(ExpectedConditions.elementToBeClickable(elemToWait)).click();
		
	}
	
	public static void waitToSendKeys(WebDriver driver, int timeOut, WebElement elemToWait, String Value) {
		
		WebDriverWait waitExplicitely2 = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		waitExplicitely2.until(ExpectedConditions.elementToBeClickable(elemToWait)).sendKeys(Value);;
		
	}
	
	

}
