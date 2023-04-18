package herencia;

public class Trabajador extends Persona{

	private int numeroTrabajador;
	private String nombreTrabajo;
	
	public Trabajador(String nombre, String apellido, int edad, int numeroTrabajador, String nombreTrabajo) {
		
		super(nombre, apellido, edad);
		this.numeroTrabajador = numeroTrabajador;
		this.nombreTrabajo = nombreTrabajo;
	}
	
	public void mostrarDatos() {
		
		System.out.println("Nombre trabajador: " + getNombre() + "\nApellido trabajador: " + getApellido() + "\nEdad trabajador: " + getEdad() + "\nNúmero trabajador: " + numeroTrabajador + "\nNombre trabajo: " + nombreTrabajo);
	}
}
