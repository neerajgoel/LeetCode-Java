import java.util.*;

/*
O(n) - time complexity
Runtime - 28 ms
Memory - 54.9 MB
*/
public class _451_Sort_Characters_By_Frequency_01 {

    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for( char c : s.toCharArray()){
                if( !map.containsKey(c) ){
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                    return -1 * (o1.getValue() - o2.getValue());
                }
            });

            StringBuilder sb = new StringBuilder();
            int x;
            for(Map.Entry<Character, Integer> entry : list){
                x = entry.getValue();
                while(x-- > 0){
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }

}
