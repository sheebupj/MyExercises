package prime;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
			
	/*
	 * find all primes less than or equal to 100 using java 8
	 */
			IntStream.rangeClosed(2,100).boxed().filter(n-> {
				for(int i=3;i*i<=n;i++) {
					if(n%i==0) return false;
				}
				return true;
			}).forEach(System.out::println);
			
		}
	}


