import java.util.Scanner;

public class SeriesSolution {

    static int counter = 0;

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);


        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();


            for (int j = 0; j < n; j++) {

                counter = counter + (int) (Math.pow(2, j) * b);

                int result = (a + counter);
                System.out.print(result + " ");
            }
            counter = 0;

            System.out.println();
        }



        in.close();
    }
}

