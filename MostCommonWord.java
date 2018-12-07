//leetcode 819

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {

		String[] words = paragraph.split("[\\s\\.,!;'?]+");
		Set<String> ban = new HashSet<>();
		ban.addAll(Arrays.asList(banned));
		Map<String, Integer> map=new HashMap<>();

		int ansCount=0;
		String ans = null;

		for(String w:words) {
			w=w.toLowerCase();
			if(!ban.contains(w)){
				map.put(w, map.getOrDefault(w, 0)+1);
				if(ansCount<map.get(w)) {
					ans=w;
					ansCount=map.get(w);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
