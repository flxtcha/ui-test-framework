package driver;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public final class ConfigManager {

    private static final Config CONFIG = load();

    private static Config load() {
        try (InputStream in = ConfigManager.class.getResourceAsStream("/config.json")) {
            if (in == null) throw new IllegalStateException("config.json not found");
            return new ObjectMapper().readValue(in, Config.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.json", e);
        }
    }

    public static Config get() {
        return CONFIG;
    }
}