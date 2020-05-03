package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends Page {

    private By accountDropdown = By.id("accountId");
    private By idField = By.id("criteria.transactionId");
    private By idButton = By.cssSelector("button[ng-click=\"criteria.searchType = 'ID'\"]");

    public FindTransactionsPage(WebDriver driver){
        super(driver);
    }

    public void selectAccountId(String id){
        Select dropdown = new Select(driver.findElement(accountDropdown));
        dropdown.selectByVisibleText(id);
    }

    public TransactionResultsPage searchByTransactionId(String accountId, String transactionId){
        selectAccountId(accountId);
        driver.findElement(idField).sendKeys(transactionId);
        driver.findElement(idButton).click();
        return new TransactionResultsPage(driver);
    }

}
