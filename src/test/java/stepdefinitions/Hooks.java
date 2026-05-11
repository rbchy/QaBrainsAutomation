package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BaseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        // ১. ড্রাইভার ইনিশিয়ালাইজ করা
        WebDriver currentDriver = initDriver(); 
        
        // ২. URL লোড করা (Null চেকসহ)
        String url = config.getProperty("url");
        if (url != null) {
            currentDriver.get(url);
        } else {
            throw new RuntimeException("❌ URL not found in config.properties!");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // ৩. সিনারিও ফেইল করলে স্ক্রিনশট নেওয়া
        if (scenario.isFailed() && driver != null) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                System.out.println("📸 Screenshot captured for failed scenario: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("❌ Failed to take screenshot: " + e.getMessage());
            }
        }
        
        // ৪. ড্রাইভার বন্ধ করা
        quitDriver();
    }
}