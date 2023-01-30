import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_Generate_Parentheses_01 {

    private void calc(int n, int open, int close, Stack<Character> st, List<String> result){
        if( st.size() == 2*n ){
            StringBuilder sb = new StringBuilder();
            st.stream().forEach( str -> sb.append(str) );
            result.add( sb.toString() );
            return;
        }
        if( open < n ){
            // open can be added
            st.push('(');
            calc(n, open + 1, close, st, result);
            st.pop();
        }
        if( open > close ){
            // close can be added
            st.push(')');
            calc(n, open, close + 1, st, result);
            st.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        st.push('(');
        calc(n, 1, 0, st, result );
        return result;
    }

}
