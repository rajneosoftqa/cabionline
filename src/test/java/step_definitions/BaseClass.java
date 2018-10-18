package step_definitions;

import org.openqa.selenium.WebDriver;
import util.Environments;

public class BaseClass {
	public WebDriver driver = Hooks.driver;



	public void navigateToDiligenceLoginPage() {
		Environments env = new Environments();
	}
}