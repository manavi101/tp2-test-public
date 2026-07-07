package personajeFactory;

import org.junit.jupiter.api.Test;
import personajes.Mago;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MagoFactoryTest {

    @Test
    public void crearMagoDevuelveMagoValido() {
        MagoFactory factory = new MagoFactory();

        Mago mago = factory.crearPersonaje();

        assertNotNull(mago);
        assertEquals(Mago.class, mago.getClass());
        assertNotNull(mago.obtenerNombre());
        assertFalse(mago.obtenerNombre().isEmpty());
        assertTrue(mago.estaVivo());
    }

    @Test
    public void nombresSeReutilizanDespuesDeAgotarElPool() {
        MagoFactory factory = new MagoFactory();
        Set<String> nombres = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            nombres.add(factory.crearPersonaje().obtenerNombre());
        }

        assertEquals(5, nombres.size());

        nombres.add(factory.crearPersonaje().obtenerNombre());
        assertEquals(5, nombres.size());
    }
}
