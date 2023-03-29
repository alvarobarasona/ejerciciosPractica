package ejercicio_inventado_tres_en_raya;

public class Celda {

	private String estado;
	
	//String castEstado = Character.toString(estado);
	
	public Celda(String estado) {
		
		this.estado = estado;
	}
	
	public void setEstadoCelda(String estado) {
		
		this.estado = estado;
	}
	
	public String getEstadoCelda() {

		return estado;
	}
	
	public String toString() {
		
		String estadoCelda = estado;
		
		return estadoCelda;
	}
}
