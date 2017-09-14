package composition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Box {
	List<Box> composedlist = new ArrayList<Box>();
	Set<Box> grossBoxSet= new HashSet<>();

	int getCount() {
		int count = 0;
		for (Box b : composedlist) {
			count += b.getCount();
		}
		return count + 1;
	}
	
/* don't count duplicates*/
	Set<Box> getGrossBoxSet() {

		for (Box b : composedlist) {
			grossBoxSet.addAll(b.getGrossBoxSet());
		}
		
		grossBoxSet.add(this);
		return grossBoxSet;

	}
	int getGrossBoxSetCount() {
		return getGrossBoxSet().size();
	}	
	

/* avoid duplicates without 'dead store for local variable' */
	Set<Box> getGrossBoxSetWithoutUnnecessaryObjectCreation (Set<Box> set){
		for (Box b : composedlist) {
			set.addAll(b.getGrossBoxSetWithoutUnnecessaryObjectCreation(set));
		}
		
		set.add(this);
		return set;
	}
	
	int getGrossBoxSetCountVersion2(Set<Box> set) {
		return getGrossBoxSetWithoutUnnecessaryObjectCreation(set).size();
	}
	
	void addBox(Box b) {
		this.composedlist.add(b);

	}

	public static void main(String[] args) {
		Box b1 = new Box();
		Box b2 = new Box();
		Box b3 = new Box();
		Box b4 = new Box();
		Box b5 = new Box();
		Box b6 = new Box();
		Box b7 = new Box();
		Box b8 = new Box();
		Box b9 = new Box();
		Box b10 = new Box();
		Box b11 = new Box();
		Box b12 = new Box();

		b4.addBox(b8);

		b6.addBox(b9);
		b6.addBox(b10);
		b6.addBox(b12);
		b6.addBox(b11);

		b1.addBox(b2);
		b1.addBox(b3);
		b1.addBox(b4);
		b1.addBox(b5);

		b2.addBox(b6);
		b2.addBox(b5);

		b3.addBox(b7);
		b3.addBox(b5);

		System.out.println(b1.getCount() + " : " + b1.getGrossBoxSetCount());
		int count= b1.getGrossBoxSetCountVersion2(new HashSet<Box>());
		System.out.println(count);
		Set abc = new HashSet<>();
		abc.add("xyz");
		abc.add("abc");
		abc.add("123");
		abc.add("abc");
		System.out.println(abc);
	}

}
