package test;

import modelo.Vehiculo;
import modelo.Lista;

import interfaces.ILista;
import interfaces.IVehiculo;

public class TestListaDoble {

	public static void main(String[] args) {
		// creamos un vehiculo -->
		IVehiculo v1 = new Vehiculo("Toyota", "AA");
		IVehiculo v2 = new Vehiculo("Fiat", "BB");
		// creamos una lista doble -->
		ILista l = new Lista();
		
		// probamos estaVacia() ->
		System.out.println(l.estaVacia()); // debe devolver True
		
		//probamos insertarPrimero-->
		l.insertarPrimero(v1);
		l.insertarPrimero(v2);
		System.out.println(l);
		
		// probamos insertarUltimo -->
		IVehiculo v3 = new Vehiculo("Jeep", "DD");
		l.insertarUltimo(v3);
		System.out.println(l);
		
		// probamos cantidadElementos() -
		System.out.println("Cantidad de elementos de la lista es de: " + l.cantidadElementos());
		
		// probamos insertarGenerico()-
		IVehiculo v4 = new Vehiculo("Ferrari", "EE");
		l.insertarGenerico(v4, 1);
		System.out.println(l);

		// probamos eliminarPrimero() 
		l.eliminarPrimero();
		System.out.println(l);
		
		// probamos eliminarUltimo()
		l.eliminarUltimo();
		System.out.println(l);

		// probamos eliminarGenerico()
		
		// probamos obtenerPrimero()
		System.out.println("El primer vehiculo de la lista es: " + l.obtenerPrimero());
		
		// probamos obtenerUltimo()
		System.out.println("El ultimo vehiculo de la lista es: " + l.obtenerUltimo());




		

		
		
		
	}

}
