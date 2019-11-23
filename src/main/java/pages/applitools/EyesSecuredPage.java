package pages.applitools;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EyesSecuredPage extends EyesAbstractPage {

    public EyesSecuredPage(Eyes eyes, WebDriver driver) {
        super(eyes, driver);
    }

    public List<List<String>> eyesCheckSortingByAmount() {
        List<WebElement> rowsElementsBefore = driver.findElements(byRows);
        clickButton(byColumnAmount);

        List<WebElement> rowsElementsAfter = driver.findElements(byRows);

        sortByAmount(rowsElementsBefore).forEach(el -> checkElement(el));

        List<String> beforeOrdering = rowValuesToString(sortByAmount(rowsElementsBefore));
        List<String> afterOrdering = rowValuesToString(rowsElementsAfter.stream());

        List<List<String>> result = new ArrayList<>();
        result.add(beforeOrdering);
        result.add(afterOrdering);
        return result;
    }

    private List<String> rowValuesToString(Stream<WebElement> stream) {
        return stream
                .map(el -> el.findElements(byText)
                        .stream()
                        .map(el2 -> el2.getText())
                        .collect(Collectors.joining())
                )
                .collect(Collectors.toList());
    }

    private Stream<WebElement> sortByAmount(List<WebElement> webElements) {
        return webElements.stream()
                .sorted(
                        (e1, e2) -> {
                            Double n1 = getStringToAmount(e1.findElement(byAmountValue).getText());
                            Double n2 = getStringToAmount(e2.findElement(byAmountValue).getText());

                            if (n1 <= n2) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                );
    }

    public Double getStringToAmount(String amount) {
        return Double.valueOf(amount
                .replace(" ", "").replace(",", "").replace("+", "")
                .substring(0, amount.indexOf("USD") - 4));
    }
}
