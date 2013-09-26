package creators;

public class ProceduralGen {

	public static int a = 25136;// Valor seed a
	public static int b = 25256;// Valor seed b
	public double occurrenceChecktemp = 0;// Checker!

	/**
	 * Gera as coordenadas para os Systemas nos quadrantes
	 * 
	 * @param Xi
	 *            (seed inicial)
	 * @return double entre 0 e 100
	 */
	public static double getCoord(double Xi) {
		int m = 100000;
		return (((a * Xi + b) % m) / 1000);
	}// getCoord

	/**
	 * Gera uma seed limpa.
	 * 
	 * @param Xi
	 * @return double
	 */
	public static double getSeed(double Xi) {
		int m = 1000000000;
		return (((a * Xi + b) % m) / 1000);
	}// getSeed

	/**
	 * Gera um decimal entre 0 e 1.
	 * 
	 * @param seed
	 * @return
	 */
	public static double getCent(double seed) {
		int m = 100000;
		return (((a * seed + b) % m) / 1000);
	}// getDecimalNum
	
}
