package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.AppointmentPage;
import pageobject.HomePage;
import pageobject.LoginPage;

public class CuraHealthcareStepsDefinitions {
    @Steps
    HomePage home;

    @Steps
    LoginPage login;

    @Steps
    AppointmentPage appointment;

    @Given("^que el usuario ingresa a la web CURA Healthcare Service$")
    public void queElUsuarioIngresaALaWebCURAHealthcareService(){
        home.open();
        home.desplegarMenu();
        home.irALoginPage();
    }

    @When("^ingreso el usuario (.*) y contrasenia (.*) correctos$")
    public void ingresoElUsuarioYContraseniaCorrectos(String username, String password) {
        login.ingresarCredenciales(username,password);
    }

    @Then("^inicia sesion de manera exitosa$")
    public void iniciaSesionDeManeraExitosa() {
        login.validarLoginExitoso();
    }

    @And("^diligencio la solicitud de cita (.*), (.*), (.*), (.*) y (.*)$")
    public void diligencioLaSolicitudDeCita(String facility, boolean readmission, String Healthcare, String visitDate, String comment) throws InterruptedException {
        appointment.diligenciarCita(facility, readmission, Healthcare, visitDate, comment);
    }

    @Then("^se agenda la cita de manera exitosa con los datos registrados$")
    public void seAgendaLaCitaDeManeraExitosaConLosDatosRegistrados() throws InterruptedException {
        appointment.validarappointmentExitoso();
    }

    @When("^ingreso el usuario (.*) y contrasenia (.*) incorrectos$")
    public void ingresoElUsuarioYContraseniaIncorrectos(String username, String password) {
        login.ingresarCredenciales(username,password);
    }

    @Then("^el sistema no inicia sesion$")
    public void elSistemaNoIniciaSesion() throws InterruptedException {
        login.validarLoginNoExitoso();
    }
}
