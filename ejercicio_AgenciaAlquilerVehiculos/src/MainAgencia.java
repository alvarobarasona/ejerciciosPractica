import java.util.Scanner;

public class MainAgencia {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuál es el nombre de la agencia?:");
		String nombreAgencia = sc.nextLine();
		
		System.out.println("¿Cuál es el número máximo de clientes?:");
		int numeroClientesMaximo = sc.nextInt();
		
		System.out.println("¿Cuál es el número máximo de vehículos?:");
		int numeroVehiculosMaximo = sc.nextInt();
		
		AgenciaAlquilerVehiculos agencia = new AgenciaAlquilerVehiculos(nombreAgencia, numeroClientesMaximo, numeroVehiculosMaximo);
		
		int opcionMenu;
		int informacionAgencia = 1;
		int salir = 6;
		
		do {
			agencia.MenuAgencia();
			opcionMenu = sc.nextInt();
			sc.nextLine();
			
			while(opcionMenu < informacionAgencia || opcionMenu > salir) {
				
				agencia.MenuAgencia();
				opcionMenu = sc.nextInt();
				sc.nextLine();
			}
			
			switch(opcionMenu) {
			
			case 1:
				System.out.println(agencia);
				break;
			case 2:
				System.out.println("2. Añadir cliente\nIntroduce el nombre del cliente:");
				String nombreCliente = sc.nextLine();
				
				System.out.println("Introduce el apellido del cliente:");
				String apellidoCliente = sc.nextLine();
				
				agencia.anadirCliente(nombreCliente, apellidoCliente);
				break;
			case 3:
				System.out.println("3. Añadir vehículo\nIntroduce la marca del vehículo:");
				String marcaVehiculo = sc.nextLine();
				
				System.out.println("Introduce el modelo del vehículo:");
				String modeloVehiculo = sc.nextLine();
				
				agencia.anadirVehiculo(marcaVehiculo, modeloVehiculo);
				break;
			case 4:
				System.out.println("4. Alquilar vehículo\nIntroduce la posición del cliente:");
				int posicionAlquilerCliente = sc.nextInt();
				
				System.out.println("Introduce la posición del vehículo:");
				int posicionAlquilerVehiculo = sc.nextInt();
				
				agencia.alquilarVehiculo(posicionAlquilerCliente, posicionAlquilerVehiculo);
				break;
			case 5:
				System.out.println("5. Devolver vehículo\nIntroduce la posición del cliente:");
				int posicionDevolucionCliente = sc.nextInt();
				
				agencia.devolverVehiculo(posicionDevolucionCliente);
				break;
			case 6:
				System.out.println("¡Nos vemos pronto!");
			}
		} while (opcionMenu != salir);
		
		sc.close();
	}
}
