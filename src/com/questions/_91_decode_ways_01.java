class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private int find(String s, int current){
        //System.out.println("curr : " + current);
        if( map.containsKey(current) ){
            return map.get(current);
        }
        if( current >= s.length() )
            return 1;
        if( s.charAt(current) == '0' )
            return 0;
        int result = find(s, current + 1);
        if( current < s.length() - 1 ){
            int x = Integer.parseInt( s.substring(current, current + 2) );
            //System.out.println("curr : " + current + "\t x : " + x);
            if( x  >= 1 && x <= 26 ){
                result += find(s, current + 2 );
            }
        }
        //System.out.println("curr : " + current + "\t res : " + result);
        map.put(current, result);
        return result;
    }



    public int numDecodings(String s) {
        if( s.length() >= 1 && s.charAt(0) == '0')  
            return 0;
        int result = find(s, 0);
        System.out.println("result : " + result);
        return result;
    }
}
