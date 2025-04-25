package modelo;

import interfaces.IVehiculo;

public class Vehiculo implements IVehiculo { // queremos que la clase vehiculo haga lo que pide la interfaz IVehiculo
	
	// atributos del vehiculo -->
	private String marca;
	private String patente;
	
	// constructor de la clase -->
	public Vehiculo(String marca, String patente) {
		//super(); no es necesario para esta materia!
		this.marca = marca;
		this.patente = patente;
	}
	
	// getter y setters ->
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}

	// toString()
	public String toString() {
		return "Vehiculo [marca=" + marca + ", patente=" + patente + "]";
	}


}




