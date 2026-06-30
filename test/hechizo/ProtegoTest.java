package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mago;
import personajes.SubClaseMago;

import static org.junit.jupiter.api.Assertions.*;

public class ProtegoTest {

    @Test
    public void protegoActivaEscudoYReduceDanio() {
        Mago mago = new Mago("Hermione", SubClaseMago.SANADOR);
        Protego protego = new Protego();

        protego.ejecutar(mago, mago);
        mago.recibirAtaque(20);

        assertEquals(80, mago.obtenerPuntosDeSalud());

        mago.recibirAtaque(10);
        assertEquals(70, mago.obtenerPuntosDeSalud());
    }
}
