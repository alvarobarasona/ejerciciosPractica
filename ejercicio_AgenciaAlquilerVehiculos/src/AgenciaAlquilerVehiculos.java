import java.util.Arrays;

public class AgenciaAlquilerVehiculos {

	private String nombreAgencia;
	private Cliente [] cliente;
	private Vehiculo [] vehiculo;
	private int numeroClientesActual;
	private int numeroVehiculosActual;
	private int numeroClientesMaximo;
	private int numeroVehiculosMaximo;
	
	public AgenciaAlquilerVehiculos(String nombreAgencia, int numeroClientesMaximo, int numeroVehiculosMaximo) {
		
		this.nombreAgencia = nombreAgencia;
		this.cliente = new Cliente[numeroClientesMaximo];
		this.vehiculo = new Vehiculo[numeroVehiculosMaximo];
		this.numeroClientesMaximo = numeroClientesMaximo;
		this.numeroVehiculosMaximo = numeroVehiculosMaximo;
	}
	
	public void MenuAgencia() {
		
		System.out.println("Bienvenido al menú de la agencia " + nombreAgencia + ".\nElige una de estas opciones(Del 1 al 6):\n\t1. Información de la agencia"
		+ "\n\t2. Añadir cliente\n\t3. Añadir vehículo\n\t4. Alquilar vehículo\n\t5. Devolver vehículo\n\t6. Salir");
	}
	
	public void anadirCliente(String nombreCliente, String apellidoCliente) {
		
		if(numeroClientesActual >= numeroClientesMaximo) {
			
			System.err.println("ERROR. El cliente " + nombreCliente + " " + apellidoCliente + " no se ha podido añadir correctamente. Límite de clientes alcanzado."
			+ " El número máximo es de " + numeroClientesMaximo + " clientes.\n");
		} else {
			
			cliente[numeroClientesActual] = new Cliente(nombreCliente, apellidoCliente);
			numeroClientesActual++;
		}
	}
	
	public void anadirVehiculo(String marcaVehiculo, String modeloVehiculo) {
		
		if(numeroVehiculosActual >= numeroVehiculosMaximo) {
			
			System.err.println("ERROR. El vehículo " + marcaVehiculo + " " + modeloVehiculo + " no se ha podido añadir correctamente. Límite de vehículos alcanzado."
			+ " El número máximo es de " + numeroVehiculosMaximo + " vehículos.\n");
		} else {
			
			vehiculo[numeroVehiculosActual] = new Vehiculo(marcaVehiculo, modeloVehiculo);
			numeroVehiculosActual++;
		}
	}
	
	public void alquilarVehiculo(int posicionCliente, int posicionVehiculo) {
		
		if(cliente[posicionCliente - 1].getPosicionVehiculoAlquilado() == null) {
			
			if(vehiculo[posicionVehiculo - 1].getPosicionClienteAlquiler() == null) {
				
				cliente[posicionCliente - 1].setPosicionVehiculoAlquilado(posicionVehiculo - 1);
				vehiculo[posicionVehiculo - 1].setPosicionClienteAlquiler(posicionCliente - 1);
				System.out.println("Alquiler realizado con éxito.\n");
			} else {
				
				System.err.println("ERROR. El vehículo de la posición " + posicionVehiculo  + " ya está alquilado.\n");
			}
		} else {
			
			System.err.println("ERROR. El cliente de la posición " + posicionCliente + " ya tiene alquilado un vehículo.\n");
		}
	}
	
	public void devolverVehiculo(int posicionCliente) {
		
		if(cliente[posicionCliente - 1].getPosicionVehiculoAlquilado() != null) {
				
			for(int i = 0; i < vehiculo.length; i++) {
					
				if(vehiculo[i].getPosicionClienteAlquiler() == (posicionCliente - 1)) {
						
					vehiculo[i].setPosicionClienteAlquiler(null);
				}
			}
			cliente[posicionCliente - 1].setPosicionVehiculoAlquilado(null);
				
			System.out.println("Devolución realizada con éxito.\n");
			
		} else {
			
			System.err.println("ERROR. El cliente de la posición " + posicionCliente + " no tiene alquilado ningún vehículo.\n");
		}
	}
	
	public String toString() {
		
		String infoAgencia = "Información de la agencia\nNombre de la agencia: " + nombreAgencia + "\nNúmero de clientes actual: " + numeroClientesActual
		+ "\nNúmero de vehículos actual: " + numeroVehiculosActual + "\nNúmero de clientes máximo: " + numeroClientesMaximo + "\nNúmero de vehículos máximo: " + numeroVehiculosMaximo
		+ "\nLista de clientes:\n" + Arrays.toString(cliente) + "\nLista de vehículos:\n" + Arrays.toString(vehiculo) + "\n";
		
		return infoAgencia;
	}
}
