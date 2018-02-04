import java.util.ArrayList;
import java.util.List;

public class MinimumCoins {

	public static int minCoins_Recusrsion(int[] coins, int val){

		if(val<=0)
			return 0;
		List<Integer> numberOfCoins=new ArrayList<>();

		for(int i=0;i<coins.length;i++){
			if(val-coins[i]>=0)
				numberOfCoins.add(minCoins_Recusrsion(coins, val-coins[i]));
		}

		int min=Integer.MAX_VALUE;

		for(int i=0;i<numberOfCoins.size();i++){
			if(min>numberOfCoins.get(i) && numberOfCoins.get(i)!=-1)
				min = numberOfCoins.get(i);
		}
		if(min!=Integer.MAX_VALUE)
			return 1+min;
		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins={3,5,10,50,100};
		System.out.println(minCoins_Recusrsion(coins, 567));

	}

}
