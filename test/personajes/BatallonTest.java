package personajes;

import hechizo.Episkey;
import hechizo.Expelliarmus;
import hechizo.MomentoEfecto;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BatallonTest {

    @Test
    public void obtenerTipoDesconocidoConBatallonVacio() {
        Batallon batallon = new Batallon();
        assertEquals("Desconocido", batallon.obtenerTipoDePersonajes());
    }

    @Test
    public void agregarPersonajeYObtenerTipo() {
        Batallon batallon = new Batallon();
        Mago mago= new Mago("Harry", SubClaseMago.ALUMNO);
        batallon.agregarPersonaje(mago);

        assertEquals("Mago", batallon.obtenerTipoDePersonajes());
    }

    @Test
    public void personajesVivosFiltraMuertos() {
        Batallon batallon = new Batallon();
        Mago mago = new Mago("Harry", SubClaseMago.AUROR);
        Mortifago mortifago = new Mortifago("Bellatrix", SubClaseMortifago.SEGUIDOR);

        batallon.agregarPersonaje(mago);
        batallon.agregarPersonaje(mortifago);

        mortifago.modificarPuntosDeSalud(0);

        List<Personaje> vivos = batallon.personajesVivos();
        assertEquals(1, vivos.size());
        assertEquals("Mago", vivos.get(0).obtenerTipo());
    }

    @Test
    public void aplicarEfectosActivaEpiskey() {
        Batallon b = new Batallon();
        Mago m = new Mago("Neville", SubClaseMago.AUROR);
        m.modificarPuntosDeSalud(20);

        b.agregarPersonaje(m);

        Episkey e = new Episkey();
        e.ejecutar(m, m);

        b.activarEfectoParaSiguienteRonda();
        b.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        assertEquals(45, m.obtenerPuntosDeSalud());
    }

    @Test
    public void atacarUnicoObjetivoReduceSalud() {
        Batallon atacantes = new Batallon();
        Batallon defensores = new Batallon();

        Mago atacante = new Mago("Harry", SubClaseMago.ALUMNO);
        Mortifago defensor = new Mortifago("Bellatrix", SubClaseMortifago.SEGUIDOR);

        atacante.agregarHechizo(new Expelliarmus());

        atacantes.agregarPersonaje(atacante);
        defensores.agregarPersonaje(defensor);

        atacantes.atacar(defensores);

        int danio = 20 + atacante.obtenerNivelDeMagia();
        assertEquals(SubClaseMortifago.SEGUIDOR.obtenerPuntosDeSalud() - danio, defensor.obtenerPuntosDeSalud());
    }

    @Test
    public void tienePersonajesSaludables() {
        Batallon batallon = new Batallon();
        Mago mago = new Mago("Harry", SubClaseMago.ALUMNO);
        batallon.agregarPersonaje(mago);

        assertTrue(batallon.tienePersonajesSaludables());

        mago.modificarPuntosDeSalud(0);

        assertFalse(batallon.tienePersonajesSaludables());
    }

    @Test
    public void mostrarIntegrantes() {
        Batallon batallon = new Batallon();
        Mago mago = new Mago("Harry", SubClaseMago.ALUMNO);
        Mortifago mortifago = new Mortifago("Bellatrix", SubClaseMortifago.SEGUIDOR);

        batallon.agregarPersonaje(mago);
        batallon.agregarPersonaje(mortifago);

        //Lo hago por el covarage, no hay asserts, solo se imprime por consola
        batallon.mostrarIntegrantes();

    }
}
