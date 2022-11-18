

public class InterfacePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		ExOne iOne = new ExOne();
		ExTwo iTwo = new ExTwo();
		*/
		
		
		Iexample iOne = new ExOne();
		Iexample iTwo = new ExTwo();
		
		
		System.out.println(iOne.getClass());
		System.out.println(iTwo.getClass());
		
		
		iOne.printAbstract();
		iOne.printDefault();
		
		iTwo.printAbstract();
		iTwo.printDefault();
		
	//	iTwo.getVal();
		((ExTwo)iTwo).getVal();
		
	//	iOne = iTwo;
		
	//	iOne.printAbstract();
		
		
	}

}

class ExOne implements Iexample{

	@Override
	public void printAbstract() {
		// TODO Auto-generated method stub
		System.out.println("ExOne abstract method");
		
	}
	
}



class ExTwo implements Iexample{

	@Override
	public void printAbstract() {
		// TODO Auto-generated method stub
		System.out.println("ExTwo abstract method");
	}
	
	public void getVal() {
		System.out.println(val);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}