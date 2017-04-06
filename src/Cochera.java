
public class Cochera {
	private int numeroCochera;
	private boolean disponible;
	public Cochera(){}
	public Cochera(int numeroCochera, boolean disponible){
		this.numeroCochera=numeroCochera;
		this.disponible=disponible;
	}
	public int getNumeroCochera() {
		return numeroCochera;
	}
	public void setNumeroCochera(int numeroCochera) {
		this.numeroCochera = numeroCochera;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
}
