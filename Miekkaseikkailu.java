import java.util.Scanner;

/** Ohjelman kuvaus:<br><br>
 * T‰m‰ peli on keskiaikainen tekstiseikkailupeli.<br>
 * Peliss‰ pelaaja valitsee mielest‰‰n sopivimman vaihtoehdon, kun h‰nelt‰ kysyt‰‰n sit‰.<br>
 * Peliss‰ on 10 tasoa, jonka aikana pelaaja h‰vi‰‰ tai voittaa pelin.<br>
 * H‰vitess‰‰n tai voittaessaan pelin pelaajalla on mahdollisuus aloittaa peli alusta tai lopettaa se.
 * @author Ville Pˆll‰nen
 * @author Robert Hakola
 */

public class Miekkaseikkailu {
		
		
		/** HP:n kuvaus: <br><br>
		 * HP on int tyyppinen HP-muuttuja, jota k‰ytet‰‰n {@link #laskuri}-metodin lis‰ksi, myˆs kaikissa taso-metodeissa ja main-metodissa.<br>
		 * HP:n arvo m‰‰ritet‰‰n {@link #taso1 tason 1} alussa.
		 * @see #laskuri
		 * @see #taso1
		 * @see #taso2
		 * @see #taso3
		 * @see #taso4
		 * @see #taso5
		 * @see #taso6
		 * @see #taso7
		 * @see #taso8
		 * @see #taso9
		 * @see #taso10
		 * @see #main        
		 */
		private static int HP;
		/** Vaikeustason kuvaus: <br><br>
		 * Vaikeustaso on <code>int</code> tyyppinen muuttuja ja se m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @see #vaikeus
		 */
		private static int vaikeustaso;
		/** Valinnan kuvaus: <br><br>
		 * Valinta on k‰ytt‰j‰n/pelaajan tasovalinta, joka luetaan {@link #lukija}-nimisell‰ Scannerilla ja sit‰ k‰ytet‰‰n selvitt‰m‰‰n tasojen switch-case valinta.
		 * @see #lukija
		 */
		private static int valinta;
		/** Vastauksen kuvaus: <br><br>
		 * Vastaus on <code>boolean</code>-tyyppinen muuttuja ja sit‰ k‰ytet‰‰n {@link #lopetus}-metodissa ja {@link #main p‰‰ohjelman} do-while silmukassa.
		 * @see #lopetus
		 * @see #main
		 */
		private static boolean vastaus;
		/** Lukijan kuvaus: <br><br>
		 * Scanner lukija lukee k‰ytt‰j‰n/pelaajan valinnan kaikissa {@link #main main-metodin} ulkopuolella olevissa metodeissa (paitsi {@link #laskuri laskurissa}).
		 */
		private static Scanner lukija;
		
		/** P‰‰ohjelman kuvaus:<br><br>
		 * P‰‰ohjelmassa toistetaan do while -rakenteella peli‰ niin kauan, kunnes k‰ytt‰j‰/pelaaja lopettaa pelin. <br>
		 * Ohjelma toistetaan niin kauan jos <code>if ({@link #vastaus} == true)</code> on tosi.<br><br>
		 * Uutta tasoa ei aloiteta, jos {@link #HP}-muuttujan arvo on v‰hemm‰n tai yht‰ suuri kuin 0.<br>
		 * Jos pelaaja h‰vi‰‰ pelin h‰nelt‰ kysyt‰‰n haluaako h‰n jatkaa pelaamista. <br>
		 * Jos pelaaja p‰‰tt‰‰ yritt‰‰ uudestaan h‰n aloittaa pelin alusta.<br>
		 * @param args P‰‰metodin oletusarvo.
		 * @see #lopetus
		 * @see #laskuri
		 */

		public static void main(String args[]){
				
			do {
			lukija = new Scanner(System.in);
			alku();
			vaikeus();
			taso1(vaikeustaso);
			if (HP > 0)
			taso2(vaikeustaso);
			if (HP > 0)
			taso3();
			if (HP > 0)
			taso4(vaikeustaso);
			if (HP > 0)
			taso5(vaikeustaso);
			if (HP > 0)
			taso6(vaikeustaso);
			if (HP > 0)
			taso7(vaikeustaso);
			if (HP > 0)
			taso8(vaikeustaso);
			if (HP > 0)
			taso9(vaikeustaso);
			if (HP > 0)
			taso10();
			} while (vastaus == true);
	}
		
	/** Metodin kuvaus:<br><br>
	 * Metodin tarkoitus on kysy‰ pelaajalta tulostetaanko ohjeet vai ei.<br>
	 * Metodissa tulostetaan ensin Miekkaseikkailu -pelin taulukko. <br>
	 * T‰m‰n j‰lkeen pelaajalta kysyt‰‰n true/false arvo.<br>
	 * Metodissa on tarkistus, joka tulostaa ohjeet, jos arvo on tosi.
	 * <br> Tarkistus on toteutettu if-else rakenteella.<br>
	 * OhjeetvaiEi-muuttujassa k‰ytt‰j‰lt‰ kysyt‰‰n tulostetaanko ohjeet vai ei, t‰m‰ luetaan {@link #lukija}:lla <br> Kun arvo on tosi ohjeet tulostetaan, jos arvo on ep‰tosi ohjeita ei tulosteta.<br>
	 * Metodi on <code>void</code> tyyppinen, eik‰ palauta mit‰‰n. <br>
	 * <p>
	 * <b> Esimerkki:</b><br><br>
	 * 
	 * <code>Tervetuloa miekkaseikkailu peliin!<br>
	 * Peli on keskiaikainen testiseikkailupeli.<br>
	 * <br>
	 * Haluatko lukea pelin ohjeet? (true/false):</code> (k‰ytt‰j‰n vastaus on <b>true</b>)<br>
	 * (Tulostetaan pelin ohjeet.)
	 * </p>
	 */


