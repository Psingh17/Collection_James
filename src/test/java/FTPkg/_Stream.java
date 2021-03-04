package FTPkg;

import java.util.List;

import static FTPkg.GenderValue.*;


public class _Stream {

    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("Asmika", FEMALE),
                new Person("Kinni", FEMALE),
                new Person("Pranav", MALE),
                new Person("Sudha", FEMALE),
                new Person("Tushar", MALE)
        );


        people.stream().forEach(System.out::println);

        System.out.println(people.stream()
                .allMatch(person->MALE.equals(person.gender)));

    }


    static class Person {

        private String name;
        private GenderValue gender;


        public Person(String name, GenderValue gender) {
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
}

enum GenderValue{
    MALE, FEMALE;
}



