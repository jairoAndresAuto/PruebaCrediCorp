package co.com.sura.crear_cliente.interactions;

import net.serenitybdd.model.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Espera implements Task {

    private int tiempo;

    public Espera(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        new InternalSystemClock().pauseFor(tiempo);
    }

    public static Espera unTiempo(int tiempo) {
        return Tasks.instrumented(Espera.class, tiempo);
    }
}
