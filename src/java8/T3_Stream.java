package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class T3_Stream {
	

	public static void main(String[] args) {
	
			List<Foo> foos = new ArrayList<>();
			List<Person> persons =
				    Arrays.asList(
				        new Person("Max", 18),
				        new Person("Peter", 23),
				        new Person("Pamela", 23),
				        new Person("David", 12));
			
			
			// create foos
			IntStream
			    .range(1, 4)
			    .forEach(i -> foos.add(new Foo("Foo" + i)));
		
			// create bars
			foos.forEach(f ->
			    IntStream
			        .range(1, 4)
			        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
	
			
			foos.stream()
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));	
			
			

		//Reduce
			
			persons
		    .stream()
		    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
		    .ifPresent(System.out::println);    // Pamela
			
			
			
			Person result =
				    persons
				        .stream()
				        .reduce(new Person("", 0), (p1, p2) -> {
				            p1.age += p2.age;
				            p1.name += p2.name;
				            return p1;
				        });

				System.out.format("name=%s; age=%s", result.name, result.age);
				// name=MaxPeterPamelaDavid; age=76
			
				Integer ageSum = persons
					    .stream()
					    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

					System.out.println(ageSum);  // 76
					
					
					Integer ageSuma = persons
						    .stream()
						    .reduce(0,
						        (sum, p) -> {
						            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
						            return sum += p.age;
						        },
						        (sum1, sum2) -> {
						            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
						            return sum1 + sum2;
						        });

						// accumulator: sum=0; person=Max
						// accumulator: sum=18; person=Peter
						// accumulator: sum=41; person=Pamela
						// accumulator: sum=64; person=David	
					
					Integer ageSumb= persons
						    .parallelStream()
						    .reduce(0,
						        (sum, p) -> {
						            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
						            return sum += p.age;
						        },
						        (sum1, sum2) -> {
						            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
						            return sum1 + sum2;
						        });

						// accumulator: sum=0; person=Pamela
						// accumulator: sum=0; person=David
						// accumulator: sum=0; person=Max
						// accumulator: sum=0; person=Peter
						// combiner: sum1=18; sum2=23
						// combiner: sum1=23; sum2=12
						// combiner: sum1=41; sum2=35
					
					
					
					
					// Parallel Streams
					ForkJoinPool commonPool = ForkJoinPool.commonPool();
					System.out.println(commonPool.getParallelism());    // 3
					
					Arrays.asList("a1", "a2", "b1", "c2", "c1")
				    .parallelStream()
				    .filter(s -> {
				        System.out.format("filter: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return true;
				    })
				    .map(s -> {
				        System.out.format("map: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return s.toUpperCase();
				    })
				    .forEach(s -> System.out.format("forEach: %s [%s]\n",
				        s, Thread.currentThread().getName()));
					
					
					Arrays.asList("a1", "a2", "b1", "c2", "c1")
				    .parallelStream()
				    .filter(s -> {
				        System.out.format("filter: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return true;
				    })
				    .map(s -> {
				        System.out.format("map: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return s.toUpperCase();
				    })
				    .sorted((s1, s2) -> {
				        System.out.format("sort: %s <> %s [%s]\n",
				            s1, s2, Thread.currentThread().getName());
				        return s1.compareTo(s2);
				    })
				    .forEach(s -> System.out.format("forEach: %s [%s]\n",
				        s, Thread.currentThread().getName()));
					
					
					
			
					List<Person> persons2 = Arrays.asList(
						    new Person("Max", 18),
						    new Person("Peter", 23),
						    new Person("Pamela", 23),
						    new Person("David", 12));

						persons2
						    .parallelStream()
						    .reduce(0,
						        (sum, p) -> {
						            System.out.format("accumulator: sum=%s; person=%s [%s]\n",
						                sum, p, Thread.currentThread().getName());
						            return sum += p.age;
						        },
						        (sum1, sum2) -> {
						            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
						                sum1, sum2, Thread.currentThread().getName());
						            return sum1 + sum2;
						        });
			
	}
	

}
