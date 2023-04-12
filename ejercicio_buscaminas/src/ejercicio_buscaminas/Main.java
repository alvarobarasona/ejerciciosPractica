package ejercicio_buscaminas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numeroMinimoFilas = 1;
		int numeroFilas = 8;
		int numeroMinimoColumnas = 1;
		int numeroColumnas = 8;
		int contadorTurno = 1;
		
		Tablero tablero = new Tablero(numeroFilas, numeroColumnas);
		
		System.out.println("Bienvenido al juego del buscaminas");
		
		tablero.rellenarTablero(numeroFilas, numeroColumnas);
		tablero.asignarNumero(numeroFilas, numeroColumnas);
		tablero.imprimirTablero();
		
		int posicionFila;
		int posicionColumna;

		do {
			do {
				
				System.out.println("Introduce una posición de la fila(De 1 a 8):");
				posicionFila = sc.nextInt();
			} while(posicionFila < numeroMinimoFilas || posicionFila > numeroFilas);

			while(tablero.comprobarFilaValida(posicionFila, numeroColumnas) == false) {
				
				do {
					
					System.err.println("No se puede seleccionar esta fila. Introduce otro número de fila(De 1 a 8):");
					posicionFila = sc.nextInt();
				} while(posicionFila < numeroMinimoFilas || posicionFila > numeroFilas);
			}
			
			do {
				
				System.out.println("Introduce una posición de la columna(De 1 a 8):");
				posicionColumna = sc.nextInt();
			} while(posicionColumna < numeroMinimoColumnas || posicionColumna > numeroColumnas);
			
			while(tablero.comprobarCeldaValida(posicionFila, posicionColumna) == false) {
				
				do {
					
					System.err.println("Posición no válida. Introduce otra posición de la columna(De 1 a 8):");
					posicionColumna = sc.nextInt();
				} while(posicionColumna < numeroMinimoColumnas || posicionColumna > numeroColumnas);
			}
			
			if(tablero.comprobarBomba(posicionFila, posicionColumna, numeroFilas, numeroColumnas, contadorTurno) == true) {
				
				System.out.println("HAS PERDIDO");
				tablero.mostrarBombas(numeroFilas, numeroColumnas);
				tablero.imprimirTablero();
			} else {
				
				tablero.imprimirTablero();
				contadorTurno++;
			}	
		} while(tablero.comprobarBomba(posicionFila, posicionColumna, numeroFilas, numeroColumnas, contadorTurno) == false); 
	}
}