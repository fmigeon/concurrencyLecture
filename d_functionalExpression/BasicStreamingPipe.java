// credits : https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
// author : Fred Migeon - IRIT - Université Toulouse 3

package d_functionalExpression;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasicStreamingPipe {
	private enum Sex {
		MALE, FEMALE
	}

	static class Person {

		String name;
		LocalDate birthday;
		Sex gender;
		String emailAddress;

		public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
			super();
			this.name = name;
			this.birthday = birthday;
			this.gender = gender;
			this.emailAddress = emailAddress;
		}

		public int getAge() {
			return Period.between(birthday, LocalDate.now()).getYears();
		}

		public Sex getGender() {
			return Sex.MALE;
		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) {
		Person[] roster = { new Person("Paul", LocalDate.of(1998, 6, 23), Sex.MALE, "paul.luap@me.com"),
				new Person("Marie", LocalDate.of(2005, 3, 12), Sex.FEMALE, "marie.eiram@me.com"),
				new Person("Pierre", LocalDate.of(2010, 8, 15), Sex.MALE, "pierre.erreip@me.com") };

		double startTime = System.nanoTime();
		
		double average = Arrays.stream(roster)
				.filter(p -> p.getGender() == Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();
		System.out.println("moyenne par stream / pipeline : " + average);
		
		double endTime = System.nanoTime();
		double elapsedTime = (endTime - startTime);
		System.out.println("Execution time for sequential streaming average : " + elapsedTime/1000000 + " ms.");

		startTime = System.nanoTime();
		
		average = Arrays.stream(roster).parallel()
				.filter(p -> p.getGender() == Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();
		System.out.println("moyenne par stream / pipeline : " + average);
		
		endTime = System.nanoTime();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for parallel streaming average : " + elapsedTime/1000000 + " ms.");

		startTime = System.nanoTime();
		
		Person[] filtered = handmadeFilter(roster, p -> p.getGender() == Sex.MALE);
		Integer[] mapped = handmadeMapToInt(filtered, Person::getAge);
		average = handmadeAverage(mapped);
		System.out.println("moyenne par séquence de méthodes: " + average);
		
		endTime = System.nanoTime();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for classic average : " + elapsedTime/1000000 + " ms.");

	}
	
	static private Person[] handmadeFilter(Person[] toFilter, Predicate<Person> predicate) {
		Person [] res = new Person[toFilter.length];
		for(int count=0,index=0; count<toFilter.length; count++ ) {
			if (predicate.test(toFilter[count])) {
				res[index] = toFilter[count];
				index++;
			}
		}
		return res;
	}
	
	static  private Integer[] handmadeMapToInt(Person[] toMap, Function<Person, Integer> function) {
		Integer [] res = new Integer[toMap.length];
		for(int count=0; count<toMap.length; count++) {
			res[count]=function.apply(toMap[count]);
		}
		return res;
	}
	
	static  private double handmadeAverage(Integer[] toAverage) {
		double res=0;
		double sum = 0;
		for(int value : toAverage) {
			sum += value;
		}
		res = sum/toAverage.length;
		return res;
	}

}
