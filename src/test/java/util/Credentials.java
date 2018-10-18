package util;
import helpers.Wait;
import org.openqa.selenium.interactions.Actions;
import pageobjects.LoginPage;
import step_definitions.BaseClass;
import java.util.logging.Level;

public class Credentials extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    public void getCredentials() {

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        String cred = System.getProperty("CRED");
        if (cred == null) {
            cred = System.getenv("CRED");
            if (cred == null) {
                cred = "omsclient";
            }
        }
        System.out.println("The test is running on " + cred.toUpperCase() + " Credentials");
        switch (cred.toLowerCase()) {
            case "omsclient":
                loginPage.userName.sendKeys("tdattaparent@exiger.com");
                loginPage.password.sendKeys("Exiger1!!");
//                loginPage.userName.sendKeys("tdattaparent@exiger.com");
//                loginPage.password.sendKeys("Exiger1!!");
                loginPage.loginButton.click();
                break;

            case "researcher":
                loginPage.userName.sendKeys("tdattaresearcher@exiger.com");
                loginPage.password.sendKeys("Admin123!!");
                loginPage.loginButton.click();
                break;

            case "researcher2":
                loginPage.userName.sendKeys("tdattaresearcher2@exiger.com");
                loginPage.password.sendKeys("Exiger1!!!");
                loginPage.loginButton.click();
                break;

            case "contentReviewer":
                loginPage.userName.sendKeys("tdattareview@exiger.com");
                loginPage.password.sendKeys("Exiger1!!");
                loginPage.loginButton.click();
                break;

            case "editor":
                loginPage.userName.sendKeys("tdattaedit@exiger.com");
                loginPage.password.sendKeys("Exiger1!!");
                loginPage.loginButton.click();
                break;

            case "caseSupervisor":
                loginPage.userName.sendKeys("tdattasupervisor@exiger.com");
                loginPage.password.sendKeys("Exiger1!");
                loginPage.loginButton.click();
                break;


            case "clientAccountManager":
                loginPage.userName.sendKeys("tdattacm@exiger.com");
                loginPage.password.sendKeys("Admin1234");
                loginPage.loginButton.click();
                break;

            case "clientchild1":
                loginPage.userName.sendKeys("tdattachild1@exiger.com");
                loginPage.password.sendKeys("Exiger1!");
                loginPage.loginButton.click();
                break;

            case "clientchild2":
                loginPage.userName.sendKeys("tdattachild2@exiger.com");
                loginPage.password.sendKeys("Exiger1!");
                loginPage.loginButton.click();
                break;

            case "omsclient2":
                loginPage.userName.sendKeys("tdattac2@exiger.com");
                loginPage.password.sendKeys("Exiger1!");
                loginPage.loginButton.click();
                break;
        }
    }
}


