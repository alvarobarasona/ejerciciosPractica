package herencia;

public class Estudiante extends Persona{

	private int numeroEstudiante;
	private String nombreEstudios;
	
	public Estudiante(String nombre, String apellido, int edad, int numeroEstudiante, String nombreEstudios) {
		
		super(nombre, apellido, edad);
		this.numeroEstudiante = numeroEstudiante;
		this.nombreEstudios = nombreEstudios;
	}
	
	public void mostrarDatos() {
		
		System.out.println("Nombre alumno: " + getNombre() + "\nApellido alumno: " + getApellido() + "\nEdad alumno: " + getEdad() + "\nNúmero estudiante: " + numeroEstudiante + "\nNombre estudios: " + nombreEstudios);
	}
}
