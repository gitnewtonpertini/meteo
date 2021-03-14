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
}
