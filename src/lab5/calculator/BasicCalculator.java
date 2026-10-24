package lab5.calculator;

public class BasicCalculator implements Calculator {
    int[] cells;
    int t;

    private BasicCalculator(){
        this.cells = new int[2];
    }

    public static Calculator getInstance(){
        Calculator basicCalculator = new BasicCalculator();
        basicCalculator.clearAll();
        return basicCalculator;
    }

    @Override
    public Calculator put(int n) {
        cells[t] = n;
        t = (t + 1) % 2;
        return this;
    }

    @Override
    public int read(){
        return this.cells[0];
    }

    @Override
    public Calculator neg() {
        this.cells[t] = -this.cells[t];
        return this;
    }

    @Override
    public Calculator add() {
        this.cells[0] += this.cells[1];
        t = 0;
        return this;
    }

    @Override
    public Calculator sub() {
        this.cells[0] -= this.cells[1];
        t = 0;
        return this;
    }

    @Override
    public Calculator mul() {
        this.cells[0] *= this.cells[1];
        t = 0;
        return this;
    }

    @Override
    public Calculator div() {
        if(this.cells[1] != 0) this.cells[0] /= this.cells[1];
        return this;
    }

    @Override
    public Calculator clear() {
        this.cells[t] = 0;
        t = 0;
        return this;
    }

    @Override
    public Calculator clearAll() {
        this.cells[0] = this.cells[1] = 0;
        t = 0;
        return this;
    }
}