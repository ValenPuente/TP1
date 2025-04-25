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
		System.out.println("-------------------------------------");
		
		
		//probamos insertarPrimero-->
		l.insertarPrimero(v1);
		l.insertarPrimero(v2);
		System.out.println(l);
		System.out.println("-------------------------------------");
		
		
		// probamos insertarUltimo -->
		IVehiculo v3 = new Vehiculo("Jeep", "DD");
		l.insertarUltimo(v3);
		System.out.println(l);
		
		
		// probamos cantidadElementos() -
		System.out.println("Cantidad de elementos de la lista es de: " + l.cantidadElementos());
		System.out.println("-------------------------------------");
		
		
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
		System.out.println("-------------------------------------");
		
		
		// probamos obtenerPrimero()
		System.out.println("El primer vehiculo de la lista es: " + l.obtenerPrimero());
		
		
		// probamos obtenerUltimo()
		System.out.println("El ultimo vehiculo de la lista es: " + l.obtenerUltimo());
		System.out.println("-------------------------------------");

		
		// probamos mostrar()
		l.mostrar();
		System.out.println("-------------------------------------");

		
		// probamos obtenerGenerico()
		System.out.println("Elemento en posición 1: " + l.obtenerGenerico(1));
		System.out.println("-------------------------------------");
		
		
		// probamos buscar()
		// mostramos la posicion del vehiculo que coincida con la marca y la patente
		System.out.println(l);
		int pos = l.buscar(new Vehiculo("Toyota", "AA")); // creamos un nuevo objeto en memoria para usarlo como referencia y compararlo con los de la lista 
		System.out.println("Vehiculo encontrado en posición: " + pos);
		System.out.println("-------------------------------------");
		
		
		// probamos eliminarGenerico()
		// insertamos mas vehiculos 
		l.insertarUltimo(v2);
		l.insertarUltimo(v3);
		// Mostramos la lista actual
		System.out.println(l); 
		
		IVehiculo eliminado = l.eliminarGenerico(2); // Eliminamos el vehículo v2 que esta en la tercera pocision (vehiculo: Fiat, patente: BB)
		System.out.println("Vehículo eliminado: " + eliminado);
		System.out.println("Lista después de eliminar:");
		System.out.println(l);

		

		
		
		
	}

}
