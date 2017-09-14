package excersices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingWordsFromFile {
	BufferedReader bufferedReader;
	String grossWords;

	void readFiles(File file) throws IOException {
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String word;
			StringBuilder sb = new StringBuilder();
			while ((word = bufferedReader.readLine()) != null) {
				sb.append(word);
			}
			grossWords = sb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	List<String> splitWordsToList() {
		String[] wordArray = grossWords.split("\\s");
		return Arrays.asList(wordArray);
	}

	Map<String, Integer> countWords(List<String> words) {
		Map<String, Integer> countedWords = new HashMap<>();
		for (String word : words) {
			if (countedWords.containsKey(word)) {
				int count = countedWords.get(word);
				countedWords.put(word, count + 1);
			} else {
				countedWords.put(word, 1);
			}
		}
		return countedWords;
	}
	
	
	
	List<KeyValue> buildList(Map<String,Integer> countedMap,List<String> words){
		List<KeyValue> objectList = new ArrayList<>();
		for(String word:words){
			String key=word;
			Integer value = countedMap.get(key);
			objectList.add(new KeyValue(key, value));
		}
		return objectList;
	}
	

	public static void main(String[] args) {
		SortingWordsFromFile mapsorting = new SortingWordsFromFile();
		try {
			mapsorting.readFiles(new File("input40.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> words=mapsorting.splitWordsToList();
		Map<String,Integer> countedMap = mapsorting.countWords(words);
		
		List<KeyValue> listForSorting =mapsorting.buildList(countedMap, words);
		
		Collections.sort(listForSorting,Collections.reverseOrder(new SortKeyValueComparator()));
		for(KeyValue kv:listForSorting){
			System.out.println(kv);
		}
	}

}
class KeyValue{
	String key;
	Integer value;
	public String getKey() {
		return key;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public KeyValue(String key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}
	


	@Override
	public String toString(){
		return this.getKey() + ":" + this.getValue();
	}
	
}
class SortKeyValueComparator implements Comparator<KeyValue> {

	@Override
	public int compare(KeyValue o1, KeyValue o2) {
		// TODO Auto-generated method stub
		return o1.getValue().compareTo(o2.getValue());
	}
	
}
