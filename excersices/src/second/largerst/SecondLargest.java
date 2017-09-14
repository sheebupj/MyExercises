package second.largerst;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SecondLargest {
	public static void main(String[] args) {
		List<Integer> ar = new ArrayList<>();
		ar.add(45);
		ar.add(145);
		ar.add(451);
		ar.add(45);
		ar.add(245);
		ar.add(445);
		ar.add(458);
		NavigableSet<Integer> navigableSet= new TreeSet<>(ar);
		SortedSet<Integer>sortedSet= new TreeSet<>(ar);
		
		System.out.println(navigableSet);
		
		Integer largest = navigableSet.last();
		System.out.println(":"+navigableSet.lower(largest));
		
		navigableSet.pollLast();
		Integer secondLargest=navigableSet.pollLast();
		
		System.out.println(secondLargest);
		
		sortedSet.remove(sortedSet.last());
		System.out.println(sortedSet.last());
		
		
		
	}

}
