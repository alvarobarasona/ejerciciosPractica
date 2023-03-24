package ejercicio_examen_asignatura;

import java.util.Scanner;

public class MainAsignatura {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nombreAsignatura;
		int numeroMaximoEstudiantes;
		int maximoEstudiantesPermitido = 100;
		int minimoEstudiantesPermitido = 1;
		
		do {
			System.out.println("Introduce el nombre de la asignatura:");
			nombreAsignatura = sc.nextLine();
		} while(nombreAsignatura.isEmpty());
		
		do {
			System.out.println("Introduce el número máximo de estudiantes(No puede ser superior a 100):");
			numeroMaximoEstudiantes = sc.nextInt();
		} while(numeroMaximoEstudiantes < minimoEstudiantesPermitido || numeroMaximoEstudiantes > maximoEstudiantesPermitido);

		Asignatura asignatura = new Asignatura(nombreAsignatura, numeroMaximoEstudiantes);
		
		int opcionMenu;
		int limiteInferiorMenu = 1;
		int limiteSuperiorMenu = 4;
		
		do {
			
			asignatura.Menu(nombreAsignatura);
			opcionMenu = sc.nextInt();
			sc.nextLine();
			
			while(opcionMenu < limiteInferiorMenu || opcionMenu > limiteSuperiorMenu) {
				
				asignatura.Menu(nombreAsignatura);
				opcionMenu = sc.nextInt();
				sc.nextLine();
			}
			
			switch(opcionMenu) {
			
			case 1:
				System.out.println("1. Imprimir detalles de la asignatura\n" + asignatura);
				break;
			case 2:
				System.out.println("2. Añadir estudiante\nIntroduce el nombre del estudiante:");
				String nombreEstudiante = sc.nextLine();
				
				System.out.println("Introduce el apellido del estudiante:");
				String apellidoEstudiante = sc.nextLine();
				
				System.out.println("Introduce el NIA del estudiante:");
				int niaEstudiante = sc.nextInt();
				
				asignatura.anadirEstudiante(nombreEstudiante, apellidoEstudiante, niaEstudiante);
				break;
			case 3:

				System.out.println("3. Añadir nota a un estudiante");
				
				if(asignatura.comprobarSiHayEstudiantes() == false) {
					
					System.err.println("ERROR. No hay estudiantes añadidos al sistema.\n");
				} else {
					
					if(asignatura.comprobarNotasEstudiante() == false) {
						
						System.err.println("ERROR. No quedan huecos en las evaluaciones de los alumnos registrados.\n");
					} else {
						
						int posicionEstudiante;
						
						if(asignatura.comprobarNumeroEstudiantes() == false) {
							
							posicionEstudiante = asignatura.getNumeroActualEstudiantes();
						} else {
							
							posicionEstudiante = sc.nextInt();
							sc.nextLine();
						}
		
						while(asignatura.comprobarPosicionEstudianteValida(posicionEstudiante) == false) {
									
							posicionEstudiante = sc.nextInt();
							sc.nextLine();
						}
								
						int posicionEvaluacion = sc.nextInt();
						sc.nextLine();
								
						while(asignatura.comprobarEstadoPosicionEstudiante(posicionEstudiante, posicionEvaluacion) == false) {
									
							posicionEvaluacion = sc.nextInt();
						}
								
						float nota1;
						float nota2;
						float nota3;
								
						do {
							System.out.println("Introduce la nota del primer exámen del estudiante " + posicionEstudiante + " en la evaluación " + posicionEvaluacion + " (De 0 a 10):");
							nota1 = sc.nextFloat();
						} while(nota1 < 0 || nota1 > 10);
						do {
							System.out.println("Introduce la nota del segundo exámen del estudiante " + posicionEstudiante + " en la evaluación " + posicionEvaluacion + " (De 0 a 10):");
							nota2 = sc.nextFloat();
						} while(nota2 < 0 || nota2 > 10);
						do {
							System.out.println("Introduce la nota del tercer exámen del estudiante " + posicionEstudiante + " en la evaluación " + posicionEvaluacion + " (De 0 a 10):");
							nota3 = sc.nextFloat();
						} while(nota3 < 0 || nota3 > 10);
							
						asignatura.anadirNota(posicionEstudiante, posicionEvaluacion, nota1, nota2, nota3);
					}
				}
				break;
			}
		} while(opcionMenu != limiteSuperiorMenu);
	}
}
