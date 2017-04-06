import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;


public class Reserva {
private int id;
private Calendar horaEntrada;
private Calendar horaSalida;//si hago persistentes las reservas puedria utilizarlo
private Cliente cliente;
private ArrayList<Cochera> cochera;
private boolean pagoEfectivo;//true efectivo-false tarjeta
private boolean lavar;
private boolean revision;
private String comentarios;

	


public Reserva(){}

public Reserva(int id,Calendar horaEntrada, Cliente cliente,ArrayList<Cochera> cochera, boolean pagoEfectivo,boolean lavar,boolean revision){
this.id=id;
this.horaEntrada=horaEntrada;
this.cliente=cliente;
this.cochera=cochera;
this.pagoEfectivo=pagoEfectivo;
this.lavar=lavar;
this.revision=revision;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Calendar getHoraEntrada() {
	return horaEntrada;
}

public void setHoraEntrada(Calendar horaEntrada) {
	this.horaEntrada = horaEntrada;
}

public Calendar getHoraSalida() {
	return horaSalida;
}

public void setHoraSalida(Calendar horaSalida) {
	this.horaSalida = horaSalida;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public ArrayList<Cochera> getCochera() {
	
	return cochera;
}

public void setCochera(ArrayList<Cochera> cochera) {
	this.cochera = cochera;
}

public boolean isPagoEfectivo() {
	return pagoEfectivo;
}

public void setPagoEfectivo(boolean pagoEfectivo) {
	this.pagoEfectivo = pagoEfectivo;
}

public boolean isLavar() {
	return lavar;
}

public void setLavar(boolean lavar) {
	this.lavar = lavar;
}

public boolean isRevision() {
	return revision;
}

public void setRevision(boolean revision) {
	this.revision = revision;
}


public String getComentarios() {
	return comentarios;
}

public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}
	
	
}
