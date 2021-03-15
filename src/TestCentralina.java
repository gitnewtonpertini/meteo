// Il package è un contenitore di classi, utile per organizzare
// in modo modulare i componenti di una applivazione
//package meteo;

public class TestCentralina {

	public static void main(String[] args) {
		
		// L'attributo "numeroCentraline" è di tipo "static", quindi ne è possibile usare
		// il valore senza aver creato un oggetto della classe
		//System.out.println("Numero centraline " + CentralinaMeteo.numeroCentraline);
		// Dichiarazione di una variabile/oggetto di class CentralinaMeteo
		CentralinaMeteo centCamposampiero_01;
		
		// Creazione di un oggetto/istanza della classe CentralinaMeteo
		centCamposampiero_01 = new CentralinaMeteo("CENT_CSP_01", 30, 10, 22);
		
		// Il metotodo toString, non è un metodo della classe CentralinaMeteo,
		// ma della classe Object. In Java tutte le classi (implicitamente)
		// sono "figlie" della classe Object, quindi ne ereditano le proprietà
		// ed i metodi.
		// https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
		System.out.println("\n--- TEST CLASSE CentralinaMeteo");		
		System.out.println(centCamposampiero_01.toString());
		
		// Test classe figlia CentralinaMeteoMare; creo un oggetto vuoto
		// attenzione: vuoto non significa null
		System.out.println("\n--- TEST CLASSE FIGLIA CentralinaMeteoMare");		
		CentralinaMeteoMare centVenezia_01;
		centVenezia_01 = new CentralinaMeteoMare();
		if (centVenezia_01 == null)
			System.out.println("Oggetto inesistente (nullo: non allocata memoria)");
		else
			System.out.println("Oggetto esistente (allocata memoria)");
			
		// Creo un oggetto della classe figlia, ma praticamente uguale
		// ad un oggetto della classe madre (nella classe figlia non ho ancora
		// aggiunto alcun attributo.
		System.out.println("\n--- STAMPA CENTRALINA CLASSE MeteoMare");
		CentralinaMeteoMare centVenezia_02;
		centVenezia_02 = new CentralinaMeteoMare("CENT_VNZ_02", 20, 15, 30, 50);
		System.out.println(centVenezia_02.toString());
		
		// Creo un oggetto della classe figlia attribuendo un valore anche
		// all'attributo dichiarato (livelloAcqua) nella classe figlia 
		System.out.println("\n--- STAMPA CENTRALINA CLASSE MeteoMonti");
		CentralinaMeteoMonti centArabba_01;
		centArabba_01 = new CentralinaMeteoMonti("CENT_ARB_01", 25.5f, 13, 40.0f, 20);
		System.out.println(centArabba_01.toString());

		// Verifica codice zona di due centraline
		System.out.println("\n--- CODICE ZONA");
		System.out.println(centArabba_01.stessaZona(centVenezia_02) ? "Stessa zona" : "Zone diverse");
		CentralinaMeteoMonti centArabba_02 = new CentralinaMeteoMonti("CENT_ARB_02", 25.0f, 13, 30.0f, 20);
		System.out.println(centArabba_01.stessaZona(centArabba_02) ? "Stessa zona" : "Zone diverse");
		
		// Creazione dell'array delle centraline
		System.out.println("\n--- STAMPA CENTRALINA DA ARRAY");
		ReteMeteo reteMeteo_01 = new ReteMeteo(10, 10);
		reteMeteo_01.setCentralina(3, "CENT_ROV_01", 22, 15, 30);
		if (reteMeteo_01.getCentralina(3) != null)
			System.out.println(reteMeteo_01.getCentralina(3).toString());
		else
			System.out.println("Oggetto nullo");
		
		// Inserimento di un oggetto nell'array delle centraline
		System.out.println("\n--- INSERIMENTO OGGETTO CENTRALINAMETEO IN ARRAY ");
		CentralinaMeteo centPiombinoDese_01;
		centPiombinoDese_01 = new CentralinaMeteo("CENT_PMD_01", 30, 23, 32);	
		reteMeteo_01.setCentralina(4, centPiombinoDese_01);
		System.out.println(reteMeteo_01.getCentralina(4));
		
		// TODO: verificare se le modifiche fatte nell oggetto centPiombinoDese_01 (ad es. modifica dell'Id) 
		// si ripercuotono anche sull' oggetto che e' stato inserito nell'array (domanda: l oggetto e' lo stesso?)		
		System.out.println("\n--- RISTAMPA OGGETTO IN ARRAY DOPO MODIFICA NEL main() ");
		centPiombinoDese_01.setId("CENT_ZZZ_00");
		System.out.println(reteMeteo_01.getCentralina(4));
        
		// Inserimento di una copia di un oggetto nell'array delle centraline
        // per evitare il problema dei riferimenti (oggetto in array centraline = oggetto creato
        // nel main)
		System.out.println("\n--- INSERIMENTO COPIA OGGETTO CENTRALINAMETEO IN ARRAY ");
		CentralinaMeteo copiaCentPiombinoDese_01;
		copiaCentPiombinoDese_01 = new CentralinaMeteo(centPiombinoDese_01);	
		reteMeteo_01.setCentralina(5, copiaCentPiombinoDese_01);
		System.out.println(reteMeteo_01.getCentralina(5));   
        
		// Inserimento di una centralina, nell'array di una rete meteo, nella
		// prima posizione vuota (null)
		System.out.println("\n--- INSERIMENTO CENTRALINAMETEO PRIMO POSTO VUOTO IN ARRAY E RICERCA PER ID");
		CentralinaMeteo centRustega_01;
		centRustega_01 = new CentralinaMeteo("CENT_RUS_01", 25, 20, 32);	
		reteMeteo_01.setCentralina(centRustega_01);
		
		// Ricerca di una centralina corrispondente all'id
		System.out.println("\n--- RICERCA PER ID");
		CentralinaMeteo cent_99 = reteMeteo_01.getCentralina("CENT_RUS_01");
		cent_99.setTemperatura(100);
		System.out.println(cent_99.toString());
		
		// Impostazione di un nuovo valore di velocità superiore alla soglia di allarme
		// con conseguente generazione dell'eccezione
		System.out.println("\n--- GENERAZIONE/GESTIONE DELL'ECCEZIONE DI TIPO CHECKED: extends Exception");
		try {
			cent_99.setVelocitaVento(150);
		} catch (SogliaVentoException e) {
			System.out.println(e.getMessaggio());
		}
		
		System.out.println("\n--- GENERAZIONE/GESTIONE DELL'ECCEZIONE DI TIPO UN-CHECKED extends RunTimeException");
		cent_99.setQuantitaPioggia(1000);
		System.out.println("CONTINUA?");
        
		System.out.println("\n--- SALVATAGGIO DEI DATI DELLE CENTRALINE IN UN FILE");
        int numeroCentraline = reteMeteo_01.salvaCentralineSuFile("reteMeteo_01");
		System.out.println("\n--- SONO STATE SALVATE " + numeroCentraline);
		
		System.out.println("\n--- LETTURA DEI DATI DELLE CENTRALINE IN UN FILE");
		ReteMeteo reteMeteo_02 = new ReteMeteo(10, "reteMeteo_01");
		reteMeteo_02.stampaCentraline();   

		System.out.println("\n--- CREAZIONE DI UN OGGETTO DI TIPO PalloneSonda");
		PalloneSonda pal_cmp_01 = new PalloneSonda("PAL_CMP_01", 34000, 10);	
		PalloneSonda pal_cmp_02 = new PalloneSonda("PAL_CMP_02", 54000, 15);
		reteMeteo_01.setStrumento(centCamposampiero_01);
        reteMeteo_01.setStrumento(pal_cmp_01);
        reteMeteo_01.setStrumento(pal_cmp_02);
		
        
	}
}
