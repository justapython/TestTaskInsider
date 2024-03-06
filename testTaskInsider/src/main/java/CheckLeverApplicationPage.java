import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckLeverApplicationPage extends BasePage{

    By jobPageApplyNowButton = By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]");
    By jobDetailPageApplyButton = By.xpath("(//a[text()='Apply for this job'])[1]");
    public CheckLeverApplicationPage(WebDriver driver) {
        super(driver);
    }

    public void goToLeverApplicationFormPage(){
        hoverElementAction(jobPageApplyNowButton);
        checkElementClickableThenClick(jobPageApplyNowButton);
    }

    public void checkIsRedirectSuccess(){
        switchTab(1);
        checkElementClickable(jobDetailPageApplyButton);
    }

}
