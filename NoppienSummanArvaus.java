import java.util.Scanner;

public class NoppienSummanArvaus {
public static void main(String[] args) {


int noppaluku1, noppaluku2;


boolean jatketaanko = true;

Scanner lukija = new Scanner(System.in);

do {

System.out.print("Arvaa noppien summa: ");
int arvaus = lukija.nextInt();

noppaluku1 = (int) Math.floor(Math.random() * 6 + 1);
noppaluku2 = (int) Math.floor(Math.random() * 6 + 1);

int summa = (noppaluku1 + noppaluku2);

System.out.println("Noppa 1: " + noppaluku1 + " " + " Noppa 2: " + noppaluku2);
System.out.println("Noppien summa: " + summa);
System.out.println("Arvauksesi oli: " + arvaus);

if (arvaus == summa) {
System.out.println("Arvasit oikein!");
} else {
System.out.println("Arvauksesi ei ollut oikein.");
}
System.out.print("Haluatko yrittää uudelleen? (true/false) ");
jatketaanko = lukija.nextBoolean();

if (jatketaanko == false) {
 System.out.println("Ohjelman suoritus lopetetaan...");
} else {
  System.out.println("Jatketaan sovelluksen käyttöä..." + "\n");
}


} while(jatketaanko);
	lukija.close();
	}
}