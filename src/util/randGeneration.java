package util;

import java.util.ArrayList;
import java.util.Random;

import bean.publication;

public class randGeneration {

	private search search;

	public randGeneration() {
		search = new search();
	}
	public ArrayList<publication> generateRandResult() {
		//ArrayList<publication> allData = search.getAllData();
		ArrayList<publication> ranPublGet = new ArrayList<publication>();
		
//		ArrayList<String> idList = new ArrayList<String>();
//		for (int i = 0; i < allData.size(); ++i) {
//			idList.add(allData.get(i).getItemId());
//		}
//		ArrayList<String> idListGet = new ArrayList<String>();
		ArrayList<publication> allData = search.getAllData();
		int size = allData.size();
		
		for (int i = 0; i < 10; ++i) {
			Random rand = new Random();
			int n = rand.nextInt(size); //need to deal with duplications

			ranPublGet.add(allData.get(n));
		}
		
	
		return ranPublGet;

	}

}
