package hechizo;

import org.junit.jupiter.api.Test;
import personajes.Mago;
import personajes.Mortifago;
import personajes.SubClaseMortifago;
import personajes.SubClaseMago;

import static org.junit.jupiter.api.Assertions.*;

public class SectumsempraTest {

    @Test
    public void sectumsempraCausaDañoVariosTurnos() {
        Mago mago = new Mago("Neville", SubClaseMago.AUROR);
        Mortifago mortifago = new Mortifago("Draco", SubClaseMortifago.SEGUIDOR);

        mortifago.modificarPuntosDeSalud(200);

        Sectumsempra sectumsempra = new Sectumsempra();
        sectumsempra.ejecutar(mago, mortifago);

        mortifago.activarEfectosParaSiguienteRonda();
        mortifago.aplicarEfectos(MomentoEfecto.FIN_TURNO);

        assertEquals(165, mortifago.obtenerPuntosDeSalud());

        sectumsempra.ejecutar(mago, mortifago);

        mortifago.activarEfectosParaSiguienteRonda();
        mortifago.aplicarEfectos(MomentoEfecto.FIN_TURNO);

        assertEquals(95, mortifago.obtenerPuntosDeSalud());

        mortifago.activarEfectosParaSiguienteRonda();
        mortifago.aplicarEfectos(MomentoEfecto.FIN_TURNO);

        assertEquals(25, mortifago.obtenerPuntosDeSalud());
    }
      
}
