package com.mkyong;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
	 public static void main(String[] args) {

	        Stream<String> language1 = Stream.of("java", "python", "node", null, "ruby", null, "php");
	        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

	        List<String> result1 = language1.collect(Collectors.toList());

	        List<String> result = language.filter(x -> x!=null).collect(Collectors.toList());

	        
	        result1.forEach(System.out::println);
	        
	        
	        result.forEach(System.out::println);


	    }
}
