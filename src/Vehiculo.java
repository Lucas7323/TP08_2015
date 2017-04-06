
public class Vehiculo {
private String patente;
private String marca;
private String modelo;
private String tipo;
private boolean principal;

public Vehiculo(){}
public Vehiculo(String tipo,String modelo,String marca,String patente){
	this.patente=patente;
	this.marca=marca;
	this.modelo=modelo;
	this.tipo=tipo;
	
	
}
public String getPatente() {
	return patente;
}
public void setPatente(String patente) {
	this.patente = patente;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}


	
	
}
