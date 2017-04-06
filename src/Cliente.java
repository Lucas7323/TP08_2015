import java.util.ArrayList;

public class Cliente {
private String nombre;
private String apellido;
private String mail;
private String telefono;
private String domicilio;
private long dni;
private int cp;
private String provincia;
private Vehiculo vehiculo;
private String diasFrecuentes;
private String otrosVehiculos;


public Cliente (){
	vehiculo= new Vehiculo();
	}
public Cliente(String nombre, String apellido, String mail, String telefono,String domicilio, long dni, int cp,String tipo, String marca, String modelo,String patente,String provincia, String diasFrecuentes,String otrosVehiculos){
	this.nombre=nombre;
	this.mail=mail;
	this.apellido=apellido;
	this.telefono=telefono;
	this.domicilio=domicilio;
	this.dni=dni;
	this.cp=cp;
	vehiculo= new Vehiculo(tipo, marca,modelo,patente);
	this.provincia=provincia;
	this.diasFrecuentes=diasFrecuentes;
	this.otrosVehiculos=otrosVehiculos;
	
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getDomicilio() {
	return domicilio;
}
public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}
public long getDni() {
	return dni;
}
public void setDni(long dni) {
	this.dni = dni;
}
public int getCp() {
	return cp;
}
public void setCp(int cp) {
	this.cp = cp;
}
public Vehiculo getVehiculo() {
	return vehiculo;
}
public void setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;
}

public String getDiasFrecuentes() {
	return diasFrecuentes;
}
public void setDiasFrecuentes(String diasFrecuentes) {
	this.diasFrecuentes = diasFrecuentes;
}
public String getOtrosVehiculos() {
	return otrosVehiculos;
}
public void setOtrosVehiculos(String otrosVehiculos) {
	this.otrosVehiculos = otrosVehiculos;
}


}
