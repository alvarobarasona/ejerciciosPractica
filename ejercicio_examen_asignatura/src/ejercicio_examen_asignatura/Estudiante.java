package ejercicio_examen_asignatura;

public class Estudiante {

	private String nombreEstudiante;
	private String apellidoEstudiante;
	private int niaEstudiante;
	
	public Estudiante(String nombreEstudiante, String apellidoEstudiante, int niaEstudiante) {
		
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.niaEstudiante = niaEstudiante;
	}
	
	public void setNombreEstudiante(String nombreEstudiante) {
		
		this.nombreEstudiante = nombreEstudiante;
	}
	
	public String getNombreEstudiante(String apellidoEstudiante) {
		
		return nombreEstudiante;
	}
	
	public void setApellidoEstudiante(String apellidoEstudiante) {
		
		this.apellidoEstudiante = apellidoEstudiante;
	}
	
	public String getApellidoEstudiante() {
		
		return apellidoEstudiante;
	}
	
	public void setNiaEstudiante(int niaEstudiante) {
		
		this.niaEstudiante = niaEstudiante;
	}
	
	public int getNiaEstudiante() {
		
		return niaEstudiante;
	}
	
	public String toString() {
		
		String infoEstudiante = niaEstudiante + "(" + nombreEstudiante + " " + apellidoEstudiante + ")";
		return infoEstudiante;
	}
}
