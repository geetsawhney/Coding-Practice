
public class StockBuySell3 {

	public static int maxProfit(int prices[]) {

		return maxProfit(prices,0,0,0,"",0);
	}

	private static int maxProfit(int[] prices, int i, int bank, int transaction,String step,int prof) {
		// TODO Auto-generated method stub

		if(transaction==4 || i>prices.length-1)
		{
			System.out.println(step+"  "+ prof);
			return 0;
		}
//		System.out.println(i+" "+bank+" "+transaction+" "+prices[i]);

		int buy=0,sell=0;

		if(bank==0 && transaction%2==0) {
			buy=maxProfit(prices, i+1, prices[i], transaction+1,step+"B",prof);

		}else if(transaction%2==1){
			if(prices[i]>bank)
				sell=prices[i]-bank+maxProfit(prices, i+1, 0, transaction+1,step+"S", prof+prices[i]-bank);
		}

		return Math.max(buy,Math.max(maxProfit(prices, i+1, bank, transaction,step+"N",prof), sell));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {1,2,3,4}));
	}

}
