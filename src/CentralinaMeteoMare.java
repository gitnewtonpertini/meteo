// Centralina meteo specializzata per le aree marine.
// Utilizzo l'ereditarietà tra classi

//package meteo;
// Eseguire da riga di comando con java -cp ".\" TestCentralina
public class CentralinaMeteoMare extends CentralinaMeteo {
	
	private int sogliaAcqua;
	
	public CentralinaMeteoMare(String id, float sogliaVento, int sogliaPioggia,
			float sogliaTemperatura, int sogliaAcqua) {
		// la parola chiave "super" è un riferimento alla classe madre
		super(id, sogliaVento, sogliaPioggia, sogliaTemperatura);
		this.sogliaAcqua = sogliaAcqua;
	}

	// TODO: creare il costruttore di copia

	public CentralinaMeteoMare() {
		super();
	}

	@Override
	public String toString() {
		return "CentralinaMeteoMare " + super.numeroCentraline + "[sogliaAcqua=" + sogliaAcqua + ", toString()=" + super.toString() + "]";
	}

	
	
	
}