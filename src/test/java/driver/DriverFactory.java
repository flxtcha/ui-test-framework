package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static driver.BrowserType.valueOf;
import static java.lang.System.getenv;

public class DriverFactory {

    public static WebDriver create() {
        Config config = ConfigManager.get();
        BrowserType browser = getenv("BROWSER") == null
                ? valueOf(config.getBrowser().trim().toUpperCase())
                : valueOf(getenv("BROWSER").trim().toUpperCase());

        return switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                if (config.isHeadless()) options.addArguments("--headless=new");
                yield new ChromeDriver(options);
            }
            case FIREFOX -> {
                FirefoxOptions options = new FirefoxOptions();
                if (config.isHeadless()) options.addArguments("-headless");
                yield new FirefoxDriver(options);
            }
            case EDGE -> {
                EdgeOptions options = new EdgeOptions();
                if (config.isHeadless()) options.addArguments("--headless=new");
                yield new EdgeDriver(options);
            }
        };
    }
}