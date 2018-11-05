import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OptimalAccountBalance {

	public static int getMinimumTransactions(List<List<Integer>> transactions) {

		Map<Integer, Integer> balanceMap = getBalanceMap(transactions);
		removeZeroValueMap(balanceMap);
		List<Integer> balanceList = new LinkedList<>(balanceMap.values());
		return getMinimumTransactionsHelper(balanceList);

	}

	private static int getMinimumTransactionsHelper(List<Integer> balanceList) {
		if(balanceList.size() < 1)
			return 0;
		int min=-getMin(balanceList);
		int max=getMax(balanceList);
		balanceList.remove((Object)(-min));
		balanceList.remove((Object)max);

		if(max!=min)
			balanceList.add(max-min);

		return 1+getMinimumTransactionsHelper(balanceList);
	}

	private static int getMax(List<Integer> balanceList) {
		// TODO Auto-generated method stub
		return Collections.max(balanceList);
	}

	private static int getMin(List<Integer> balanceList) {
		// TODO Auto-generated method stub
		return Collections.min(balanceList);
	}

	private static void removeZeroValueMap(Map<Integer, Integer> balance) {
		List<Integer> remove=new ArrayList<>();
		for(Integer key: balance.keySet()) {
			if(balance.get(key) == 0)
				remove.add(key);
		}
		for(Integer key : remove)
			balance.remove(key);
	}

	public static Map<Integer, Integer> getBalanceMap(List<List<Integer>> transactions){
		Map<Integer, Integer> balance = new TreeMap<>();

		for(List<Integer> transaction : transactions) {
			if(!balance.containsKey(transaction.get(0)))
				balance.put(transaction.get(0), 0);

			if(!balance.containsKey(transaction.get(1)))
				balance.put(transaction.get(1), 0);

			balance.put(transaction.get(0), balance.get(transaction.get(0))-transaction.get(2));
			balance.put(transaction.get(1), balance.get(transaction.get(1))+transaction.get(2));
		}
		return balance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> input =new ArrayList<>();
		input.add(new ArrayList<>());
		input.get(0).add(0);
		input.get(0).add(1);
		input.get(0).add(10);

		input.add(new ArrayList<>());
		input.get(1).add(1);
		input.get(1).add(0);
		input.get(1).add(1);
		input.add(new ArrayList<>());
		input.get(2).add(1);
		input.get(2).add(2);
		input.get(2).add(5);
		input.add(new ArrayList<>());
		input.get(3).add(2);
		input.get(3).add(0);
		input.get(3).add(5);

		System.out.println(getMinimumTransactions(input));
	}

}
