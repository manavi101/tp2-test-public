package hechizoFactory;

import hechizo.AvadaKedavra;
import hechizo.Hechizo;

public class AvadaKedavraFactory extends HechizoFactory{

	@Override
	public Hechizo crearHechizo() {
		return new AvadaKedavra();
	}

}
