package liubo.Tread.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends Thread implements FightQuery {
    private final String origin;
    private final String destination;
    private final List<String> flightList = new ArrayList<>();
    public FightQueryTask(String airline,String origin,String destination){
        super("["+airline+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println(getName()+"-query from "+origin+"  to "+destination+"\n");
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try{
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName()+"-"+randomVal);
            System.out.println("this Fight :"+getName()+" list query successful\n");
        }catch (InterruptedException e){

        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
