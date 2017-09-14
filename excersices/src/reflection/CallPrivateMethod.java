package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallPrivateMethod {
	String name;
	
	
	public CallPrivateMethod(String name) {
		super();
		this.name = name;
	}
	private void disp(CallPrivateMethod a,char d){
		System.out.println("private method called" + a.name);
	}
	public static void main(String[] args) {
		Caller1 caller1 = new Caller1();
		CallPrivateMethod callPrivateMethod= new CallPrivateMethod("sheebu");
		caller1.call(callPrivateMethod, "disp", callPrivateMethod,"c");
		
	
	}

}
