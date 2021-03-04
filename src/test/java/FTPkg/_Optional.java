package FTPkg;

import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {


        Optional.ofNullable(null).
                        ifPresentOrElse(
                                email-> System.out.println("Sending email to -> "+email),
                                ()-> System.out.println("Can't send the email"));


        Optional.ofNullable("Java").ifPresent(book-> System.out.println(book.toUpperCase()));
    }
}
