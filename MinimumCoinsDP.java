import java.util.ArrayList;
import java.util.List;

public class MinimumCoinsDP {


	public static int minCoins_TopDownDP(int coins[], int value) {
		// TODO Auto-generated method stub

		int dp[]=new int[value+1];
		
		for(int i=0;i<dp.length;i++){
			dp[i]=-1;
		}
		
		return minCoins_TopDownDP(coins, value, dp);

	}

	private static int minCoins_TopDownDP(int coins[], int value, int[] dp) {
		
		if(value==0)
			return 0;
		
		if(dp[value]!=-1)
			return dp[value];

		List<Integer> numberOfCoins=new ArrayList<>();
		for(int i=coins.length-1;i>=0;i--){
			if(value>=coins[i]){
				numberOfCoins.add(minCoins_TopDownDP(coins, value-coins[i], dp));
			}
		}

		int min=Integer.MAX_VALUE;
		int j = -1;
		for(int i=0;i<numberOfCoins.size();i++){
			if(min>numberOfCoins.get(i) && numberOfCoins.get(i)!=-1){
				min = numberOfCoins.get(i);
				j=i;
			}
		}
		
		if(min!=Integer.MAX_VALUE)
			dp[value]= 1+min;
		
		return dp[value];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins={3,5,10,50,100};
		System.out.println(minCoins_TopDownDP(coins, 567));

	}

}
