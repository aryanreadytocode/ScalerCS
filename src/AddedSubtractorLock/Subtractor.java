package AddedSubtractorLock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Count count;
    Lock lock;
    Subtractor(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        int i = 0;

        while (i < 10000){
            lock.lock();
            count.value -= i;
            System.out.println("-"+i);
            lock.unlock();
            i++;
        }
    }
}
