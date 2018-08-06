package liubo.Tread.chapter01;

public class TicketWindows extends Thread {
    private final String name;

    private static final int MAX = 1000;

    private static int index = 1; //加入static修饰，做到多线程下共享资源的唯一性

    public TicketWindows(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(index<MAX){
            System.out.println("柜台"+name+"当前的号码是："+(index++));
        }
    }

    public static void main(String[] args) {
        TicketWindows ticketWindows1 = new TicketWindows("一号出号机");
        ticketWindows1.start();
        TicketWindows ticketWindows2 = new TicketWindows("二号出号机");
        ticketWindows2.start();
        TicketWindows ticketWindows3 = new TicketWindows("三号出号机");
        ticketWindows3.start();
        TicketWindows ticketWindows4 = new TicketWindows("四号出号机");
        ticketWindows4.start();
    }
}
