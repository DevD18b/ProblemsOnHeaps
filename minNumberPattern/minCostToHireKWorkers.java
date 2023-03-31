package minNumberPattern;

import java.util.Arrays;
import java.util.PriorityQueue;


public class minCostToHireKWorkers {
public static double find(int [] qarr , int []warr , int kth){
    Workers [] worker = new Workers[qarr.length];
    for(int i = 0; i<qarr.length; i++){
            worker[i] = new  Workers(qarr[i], warr[i]);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(worker);
    int sum = 0;
    double ans  = 1e9;
    for(Workers work : worker){
           pq.offer(-work.quality);
           sum+=work.quality;
           if(pq.size()>kth) sum+=pq.poll();
         if(pq.size()==kth){
            ans = Math.min(ans, sum*(work.wages/work.quality));
         }
    }
    return ans;
}
public static double easyPeasyMethod(int [] q , int [] w , int k){
    double [][] arr = new double[q.length][w.length];
    
    for(int i  =0; i<q.length; i++){
        arr[i] =  new double[]{(double)(q[i]/w[i]),(double)q[i]};
    }

       Arrays.sort(arr);
     
       int sum = 0;
       PriorityQueue<Double> pq  = new PriorityQueue<>();
       // pq gives me lowest quality worker which help meh 
       // minimize my payCheck to hire k workers.
       double ans  = 0;
       for(double [] a : arr){
        sum+=a[1];
        pq.offer(a[1]);
        if(pq.size()>k){
          sum-=pq.poll();
        }
        if(pq.size()==k){
            ans = Math.min(ans,  sum*(a[0]));
        }

       }

 return ans;


}    
}

class Workers implements Comparable<Workers>{
    int quality ;
    int wages;
    Workers(int q , int w){
        this.quality =q;
        this.wages = w;
    }
    double ratio(){
        return (double)(wages/quality);
    }
    @Override
    public int compareTo(Workers o) {
        return Double.compare(this.ratio(), o.ratio());
    }
    
    
}
