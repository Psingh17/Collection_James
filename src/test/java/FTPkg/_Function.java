package FTPkg;

        import java.util.function.BiFunction;
        import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        Function<Integer, Integer> incrementByOneFunction = number -> number+1;

        Function<Integer,Integer> multiplyBy10DFunction = number->number*10;

        int result_first =  incrementByOneFunction.apply(10);
        System.out.println(multiplyBy10DFunction.apply(result_first));


     Function<Integer,Integer> incByOneAndMultipliedBy10Function = incrementByOneFunction.andThen(multiplyBy10DFunction);
        System.out.println(incByOneAndMultipliedBy10Function.apply(10));

        BiFunction<Integer,Integer,Integer> addByOneAndMulBiFunction = (numberToAddOne, numberToMul)->(numberToAddOne+1)*numberToMul;
        System.out.println(addByOneAndMulBiFunction.apply(5,5));
    }


}
