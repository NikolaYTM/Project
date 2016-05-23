package Igrica2;

import java.util.Scanner;

public class PogodiOd1Do1000 {

	static Scanner s = new Scanner(System.in); 

	static int nepoznatBroj;    
	static int maxNepoznatBroj;  
	static int brojPokusaja;
	


	public static int getBrojPokusaja() {   
		return brojPokusaja;
	}

	public static void setBrojPokusaja(int brojPokusaja) {
		PogodiOd1Do1000.brojPokusaja = brojPokusaja;
	}

	public static int getMaxNepoznatBroj() {
		return maxNepoznatBroj;
	}

	public static void setMaxNepoznatBroj(int broj) {
		maxNepoznatBroj = broj;
	}

	public static int getNepoznatBroj() {
		return nepoznatBroj;
	
	}
	
	public static void setNepoznatBroj(int Broj) {
		nepoznatBroj = Broj;
	
	}

	public static int numberGenerator(int min, int max){  // metoda koja generise 
		int number;
		number = min + (int)(Math.random() * ((max - min) + 1));
		return number;
	}
	
	public static void main(String[] args) {
		setNivo();  // pozvana metoda - setNivo- koja ispsuje pravila svakog nivo-a, i omogucava da korisnik unese broj nivoa. 
		
		setNepoznatBroj(numberGenerator(1, getMaxNepoznatBroj()));
	
		for(int i = 1; i <= getBrojPokusaja(); i++){
			System.out.println("Unesi " + i + " broj:");
			int a = s.nextInt();
			poredjenjeDvaBroja(a, getNepoznatBroj(), i);
		}
		System.out.println("Zao nam je niste pogodili broj.\nTrazeni broj je bio " +getNepoznatBroj());
	}
	
	
	public static void poredjenjeDvaBroja(int prviBroj, int drugiBroj, int pokusaji){  // metoda poredjenja ulaznis parametara
		if(prviBroj > drugiBroj){
			System.out.println("Uneli ste veci broj od trazenog!");
		}
		else if(prviBroj == drugiBroj){
			System.out.println("Pogodili ste broj u " + pokusaji + " pokusaja.");
			System.exit(0);     //komanda za prekid programa u slucaju pogodga broja
		}
		else if(prviBroj < drugiBroj){
			System.out.println("Uneli ste manji broj od trazenog!");
		}
	}
	public static void setNivo(){
		
		System.out.println("Za lak nivo upisite: 1");    
		System.out.println("Za srednji nivo upisite: 2");
		System.out.println("Za tezi nivo upisite: 3");
		
		System.out.println("Unesite nivo:");
		int nivo = s.nextInt(); //unesi broj nivoa koji zelis da igras od 1 do 3.
		
		if(nivo == 1){ // ako uneses 1- tj prvi nivo onda ce da setuje od 1 do 30 brojeva igru i 6 pokusaja da pogodis br.
			setMaxNepoznatBroj(30);
			setBrojPokusaja(6);
			System.out.println("Pogodi broj izmedju 1 i " + getMaxNepoznatBroj() + " u " + getBrojPokusaja() + " pokusaja.");
		}
		else if(nivo == 2){ // ako uneses 2 - tj drugi nivo onda ce da ti setuje od 1 do 60 brojeva igru i 5 pokusaja da pogodis br
			setMaxNepoznatBroj(60);
			setBrojPokusaja(5);
			System.out.println("Pogodi broj izmedju 1 i " + getMaxNepoznatBroj() + " u " + getBrojPokusaja() + " pokusaja.");
		}
		else if(nivo == 3){  //ako uneses 3 onda ce da ti setuje od 1 do 100 brojeva igru i 4 pokusaja da pogodis  br.
			setMaxNepoznatBroj(100);
			setBrojPokusaja(4);
			System.out.println("Pogodi broj izmedju 1 i " + getMaxNepoznatBroj() + " u " + getBrojPokusaja() + " pokusaja.");
		}
		else{ 
			System.out.println("Uneli ste nevazeci broj za nivo!");
			System.exit(0); // komanda za prekid programa u slucaju da neko unese veci broj od 1 do 3 ili neko slovo u slucaju odabira nivoa
		}
	}
}


