import java.time.LocalDateTime;

public class LetturaPallone extends Lettura {

	private int altitudine;

	public LetturaPallone(String idStrumento, LocalDateTime dataOra, float velocitaVento, float temperatura,
			float pressione, int altitudine) {
		super(idStrumento, dataOra, velocitaVento, temperatura, pressione);
		this.altitudine = altitudine;
	}

	public int getaltitudine() {
		return altitudine;
	}

	public void setaltitudine(int altitudine) {
		this.altitudine = altitudine;
	}

	@Override
	public String toString() {
		return super.toString() + "LetturaPallone [altitudine=" + altitudine + "]";
	}
	
}
