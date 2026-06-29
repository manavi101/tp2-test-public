package personajeFactory;

import java.util.ArrayList;
import hechizoFactory.AvadaKedavraFactory;
import hechizoFactory.ExpeliarmusFactory;
import hechizoFactory.ProtegoFactory;
import hechizoFactory.SectumsempraFactory;
import personajes.Mortifago;
import personajes.SubClaseMortifago;

public class MortifagoFactory extends PersonajeFactory{
	
	public MortifagoFactory() {
		super();
		
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
		
		Mortifago mortifago = new Mortifago(obtenerNombre(), subClaseRandom);
		mortifago.agregarHechizo(new AvadaKedavraFactory().crearHechizo());
		mortifago.agregarHechizo(new ExpeliarmusFactory().crearHechizo());
		mortifago.agregarHechizo(new SectumsempraFactory().crearHechizo());
		return mortifago;
	}
	
}
