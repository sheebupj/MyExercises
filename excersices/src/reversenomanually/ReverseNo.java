package reversenomanually;

public class ReverseNo {
	long no;
	public ReverseNo(long n) {
		// TODO Auto-generated constructor stub
		no=n;
	}
	long reverse(){
		StringBuilder n=new StringBuilder(Long.toString(no)) ;
		n= n.reverse();
		System.out.println(n);
		return Long.parseLong(n.toString());
		
	}
	public static void main(String[] args) {
		double d=100000000000.0;
		int l=(int)d;
		ReverseNo reberseNo= new ReverseNo(1234567890);
		System.out.println(reberseNo.reverse());
	}
	

}
