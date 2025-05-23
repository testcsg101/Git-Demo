package utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
        	Object currentClass = result.getInstance();
        	WebDriver driver = ((BaseTest) currentClass).getDriver();
             //BaseTest.driver = ((BaseTest) currentClass).getDriver();
            ScreenshotUtil.captureScreenshot(driver, result.getName());
            System.out.println("❌ Test Failed: " + result.getName());
        } catch (Exception e) {
            System.out.println("⚠️ Failed to capture screenshot: " + e.getMessage());
        }
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🔄 Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("✅ Test Suite Finished: " + context.getName());
    }

    // Other methods can be overridden if needed (onTestSkipped, etc.)
}
