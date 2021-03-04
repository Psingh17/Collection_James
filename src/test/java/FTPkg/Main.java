package FTPkg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static FTPkg.Gender.FEMALE;
import static FTPkg.Gender.MALE;




public class Main {

    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("Asmika", FEMALE),
                new Person("Kinni", FEMALE),
                new Person("Pranav", MALE),
                new Person("Sudha", FEMALE),
                new Person("Tushar", MALE)
                );


        List<Person> females = new ArrayList<>();

        for(Person person:people){
            if (FEMALE.equals(person.gender)){
                females.add(person);
            }
        }


        for(Person female:females){
            System.out.println(female);
        }

        System.out.println("****************************************************");

        Predicate<Person> predicate = i->FEMALE.equals(i.gender);
        people.stream()
                .filter(predicate)
                .forEach(System.out::println);

    }

    static class Person {

        private String name;
        private Gender gender;


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
}
enum Gender{
    MALE, FEMALE;
}

