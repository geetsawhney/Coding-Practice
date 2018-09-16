
// Leetcode 905
class EvenBeforeOdd {
    public static int[] sortArrayByParity(int[] A) {
        int i=0, j=A.length-1, out[]=new int[A.length];
        for(int x: A){
            if(x%2==0){
                out[i++]=x;
            }
            else{
                out[j--]=x;
            }
        }
        return out;
    }

    public static void main(String[] args) {
    	int[] input= {1,2,3,4,5,6,7};
    	input=sortArrayByParity(input);
    	for(int n: input) {
			System.out.println(n);
		}
	}
}
