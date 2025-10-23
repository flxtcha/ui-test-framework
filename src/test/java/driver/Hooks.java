package driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }

    @Before
    public void setUp() {
        THREAD_LOCAL.set(DriverFactory.create());
        WebDriver webDriver = getDriver();
        webDriver.manage().window().maximize();
        webDriver.get(ConfigManager.get().getBaseUrl());
    }

    @After
    public void tearDown() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) webDriver.quit();
        THREAD_LOCAL.remove();
    }
}