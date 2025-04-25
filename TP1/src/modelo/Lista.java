package modelo;

import interfaces.ILista;
import interfaces.INodo; // porque vamos a crear variables tipo INodo
import interfaces.IVehiculo; // porque vamos a crear recibir variables de parámetro tipo IVehiculo

public class Lista implements ILista { //la clase lista debe hacer lo que diga el contrato de ILista!!
	
	// la lista contendrá nodos, que guardarán vehículos -->
	// atributos:
	private INodo primero;

	public Lista() {
		//super();
		this.primero = null; // cuando creamos la lista no sabemos cual será el primer nodo, por eso lo ponemos en null
	}

	// toString() ->
	@Override
	public String toString() {
		return "Lista [primero=" + primero + "]";
	}

	// getter y setters ->
	public INodo getPrimero() {
		return primero;
	}

	public void setPrimero(INodo primero) {
		this.primero = primero;
	}
	
	// Primitivas de una lista -->
	
	public void insertarPrimero(IVehiculo v) {// recordar que recibimos un vehiculo de tipo IVehiculo desde ahora, que es de cualquier clase que cumple con
		// los métodos de la interfaz Vehiculo!!!
		INodo vehiculoAInsertar = new Nodo(v); // creamos nodo con el vehiculo y con anterior y siguiente en null
		
		// primero verificamos si la lista está vacía o no --->
		if (!estaVacia()) {// si no está vacía -->
			// supongamos que tenemos la lista:
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
			// 								o
			// null <- [Ford, BB] <-> [Toyota, AA] <-> [Fiat, CC] -> null
			// creamos el nodo con el vehiculo a insertar
			// como lo queremos insertar primero -->
			// ahora el anterior a primero no puede ser más null, debe ser el nodo anterior a el que será el nuevo -->
			primero.setAnterior(vehiculoAInsertar); // ahora anterior apunta al nuevo nodo!
			// ahora a vehiculoAInsertar le cambiamos el siguiente con primero, que tiene toda la concatenación de los siguientes nodos
			vehiculoAInsertar.setSiguiente(primero);
			// y cambiamos primero
			primero = vehiculoAInsertar;	
		}else {
			primero = vehiculoAInsertar; // si la lista está vacía --> ponemos que el primer nodo sea el nodo que creamos con el vehículo recibido!!
		}
		
	}
	
