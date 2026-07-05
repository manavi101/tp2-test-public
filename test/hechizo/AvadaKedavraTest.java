package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mago;
import personajes.SubClaseMago;

import static org.junit.jupiter.api.Assertions.*;

public class AvadaKedavraTest {

    @Test
    public void avadaKedavraEliminaPersonaje() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        Mago mago2 = new Mago("Draco", SubClaseMago.AUROR);

        mago2.modificarPuntosDeSalud(50);

        AvadaKedavra avadaKedavra = new AvadaKedavra();
        avadaKedavra.ejecutar(mago, mago2);


        assertEquals(0, mago2.obtenerPuntosDeSalud());
    }
}
