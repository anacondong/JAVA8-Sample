package com.mkyong;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams_Filter_Collection {

	
	 public static void main(String[] args) {

	        List<Person> persons = Arrays.asList(
	                new Person("mkyong", 30),
	                new Person("jack", 20),
	                new Person("lawrence", 40)
	        );

	        Person result1 = persons.stream()                        // Convert to steam
	                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
	                .findAny()                                      // If 'findAny' then return found
	                .orElse(null);                                  // If not found, return null

	        System.out.println(result1);

	        Person result2 = persons.stream()
	                .filter(x -> "ahmook".equals(x.getName()))
	                .findAny()
	                .orElse(null);

	        System.out.println(result2);
	        
	        ////////////////////////////////////////////
	        
	        Person result11 = persons.stream()
	                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
	                .findAny()
	                .orElse(null);

	        System.out.println("result 1 :" + result11);

	        //or like this
	        Person result22 = persons.stream()
	                .filter(p -> {
	                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
	                        return true;
	                    }
	                    return false;
	                }).findAny()
	                .orElse(null);

	        System.out.println("result 2 :" + result22);
	        
	        
	        /////////////////////////////////////////
	        String name = persons.stream()
	                .filter(x -> "jack".equals(x.getName()))
	                .map(Person::getName)                        //convert stream to String
	                .findAny()
	                .orElse("");

	        System.out.println("name : " + name);

	        List<String> collect = persons.stream()
	                .map(Person::getName)
	                .collect(Collectors.toList());

	        collect.forEach(System.out::println);
	        /////////////////////////////////////////
	        
	        
	        
	        
	        
	        
	        
	        

	        
	        
	        

	    }

	
	
}
