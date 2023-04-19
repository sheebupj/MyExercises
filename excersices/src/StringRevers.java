import java.util.Arrays;

public class StringRevers {
	public static void main(String[] args) {
		String txt= "My name is Sheebu";
		int len= txt.length();
		String reversed="";
		for(int i=len-1;i>=0;i--) {
			reversed=reversed+txt.charAt(i);
		}
		System.out.println(reversed);
		//word wise reverse
		String[] txtAr= txt.split(" ");
		 reversed="";
		for(int i=txtAr.length-1;i>=0;i--) {
			reversed= reversed+ txtAr[i]+" ";
		}
		System.out.println(reversed);
		
	}

}
