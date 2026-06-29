package hechizoFactory;

import hechizo.Episkey;
import hechizo.Hechizo;

public class EpiskeyFactory extends HechizoFactory{

	@Override
	public Hechizo crearHechizo() {
		return new Episkey();
	}

}
