import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterJobList extends BasePage {

    By careerPageQualityAssuranceText = By.xpath("//h3[text()='Quality Assurance']");
    By qaPageSeeAllQAJobsButton = By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50");
    By filterPageLocationSelection = By.xpath("//select[@name='filter-by-location']");
    By filterPageLocationSelectBox = By.id("select2-filter-by-location-container");
    By filterPageIstanbulLocationText = By.xpath("//select[@name='filter-by-location']/option[@data-select2-id='12']");
    By filterPageBrowseOpenPositionsText = By.xpath("//h3[@class='mb-0']");
    By filterPageLoadingCheckQualityAssuranceText = By.xpath("//span[@title='Quality Assurance']");
    By filterPageLocationCheckText = By.xpath("//span[@title='Istanbul, Turkey']");

    public FilterJobList(WebDriver driver) {
        super(driver);
    }

    public void goToQualityAssurenceJobs() throws InterruptedException {
        checkElementVisible(careerPageQualityAssuranceText);
        scrollElementWithJs(careerPageQualityAssuranceText);
        checkElementClickableThenClick(careerPageQualityAssuranceText);
    }

    public void seeAllQAJobs() {
        checkElementVisible(qaPageSeeAllQAJobsButton);
        checkElementClickableThenClick(qaPageSeeAllQAJobsButton);
    }

    public void filterJobs() throws InterruptedException {
        scrollElementWithJs(filterPageBrowseOpenPositionsText);
        checkElementVisible(filterPageLoadingCheckQualityAssuranceText);
        checkElementVisible(filterPageLocationSelection);
        checkElementClickableThenClick(filterPageLocationSelectBox);
        checkElementVisible(filterPageIstanbulLocationText);
        checkElementClickableThenClick(filterPageIstanbulLocationText);
        checkElementClickableThenClick(filterPageLocationSelectBox);
        checkElementVisible(filterPageLocationCheckText);
    }
}
