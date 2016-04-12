import java.io.*;

import java.util.Scanner;

class EtsiSanoja {

public static void main(String[] args) {

	Scanner lukija = new Scanner(System.in);
	
	System.out.println("Mitä merkkijonoa etsitään tiedotosta Rautatie.txt? ");
	
	String teksti = lukija.nextLine();	
try {
 Scanner syöttötiedosto = new Scanner(new File("src//Rautatie.txt"));
 
 
 int i = 0;
 
 while (syöttötiedosto.hasNextLine()) {
 i++;
 String rivi = syöttötiedosto.nextLine();
 
 if (rivi.indexOf("" + teksti + "") != -1) {
 System.out.println(i + ": "+ rivi);
 }
}
 	syöttötiedosto.close();
 	lukija.close();
 } catch (Exception e) {
	System.out.println("Hakemaasi tiedostoa ei lï¿½ytynyt");
 }
 	}
}