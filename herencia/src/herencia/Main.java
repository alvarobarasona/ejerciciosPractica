package herencia;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int respuestaUsuario;
		int respuestaContinuar;
		
		do {
			
			do {
				System.out.println("Introduce el tipo de ususario que eres. Si eres alumno, introduce 1. Si eres trabajador, introduce 2:");
				respuestaUsuario = sc.nextInt();
				sc.nextLine();
			} while(respuestaUsuario < 1 || respuestaUsuario > 2);
			
			if(respuestaUsuario == 1) {
				
				System.out.println("Introduce el nombre del estudiante:");
				String nombreEstudiante = sc.nextLine();
				
				System.out.println("Introduce el apellido del estudiante:");
				String apellidoEstudiante = sc.nextLine();
				
				System.out.println("Introduce la edad del estudiante:");
				int edadEstudiante = sc.nextInt();
				
				System.out.println("Inroduce el número de estudiante:");
				int numeroEstudiante = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Introduce el nombre de los estudios:");
				String nombreEstudios = sc.nextLine();
				
				System.out.println();
				
				Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, edadEstudiante, numeroEstudiante, nombreEstudios);
				estudiante.mostrarDatos();
				
				System.out.println();
			} else {
				
				System.out.println("Introduce el nombre del trabajador:");
				String nombreTrabajador = sc.nextLine();
				
				System.out.println("Introduce el apellido del trabajador:");
				String apellidoTrabajador = sc.nextLine();
				
				System.out.println("Introduce la edad del trabajador:");
				int edadTrabajador = sc.nextInt();
				
				System.out.println("Inroduce el número de trabajador:");
				int numeroTrabajador = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Introduce el nombre del trabajo:");
				String nombreTrabajo = sc.nextLine();
				
				System.out.println();
				
				Trabajador trabajador = new Trabajador(nombreTrabajador, apellidoTrabajador, edadTrabajador, numeroTrabajador, nombreTrabajo);
				trabajador.mostrarDatos();
				
				System.out.println();
			}
			do {
				System.out.println("¿Quieres continuar? Para SI pulsa 1. Para NO pulsa 2:");
				respuestaContinuar = sc.nextInt();
			} while(respuestaContinuar < 1 || respuestaContinuar > 2);
		} while(respuestaContinuar == 1);
	}
}
