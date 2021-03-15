import java.time.LocalDateTime;

/**
* Classe che rappresenta la lettura dei valori di uno strumento generico (Centralina/Pallone sonda)
* @author 4A ITI
* @version 1.0
*/
public class Lettura {
	
	String idStrumento;
	protected LocalDateTime dataOra;
	protected float velocitaVento; 
	protected float temperatura;
	protected float pressione;
	
	public Lettura(String idStrumento, LocalDateTime dataOra, float velocitaVento, float temperatura, float pressione) {
		super();
		this.idStrumento = idStrumento;
		this.dataOra = dataOra;
		this.velocitaVento = velocitaVento;
		this.temperatura = temperatura;
		this.pressione = pressione;
	}

	@Override
	public String toString() {
		return "Lettura [idStrumento=" + idStrumento + ", dataOra=" + dataOra + ", velocitaVento=" + velocitaVento
				+ ", temperatura=" + temperatura + ", pressione=" + pressione + "]";
	}

	public String getIdStrumento() {
		return idStrumento;
	}

	public void setIdStrumento(String idStrumento) {
		this.idStrumento = idStrumento;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

	public float getVelocitaVento() {
		return velocitaVento;
	}

	public void setVelocitaVento(float velocitaVento) {
		this.velocitaVento = velocitaVento;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getPressione() {
		return pressione;
	}

	public void setPressione(float pressione) {
		this.pressione = pressione;
	}
	
}
