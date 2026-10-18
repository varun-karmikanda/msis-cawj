package lab1;

public class q03_SumArguments {
    public static void main(String[] args) {
        int result = Integer.parseInt(args[0]) + Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
        System.out.println("sum of three arguments: " + result);
    }
}
