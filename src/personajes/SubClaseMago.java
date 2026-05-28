package personajes;

public enum SubClaseMago {
	AUROR(100, 35),
	PROFESOR(120, 40),
	ALUMNO(80, 15),
	SANADOR(90, 20);
	
	private int puntosDeSalud;
	private int nivelDeMagia;
	
	SubClaseMago(int puntosDeSalud, int nivelDeMagia) {
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
