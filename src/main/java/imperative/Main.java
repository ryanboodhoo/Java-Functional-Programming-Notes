package imperative;

import java.util.List;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.MALE)
        );

        //print women

        //Imperative approach
        List<Person> females = new ArrayList<>();
        for ( Person p : people ) {
            if ( Gender.FEMALE.equals(p.gender) ) {
                females.add(p);
            }
        }

        for( Person female: females ){
            System.out.println(female);
        }

        System.out.println("Declarative");

        //Declarative approach

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}
