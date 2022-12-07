/*
 Runtime Complexity - O(n)
 Runtime - 6 ms
 Memory - 48.9 MB
*/
class Solution {

    enum color{
        black, gray, white;
    }

    private void dfs(int numCourses){
        for(int i=0 ; i<numCourses ; i++){
            if( col[i] == color.white ){
                dfs_visit(i);
            }
        }
    }

    private void dfs_visit(int u){
        //System.out.println(" u : " + u);
        col[u] = color.gray;
        for(int v : grp.get(u) ){
            if( col[v] == color.white){
                dfs_visit(v);
            }
            else if( col[v] == color.gray){
                foundLoop = true;
            }
        }
        col[u] = color.black;
        // insert at head of result;
        result[index] = u;
        index--;
    }

    color col[];
    List<List<Integer>> grp;
    int result[];
    int index;
    boolean foundLoop = false;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        grp = new ArrayList<>();
        col = new color[numCourses];
        index = numCourses - 1;
        result = new int[numCourses];
        for(int i=0 ; i<numCourses ; i++){
            col[i] = color.white;
            grp.add(new ArrayList<>());
        }
        for(int[] ar : prerequisites){
            grp.get(ar[1]).add(ar[0]);
        }
        dfs(numCourses);
        return foundLoop ? new int[]{} : result;
    }
}
