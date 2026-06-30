package personajeFactory;

import java.util.ArrayList;
import hechizo.AvadaKedavra;
import hechizo.Episkey;
import hechizo.Expelliarmus;
import hechizo.Protego;
import hechizo.ExpectoPatronum;
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
		
		Mago mago = new Mago(obtenerNombre(), subClaseRandom);
		
		mago.agregarHechizo(new Expelliarmus());
		mago.agregarHechizo(new Protego());
		mago.agregarHechizo(new AvadaKedavra());
		mago.agregarHechizo(new ExpectoPatronum());
		mago.agregarHechizo(new Episkey());
		
		return mago;
	}
	

}
