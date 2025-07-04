package interfaces;
// no es necesario importar IVehiculo ya que están en el mismo paquete
public interface ILista {

	public void insertarPrimero(IVehiculo v1);

	public boolean estaVacia();

	public void insertarUltimo(IVehiculo v3);
	
	public void insertarGenerico(IVehiculo v, int pos);

	public int cantidadElementos();
	
	public IVehiculo eliminarPrimero();
	
	public IVehiculo eliminarUltimo();

	public IVehiculo eliminarGenerico(int pos);
	
	public IVehiculo obtenerPrimero();

	public IVehiculo obtenerUltimo();
	
	public IVehiculo obtenerGenerico(int pos);

	public void mostrar();
	
	public int buscar(IVehiculo v);
	
	

}
