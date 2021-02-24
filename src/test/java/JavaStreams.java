import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) throws IOException {

        //1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::println);

        System.out.println("***************************************************");

        //2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println("***************************************************");

        //3. Integer stream with sum
        System.out.println(IntStream
                .range(1, 10)
                .sum());

        System.out.println("***************************************************");

        //4 stream of string ..sorted
        List<String> names = Arrays.asList("Pranav", "Asmika", "Gunnu", "Mayank", "Pratap");

        names.stream().sorted().findFirst().ifPresent(System.out::println);

        System.out.println(Stream.of("Vegeta", "Ava", "Zorro", "Bulma", "Goku", "Yamcha")
                .sorted()
                .findFirst().get());

        System.out.println("***************************************************");

        //5. Stream from array (string), sorted on the basis of first char
        String[] nameArray = {"Ava", "Adam", "Asmika", "Zorro", "Yamcha", "Goku", "Azahar", "Aakash"};
        Arrays.stream(nameArray)
                .filter(i -> i.startsWith("A"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("***************************************************");

        /*int[] numArray= new int []{90,80,56,87,12,74};*/
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(20, 5, 3, 6, 9, 12));
        al2.stream()
                .sorted((i1, i2) -> -i1.compareTo(i2))
                .forEach(System.out::println);

        System.out.println("***************************************************");

        //6. Array stream find average of squares

        Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .map(i -> i * i)
                .average()
                .ifPresent(System.out::println);

        System.out.println("***************************************************");

        //7. List of string in lower case with char preference

        List<String> nameList = Arrays.asList("Pranav", "Asmika", "Gunnu", "Mayank", "Pratap");
        nameList.stream()
                .filter(i -> i.startsWith("P"))
                .map(String::toLowerCase)
                .forEach(System.out::println);

        System.out.println("***************************************************");


        //8. Stream rows from text file, sort , filter and print
        Stream<String> bands = Files.lines(Paths.get("src/test/bands.txt"));
        bands
                .sorted()
                .filter(i -> i.length() > 13)
                .forEach(System.out::println);
        bands.close();

        System.out.println("***************************************************");


        //9. Stream rows from text file and checking specific value
        Files.lines(Paths.get("src/test/bands.txt"))
                .filter(x -> x.contains("jit"))
                .forEach(System.out::println);

        System.out.println("***************************************************");

        //10. Stream rows from csv to check bad row(no column data
        Stream<String> data = Files.lines(Paths.get("src/test/data.txt"));
        int rowCount = (int) data
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        data.close();

        System.out.println(rowCount);

        System.out.println("***************************************************");

        //11. Stream rows from csv file, parse data from rows
        Stream<String> data2 = Files.lines(Paths.get("src/test/data.txt"));

        data2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        data2.close();

        System.out.println("***************************************************");

        //12. Stream rows from csv file, store fields in hashmap

        Stream<String> data3 = Files.lines(Paths.get("src/test/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = data3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        data3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "   " + map.get(key));
        }

        System.out.println("***************************************************");

        //13. reduce method for sum

        System.out.println("Sum of given double numbers-> "+Stream.of(2.5, 3.5, 4.5)
                .reduce(0.0, (Double a, Double b) -> (a + b)));

        System.out.println("Sum of given int-->"+Stream.of(1,2,3,4,5)
                .reduce(0,(Integer a, Integer b)->a+b));

        System.out.println("***************************************************");

        //14. IntsummaryStatistics

        IntSummaryStatistics summary = IntStream.of(10,45,32,14,65,78,23)
                .summaryStatistics();
        System.out.println(summary);

        System.out.println("***************************************************");

        ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(20, 5, 3, 6, 9, 12));

        IntSummaryStatistics intSummaryStatistics= new IntSummaryStatistics();

        Iterator<Integer> itr = al3.iterator();

        while (itr.hasNext()){
            intSummaryStatistics.accept(itr.next());
        }

        System.out.println(intSummaryStatistics.toString());


    }
}
