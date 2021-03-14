
public class PalloneSonda implements IStrumentoMeteo {
	private String id;
	private long volume;
	private int peso;
	
	public PalloneSonda(String id, long volume, int peso) {
		this.id = id;
		this.volume = volume;
		this.peso = peso;
	}

	public PalloneSonda(PalloneSonda pallone) {
		super();
		this.id = pallone.id;
		this.volume = pallone.volume;
		this.peso = pallone.peso;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public long getVolume() {
		return volume;
	}


	public void setVolume(long volume) {
		this.volume = volume;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	/**
	* Estrae il codice zona dall'id 
	* di un altra centralina
	* @param id id centralina da cui estrarre il codice zona
	* @return String Codice della zona
	*/
	public String codiceZona(String id) {
	    return id.substring(id.indexOf('_') + 1, id.lastIndexOf('_') + 1);
	}
	
}

