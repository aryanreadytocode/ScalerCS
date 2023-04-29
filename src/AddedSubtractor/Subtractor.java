package AddedSubtractor;

public class Subtractor implements Runnable{
    Count count;
    Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        int i = 0;
        while (i < 10){
            count.value = count.value - 1;
            System.out.println("- "+count.value);
            i++;
        }
    }
}
