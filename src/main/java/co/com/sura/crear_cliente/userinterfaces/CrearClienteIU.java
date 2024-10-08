package co.com.sura.crear_cliente.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class CrearClienteIU {

    public static final Target BTN_SIGN_UP = Target.the("Boton registrar")
            .located(ByShadow.id("signin2"));
    public static final Target BTN_LOG_IN= Target.the("Boton Ingresar")
            .located(ByShadow.id("login2"));
    public static final Target TXT_USUARIO_SIGN_IN = Target.the("Boton Ingresar")
            .located(ByShadow.id("sign-username"));
    public static final Target TXT_CLAVE_SIGN_IN = Target.the("Boton Ingresar")
            .located(ByShadow.id("sign-password"));
    public static final Target TXT_USUARIO_LOG_IN= Target.the("Boton Ingresar")
            .located(ByShadow.id("loginusername"));
    public static final Target TXT_CLAVE_LOG_IN= Target.the("Boton Ingresar")
            .located(ByShadow.id("loginpassword"));
    public static final Target BTN_LOG_IN_INGRESAR= Target.the("Boton Ingresar")
            .located(ByShadow.xpath("//button[contains(.,'Log in')]"));
    public static final Target BTN_SIGN_IN_INGRESAR= Target.the("Boton Ingresar")
            .located(ByShadow.xpath("//button[contains(.,'Sign up')]"));
    public static final Target BTN_ARTICULO= Target.the("Boton Ingresar")
            .locatedBy("(//a[@class='hrefch'])[{0}]");
    public static final Target BTN_AGREGAR_CARRO = Target.the("Boton Ingresar")
            .locatedBy("//a[contains(.,'Add to cart')]");
    public static final Target BTN_CARRO= Target.the("Boton Ingresar")
            .located(By.xpath("//a[contains(.,'Cart')]"));
    public static final Target ARTICULO_AGREGADO= Target.the("Boton Ingresar")
            .located(By.xpath("//tr"));

}
