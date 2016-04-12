
import javax.swing.JOptionPane;

public class KirjaLuoja {

	public static void main(String[] args) {
			
		Kirja[] kirjaHylly = new Kirja[3];
		kirjaHylly[0] = new Kirja();
		kirjaHylly[1] = new Kirja();
		kirjaHylly[2] = new Kirja();

	
		for(int i = 0; i < kirjaHylly.length; i++) {
		String eka =

		JOptionPane.showInputDialog(null, "Anna kirjan nimi?", 
		"Kirjan tietojen kysely", JOptionPane.QUESTION_MESSAGE);
		
		String toka =

		JOptionPane.showInputDialog(null, "Anna julkaisuvuosi?", 
		"Julkaisuvuoden kysely", JOptionPane.QUESTION_MESSAGE);
		
		String kolmas =

		JOptionPane.showInputDialog(null, "Anna tekijän nimi?", 
		"Tekijän kysely", JOptionPane.QUESTION_MESSAGE);
			
	    kirjaHylly[i].setTekijä(eka);
	    kirjaHylly[i].setJulkaisuvuosi(new Integer(toka));
	    kirjaHylly[i].setTeoksenNimi(kolmas);
		}
		
		for(int i = 0; i < kirjaHylly.length; i++) {
		JOptionPane.showMessageDialog(null, kirjaHylly[i]);
	    System.out.println(kirjaHylly[i]);
		}
	   
		
	}

}
