package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobApplicationPage extends BasePage {


    public JobApplicationPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyLeverPageUrl(String leverUrl){
        return driver.getCurrentUrl().contains(leverUrl);
    }







}