package hechizoFactory;

import hechizo.Expelliarmus;
import hechizo.Hechizo;

public class ExpeliarmusFactory extends HechizoFactory{

	@Override
	public Hechizo crearHechizo() {
		return new Expelliarmus();
	}
	
}
