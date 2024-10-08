package co.com.sura.crear_cliente.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sura.crear_cliente.userinterfaces.CrearClienteIU.ARTICULO_AGREGADO;

public class ValidarExistencia implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return ARTICULO_AGREGADO.resolveAllFor(actor).size()==2;
    }

    public static ValidarExistencia producto() {
        return new ValidarExistencia();
    }
}
