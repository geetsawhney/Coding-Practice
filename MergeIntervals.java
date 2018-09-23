//Leetcode 56

import java.util.*;

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		int len=intervals.size();
		if(len<2)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});

		List<Interval> output=new ArrayList<Interval>();
		int first=intervals.get(0).start;
		int last=intervals.get(0).end;

		int currStart = 0,currEnd = 0;
		for(int i=1;i<len;i++) {
			currStart=intervals.get(i).start;
			currEnd=intervals.get(i).end;

			if(currStart>last) {
				output.add(new Interval(first,last));
				first=currStart;
				last=currEnd;
			}

			else if (currEnd>last) {
				last=currEnd;
			}

		}

		output.add(new Interval(first,last));
		return output;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> input=new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(2, 6));
		input.add(new Interval(8, 10));
		input.add(new Interval(15, 18));

		for(Interval x:merge(input)) {
			System.out.println(x.start+"  "+x.end);
		}


	}

}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
