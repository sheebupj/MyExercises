package excersices;

import java.util.ArrayList;
import java.util.List;

public abstract class MyAbstractClassWithMain {
	public MyAbstractClassWithMain (){
		System.out.println(" kjkj");
	}
	static void  disp(){
		System.out.println("this is from main method of abstract class");
	}
	
	public static void main(String[] args) {
		MyAbstractClassWithMain.disp();
		abc a1= new abc();
		a1.show();
		ArrayList  arrayList =new ArrayList<>();
		arrayList.add("abc");
		List l= (List)arrayList;
		System.out.println(l.get(0));
	}

}
class abc extends MyAbstractClassWithMain{
	
	void show(){
		System.out.println("kkkk");
	}
}
