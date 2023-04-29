package ProducerConsumer;

import javax.management.ObjectName;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Producer implements Runnable{
    int cap;
    Queue<Object>  cars;
    Producer(Queue<Object> cars, int cap) {
        this.cap = cap;
        this.cars = cars;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (cars) {
                if (cars.size() < cap)
                    cars.add(new Object());
                System.out.println("Car size: "+cars.size());
            }
        }
    }
}
