package pakotne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class KlaseMetodiem {
	static int kritSk, studSk;
	static String[] kriteriji = new String[kritSk];
	static String[] studenti = new String[studSk];
	static int[] kriterijaSvars = new int[kritSk];
	static int[][] kriterijaVertejums = new int[studSk][kritSk];
	static double[] semestraVertejums = new double[studSk];
	DecimalFormat df = new DecimalFormat("0.#");
	public static void ievaditStudentus(Scanner scan){
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			while(!scan.hasNextInt()) {
				System.out.println("Kļuda! Vajag uzrakstit burtus");
				scan.next();
			}
			studSk = scan.nextInt();
			if(studSk < 1)
				System.out.println("Studentam vajag but par 1");
		}while(studSk<1);
		studenti = new String[studSk];
		scan.nextLine();
		for(int i=0; i<studenti.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". studentu");
				studenti[i] = scan.nextLine().trim();
				if(!studenti[i].matches("^[\\p{L} ]+$"))
						System.out.println("Drīkst tikai burtiski");
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
	}
	public static void ievaditKriterijuSk(Scanner scan) {
		if(kriteriji == null)
			System.out.println("Izveido vispirms Studentu");
		int kritSk = 100;
				do {
					System.out.println("Kāds būs kritēriju skaits?");
					while(!scan.hasNextInt()) {
						System.out.println("Kāds būs kritēriju skaits?");
						scan.next();
					}
					kritSk = scan.nextInt();
					if(kritSk < 1)
						System.out.println("Kriterijam vajag but par 1");
				}while(kritSk<1);
				kriteriji = new String[kritSk];
				kriterijaSvars = new int[kritSk];
				kriterijaVertejums = new int[studSk][kritSk];
				semestraVertejums = new double[studSk];
				scan.nextLine();
	}
	 public static void ievaditKriterijuSvarus(Scanner scan) {
		 int maxSvars = 100 , sk = 1;
			double atlSvars;
				for(int i=0; i<kriteriji.length; i++) {
					do {
						System.out.println("Ievadi "+(i+1)+". kritēriju");
						kriteriji[i] = scan.nextLine().trim();
						if(!kriteriji[i].matches("^[\\p{L} ]+$"))
							System.out.println("Drīkst tikai burtiski");
					} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
					
					do {
						System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
						while(!scan.hasNextInt()) {
							System.out.println("Ievadi "+(i+1)+". kritērija svaru");
							scan.next();
						}
						kriterijaSvars[i] = scan.nextInt();
						scan.nextLine();
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
				public static void IevaditVertejumi(Scanner scan) {		
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
	public static void LabotKriterijumi(Scanner scan) {
		if(kriteriji == null)
			System.out.println("Izveido vispirms Studentu");
		int kritSk = 100;
				do {
					System.out.println("Kāds būs kritēriju skaits?");
					while(!scan.hasNextInt()) {
						System.out.println("Kāds būs kritēriju skaits?");
						scan.next();
					}
					kritSk = scan.nextInt();
					if(kritSk < 1)
						System.out.println("Kriterijam vajag but par 1");
				}while(kritSk<1);
				kriteriji = new String[kritSk];
				kriterijaSvars = new int[kritSk];
				kriterijaVertejums = new int[studSk][kritSk];
				semestraVertejums = new double[studSk];
				scan.nextLine();
				}
	public static void LabotKriterijumiSvarus(Scanner scan) {
		 int maxSvars = 100 , sk = 1;
			double atlSvars;
				for(int i=0; i<kriteriji.length; i++) {
					do {
						System.out.println("Ievadi "+(i+1)+". kritēriju");
						kriteriji[i] = scan.nextLine().trim();
						if(!kriteriji[i].matches("^[\\p{L} ]+$"))
							System.out.println("Drīkst tikai burtiski");
					} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
					
					do {
						System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
						while(!scan.hasNextInt()) {
							System.out.println("Ievadi "+(i+1)+". kritērija svaru");
							scan.next();
						}
						kriterijaSvars[i] = scan.nextInt();
						scan.nextLine();
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
	public static void LabotVertejumi(Scanner scan) {
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
	public static void GalaVertejums(Scanner scan) {
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
	public static void saglabatFailu(String Figuras[], String failaNosaukums) {
		try {
			FileWriter fw = new FileWriter(failaNosaukums, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(Figuras.length);
			pw.println("+".repeat(100));
			pw.close();
			JOptionPane.showMessageDialog(null, "Ieraksts saglabāts"+failaNosaukums);
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Radās kļūda ierakstot failā!",
					"Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void nolasitFailu(String failaNosaukums) {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(failaNosaukums);
			BufferedReader br = new BufferedReader(fr);
			while((teksts = br.readLine()) != null) {
				str += teksts + "\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null, str, "Faila  saturs", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Radās kļūda nolasot failā!",
					"Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}


