package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "txt-username")
    public WebElementFacade usernameTxt;
    @FindBy(name = "password")
    public WebElementFacade passwordTxt;
    @FindBy(css = ".btn.btn-default")
    public WebElementFacade submitBtn;
    @FindBy(xpath = "//section[@id='appointment']/div/div/div/h2")
    public WebElementFacade tituloLbl;
    @FindBy(xpath = "//section[@id = 'login']/div/div/div/p[2]")
    public WebElementFacade loginNoExitosoLbl;

    public void ingresarCredenciales(String username, String password){
        usernameTxt.type(username);
        passwordTxt.type(password);
        submitBtn.click();
    }

    public void validarLoginExitoso(){
        element(tituloLbl).waitUntilVisible();
        Assert.assertEquals(tituloLbl.getText(), "Make Appointment");
    }

    public void validarLoginNoExitoso() throws InterruptedException {
        Thread.sleep(3000);
        element(loginNoExitosoLbl).waitUntilVisible();
        Assert.assertEquals(loginNoExitosoLbl.getText(), "Login failed! Please ensure the username and password are valid.");

    }
}
