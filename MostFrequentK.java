package assessment;

//leetcode 692

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentK {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count =new HashMap<>();

		class StringFreq{
			String string;
			int freq;
			public StringFreq(String x,int y) {
				string=x;
				freq=y;
			}
		}

		for(String s:words){
			count.put(s, count.getOrDefault(s, 0)+1);
		}

		PriorityQueue<StringFreq> pq=new PriorityQueue<>(new Comparator<StringFreq>() {

			@Override
			public int compare(StringFreq o1, StringFreq o2) {
				if(o1.freq==o2.freq)
					return o2.string.compareTo(o1.string);
				return o1.freq-o2.freq;
			}
		});

		for(String key: count.keySet()) {
			if(pq.size()<k) {
				pq.add(new StringFreq(key,count.get(key)));
			}else {
				if(pq.peek().freq<count.get(key) || pq.peek().freq==count.get(key) && pq.peek().string.compareTo(key)>0) {
					pq.poll();
					pq.add(new StringFreq(key,count.get(key)));
				}
			}
		}

		List<String> ans=new ArrayList<>(pq.size());
		while(!pq.isEmpty()) {
			ans.add(pq.poll().string);
		}
		Collections.reverse(ans);
		return ans;
	}
}
