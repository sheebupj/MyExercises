package excersices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class A
{
  // some code
}
public class B
{
    public static void main(String[] args)
    {
        A a = new A();
        String abc="010101";
        List clist=new ArrayList<>();
        for(int i=0;i<abc.length();i++){
        	clist.add(abc.charAt(i));
        	
        }
        Collections.sort(clist,Comparator.reverseOrder());
        System.out.println(clist);
        String s="";
        for(int i=0;i<clist.size();i++){
        	s=s+clist.get(i);
        	
        }
        System.out.println(s);
       
    }
}
