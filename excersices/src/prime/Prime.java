package prime;

import java.io.IOException;

public class Prime {
	int pNumber;
	public Prime(int no) {
		this.pNumber=no;
	}
	public Prime() {
		// TODO Auto-generated constructor stub
	}
	void checkPrimeOrNot(){
		for(int i=2;i<=Math.sqrt((double)pNumber);i++){
			if(pNumber%i==0){
				System.out.println("number is not a prime");
				return;
			}
		}
		System.out.println("number is  a prime");
	}
	public static void main(String[] args) {
		Prime prime=new Prime();
		
		prime.pNumber=31;
		System.out.println("starting");
		
			prime.checkPrimeOrNot();
			
		}
	}


