import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Rete di rilevamento meteo
* @author 4A ITI
* @version 1.0
*/
public class ReteMeteo {

    final String  NOME_RETE = "RETE RILEVAMENTO VENETO";
    private CentralinaMeteo centraline[];
    private IStrumentoMeteo strumenti[];
    // TODO: far si che sia una multilista...
    private Lettura registro[];
	private int numeroMaxCentraline;
	private int numeroMaxStrumenti;
	private int numeroMaxLetture;

    /**
    * Costruttore dell'array delle centraline: si limita solo alla allocazione (new)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param numeroCentraline numero di elementi dell'array
    */  
    public ReteMeteo(int numeroMaxCentraline, int numeroMaxStrumenti) {
        // Allocazione nella memoria heap dello spazio necessario per un numeroCentraline
        // di oggetti pari al valore del parametro (numeroCentraline) passato.
        centraline = new CentralinaMeteo[numeroMaxCentraline];
		this.numeroMaxCentraline = numeroMaxCentraline;
        // Idem per l'array degli strumenti (centraline o palloni)
        strumenti = new IStrumentoMeteo[numeroMaxStrumenti];
		this.numeroMaxStrumenti = numeroMaxStrumenti;
    }
    
    /**
    * Costruttore dell'array delle centraline: inizializza l'array delle centraline
    * caricandole da un file CSV, il metodo carica le centraline dal file finchè c'è posto
    * nell'array.
    * @param numeroCentraline numero di elementi dell'array
    * @param nomeFile nome del file CSV contenente le centraline
    */  
    public ReteMeteo(int numeroMaxCentraline, String nomeFile) {
        // Allocazione nella memoria heap dello spazio necessario per un numeroCentraline
        // di oggetti pari al valore del parametro (numeroCentraline) passato.
        centraline = new CentralinaMeteo[numeroMaxCentraline];       
		this.numeroMaxCentraline = numeroMaxCentraline;
    	BufferedReader br = null;
    	int numeroCentraline = 0;
    	String riga;
    	int i;
    	try {
    		i = 0;
    		br = new BufferedReader(new FileReader(nomeFile + ".csv"));
    		// Leggo le righe delle centraline dal file finchè ce ne sono e c'è posto
    		// nell'array delle centaline
    		while ((riga = br.readLine()) != null && i < numeroMaxCentraline) {
    			String valoriCentralina[] = riga.split(";");
    			centraline[i] = new CentralinaMeteo(
    					valoriCentralina[0], // Id
    					Float.parseFloat(valoriCentralina[1]), // velocità vento
    					Integer.parseInt(valoriCentralina[2]), // quantita pioggia
    					Float.parseFloat(valoriCentralina[3]), // temperatura
    					Float.parseFloat(valoriCentralina[4]), // soglia temperatura					
    					Integer.parseInt(valoriCentralina[5]), // soglia pioggia
    					Float.parseFloat(valoriCentralina[6]) // soglia vento
    			);
    			i++;
    		}
    		br.close();
    	}
    	// Da togliere e mettere nel metodo leggiCentralineDaFile
    	catch(FileNotFoundException e) {
    		// Visualizzo un messaggio "per il cliente"
    		System.out.println("ERRORE: il file " + nomeFile + "non esiste");
    		// Registro in un file di Log informazioni sull'eccezione "utili al programmatore"
    		Logger.getLogger("RETE METEO (ReteMeteo.java)").log(Level.SEVERE, null, e);
    	} catch (IOException e) {
    		System.out.println("ERRORE: si è verificato un problema in fase di apertura del file");
    		// Registro in un file di Log informazioni sull'eccezione "utili al programmatore"
    		Logger.getLogger("RETE METEO (ReteMeteo.java)").log(Level.SEVERE, null, e);
		} catch (NumberFormatException e) {
			System.out.println("ERRORE: errore nel formato dei dati nel file CSV");
			// Registro in un file di Log informazioni sull'eccezione "utili al programmatore"
			Logger.getLogger("RETE METEO (ReteMeteo.java)").log(Level.SEVERE, null, e);
    	}
    }
       
    /**
    * Riceve come parametro un'oggetto di classe centralina e lo inserisce 
    * nell'array centraline nella posizione passata come parametro
    * @param pos posizione nella quale si vuole inserire l'oggetto CentralinaMeteo
    * @param CentralinaMeteo centralina da inserire nell'array centraline 
    */
    public void setCentralina(int pos, CentralinaMeteo centralina) {
        
        // L'oggetto centralina (quindi gia creato) viene inserito nell'array nella posizione pos (parametro)  
        centraline[pos] = centralina;
    }
    
    /**
    * Riceve come parametro un'oggetto di classe centralina e lo inserisce 
    * nell'array centraline nella prima posizione libera (null)
    * @param CentralinaMeteo centralina da inserire nell'array centraline 
    */
    public void setCentralina(CentralinaMeteo centralina) {
        
        // L'oggetto centralina (quindi gia creato) viene inserito nell'array nella posizione pos (parametro)  
		int i = 0;
		// Il ciclo termina quando viene trovato un posto libero (null) oppure
		// si è arrivati alla fine dell'array (i == numeroCentraline)
		// senza aver trovato un posto libero.
		while (centraline[i] != null && i < numeroMaxCentraline)
			i++;
		if (i < numeroMaxCentraline)
			centraline[i] = centralina;
    }
    
