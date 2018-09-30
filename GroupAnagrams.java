//leetcode 49

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<HashMap<Character,Integer>, List<String>> map=new HashMap<>();
		HashMap<Character, Integer> letters;
		List<List<String>> ans=new ArrayList<>();
		char c;
		for(String s: strs) {
			letters=new HashMap<>();
			for(int i=0;i<s.length();i++) {
				c=s.charAt(i);
				if(letters.containsKey(c)) {
					letters.put(c, letters.get(c)+1);
				}else {
					letters.put(c, 1);
				}
			}

			if(map.containsKey(letters)) {
				map.get(letters).add(s);
			}else {
				map.put(letters, new ArrayList<String>(Arrays.asList(s)));
			}
		}

		for(HashMap<Character,Integer> key: map.keySet()) {
			ans.add(map.get(key));
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));

	}

}
