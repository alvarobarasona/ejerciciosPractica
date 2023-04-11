package ejercicio_buscaminas;

public class Tablero {

	private Celda [][] tablero;
	
	int diferenciaArray = 1;
	
	public Tablero(int numeroFilas, int numeroColumnas) {
		
		tablero = new Celda [numeroFilas][numeroColumnas];
	}
	
	//Método para imprimir el tablero
	public void imprimirTablero() {
		
		System.out.println("  1   2   3   4   5   6   7   8\n---------------------------------\n"
		+ "| " + imprimirCelda(0, 0) + " | " + imprimirCelda(0, 1) + " | " + imprimirCelda(0, 2) + " | " + imprimirCelda(0, 3) + " | " + imprimirCelda(0, 4) + " | " + imprimirCelda(0, 5) + " | " + imprimirCelda(0, 6) + " | " + imprimirCelda(0, 7) + " | 1\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(1, 0) + " | " + imprimirCelda(1, 1) + " | " + imprimirCelda(1, 2) + " | " + imprimirCelda(1, 3) + " | " + imprimirCelda(1, 4) + " | " + imprimirCelda(1, 5) + " | " + imprimirCelda(1, 6) + " | " + imprimirCelda(1, 7) + " | 2\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(2, 0) + " | " + imprimirCelda(2, 1) + " | " + imprimirCelda(2, 2) + " | " + imprimirCelda(2, 3) + " | " + imprimirCelda(2, 4) + " | " + imprimirCelda(2, 5) + " | " + imprimirCelda(2, 6) + " | " + imprimirCelda(2, 7) + " | 3\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(3, 0) + " | " + imprimirCelda(3, 1) + " | " + imprimirCelda(3, 2) + " | " + imprimirCelda(3, 3) + " | " + imprimirCelda(3, 4) + " | " + imprimirCelda(3, 5) + " | " + imprimirCelda(3, 6) + " | " + imprimirCelda(3, 7) + " | 4\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(4, 0) + " | " + imprimirCelda(4, 1) + " | " + imprimirCelda(4, 2) + " | " + imprimirCelda(4, 3) + " | " + imprimirCelda(4, 4) + " | " + imprimirCelda(4, 5) + " | " + imprimirCelda(4, 6) + " | " + imprimirCelda(4, 7) + " | 5\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(5, 0) + " | " + imprimirCelda(5, 1) + " | " + imprimirCelda(5, 2) + " | " + imprimirCelda(5, 3) + " | " + imprimirCelda(5, 4) + " | " + imprimirCelda(5, 5) + " | " + imprimirCelda(5, 6) + " | " + imprimirCelda(5, 7) + " | 6\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(6, 0) + " | " + imprimirCelda(6, 1) + " | " + imprimirCelda(6, 2) + " | " + imprimirCelda(6, 3) + " | " + imprimirCelda(6, 4) + " | " + imprimirCelda(6, 5) + " | " + imprimirCelda(6, 6) + " | " + imprimirCelda(6, 7) + " | 7\n"
		+ "---------------------------------\n"
		+ "| " + imprimirCelda(7, 0) + " | " + imprimirCelda(7, 1) + " | " + imprimirCelda(7, 2) + " | " + imprimirCelda(7, 3) + " | " + imprimirCelda(7, 4) + " | " + imprimirCelda(7, 5) + " | " + imprimirCelda(7, 6) + " | " + imprimirCelda(7, 7) + " | 8\n"
		+ "---------------------------------");
	}
	
	//Dependiendo del atributo visible de celda, imprimirá un espacio en blanco o el valor que tenga asignado visible
	public String imprimirCelda(int posicionFila, int posicionColumna) {
		
		if(tablero[posicionFila][posicionColumna].getVisible() == false) {
			
			return " ";
		} else {

			return tablero[posicionFila][posicionColumna].getEstado();
		}
	}
	
	//Calcula de forma random si una celda será mina o no.
	public boolean calcularBomba() {
		
		if(Math.random() > 0.8) {
			
			return true;
		} else {
			
			return false;
		}
	}
	
