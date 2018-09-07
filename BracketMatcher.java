import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketMatcher {

	public static boolean isValid(String s) {

		int len=s.length();

		if(len==0)
			return true;
		if(len%2==1)
			return false;

		Stack<Character> st=new Stack<>();
		char c;
		Map<Character, Character> bracket=new HashMap<>();
		bracket.put('(', ')');
		bracket.put('{', '}');
		bracket.put('[', ']');

		for(int i=0;i<len;i++) {
			c=s.charAt(i);
			if(!st.isEmpty()) {
				if(bracket.containsKey(st.peek())){
					if(c==bracket.get(st.peek()))
						st.pop();
					else
						st.push(c);
				}else {
					return false;
				}
			}
			else {
				st.push(c);
			}
		}
		return st.empty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("{{)}"));
	}

}
