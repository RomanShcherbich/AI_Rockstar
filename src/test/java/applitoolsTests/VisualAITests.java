package applitoolsTests;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.applitools.EyesLoginPage;
import pages.applitools.EyesSecuredPage;

@FixMethodOrder
public class VisualAITests extends EyesBase {

    private EyesLoginPage login() {
        return new EyesLoginPage(eyes, driver);
    }

    @Test
    public void LoginPageUiElementsTest(){
        login().checkLoginPage();
    }

    @Test
    public void DataDrivenTests_No_Password() {
        login().clickLogin("validUser", null, "Password must be present");
    }
    @Test
    public void DataDrivenTests_No_Username() {
        login().clickLogin(null, "validPass", "Username must be present");
    }
    @Test
    public void DataDrivenTests_No_Credentials() {
        login().clickLogin(null, null, "Both Username and Password must be present");
    }
    @Test
    public void DataDrivenTests_Valid_Credentials() {
        login().clickLogin("validUser", "validPass", null);
    }

    @Test
    public void t3_AmountOrderTest() {
        EyesSecuredPage securedPage = login().clickLogin("validUser", "validPass", null);
        List<List<String>> beforeAfterSorting = securedPage.eyesCheckSortingByAmount();
        Assert.assertArrayEquals(beforeAfterSorting.get(0).toArray(),
                beforeAfterSorting.get(1).toArray());
    }
}
