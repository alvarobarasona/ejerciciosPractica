package ejercicio_inventado_tres_en_raya;

public class Tablero {

	private Celda [][] tablero;
	
	int diferenciaArray;
	int limiteOpcionInferior;
	int limiteOpcionSuperior;
	int totalCeldas;
	
	public Tablero(int posicionFila, int posicionColumna) {
		
		tablero = new Celda [posicionFila][posicionColumna];
		diferenciaArray = 1;
		limiteOpcionInferior = 1;
		limiteOpcionSuperior = 3;
		totalCeldas = 9;
	}
	
	//Comprueba que el usuario haya introducido una posición válida.
	public boolean comprobarNumeroUsuario(int posicion) {
		
		if(posicion < limiteOpcionInferior || posicion > limiteOpcionSuperior) {
			
			return false;
		} else {

			return true;
		}
	}
	
	//Comprueba si en la fila introducida inicialmente queda algún hueco en una de sus columnas.
	public boolean comprobarFilaValida(int posicionFila) {
		
		int contador = 0;
		
		for(int c = 0; c < limiteOpcionSuperior; c++) {
			
			if(!tablero[posicionFila - diferenciaArray][c].getEstadoCelda().equals(" ")) {
				
				contador++;
			}	
		}	
		if(contador == limiteOpcionSuperior) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Comprueba si la celda seleccionada al introducir el eje X y el eje Y está vacía o no.
	public boolean comprobarEstadoCelda(int posicionFila, int posicionColumna) {
		
		if(!tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].getEstadoCelda().equals(" ")) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Setea el estado de la celda a 'X' o 'O' dependiendo del contador del main, e imprime el tablero con la celda introducida por el usuario.
	public void aniadirValorCelda(int contadorJugador, int posicionFila, int posicionColumna) {
		
		if(contadorJugador % 2 == 0) {
			
			tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].setEstadoCelda("X");
		} else {
			
			tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].setEstadoCelda("O");
		}
		imprimirTablero();
	}
	
	//Comprueba tras haber introducido uno de los usuario su celda todas las posibilidades para ganar. 
	public int comprobarGanador() {
		
		if((tablero[0][0].getEstadoCelda().equals("X") && tablero[0][1].getEstadoCelda().equals("X") && tablero[0][2].getEstadoCelda().equals("X"))
		|| (tablero[1][0].getEstadoCelda().equals("X") && tablero[1][1].getEstadoCelda().equals("X") && tablero[1][2].getEstadoCelda().equals("X"))
		|| (tablero[2][0].getEstadoCelda().equals("X") && tablero[2][1].getEstadoCelda().equals("X") && tablero[2][2].getEstadoCelda().equals("X"))
		|| (tablero[0][0].getEstadoCelda().equals("X") && tablero[1][0].getEstadoCelda().equals("X") && tablero[2][0].getEstadoCelda().equals("X"))
		|| (tablero[0][1].getEstadoCelda().equals("X") && tablero[1][1].getEstadoCelda().equals("X") && tablero[2][1].getEstadoCelda().equals("X"))
		|| (tablero[0][2].getEstadoCelda().equals("X") && tablero[1][2].getEstadoCelda().equals("X") && tablero[2][2].getEstadoCelda().equals("X"))
		|| (tablero[0][0].getEstadoCelda().equals("X") && tablero[1][1].getEstadoCelda().equals("X") && tablero[2][2].getEstadoCelda().equals("X"))
		|| (tablero[0][2].getEstadoCelda().equals("X") && tablero[1][1].getEstadoCelda().equals("X") && tablero[2][0].getEstadoCelda().equals("X"))) {
			
			return 1;
		} else {
			
			if((tablero[0][0].getEstadoCelda().equals("O") && tablero[0][1].getEstadoCelda().equals("O") && tablero[0][2].getEstadoCelda().equals("O"))
			|| (tablero[1][0].getEstadoCelda().equals("O") && tablero[1][1].getEstadoCelda().equals("O") && tablero[1][2].getEstadoCelda().equals("O"))
			|| (tablero[2][0].getEstadoCelda().equals("O") && tablero[2][1].getEstadoCelda().equals("O") && tablero[2][2].getEstadoCelda().equals("O"))
			|| (tablero[0][0].getEstadoCelda().equals("O") && tablero[1][0].getEstadoCelda().equals("O") && tablero[2][0].getEstadoCelda().equals("O"))
			|| (tablero[0][1].getEstadoCelda().equals("O") && tablero[1][1].getEstadoCelda().equals("O") && tablero[2][1].getEstadoCelda().equals("O"))
			|| (tablero[0][2].getEstadoCelda().equals("O") && tablero[1][2].getEstadoCelda().equals("O") && tablero[2][2].getEstadoCelda().equals("O"))
			|| (tablero[0][0].getEstadoCelda().equals("O") && tablero[1][1].getEstadoCelda().equals("O") && tablero[2][2].getEstadoCelda().equals("O"))
			|| (tablero[0][2].getEstadoCelda().equals("O") && tablero[1][1].getEstadoCelda().equals("O") && tablero[2][0].getEstadoCelda().equals("O"))) {
				
				return 2;
			} else {
				
				return 3;
			}
		}
	}
	//Comprueba si ha habido un empate.
	public boolean comprobarEmpate() {
		
		int contador = 0;
		
		for(int f = 0; f < limiteOpcionSuperior; f++) {
			for(int c = 0; c < limiteOpcionSuperior; c++) {
				
				if(!tablero[f][c].getEstadoCelda().equals(" ")) {
					
					contador++;
				}
			}
		}

		if(contador == totalCeldas) {

			return true;
		} else {
			
			return false;
		}
	}
	
	//Si se quiere volver a jugar otra partida, restablece el valor de las celdas a null.
	public void reiniciarTablero() {
		
		for(int f = 0; f < limiteOpcionSuperior; f++) {
			for(int c = 0; c < limiteOpcionSuperior; c++) {
				
				if(tablero[f][c] != null) {
					
					tablero[f][c] = null;
				}
			}
		}
	}
	
	//Todas las posiciones de la matriz que sean null las rellena con un espacio(' ').
	public void rellenarTablero() {
		
		for(int f = 0; f < limiteOpcionSuperior; f++) {
			for(int c = 0; c < limiteOpcionSuperior; c++) {
				
				if(tablero[f][c] == null) {
					
					tablero[f][c] = new Celda(" ");
				}
			}	
		}
	}
	
	//Imprime el tablero.
	public void imprimirTablero() {
		
		System.out.println("  1   2   3\n-------------\n| " + tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + " | 1\n-------------\n| "
		+ tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + " | 2\n-------------\n| " + tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2]
		+ " | 3\n-------------");
	}
}
