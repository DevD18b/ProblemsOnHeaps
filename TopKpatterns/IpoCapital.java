package TopKpatterns;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
public class IpoCapital {
    public static int Ipo(int [] capital , int [] profit , int w , int numberOfProjects){
        ArrayList<greedy> list = new ArrayList<>();          
            for(int i = 0; i<capital.length; i++){
                list.add(new greedy(capital[i], profit[i]));
            }
            Collections.sort(list);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = capital.length;
            int j = 0;
            for(int i = 0; i<numberOfProjects; i++){
                while(j<n && list.get(j).cap<=w){
                    pq.offer(list.get(j++).prof);
                }
                if(pq.isEmpty()){
                    break;
                }
                else{
                    w+=pq.poll();
                }
            }
            return w;


    }    
}
class greedy implements Comparable<greedy>{
int cap;
int prof;
greedy(int cap , int prof){
    this.cap = cap;
    this.prof = prof;
}
    @Override
    public int compareTo(greedy o) {
          return this.prof-o.prof;

    }
    
}
