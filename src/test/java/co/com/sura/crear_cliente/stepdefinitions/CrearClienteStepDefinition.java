package co.com.sura.crear_cliente.stepdefinitions;

import co.com.sura.crear_cliente.questions.ValidarExistencia;
import co.com.sura.crear_cliente.tasks.IngresarLogin;
import co.com.sura.crear_cliente.tasks.RegistrarCliente;
import co.com.sura.crear_cliente.tasks.SeleccionarCelular;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearClienteStepDefinition {

    @Managed(driver = "chrome")
    public WebDriver driver;


    @Dado("procede a ingresa a la siguiente {string}")
    public void procedeAIngresaALaSiguiente(String URL) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("PIATCalidadSura");
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver)).attemptsTo(Open.url(URL));
    }

    @Cuando("procede a ingresar los datos del cliente en sing up")
    public void procedeAIngresarLosDatosDelClienteEnSingUp() {
        theActorInTheSpotlight().attemptsTo(RegistrarCliente.enPlataforma());
    }

    @Y("procede loguearse en la opcion log in")
    public void procedeLoguearseEnLaOpcionLogIn() {
        theActorInTheSpotlight().attemptsTo(IngresarLogin.clinete());
    }

    @Y("Despues añadir el telefono con {string} a gusto al carrito")
    public void despuesAñadirElTelefonoConAGustoAlCarrito(String posicion) {
        theActorInTheSpotlight().attemptsTo(SeleccionarCelular.dePreferencia(posicion));
    }

    @Entonces("se podra observar un item en el carrito")
    public void sePodraObservarUnItemEnElCarrito() {
        theActorInTheSpotlight().should(seeThat(ValidarExistencia.producto()));
    }


}
