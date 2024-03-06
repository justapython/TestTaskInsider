import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckContainsOfJobsList extends BasePage {
    By checkContaionsPageJobBoxes = By.xpath("//div[@class='position-list-item-wrapper bg-light']");
    By checkQualityAssurenceJobBox = By.xpath("(//span[text()='Quality Assurance'])[2]");

    public CheckContainsOfJobsList(WebDriver driver) {
        super(driver);
    }

    public void checkPositionContains() {

        checkElementVisible(checkContaionsPageJobBoxes);
        checkElementVisible(checkQualityAssurenceJobBox);

        List<WebElement> list = driver.findElements(checkContaionsPageJobBoxes);
        System.out.println("List size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            String positionText = driver.findElement(By.xpath("(//p[@class='position-title font-weight-bold'])[" + (i + 1) + "]")).getText();
            System.out.println((i + 1) + ".position= " + positionText);
            Assertions.assertTrue(positionText.contains("Quality Assurance"));
            String departmentText = driver.findElement(By.xpath("(//span[@class='position-department text-large font-weight-600 text-primary'])[" + (i + 1) + "]")).getText();
            System.out.println((i + 1) + ".department= " + departmentText);
            Assertions.assertTrue(departmentText.contains("Quality Assurance"));
            String locationText = driver.findElement(By.xpath("(//div[@class='position-location text-large'])[" + (i + 1) + "]")).getText();
            Assertions.assertTrue(locationText.contains("Istanbul, Turkey"));
            checkElementVisible(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[" + (i + 1) + "]"));
        }
    }
}



