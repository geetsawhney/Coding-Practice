//Leetcode 799
public class ChampagneTower {

	public static double champagneTower(int poured, int query_row, int query_glass) {
		return champagneTower_helper(poured, query_row+1, query_glass+1);
	}
	public static double champagneTower_helper(int poured, int query_row, int query_glass) {
		int total_glasses=query_row*(query_row+1)/2;
		double glasses[]=new double[total_glasses+1];
		int index=1;
		glasses[index]=poured;
		double remaining;
		double ans;
		for(int row=1;row<=query_row;row++) {
			for(int col=1;col<=row;col++) {
				remaining=glasses[index];
				glasses[index]= remaining>=1.0?1.0:remaining;
				remaining=remaining>=1?remaining-1:0.0;
				if(index+row>total_glasses)
				{
					ans=glasses[((query_row*(query_row-1))/2)+query_glass];
					return ans>1.0?1.0:ans;
				}
				glasses[index+row]+=remaining/2;
				glasses[index+row+1]+=remaining/2;
				index++;
			}
		}
		ans=glasses[((query_row*(query_row-1))/2)+query_glass];
		return ans>1.0?1.0:ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(champagneTower(6, 3, 1));

	}

}
