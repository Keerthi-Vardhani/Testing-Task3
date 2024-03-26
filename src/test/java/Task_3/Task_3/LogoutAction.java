package Task_3.Task_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutAction implements Runnable {
    private WebDriver driver;

    public LogoutAction(WebDriver driver) {
        this.driver = driver;
    }

    public void run() {
    	WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }
}

