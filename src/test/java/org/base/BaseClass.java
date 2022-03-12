package org.base;
import java.awt.Checkbox;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Alert;
public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		  return driver;
	}
	
	public static WebDriver browserLaunch(String browserName) {
	if (browserName.equals("Chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	return driver;}
	//1. Get Url
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		}
	//2.By Using Navigate().to()
	//public static void browserLaunch(String url) {
	//	driver.navigate().to(url);
	//	driver.manage().window().maximize();
	//	}
	//3. Implicitly Wait
	public static void implicitlyWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
	//4. Get Current Url
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		}
	//5.  Get Title
	public static String getTtile() {
		String title = driver.getTitle();
		return title;
		}
	//6. quit
	public static void quit() {
		driver.quit();
		}
	//7.Send Keys
	public static void sendKeys(WebElement e,String user) {
		e.sendKeys(user);
		}
	//8. Click
	public static void click(WebElement e) {
		e.click();
		}
	// 9. Get Text
	public static String gettext(WebElement e) {
		String text = e.getText();
		return text;
		}
	//10. Get Attribute
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("Value");
		return attribute;
		}
	//11. Find Element
	public static WebElement findElement(String locatorName,String locator) {
		WebElement e = null;
		if (locatorName.equals("id")) {
			e = driver.findElement(By.id(locator));}
		else if (locatorName.equals("name")) {
			e= driver.findElement(By.name(locator));}
		else if (locatorName.equals("xpath")) {
			e= driver.findElement(By.xpath(locator));}
		return e;
		}
	//12. Select By Index
	public static void selectByIndex(WebElement e,int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
		}
	// 13 .Select By Value
	public static void selectByvalue(WebElement e,String Value) {
		Select s = new Select(e);
		s.selectByValue(Value);
		}
	// 14. Select By Visible Text
	public static void selctByVisibleText(WebElement e,String text) {
		Select s = new Select(e);
		s.selectByVisibleText(text);
		}
	// 15. Get Options
	//public static void getoptions(WebElement e,String Value) {
	//	Select s = new Select(e);
	//	s.getoptions();}
	//16.DeSelct By Index
		public static void deselectByIndex(WebElement e,int index) {
		Select s = new Select(e);
		s.deselectByIndex(index);
		}
	//17.Deselct By Value
	public static void deselectByValue(WebElement e,String Value) {
		Select s = new Select(e);
	s.deselectByValue(Value);
	}
	//18..Deselct By Visible Text
		public static void deselectByVisibleText(WebElement e,String Value) {
			Select s = new Select(e);
		s.deselectByVisibleText(Value);
		}
	//19. Select of multiple Drop down
		public static boolean selectByMultipleOptions(WebElement e) {
			Select s = new Select(e);
			boolean m = s.isMultiple();
			return m;
			}
	//20.Deselect All
		public static void deselectAll(WebElement e) {
			Select s = new Select(e);
				s.deselectAll();
				}
	//21 Get all selected options
		public static WebElement selectalloptions(WebElement e,int index) {
			Select s = new Select(e);
			List<WebElement> options = s.getAllSelectedOptions();
			WebElement element = options.get(index);
			return element;
			}
	//22.Get First Selected option 
		public static WebElement getFirstSelectedOption(WebElement e ) {
			Select s = new Select(e);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			return firstSelectedOption;
			}
	//23. Select all by index
		public static void selectallByIndex(WebElement e,int index) {
			Select s = new Select(e);
			s.selectByIndex(index);
			}
	//24.Move To Element
		public static void moveToElement(WebElement e) {
			Actions a = new Actions(driver);
			a.moveToElement(e).perform();
			}
	//25. Drag and Drop
		public static void dragAndDrop(WebElement src,WebElement des) {
			Actions a = new Actions(driver);
			a.dragAndDrop(src, des).perform();
			}
	//26.Doluble Click
		public static void doubleClick(WebElement e) {
			Actions a = new Actions(driver);
			a.doubleClick(e).perform();
			}
	// 27. Context Click
		public static void contextClick(WebElement e) {
			Actions a = new Actions(driver);
			a.contextClick(e).perform();
			}
	//28. click and Hold and release	
		public static void clickAndHoldRelease(WebElement src,WebElement des) {
			Actions a = new Actions(driver);
			a.clickAndHold(src).release(des).perform();
			}
	// 29. click and Hold and Move to webElement and release
		public static void clickAndMovetoWebElementRelease(WebElement src,WebElement des) {
			Actions a = new Actions(driver);
			a.clickAndHold(src).moveToElement(des).release().perform();
			}
	//30. TakeScreenshot
//		public static TakesScreenShot takeScrenshot() {
//			TakesScreenShot tk = (TakesScreenShot).driver;
//			File screenshot = tk.getScreenshotAs(OutputType.FILE);
//			return tk;
//			}
	//31. JavaScriptExecutor using SetAttribute
		public static JavascriptExecutor scriptExecuter(String id,String user) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','id')", user);
			return js;
			}
	//32. Scroll Down
		public static JavascriptExecutor scrollDown(String id) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", id);
		return js;
		}
	//33. Scroll up
		public static JavascriptExecutor scrollUp(String id) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].ScrollIntoView(false)", id);
			return js;
			}
	//34. JavaScriptExecutor using getAttribute
		public static JavascriptExecutor executeScript(String user) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("returnarguments[0].getAttribute('value')", user);
			return js;
			}
	//35. frames Swith to index
		public static void switchToIndex(int index) {
			 driver.switchTo().frame(index);
			 }
	//36. frames Swith to id 
		public static void switchToId(int id) {
			driver.switchTo().frame(id);
				}
	//37. frames Swith to name 
				public static void switchToName(String name) {
					 driver.switchTo().frame(name);
					 }
	//38. frames swith to webElement
				public static void switchToWebElement(WebElement e) {
				driver.switchTo().frame(e);
				}
	//39. Switch to frame
				public static void switchToFrame(String name) {
					 driver.switchTo().frame(name);
					 }
	//40. isDisplayed
				public static boolean isDisplyed(WebElement e) {
					boolean displayed = e.isDisplayed();
					return displayed;
					}
	//41. 	isSelected
				public static boolean isSelected(WebElement e) {
					boolean selected = e.isSelected();
					return selected;
					}
	//42. isEnabled
				public static boolean isEnabled(WebElement e) {
					boolean enabled = e.isEnabled();
					return enabled;
					}
	//43 .current Window ID
				public static String currentWindowId() {
					String windowHandle = driver.getWindowHandle();
					return windowHandle;
					}
		
				
				
				
				
				
				
				
				

}
