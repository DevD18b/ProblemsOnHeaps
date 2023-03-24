package TopKpatterns;

import java.util.Objects;
import java.util.PriorityQueue;

public class kthClosestPoints {
    public static int [][] kthClosestPointsToOrigin(int [][] points , int k){
            PriorityQueue<coordinate> pq = new PriorityQueue<>();
            for(int i = 0; i<points.length; i++){
                 int x  = points[i][0];
                 int y  = points[i][1];
                 long distance = x*x+y*y;
                 pq.offer(new coordinate((int) distance, points[i]));
            }
            points =  new int[k][2];
            for(int i =0 ; i<k; i++){
                points[i] = Objects.requireNonNull(pq.poll()).coordinateArray;
            }
            return points;

}
}
class coordinate{
    int  distance;
    int [] coordinateArray;
    coordinate(int distance , int [] arr){
        this.distance = distance;
        this.coordinateArray = arr;
    }
}