	//Asigna un número al atributo estado de la clase celda mientras que la celda tenga en su estado C, dependiendo de la cantidad de minas que tenga alrededor.
	public void asignarNumero(int numeroFilas, int numeroColumnas) {
		
		for(int f = 0; f < numeroFilas; f++) {
			for(int c = 0; c < numeroColumnas; c++) {
				
				int contadorMinasCercanas = 0;
				String stringContadorMinasCercanas = String.valueOf(contadorMinasCercanas);
				
				if(tablero[f][c].getEstado().equals("C")) {
					if(f == 0) {
						if(c == 0) {
							
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c > 0 && c < 7) {
							
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c == 7) {
							
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
					}
					if(f > 0 && f < 7) {
						
						if(c == 0) {
							
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c > 0 && c < 7) {
							
							if(tablero[f - 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c == 7) {
							
							if(tablero[f - 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f + 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
					}
					if(f == 7) {
						
						if(c == 0) {
							
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c > 0 && c < 7) {
							
							if(tablero[f - 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c + 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
						if(c == 7) {
							
							if(tablero[f - 1][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f - 1][c].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
							if(tablero[f][c - 1].getEstado().equals("X")) {
								
								contadorMinasCercanas++;
							}
						}
					}
					switch(contadorMinasCercanas) {
					
					case 0:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 1:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 2:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 3:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 4:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 5:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 6:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 7:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
						break;
					case 8:
						
						tablero[f][c].setEstado(stringContadorMinasCercanas);
					}
				}
			}
		}
	}
	
	//Si las celdas del tablero están vacías, asigna false al atributo visible de todas las celdas, y asignando X al estado de la celda crea una bomba, mientras que si no es bomba se le asignará C al estado.
	public void rellenarTablero(int numeroFilas, int numeroColumnas) {
		
		int contadorMinas = 0;
		int numeroMaximoMinas = 12;
		
		for(int f = 0; f < numeroFilas; f++) {
			for(int c = 0; c < numeroColumnas; c++) {
				
				if(tablero[f][c] == null) {
					
					if(contadorMinas < numeroMaximoMinas) {
						
						if(calcularBomba() == true) {
							
							tablero[f][c] = new Celda("X", false);
							contadorMinas++;
						} else {
							
							tablero[f][c] = new Celda("C", false);
						}
					} else {
						
						tablero[f][c] = new Celda("C", false);
					}
				}
			}
		}
	}
	
	//Comprueba si queda algún hueco en las columnas de la fila seleccionada.
	public boolean comprobarFilaValida(int posicionFila, int numeroColumnas) {
		
		int contador = 0;
		
		for(int c = 0; c < numeroColumnas; c++) {
			
			if(tablero[posicionFila - diferenciaArray][c].getVisible() == true) {
				
				contador++;
			}
		}
		
		if(contador == numeroColumnas) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Comprueba si la celda seleccionada ya es visible o no.
	public boolean comprobarCeldaValida(int posicionFila, int posicionColumna) {
		
		if(tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].getVisible() == true) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Setea el atributo visible de la celda seleccionada a true.
	public void destaparCelda(int posicionFila, int posicionColumna) {
		
		tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].setVisible(true);
	}
	
	//Si es el primer turno y la celda seleccionada es bomba, la covierte a una celda que no lo sea y recalcula la asignación de números del tablero.
	public boolean comprobarBomba(int posicionFila, int posicionColumna, int numeroFilas, int numeroColumnas, int contadorTurno) {
		
		if(contadorTurno == 1 && tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].getEstado().equals("X")) {
			
			tablero[posicionFila - diferenciaArray][posicionColumna - diferenciaArray].setEstado("C");
			asignarNumero(numeroFilas, numeroColumnas);
			return false;
		}
	}
	
	//Si en el primer turno la celda seleccionada es una bomba, la cambia a una celda que no lo sea y vuelve a recalcular los números asignados de cada celda que no sea bomba, ade
	public void destaparCelda(int posicionFila, int posicionColumna, int numeroFilas, int numeroColumnas, int contadorTurno) {
		
		
		
		if(posicionFila - diferenciaArray == 0) {
			
			if(posicionColumna - diferenciaArray == 0) {
				
				
			}
		}
	}
}
