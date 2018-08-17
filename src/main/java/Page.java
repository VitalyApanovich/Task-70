import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Page {

    private final String TITLE;
    WebDriver driver;

    Page(String title) {
        TITLE = title;
        driver = Driver.getDriver().get();
    }

    public boolean isDisplayed() {
        return driver.getTitle().contains(TITLE);
    }

    public void makeScreenShot(String fileName) {
        String s = Paths.get("").toAbsolutePath().toString();
        File screenFile = ((TakesScreenshot) Driver.getDriver().get()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenFile, new File(s + "\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
