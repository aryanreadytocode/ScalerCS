package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    int cap;
    Queue<Object> cars;
    Semaphore cs;
    Semaphore pps;

    Consumer(Queue<Object> cars, int cap, Semaphore cs, Semaphore pps) {
        this.cap = cap;
        this.cars = cars;
        this.cs = cs;
        this.pps = pps;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cs.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            synchronized (cars) {
            if (cars.size() > 0)
                cars.remove();
            pps.release();
            System.out.println("Car size: " + cars.size());
//            }
        }
    }
}
