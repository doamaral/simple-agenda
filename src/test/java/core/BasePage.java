package core;

import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Properties;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import static core.DriverFactory.getDriver;

@Log4j
@Getter
public abstract class BasePage {
    protected final static ResourceBundle envConfig = ResourceBundle.getBundle(Properties.environment.getFileProperties());
    protected final static ResourceBundle runTimeConfig = ResourceBundle.getBundle("runtime");

    protected WebDriverWait waitForElement = new WebDriverWait(getDriver(), Long.parseLong(runTimeConfig.getString("selenium.longWait")));
    protected WebDriverWait shortWaitForElement = new WebDriverWait(getDriver(), Long.parseLong(runTimeConfig.getString("selenium.shortWait")));


    @FindBy(how = How.CSS, using = "")
    protected WebElement elementoDaPagina;


    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public static void takeSnapShot(String nomeDoArquivoImagem){
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) getDriver());

        // Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // imageFileDir = System.getProperty("java.io.tmpdir");
        String imageFileDir = "C://Users//doamaral//evidencias//";
        try {
            FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}