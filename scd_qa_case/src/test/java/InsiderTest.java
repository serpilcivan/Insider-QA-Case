import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CareersPage;
import pages.IndexPage;
import pages.JobApplicationPage;
import pages.QAJobsPage;

public class InsiderTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/master/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://useinsider.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        // Step 1: Verify Home Page
        IndexPage indexPage = new IndexPage(driver);
        assert indexPage.isHomePageLoaded();

        // Step 2: Navigate to Careers Page
        indexPage.openCareersPage();
        CareersPage careersPage = new CareersPage(driver);
        assert careersPage.isLocationsBlockVisible();
        assert careersPage.isTeamsBlockVisible();
        assert careersPage.isLifeAtInsiderBlockVisible();

        // Step 3: Navigate to QA Jobs and Filter
        driver.get("https://useinsider.com/careers/quality-assurance/");
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.seeJobs();

        qaJobsPage.filterDepartment("Quality Assurance");
        qaJobsPage.filterLocation("Istanbul, Turkey");
        assert qaJobsPage.areJobsFilteredPresent();
        assert qaJobsPage.verifyJobListingResults("Istanbul, Turkey", "Quality Assurance");

        // Step 4: Verify Job Details and Redirect
        qaJobsPage.viewFirstJob();

        JobApplicationPage jobApplicationPage= new JobApplicationPage(driver);
        jobApplicationPage.verifyLeverPageUrl("jobs.lever.co");



        // Close the browser
        driver.close();
        driver.quit();


    }
}


