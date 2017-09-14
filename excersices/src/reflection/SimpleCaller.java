package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleCaller {
	public Object call(Object object, String methodName, Object obj1) {
		Object[] classobjects= getParameterArray(obj1);
		
		return createAndCallMethod(object, classobjects, methodName);
		
	}
private Object[] getParameterArray(Object ob1){
		
		Object[] objects = new Object[1];
		objects[0]=ob1;
		
		
		return objects;
	}


private Object createAndCallMethod(Object object ,Object[] objects, String methodName){
	Method method=null;
	try {
		method = getMethod(object, methodName);
		replaceStringWithPrimitiveType(method, objects);
	} catch (NoSuchMethodException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Object obj =null;

	method.setAccessible(true);

	
		try {
			obj = method.invoke(object, objects);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return obj;
}
private Method getMethod(Object obj, String methodName) throws NoSuchMethodException{
	for(Method method:obj.getClass().getDeclaredMethods()){
		if(method.getName().equals(methodName)){
			return method;
		}
	}
	throw new NoSuchMethodException();
}
private void replaceStringWithPrimitiveType(Method method,Object[] object){
	Class<?>[] classes = method.getParameterTypes();
	for(int i=0;i<classes.length;i++){
		if(!object[i].getClass().getName().equals(classes[i].getName())){
			object[i]=replaceStringWithPrimitiveType(classes[i].getName(),object[i]);
		}
	}
	
	
	//return object;
	
}
private Object replaceStringWithPrimitiveType(String className, Object obj){
	String objString = (String) obj;
		return (int)Integer.parseInt(objString.trim());
	
	}

}
