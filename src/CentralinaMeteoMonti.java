// Centralina meteo specializzata per le aree marine.
// Utilizzo l'ereditarietà tra classi

//package meteo;
// Eseguire da riga di comando con java -cp ".\" TestCentralina
public class CentralinaMeteoMonti extends CentralinaMeteo {
	
	private int precipitazioneNeve;
	private int livelloNeve;
	
	public CentralinaMeteoMonti(String id, float velocitaVento, int quantitaPioggia,
		float temperatura, int precipitazioneNeve, int livelloNeve) {

		// la parola chiave "super" è un riferimento alla classe madre		
		super(id, velocitaVento, quantitaPioggia, temperatura);
		// super può essere usato per riferirsi al costruttore (vedi sopra) della
		// classe madre: super(....) oppure ad un suo attributo, vedi riga sotto.
		super.id = id; // riga cancellabile
		this.precipitazioneNeve = precipitazioneNeve;
		this.livelloNeve = livelloNeve;
	}
	
	// TODO: creare il costruttore di copia
	
	public CentralinaMeteoMonti() {
		super();
	}
	
	// TODO: modificare usando il metodo toString della classe madre
	public String toString() {
		return "Centralina: " + id  + " (" + super.numeroCentraline + ")"
			+ "\n\rquantita\' pioggia " + quantitaPioggia
			+ "\n\rvelocita\' vento " + velocitaVento
			+ "\n\rtemperatura " + temperatura
			+ "\n\rneve caduta " + precipitazioneNeve
			+ "\n\rlivello neve accumulata " + livelloNeve
			+ "\n-------------------------------\n";
	}
	
	
	
}