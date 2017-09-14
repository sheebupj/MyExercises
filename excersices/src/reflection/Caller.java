package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Caller {
	public Object call(Object object, String string, Object obj1, Object obj2, Object obj3,Object obj4,Object obj5) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3,obj4,obj5,new Object[4]);
		return createAndCallMethod(object, classobjects, string);
	}
	
	public Object call(Object object, String string, Object obj1, Object obj2, Object obj3,Object obj4) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3,obj4,new Object[4]);
		return createAndCallMethod(object, classobjects, string);
	}
	
	public Object call(Object object, String string, Object obj1, Object obj2, Object obj3) {
		Object[] classobjects= getParameterArray(obj1, obj2,obj3,new Object[3]);
		return createAndCallMethod(object, classobjects, string);
	}
	
	public Object call(Object object, String string, Object obj1, Object obj2) {
		Object[] classobjects= getParameterArray(obj1, obj2, new Object[2]);
		return createAndCallMethod(object, classobjects, string);
	}
	
	public Object call(Object object, String string, Object obj1) {
		Object[] classobjects= getParameterArray(obj1, new Object[1]);
		return createAndCallMethod(object, classobjects, string);
	}
	
	public Object call(Object object, String string)  {
			return createAndCallMethod(object, null, string);
		
	}
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3,Object ob4,Object ob5,Object[] objects){
		
		getParameterArray(ob1, ob2, ob3, ob4, ob5, objects);
		objects[4]=ob5;
		
		return objects;
	}
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3,Object ob4,Object[] objects){
		
		getParameterArray(ob1, ob2, ob3, objects);
		objects[3]=ob4;
	
		return objects;
	}
	
	
	private Object[] getParameterArray(Object ob1, Object ob2, Object ob3,Object[] objects){
		
		getParameterArray(ob1, ob2, objects);
		objects[2]=ob3;
		
		return objects;
	}
	
	private Object[] getParameterArray(Object ob1, Object ob2, Object[] objects){
		
		getParameterArray(ob1, objects);
		objects[1]=ob2;
		
		return objects;
	}
	private Object[] getParameterArray(Object ob1,Object[] objects){
		objects[0]=ob1;
		return objects;
	}
	
	
	private Object createAndCallMethod(Object object ,Object[] objects, String string){
		Method method=null;
		try {
			method = getMethod(object, string);
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
		return (int)Integer.parseInt(objString);
	
	}
	
}

