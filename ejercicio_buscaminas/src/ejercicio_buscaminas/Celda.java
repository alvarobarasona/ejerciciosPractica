package ejercicio_buscaminas;

public class Celda {

	private String estado;
	private boolean visible;
	
	public Celda(String estado, boolean visible) {
		
		this.estado = estado;
		this.visible = visible;
	}
	
	public void setEstado(String estado) {
		
		this.estado = estado;
	}
	
	public String getEstado() {
		
		return estado;
	}
	
	public void setVisible(boolean visible) {
		
		this.visible = visible;
	}
	
	public boolean getVisible() {
		
		return visible;
	}
}
