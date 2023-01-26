import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 Runtime Complexity - O(E*K)

 Runtime - 4 ms
 Memory - 43.8 MB

*/
public class _787_Cheapest_Flights_Within_K_Stops_02 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int d[] = new int[n];
        int temp[] = new int[n];
        for(int i=0 ; i<n ; i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[src] = 0;

        for(int i=0 ; i<=k ; i++){
            for(int j=0 ; j<n ; j++){
                temp[j] = d[j];
            }
            System.out.print("d : ");
            Arrays.stream(d).forEach(c -> System.out.print(c + "\t"));
            System.out.println();
            for(int j=0 ; j<flights.length ; j++){
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];
                if( d[u] != Integer.MAX_VALUE && d[v] > d[u] + w && d[u] + w < temp[v]){
                    temp[v] = d[u] + w;
                }
            }
            System.out.print("te,p : ");
            Arrays.stream(temp).forEach(c -> System.out.print(c + "\t"));
            System.out.println();
            for(int j=0 ; j<n ; j++){
                d[j] = temp[j];
            }
        }

        return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }

    public static void main(String[] args) {
        int[][] flg = {{0,3,7},{4,5,3},{6,4,8},{2,0,10},{6,5,6},{1,2,2},{2,5,9},{2,6,8},
                {3,6,3},{4,0,10},{4,6,8},{5,2,6},{1,4,3},{4,1,6},{0,5,10},{3,1,5},{4,3,1},
                {5,4,10},{0,1,6}};
        int res = findCheapestPrice(7, flg, 2, 4, 1);
        System.out.println(res);
    }

}
