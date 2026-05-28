package hechizoFactory;

import hechizo.Hechizo;
import hechizo.Protego;

public class ProtegoFactory extends HechizoFactory{

	@Override
	public Hechizo crearHechizo() {
		return new Protego();
	}

}
