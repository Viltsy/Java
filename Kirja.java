
public class Kirja {

	private String teoksenNimi;
	private int julkaisuvuosi; 
	private String tekij�;
	
	Kirja() {
	teoksenNimi = "ei nime�";	
	julkaisuvuosi = 0;
	tekij� = "Rasmus";
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
	
	public String getTekij�() {
		return this.tekij�;
	}
	
	public void setTekij�(String uusitekij�){
		this.tekij� = uusitekij�;
	}
	
	public String toString() {
		return "Kirja Teos: " + teoksenNimi + " Julkaisuvuosi: " + julkaisuvuosi + " Tekij�: " + tekij�;
	}
	
}

