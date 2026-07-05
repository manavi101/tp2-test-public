package personajes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MortifagoTest {

    private Mortifago crearMortifago() {
        return new Mortifago("Bellatrix", SubClaseMortifago.SEGUIDOR);
    }

    @Test
    public void curarNoSuperaElMaximo() {
        Mortifago mortifago = crearMortifago();
        mortifago.modificarPuntosDeSalud(10);

        mortifago.curar(20000);

        assertEquals(SubClaseMortifago.SEGUIDOR.obtenerPuntosDeSalud(), mortifago.obtenerPuntosDeSalud());
    }

    @Test
    public void recibirAtaqueReduceSalud() {
        Mortifago mortifago = crearMortifago();

        mortifago.recibirAtaque(30);

        assertEquals(SubClaseMortifago.SEGUIDOR.obtenerPuntosDeSalud() - 30, mortifago.obtenerPuntosDeSalud());
    }

    @Test
    public void recibirAtaqueConEscudoReduceMitadYLoConsume() {
        Mortifago mortifago = crearMortifago();
        mortifago.activarEscudo();

        mortifago.recibirAtaque(30);
        assertEquals(SubClaseMortifago.SEGUIDOR.obtenerPuntosDeSalud() - 15, mortifago.obtenerPuntosDeSalud());

        mortifago.recibirAtaque(10);
        assertEquals(SubClaseMortifago.SEGUIDOR.obtenerPuntosDeSalud() - 25, mortifago.obtenerPuntosDeSalud());
    }

    @Test
    public void mortifagoPotenciarDanioOscuroIncluyeBonificacion() {
        Mortifago mortifago = crearMortifago();
        int nivelDeMagia = mortifago.obtenerNivelDeMagia();

        int danioTotal = mortifago.potenciarDanioOscuro(10);

        assertEquals(10 + nivelDeMagia + 20, danioTotal);
    }

    @Test
    public void mortifagoEstaVivoAntesDeSerSanado() {
        Mortifago mortifago = crearMortifago();

        assertTrue(mortifago.estaVivo());
    }

    @Test
    public void mortifagoMuere() {
        Mortifago mortifago = crearMortifago();

        mortifago.recibirAtaque(mortifago.obtenerPuntosDeSalud() + 1);

        assertFalse(mortifago.estaVivo());
    }

    @Test
    public void obtenerMortifagoString() {
        Mortifago mortifago = crearMortifago();

        assertEquals("[Mortifago] Bellatrix | SubClase: SEGUIDOR | Puntos de Salud 90 | Nivel de Magia: 35", mortifago.toString());
    }

    @Test
    public void obtenerTipoMortifago() {
        Mortifago mortifago = crearMortifago();

        assertEquals("Mortifago", mortifago.obtenerTipo());
    }

    @Test
    public void obtenerSubclaseMortifago() {
        Mortifago mortifago = crearMortifago();

        assertEquals(SubClaseMortifago.SEGUIDOR, mortifago.obtenerSubclase());
    }
}