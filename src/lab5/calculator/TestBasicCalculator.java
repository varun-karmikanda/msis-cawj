package lab5.calculator;

public class TestBasicCalculator {

    private static void testPutAndRead(){
        Calculator calculator = BasicCalculator.getInstance();

        assert calculator.read() == 0 : "Result is 0";

        assert calculator
                .put(10)
                .put(15)
                .add()
                .read() == 25 : "Addition result is 25";

        assert calculator
                .clear()
                .read() == 0 : "Removed 15 and return 10";

        assert calculator
                .put(1)
                .put(2)
                .put(67)
                .read() == 67: "Reads value 67";
    }

    private static void testAdd(){
        Calculator calculator = BasicCalculator.getInstance();

        assert calculator.read() == 0: "Values are 0 when creating new instance";

        assert calculator
                .put(10)
                .put(30)
                .put(20)
                .add()
                .read() == 50 : "Thw sum must be 50";
    }

    public static void testNegation(){
        Calculator calculator = BasicCalculator.getInstance();

        assert calculator
                .put(-67)
                .neg()
                .read() == -67 : "Neg of -67 is 67";
    }

    public static void main(String[] args){
        testPutAndRead();
        testAdd();
        testNegation();
    }
}
