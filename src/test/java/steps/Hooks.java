package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import setup.Properties;

public class Hooks {
    @After
    public void tearDown() {
        if(Properties.FECHAR_BROWSER) DriverFactory.killDriver();
    }
}
