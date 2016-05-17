package GrckiKino2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import GrckiKino.GrckiKino;

public class GrckiKino2 {
	static Scanner s = new Scanner(System.in);
	//Array LIsta uvek krece od NULTOG elementa.
	
	public static List<Integer> GrckiKinoBrojevi = new ArrayList<Integer>(); //  Lista 20 brojeva koji ce biti izvuceni.
	public static List<Integer> korisnikoviBrojevi = new ArrayList<Integer>(); //  Lista brojeva koje ce krosnik uneti.   

	static final int minBroj = 1;  
	static final int maxBroj = 80;

	static int korisnikovBroj; 

	static boolean statusTiketa;
	static int brojPogoðenih;
	static int brojUnesenih;

	static Thread thread;  // instancijeranje Thread-a 

	/***********************************************
	 * 
	 * Setters and Getters
	 * 
	 ***********************************************/
	public static int getBrojUnesenih() {
		return brojUnesenih;
	}
	public static void setBrojUnesenih(int brojUnesenih) {
		GrckiKino.brojUnesenih = brojUnesenih;
	}
	public static int getBrojPogoðenih() {
		return brojPogoðenih;
	}
	public static void setBrojPogoðenih(int brojPogoðenih) {
		GrckiKino.brojPogoðenih = brojPogoðenih;
	}
	public static boolean isStatusTiketa() {
		return statusTiketa;
	}
	public static void setStatusTiketa(boolean statusTiketa) { // Metoda koja ce da SETuje vrednost StatusaTiketa : dal je prosao ili nije
		GrckiKino.statusTiketa = statusTiketa;
	}
	public static List<Integer> getGrckiKinoBrojevi() { 
		return GrckiKinoBrojevi;
	}
	public static void setGrckiKinoBrojevi(List<Integer> grckiKinoBrojevi) { //Metoda koja ce da SETuje vednost izvucenih random brojava u listu GrckiKInoBrojevi
		GrckiKinoBrojevi = grckiKinoBrojevi;
	}
	public static List<Integer> getKorisnikoviBrojevi() {   // Metoda koja ce da uzme vrednost SETovanih unestih brojeva iz KORISNIKOVE LISTE BROJEVA i da se iskorisi negde gde bude potrebno
		return korisnikoviBrojevi;
	}
	public static void setKorisnikoviBrojevi(List<Integer> korisnikoviBrojevi) { //Metoda koja ce da Setuje vrednost unetih brojeva u listu KORISNIKOVI BROJEVI
		GrckiKino.korisnikoviBrojevi = korisnikoviBrojevi;
	}
	public static Integer getKorisnikovBroj() { // Metoda koja ce da uzme vrednost SETovanih brojeva u listi i da iskoristi negde gde bude potrebno
		return korisnikovBroj;
	}
	public static void setKorisnikovBroj(int nikola1) { 
		GrckiKino.korisnikovBroj = nikola1;
	}   


	/*************************************************
	 * 
	 * METHODS
	 * 
	 *************************************************/
	public static int numberGenerator(int min, int max){  // numberGenertoar metoda 
		int number;
		number = min + (int)(Math.random() * ((max - min) + 1));
		return number;
	}


	@SuppressWarnings("rawtypes")
	public static List GrckiKinoIzvlacenje(){ //Metoda koja izvlaci 20 brojeva random i uporedjuje ih sa unetim brojevima 
		for(int i = 1; i <= 20;){
			int number = numberGenerator(minBroj, maxBroj);  
			if(GrckiKinoBrojevi.contains(number)){ //Ako lista GrckiKinoBrojevi sadrzi vec izvucen broj, vrati se na pocetak i 
			}                                      //izvlaci opet drugi broj sve dok ne izvuce broj koji nije izvucen do sad!
			else{    
				GrckiKinoBrojevi.add(number);                                                           //Ako broj nije izvucen do sad, onda dolazimo do else petlje, gde taj broj dodajemo
				i++;    //Brojac staoji ovde da povecava broj samo u slucaju da broj nije vec izvucen      // U listu: GrckiKinoBrojevi . i brojac dobija na vrednost za 1 vise: " i++ "
			}                             // pa ispocetka sve.
		}
		return GrckiKinoBrojevi;   //Ovde vraca vrednost izvucenih brojeva u listu.
	}


