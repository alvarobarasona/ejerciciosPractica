package ejercicio_inventado_tres_en_raya;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numeroFilas = 3;
		int numeroColumnas = 3;
		int contadorJugador = 0;
		Tablero tablero = new Tablero(numeroFilas, numeroColumnas);
		System.out.println("Bienvenido al juego del tres en raya");
		tablero.imprimirTablero();
		
	
		do {
			
			int posicionFila;
			int posicionColumna;
			
			if(contadorJugador % 2 == 0) {
				
				System.out.println("TURNO DEL JUGADOR 1.\r\tIntroduce la posición de la fila(Del 1 al 3):");
				posicionFila = sc.nextInt();
				
				while(tablero.comprobarNumeroUsuario(posicionFila) == false) {
					
					System.err.println("ERROR. Número de fila inválido. Vuelve a introducir el número de la fila:");
					posicionFila = sc.nextInt();
				}
				
				System.out.println("Introduce la posición de la columna(Del 1 al 3):");
				posicionColumna = sc.nextInt();
				
				while(tablero.comprobarNumeroUsuario(posicionColumna) == false) {
					
					System.err.println("ERROR. Número de columna inválido. Vuelve a introducir el número de la columna:");
					posicionFila = sc.nextInt();
				}
			}
		} while();
	}	
}
