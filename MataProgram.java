package NewProgram;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MataProgram {

	static Scanner s = new Scanner(System.in);

	static int nepozantBroj1;
	static int nepoznatBroj2;
	static int nikola1;
	static int rezultat;
	static int brojTacnih;
	static int brojPromasenih;

	        // Seteri i Geteri
	public static int getBrojPromasenih() {
		return brojPromasenih;
	}
	public static void setBrojPromasenih(int brojPromasenih) {
		MataProgram.brojPromasenih = brojPromasenih;
	}
	public static int getBrojTacnih() {
		return brojTacnih;
	}
	public static void setBrojTacnih(int brojTacnih) {
		MataProgram.brojTacnih = brojTacnih;
	}
	public static int getNepozantBroj1() {
		return nepozantBroj1;
	}
	public static void setNepozantBroj1(int nepozantBroj1) {
		MataProgram.nepozantBroj1 = nepozantBroj1;
	}
	public static int getNepoznatBroj2() {
		return nepoznatBroj2;
	}
	public static void setNepoznatBroj2(int nepoznatBroj2) {
		MataProgram.nepoznatBroj2 = nepoznatBroj2;
	}
	public static int getNikola1() {
		return nikola1;
	}
	public static void setNikola1(int nikola1) {
		MataProgram.nikola1 = nikola1;
	}
	public static int getRezultat() {
		return rezultat;
	}
	public static void setRezultat(int rezultat) {
		MataProgram.rezultat = rezultat;
	}

	public static int numberGenerator(int min, int max){
		int number;
		number = min + (int)(Math.random() * ((max - min) + 1));
		return number;
	}
	public static void main(String[] args) {
		yesOrNo();
		infoBox("NMR", "Dobro dosli u MataProg!");
		int brojPromasenih = 0;
		for(int i = 1; i <= 15; i++){
			setNepozantBroj1(numberGenerator(1, 1000));
			setNepoznatBroj2(numberGenerator(1, 1000));
			setRezultat(getNepozantBroj1() + getNepoznatBroj2());
			System.out.println(getNepozantBroj1() + "+" + getNepoznatBroj2() + " =?");

			System.out.println("Unesi rezultat:");
			setNikola1(s.nextInt());

			if(getNikola1() == getRezultat()){
				System.out.println("Tacno!");
				setBrojTacnih(i);
			}
			else{
				brojPromasenih++;
				setBrojPromasenih(brojPromasenih);
				if(getBrojPromasenih() == 3){
					infoBox(" ", "Zao nam je promasio si tri puta!");
					ispisiBrojPogodjenih();
					System.exit(0);
				}
				else{
					System.out.println("Pokusaj jos jedan put:");
					setNikola1(s.nextInt());

					if(getNikola1() == getRezultat()){
						System.out.println("Tacno!");
						setBrojTacnih(i);
					}
					else{
						infoBox("Izgubili ste!","Sledeci put dodji spremniji!");
						ispisiBrojPogodjenih();
						System.exit(0);
					}
				}
			}
		}
		System.out.println("Pogodili ste svih, " + getBrojTacnih() + " rezultata.");
	}                                                                                  // KRAJ MAIN METODE

	public static void ispisiBrojPogodjenih(){
		System.out.println("Pogodili ste: " + getBrojTacnih() + " brojeva.");
	}

	public static void infoBox(String title, String infoMessage){     // metoda INFO BOX 
		JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE); // 
		
	}
	
	public static void yesOrNo(){  // INFOBOX YES OR NO - METODA
		if (JOptionPane.showConfirmDialog(null, "Da li zelite da pokrenete aplikaciju?", "NMR",   
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				== JOptionPane.YES_OPTION) { 
		}                 
		else{

			System.exit(0);    
		}
	}

}