	private static void alku() {
		System.out.println("|-----------------------|\n| Miekkaseikkalu -peli  |\n|-----------------------|\n\n  Tervetuloa Miekkaseikkailu -peliin!\n  Peli on keskiaika-teemainen tekstiseikkailupeli!");
		
		System.out.print("\n  Haluatko lukea pelin ohjeet? (true/false): ");
		Boolean OhjeetVaiEi = lukija.nextBoolean();
		
			if (OhjeetVaiEi == true) {
			System.out.println("\n0----------------0\n|  Pelin ohjeet  |\n0----------------0\n");
			System.out.println("  Peliss‰ on 10 tasoa, joissa kerrotaan tasokuvaus eli miss‰ tilanteessa olet...\n  Sinulta kysyt‰‰n myˆs tason alussa mit‰ haluat tehd‰...\n  T‰m‰n j‰lkeen valitset haluamasi tasovalinnan valitsemalla kokonaisluvun (1-3 tai 1-4) v‰lilt‰ tasosta riippuen...\n  Osa n‰ist‰ tapahtumista voi olla neutraaleja, positiivisia tai negatiivisia...\n  Joistakin valinnoista voit h‰vit‰ pelin suoraan!\n\n  Pelin alussa sinulla on 100 HP:ta...\n  Pelin aikana \"POSITIIVISET\" valinnat kasvattavat HP:tasi...\n  \"NEGATIIVISET\" valinnat v‰hent‰v‰t HP:ta riippuen siit‰ mink‰ vaikeustason valitset...\n  \"NEUTRAALEISTA\" valinnoista et menet‰ HP:ta...\n  Valintasi j‰lkeen peli kertoo sinulle mit‰ valinnasta tapahtuu..\n  Jos sinulla on viel‰ HP:ta j‰ljell‰ jatkat seuraavalle tasolle...\n  Pelin viimeinen taso on 10 ja jos l‰p‰iset sen, voitat pelin...\n\n  Valitse vaikeustaso valintasi, kun olet valmis aloittamaan...\n  Vaikeustasot ovat kerrottu vaikeustaso valikon alla...\n");
			} else {
				System.out.println("\n  Olet siis henkilˆ, joka ei lue ohjeita...\n  Mielenkiintoista...\n  Tai sitten luit ne jo aikaisemmin...\n  Etk‰ t‰ll‰ kertaa tarvitse ohjeita...\n");
			}
}
	
    /** Metodin kuvaus:<br><br>
     * Metodissa kysyt‰‰n pelaajalta pelin {@link #vaikeustaso} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-4 v‰lilt‰.<br>
     * Metodissa {@link #vaikeustaso vaikeustaso} kysyt‰‰n pelaajalta, jonka j‰lkeen pelaajan valitsema switch-case kerrotaan pelaajalle.
     * <p>
     * Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #vaikeustaso}-muuttujan uusi arvo. <br> 
    * T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
    * Jos {@link #vaikeustaso} on muu kuin 1-4 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
  	* Vasta kun {@link #vaikeustaso} on 1-4 v‰lilt‰, palautetaan metodin return arvo.</p>
  	
	 * <p>Seuraavat tasot k‰ytt‰v‰t {@link #vaikeustaso}-muuttujaa: <br>
	 * {@link #taso1} {@link #taso2} {@link #taso4} {@link #taso5} {@link #taso6} {@link #taso7} {@link #taso8} {@link #taso9}</p>
	 * <p>
	 * <b>Esimerkki 1:</b><br><br>
	 * Vaikeustaso valikko: <br><br>
	 * <code> 1) Helppo<br>
	 *  2) Keskivaikea<br>
	 *  3) Vaikea<br>
	 *  4) Mahdoton<br><br>
	 *  Valitse vaikeustaso (1-4):</code> (k‰ytt‰j‰n valinta on <b>4</b>)<br><br>
	 *  Tulostetaan switch-case <b>4</b>:<br><br>
	 *  <code>Valitsit siis vaikeustason Mahdoton<br><br>
	 *  Aloitetaan mahdoton peli.</code>
	 * </p>
	 *  <p>
	 * <b>Esimerkki 2:</b><br><br>
	 * Vaikeustaso valikko: <br><br>
	 * <code> 1) Helppo<br>
	 * 2) Keskivaikea<br>
	 * 3) Vaikea<br>
	 * 4) Mahdoton<br><br>
	 * Valitse vaikeustaso (1-4):</code> (k‰ytt‰j‰n valinta on <b>5</b>)<br><br>
	 * Tulostetaan switch-case <b>default</b>:<br><br>
	 *<code>Anna kokonaisluku (1-4) v‰lilt‰.</code><br><br>
	 * (T‰m‰n j‰lkeen {@link #vaikeustaso} kysyt‰‰n uudelleen.) 
	 * </p>
	 * @return Palauttaa k‰ytt‰j‰n/pelaajan valitseman {@link #vaikeustaso}-muuttujan (vain jos on 1-4) ja k‰ytt‰‰ sit‰ tietyiss‰ taso-metodeissa. 
	 */