    /**
    * Riceve come parametro un'oggetto di classe centralina e lo inserisce 
    * nell'array centraline nella prima posizione libera (null)
    * @param CentralinaMeteo centralina da inserire nell'array centraline 
    */
    public void setStrumento(IStrumentoMeteo strumento) {
        
        // L'oggetto centralina (quindi gia creato) viene inserito nell'array nella posizione pos (parametro)  
		int i = 0;
		// Il ciclo termina quando viene trovato un posto libero (null) oppure
		// si è arrivati alla fine dell'array (i == numeroCentraline)
		// senza aver trovato un posto libero.
		while (strumenti[i] != null && i < numeroMaxCentraline)
			i++;
		if (i < numeroMaxStrumenti)
			strumenti[i] = strumento;
    }
    
    /**
    * Crea un'oggetto di classe CentralinaMeteo mediante gli attributi passati come parametri e lo 
    * inserisce nell'array centraline nella posizione passata come parametro 
    * @param pos posizione nella quale si vuole inserire l'oggetto CentralinaMeteo
    * @param String id Identificativo
    * @param float velocitaVento Velocità del vento
    * @param int quantitaPioggia Quantità di pioggia caduta
    * @param float temperatura temperatura rilevata
    */
    public void setCentralina(int pos, String id, float velocitaVento, int quantitaPioggia, float temperatura) {
        
        centraline[pos] = new CentralinaMeteo(id, velocitaVento, quantitaPioggia, temperatura);
    }
    
    /**
    * Restituisce la centralina che si trova nella posizione indicata dal parametro "pos"
    * @param pos posizione (indice) nell'array della centralina
    */
    public CentralinaMeteo getCentralina(int pos) {
        
        return centraline[pos];

    }
	
	/**
    * Restituisce la centralina corrispondente all'identificativo passato come parametro (id)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param id Identificativo della centralina da ricercare nell'array
    */
    public CentralinaMeteo getCentralina(String id) {
        
		// Modificare il ciclo for oppure utilizzare un ciclo while
		// in modo che non si sia costretti a scorrere tutto l'array
		// nel caso in cui la centralina sia trovata prima che il ciclo
		// sia giunto alla fine
		CentralinaMeteo cent = null;
		boolean trovata = false;
	
        for (int i = 0; i < numeroMaxCentraline; i++)
			if (centraline[i].getId().equals(id)) {
				cent = centraline[i];
				break;
			}

			// ATTENZIONE: restituisce il riferimento, quindi, le modifiche
		// che verranno fatte sull'oggetto restituito verranno fatte anche
		// all'oggetto che si trova sull'array (perche si tratta dello stesso oggetto)
		// Per evirare questo problema si deve restituire una copia creata invocando il
		// costruttore di copia: return CentralinaMeteo(cent);
		return cent;	
    }
    

	/**
    * Restituisce la centralina corrispondente all'identificativo passato come parametro (id)
    * della memoria necessaria per memorizzare i valori di ogni oggetto
    * (di tipo CentralinaMeteo) dell'array
    * @param id Identificativo della centralina da ricercare nell'array
    */
    public CentralinaMeteo getCentralina2(String id) {
        
		// Modificare il ciclo for oppure utilizzare un ciclo while
		// in modo che non si sia costretti a scorrere tutto l'array
		// nel caso in cui la centralina sia trovata prima che il ciclo
		// sia giunto alla fine
		CentralinaMeteo cent = null;
		boolean trovata = false;
	
        for (int i = 0; (i < numeroMaxCentraline && !trovata); i++)
			if (centraline[i].getId().equals(id)) {
				cent = centraline[i];
				trovata = true;
			}
		return cent;	
    }
    
    // Salvataggio dell'array delle centraline in un file
    // @param nomeFile Nome del file su cui salvare le centraline
    // @param append se true aggiunge le centraline a quelle esisteni nel file; 
    // altrimenti azzera il file e salva le nuove
    // ATTENZIONE: GESTIRE LA MODALITA' APPEND
    public int salvaCentralineSuFile(String nomeFile) {
    	
    	BufferedWriter bw = null;
    	int numeroCentraline = 0;
    	
    	try {
    		bw = new BufferedWriter(new FileWriter(nomeFile + ".csv"));
    		int i = 0;
    		String centralinaCSV = "";
    		// Meglio con un ciclo for
    		while (i < numeroMaxCentraline) {
    			if (centraline[i] != null) {
    				centralinaCSV = centraline[i].id + ";" + centraline[i].velocitaVento + ";" + centraline[i].quantitaPioggia + ";" + centraline[i].temperatura + ";" + centraline[i].sogliaVento + ";" + centraline[i].sogliaPioggia + ";" + centraline[i].sogliaTemperatura;
    				bw.write(centralinaCSV, 0, centralinaCSV.length());
    				bw.newLine();
    				numeroCentraline++;
    			}
    			i++;
    		}
    		bw.close();
    	}
    	// Da togliere e mettere nel metodo leggiCentralineDaFile
    	catch(FileNotFoundException e) {
    		// Visualizzo un messaggio "per il cliente"
    		System.out.println("ERRORE: il file " + nomeFile + "non esiste");
    		// Registro in un file di Log informazioni sull'eccezione "utili al programmatore"
    		Logger.getLogger("RETE METEO (ReteMeteo.java)").log(Level.SEVERE, null, e);
    		return -1;
    	} catch (IOException e) {
    		System.out.println("ERRORE: si è verificato un problema in fase di apertura del file");
    		// Registro in un file di Log informazioni sull'eccezione "utili al programmatore"
    		Logger.getLogger("RETE METEO (ReteMeteo.java)").log(Level.SEVERE, null, e);
    		return -1;
		}
    	
    	return numeroCentraline;
        
    }

	public void stampaCentraline() {
		// TODO Auto-generated method stub
		
	} 
        
}