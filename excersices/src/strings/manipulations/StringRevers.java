package strings.manipulations;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringRevers {
	public static void main(String[] args) {
		
		/*
		 * sentence reversal letter wise
		 */
		String txt= "My name is Sheebu";
		int len= txt.length();
		String reversed="";
		for(int i=len-1;i>=0;i--) {
			reversed=reversed+txt.charAt(i);
		}
		System.out.println(reversed);
		/*
		 * sentence reversal word wise
		 */
		String[] txtAr= txt.split(" ");
		 reversed="";
		for(int i=txtAr.length-1;i>=0;i--) {
			reversed= reversed+ txtAr[i]+" ";
		}
		System.out.println(reversed);
		/*
		 * count special characters in a string
		 */
		String str="abcdy&jdkg%dfjd/sjjdfd*uenbgd@pyebdfd (";
		System.out.println(Arrays.stream(str.split("")).map(s->s.charAt(0)).filter(c-> !(Character.isAlphabetic(c)|| Character.isDigit(c))).count());
		
	}

}
