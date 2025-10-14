package driver;

import lombok.Getter;

@Getter
public class Config {
    private String browser;
    private boolean headless;
    private String baseUrl;
}