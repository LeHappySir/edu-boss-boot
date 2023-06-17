import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test
 *
 * @author xianhongle
 * @data 2023/5/17 10:38
 **/
public class Test<T> {

    private T date;

    public T getDate(){
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static void main(String[] args) {
        Test<String> test = new Test<String>(){};
        Type type = test.getClass().getGenericSuperclass();
        System.out.println(type);
        Type typeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        System.out.println(typeArgument);

        new LinkedList<String>();
        HashMap<String, String> map = new HashMap<>();
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
        new HashSet<String>();
        new LinkedHashMap<String,String>();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread runnableThread = new Thread(new RunnableTest());

        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
        Thread thread = new Thread(futureTask);
        try {
            String s = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ThreadTest threadTest = new ThreadTest();
        threadTest.run();

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        Condition condition = lock.newCondition();
        try {
            condition.await();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(1,0);

    }

    public static class RunnableTest implements Runnable{

        @Override
        public void run() {

        }
    }

    public static class CallableTest implements Callable<String>{

        @Override
        public String call() throws Exception {
            return null;
        }
    }

    public static class ThreadTest extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
