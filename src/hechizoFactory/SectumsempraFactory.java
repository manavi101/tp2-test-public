package hechizoFactory;

import hechizo.Hechizo;
import hechizo.Sectumsempra;

public class SectumsempraFactory extends HechizoFactory{

	@Override
	public Hechizo crearHechizo() {
		return new Sectumsempra();
	}

}
