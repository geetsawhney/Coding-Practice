
public class StockBuySell {

	public static int maxProfit(int[] prices) {
		int ans=0;
		for(int i=0;i<prices.length-1;i++) {
			for(int j=i+1;j<prices.length;j++) {
				if(ans<prices[j]-prices[i]) {
					ans=prices[j]-prices[i];
				}
			}
		}
		return ans;
	}

	// public static int maxProfit_1(int[] prices) { //better O(n)
  //
	// 	int diff[]=new int[prices.length];
  //
	// 	int ans=0;
  //
	// 	for(int i=1;i<prices.length;i++) {
	// 		diff[i]=prices[i]-prices[i-1];
	// 	}
  //
	// 	int sum=0;
	// 	for(int i=0;i<diff.length;i++) {
  //
	// 		sum=sum+diff[i];
	// 		if(sum<0) {
	// 			sum=0;
	// 		}
	// 		if(sum>ans)
	// 			ans=sum;
	// 	}
	// 	return ans;
	// }

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] input= {7,6,4,3,1};
		System.out.println(maxProfit_1(input));
	}

}
