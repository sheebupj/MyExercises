package uninitstaticint;

public class UninitstaticintClass {
	public static void main(String[] args) {
		abc a = new abc();
		a.a++;
		System.out.println(a.a);
	}
	
	

}
class abc{
	static int a;
}
