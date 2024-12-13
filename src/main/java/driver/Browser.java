package driver;

public class Browser {
    public static String getDriverType() {
        String driverType = System.getProperty("Browser");
        if (driverType.contains("FIREFOX")) {
            return "FIREFOX";
        } else if (driverType.contains("EDGE")) {
            return "EDGE";
        } else if (driverType.contains("CHROME")) {
            return "CHROME";
        } else {
            return "Unknown";
        }
    }
}

