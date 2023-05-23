package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    int cap;
    Queue<Object> cars;
    Semaphore pps;
    Semaphore cs;

    Producer(Queue<Object> cars, int cap, Semaphore pps, Semaphore cs) {
        this.cap = cap;
        this.cars = cars;
        this.pps = pps;
        this.cs = cs;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pps.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            synchronized (cars) {
            if (cars.size() < cap)
                cars.add(new Object());
            System.out.println("Car size: " + cars.size());
            cs.release();
//            }
        }
    }
}
