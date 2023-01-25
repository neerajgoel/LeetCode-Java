
/*
O(n) - time complexity
Runtime - 8 ms
Memory - 43.5 MB
*/
public class _151_Reverse_Words_in_a_String_01 {

    public String reverseWords(String s) {
        if( s == null ){
            return s;
        }

        int first, last;
        StringBuilder result = new StringBuilder();
        first = last = -1;
        char ch;
        for(int i=s.length()-1 ; i>=0 ; i--){
            ch = s.charAt(i);
            if( ch == ' ' ){
                if( last == -1 ){
                    continue;
                }
                else{
                    // last is set
                    // push in results
                    result.append( s.substring(first, last+1) + " ");
                    first = last = -1;
                }
            }
            else{
                // if ch is a character
                if( last == -1 ){
                    first = last = i;
                    continue;
                }
                else{
                    first = i;
                }
            }
        }
        if( first >= 0 && last < s.length()  ){
            result.append( s.substring(first, last+1) + " ");
        }

        String resultStr = result.toString();
        if( resultStr.length() > 0 && resultStr.charAt( resultStr.length() - 1 ) == ' ' ){
            return result.substring(0, resultStr.length() - 1);
        }
        return resultStr;
    }

}
