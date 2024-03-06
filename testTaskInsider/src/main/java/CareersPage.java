import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    By homePageMoreDropBox = By.xpath("//span[text()='More']");
    By homePageCareerButton = By.xpath("(//a[@class='d-flex flex-column flex-fill'])[12]");
    By careerPageSeeAllTeamsButton = By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore");
    By careerPageCustomerSuccessText = By.xpath("//h3[text()='Customer Success']");
    By careerPageOurLocationsLeftScrollButton = By.cssSelector(".icon-arrow-left.location-slider-prev.mr-4.text-xsmall.text-dark");
    By careerPageNewYorkImage = By.xpath("//img[@alt='New York']");
    By careerPageLifeAtInsiderText = By.xpath("//h2[text()='Life at Insider']");
    By careerPageLifeAtInsiderBlock = By.xpath("//div[@data-id='c06d1ec']");


    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void goToCareersPage(){
        checkElementClickableThenClick(homePageMoreDropBox);
        checkElementClickableThenClick(homePageCareerButton);
    }

    public void checkLocationBlock() throws InterruptedException{
        scrollElementWithJs(careerPageOurLocationsLeftScrollButton);
        checkElementVisible(careerPageNewYorkImage);
    }

    public void checkLifeAtInsiderBlock() throws  InterruptedException{
        scrollElementWithJs(careerPageLifeAtInsiderText);
        checkElementVisible(careerPageLifeAtInsiderBlock);
    }

    public void checkTeamsBlock() throws InterruptedException{
        checkElementVisible(careerPageSeeAllTeamsButton);
        scrollElementWithJs(careerPageCustomerSuccessText);
        click(careerPageSeeAllTeamsButton);
        checkElementInVisible(careerPageSeeAllTeamsButton);
    }
}
