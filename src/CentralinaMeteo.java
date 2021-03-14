// Il package è un contenitore di classi, utile per organizzare
// in modo modulare i componenti di una applivazione
//package meteo;

// Il nome della classe deve coincidere con il nome del file
/**
* Centralina meteo
* @author 4A ITI
* @version 1.0
*/
public class CentralinaMeteo implements IStrumentoMeteo {
	// Le proporietà/attributi della classe sono dichiarati
	// privati (data hiding/incapsulamento)
	protected final String ENTE_PROPRIETARIO = "ARPANP - Newton-Pertini";
	
	// Una proprietà statica è una proprietà di classe ovvero il suo valore è condiviso
	// (lettura/scrittura) dagli oggetti (istanze) della classe)
	protected static int numeroCentraline = 0;
	protected String id;
	// TODO: queste tre propriet� devono essere tolte da qui
	// perch� sono delle propriet� della classe Lettura
	protected float velocitaVento; 
	protected int quantitaPioggia;
	protected float temperatura;
	
	protected float sogliaVento;
	protected int sogliaPioggia;
	protected float sogliaTemperatura;

	// Il costruttore è responsabile dell'inizializzazione degli attributi
	// di un oggetto; i valori di soglia vengono impostati con valori di default (scelta del programmatore)
	public CentralinaMeteo(String id, float velocitaVento, int quantitaPioggia, float temperatura) {
		// la keyword this significa "questo oggetto/istanza", in questo caso è
		// utile per risolvere l'ambiguità deruvante dal fatto che parametro e attributo
		// della classe hanno lo stesso nome.
		this.id = id;
		this.velocitaVento = velocitaVento;
		this.quantitaPioggia = quantitaPioggia;
		this.temperatura = temperatura;
		// TODO: I seguenti valori di default potrebbero essere letti da un filer di configurazione
		sogliaPioggia = 200;
		sogliaVento = 100;
		sogliaTemperatura = -5;
		numeroCentraline++;
	}

	// Costruttore che riceve anche i valori delle soglie
	public CentralinaMeteo(String id, float velocitaVento, int quantitaPioggia, float temperatura,
			float sogliaTemperatura, int sogliaPioggia, float sogliaVento) {
		// la keyword this significa "questo oggetto/istanza", in questo caso è
		// utile per risolvere l'ambiguità deruvante dal fatto che parametro e attributo
		// della classe hanno lo stesso nome.
		this.id = id;
		this.velocitaVento = velocitaVento;
		this.quantitaPioggia = quantitaPioggia;
		this.temperatura = temperatura;
		this.sogliaPioggia = sogliaPioggia;
		this.sogliaVento = sogliaVento;
		this.sogliaTemperatura = sogliaTemperatura;
		numeroCentraline++;
	}

	// Il costruttore di copia serve per creare un oggetto che è una copia di un altro
	// oggetto della medesima classe.
	public CentralinaMeteo(CentralinaMeteo centralinaMeteo) {
		this.id = centralinaMeteo.id;
		this.velocitaVento = centralinaMeteo.velocitaVento;
		this.quantitaPioggia = centralinaMeteo.quantitaPioggia;
		this.temperatura = centralinaMeteo.temperatura;
		// I seguenti valori di default potrebbero essere letti da un filer di configurazione
		sogliaPioggia = centralinaMeteo.sogliaPioggia;
		sogliaVento = centralinaMeteo.sogliaVento;
		sogliaTemperatura = centralinaMeteo.sogliaTemperatura;		
		numeroCentraline++;
	}
	// Il costruttore vuoto crea un oggetto non inizializzato (utile in determinate
	// circostanze)
	public CentralinaMeteo() {}
	
	// Metodi "setters" e "getters"
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setVelocitaVento(float velocitaVento) throws SogliaVentoException {
		if (velocitaVento > sogliaVento)
			throw new SogliaVentoException(velocitaVento, this.sogliaVento);
		this.velocitaVento = velocitaVento;
	}
	
	public float getVelocitavento() {
		return velocitaVento;
	}
	public void setQuantitaPioggia(int sogliaPioggia) throws SogliaPioggiaException {
		if (quantitaPioggia > sogliaPioggia)
			throw new SogliaPioggiaException(quantitaPioggia, this.sogliaPioggia);
		this.quantitaPioggia = quantitaPioggia;
	}
	
	public int getQuantitaPiogia() {
		return quantitaPioggia;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
	public float getTemperatura() {
		return temperatura;
	}
	
	public void setSogliaVento(float sogliaVento) {
		this.sogliaVento = sogliaVento;
	}
	
	public float getSogliaVento() {
		return sogliaVento;
	}
	public void setSogliaPioggia(int sogliaPioggia) {
		this.sogliaPioggia = sogliaPioggia;
	}
	
	public int getSogliaPioggia() {
		return sogliaPioggia;
	}
	public void setSogliaTemperatura(float sogliaTemperatura) {
		this.sogliaTemperatura = sogliaTemperatura;
	}
	
	public float getSogliaTemperatura() {
		return sogliaTemperatura;
	}

	public String toString() {
		return "Centralina: " + id 
			+ "\n\rquantita\' pioggia " + quantitaPioggia
			+ "\n\rvelocita\' vento " + velocitaVento
			+ "\n\rtemperatura " + temperatura
			+ "\n-------------------------------\n";
	}
	
	/**
	* Estrae il codice zona dall'id 
	* di un altra centralina
	* @param id id centralina da cui estrarre il codice zona
	* @return String Codice della zona
	*/
	public String codiceZona(String id) {
	    return id.substring(id.indexOf('_') + 1, id.lastIndexOf('_') + 1);
	}
	
	/**
	* Confronta il codice della zona con il codice della zona 
	* di un altra centralina
	* @param centralina Centralina con la quale si desidera eseguire il confronto della zona
	* @return boolean true se il codice corrisponde, false altrimenti
	*/
	public boolean stessaZona(CentralinaMeteo centralina) {
	    
		String strCodiceZona = codiceZona(this.id);
		if (strCodiceZona != null && centralina != null)
			// Il confronto tra due stringhe si fa mediante il metodo "equals"
			// sarebbe errato utilizzare l'operatore == perchè in tal caso
			// si confronterebbero i riferimenti.
			//return strCodiceZona == codiceZona(centralina.getId());
			// TODO: bisogna controllare che il codice zona del parametro centralina
			// non sia null (come si comporta in questo caso il metodo equals?)
		    return strCodiceZona.equals(codiceZona(centralina.getId()));
		else
		    return false;
	}
	
}
