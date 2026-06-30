package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mago;
import personajes.SubClaseMago;

import static org.junit.jupiter.api.Assertions.*;

public class EpiskeyTest {

    @Test
    public void episkeyCuraDuranteElTurno() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        mago.modificarPuntosDeSalud(20);

        Episkey episkey = new Episkey();
        episkey.ejecutar(mago, mago);

        mago.activarEfectosParaSiguienteRonda();
        mago.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(45, mago.obtenerPuntosDeSalud());
    }
}
