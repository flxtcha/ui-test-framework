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
        WebDriver webDriver = DriverFactory.create();
        THREAD_LOCAL.set(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(ConfigManager.get().getBaseUrl());
    }

    @After
    public void tearDown() {
        WebDriver d = THREAD_LOCAL.get();
        if (d != null) d.quit();
        THREAD_LOCAL.remove();
    }
}