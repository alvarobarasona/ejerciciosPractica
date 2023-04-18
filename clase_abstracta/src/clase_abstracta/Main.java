package clase_abstracta;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcionSerVivo;
		
		
		do {
			
			do {
				System.out.println("Introduce el tipo de ser vivo que eres. Si eres una planta pulsa 1. Si eres un hervíboro pulsa 2. Si eres un carnívoro pulsa 3. Si eres un omnívoro pulsa 4.");
				opcionSerVivo = sc.nextInt();
			} while(opcionSerVivo < 1 || opcionSerVivo > 4);

			
			switch(opcionSerVivo) {
			
				case 1:
					Planta planta = new Planta();
					planta.alimentarse();
					break;
				case 2:
					Herbivoro herbivoro = new Herbivoro();
					herbivoro.alimentarse();
					break;
				case 3:
					Carnivoro carnivoro = new Carnivoro();
					carnivoro.alimentarse();
					break;
				case 4:
					Omnivoro omnivoro = new Omnivoro();
					omnivoro.alimentarse();
				default:
					break;
			}
		} while();
		

	}
}
