import java.io.*;

import java.util.Scanner;

class EtsiSanoja {

public static void main(String[] args) {

	Scanner lukija = new Scanner(System.in);
	
	System.out.println("Mit� merkkijonoa etsit��n tiedotosta Rautatie.txt? ");
	
	String teksti = lukija.nextLine();	
try {
 Scanner sy�tt�tiedosto = new Scanner(new File("src//Rautatie.txt"));
 
 
 int i = 0;
 
 while (sy�tt�tiedosto.hasNextLine()) {
 i++;
 String rivi = sy�tt�tiedosto.nextLine();
 
 if (rivi.indexOf("" + teksti + "") != -1) {
 System.out.println(i + ": "+ rivi);
 }
}
 	sy�tt�tiedosto.close();
 	lukija.close();
 } catch (Exception e) {
	System.out.println("Hakemaasi tiedostoa ei l�ytynyt");
 }
 	}
}