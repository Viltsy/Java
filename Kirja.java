
public class Kirja {

	private String teoksenNimi;
	private int julkaisuvuosi; 
	private String tekijä;
	
	Kirja() {
	teoksenNimi = "ei nimeä";	
	julkaisuvuosi = 0;
	tekijä = "Rasmus";
	}
	

	
	public String getTeoksenNimi() {
		return this.teoksenNimi;
	}
	
	public void setTeoksenNimi(String uusinimi){
		this.teoksenNimi = uusinimi;
	}
	
	public int getJulkaisuvuosi() {
		return this.julkaisuvuosi;
	}
	
	public void setJulkaisuvuosi(int uusijulkaisu){
		this.julkaisuvuosi = uusijulkaisu;
	}
	
	public String getTekijä() {
		return this.tekijä;
	}
	
	public void setTekijä(String uusitekijä){
		this.tekijä = uusitekijä;
	}
	
	public String toString() {
		return "Kirja Teos: " + teoksenNimi + " Julkaisuvuosi: " + julkaisuvuosi + " Tekijä: " + tekijä;
	}
	
}

