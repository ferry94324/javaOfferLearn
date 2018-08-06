package liubo.Tread.chapter04;

/**
 * 这个例子表示，类锁和对象锁所属的区域不同。两者互不影响，所以会出现抢占资源问题
 */
public class ClassThread2 {
    public static void main(String[] args) {
        final ClassThread2 my=new ClassThread2();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    my.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"test1");
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ClassThread2.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"test2");
        thread1.start();
        thread2.start();
    }

    public synchronized void test1() throws InterruptedException{
        int i=0;
        while(i++<5){
            System.out.println(Thread.currentThread().getName()+":"+i);
            Thread.sleep(500);
        }
    }

    public static synchronized void test2() throws InterruptedException{
        int i=0;
        while(i++<5){
            System.out.println(Thread.currentThread().getName()+":"+i);
            Thread.sleep(500);
        }
    }

}
