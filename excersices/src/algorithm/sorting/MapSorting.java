package algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapSorting {
	public static Map<String, String> sortMapNormal(Map<String, String> map) {
		return new TreeMap<String,String>(map);
	}
	public static Map<String,String> sortBasedValue(Map<String, String> map){
		
		Set<Entry<String, String>> emtrySet=map.entrySet();
		List<Entry<String,String>> list= new LinkedList<Entry<String,String>>(emtrySet);
		MyValueSelectionComparator comparator= new MyValueSelectionComparator();
		Map<String,String> valuBasedSortedMap = new LinkedHashMap<>();
		Collections.sort(list,comparator);
		
		for(Entry<String,String> en: list){
			valuBasedSortedMap.put(en.getKey(), en.getValue());
			//System.out.println(en.getKey() + " " + en.getValue());
		}
		
		 // valuBasedSortedMap.putAll(map);
		  return valuBasedSortedMap;
	}
	public static void printMap(Map<String,String> map){
		Set<Entry<String,String>> ens=map.entrySet();
		for(Entry<String,String> en:ens){
			System.out.println(en.getKey() + " " + en.getValue());
		}
	}
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("1824", "5");
		map.put("1821", "3");
		map.put("1829", "6");
		map.put("1822", "1");
		map.put("1828", "4");
		map.put("1826", "2");
		map.put("1823", "7");
		//System.out.println(sortMapNormal(map));
		System.out.println("--------------------");
		 Map<String,String> maps=sortBasedValue(map);
		printMap(maps);
				
	}}
	class MyValueSelectionComparator implements Comparator<Entry<String, String>>{

		@Override
		public int compare(Entry<String, String> o1, Entry<String, String> o2) {
			// TODO Auto-generated method stub
			 return o1.getValue().compareTo(o2.getValue());
		}
		
	}
	
	
	

