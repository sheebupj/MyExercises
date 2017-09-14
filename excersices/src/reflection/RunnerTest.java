package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunnerTest {
	public static void main(String[] args) {
		Caller1 caller1 = new Caller1();
		CallPrivateMethod callPrivateMethod= new CallPrivateMethod("sheebu");
		caller1.call(callPrivateMethod, "disp", callPrivateMethod);
		
	}
	
}
