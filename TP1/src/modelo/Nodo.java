package modelo;

import interfaces.INodo;
import interfaces.IVehiculo;

public class Nodo implements INodo {
	
	//atributos de la clase Nodo, donde guardaremos datos del tipo vehículo!!
	
	private INodo anterior; // referencia al Vehiculo anterior
	private IVehiculo vehiculo; // es del tipo IVehiculo, es decir, de cualquier clase que implemente los métodos de la clase Vehículo
	private INodo siguiente;
	
	// toString pero no lo dejamos de manera predeterminada para evitar el ciclo infinito  -->
	@Override
	public String toString() {
		return "Nodo [anterior=" + (anterior != null ? anterior.getVehiculo() : "null") + // esto es una forma de escribir un if-else donde
				//    					condicion      valor_si_es_verdadero	valor_si_es_falso (si es null la condición)
		           ", vehiculo=" + vehiculo + 
		           ", siguiente=" + siguiente + "]";
	} // de esta manera anterior no imprime todo el nodo sino el dato del nodo anterior, en este caso el vehiculo!

	// Constructor -->
	public Nodo(IVehiculo vehiculo) { // solo sabemos el vehiculo que contendrá, pero no los nodos que le siguen y su anterior!!! por eso lo ponemos en null
		super();
		this.vehiculo = vehiculo;
		this.siguiente = null;
		this.anterior = null;
	}

	// getters y setters
	public IVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(IVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public INodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(INodo siguiente) {
		this.siguiente = siguiente;
	}

	public INodo getAnterior() {
		return anterior;
	}

	public void setAnterior(INodo anterior) {
		this.anterior = anterior;
	}
	
}
