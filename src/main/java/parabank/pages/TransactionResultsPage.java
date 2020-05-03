package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionResultsPage extends Page{

    private By tableCells = By.cssSelector("#transactionTable tr td");

    public TransactionResultsPage(WebDriver driver){
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableCells));
    }

    public List<String> getTransactionResults() {
        return driver.findElements(tableCells)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
