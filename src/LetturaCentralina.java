import java.time.LocalDateTime;

public class LetturaCentralina extends Lettura {

	private int quantitaPioggia;

	public LetturaCentralina(String idStrumento, LocalDateTime dataOra, float velocitaVento, float temperatura,
			float pressione, int quantitaPioggia) {
		super(idStrumento, dataOra, velocitaVento, temperatura, pressione);
		this.quantitaPioggia = quantitaPioggia;
	}

	public int getQuantitaPioggia() {
		return quantitaPioggia;
	}

	public void setQuantitaPioggia(int quantitaPioggia) {
		this.quantitaPioggia = quantitaPioggia;
	}

	@Override
	public String toString() {
		return super.toString() + "LetturaCentralina [quantitaPioggia=" + quantitaPioggia + "]";
	}
	
}
