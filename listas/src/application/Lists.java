package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(3);
		list.add(5);
		list.add(67);
		list.add(33);
		list.add(91);
		list.add(26);
		
		System.out.println("Size: " + list.size());
		
		System.out.println("----------------------");
		System.out.println("Adding elements:");
		
		list.add(3, 40);
		
		for(Integer number: list) {
			System.out.println(number);
		}
		
		System.out.println("----------------------");
		System.out.println("Removing elements:");
		
		list.remove(4);
		list.removeIf(n -> n < 10);
		
		for(Integer number: list) {
			System.out.println(number);
		}
		
		System.out.println("----------------------");
		System.out.println("Looking for index of elements:");
		
		System.out.println("Index of 40: " + list.indexOf(40));
		System.out.println("Index of 666: " + list.indexOf(666));
		
		System.out.println("----------------------");
		System.out.println("Filtering the original list into a new list:");
		
		List<Integer> newList = list.stream().filter(n -> n > 20 && n < 50).collect(Collectors.toList());
		
		for(Integer number: newList) {
			System.out.println(number);
		}
		
		System.out.println("----------------------");
		System.out.println("Finding elements depending on condition:");
		
		List<Integer> totalNewList  = new ArrayList<>();
		
		totalNewList.add(35);
		totalNewList.add(45);
		totalNewList.add(28);
		totalNewList.add(93);
		totalNewList.add(60);
		totalNewList.add(80);
		totalNewList.add(2);
		
		Integer numberFirst = totalNewList.stream().filter(n -> n >= 40 && n <= 100 && n % 2 == 0).findAny().orElse(null);
		
		System.out.println(numberFirst);
	}

}
