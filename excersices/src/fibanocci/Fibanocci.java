package fibanocci;

public class Fibanocci {
	int prev1=0;
	int prev2=1;
	int lim;
	public Fibanocci(int limitt) {
		// TODO Auto-generated constructor stub
		lim=limitt;
	}
	void printSeries(){
		System.out.print(prev1+".."+prev2);
		int count=2;
		while(count<lim){
			int tmp=prev1;
			prev1=prev2;
			prev2=tmp+prev2;
			System.out.print(".."+prev2);
			count++;
		}
		
	}
	public static void main(String[] args) {
		Fibanocci fibanocci= new Fibanocci(6);
		fibanocci.printSeries();
	}
	

}
