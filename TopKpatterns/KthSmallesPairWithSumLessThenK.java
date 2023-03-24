package TopKpatterns;
import java.util.*;
import java.util.ArrayList;



public class KthSmallesPairWithSumLessThenK {

    public static int findKthSmallestSum(int [][] matrix , int kth){
        // i am given two hints --> as for example rows are sorted.
        // secondly i need to maintain sum in pairs.
        int[] row = matrix[0];
        for(int i = 1; i<matrix.length; i++){
             helper(row , matrix [i], kth);
        }
        return row[kth-1];
    }
    public static void helper(int [] arr1, int [] arr2 , int kth){
         
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->(a[0]+a[1])-(b[0]+b[1]));
        for(int i = 0; i<arr1.length && i<kth; i++){
            pq.offer(new int[]{arr1[i],arr2[0],0});
        }
        for(int i = 0; i<kth && pq.isEmpty()==false; i++){
            int [] arr = pq.poll();
            list.add(arr[0]+arr[1]);
            int arr2Index =  arr[2];
            if(arr2Index<arr2.length-1){
                   pq.offer(new int[]{arr1[0],arr2[arr2Index+1],arr2Index+1});
            }
        }
        







    }

    
}
