public class Cliente {

	private String nombreCliente;
	private String apellidoCliente;
	private Integer posicionVehiculoAlquilado;
	
	public Cliente(String nombreCliente, String apellidoCliente) {
		
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
	}

	public Integer getPosicionVehiculoAlquilado() {
		
		return posicionVehiculoAlquilado;
	}

	public void setPosicionVehiculoAlquilado(Integer posicionVehiculoAlquilado) {
		
		this.posicionVehiculoAlquilado = posicionVehiculoAlquilado;
	}
	
	public String toString() {
		
		String infoCliente = nombreCliente + " " + apellidoCliente;
		return infoCliente;
	}
}
