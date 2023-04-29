package ProducerConsumer;

import javax.management.ObjectName;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable{
    int cap;
    Queue<Object>  cars;

    Consumer(Queue<Object>  cars, int cap) {
        this.cap = cap;
        this.cars = cars;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (cars) {
                if (cars.size() > 0)
                    cars.remove();
                System.out.println("Car size: "+cars.size());
            }
        }
    }
}
