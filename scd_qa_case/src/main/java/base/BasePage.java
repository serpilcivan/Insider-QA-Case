package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }

    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void scroll(int lenght){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+lenght+")");
    }

    protected List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected By setLocatorParameters (By by,String name) {
        String test = by.toString().replace("By.xpath: ","");
        test = test.replace("{1}",name);
        return new By.ByXPath(test);
    }

    public void switchBrowserTab(){
        Set<String> windows = driver.getWindowHandles(); //[parentWindowID, childWindowID, subChildWindowId, ...]
        Iterator<String> iter = windows.iterator();
        String parentID = iter.next();
        String childID = iter.next();
        driver.switchTo().window(childID);
    }

    public void hoverAndClick(WebDriver driver, By elementToHover, By elementToClick) {

        WebElement hoverElement = driver.findElement(elementToHover);


        Actions actions = new Actions(driver);


        actions.moveToElement(hoverElement).perform();


        waitForVisibility(elementToClick);


        WebElement clickElement = driver.findElement(elementToClick);
        clickElement.click();
    }
}