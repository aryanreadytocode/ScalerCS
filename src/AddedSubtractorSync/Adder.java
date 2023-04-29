package AddedSubtractorSync;

public class Adder implements Runnable {
    final Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10000) {
            count.incrementValue(i);
            i++;
        }
    }
}
