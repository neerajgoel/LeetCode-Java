/*
RunTime complexity : O(n)
Runtime: 16 ms, faster than 75.70% of Java online submissions for Plates Between Candles.
Memory Usage: 143.4 MB, less than 35.69% of Java online submissions for Plates Between Candles.
*/

class _2055_Plates_Between_Candles_01 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int nearestCandleLeft[] = new int[s.length()];
        int nearestCandleRight[] = new int[s.length()];
        
        int plates[] = new int[s.length()];
        int plate = 0;
        int i=-1;
        for(char c : s.toCharArray()){
            i++;
            if( c == '*' ){
                plate++;
            }
            plates[i] = plate;
        }
        
        // calculate nearest candle left
        int candleIndex = -1;
        for(i=0 ; i<s.length() ; i++){
            if( s.charAt(i) == '|' ){
                candleIndex = i;
            }
            nearestCandleLeft[i] = candleIndex;
        }
        
        // calculate nearest candle right
        candleIndex = -1;
        for(i=s.length()-1 ; i>=0 ; i--){
            if( s.charAt(i) == '|' ){
                candleIndex = i;
            }
            nearestCandleRight[i] = candleIndex;
        }
        
        int res[] = new int[queries.length];
        
        for(i=0 ; i<queries.length ; i++){
            int ncr = nearestCandleRight[ queries[i][0] ];
            int ncl = nearestCandleLeft[ queries[i][1] ];
            //System.out.println("ncr:" + ncr + "\tncl:" + ncl);
            if( !(ncl == -1 || ncr == -1) && ncl > ncr ){
                res[i] = plates[ncl] - plates[ncr];
            }else{
                res[i] = 0;
            }
        }
        return res;
    }
}
