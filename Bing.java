package com.qait.maven.bingTranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Bing {
	String inserted;

	WebDriver driver;
	JavascriptExecutor js;
	public Bing() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Vibhushrivastav\\\\eclipse-workspace\\\\training\\\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) this.driver;
	}
	public void launchBrowser() {


		driver.get("https://www.bing.com/translator");
		driver.manage().window().maximize();
	}
	public void searchBox() throws InterruptedException {
		js.executeScript("document.getElementById('sb_form_q').value = 'Vibhu'");
		js.executeScript("document.getElementById('search-button').click();");
		driver.switchTo().window("");

	}

	public void drop_down1() throws InterruptedException {

		Select drpDwn=new Select(driver.findElement(By.id("t_sl")));
		drpDwn.selectByVisibleText("French");
		Thread.sleep(5000);
		driver.findElement(By.id("t_sl")).click(); 
	}

	public void set_text() throws NullPointerException {

		inserted = "Ma Erreur";
		driver.findElement(By.id("t_sv")).sendKeys(inserted);
	}
	public void interchange() {
		driver.findElement(By.xpath("//*[@id=\"t_revIcon\"]")).click();
	}
	public void shareIcon() {
		driver.findElement(By.cssSelector("span[class=\"actionmenu\"]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("div[class=\"sharemedia\"]>a[class=\"b_accentColor\"]>div[class=\"actIconSvg actFacebookSvgIcon\"]")).click();
		String parentWindow = driver.getWindowHandle(); 
		String childWindow = null;
		java.util.Set<String> windows = driver.getWindowHandles();
		String MainWindow = driver.getWindowHandle();
		driver.switchTo().window(MainWindow);
	}
	public void charCount() {
		/*String displayed = driver.findElement(By.linkText("div[class=\"t_inputoptions\"]>div[id]")).getText();*/
		WebElement charLimit=driver.findElement(By.cssSelector("div[id='t_charcount']"));
		String displayed=charLimit.getText();
		int slashIndex=displayed.indexOf("/");
		int maxLimit= Integer.parseInt(displayed.substring(slashIndex+1));
		
		System.out.println(displayed);
		if(displayed.length() == inserted.length()) {
			System.out.println("succes");
		}

	}

}

