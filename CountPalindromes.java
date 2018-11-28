
public class CountPalindromes {

	static int countPS(String S)
	{
        int len = S.length();
        int ans = 0;
        for (int mid = 0; mid <= 2*len-1; mid++) {
            int left = mid / 2;
            int right = left + mid % 2;
            while (left >= 0 && right < len && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
	}

	public static void main(String[] args) {

		System.out.println(countPS("hellolle"));

	}

}
