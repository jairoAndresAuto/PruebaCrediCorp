package co.com.sura.crear_cliente.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_LOG_IN;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_LOG_IN_INGRESAR;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.TXT_CLAVE_LOG_IN;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.TXT_USUARIO_LOG_IN;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.TXT_USUARIO_SIGN_IN;
import static co.com.sura.crear_cliente.util.Constantes.CLAVE;
import static co.com.sura.crear_cliente.util.Constantes.USUARIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class IngresarLogin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_LOG_IN, isClickable()),
                Click.on(BTN_LOG_IN),
                WaitUntil.the(TXT_USUARIO_LOG_IN,isEnabled()).forNoMoreThan(Duration.ofMinutes(1)),
                Enter.theValue(actor.recall(USUARIO).toString()).into(TXT_USUARIO_LOG_IN),
                Enter.theValue(actor.recall(CLAVE).toString()).into(TXT_CLAVE_LOG_IN),
                Click.on(BTN_LOG_IN_INGRESAR));
    }

    public static IngresarLogin clinete() {
        return Tasks.instrumented(IngresarLogin.class);
    }
}
