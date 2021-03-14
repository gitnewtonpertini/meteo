	// Questa è una eccezione di tipo un-checked (non controllata) quindi non è obbligatorio gestirla mediante try-catch o throws
	public class SogliaPioggiaException extends RuntimeException {

		private final String msg = "Attenzione la quantità di pioggia ha superato il valore della soglia di allerta: ";
		private float quantitaPioggia;
		private float sogliaPioggia;
		
		public SogliaPioggiaException(int quantitaPioggia, int sogliaPioggia) {
			this.quantitaPioggia = quantitaPioggia;
			this.sogliaPioggia = sogliaPioggia;
		}
		
		public String getMessaggio() {
			return msg + this.quantitaPioggia + " > " + this.sogliaPioggia;
		}
	}

		
