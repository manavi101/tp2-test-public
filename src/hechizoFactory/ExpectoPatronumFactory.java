package hechizoFactory;

import hechizo.ExpectoPatronum;
import hechizo.Hechizo;

public class ExpectoPatronumFactory extends HechizoFactory {
	
	@Override
	public Hechizo crearHechizo() {
		return new ExpectoPatronum();
	}
}