	public void insertarUltimo(IVehiculo v) {
		INodo elementoAInsertar = new Nodo(v); // creamos nodo con el vehiculo que queremos 
		// primero verifico si la lista está vacía o no -->
		if (!estaVacia()) {// si no está vacía
			// Supongamos que tenemos la siguiente lista:
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
			
			// si queremos insertar un nodo a lo ultimo -->
			// primero el anterior del nodo que creamos no debe ser null, sino que debe ser el ultimo nodo [anterior=[Toyota,AA], dato=[Fiat,CC], siguiente=null]
			// para eso recorro la lista hasta llegar al último nodo 
			INodo actual = primero; // debe ser INodo actual porque primero es de tipo INodo
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente(); // actualizo actual hasta llegar al ultimo nodo que tiene el dato que nos interesa!
			}
			// cuando salgo del while actual es el nodo que nos interesa 
			// cambio el anterior de mi nodo a insertar por el nodo actual
			elementoAInsertar.setAnterior(actual);
			// y ahora cambio que el siguiente de actual es el nuevo nodo que queremos meter -->
			actual.setSiguiente(elementoAInsertar);

		}else {// la lista está vacía --> el primero es el ultimo 
			primero = elementoAInsertar;
		}
	}
	
	public void insertarGenerico(IVehiculo v, int pos) {// necesitamos recibir el vehiculo a insertar y la posición en la que se desea insertarlo!
		// primero verificamos que:
		if (!estaVacia() && pos>=0 && pos < cantidadElementos()) {// importante verificar que no nos pasemos!->
			if (pos == 0) { // si puso que la pos es cero ya tenemos un método para eso
				insertarPrimero(v);
			}else {
				INodo elementoAInsertar = new Nodo(v);
				// si pos > 0 ->
				// supongamos que tenemos la siguiente lista
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
		//pos						0												 1												   2
				// y se desea agregar v en la pos 1 -->
				//L: null <- [Ford,BB] <-> [Toyota,AA] <-> [Fiat,CC] -> null
				//				0			    1			   2				insertar ["Jeep, DD] en pos (1) -->
				// recorro la lista hasta llegar uno antes del nodo en el que se encuentra la posición 
				int contador = 0;
				INodo actual = primero;
				while (contador < pos - 1) {// quiero llegar al nodo anterior al nodo que se encuentra en pos!!!
					actual = actual.getSiguiente();
					contador++;
				}
				// cuando salgamos del while, actual es el nodo anterior al nodo que se encuentra en pos
				// si quiero poner el nuevo nodo en esa posición entonces dicho nodo debe tener como anterior actual ya que actual es el nodo que se encuentra
				// en una posición atrás de la posición indicada -->
				elementoAInsertar.setAnterior(actual);
				// luego como siguiente debe tener todo lo que le sigue a actual 
				elementoAInsertar.setSiguiente(actual.getSiguiente());
				// y también el anterior de [Toyota,AA] deja de ser [Ford,BB] y pasa a ser el nodo que vamos a poner, ya que irá en su posición
				// y [Toyota,AA] se desplaza a la derecha -->
				actual.getSiguiente().setAnterior(elementoAInsertar);
				// ahora lo ponemos en la posición indicada 
				actual.setSiguiente(elementoAInsertar);
			}
		}else {
			System.out.println("Error");
		}
		
	}
	
	public IVehiculo eliminarPrimero() {// queremos retornar el vehiculo del nodo a eliminar
		// verificamos si la lista está vacía -->
		if (!estaVacia()) {// si no lo está
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
			// queremos eliminar el primer nodo de la lista
			// pero antes de hacerlo, el que pasa a ser primero debe tener como anterior null ->
			primero.getSiguiente().setAnterior(null);
			// recuperamos vehiculo antes de eliminarlo
			IVehiculo vehiculoAEliminar = primero.getVehiculo();
			// ahora elimino primero ->
			primero = primero.getSiguiente();
			return vehiculoAEliminar;
		}else {//la lista está vacía
			return null; // null porque funciona con todo tipo de variable!!
		}
	}
	
	public IVehiculo eliminarUltimo() {
		// primero verificamos si la lista está vacía o no
		if (!estaVacia()) {// si no está vacía -->
			// verificamos si solo hay un nodo en la lista -->
			if (primero.getSiguiente() == null) {
				IVehiculo elementoAEliminar = primero.getVehiculo();
				primero = null;
				return elementoAEliminar;
			}else {// hay más de un nodo -->
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
				// para eliminar el último nodo, recorro la lista hasta llegar al nodo detrás del mismo -->
				INodo actual = primero;
				while (actual.getSiguiente().getSiguiente() != null) {// si tengo 12, siguiente --> 13, siguiente ---> 14, siguiente---> null, 
					// recién cuando estoy en 13, estaré detrás del nodo que tiene como dato 14 y siguiente null, es por eso que vamos de a dos siguientes 
					actual = actual.getSiguiente(); // avanzo uno 		
				}
				// cuando salga del while, actual recién ahí es el nodo que está detras del nodo que tiene como atributo siguiente igual a null -->
				// recuperamos dato a eliminar 
				IVehiculo elementoAEliminar = actual.getSiguiente().getVehiculo();
				// ahora actual debe apuntar a null, ya que actual será el nuevo último nodo --> eliminamos el ultimo
				actual.setSiguiente(null);
				
				return elementoAEliminar;
			}
			
		}else {
			return null;
		}
		
	}
	
	@Override
	public IVehiculo eliminarGenerico(int pos) {
		// verificamos si la lista está vacía o si la posición es inválida
	    if (estaVacia() || pos < 0 || pos >= cantidadElementos()) {
	        System.out.println("No se puede eliminar: posición inválida o lista vacía.");
	        return null;
	    }

	    // si la posición es 0, usamos directamente eliminarPrimero()
	    if (pos == 0) {
	        return eliminarPrimero();
	    }
	    
	    INodo actual = primero; 
	    int contador = 0;

	    while (contador < pos) {
	        actual = actual.getSiguiente();
	        contador++;
	    }
	    // guardamos los nodos anterior y siguiente al que queremos eliminar
	    INodo anterior = actual.getAnterior();
	    INodo siguiente = actual.getSiguiente();

	    // si hay un nodo anterior, lo conectamos con el siguiente
	    if (anterior != null) {
	        anterior.setSiguiente(siguiente);
	    }
	    // si hay un nodo siguiente, lo conectamos con el anterior
	    if (siguiente != null) {
	        siguiente.setAnterior(anterior);
	    }
	    // retornamos vehiculo eliminado
	    return actual.getVehiculo();
	}

	
	public IVehiculo obtenerPrimero() {
		// primero me fijo si la lista está vacía
		if (!estaVacia()) {// si no lo está -->
			// supongamos que tenemos la siguiente lista -->
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
			// recupero el dato del primero -->
			return primero.getVehiculo();
		}else {
			return null;
		}
	}
	
	public IVehiculo obtenerUltimo() {
		// primero me fijo si la lista está vacía -->
		if (!estaVacia()) {// si no lo está 
			// supongamos que tenemos la siguiente lista -->
		//L:[anterior=null, dato=[Ford,BB], siguiente=[anterior=[Ford,BB], dato=[Toyota,AA], siguiente=[anterior=[Toyota,AA], dato=[Fiat, CC], siguiente=null]]]
			// recorro la lista hasta llegar al nodo que tiene como siguiente null ->
			INodo actual = primero;
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			// cuando salgamos del while, actual será el nodo que tenga como siguiente null -->
			return actual.getVehiculo();		
		}else {
			return null;
		}
	}
	
	
	public IVehiculo obtenerGenerico(int pos) {
	    if (estaVacia() || pos < 0 || pos >= cantidadElementos()) {
	        System.out.println("Posición inválida o lista vacía.");
	        return null;
	    }

	    INodo actual = primero;
	    int contador = 0;

	    while (contador < pos) {
	        actual = actual.getSiguiente();
	        contador++;
	    }

	    return actual.getVehiculo(); // vehiculo encontrado
	}


	// Métodos extra -->
	
	public boolean estaVacia() {
		return if (primero == null);
	}
	
	public int cantidadElementos() {
		int cantidad = 0;
		if (estaVacia()) {
			return cantidad;
		} else {
			INodo actual = primero;
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				cantidad++;
			}
			return cantidad + 1;
		}
	}
	
	

	public void mostrar() {
	    INodo actual = primero;

	    while (actual != null) { 
	        System.out.println(actual.getVehiculo());
	        actual = actual.getSiguiente();
	    }
	}

	
	public int buscar(IVehiculo v) {
	    if (estaVacia()) {
	        return -1;
	    }

	    INodo actual = primero;
	    int posicion = 0;

	    while (actual != null) {
	        IVehiculo actualVehiculo = actual.getVehiculo(); // obtenemos vehiculo del nodo

	        if (actualVehiculo.getMarca().equals(v.getMarca()) && // comparamos marca y patente
	            actualVehiculo.getPatente().equals(v.getPatente())) {
	            return posicion;
	        }

	        actual = actual.getSiguiente();
	        posicion++;
	    }

	    return -1; // No se encontró
	}

}
