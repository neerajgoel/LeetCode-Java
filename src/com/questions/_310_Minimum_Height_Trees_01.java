import java.util.*;

/*
 Runtime Complexity - O(n*(V+E)) - DFS approach

Time Limit Exceeded
63 / 71 testcases passed

*/
public class _310_Minimum_Height_Trees_01 {

    private void insertInMap(int u, int v, Map<Integer, Set<Integer>> map){
        if( !map.containsKey(u) ){
            map.put(u, new HashSet<>());
        }
        map.get(u).add(v);
    }

    enum Color{
        white, gray, black;
    }

    private int findHeight(Map<Integer, Set<Integer>> map, Color col[], int s){
        if( map.containsKey(s) ){
            col[s] = Color.gray;
            int maxHeight = Integer.MIN_VALUE;
            for(int v : map.get(s)){
                if( col[v] == Color.white ){
                    int ht = findHeight(map, col, v);
                    if( maxHeight < ht ){
                        maxHeight = ht;
                    }
                }
            }
            return maxHeight + 1;
        }
        return 0;
    }

    private void initcolor(Color col[]){
        for(int i=0 ; i<col.length ; i++){
            col[i] = Color.white;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for( int i=0 ; i<edges.length ; i++ ){
            insertInMap(edges[i][0], edges[i][1], map);
            insertInMap(edges[i][1], edges[i][0], map);
        }

        Color col[] = new Color[n];

        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        int minHeight = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            initcolor(col);
            int ht = findHeight(map, col, i);
            if( !resultMap.containsKey(ht) ){
                resultMap.put(ht, new ArrayList<>() );
            }
            resultMap.get(ht).add(i);
            if( minHeight > ht ){
                minHeight = ht;
            }
        }
        return resultMap.get(minHeight);


    }

}
