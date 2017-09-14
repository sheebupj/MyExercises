package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Caller1 {
	public Object call(Object object, String methodName, Object obj1, Object obj2, Object obj3,Object obj4,Object obj5) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3,obj4,obj5);
		return createAndCallMethod(object, classobjects, methodName);

		
	}
	public Object call(Object object, String methodName, Object obj1, Object obj2, Object obj3,Object obj4) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3,obj4);
		return createAndCallMethod(object, classobjects, methodName);

		
	}
	
	public Object call(Object object, String methodName, Object obj1, Object obj2, Object obj3) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3);
		return createAndCallMethod(object, classobjects, methodName);

		
	}
	
	public Object call(Object object, String methodName, Object obj1, Object obj2) {
		Object[] classobjects= getParameterArray(obj1, obj2);
		return createAndCallMethod(object, classobjects, methodName);

		
	}
	
	public Object call(Object object, String methodName, Object obj1) {
		Object[] classobjects= getParameterArray(obj1);
		
		return createAndCallMethod(object, classobjects, methodName);
		
	}
	public Object call(Object object, String methodName)  {
		
		return createAndCallMethod(object, null, methodName);
		
	}
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3,Object ob4,Object ob5){
		
		Object[] objects = new Object[5];
		objects[0]=ob1;
		objects[1]=ob2;
		objects[2]=ob3;
		objects[3]=ob4;
		objects[4]=ob5;
		
		return objects;
	}
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3,Object ob4){
		
		Object[] objects = new Object[4];
		objects[0]=ob1;
		objects[1]=ob2;
		objects[2]=ob3;
		objects[3]=ob4;
	
		return objects;
	}
	
	
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3){
		
		Object[] objects = new Object[3];
		objects[0]=ob1;
		objects[1]=ob2;
		objects[2]=ob3;
		
		return objects;
	}
	
	private Object[] getParameterArray(Object ob1, Object ob2){
		
		Object[] objects = new Object[2];
		objects[0]=ob1;
		objects[1]=ob2;
		
		return objects;
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
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
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
	switch (className) {
	case "int":
		obj=Integer.parseInt(objString.trim());
		break;
	case "double":
		obj=Double.parseDouble(objString.trim());
		break;
	case "float":
		obj=Float.parseFloat(objString.trim());
		break;
	case "long":
		obj=Long.parseLong(objString.trim());
		break;
	case "char":
		obj=objString.charAt(0);
		break;
	case "short":
		obj=Short.parseShort(objString.trim());
		break;
	case "byte":
		obj=Byte.parseByte(objString.trim());
		break;
	
	}
	return obj;	
	
	}
	
}
