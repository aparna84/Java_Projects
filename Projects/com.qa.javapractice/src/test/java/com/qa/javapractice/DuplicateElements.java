package com.qa.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {

		String namesArr[]= {"Java", "Ruby", "Python", "selenium", "Java", "selenium"};
		
		//Approach 1
		
		for(int i=0;i<namesArr.length;i++)
		{
			for(int j=i+1;j<namesArr.length;j++)
			{
				if(namesArr[i].equals(namesArr[j]))
				{
					System.out.println("Dupilicate element is"+namesArr[i]);
				}
			}
		}
		
		//Aproach 2 using hashset
		
		Set <String> hs= new HashSet<String>();
		for(String namesList: namesArr)
		{
			if(hs.add(namesList)==false)
			{
				System.out.println("Duplicate elements are"+namesList);
			}
		}
		
		//Approach 3 using hashmap
		
		Map<String,Integer> maplist= new HashMap<String,Integer>();
		for(String mapNames: namesArr)
		{
			Integer count=maplist.get(mapNames);
			if(count==null)
			{
				maplist.put(mapNames, 1);
				
			}
			else
				maplist.put(mapNames, ++count);
			
			}
		
			Set<Entry<String, Integer>> entrylist= maplist.entrySet();
			for(Entry<String, Integer> entryloop: entrylist)
			{
				if(entryloop.getValue()>1)
				{
					System.out.println("Duplicate values in map are" +entryloop);
					
				}
				
			}
		
	}

}
