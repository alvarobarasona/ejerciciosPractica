public class Vehiculo {

	private String marcaVehiculo;
	private String modeloVehiculo;
	private Integer posicionClienteAlquiler;
	
	public Vehiculo(String marcaVehiculo, String modeloVehiculo) {
		
		this.marcaVehiculo = marcaVehiculo;
		this.modeloVehiculo = modeloVehiculo;
	}
	
	public Integer getPosicionClienteAlquiler() {
		
		return posicionClienteAlquiler;
	}
	
	public void setPosicionClienteAlquiler(Integer posicionClienteAlquiler) {
		
		this.posicionClienteAlquiler = posicionClienteAlquiler;
	}
	
	public String toString() {
		
		String infoVehiculo = marcaVehiculo + " " + modeloVehiculo;
		return infoVehiculo;
	}
}
