package com.mkyong;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_map {
	 public static void main(String[] args) {

	        List<String> alpha = Arrays.asList("a", "b", "c", "d");

	        //Before Java8
	        List<String> alphaUpper = new ArrayList<>();
	        for (String s : alpha) {
	            alphaUpper.add(s.toUpperCase());
	        }

	        System.out.println(alpha); //[a, b, c, d]
	        System.out.println(alphaUpper); //[A, B, C, D]

	        // Java 8
	        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
	        System.out.println(collect); //[A, B, C, D]

	        // Extra, streams apply to any data type.
	        List<Integer> num = Arrays.asList(1,2,3,4,5);
	        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
	        System.out.println(collect1); //[2, 4, 6, 8, 10]
	        
	        ////////////////////
	        
	        List<Staff> staff = Arrays.asList(
	                new Staff("mkyong", 30, new BigDecimal(10000)),
	                new Staff("jack", 27, new BigDecimal(20000)),
	                new Staff("lawrence", 33, new BigDecimal(30000))
	        );

	        //Before Java 8
	        List<String> result = new ArrayList<>();
	        for (Staff x : staff) {
	            result.add(x.getName());
	        }
	        System.out.println(result); //[mkyong, jack, lawrence]

	        //Java 8
	        List<String> collect11 = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
	        System.out.println(collect11); //[mkyong, jack, lawrence]
	        

	    }
}
