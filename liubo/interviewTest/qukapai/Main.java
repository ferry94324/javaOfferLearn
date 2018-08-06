package liubo.interviewTest.qukapai;

import java.util.*;

public class Main {
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<int[]> friends = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String[] temp = scanner.nextLine().split(" ");
            int[] tempFriend = new int[temp.length];
            for(int j=0;j<temp.length;j++)
            {
                tempFriend[j] = Integer.parseInt(temp[j]);
            }
            friends.add(tempFriend);
        }
        int[] target = friends.get(m);
        Set<Integer> commenFrient = new HashSet<Integer>();
        HashMap<Integer,Integer> used = new HashMap<Integer,Integer>();
        used.put(m,0);
        for(Integer ii:target)
        {
            used.put(ii,0);
        }
        for(int i=0;i<target.length;i++)
        {
            for(Integer onn:friends.get(target[i]))
            {
                if(!used.containsKey(onn))
                {
                    int result = compare(target,friends.get(onn));
                    used.put(onn,result);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(Map.Entry<Integer,Integer> one:used.entrySet())
        {
            if(one.getValue()>max)
            {
                max = one.getValue();
                index = one.getKey();
            }
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        solution();
    }
    public static int compare(int[] a,int[] b)
    {
        int result = 0;
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                if(a[i]==b[j])
                    result = result+1;
            }
        }
        return result;
    }
}
