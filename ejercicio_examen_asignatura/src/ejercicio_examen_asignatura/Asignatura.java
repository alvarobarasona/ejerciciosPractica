package ejercicio_examen_asignatura;

import java.util.Arrays;

public class Asignatura {

	private String nombreAsignatura;
	private Estudiante [] estudiante;
	private Float [][] notas;
	private int numeroActualEstudiantes;
	private final int numeroEvaluaciones = 3;
	private final int numeroExamenesEvaluacion = 3;
	
	final int diferenciaArray = 1;
	int limiteInferiorArray = 0;
	final int ningunEstudiante = 0;
	
	public Asignatura(String nombreAsignatura, int numeroMaximoEstudiantes) {
		
		this.nombreAsignatura = nombreAsignatura;
		estudiante = new Estudiante [numeroMaximoEstudiantes];
		notas = new Float [numeroMaximoEstudiantes][numeroEvaluaciones];
	}
	
	public int getNumeroActualEstudiantes() {
		
		return numeroActualEstudiantes;
	}
	
	public void Menu(String nombreAsignatura) {
		
		System.out.println("¡Bienvenido al menú de la asignatura de " + nombreAsignatura + "!\nIntroduce una opción(Del 1 al 4):\n\t1. Imprimir detalles de la asignatura\n\t2. Añadir estudiante"
		+ "\n\t3. Añadir nota a un estudiante\n\t4. Salir\n");
	}
	
	public void anadirEstudiante(String nombreEstudiante, String apellidoEstudiante, int niaEstudiante) {
		
		if(numeroActualEstudiantes < estudiante.length) {
			
			estudiante[numeroActualEstudiantes] = new Estudiante(nombreEstudiante, apellidoEstudiante, niaEstudiante);
			numeroActualEstudiantes++;
			System.out.println("El alumno " + nombreEstudiante + " " + apellidoEstudiante + " se ha añadido correctamente.\n");
		} else {
			
			System.err.println("ERROR. El alumno " + nombreEstudiante + " " + apellidoEstudiante + " no se ha podido añadir. Límite de estudiantes alcanzado. El número máximo de estudiantes es de " + estudiante.length + ".\n");
		}
	}
	
	//Método que comprueba si hay esudiantes registrados a los que poder añadir notas
	public boolean comprobarSiHayEstudiantes() {
		
		if(numeroActualEstudiantes == ningunEstudiante) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Comprueba si (al/a los) estudiante/s le queda algún hueco para añadir notas en la matriz notas
	public boolean comprobarNotasEstudiante() {
		
		int contador = 0;
		
		for(int f = 0; f < numeroActualEstudiantes; f++) {
			for(int c = 0; c < numeroEvaluaciones; c++) {
				
				if(notas[f][c] != null) {
					
					contador++;
				} else {
					
					System.out.println("Al estudiante de la posición " + (f + diferenciaArray) + " le queda hueco para añadir notas en la evaluación " + (c + diferenciaArray) + ".");
				}
			}
		}
		if(contador == (numeroActualEstudiantes * numeroEvaluaciones)) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	//Método que comprueba si solo hay uno o varios estudiantes, y si sólo hay uno se salta el paso de pedir que se introduzca la posición del estudiante
	public boolean comprobarNumeroEstudiantes() {

		final int unEstudiante = 1;
		
		if(numeroActualEstudiantes == unEstudiante) {
				
				System.out.println("Introduce la posición de la evaluación del alumno " + numeroActualEstudiantes + ":");
				return false;
		} else {
				
				System.out.println("Introduce la posición del estudiante(Debe estar comprendida entre 1 y "
				+ numeroActualEstudiantes + " incluidos):");
				return true;
		}
	}
	
	//Comprobamos si la posición introducida por el usuario se encuentra dentro de los límites del número de estudiantes añadidos al vector estudiante, y también si a dicha posición le queda algún hueco por asignar.
	public boolean comprobarPosicionEstudianteValida(int posicionEstudiante) {
		
		if((posicionEstudiante - diferenciaArray) < limiteInferiorArray || posicionEstudiante > numeroActualEstudiantes) {
			
			System.err.println("ERROR. Posición del estudiante " + posicionEstudiante + " inválida. La posición debe estar comprendida entre 1 y " + numeroActualEstudiantes + " incluidos. Vuelve a introducir otra posición del alumno:");
			return false;
		} else {
			
			int contador = 0;
			
			for(int i = 0; i < numeroEvaluaciones; i++) {
				
				if(notas[posicionEstudiante - diferenciaArray][i] != null) {
					
					contador++;
				}
			}
			if(contador == numeroEvaluaciones) {
				
				System.err.println("ERROR. El alumno ya tiene asignado notas en todas las evaluaciones. Vuelve a introducir otra posición del alumno:");
				return false;
			} else {
				
				return true;
			}
		}
	}
	
	//Comprobamos si la posición de la evaluación introducida por el usuario tiene ya un valor asignado o no en la matriz notas.
	public boolean comprobarEstadoPosicionEstudiante(int posicionEstudiante, int posicionEvaluacion) {
		
		if((posicionEvaluacion - diferenciaArray) < limiteInferiorArray || posicionEvaluacion > numeroEvaluaciones) {
			
			System.err.println("ERROR. La evaluación debe estar comprendida entre 1 y 3. Vuelve a introducir de nuevo la posiciónd de la evaluación:\n");
			return false;
		}
		
		if(notas[posicionEstudiante - diferenciaArray][posicionEvaluacion - diferenciaArray] != null) {
			
			System.err.println("ERROR. Este alumno ya tiene una nota en esta evaluación. Introduce otra posición de la evaluación:");
			return false;
		} else {
			
			return true;
		}
	}
	
	public void anadirNota(int posicionEstudiante, int posicionEvaluacion, float nota1, float nota2, float nota3) {
		
		notas[posicionEstudiante - diferenciaArray][posicionEvaluacion - diferenciaArray] = (nota1 + nota2 + nota3) / numeroExamenesEvaluacion;
	}
	
	public void notasEstudianteToString() {
		
		for(int f = 0; f < numeroActualEstudiantes; f++) {
			for(int c = 0; c < numeroEvaluaciones; c++) {
				
				System.out.println(notas[f][c] + "\n");
			}
		}
	}
	
	public String toString() {
		
		String infoAsignatura = "Asignatura '" + nombreAsignatura + "'. " + numeroActualEstudiantes + " estudiantes registrados (máximo " + estudiante.length + ")\n";
		
		if(numeroActualEstudiantes > ningunEstudiante) {
			
			infoAsignatura += "1aEv 2aEv 3aEv	FINAL | NIA";
		}
		
		return infoAsignatura;
	}
}
