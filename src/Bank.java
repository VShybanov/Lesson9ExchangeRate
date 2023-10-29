import java.util.Objects;

public class Bank /*implements Comparable<Bank>*/ {
    String name;
    double USDtoUAHrate;

    public Bank(String name, double USDtoUAHrate) {
        this.name = name;
        this.USDtoUAHrate = USDtoUAHrate;
    }

    @Override
    public String toString() {
        return String.format("%s, курс - %.4f грн./доллар", name, USDtoUAHrate);
    }

    /*
    @Override
    public int compareTo(Bank o) {
        return (this.USDtoUAHrate < o.USDtoUAHrate) ? 1 : (this.USDtoUAHrate == o.USDtoUAHrate) ? 0 : -1;
    }
     */
}
