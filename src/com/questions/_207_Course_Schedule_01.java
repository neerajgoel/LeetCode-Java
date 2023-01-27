import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 Runtime Complexity - O(V+E) - DFS approach
 Runtime - 5 ms
 Memory - 42.3 MB
*/
public class _207_Course_Schedule_01 {
    class Solution {

        enum Color{
            white, gray, black;
        }

        private boolean dfs(int n, Map<Integer, Set<Integer>> map, int s[], int f[], Color col[]){
            int time = -1;
            for(int i=0 ; i<n ; i++){
                if( col[i] == Color.white ){
                    // dfs visit
                    boolean res = dfs_visit(map, i, time, s, f, col);
                    if( !res  ){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs_visit(Map<Integer, Set<Integer>> map, int u, int time, int s[], int f[], Color col[]){
            time++;
            s[u] = time;
            col[u] = Color.gray;
            if( map.containsKey(u) ){
                for(int v : map.get(u)){
                    if( col[v] == Color.white ){
                        boolean result = dfs_visit(map, v, time, s, f, col);
                        if( !result ){
                            return false;
                        }
                    }
                    else if( col[v] == Color.gray ){
                        return false;
                    }
                }
            }
            time++;
            f[u] = time;
            col[u] = Color.black;
            return true;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Color col[] = new Color[numCourses];
            int s[] = new int[numCourses];
            int f[] = new int[numCourses];

            for(int i=0 ; i<numCourses ; i++){
                col[i] = Color.white;
                s[i] = f[i] = -1;
            }

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int j=0 ; j<prerequisites.length ; j++){
                if( !map.containsKey( prerequisites[j][1] ) ){
                    map.put( prerequisites[j][1], new HashSet() );
                }
                map.get( prerequisites[j][1] ).add( prerequisites[j][0] );
            }
            return dfs(numCourses, map, s, f, col);




        }
    }
}
