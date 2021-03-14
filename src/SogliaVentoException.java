// Questa è una eccezione di tipo Checked (controllata) quindi è obbligatorio gestirla mediante try-catch o throws
public class SogliaVentoException extends RuntimeException {

	private final String msg = "Attenzione la velocità del vento ha superato il valore della soglia di allerta: ";
	private float velocitaVento;
	private float sogliaVento;
	
	public SogliaVentoException(float velocitaVento, float sogliaVento) {
		this.velocitaVento = velocitaVento;
		this.sogliaVento = sogliaVento;
	}
	
	public String getMessaggio() {
		return msg + this.velocitaVento + " > " + this.sogliaVento;
	}
}

	