package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class QAJobsPage extends BasePage {
    private By seeAllJobs = By.linkText("See all QA jobs");
    private By filterLocation = By.id("select2-filter-by-location-container");
    private By allOptions = By.cssSelector(".select2-results__option");
    private By locations = By.xpath("//li[contains(text(),'{1}')]");
    private By filterDepartment = By.xpath("//form[@id='top-filter-form']/div[2]/span/span/span/span");
    private By jobsList = By.cssSelector(".position-list-item");
    private  By departments = By.xpath("//li[contains(text(),'{1}')]");
    private By jobListingItems=By.cssSelector("\".position-list-item\"");
    private By jobPosition = By.xpath("//*[@id='jobs-list']/div[1]");

    private By viewRoleButton = By.xpath("//*[@id='jobs-list']/div[1]/div/a");





    protected WebDriverWait wait;

    public QAJobsPage(WebDriver driver) {
        super(driver);
    }

    public void seeJobs() throws InterruptedException {
        clickElement(seeAllJobs);
        Thread.sleep(10000);


    }
    public void filterLocation(String locationsName) throws InterruptedException {

        clickElement(filterLocation); //aç
        locations = setLocatorParameters(locations,locationsName);
        clickElement(locations);


    }

    public void filterDepartment(String departmentName) {
        clickElement(filterDepartment);
        departments = setLocatorParameters(departments,departmentName);

        clickElement(departments);
    }

    public boolean areJobsFilteredPresent() {

        getElements(jobListingItems);
        System.out.println("jobsList"+jobListingItems);
        //return jobListingItems!=null && !jobListingItems.isEmpty();
        return false;
    }
    public boolean verifyJobListingResults(String location, String department){
        List<WebElement> jobs = getElements(jobsList);
        System.out.println("jobsList"+jobsList);
        for (WebElement job : jobs) {
            String jobText = job.getText();
            if (!jobText.contains(location) || !jobText.contains(department)) {
                return false;
            }
        }
        return true;
    }


    public void viewFirstJob() throws InterruptedException {

        scroll(600);
        Thread.sleep(2000);
        hoverAndClick(driver, jobPosition,viewRoleButton);
        switchBrowserTab();
    }

}