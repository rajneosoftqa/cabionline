package util;

import com.browserstack.local.Local;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by titudatta on 1/10/17.
 */
public class Browsers {
//    private static String USERNAME = "titudattaexiger"; // Your username
//    private static String ACCESS_KEY = "02486554-c03f-4e0a-8659-548230c55c7a";  // Your authkey

    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private static DesiredCapabilities caps = new DesiredCapabilities();

    public static final String USERNAME = "titudatta2";
    static String ACCESS_KEY = System.getenv("515tDaa6xdvy2yHwLLwx");
    static String URL = "https://" + "titudatta2" + ":" + "515tDaa6xdvy2yHwLLwx" + "@hub.browserstack.com/wd/hub";

    //private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    //private static DesiredCapabilities caps = new DesiredCapabilities();
    public static WebDriver driver;
    private static Local l;

    public static WebDriver getPJSMacDriver() throws Exception {
        String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
        System.out.println("Getting ready to start with Phantom JS Mac");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/macPJS/phantomjs"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        WebDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }


    public static WebDriver getHTMLDriver() throws Exception {
        String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
        System.out.println("Getting ready to start with Phantom JS Mac");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/macPJS/phantomjs"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        WebDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }

    public static WebDriver getPJSLinux() throws Exception {

        System.out.println("Getting ready to start with Phantom JS Linux");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/linuxPJS/phantomjs"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }


    public static WebDriver getpjsWindows() throws Exception {

        System.out.println("Getting ready to start with Phantom JS Windows");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/WindowsPJS/phantomjs.exe"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }


    public static WebDriver getIEGrid() throws Exception {
        String nodesURL = "http://10.211.55.3:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setBrowserName("internet explorer");
        cap.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(new URL(nodesURL), cap);
        return driver;

    }

    public static WebDriver pjsWindowsGet(){
        WebDriver driver;
        DesiredCapabilities capabilities= DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("phantomjs.binary.path",
                driverDirectory+ "/WindowsPJS/phantomjs.exe");
        capabilities.setJavascriptEnabled(true);
        driver = new PhantomJSDriver(capabilities);
        return driver;
    }

    private static WebDriver getBrowser(final String browser, final DesiredCapabilities capabilities) {
        switch (browser) {
            case "BROWSER_HTMLUNIT":
                return new HtmlUnitDriver(capabilities);
            case "BROWSER_CHROME":
                return new ChromeDriver(capabilities);
        }
        throw new RuntimeException("No browser specified! Use " + browser + " parameter.");
    }

    public static WebDriver getChromeBroswerStack() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.local", "true");
        caps.setCapability("browserstack.localIdentifier", "Test123");
        if (System.getProperty("local") != null && System.getProperty("local").equals("true")) {
            caps.setCapability("browserstack.local", "true");
            l = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", ACCESS_KEY);
            l.start(options);
        }

        driver = new RemoteWebDriver(new URL(URL), caps);
        return driver;
    }
}






























