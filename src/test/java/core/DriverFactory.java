package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import setup.Properties;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private final static ResourceBundle runTimeConfig = ResourceBundle.getBundle("runtime");
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    //Construtor feito privado para não estar acessível para nenhuma outra classe instanciar
    private DriverFactory(){}

    //Método Estático para retornar a instância única do Objeto Singleton (Equivalente a uma getInstance())
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    //Inicializar propriedades do Objeto Singleton Webdriver
    public static WebDriver initDriver(){
        WebDriver navegador = null;
        switch (Properties.BROWSER) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", runTimeConfig.getString("driver.browser.firefoxPath"));
                navegador = new FirefoxDriver();
                break;
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-translate");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                if(runTimeConfig.getString("driver.chrome.headless").equals("true")){
                    options.addArguments("--headless");
                }
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                System.setProperty("webdriver.chrome.driver", runTimeConfig.getString("driver.browser.chromePath"));
                navegador = new ChromeDriver(options);
                break;
        }
        return navegador;
    }

    public static void killDriver(){
        WebDriver navegador = getDriver();
        if(navegador != null) {
            navegador.quit();
            navegador = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }
}