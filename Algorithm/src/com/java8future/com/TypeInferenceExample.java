package com.java8future.com;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface StringLength{
	String findLenght(List<String> name);
}
public class TypeInferenceExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("B");
		list.add("C");
		list.add("T");
		list.add("A");
		list.add("D");
		list.add("E");
		
		StringLength len = n -> {
			String string = "";
			for(int i=0;i<n.size();i++) {
				string +=n.get(i);
			}
			return string;
		};
		
		System.out.println(len.findLenght(list));
		
	}

}
