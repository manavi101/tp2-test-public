package personajeFactory;

import java.util.ArrayList;
import java.util.Random;

import personajes.Mago;
import personajes.SubClaseMago;

public class MagoFactory extends PersonajeFactory{
	
	public MagoFactory() {
		super();
		
		nombres = new ArrayList<>();
		
		nombres.add("Harry");
		nombres.add("Hermionie");
		nombres.add("Ron");
		nombres.add("Dumbledore");
		nombres.add("Lupin");
		
		nombresDisponibles = new ArrayList<>(nombres);
	}
	
	@Override
	public Mago crearPersonaje() {
		SubClaseMago[] subClases = SubClaseMago.values();
		
		SubClaseMago subClaseRandom = subClases[rand.nextInt(subClases.length)];
		
		return new Mago(obtenerNombre(), subClaseRandom);
	}
	

}
