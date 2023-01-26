import java.util.HashMap;
import java.util.Map;

/*
 Runtime Complexity - O(2^n)
 Time Limit Exceeded
 28 / 52 testcases passed
*/
public class _787_Cheapest_Flights_Within_K_Stops_01 {

    private int result = Integer.MAX_VALUE;

    private void find(Map<Integer, Map<Integer, Integer>> map, int src, int dst, int k, int currentWeight){
        if( src == dst ){
            if( result > currentWeight ){
                result = currentWeight;
            }
            return ;
        }
        if( k < 0 ){
            return;
        }
        if( !map.containsKey(src) ){
            return ;
        }
        for( Map.Entry<Integer, Integer> entry : map.get(src).entrySet() ){
            find(map, entry.getKey(), dst, k - 1, currentWeight + entry.getValue());
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create map
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int s, d;
        for(int i=0 ; i<flights.length ; i++){
            s = flights[i][0];
            d = flights[i][1];
            if( !map.containsKey(s) ){
                map.put( s, new HashMap<>() );
            }
            map.get(s).put(d, flights[i][2]);
        }

        find(map, src, dst, k, 0);

        if( result == Integer.MAX_VALUE )
            return -1;
        return result;
    }

}
