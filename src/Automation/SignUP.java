package Automation;

import java.awt.Window;
import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUP {	  
	WebDriver driver=new ChromeDriver() ;
	String url="https://automationexercise.com/";
	String[] fname = {"Liam","Olivia","Noah","Emma","Aiden","Ava","Lucas","Sophia","Mason", "Isabella"};
	String[] Lname = {"Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson"};
	Random rand=new Random();   

@BeforeTest	
public void start() {	  
	driver.get(url);
	driver.manage().window().maximize();

	
}
	
	
	
	
  @Test(invocationCount = 20)
  public void Regestration() throws InterruptedException {
	  
	  int randomname=rand.nextInt(10);
	  
	  driver.findElement(By.xpath("//a[@href='/login']")).click();
	  
	  driver.findElement(By.name("name")).sendKeys(fname[randomname]);
	  
	  int randomnumber=rand.nextInt(23134)+1;
	  
	  String email=fname[randomname]+Lname[randomname]+randomnumber+"@gmail.com";
	  System.out.println(email);
	  
	  driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
	  
	  driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	  
	  driver.findElement(By.id("uniform-id_gender1")).click();
	  
	  String password=fname[randomname]+randomnumber+"#@";
	  driver.findElement(By.id("password")).sendKeys(password);
	  System.out.println(password);

	  
	  WebElement day=driver.findElement(By.id("days")); 
	  Select myselect=new Select(day);
	  myselect.selectByValue("26");
	  
	  
	  WebElement month=driver.findElement(By.id("months")); 
	  Select myselect2=new Select(month);
	  myselect2.selectByVisibleText("January");
	  
	  
	  WebElement year=driver.findElement(By.id("years")); 
	  Select myselect3=new Select(year);
	  myselect3.selectByVisibleText("2002");
	  
	  WebElement firstname=driver.findElement(By.id("first_name"));
	  firstname.sendKeys(fname[randomname]);
	  
	  WebElement lastname=driver.findElement(By.id("last_name"));
	  lastname.sendKeys(Lname[randomname]);
	  
	  WebElement address1=driver.findElement(By.id("address1"));
	  address1.sendKeys("Zarqa123");
	  
	  WebElement state=driver.findElement(By.id("state"));
	  state.sendKeys("Zarqa123");
	  
	  WebElement zipcode=driver.findElement(By.id("zipcode"));
	  zipcode.sendKeys("13511");
	  
	  WebElement phone=driver.findElement(By.id("mobile_number"));
	  phone.sendKeys("+962797615856");
	  
	  WebElement city=driver.findElement(By.id("city"));
	  city.sendKeys("zarqa");
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	//calling the method 
	js.executeScript("window.scrollTo(0,1800)");

	  
	  
	  Thread.sleep(1000); 
	  
	  WebElement submitbutton=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
	  submitbutton.click();
	  
	  
//	  driver.findElement(By.partialLinkText("Create Account")).click();
//	  Thread.sleep(2000); 
//
//	  
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath("//a[@href='/login']")).click();


	  driver.findElement(By.linkText("Logout")).click();
	  
	  
	  
	  
	  
	  
  }
}
