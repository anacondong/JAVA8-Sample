package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;;
public class T1_Stream {

	public static void main(String[] args) {
	
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
			
			
			
			Arrays.asList("a1", "a2", "a3")
		    .stream()
		    .findFirst()
		    .ifPresent(System.out::println);  // a1
			
			Stream.of("a1", "a2", "a3")
		    .findFirst()
		    .ifPresent(System.out::println);  // a1
			
			
			IntStream.range(1, 4)
		    .forEach(System.out::println);
			
			
			Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1)
		    .average()
		    .ifPresent(System.out::println);  // 5.0
			
			Stream.of("a1", "a2", "a3")
		    .map(s -> s.substring(1))
		    .mapToInt(Integer::parseInt)
		    .max()
		    .ifPresent(System.out::println);  // 3
			
			IntStream.range(1, 4)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);
				// a1
				// a2
				// a3
			
			Stream.of(1.0, 2.0, 3.0)
		    .mapToInt(Double::intValue)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);
			
			
			// Processing Order
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    });
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .anyMatch(s -> {
		        System.out.println("anyMatch: " + s);
		        return s.startsWith("A");
		    });
			
			
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("A");
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			
			
			
//			//Reusing Streams
//			Stream<String> stream =
//				    Stream.of("d2", "a2", "b1", "b3", "c")
//				        .filter(s -> s.startsWith("a"));
//
//				stream.anyMatch(s -> true);    // ok
//				stream.noneMatch(s -> true);   // exception
			
			
			
				Stream<String> streamd =
					    Stream.of("d2", "a2", "b1", "b3", "c")
					        .filter(s -> s.startsWith("a"));

					streamd.anyMatch(s -> true);    // ok
					//streamd.noneMatch(s -> true);   // exception
			
			
				Supplier<Stream<String>> streamSupplier =
					    () -> Stream.of("d2", "a2", "b1", "b3", "c")
					            .filter(s -> s.startsWith("a"));

					streamSupplier.get().anyMatch(s -> true);   // ok
					streamSupplier.get().noneMatch(s -> true);  // ok
			
			
					//Advanced Operations 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}

}