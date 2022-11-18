
public interface Iexample {

	int val = 300;
	
	default void printDefault() {
		System.out.println("inside default method");
		
	}
	
	static void printStatic() {
		System.out.println("inside static method");
		
	}
	
	 void printAbstract();
}
