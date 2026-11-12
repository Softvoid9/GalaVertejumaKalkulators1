package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GalvenaKlase {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int izvele;
		int studSk = 0, kritSk = 0;
		String[] studenti = new String[studSk];
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		do {
			System.out.println("\n--- IZVĒLNE ---");
			System.out.println("1 - Ievadīt Audzēkņus");
			System.out.println("2 - Ievadīt kritēriju ");
			System.out.println("3 - Ievadīt kritēriju svars");
			System.out.println("4 - Ievadīt vērtējumus");
			System.out.println("5 - Labot kriteriju");
			System.out.println("6 - Labot kriteriju svars");
			System.out.println("7 - Labot iegūto vērtējumu");
			System.out.println("8 - Apreķināt gala vērtējumi");
			System.out.println("9 - Saglabāt rezultātus failā");
			System.out.println("10 - Nolasīt rezultātus no faila");
			System.out.println("11 - Beigt");
			System.out.print("Izvēle: ");
			while (!scan.hasNextInt()) {
				System.out.print("Kļūda! Ievadi skaitli no 1 līdz 10: ");
				scan.next();
			}
			izvele = scan.nextInt();
			scan.nextLine();
			switch (izvele) {
			case 1:
				KlaseMetodiem.ievaditStudentus(scan);
				break;
			case 2:
				KlaseMetodiem.ievaditKriterijuSk(scan);
				break;
			case 3:
				KlaseMetodiem.ievaditKriterijuSvarus(scan);
				break;
			case 4:
				KlaseMetodiem.IevaditVertejumi(scan);
				break;
			case 5:
				KlaseMetodiem.LabotKriterijumi(scan);
				break;
			case 6:
				KlaseMetodiem.LabotKriterijumiSvarus(scan);
				break;
			case 7:
				KlaseMetodiem.LabotVertejumi(scan);
				break;
			case 8:
				KlaseMetodiem.GalaVertejums(scan);
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
					System.out.println("Programma darbu beidz.");break;
				default:
					System.out.println("Nepareiza izvēle!");
			}
			
	}while(izvele != 11);
	}
}