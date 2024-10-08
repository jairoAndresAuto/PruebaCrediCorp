package co.com.sura.crear_cliente.tasks;

import co.com.sura.crear_cliente.interactions.Espera;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_AGREGAR_CARRO;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_ARTICULO;
import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.BTN_CARRO;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA_EXTRA_LARGO;
import static co.com.sura.crear_cliente.util.Constantes.TIEMPO_ESPERA_LARGO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

@AllArgsConstructor
public class SeleccionarCelular implements Task {

    private String posicion;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Espera.unTiempo(TIEMPO_ESPERA_LARGO),
                Scroll.to(BTN_ARTICULO.of(posicion)),
                Click.on(BTN_ARTICULO.of(posicion)),
                WaitUntil.the(BTN_AGREGAR_CARRO,isClickable()),
                Click.on(BTN_AGREGAR_CARRO),
                Espera.unTiempo(TIEMPO_ESPERA_LARGO));
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        actor.attemptsTo(Click.on(BTN_CARRO),
                Espera.unTiempo(TIEMPO_ESPERA_EXTRA_LARGO));

    }

    public static SeleccionarCelular dePreferencia(String posicion) {
        return Tasks.instrumented(SeleccionarCelular.class,posicion);
    }

}
