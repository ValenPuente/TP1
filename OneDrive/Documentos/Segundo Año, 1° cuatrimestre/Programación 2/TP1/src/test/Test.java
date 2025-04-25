package test;

import modelo.Vehiculo;

public class Test {

	public static void main(String[] args) {
		Vehiculo v1 = new Vehiculo("Toyota", "AA");
		Vehiculo v2 = new Vehiculo("Toyota", "AA"); 
		
		if (v1.equals(v2)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}

}
