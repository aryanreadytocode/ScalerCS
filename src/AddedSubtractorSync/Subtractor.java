package AddedSubtractorSync;

public class Subtractor implements Runnable {
    final Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10000) {
            count.incrementValue(-i);
            i++;
        }
    }
}
