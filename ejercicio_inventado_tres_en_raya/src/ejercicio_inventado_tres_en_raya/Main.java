package ejercicio_inventado_tres_en_raya;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numeroFilas = 3;
		int numeroColumnas = 3;
		int respuestaUsuario;
		Tablero tablero = new Tablero(numeroFilas, numeroColumnas);
		System.out.println("Bienvenido al juego del tres en raya\n");
		System.out.println("Introduce el nombre del jugador 1:");
		String nombreJugador1 = sc.nextLine();
		
		System.out.println("Introduce el nombre del jugador 2:");
		String nombreJugador2 = sc.nextLine();

		do {
			int contadorJugador = 0;
			tablero.rellenarTablero();
			tablero.imprimirTablero();
			do {
				
				int posicionFila;
				int posicionColumna;
				
				if(contadorJugador % 2 == 0) {
					
					System.out.println("TURNO DE " + nombreJugador1 + ".\r\nIntroduce la posición de la fila(Del 1 al 3):");
					posicionFila = sc.nextInt();
					
					while(tablero.comprobarNumeroUsuario(posicionFila) == false) {
						
						System.err.println("ERROR. Número de fila inválido. Vuelve a introducir el número de la fila:");
						posicionFila = sc.nextInt();
					}
					
					while(tablero.comprobarFilaValida(posicionFila) == false) {
						
						System.err.println("ERROR. La fila seleccionada no tiene hueco para añadir una columna. Vuelve a introducir el número de fila:");
						posicionFila = sc.nextInt();
					}
					if(tablero.comprobarFilaValida(posicionFila) == true) {
						
						System.out.println("Introduce la posición de la columna(Del 1 al 3):");
						posicionColumna = sc.nextInt();
						
						while(tablero.comprobarNumeroUsuario(posicionColumna) == false) {
							
							System.err.println("ERROR. Número de columna inválido. Vuelve a introducir el número de la columna:");
							posicionColumna = sc.nextInt();
						}
						
						while(tablero.comprobarEstadoCelda(posicionFila, posicionColumna) == false) {
							
							System.err.println("ERROR. La posición seleccionada ya está ocupada. Introduce otro número de la columna:");
							posicionColumna = sc.nextInt();
						}
						if(tablero.comprobarEstadoCelda(posicionFila, posicionColumna) == true) {
							
							tablero.aniadirValorCelda(contadorJugador, posicionFila, posicionColumna);
						}
					}
				}
				if(contadorJugador % 2 != 0) {
					
					System.out.println("TURNO DE " + nombreJugador2 + ".\r\nIntroduce la posición de la fila(Del 1 al 3):");
					posicionFila = sc.nextInt();
					
					while(tablero.comprobarNumeroUsuario(posicionFila) == false) {
						
						System.err.println("ERROR. Número de fila inválido. Vuelve a introducir el número de la fila(Del 1 al 3):");
						posicionFila = sc.nextInt();
					}
					
					while(tablero.comprobarFilaValida(posicionFila) == false) {
						
						System.err.println("ERROR. La fila seleccionada no tiene hueco para añadir una columna. Vuelve a introducir el número de fila:");
						posicionFila = sc.nextInt();
					}
					if(tablero.comprobarFilaValida(posicionFila) == true) {
						
						System.out.println("Introduce la posición de la columna(Del 1 al 3):");
						posicionColumna = sc.nextInt();
						
						while(tablero.comprobarNumeroUsuario(posicionColumna) == false) {
							
							System.err.println("ERROR. Número de columna inválido. Vuelve a introducir el número de la columna(Del 1 al 3):");
							posicionColumna = sc.nextInt();
						}
						
						while(tablero.comprobarEstadoCelda(posicionFila, posicionColumna) == false) {
							
							System.err.println("ERROR. La posición seleccionada ya está ocupada. Introduce otro número de la columna:");
							posicionColumna = sc.nextInt();
						}
						if(tablero.comprobarEstadoCelda(posicionFila, posicionColumna) == true) {
							
							tablero.aniadirValorCelda(contadorJugador, posicionFila, posicionColumna);
						}
					}
				}
				switch(tablero.comprobarGanador()) {
				
					case 1:
						System.out.println("¡ENHORABUENA. " + nombreJugador1 + " ha ganado!\n");
						break;
					case 2:
						System.out.println("¡ENHORABUENA. " + nombreJugador2 + " ha ganado!\n");
						break;
					case 3:
						if(tablero.comprobarEmpate() == true) {
							
							System.out.println("¡EMPATE!\n");
						}
				}
				
				contadorJugador++;
			} while(tablero.comprobarGanador() != 1 && tablero.comprobarGanador() != 2 && tablero.comprobarEmpate() == false);
		
			do {
				System.out.println("¿Quieres volver a jugar? Para SI pulsa 1. Para NO pulsa 2");
				respuestaUsuario = sc.nextInt();
			} while(respuestaUsuario < 1 || respuestaUsuario > 2);
			
			if(respuestaUsuario == 1) {
				
				tablero.reiniciarTablero();
			}	
		} while(respuestaUsuario == 1);
		
		System.out.println("¡Hasta la próxima!");
		
		sc.close();
	}	
}
