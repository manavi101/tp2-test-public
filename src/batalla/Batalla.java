package batalla;

import personajeFactory.PersonajeFactory;
import personajeFactory.Reclutador;
import personajes.Batallon;

import java.util.Random;

import hechizo.MomentoEfecto;


public class Batalla {

    private Batallon batallon1;
    private Batallon batallon2;
    private Reclutador reclutador1;
    private Reclutador reclutador2;
    private Random rand;
    private int turno;

    Batalla(PersonajeFactory factory1, PersonajeFactory factory2) {
        this.batallon1 = new Batallon();
        this.batallon2 = new Batallon();
        this.reclutador1 = new Reclutador(factory1);
        this.reclutador2 = new Reclutador(factory2);
        this.rand = new Random();
        this.turno = 1;
    }

    public void agregarPersonaje1(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            batallon1.agregarPersonaje(reclutador1.reclutarPersonaje());
        }
    }

    public void agregarPersonaje2(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            batallon2.agregarPersonaje(reclutador2.reclutarPersonaje());
        }
    }

    public void realizarBatalla(){
        System.out.println("Comienza la batalla!");
        System.out.println();
    	
        while (batallon1.tienePersonajesSaludables() && batallon2.tienePersonajesSaludables()) {
            realizarTurno();

        }
        this.mostrarResultadoBatalla();
    }

    private void mostrarResultadoBatalla() {
    	System.out.println();
        if (batallon1.tienePersonajesSaludables()) {
            System.out.println("¡Los " + batallon1.obtenerTipoDePersonajes() + "s han ganado la batalla!");
        } else {
            System.out.println("¡Los " + batallon2.obtenerTipoDePersonajes() + "s han ganado la batalla!");
        }
    }

    private void realizarTurno() {
        System.out.println("----------------------------");
        System.out.println("Inicio de turno: " + turno);
        System.out.println();

        batallon1.aplicarEfectos(MomentoEfecto.INICIO_TURNO);
        batallon2.aplicarEfectos(MomentoEfecto.INICIO_TURNO);

        if (rand.nextBoolean()) {
            ataqueTurno(batallon1, batallon2);
            ataqueTurno(batallon2, batallon1);
        } else {
            ataqueTurno(batallon2, batallon1);
            ataqueTurno(batallon1, batallon2);
        }

        batallon1.aplicarEfectos(MomentoEfecto.FIN_TURNO);
        batallon2.aplicarEfectos(MomentoEfecto.FIN_TURNO);

        batallon1.activarEfectoParaSiguienteRonda();
        batallon2.activarEfectoParaSiguienteRonda();

        System.out.println();
        System.out.println("Fin de turno " + turno);
        System.out.println("----------------------------");
        turno++;
    }

    private void ataqueTurno(Batallon atacante, Batallon defensor) {
        if (atacante.tienePersonajesSaludables()) {
            atacante.atacar(defensor);
        }
    }



}