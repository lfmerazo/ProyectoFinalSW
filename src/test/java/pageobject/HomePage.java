package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "menu-toggle")
    public WebElementFacade menuToggle;
    @FindBy(xpath = "//a[text() = 'Login']")
    public WebElementFacade loginLink;

    public void desplegarMenu(){
        menuToggle.click();
    }

    public void irALoginPage(){
        loginLink.click();
    }
}
