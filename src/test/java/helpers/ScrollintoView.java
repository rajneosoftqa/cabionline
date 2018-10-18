package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CasePage;

import static step_definitions.Hooks.driver;

/**
 * Created by tdatta on 6/1/17.
 */
public class ScrollintoView {

    private JavascriptExecutor jse = (JavascriptExecutor) driver;


    public void scrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void scrollUp(){
        jse.executeScript("scroll(0, -250);");

    }

    public void scrollDown(){
        jse.executeScript("scroll(0, 2000);");
    }

    public void scrollToMiddle(){
        jse.executeScript("scroll(0, 400);");

    }
    public void scrollToViewAndClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element );
        element.click();
    }

    public void scrollWithoutBanner(WebDriver driver){
        new CssHelpers().addCssProperty(new CasePage(driver).navBar,"position","relative");

    }
}
