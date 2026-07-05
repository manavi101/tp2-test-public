package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mago;
import personajes.SubClaseMago;

import static org.junit.jupiter.api.Assertions.*;

public class ExpelliarmusTest {

    @Test
    public void expelliarmusEliminaPersonaje() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        Mago mago2 = new Mago("Draco", SubClaseMago.AUROR);

        mago2.modificarPuntosDeSalud(50);

        Expelliarmus expelliarmus = new Expelliarmus();
        expelliarmus.ejecutar(mago, mago2);


        assertEquals(0, mago2.obtenerPuntosDeSalud());
    }
    
}
