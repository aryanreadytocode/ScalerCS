package AddedSubtractorSync;

public class Count {
    int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementValue(int value) {
        this.value += value;
    }
}
