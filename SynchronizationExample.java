package newexample;

class Counter {
    private int count = 1;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    // Method to get the current count value
    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    private Counter counter;

    // Constructor to initialize the Counter object
    public MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Creating two threads with the same Counter object
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        // Starting both threads
        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        thread1.join();
        thread2.join();

        // Printing the final count value
        System.out.println("Final Count: " + counter.getCount());
    }
}