	public static void sastaviMojTiket(){ 
		try{	
			int brojPodudarenih = 0;          //Deklarisali smo dve promenljive
			int brojUnesenih = 0;

			for(int i = 1; i <= 20;){                           // pettlja koja ce 20 puta da se izvrsava
				System.out.println("Unesite " + i + ". broj");       //Ovde je ubacen brojac "i", da bi se ispisvali brojevi od 1 do 20 u consoli:npr: "Unesite 1. broj"...
				try{                                              // try catch metoda pocinje odavde ona sluzai za zastitu koda u slucaju Exeption e, umesto toga izacice INFO BOX SA POruKOM
					setKorisnikovBroj(s.nextInt());                //Set-ova ce broj koji korisnik unese u metodu KORISNIKOVI BROJEVI
				}
				catch(Exception e){
					infoBox("GRESKA", "Ne mozete da unesete slova!");              // Ovo je metoda za INFO BOX koja ce da se pojavi prilikom unosenjem slova
					System.exit(0);            // Ovo je komanda za izlazak iz aplikacije, u ovom slucaju da neko napise SLOVO umesto BROJA.
					System.out.println("Mora te ispocetka pokrenuti aplikaciju!");
				}
				if(getKorisnikovBroj() == 0 && i > 3){     //Ako je uneto vise od 3 broja i 0 zaustavi petlju i ubaci tu vrednost 3 broja u listu.. 
					break;            
				} 
				if(getKorisnikovBroj() != 0){             //Ovde smo stavili uslov da sve brojeve koje je korisnik uneo ubaci u listu osim 0
					korisnikoviBrojevi.add(getKorisnikovBroj());  // Ovde dodajemo unete brojeve korisnika u listu.
					i++;   
					brojUnesenih++;                        //Ovde sabira koliko je korisnik uneo brojeva .
					setBrojUnesenih(brojUnesenih);       //Ovde SETujemo vrednost unesenih brojeva tj. koliko je korisnik uneo brojeva u SET metodu BROJ-UNESENIH.
					Collections.sort(korisnikoviBrojevi);                 // ovde sortiramo listu korisnikovih brojeva po velicini.
					if(GrckiKinoBrojevi.contains(getKorisnikovBroj())){    //Proveravamo dal lista GrckiKinoBrojevi sadrzi korisnikove unete brojeve
						brojPodudarenih++;                                //ako sadrzi on onda ce brojac = brojPodudarenih++ da dobije vrednost 1, ako sadrzi jos jedan broj onda ce 2 itd...
						setBrojPogoðenih(brojPodudarenih);                //Ovde SETujemo vrednost brojPodudarenih brojeva u metodu setBrojPogoðenih.
					}
				}
				else{   // Ako uneste manje od 3 broja i pokrenete igricu klikom na " 0 " onda ce vam izaci info box sa ovom porukom ispod. "Ne možete da pokrenete igru bez minimum 3 broja!"
					infoBox("Sistemska greska!", "Ne možete da pokrenete igru bez minimum 3 broja!");
				}
			}

			uporedi(brojPodudarenih, brojUnesenih);// Ovde je pozvana metoda UPOREDI koja kao parametar prima brojPodudarenih i brojUnesenih i uporedjuje ih.
		}
		catch(Exception e){   
			infoBox("GRESKA", "Desila se greska u kreiranju tiketa");
			System.out.println("Aplikacija se gasi!");
			System.exit(0);
		}
	}
	//KRAJ SASTAVI MOJ TIKET METODE

	public static void uporedi(int one, int two){ // Metoda uporedi dva broja, koja dobija kao parametar sluzi da se proveri dal je tiket prosao ili ne.
		if(one == two){            // ako je one jednak two = stattus tiket je true tj prosao je
			setStatusTiketa(true);   //a ako nije jednak onda je flase tj pao je tiket.
		}
		else{
			setStatusTiketa(false);
		}
	}
	public static void infoBox(String title, String infoMessage){     // metoda INFO BOX 
		JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE); // 
	}

	public static void yesOrNo(String title, String poruka){  // INFOBOX YES OR NO - METODA
		if (JOptionPane.showConfirmDialog(null, poruka, title,   
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				== JOptionPane.YES_OPTION) 
		{ 
			// ako kliknes YES uradi ovaj blok koda 
			game();  //POZVANA METODA
		}                 
		else  
		{
			// ako kliknes NO uradi ovaj blok koda
			System.exit(0);   //komanda za izbacivanje iz sisetma 
		}
	}

	@SuppressWarnings("static-access")
	public static void game(){
		infoBox("Zdravo!", "Dobro dosli u Grcki Kino!");  // prvo sta ce da se desi kada se run-uje aplikacija
		System.out.println("Pravila igre:\nIzaberite od 3 do 20 brojeva, izmedju 1 i 80.\nZatim pritisnite 0 kada unesete vase brojeve!");
		System.out.println("Nakon toga iz bubnja se izvlaci 20 brojeva.");
		GrckiKinoIzvlacenje();   
		sastaviMojTiket();
		System.out.println("Vasi uneti brojevi su: " + korisnikoviBrojevi);  // nakaon sto se sastavi tiket izbacuje se text 
		for(int i = 0; i < 20; i++){ 
			System.out.println((i+1) + " izvuceni broj je: " + GrckiKinoBrojevi.get(i));   // ADD I GET su metode klase ARRAYLISTE
			try {
				infoBox(" ", "Izvucen je broj: " + GrckiKinoBrojevi.get(i));
				thread.sleep(2000); // komanda da 2 sekunde za svaku sledecu iteraciju brojaca petlje
			} catch (InterruptedException e) { // zastita za thread.sleep
				// TODO Auto-generated catch block
				e.printStackTrace();  //komanda koja ce da mi ispsise eror u conzolu.
			}
		}
		if(isStatusTiketa()){ // On ovde odma pita da li je TRUE tiket tj dali ispunjava uslov za true. jer je tipa boolean.
			System.out.println("Osvojili ste tiket");
		}
		else{  
			System.out.println("Pali ste tiket");
		}
		Collections.sort(GrckiKinoBrojevi);     // komanda koja ce da soritra izvucene brojeve.
		System.out.println("Izvuceni brojevi su: " + GrckiKinoBrojevi);   
		System.out.println("Pogodili ste: " + getBrojPogoðenih() + " od " + getBrojUnesenih() + " unesenih brojeva.");
	}


	//MAIN METHOD
	public static void main(String[] args) {       // u MAIN METoDI je pozvana YESorNo metoda koja sadrzi game metodu....
		yesOrNo("Start", "Da li zelite da zapocnete igru?");
	}
}


