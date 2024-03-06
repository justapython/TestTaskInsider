import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Check_Insider_Apply extends BaseTest {


    HomePage homePage;
    CareersPage careersPage;
    FilterJobList filterJobList;
    CheckContainsOfJobsList checkContainsOfJobsList;
    CheckLeverApplicationPage checkLeverApplicationPage;

    @Test
    @Order(1)
    public void checkHomePage() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.isUrlEqual("https://useinsider.com/");
        homePage.isOnHomePage();
    }

    @Test
    @Order(2)
    public void checkCareersPage() throws InterruptedException {
        careersPage = new CareersPage(driver);
        careersPage.goToCareersPage();
        careersPage.checkLocationBlock();
        careersPage.checkLifeAtInsiderBlock();
        careersPage.checkTeamsBlock();
    }

    @Test
    @Order(3)
    public void filterJobList() throws InterruptedException {
        filterJobList = new FilterJobList(driver);
        filterJobList.goToQualityAssurenceJobs();
        filterJobList.seeAllQAJobs();
        filterJobList.filterJobs();
    }

    @Test
    @Order(4)
    public void checkContainsOfJobsList() {
        checkContainsOfJobsList = new CheckContainsOfJobsList(driver);
        checkContainsOfJobsList.checkPositionContains();
    }

    @Test
    @Order(5)
    public void checkLeverApplicationPage() {
        checkLeverApplicationPage = new CheckLeverApplicationPage(driver);
        checkLeverApplicationPage.goToLeverApplicationFormPage();
        checkLeverApplicationPage.checkIsRedirectSuccess();
    }


}
