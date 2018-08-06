package liubo.Tread.chapter02;

import java.util.stream.IntStream;

public class ThreadName {
    public static void main(String[] args) {
        IntStream.range(0,5).boxed().map(i->new Thread(
                ()-> System.out.println(Thread.currentThread().getName())
        )).forEach(Thread::start);
    }
}

