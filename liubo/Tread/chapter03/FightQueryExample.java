package liubo.Tread.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FightQueryExample {
    private static List<String> fightcompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");
        System.out.println("===========result============");
        results.forEach(System.out::println);

    }
    private static List<String> search(String original ,String dest){
        final List<String> result = new ArrayList<>();

        List<FightQueryTask> tasks = fightcompany.stream().map(f -> createSearchhTask(f,original,dest)).collect(Collectors.toList());
        tasks.forEach(Thread::start);
        tasks.forEach(
                t ->{
                    try{
                        t.join();
                    }catch (InterruptedException e){

                    }
                }
        );
        tasks.stream().map(FightQuery::get).forEach(result::addAll);
        return result;
    }
    private static FightQueryTask createSearchhTask(String fight,String original,String dest){
        return new FightQueryTask(fight,original,dest);
    }
}
