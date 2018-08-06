package liubo.Tread.chapter04;

public class ClassThread {
    public static void main(String[] args) {
        final ClassThread my=new ClassThread();
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
                    ClassThread.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"test2");
        thread1.start();
        thread2.start();
    }


    public void test1() throws InterruptedException{
        synchronized (ClassThread.class) {
            int i=0;
            while(i++<5){
                System.out.println(Thread.currentThread().getName()+":"+i);
                Thread.sleep(500);
            }
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
