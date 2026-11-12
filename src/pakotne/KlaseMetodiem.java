package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

public class KlaseMetodiem {
	static int kritSk, studSk;
	static String[] kriteriji = new String[kritSk];
	static String[] studenti = new String[studSk];
	int[] kriterijaSvars = new int[kritSk];
	int[][] kriterijaVertejums = new int[studSk][kritSk];
	double[] semestraVertejums = new double[studSk];
	DecimalFormat df = new DecimalFormat("0.#");
	public static void ievaditStudentus(Scanner scan){
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			while(!scan.hasNextInt()) {
				System.out.println("Kļuda! Vajag uzrakstit veselos skaitļos");
				scan.next();
			}
			studSk = scan.nextInt();
		}while(studSk<1);
		studenti = new String[studSk];
		scan.nextLine();
		for(int i=0; i<studenti.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". studentu");
				studenti[i] = scan.nextLine().trim();
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
	}
	public static void ievaditKriterijuSk(Scanner scan, String[] studenti, String[] kriteriji,int[] kriterijaSvars,int[][] kriterijaVertejums,double[] semestraVertejums) {
		int kritSk;
		// Vērtēšanas kritēriju skaita ievade
				do {
					System.out.println("Kāds būs kritēriju skaits?");
					while(!scan.hasNextInt()) {
						System.out.println("Kāds būs kritēriju skaits?");
						scan.next();
					}
					kritSk = scan.nextInt();
				}while(kritSk<1);
				kriteriji = new String[kritSk];
				kriterijaSvars = new int[kritSk];
				kriterijaVertejums = new int[studSk][kritSk];
				semestraVertejums = new double[studSk];
				scan.nextLine();
	}
	 public static void ievaditKriterijuSvarus(Scanner scan,String[] kriteriji, int[] kriterijaSvars) {
		 int maxSvars = 100 , sk = 1;
			double atlSvars;
				for(int i=0; i<kriteriji.length; i++) {
					do {
						System.out.println("Ievadi "+(i+1)+". kritēriju");
						kriteriji[i] = scan.nextLine().trim();
					} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
					// Norāda katra kritērija svaru
					do {
						System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
						while(!scan.hasNextInt()) {
							System.out.println("Ievadi "+(i+1)+". kritērija svaru");
							scan.next();
						}
						kriterijaSvars[i] = scan.nextInt();
						/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
						 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
						*/
						atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
					} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
						  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
						  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
						  || atlSvars < 5);
					maxSvars -= kriterijaSvars[i];
					sk++;
				}
	}
				public static void IevaditVertejumi(Scanner scan, int[][] kriterijaVertejums, String[] studenti,String[] kriteriji) {		
				// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
				for(int i=0; i<kriterijaVertejums.length; i++) {
					for(int j=0; j<kriterijaVertejums[i].length; j++) {
						do {
							System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
							while(!scan.hasNextInt()) {
								System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
								scan.next();
							}
							kriterijaVertejums[i][j] = scan.nextInt();
						}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
					}
				}
				}
	
	public static void GalaVertejums(Scanner scan ,double[] semestraVertejums,String[] studenti,String[] kriteriji, int[][] kriterijaVertejums,int[] kriterijaSvars ) {
		// Gala vērtējuma aprēķināšana
		DecimalFormat df = new DecimalFormat("0.#");
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		scan.close();
	}
	
}


