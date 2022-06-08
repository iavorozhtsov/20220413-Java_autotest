package IAV.HomeWork_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static EventFiringWebDriver driver;

    @BeforeAll
    static void init() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new EventFiringWebDriver (new ChromeDriver(options));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo(){
        driver.get("https://www.livejournal.com/");
    }

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){
            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    try {
                        FileUtils.writeStringToFile(new File("./target/" + System.currentTimeMillis() + ".log"),logEntry.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
