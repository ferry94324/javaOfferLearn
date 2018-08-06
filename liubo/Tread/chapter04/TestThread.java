package liubo.Tread.chapter04;

/**
 *同步机制synchronized：synchronized关键字用于修饰方法或者单独的synchronized代码块，
 * 当一个线程想执行synchronized中的内容时，必须先获取到对象锁，当对象锁没有线程占用时，
 * 进入synchronized方法会自动获取到对象锁，执行完毕后会自动释放锁，如果对象锁被A线程占用，
 * B线程想执行synchronized的代码只能等待A个线程执行完毕后，释放对象锁，B线程才能获取到对象锁进入方法执行。
 * 一个线程获得对象A的锁，也可以获得对象B的锁，两个不同类的对象锁没有关联。
 *
 *
 * 如何要是去掉一个synchronized后，输出的语句是交叉执行的。
 * 这就说明，对于同一个对象，如果线程A得到了对象锁，线程B可以访问对象没有同步的方法和代码。
 * 进行同步的代码和没有同步的代码是互不影响的。
 */
public class TestThread {
    public void test1() {
        for(int j = 1;j<5;j++){
            System.out.println("out"+Thread.currentThread().getName() + " : " +j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
        synchronized (this) {
            int i = 0;
            while (i++<5) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }

    }

    public synchronized void test2() {
        for(int j = 1;j<5;j++){
            System.out.println("in"+Thread.currentThread().getName() + " : " +j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
        int i = 0;
        while (i++<5) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestThread test = new TestThread();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                test.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                test.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }

}
