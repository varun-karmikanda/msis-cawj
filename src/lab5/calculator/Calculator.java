package lab5.calculator;

public interface Calculator {
    Calculator put(int n);
    int read();
    Calculator neg();
    Calculator add();
    Calculator sub();
    Calculator mul();
    Calculator div();
    Calculator clear();
    Calculator clearAll();
}
