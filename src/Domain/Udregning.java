package Domain;

public class Udregning {

	public int substract(int input1, int input2){
		int first = input1;
		int second = input2;
		int total = first-second;
		return total;
	}
	
	public int adder(int input1, int input2){
		int first = input1;
		int second = input2;
		int total = first+second;
		return total;
	}
	
	public int multiplicer(int input1, int input2){
		int first = input1;
		int second = input2;
		int total = first*second;
		return total;
	}
	
	public int divider(int input1, int input2){
		int first = input1;
		int second = input2;
		int total = first/second;
		return total;
	}
}
