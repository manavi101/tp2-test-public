package personajes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagoTest {

    private Mago crearMago() {
        return new Mago("Harry", SubClaseMago.ALUMNO);
    }

    @Test
    public void curarNoSuperaElMaximo() {
        Mago mago = crearMago();

        mago.curar(100);

        assertEquals(80, mago.obtenerPuntosDeSalud());
    }

    @Test
    public void recibirAtaqueReduceSalud() {
        Mago mago = crearMago();

        mago.recibirAtaque(30);

        assertEquals(50, mago.obtenerPuntosDeSalud());
    }

    @Test
    public void recibirAtaqueConEscudoReduceMitadYLoConsume() {
        Mago mago = crearMago();
        mago.activarEscudo();

        mago.recibirAtaque(30);
        assertEquals(65, mago.obtenerPuntosDeSalud());

        mago.recibirAtaque(10);
        assertEquals(55, mago.obtenerPuntosDeSalud());
    }

    @Test
    public void potenciarDanioOscuroSumaNivelDeMagia() {
        Mago mago = crearMago();

        assertEquals(25, mago.potenciarDanioOscuro(10));
    }

    @Test
    public void magoPotenciarCuracionIncluyeBonificacion() {
        Mago mago = crearMago();

        assertEquals(35, mago.potenciarCuracion(10));
    }

    @Test
    public void obtenerMagoString() {
        Mago mago = crearMago();

        assertEquals("[Mago] Harry | SubClase: ALUMNO | Puntos de Salud 80 | Nivel de Magia: 15", mago.toString());
    }

    @Test
    public void obtenerTipoMago() {
        Mago mago = crearMago();

        assertEquals("Mago", mago.obtenerTipo());
    }

    @Test
    public void obtenerSubclaseMago() {
        Mago mago = crearMago();

        assertEquals(SubClaseMago.ALUMNO, mago.obtenerSubclase());
    }
}
