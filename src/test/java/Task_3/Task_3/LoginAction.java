package Task_3.Task_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAction implements Runnable {
    private WebDriver driver;
    private String username;
    private String password;

    public LoginAction(WebDriver driver, String username, String password) {
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    public void run() {
        // Perform login action
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
}
