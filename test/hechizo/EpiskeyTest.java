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

    @Test
    public void episkeyCuraDuranteElTurnoYSeAcumula() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        mago.modificarPuntosDeSalud(10);

        Episkey episkey = new Episkey();
        episkey.ejecutar(mago, mago);

        mago.activarEfectosParaSiguienteRonda();
        mago.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(35, mago.obtenerPuntosDeSalud());

        episkey.ejecutar(mago, mago);
        mago.activarEfectosParaSiguienteRonda();
        mago.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(85, mago.obtenerPuntosDeSalud());

        mago.activarEfectosParaSiguienteRonda();
        mago.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(100, mago.obtenerPuntosDeSalud());
    }

    @Test
    public void episkeyPersonajeMuertoNoCura() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        mago.modificarPuntosDeSalud(0);

        Episkey episkey = new Episkey();
        episkey.ejecutar(mago, mago);

        mago.activarEfectosParaSiguienteRonda();
        mago.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(0, mago.obtenerPuntosDeSalud());
    }
}
