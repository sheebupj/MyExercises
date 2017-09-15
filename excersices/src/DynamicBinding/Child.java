package DynamicBinding;

public class Child extends Parent {
	void disp(){
		System.out.println("from child");
	}
	void disp2(){
		System.out.println("from parent");
	}
	public static void main(String[] args) {
		Parent p= new Child();
		p.disp();
	}
}
