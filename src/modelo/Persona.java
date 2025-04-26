package modelo;

import interfaces.IPersona;
import interfaces.ILista;

public class Persona implements IPersona {
    private String nombre;
    private String apellido;
    private ILista lista;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lista = null; // Inicializamos la lista como null
    }
    

    public Persona(String nombre, String apellido, ILista lista) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lista = lista;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public void asignarLista(ILista lista) {
        this.lista = lista;
    }

    @Override
    public ILista getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", lista=" + lista + "]";
    }
}
