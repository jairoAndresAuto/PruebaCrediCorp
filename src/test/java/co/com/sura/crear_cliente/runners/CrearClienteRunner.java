package co.com.sura.crear_cliente.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/registrar_cliente.feature"
        , glue = "co.com.sura.crear_cliente.stepdefinitions"
        , snippets = CAMELCASE)
public class CrearClienteRunner {
}