	private static int vaikeus() {	
			
			do {
			System.out.println("+---------------------+\n| Vaikeustaso valikko |\n+---------------------+\n");
			System.out.println("  1) Helppo");
			System.out.println("  2) Keskivaikea");
			System.out.println("  3) Vaikea");
			System.out.println("  4) Mahdoton\n");
			System.out.print("  Valitse vaikeustaso (1-4): ");
			vaikeustaso = lukija.nextInt();
			
			switch (vaikeustaso) {
			case 1:
				System.out.println("\n  Valitsit siis vaikeustason Helppo\n\n  Aloitetaan helppo peli...");
				break;
			case 2:
				System.out.println("\n  Valitsit siis vaikeustason Keskivaikea\n\n  Aloitetaan keskivaikea peli...");
				break;
			case 3:
				System.out.println("\n  Valitsit siis vaikeustason Vaikea\n\n  Aloitetaan vaikea peli...");
				break;
			case 4:
				System.out.println("\n  Valitsit siis vaikeustason Mahdoton\n\n  Aloitetaan mahdoton peli...");
				break;
				default: System.out.println("  Anna kokonaisluku (1-4) v‰lilt‰.\n");
				break;
			}
				}	while (vaikeustaso < 1 || vaikeustaso > 4);
		return vaikeustaso;
	}	
		
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 1 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     * Ensin {@link #HP}:lle annetaan arvo 100, eli pelaajan HP on siis 100 pelin alussa. <br>
	     * Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	    * T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	  * Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	* Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
	* <p>
	 * <b>Esimerkki 1 (negatiivinen valinta):</b><br><br>
	 * <code>{@link #HP} = 100;</code><br><br>
	 * Taso1: <br><br>
	 * (Tulostetaan taso kuvaus)<br><br>
	 *  <code>1) L‰hde etsim‰‰n miekkaa etel‰st‰<br>
	 *  2) L‰hde etsim‰‰n miekkaa ja kilpe‰ pohjoisesta<br>
	 *  3) L‰hde etsim‰‰n kilpe‰ id‰st‰<br><br>
	 *  Valitse tasovalinta (1-3):</code> (k‰ytt‰j‰n {@link #valinta} on <b>1</b>)<br><br>
	 *  Tulostetaan switch-case <b>1</b>:<br><br>
	 *  (Tulostetaan mit‰ valinnasta tapahtuu)<br><br>
	 *  Pelaaja menett‰‰ <b>10*{@link #vaikeustaso}</b> verran {@link #HP}:ta (<b>Esim.</b> vaikeustaso on 4, pelaaja menett‰‰ 40 HP:ta)
	 *  <br><br>
	 *  (<code>HP:ta j‰ljell‰: 60</code> {@link #laskuri} tulostaa t‰m‰n arvon)
	 * </p>
	 * <p>
	 * 	<b>Esimerkki 2 (positiivinen valinta):</b><br><br>
	 * <code>{@link #HP} = 100;</code><br><br>
	 * Taso1: <br><br>
	 * (Tulostetaan taso kuvaus)<br><br>
	 *  <code>1) L‰hde etsim‰‰n miekkaa etel‰st‰<br>
	 *  2) L‰hde etsim‰‰n miekkaa ja kilpe‰ pohjoisesta<br>
	 *  3) L‰hde etsim‰‰n kilpe‰ id‰st‰<br><br>
	 *  Valitse tasovalinta (1-3):</code> (k‰ytt‰j‰n {@link #valinta} on <b>3</b>)<br><br>
	 *  Tulostetaan switch-case <b>3</b>:<br><br>
	 *  Pelaajan {@link #HP}:ta kasvatetaan <b>25</b>:ll‰ ({@link #vaikeustaso}sta riippumatta)<br>
	 *  (Pelaajan uusi {@link #HP} on siis 125)<br><br>
	 *  (<code>HP:ta j‰ljell‰: 125</code> {@link #laskuri} tulostaa t‰m‰n.)
	 * </p>
	 *  <p>
	 * 	<b>Esimerkki 3:</b><br><br>
	 * <code>{@link #HP} = 100;</code><br><br>
	 * Taso1: <br><br>
	 * (Tulostetaan taso kuvaus)<br><br>
	 *  <code>1) L‰hde etsim‰‰n miekkaa etel‰st‰<br>
	 *  2) L‰hde etsim‰‰n miekkaa ja kilpe‰ pohjoisesta<br>
	 *  3) L‰hde etsim‰‰n kilpe‰ id‰st‰<br><br>
	 *  Valitse tasovalinta (1-3):</code> (k‰ytt‰j‰n {@link #valinta} on <b>0</b>)<br><br>
	 *  Tulostetaan switch-case <b>default</b>:<br><br>
	 * <code>Anna kokonaisluku (1-3) v‰lilt‰.</code><br><br>
	 * T‰m‰n j‰lkeen {@link #valinta} kysyt‰‰n uudelleen. ({@link #HP}:n arvo kuitenkin pysyy samana.)
	 * </p>
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 * @see #vaikeus
		 */
	
		private static int taso1(int vaikeustaso) {
			
			HP = 100;
			do {
			System.out.println("\n+---------------------+\n|        Taso 1       |\n+---------------------+\n");
			System.out.println("  Avaat silm‰si ja her‰‰t pime‰st‰ mets‰st‰...\n  Katselet itse‰si vahinkojen varalta ja huomaat olevasi ritari, jolla ei ole miekkaa eik‰ kilpe‰...\n  Olisi hauska tiet‰‰ miten t‰nne p‰‰dyit, ajattelet...\n  N‰ytt‰‰ silt‰, ett‰ olet lˆynyt p‰‰si johonkin, ehk‰ kannattaisi n‰ytt‰‰ p‰‰t‰si l‰‰k‰rille...\n  Olet myˆs menett‰nyt muistisi....\n  Etk‰ edes tied‰ tarkalleen miss‰ olet... \n  Selviyty‰ksesi tarvitset aseen tai kilven\n  Mit‰ teet?\n");
			System.out.println("  1) L‰hde etsim‰‰n miekkaa etel‰st‰");
			System.out.println("  2) L‰hde etsim‰‰n miekkaa ja kilpe‰ pohjoisesta");
			System.out.println("  3) L‰hde etsim‰‰n kilpe‰ id‰st‰\n");
			
			System.out.print("  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP -= 10 * vaikeustaso;
			System.out.println("  \n  L‰hdet etel‰‰n viev‰lle polulle...\n  V‰h‰n aikaa k‰velty‰si lˆyd‰t kaipaamasi miekan puun vierest‰...\n  Kurotat ottaaksesi sen, mutta kompastut puunjuureen ja miekka viilt‰‰ k‰teesi haavan...\n  Onneksesi miekka ei ollut hirve‰n ter‰v‰...\n  T‰st‰ syyst‰ p‰‰t‰t j‰tt‰‰ miekan puunjuureen...");
			System.out.println("  Menetit " + (10*vaikeustaso) + " HP:ta");
			break;
			case 2:
			System.out.println("\n  L‰hdet pohjoiseen viev‰lle polulle...\n  Miekkaa ja kilpe‰ ei kuitenkaan n‰y...\n  P‰‰t‰t jatkaa matkaasi t‰st‰ huolimatta...");
			break;
			case 3:
			HP += 25;
			System.out.println("\n  L‰hdet it‰‰n viev‰lle polulle...\n  Hetken matkattuasi n‰‰t esineen ojassa...\n  Katsot ojaan ja lˆyd‰t etsim‰si kilven...\n  T‰m‰ parantaa todenn‰kˆisyytt‰si selviyty‰\n  +25 HP");
			break;
			default: 
			System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰.");
			break;
			}
				}	while (valinta < 1 || valinta > 3);
			return laskuri(HP);
		}
		
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 2 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     * Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	    * T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    * Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    * Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	    * Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p>
		 * <b>Esimerkki 1 (neutraali valinta):</b><br><br>
		 * {@link #HP} on aiemman tason {@link #valinta}<br><br>
		 * Taso2: <br><br>
		 * (Tulostetaan taso kuvaus)<br><br>
		 *  1) Run! Forest! Run!<br>
		 *  2) Et pelk‰‰! L‰hdet rauhallisesti juoksemaan<br>
		 *  3) J‰‰t ihailemaan maisemia<br><br>
		 *  Valitse tasovalinta (1-3): (k‰ytt‰j‰n {@link #valinta} on <b>2</b>)<br><br>
		 *  Tulostetaan switch-case <b>2</b>:<br><br>
		 *  (Tulostetaan mit‰ valinnasta tapahtuu)<br><br>
		 *  Pelaajalle ei tapahdu mit‰‰n tulostetaan aiemman tason {@link #HP}:n <br>(<b>Esim.</b> jos pelaajalla oli 60 {@link #HP}:ta aiemmalla tasolla {@link #laskuri} tulostaa 60)
		 *  <br><br>
		 *  (<code>HP:ta j‰ljell‰: 60</code> {@link #laskuri} tulostaa t‰m‰n.)
		 * </p>
		 * <p>
		 * 	<b>Esimerkki 2 (Pelin h‰vi‰v‰ valinta):</b><br><br>
		 * {@link #HP} on aiemman tason {@link #valinta}<br><br>
		 * Taso2: <br><br>
		 * (Tulostetaan taso kuvaus)<br><br>
		 *  <code>1) Run! Forest! Run!<br>
		 *  2) Et pelk‰‰! L‰hdet rauhallisesti juoksemaan<br>
		 *  3) J‰‰t ihailemaan maisemia<br><br>
		 *  Valitse tasovalinta (1-3):</code> (k‰ytt‰j‰n {@link #valinta} on <b>3</b>)<br><br>
		 *  Tulostetaan switch-case <b>3</b>:<br><br>
		 *  (Tulostetaan mit‰ valinnasta tapahtuu)<br><br>
		 *  Pelaajan {@link #HP}:n arvo muutetaan <b>0</b>:ksi ({@link #vaikeustaso}sta riippumatta)<br>
		 *  (Pelaajan uusi {@link #HP}-arvo on siis 0)<br><br>
		 *  (<code>HP:ta j‰ljell‰: 0</code> {@link #laskuri} tulostaa t‰m‰n.)<br>
		 *  (Pelaaja h‰vi‰‰ pelin.)
		 * </p>
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 * @see #vaikeus
		 */
		private static int taso2(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 2       |\n+---------------------+\n");
			
			System.out.println("  L‰hdit jatkamaan matkaa eteenp‰in...\n  P‰‰dyt entist‰ synkemp‰‰n osioon mets‰ss‰...\n  Lopulta p‰‰dyt polun risteykseen...\n  Kuulet hyyt‰v‰n karjaisun takaasi...\n  Mit‰ teet?\n");
			System.out.println("  1) Run! Forest! Run!");
			System.out.println("  2) Et pelk‰‰! L‰hdet rauhallisesti juoksemaan");
			System.out.println("  3) J‰‰t ihailemaan maisemia");
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
				HP -= 10 * vaikeustaso;
				System.out.println("\n  Aijai n‰ytt‰‰ silt‰ ett‰, kompastuit h‰tikˆidess‰si kiveen...");
				System.out.println("  Menetit " + (10 * vaikeustaso) + " HP:ta");
				break;
			case 2: 
				System.out.println("\n  L‰hdet rennosti hˆlkk‰‰m‰‰n...\n  N‰et hirviˆn takanasi ja katsot sit‰ silmiin...\n  Hirviˆ kavahtaa rohkeuttasi ja j‰tt‰‰ sinut rauhaan...");
				break;
			case 3:
				HP = 0;
				System.out.println("\n  Aijai! Tyhmyytesi tulee maksaamaan sinulle kalliisti...\n  N‰et takaasi juoksevan hirviˆn ja se tappaa sinut mahdollisimman raaíalla tavalla...\n  T‰m‰ oli niin kamala tapahtuma, jota en rupea kuvailemaan tarkemmin... Sinulta voisi menn‰ yˆunet. :)");
				break;
			default: 
				System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰.");
				break;
			}
				}	while (valinta < 1 || valinta > 3);
			return laskuri(HP);	
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 3 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso3() {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 3       |\n+---------------------+\n");
			System.out.println("  P‰‰sty‰si jotenkin ihmeen kaupalla karkuun hirviˆt‰ matkasi jatkuu...\n  J‰it kuitenkin miettim‰‰n viel‰kˆ kohtaat t‰m‰n hirvitt‰v‰n otuksen...\n  Jatkoit matkaasi ja kohtasit puron...\n  Mit‰ teet?\n");
			System.out.println("  1) Etsi purosta purtavaa :)");
			System.out.println("  2) T‰yt‰ juomapullo vedell‰");
			System.out.println("  3) Ohita puro");
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP += 25;
			System.out.println("\n  Onnistuit lˆyt‰m‰‰n kalan...\n  Paistoit sen tekem‰ll‰si nuotiolla...\n  Voi juku, ett‰ kala n‰ytt‰‰ hyv‰lt‰...\n  +25 HP:ta");
			break;
			case 2:
			HP += 10;
			System.out.println("\n  Otit hˆrpyn vedest‰...\n  Vesi maistui raikkaalta juoksun j‰lkeen...\n  +10 HP:ta");
			break;
			case 3:
			System.out.println("\n  Puro ei siis kiinnosta sinua...\n  Jatkat matkaasi eteenp‰in purosta v‰litt‰m‰tt‰...");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 3);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 4 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso4(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 4       |\n+---------------------+\n");
			
			System.out.println("  Jatkat matkaa...\n  Yht‰kki‰ polun reunalta eteesi hypp‰si uhkaavan n‰kˆinen Musta Ritari...\n  Valitse viisaasti...\n");
			System.out.println("  1) Taistele Mustaa Ritaria vastaan");
			System.out.println("  2) L‰hde karkuun!");
			System.out.println("  3) Juttele Mustan Ritarin kanssa");			
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP -= 20 * vaikeustaso;
			System.out.println("\n  Musta Ritari on kunniallinen ja antaa sinulle taisteluv‰lineen...\n  Aloitatte taistelun ja pitk‰n taistelun j‰lkeen voitat Mustan Ritarin...\n  Lyˆt h‰nen p‰‰ns‰ poikki...\n  Olet v‰synyt taistelusta ja huomaat saaneesi taistelusta haavoja...");
			System.out.println("  Menetit " + (20*vaikeustaso) + " HP:ta");
			break;
			case 2:
			HP = 0;
			System.out.println("\n  L‰hdit juoksemaan karkuun...\n  Musta Ritari ei kuitenkaan tyk‰nnyt t‰st‰...\n  H‰n l‰hti per‰‰si ja heitti tikarilla sinua takaraivoon...\n  No ainakin yritit.");
			break;
			case 3:
			System.out.println("\n  Kyselit Mustalta Ritarilta kuulumisia ja huijasit h‰nt‰ vanhanaikaisella h‰m‰yksell‰...\n  Kolautit h‰nt‰ nopeasti kivell‰ p‰‰h‰n...\n  Otit Mustan Ritarin miekan ja l‰vistit h‰net monta kertaa ja viel‰ lˆit h‰nen p‰‰ns‰ irti (FATALITY)...");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 3);
			return laskuri(HP);
			
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 5 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-4 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-4 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-4 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso5(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 5       |\n+---------------------+\n");
			
			System.out.println("  Lyˆty‰si ritarin oli aika huilata ja p‰‰dyit v‰h‰n matkan p‰‰h‰n...\n  Sielt‰ lˆyd‰t Mustan Ritarin lepopaikan...\n  Valintanasi ovat seuraavat...\n");
			System.out.println("  1) J‰‰ lep‰‰m‰‰n lepopaikkaan");
			System.out.println("  2) Tutki leiripaikkaa nopeasti");
			System.out.println("  3) Tutki leiripaikkaa tarkasti");
			System.out.println("  4) Jatka matkaasi");
			
			System.out.print("\n  Anna tasovalintasi (1-4): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP = 0;
			System.out.println("\n  Yˆll‰ Valkoinen Ritari saapui lepopaikalle...\n  Oli jo liian myˆh‰ist‰...\n  Valkoinen Ritari oli saanut selville, ett‰ tapoit h‰nen kaverinsa...\n  H‰n p‰‰tti kostaa kaverinsa surman ja tappoi sinut kylm‰n rauhallisesti...");
			break;
			case 2:
			HP -= 25 * vaikeustaso;
			System.out.println("\n  Tutkit leiripaikkaa nopeasti...\n  Mutta tiput vahingossa ansaan...\n  Jonka luultavasti Musta Ritari oli viritt‰nyt sinne...\n  Satutat itsesi, etk‰ halua etsi‰ enemp‰‰...\n  Nouset ansasta ja jatkat matkaa v‰h‰n matkan p‰‰h‰n...\n  Teet oman leiripaikan ja menet nukkumaan.");
			System.out.println("  Menetit " + (25*vaikeustaso) + " HP:ta");
			break;
			case 3:
			HP += 40;
			System.out.println("\n  Tutkit leiripaikkaa tarkasti...\n  Huomaat ansan, etk‰ laukaise sit‰...\n  Leiripaikasta lˆyd‰t taikajuoman...\n  Ajattelet, ett‰ on hyv‰ idea juoda se...\n  T‰m‰n j‰lkeen jatkoit v‰h‰n matkan p‰‰h‰n Mustan Ritarin leiripaikasta...\n  Teet oman leiripaikan ja menet nukkumaan.");
			break;
			case 4:
			System.out.println("\n  Jostain syyst‰ et ole seikkailun haluinen...\n  P‰‰t‰t jatkaa matkaasi v‰h‰n matkan p‰‰h‰n...\n  Teet oman leiripaikan ja menet nukkumaan.");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-4) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 4);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 6 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-4 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-4 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-4 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso6(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 6       |\n+---------------------+\n");
			
			System.out.println("  1) L‰hde hiipim‰‰n huudon suuntaan");
			System.out.println("  2) L‰hde k‰velem‰‰n huudon suuntaan");
			System.out.println("  3) L‰hde juoksemaan huudon suuntaan");
			System.out.println("  4) L‰hde ryˆmim‰‰n huudon suuntaan");
			
			System.out.print("\n  Anna tasovalintasi (1-4): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			System.out.println("\n  Hiivit niin hiljaa, ettei Valkoinen Ritari kuule sinua...\n  N‰et Valkoisen Ritarin, eik‰ h‰n huomaa sinua...");
			break;
			case 2:
			HP = 0;
			System.out.println("\n  L‰hdit k‰velem‰‰n huudon suuntaan...\n  Matkalla astut monen risun p‰‰lle...\n  Menet leiripaikalle, siell‰ ei kuitenkaan ole ket‰‰n...\n  Yht‰kki‰ kuulet askelia takaasi...\n  Et ehdi edes vilkaista, kun miekka jo l‰vist‰‰ syd‰mesi (FATALITY)...");
			break;
			case 3:
			HP = 0;
			System.out.println("\n  L‰hdet juoksemaan huudon suuntaan ja hyˆkk‰‰t Valkoisen Ritarin kimppuun...\n  Aloittatte eeppisen taistelun...\n  Viimein onnistut nujertamaan Valkoisen Ritarin...\n  Huonoksi onneksesi huomaat olosi heikoksi...\n  V‰h‰n ajan kuluttua menet‰t n‰kˆsi ja syd‰mesi alkaa lyˆd‰ hitaammin...\n  Valkoinen Ritari oli k‰ytt‰nyt miekassaan myrkky‰...");
			break;
			case 4:
			HP -= 5 * vaikeustaso;
			System.out.println("\n  L‰hdet ryˆmim‰‰n huudon suuntaan ja ter‰v‰t kivet sattuttavat sinua...\n  N‰et kumminkin viel‰ Valkoisen Ritarin...\n  Ihme kyll‰, Valkoinen Ritari ei kuitenkaan huomaa tai kuule sinua sinua...");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-4) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 4);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 7 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso7(int vaikeustaso) {
			
			do {
			
			System.out.println("\n+---------------------+\n|        Taso 7       |\n+---------------------+");
			
			System.out.println("\n  Onnistuit v‰ltt‰m‰‰n Valkoisen Ritarin murhaavan katseen...\n  Seurasit h‰nt‰ onnistuneesti...\n  Huomaat, ett‰ h‰n on menossa luolaan...\n  Olikohan t‰m‰ h‰nen ja Mustan Ritarin aarrek‰tkˆ, tuumasit...\n  Mit‰ teet?\n");
			System.out.println("  1) L‰hde v‰littˆm‰sti seuraamaan Valkoista Ritaria");
			System.out.println("  2) Odota, ett‰ Valkoinen Ritari poistuu luolasta");
			System.out.println("  3) L‰hde jatkamaan matkaasi poisp‰in luolasta");
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP -= 40 * vaikeustaso;
			System.out.println("\n  Kuulet huutoa...\n  Huomaat, ett‰ Valkoinen Ritari taistelee urheasti aiemmin tapaamaasi hirviˆt‰ vastaan...\n  P‰‰t‰t menn‰ auttamaan h‰nt‰...\n  Valkoinen Ritari ja hirviˆ kuolevat taistelussa...\n  Selvi‰t hengiss‰, mutta taistelusta saamat haavasi n‰ytt‰v‰t vakavilta...");
			System.out.println("  Menetit " + (40*vaikeustaso) + " HP:ta");
			break;
			case 2:
				System.out.println("\n  Odotat ja odotat...\n  V‰h‰n ajan p‰‰st‰ kuulet useita avunhuutoja...\n  L‰hdit tutkimaan luolaa ja lˆyd‰t kuolleen Valkoisen Ritarin ja pahasti haavoittuneen hirviˆn...\n  P‰‰t‰t lopettaa hirviˆn tuskat...");
			break;
			case 3:
			HP = 0;
			System.out.println("\n  L‰hdet jatkamaan matkaasi...\n  Valitettavasti pelist‰ lˆytyi bugi...\n  Tiput kartan reunalta varmaan tuhoosi...");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰");
			break;
			}
				} while (valinta < 1 || valinta > 3);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 8 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-4 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-4 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-4 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso8(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 8       |\n+---------------------+");
			
			System.out.println("\n  Lyˆty‰si aiemman kohtaamasi hirviˆn luolassa...\n  Lˆyd‰t sielt‰ aarteen, onneksi olkoon...!\n  Lˆyd‰t tiesi ulos luolasta...\n  P‰‰t‰t l‰hte‰ jatkamaan polkua eteenp‰in...\n  N‰et edess‰si rotkon ja huppup‰isen henkilˆn...\n  Mit‰ teet?\n");
			System.out.println("  1) Potkaise huppup‰inen henkilˆ rotkoon");
			System.out.println("  2) Anna aarre huppup‰iselle henkilˆlle");
			System.out.println("  3) Ohita rotko");
			System.out.println("  4) Heit‰ aarre rotkoon");
			
			System.out.print("\n  Anna tasovalintasi (1-4): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP -= 25 * vaikeustaso;
			System.out.println("\n  Yrit‰t potkaista tuntemattoman henkilˆn rotkoon...\n  Jalkasi kuitenkin menee suoraan huppup‰isen henkilˆn l‰pi...\n  Huomaat h‰nen olevan haltia...\n  Haltia p‰‰tt‰‰ kirota sinut, koska yritit potkaista h‰nt‰...");
			System.out.println("  Menetit " + (25*vaikeustaso) + " HP:ta");
			break;
			case 2:
			HP += 25;
			System.out.println("\n  P‰‰t‰t olla jalo ja annat aarteesi huppup‰iselle henkilˆlle...\n  Huppup‰inen henkilˆ osoittautuukin haltiaksi...\n  Haltia sanoo jaloutesi tekev‰n h‰neen suuren vaikutuksen ja tuplaa aarteesi ja antaa sinulle taikajuoman...\n  Juotuasi juoman tunnet itsesi vahvemmaksi...\n  +25 HP:ta");
			break;
			case 3:
			System.out.println("\n  P‰‰t‰t kuitenkin viisaammaksi kiert‰‰ rotko ja salaper‰inen huppup‰inen henkilˆ...\n  Silti j‰‰t miettim‰‰n kuka h‰n oli...");
			break;
			case 4:
			HP = 0;
			System.out.println("\n  Yrit‰t heitt‰‰ aarteen rotkoon, mutta k‰tesi liimautuvat aarrearkkuun...\n  Tunnet aarteen vet‰v‰n sinua rotkoon p‰in...\n  Tiput aarteen kanssa rotkoon ja kuulet ylh‰‰lt‰ naurua...\n  Olisikohan t‰m‰ ollut huppup‰isen henkilˆn tekosia ajattelit, tippuessasi mustaan rotkoon...");
			default: System.out.println("\n  Anna kokonaisluku (1-4) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 4);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 9 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* Vasta kun {@link #valinta} on 1-3 v‰lilt‰, palautetaan metodin return arvo.</p>
	    	* Metodi on <code>int</code> tyyppinen, koska se palauttaa {@link #HP}-arvon.
		 * <p><b>Katso esimerkit t‰‰lt‰:</b> Sama toiminta periaate, kuin {@link #taso1} ja {@link #taso2}-metodeissa. </p> 
		 * @param vaikeustaso on aiemmin pelaajan valitsema {@link #vaikeustaso}, joka m‰‰ritet‰‰n {@link #vaikeus}-metodissa.
		 * @return Palauttaa {@link #HP}-arvon {@link #laskuri}-metodissa, pelaajan tasovalinnan (eli switch casen) mukaisesti.
		 * @see #laskuri 
		 */
		private static int taso9(int vaikeustaso) {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 9       |\n+---------------------+");
			
			System.out.println("\n  Jatkat matkaasi isommalle polulle...\n  Kohtaat joukon pelottavan n‰koisi‰ rosvoja, jotka himoitsevat aarrettasi...\n  Mit‰ teet?\n");
			System.out.println("  1) L‰hde karkuun");
			System.out.println("  2) Taistele rosvoja vastaan");
			System.out.println("  3) Neuvottele rosvojen kanssa");
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			System.out.println("\n  L‰hdet juoksemaan rosvoista poisp‰in...\n  Onnistut pakenemaan rosvoja, mutta puolet aarteestasi tippuu matkalle...");
			break;
			case 2:
			HP -= 15 * vaikeustaso;
			System.out.println("\n  Taistelet rosvoja vastaan urheasti...\n  Nujerrettuasi rosvot huomaat saaneesi taistelusta jonkin verran osumia...");
			System.out.println("  Menetit " + (15*vaikeustaso) + " HP:ta");
			break;
			case 3:
			HP += 25;
			System.out.println("\n  P‰‰t‰t neuvotella rosvojen kassa...\n  Rosvot olivat kuitenkin kovia neuvottelemaan...\n  Lopulta he suostuvat j‰tt‰m‰‰n sinut rauhaan, jos annat heille puolet aarteestasi...\n  P‰‰t‰t suostua heid‰n pyyntˆˆns‰...");
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰");
			break;
			}
				}	while (valinta < 1 || valinta > 3);
			return laskuri(HP);
}
	    /** Metodin kuvaus:<br><br>
	     * Metodissa kysyt‰‰n pelaajalta tason 10 {@link #valinta tasovalinta} ja sit‰ tehd‰‰n niin kauan kunnes se on <code>int</code> 1-3 v‰lilt‰.<br>
	     * <p>
	     	* Scanneri {@link #lukija} lukee k‰ytt‰j‰n antaman luvun, joka on nyt {@link #valinta}-muuttujan uusi arvo. <br> 
	     	* T‰m‰n j‰lkeen numero syˆtet‰‰n switch-case valinnalle ja switch-case:n toiminto, joka vastaa numeroa suoritetaan. <br>
	    	* Jos {@link #valinta} on muu kuin 1-3 v‰lilt‰, switch-case:n default-arvo tulostetaan ja do-while rakenteen sis‰ll‰ oleva koodi toistetaan uudelleen.<br>
	    	* </p>
	    	* Taso 10 on pelin viimeinen taso, joista kaikki switch-case {@link #valinta tasovalinnat} (paitsi <code>default:</code>) p‰‰tyv‰t loppujen lopuksi {@link #lopetus}-metodiin.<br>
	    	* Metodi on <code>void</code> tyyppinen, eik‰ se palauta mit‰‰n.
		 * <p><b>Esimerkki:</b> Pelaajan taso{@link #valinta} on 4, t‰st‰ syyst‰ tulostetaan switch-case:n <b>default</b> arvo eli <code>Anna kokonaisluku (1-3) v‰lilt‰.</code> ja do-while rakenteen sis‰ll‰ oleva koodi suoritetaan uudelleen.</p>
		 * @see #lopetus 
		 */
		private static void taso10() {
			
			do {
			System.out.println("\n+---------------------+\n|        Taso 10      |\n+---------------------+");
			
			System.out.println("\n  Olet nyt miekkaseikkailun lopussa...\n  J‰ljell‰ on viel‰ yksi valinta...\n  Saavut kotikyl‰‰si...\n  Mit‰ teet aarteellesi?\n");
			System.out.println("  1) Omi aarre itsellesi");
			System.out.println("  2) Jaa aarre kyl‰l‰isten kanssa");
			System.out.println("  3) Piilota aarre");
		
			
			System.out.print("\n  Anna tasovalintasi (1-3): ");
			valinta = lukija.nextInt();
			
			switch (valinta) {
			case 1:
			HP = 0;
			System.out.println("\n  Omittuasi aarteen itsellesi...\n  Luulet olevasi turvassa, mutta tulet hulluksi ihaillessasi aarretta...\n  Ahneutesi aktivoi aarteen kirouksen...\n  T‰st‰ syyst‰ tyˆnn‰t rahat kurkkuusi ja tukehdut niihin (FATALITY)...");
			laskuri(HP);
			break;
			case 2:
			System.out.println("\n  Onneksi olkoon! Voitit pelin onnitellut sinulle...\n  Olet nyt jalo miekkamestari ja kyl‰l‰iset rakastavat sinua.");
			lopetus();
			break;
			case 3:
			System.out.println("\n  Onneksi olkoon! Voitit pelin onnitellut sinulle...\n  Olet nyt ahne miekkamestari.");
			lopetus();
			break;
			default: System.out.println("\n  Anna kokonaisluku (1-3) v‰lilt‰.");
			break;
			}
				} while (valinta < 1 || valinta > 3);
}
		
		/** Metodin kuvaus:<br><br>
		 * Metodin tarkoitus on laskea {@link #HP}-muuttujan arvo, {@link #valinta tasovalintojen} j‰lkeen ja palauttaa se.<br><br>
		 * {@link #taso1 Taso 1}:n alussa pelaajalla on 100 {@link #HP HP:ta}. <br> 
		 * Pelin aikana pelaaja voi kuitenkin saada tai menett‰‰ {@link #HP HP:ta}. <br>
		 * Jos {@link #HP}-arvo on pienempi tai yht‰ suuri kuin 0, pelaaja h‰vi‰‰ pelin. <br>
		 * T‰m‰n j‰lkeen kutsutaan {@link #lopetus}-metodia. <br>
		 * Metodi on int tyyppinen, koska se palauttaa HP arvon. <br>
		 * <p>
		 * <b> Esimerkki: </b><br><br>
		 * (Kuvitellaan, ett‰ pelaajan {@link #HP} on -10 tason 4 j‰lkeen.)<br><br>
		 * 
		 * (Metodi tulostaa)<br><br>
		 * 
		 * <code>HP:ta j‰ljell‰: -10<br><br>
		 * 
		 * Voi ei! Taisit kuolla! El‰m‰si ei riitt‰nyt loppuun saakka, joten H‰visit pelin!</code> <br><br>
		 * 
		 * (T‰m‰n j‰lkeen kutsutaan {@link #lopetus}-metodia.) 
		 * </p>
		 * @param HP m‰‰r‰ytyy pelaajan tasovalintojen mukaan.
		 * @return Palauttaa tasovalinnan j‰lkeisen {@link #HP}-arvon riippuen pelaajan {@link #valinta tasovalinnasta}.
		 * @see #lopetus
		 */
		private static int laskuri(int HP) {
			System.out.println("  \n  HP:ta j‰ljell‰: " + HP);
			if (HP <= 0) {
				System.out.println("\n  Voi ei! Taisit kuolla! El‰m‰si ei riitt‰nyt loppuun saakka, joten H‰visit pelin!\n");
				lopetus();
			}
			return HP;
		}
		
		/** Metodin kuvaus:<br><br>
		 * Metodin on tarkoitus kysy‰ k‰ytt‰j‰lt‰ {@link #vastaus}-muuttujan arvo ja haluaako k‰ytt‰j‰ jatkaa pelaamista vai lopettaa pelin.<br>
		 * Metodia k‰ytet‰‰n {@link #taso10} ja {@link #laskuri}-metodeissa. <br>
		 * Metodin avulla voidaan p‰‰tt‰‰ lopetetaanko peli vai jatketaanko sit‰. <br>
		 * Metodissa kysyt‰‰n k‰ytt‰j‰lt‰ {@link #vastaus}-muuttujan arvo. <br>
		 * Metodin sis‰ll‰ on if-else rakenne, joka tarkistaa haluaako pelaaja jatkaa vai ei. <br>
		 * Jos k‰ytt‰j‰n/pelaajan {@link #vastaus} on <code>true</code>, peli aloitetaan alusta. <br>
		 * Jos k‰ytt‰j‰n/pelaajan {@link #vastaus} on <code>false</code>, pelin suoritus lopetetaan. <br>
		 * Metodi on <code>void</code> tyyppinen, eik‰ palauta siis mit‰‰n. <br>
		 * <p>
		 * <b> Esimerkki: </b><br><br>
		 * (Kuvitellaan, ett‰ pelaaja h‰visi pelin {@link #taso8 tasolla 8}. H‰nelt‰ kysyt‰‰n seuraava kysymys.)<br><br>
		 * <code>Haluatko yritt‰‰ uudelleen? (true/false):</code> (k‰ytt‰j‰n {@link #vastaus} on <b>true</b>) <br>
		 * <code>Janoat siis lis‰‰ saamasi pit‰‰!<br>
		 * Aloitetaan peli alusta...</code><br>
		 * (Peli palaa {@link #main main-metodiin} ja koodi toistetaan do-while rakenteen alusta.) 
		 * </p>
		 * @see #laskuri
		 * @see #taso10
		 */
		private static void lopetus() {
			
			System.out.print("  Haluatko yritt‰‰ uudelleen? (true/false): ");
			vastaus = lukija.nextBoolean();
			
			if (vastaus == false) {
				System.out.println("  Sait siis tarpeeksesi? Hyv‰ on...");
				System.out.println("  Lopetit pelin.");
				System.exit(0);
			}
			else {
				System.out.println("  Janoat siis lis‰‰? Saamasi pit‰‰!");
				System.out.println("  Aloitetaan peli alusta...\n");
			}
		}
}