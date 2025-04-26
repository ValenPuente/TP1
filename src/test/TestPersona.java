package test;

import interfaces.IPersona;
import interfaces.ILista;
import interfaces.IVehiculo;
import modelo.Lista;
import modelo.Vehiculo;
import modelo.Persona;

public class TestPersona {

    public static void main(String[] args) {
        // creamos un vehiculo -->
        IVehiculo v1 = new Vehiculo("Toyota", "AA");
        IVehiculo v2 = new Vehiculo("Fiat", "BB");
        // creamos una lista doble -->
        ILista l = new Lista();
    
        //probamos insertarPrimero-->
        l.insertarPrimero(v1);
        l.insertarPrimero(v2);

        IVehiculo v3 = new Vehiculo("Jeep", "DD");
        IVehiculo v4 = new Vehiculo("Ferrari", "EE");

        ILista l2 = new Lista();
        l2.insertarPrimero(v3);
        l2.insertarPrimero(v4);

        IPersona p1 = new Persona("Valentin", "Puente", l);
        IPersona p2 = new Persona("Salvador", "Piccin", l2);

        System.out.println(p1);
        System.out.println("\n\n" + p2);

    }
}
