package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    private By locationsBlock = By.xpath("//h3[contains(.,'Our Locations')]");
    private By teamsBlock = By.xpath("//*[@id=\"career-find-our-calling\"]/div/div/div[1]/h3");
    private By lifeAtInsiderBlock = By.xpath("//section[4]/div/div/div");


    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLocationsBlockVisible() {
        waitForVisibility(locationsBlock);
        return driver.findElement(locationsBlock).isDisplayed();
    }

    public boolean isTeamsBlockVisible() {
        waitForVisibility(teamsBlock);
        return driver.findElement(teamsBlock).isDisplayed();
    }

    public boolean isLifeAtInsiderBlockVisible() {
        waitForVisibility(lifeAtInsiderBlock);
        return driver.findElement(lifeAtInsiderBlock).isDisplayed();
    }


}