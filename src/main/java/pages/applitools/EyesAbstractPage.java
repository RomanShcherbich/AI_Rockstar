package pages.applitools;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

public class EyesAbstractPage extends AbstractPage {
    Eyes eyes;

    public EyesAbstractPage(Eyes eyes, WebDriver driver) {
        this.eyes = eyes;
        super.driver = driver;
    }

    public void checkWindow(String tag) {
        eyes.checkWindow(tag);
    }

    public void checkRegion(By by) {
        eyes.checkRegion(by);
    }

    public void clickButtonEyesCheck(By buttonElement, By buttonArea) {
        if (isElementDisplayed(buttonElement)) {
            clickButtonLog(buttonElement);
            checkRegion(buttonArea);
        } else {
            checkRegion(buttonArea);
        }
    }

    public void clickButtonEyesCheck(By buttonElement, String tag) {
        if (isElementDisplayed(buttonElement)) {
            clickButtonLog(buttonElement);
            checkWindow(tag);
        } else {
            checkWindow(tag);
        }
    }
}
