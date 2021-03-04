package FTPkg;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isNumberValid("9812345675"));
        System.out.println(predicate.test("9776543212"));

    }

    static boolean isNumberValid(String phoneNumber){
        return (phoneNumber.startsWith("98") && phoneNumber.length()==10);
    }

    static Predicate<String> predicate = phoneNumber->phoneNumber.startsWith("98") && phoneNumber.length()==10;
}
