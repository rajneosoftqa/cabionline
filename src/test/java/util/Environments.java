package util;

import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

/**
 * Created by titudatta on 5/13/16.
 */
public class Environments {

    public WebDriver driver;

    public Environments() {

        driver = Hooks.driver;


        String Env = System.getProperty("ENV");

        if (Env == null) {
            Env = "qa";
        }
        System.out.println("The test is running on " + Env.toUpperCase() + " environment");
        switch (Env.toLowerCase()) {

            case "dev":
            case "development":
                driver.get("https://exigerdevoms.claritycon.com/");
                break;

            case "qa":
                driver.get("https://diligenceqa.exiger.com/Auth/Login");
                break;

            case "prod":
                driver.get("http://diligence.exiger.com");
                break;

            case "production":
                driver.get("https://diligence.exiger.com/Auth/Login");
                break;

            case "stage":
            case "staging":
                driver.get("https://diligencestaging.exiger.com/Auth/Login");
                break;
        }
    }
}
