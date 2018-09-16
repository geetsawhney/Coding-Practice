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

    public static int[] sortArrayByParity_1(int[] A) {
        int i=0, j=A.length-1;
        int temp;
        while(i<j) {
        	if(A[i]%2!=0 && A[j]%2==0) {
        		temp=A[i];
        		A[i]=A[j];
        		A[j]=temp;
        		i++;
        		j--;
        	}
        	if(i>=j)
        	 return A;
        	if(A[i]%2==0)
        		i++;
        	if(A[j]%2!=0)
        		j--;
        }

        return A;
    }


    public static void main(String[] args) {
    	int[] input= {1,2,3,4,5,6,7};
    	input=sortArrayByParity_1(input);
    	for(int n: input) {
			System.out.println(n);
		}
	}
}
