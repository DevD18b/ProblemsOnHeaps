package TopKpatterns;
import java.util.*;
public class sortCharacter {
    public static String frequencySort(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();
            for(char ch : str.toCharArray()){
               map.put(ch,map.getOrDefault(ch, 0)+1);
             }
            
             PriorityQueue<Map.Entry<Character,Integer>>mpq =  new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
                 mpq.addAll(map.entrySet());
                StringBuilder sb   = new StringBuilder();
                 while(!mpq.isEmpty()){
                    HashMap.Entry<Character,Integer>m = mpq.poll();
                    int frequency = m.getValue();
                    while(frequency!=0){
                          sb.append(m.getValue());
                          frequency--;
                    }
                 }
                 return sb.toString();
    }
    
}
