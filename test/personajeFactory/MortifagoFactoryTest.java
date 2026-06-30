package personajeFactory;

import org.junit.jupiter.api.Test;
import personajes.Mortifago;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MortifagoFactoryTest {

    @Test
    public void crearMortifagoDevuelveMortifagoValido() {
        MortifagoFactory factory = new MortifagoFactory();

        Mortifago mortifago = factory.crearPersonaje();

        assertNotNull(mortifago);
        assertEquals(Mortifago.class, mortifago.getClass());
        assertNotNull(mortifago.obtenerNombre());
        assertFalse(mortifago.obtenerNombre().isEmpty());
        assertTrue(mortifago.estaVivo());
    }

    @Test
    public void nombresMortifagosSeReutilizanDespuesDeAgotarPool() {
        MortifagoFactory factory = new MortifagoFactory();
        Set<String> nombres = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            nombres.add(factory.crearPersonaje().obtenerNombre());
        }

        assertEquals(5, nombres.size());

        nombres.add(factory.crearPersonaje().obtenerNombre());
        assertEquals(5, nombres.size());
    }
}
