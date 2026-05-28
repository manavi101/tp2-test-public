package personajes;

public enum SubClaseMortifago {
	SEGUIDOR(90, 35),
	COMANDANTE(120, 30);
	
	private int puntosDeSalud;
	private int nivelDeMagia;
	
	SubClaseMortifago(int puntosDeSalud,int nivelDeMagia){
		this.puntosDeSalud = puntosDeSalud;
		this.nivelDeMagia = nivelDeMagia;
	}
	
	public int obtenerPuntosDeSalud() {
		return puntosDeSalud;
	}
	
	public int obtenerNivelDeMagia() {
		return nivelDeMagia;
	}
}
