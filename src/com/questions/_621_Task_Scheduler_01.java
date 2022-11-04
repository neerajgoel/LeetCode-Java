/*
 Runtime Complexity - O(n)
 Runtime - 61 ms
 Memory - 69 MB
*/

class Solution {
    
    class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -(o1-o2);
        }
    }

    class Pair{
        int first, second;
        Pair(int _f, int _s){
            first = _f;
            second = _s;
        }
        @Override
        public String toString(){
            return first + "\t" + second;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if( n == 0 )
            return tasks.length;
        int tsksAr[] = new int[26];
        for(int i=0 ; i<26 ; i++)
            tsksAr[i] = 0;
        for(char t : tasks){
            tsksAr[t-'A']++;
        }
        PriorityQueue<Integer> tsks = new PriorityQueue<>(new MaxComparator());
        for(int t : tsksAr){
            if( t != 0 )
                tsks.add(t);
        }
        Queue<Pair> que = new LinkedList<>();
        int time = 0;
        while( tsks.size() > 0 || que.size() > 0 ){
            time++;
            //System.out.println("Time : " + time + "\t: Tsks Size():" +  tsks.size());
            // consume process
            if( tsks.size() > 0 ){
                int t = tsks.poll();
                //System.out.println("Consuming : " + t);
                t--;
                if( t > 0 ){
                    Pair p = new Pair(t, time + n);
                    que.add( p );
                    //System.out.println("Adding in queue : " + p);
                }
            }

            //System.out.println("Checking in queue : " + que.size());
            // add from queue at last
            if(que.size() > 0 && time == que.peek().second){
                Pair p = que.poll();
                tsks.add(p.first);
                //System.out.println("Adding in tsks : " + p.first);
            }
        }
        //System.out.println("res : " + time);
        return time;
    }
}
