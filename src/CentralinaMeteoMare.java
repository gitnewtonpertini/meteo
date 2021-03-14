// Centralina meteo specializzata per le aree marine.
// Utilizzo l'ereditarietà tra classi

//package meteo;
// Eseguire da riga di comando con java -cp ".\" TestCentralina
public class CentralinaMeteoMare extends CentralinaMeteo {
	
	private int livelloAcqua;
	
	public CentralinaMeteoMare(String id, float velocitaVento, int quantitaPioggia, float temperatura) {
		// la parola chiave "super" è un riferimento alla classe madre
		super(id, velocitaVento, quantitaPioggia, temperatura);
	}
	
	public CentralinaMeteoMare(String id, float velocitaVento, int quantitaPioggia, float temperatura, int livelloAcqua) {
		super(id, velocitaVento, quantitaPioggia, temperatura);
		this.livelloAcqua = livelloAcqua;
	}

	// TODO: creare il costruttore di copia

	public CentralinaMeteoMare() {
		super();
	}
	
	public String toString() {
		return "Centralina: " + id + " (" + super.numeroCentraline + ")"
			+ "\n\rquantita\' pioggia " + quantitaPioggia
			+ "\n\rvelocita\' vento " + velocitaVento
			+ "\n\rtemperatura " + temperatura
			+ "\n\rlivello acqua " + livelloAcqua
			+ "\n-------------------------------\n";
	}
	
	
	
}