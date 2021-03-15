// Centralina meteo specializzata per le aree marine.
// Utilizzo l'ereditarietà tra classi

//package meteo;
// Eseguire da riga di comando con java -cp ".\" TestCentralina
public class CentralinaMeteoMonti extends CentralinaMeteo {
	
	private int sogliaNeve;
	
	public CentralinaMeteoMonti(String id, float sogliaVento, int sogliaPioggia, 
			float sogliaTemperatura, int sogliaNeve) {

		// la parola chiave "super" è un riferimento alla classe madre		
		super(id, sogliaVento, sogliaPioggia, sogliaTemperatura);
		// super può essere usato per riferirsi al costruttore (vedi sopra) della
		// classe madre: super(....) oppure ad un suo attributo, vedi riga sotto.
		this.sogliaNeve = sogliaNeve;
	}
	
	// TODO: creare il costruttore di copia
	
	public CentralinaMeteoMonti() {
		super();
	}

	@Override
	public String toString() {
		return "CentralinaMeteoMonti " + super.numeroCentraline + "[sogliaNeve=" + sogliaNeve + ", toString()=" + super.toString() + "]";
	}
	

	
}