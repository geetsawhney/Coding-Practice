import java.util.HashMap;

public class FindElementWithOddOccurences {

	public static void main(String[] args) {

		 System.out.println(FindElementWithOddOccurences.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
	}

	public static int findIt(int[] A) {
	    HashMap<Integer,Integer> map=new HashMap<>();
	    for(int i=0;i<A.length;i++){
	      if(map.containsKey(A[i])){
	    	  map.put(A[i], map.get(A[i])+1);
	      }
	      else{
	    	  map.put(A[i], 1);
	      }
	    }
	    for(int x: map.keySet()){
	    	if(map.get(x)%2==1){
	    		return x;
	    	}
	    }
		return 0;
	  }

}
