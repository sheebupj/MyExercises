package excersices;

public class ClassWithoutStaticMain {
	
	
	void disp(){
		System.out.println("wow! !");
	}
	static {
		ClassWithoutStaticMain cwm= new ClassWithoutStaticMain();
		cwm.disp();
	}
	
}
