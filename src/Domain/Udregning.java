package Domain;

/**
 * Klasse som bruges for udregninger af diverse saldoer.
 * @author PeterRaasthøj
 *
 */
public class Udregning {

	/**
	 * Bruges for at trække to input fra hinanden
	 * <p>Modtager <b>int</b>,<b>int</b> som parametre.</p>
	 * @param input1
	 * @param input2
	 * @return input1-input2
	 */
	public int substrakter(int input1, int input2){
		return input1-input2;
	}
	
	/**
	 * Bruges for at lægge to input til hinanden
	 * <p>Modtager <b>int</b>,<b>int</b> som parametre.</p>
	 * @param input1
	 * @param input2
	 * @return input1+input2
	 */
	public int adder(int input1, int input2){
		return input1+input2;
	}
	
	/**
	 * Bruges for at gange to input med hinanden
	 * <p>Modtager <b>int</b>,<b>int</b> som parametre.</p>
	 * @param input1
	 * @param input2
	 * @return input1*input2
	 */
	public int multiplicer(int input1, int input2){
		return input1*input2;
	}
	
	/**
	 * Bruges for at dividere to input med hinanden
	 * <p>Modtager <b>int</b>,<b>int</b> som parametre.</p>
	 * @param input1
	 * @param input2
	 * @return input1/input2
	 */
	public int divider(int input1, int input2){
		return input1/input2;
	}
}

