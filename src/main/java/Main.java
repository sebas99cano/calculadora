import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Suma : " + sum().applyAsInt(5,9));
        System.out.println("Resta : "+ sub().applyAsInt(15,10));
        System.out.println("Multiplicacion : "+ multiply().applyAsInt(4,5));
        System.out.println("Division : "+ division().applyAsInt(35,0));
    }

    private static IntBinaryOperator division() {
        return (a,b) -> IntStream.range(0, a)
                .reduce((accumulator,number)-> multiply().applyAsInt(number,b)<= a?sum().applyAsInt(accumulator,1) :accumulator).orElse(0);
    }

    public static IntBinaryOperator multiply(){
        return (a , b) -> IntStream.range(0, b+1)
                .reduce((accumulator, number)-> sum().applyAsInt(accumulator, a)).getAsInt();
    }

    private static IntBinaryOperator sub() {
        return (a, b) -> (a-b);
    }

    private static IntBinaryOperator sum() {
        return Integer::sum;
    }

}
