package com.mkyong;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerTest{
	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
		System.out.println(result);
		
		
		StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result1 = sj1.toString(); //prefix-2016/02/26-suffix
        System.out.println(result1);
        
//        
//        
//      //2015-10-31
//        String result = String.join("-", "2015", "10", "31" );	 	
//        
//        
//        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
//     	//java, python, nodejs, ruby
//    String result = String.join(", ", list);
//        
//    
//    
//    
//    List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
//  //java | python | nodejs | ruby
//  String result = list.stream().map(x -> x).collect(Collectors.joining(" | "));
//        
//    
//  
        
		
	}
	
	void test(){

	    List<Game> list = Arrays.asList(
	            new Game("Dragon Blaze", 5),
	            new Game("Angry Bird", 5),
	            new Game("Candy Crush", 5)
	    );

	    //{Dragon Blaze, Angry Bird, Candy Crush}
	    String result = list.stream().map(x -> x.getName())
		.collect(Collectors.joining(", ", "{", "}"));

	}
	
}



class Game{
    String name;
    int ranking;

    public Game(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
