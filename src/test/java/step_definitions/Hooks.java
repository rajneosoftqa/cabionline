package step_definitions;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.Browsers;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

public class Hooks {

    public static WebDriver driver;
    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private static String downloadFilepath = System.getProperty("user.dir") + "/testData/Download";
    private ChromeOptions chromeOptions = new ChromeOptions();
    private InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    String os = System.getProperty("os.name").toLowerCase();

    @Before
    public void openBrowser() throws Exception {

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        String browser = System.getProperty("BROWSER");
        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chromeheadless";
            }

        }
        switch (browser.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
//              String downloadFilepath = driverDirectory + "/chrome/";

                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", downloadFilepath);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);

                if (os.contains("win")) {
                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                }
                else{
                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver");
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().setSize(new Dimension(1280, 1024));
                }

                break;

            case "firefox":
                if (os.contains("win")) {
                    System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                else{
                System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                }
                break;
            case "firefoxheadless":
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);

            if (os.contains("win")) {
                System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver.exe");
                driver = new FirefoxDriver(options);
            }
            else{
            System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            }
            break;

            case "chromeheadless":
                if (os.contains("win")) {
                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1200x600");
                    driver = new ChromeDriver(chromeOptions);
                }
                else {
                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver");
                    HashMap <String, Object> chromePrefs1 = new HashMap <String, Object>();
                    chromePrefs1.put("download.default_directory", downloadFilepath);
                    chromeOptions.setExperimentalOption("prefs", chromePrefs1);
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1200x600");
                    driver = new ChromeDriver(chromeOptions);
                }
                break;

            case "chromeheadlesswindows":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;

//            case "ieWindows":
//            case "ie":
//                System.setProperty("webdriver.ie.driver", driverDirectory + "/IEDriver/IEDriverServer.exe");
//                //DesiredCapabilities  = new DesiredCapabilities();
//                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//                capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
//
//                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//                driver = new InternetExplorerDriver(capabilities);
//                driver.manage().window().maximize();
//                break;

            case "ie":
//                WebDriverManager.iedriver().setup();
                System.setProperty("webdriver.ie.driver", driverDirectory + "/IEDriver/IEDriverServer.exe");
                InternetExplorerOptions ieOptions = new InternetExplorerOptions().requireWindowFocus();
                ieOptions.destructivelyEnsureCleanSession();
                driver = new InternetExplorerDriver(ieOptions);
                driver.manage().window().setSize(new Dimension(1280, 1024));
                break;


//            case "ie":
//                System.setProperty("webdriver.ie.driver", driverDirectory + "/IEDriver/IEDriverServer.exe");
//                internetExplorerOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//                internetExplorerOptions.setCapability("unexpectedAlertBehaviour", "accept");
//                internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//                driver = new InternetExplorerDriver(internetExplorerOptions);
//                driver.manage().window().setSize(new Dimension(1280, 1024));
//                break;
//
//            case "ieWindows":
////                InternetExplorerOptions ieOptions = new InternetExplorerOptions()
////                        .destructivelyEnsureCleanSession();
////                capabilities.setCapability("se:ieOptions", ieOptions);
////                driver = new InternetExplorerDriver();
////                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "htmlunit":
//                driver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED, true);
                java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
                break;

            case "pjsmac":
                driver = Browsers.getPJSMacDriver();
                driver.manage().window().setSize(new Dimension(1280, 1024));
                break;

            case "pjslinux":
                driver = Browsers.getPJSLinux();
                break;

            case "pjswindows":
                driver = Browsers.pjsWindowsGet();
                driver.manage().window().setSize(new Dimension(1280, 1024));
                break;

//          This can be only run from an windows machine.
            case "iegrid":
                String nodesURL = "http://10.211.55.3:5555/wd/hub";
                DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
                cap.setBrowserName("internet explorer");
                cap.setPlatform(Platform.WINDOWS);
                WebDriver driver = new RemoteWebDriver(new URL(nodesURL), cap);
                break;
        }

//        driver.manage().window().setSize(new Dimension(1280, 1024));
        System.out.println("The Browser used for this test is: " + browser.toUpperCase());
//        driver.manage().deleteAllCookies();
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) throws Exception {
        System.out.println(scenario.getStatus()+"----"+ Arrays.asList(scenario.getSourceTagNames()).toString());
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + new URL(driver.getCurrentUrl()));
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}