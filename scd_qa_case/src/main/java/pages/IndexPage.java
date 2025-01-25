package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {
    private By companyMenu = By.linkText("Company");
    private By careersLink = By.linkText("Careers");

    public IndexPage(WebDriver driver) {
        super(driver);
    }


    public void openCareersPage() {
        clickElement(companyMenu);
        clickElement(careersLink);
    }

    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("Insider");
    }
}