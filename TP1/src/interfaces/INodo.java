package interfaces;

public interface INodo {
	
	public String toString();
	
	public IVehiculo getVehiculo();

	public void setVehiculo(IVehiculo vehiculo);
	
	public INodo getSiguiente();
	
	public void setSiguiente(INodo siguiente);

	public INodo getAnterior();

	public void setAnterior(INodo anterior);
	
	
}

	

