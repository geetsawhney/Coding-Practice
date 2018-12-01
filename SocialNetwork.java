package assessment;

import java.util.*;

public class SocialNetwork {
	public static void socialGraphs(List<Integer> counts) {
		TreeMap<Integer, List<Integer>> group = new TreeMap<>(Collections.reverseOrder());

		for(int i=0;i<counts.size();i++) {
			if(!group.containsKey(counts.get(i))) {
				group.put(counts.get(i), new ArrayList<>());
				group.get(counts.get(i)).add(i);
			}
			else {
				group.get(counts.get(i)).add(i);
			}
		}

		int groupLen=group.keySet().size();
		int counter=0;

		for(Integer key: group.keySet()) {

			for(int i=0;i<group.get(key).size();i++) {

				if(i%key==0 && i!=0)
					System.out.println();
				System.out.print(group.get(key).get(i));

				if((i+1)%key!=0)
					System.out.print(" ");

			}

			if(counter!=groupLen-1)
				System.out.println();
			counter++;
		}
//		System.out.println(group);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		socialGraphs(Arrays.asList(new Integer[] {3,3,3,3,3,1,3}));
	}

}
