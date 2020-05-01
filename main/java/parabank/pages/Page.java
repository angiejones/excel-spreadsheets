package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector(".login .button");

    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickMenuLink(String name){
        driver.findElement(By.linkText(name)).click();
    }
}
