package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            synchronized (WebDriverSingleton.class) {
                if (instance == null) {
                    System.out.println("New session");
                    instance = new ChromeDriver();
                }
            }
        }
        return instance;
    }

    public static void quitDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
