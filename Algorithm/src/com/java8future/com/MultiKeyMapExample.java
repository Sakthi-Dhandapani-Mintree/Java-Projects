package com.java8future.com;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

public class MultiKeyMapExample {

	public static void main(String[] args) {
		MultiKeyMap multiKeyMap = new MultiKeyMap<>();
		
		multiKeyMap.put("Sakthi", "999_438", "Chennai");
		multiKeyMap.put("Sakthi", "999_1335", "Alapakkam");
		multiKeyMap.put("Sakthi", "999_335", "Tirupattur");
		
		multiKeyMap.put("Sumathy", "9789_8627_30", "Chennai");
		multiKeyMap.put("Sumathy", "9789_86_27_30", "Alapakkam");
		multiKeyMap.put("Sumathy", "9789_87_30", "Tirupattur");
		
		System.out.println("Name Sakthi "+multiKeyMap.get("Sakthi", "999_1335"));
		
		//Iteration:
		multiKeyMap.forEach((key1,key2) ->System.out.println("key Set is :"+key1 +":value "+key2));
 
	}

}
