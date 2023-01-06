package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AppointmentPage extends PageObject {

    @FindBy(id = "combo_facility")
    public WebElementFacade facilityListD;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElementFacade hospitalReadmissionCheck;

    @FindBy(xpath = "//form[@class='form-horizontal']/div[3]/div")
    public WebElementFacade healthcareProgramElement;

    @FindBy(xpath = "//label[@class='radio-inline']")
    public List<WebElementFacade> listHealthcareProgram;

    @FindBy(id = "txt_visit_date")
    public WebElementFacade visitDateTxt;

    @FindBy(id = "txt_comment")
    public WebElementFacade commentTxt;

    @FindBy(id = "btn-book-appointment")
    public WebElementFacade appointmentBtn;

    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
    public WebElementFacade appointmentConfirmationLbl;

    @FindBy(xpath = "//div[@class = 'input-group-addon']")
    public WebElementFacade calendarBtn;
    @FindBy(xpath = "//div[@class = 'datepicker-days']/table/tbody/tr/td[@class='day'][6]")
    public WebElementFacade dayCalendarBtn;

    public void diligenciarCita() throws InterruptedException {

        seleccionarFacility("Hongkong CURA Healthcare Center");

        element(healthcareProgramElement).waitUntilVisible();
        SelectOptions.in(listHealthcareProgram, "Medicaid");

        hospitalReadmissionCheck.click();

        /* DOS FORMAS DE SELECCIONAR LA FECHA */

        // --- 1) Ingresando la fecha de manera directa
        //visitDateTxt.type("05/01/2022");

        // --- 2) Dando clic sobre los elementos del calendario
        calendarBtn.click();
        dayCalendarBtn.click();

        commentTxt.type("Remisión de prueba QA");

        appointmentBtn.click();
    }

    public void seleccionarFacility(String option) {
        element(facilityListD).waitUntilVisible();
        List<WebElement> elements = facilityListD.findElements(By.tagName("option"));
        for(WebElement element : elements){
            if(element.getText().contains(option)){
                element.click();
                break;
            }
        }
    }

    public void validarappointmentExitoso() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(appointmentConfirmationLbl.getText(), "Appointment Confirmation");
    }
}
