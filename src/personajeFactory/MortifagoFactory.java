package personajeFactory;

import java.util.ArrayList;
import java.util.Random;

import personajes.Mortifago;
import personajes.SubClaseMortifago;

public class MortifagoFactory extends PersonajeFactory{
	
	private ArrayList<String> nombres;
	private ArrayList<String> nombresDisponibles;
	private Random rand;
	
	public MortifagoFactory() {
		
		rand = new Random();
		
		nombres = new ArrayList<>();
		
        nombres.add("Bellatrix");
        nombres.add("Lucius");
        nombres.add("Dolohov");
        nombres.add("Greyback");
        nombres.add("Yaxley");
        
        nombresDisponibles = new ArrayList<>(nombres);
	}
	
	@Override
	public Mortifago crearPersonaje() {
		
		SubClaseMortifago[] subClases = SubClaseMortifago.values();
		
		SubClaseMortifago subClaseRandom = subClases[rand.nextInt(subClases.length)];
		
		return new Mortifago(obtenerNombre(), subClaseRandom);
	}
	
	public String obtenerNombre() {
		
		if(nombresDisponibles.isEmpty()) {
			nombresDisponibles = new ArrayList<>(nombres);
		}
		
		int indice = rand.nextInt(nombresDisponibles.size());
		
		return nombresDisponibles.remove(indice);
	}
}
