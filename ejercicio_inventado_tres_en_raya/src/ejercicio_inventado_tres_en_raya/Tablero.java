package ejercicio_inventado_tres_en_raya;

public class Tablero {

	private Celda [][] tablero;
	
	int limiteOpcionInferior = 1;
	int limiteOpcionSuperior = 3;
	
	public Tablero(int posicionFila, int posicionColumna) {
		
		tablero = new Celda [posicionFila][posicionColumna];
	}
	
	//Comprueba que el usuario haya introducido una posición válida.
	public boolean comprobarNumeroUsuario(int posicion) {
		
		if(posicion < limiteOpcionInferior || posicion > limiteOpcionSuperior) {
			
			return false;
		} else {
			
			for(int c = 0; c < limiteOpcionSuperior; c++) {
				
				tablero[][]
			}
			return true;
		}
	}
	
	public boolean comprobarEstadoCelda() {
		
		if() {
			
			
		}
	}
	
	public void imprimirTablero() {
		
		System.out.println("  1   2   3\n-------------\n|   |   |   | 1\n-------------\n|   |   |   | 2\n-------------\n|   |   |   | 3\n-------------");
	}
}
