package co.com.sura.crear_cliente.tasks;

import co.com.sura.crear_cliente.interactions.Espera;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Locale;

import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_SIGN_IN_INGRESAR;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_SIGN_UP;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.TXT_CLAVE_SIGN_IN;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.TXT_USUARIO_SIGN_IN;
import static co.com.sura.crear_cliente.util.Constantes.CLAVE;
import static co.com.sura.crear_cliente.util.Constantes.LIMITE_INFERIOR;
import static co.com.sura.crear_cliente.util.Constantes.LIMITE_SUPERIOR;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA_EXTRA_LARGO;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA_LARGO;
import static co.com.sura.crear_cliente.util.Constantes.USUARIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class RegistrarCliente implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker suraFaker = new Faker(new Locale("en_US"));
        String usuario = suraFaker.name().firstName() + suraFaker.random().nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR);
        String clave = String.valueOf(suraFaker.random().nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR));
        actor.attemptsTo(WaitUntil.the(BTN_SIGN_UP, isClickable()),
                Click.on(BTN_SIGN_UP),
                WaitUntil.the(TXT_USUARIO_SIGN_IN,isEnabled()).forNoMoreThan(Duration.ofMinutes(1)),
                Enter.theValue(usuario).into(TXT_USUARIO_SIGN_IN),
                Enter.theValue(clave).into(TXT_CLAVE_SIGN_IN),
                Click.on(BTN_SIGN_IN_INGRESAR),
                Espera.unTiempo(TIEMPO_ESPERA_LARGO));
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        actor.remember(USUARIO, usuario);
        actor.remember(CLAVE, clave);
    }

    public static RegistrarCliente enPlataforma() {
        return Tasks.instrumented(RegistrarCliente.class);
    }
}
