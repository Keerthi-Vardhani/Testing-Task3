package Task_3.Task_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest extends TestCase
{
@Test
public void runTest() {
    WebDriver driver;
	System.setProperty("webdriver.chrome.driver","C:/Users/Keerthi Vardhani/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
	  driver= new ChromeDriver();					
	  driver.manage().window().maximize();	

    try {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\Keerthi Vardhani\\eclipse-workspace\\Task-3\\utils\\MOCK_DATA.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getLastRowNum();
        for (int i = 1; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            // Create login action for each user
            LoginAction loginAction = new LoginAction(driver, username, password);

            // Execute login action in a separate thread
            Thread loginThread = new Thread(loginAction);
            loginThread.start();

            // Wait for login action to complete
            loginThread.join();

            // Perform other test steps

            // Create logout action for each user
            LogoutAction logoutAction = new LogoutAction(driver);

            // Execute logout action in a separate thread
            Thread logoutThread = new Thread(logoutAction);
            logoutThread.start();

            // Wait for logout action to complete
            logoutThread.join();
        }

        workbook.close();
        file.close();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    } finally {
        // Quit the driver
        driver.quit();
    }
    }
}
