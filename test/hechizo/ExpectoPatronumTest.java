package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mortifago;
import personajes.SubClaseMortifago;

import static org.junit.jupiter.api.Assertions.*;

public class ExpectoPatronumTest {

    @Test
    public void expectoPatronumCuraPersonaje() {
        Mortifago mortifago = new Mortifago("Neville", SubClaseMortifago.SEGUIDOR);

        mortifago.modificarPuntosDeSalud(50);

        ExpectoPatronum expectoPatronum = new ExpectoPatronum();
        expectoPatronum.ejecutar(mortifago, mortifago);


        assertEquals(90, mortifago.obtenerPuntosDeSalud());
    }
    
}