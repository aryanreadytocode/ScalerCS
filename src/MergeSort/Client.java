package MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> list = List.of(7,3,1,4,9,8,2,6);
        MergeSorter mergeSorter = new MergeSorter(list, executorService);
        Future<List<Integer>> sortedArray = executorService.submit(mergeSorter);
//        List<Integer> sortedArray = mergeSorter.call();
//        sortedArray.forEach(System.out::print);
        System.out.println(sortedArray.get());
    }
}
