package excersices;

public class StringOutOfMemmory {
	public static void main(String[] args) {
		String s="0";
		StringBuilder s1=new StringBuilder();
		for(int i=1;i<25000000;i++){
			s1.append(i);
			}
		s=s1.toString();
			
		
		
		System.out.println("1");
		

	}

}
