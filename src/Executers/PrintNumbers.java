package Executers;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNumbers {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int num = 0;
        while (num < 100){
            if (num == 5 || num == 10 || num == 20)
                System.out.println(num);
            NumberPrinter printer = new NumberPrinter(num);
            executorService.submit(printer);
            num++;
        }
        executorService.shutdown();
    }
}

class NumberPrinter implements Runnable {

    int num;
    NumberPrinter(int value){
        num = value;
    }

    @Override
    public void run() {
        System.out.println("Printing :"+this.num+" " +
                "Printed by : "+Thread.currentThread().getName());
    }
}
