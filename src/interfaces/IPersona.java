package interfaces;

public interface IPersona {
    public String getNombre();
    public void setNombre(String nombre);
    public String getApellido();
    public void setApellido(String apellido);

    public void asignarLista(ILista lista);
    public ILista getLista();

    public String toString();
}
