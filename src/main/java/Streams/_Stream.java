package Streams;

import java.util.List;
import java.util.stream.Collectors;


import java.util.function.Consumer;
import java.util.function.Function;

import static Streams._Stream.Gender.FEMALE;
import static Streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ryan", MALE),
                new Person("Shawn", MALE),
                new Person("Mom", FEMALE),
                new Person("Auntie", FEMALE),
                new Person("Dan", MALE)
        );

        //print Set of genders
        people.stream().map(getGenders).collect(Collectors.toSet()).forEach(printPerson);

        //print length of person's names
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        //return boolean, if there is any person who's gender is FEMALE
        boolean isAnyFemale = people.stream().anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println("Is any female: " + isAnyFemale);

        //return boolean, if there are all women
        boolean isAllFemale = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        System.out.println("Are all female: " + isAllFemale);

        //return boolean, if there are note women
        boolean arentFemale = people.stream().noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println("Aren´t female: " + arentFemale);


        //Person person = people.stream().findFirst();

    }

    static Function<Person, Gender> getGenders = person -> person.gender;
    static Consumer<Gender> printPerson = gender -> System.out.println(gender);

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