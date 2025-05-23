package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void initializeDriver() throws IOException {
        // Load browser property
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "/src/test/java/resources/GlobalData.properties");
        prop.load(fis);

        // Get browser from system property or fallback to config
        String browserName = System.getProperty("browser", prop.getProperty("browser")).toLowerCase();
        System.out.println("Running on browser: " + browserName);

        switch (browserName) {
            case "chrome":
            case "chrome-headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (browserName.contains("headless")) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1440,900");
                }
               // WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\manoj\\Documents\\chromedriver136.0.71\\chromedriver.exe");
            	//driver = new ChromeDriver();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
            	System.setProperty("webdriver.chrome.driver", "C:\\Users\\manoj\\Documents\\edgedriver_win64\\chromedriver.exe");
            	
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
       // if (driver != null) {
            driver.close();
        }
    //}

    public WebDriver getDriver() {
        return driver;
    }
}
