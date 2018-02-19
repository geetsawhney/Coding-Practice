package problems;

public class LongestSubstringUniqueCharacters {
	public int lengthOfLongestSubstring(String s) {
		
		int first=0;
		int last=0;
		int longest_length=0;
		char temp;
		int arr[]=new int[256];
		for(int i=0;i<256;i++){
			arr[i]=-1;
		}
		int lastOccurence;
		for(int i=0;i<s.length();i++){
			temp=s.charAt(i);
			lastOccurence=arr[temp];
			if(lastOccurence<first){
				last=i;
				arr[temp]=i;
			}
			else{
				first=lastOccurence+1;
				last=i;
			}
			
			if(last-first+1>longest_length)
				longest_length=last-first+1;
		}
		
		return longest_length;
		
	}
}
