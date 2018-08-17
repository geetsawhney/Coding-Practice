import java.util.HashMap;

public class PerfectSquares {
	public static int numSquares(int n, HashMap<Integer, Integer> h) {
		if(n<2) {
			h.put(n, n);
			return n;
		}
       if(h.containsKey(n)) {
           return h.get(n);
       }

		int a = (int) Math.sqrt(n);

		int min= Integer.MAX_VALUE;
		int next;
		for(int i=a;i>0;i--) {
			next=n-(i*i);

			if(next==0)
			{
				h.put(next, 1);
				return 1;
			}

			if(h.containsKey(next)) {
				if((1+h.get(next)) < min)
					min=1+h.get(next);
			}
			else{
				int p=numSquares(next,h);
				if(min>1+p)
					min=1+p;
			}
		}
		h.put(n, min);
		return min;
	}

	public static int numSquares(int n) {
		return numSquares(n, new HashMap<Integer,Integer>());
	}


	public static void main(String args[]){
		System.out.println(numSquares(10000));
	}
}
