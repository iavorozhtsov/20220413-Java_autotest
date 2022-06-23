package IAV.HomeWork_07;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyUtilities {

    public static File makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destination;
    }
}
