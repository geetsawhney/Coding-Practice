package maps;

import java.util.HashMap;

public class NumberOfSubstringOfSWhichAreAnagramsOfT {

	public static int numberOfAnagramSubstrings(String s,String t)
	{
		HashMap<Character, Integer>map=new HashMap<>();
		int total=0;
		int countRemaining=0;
		
		
		for(int i=0;i<t.length();i++)
		{
			char current=t.charAt(i);
			
			if(map.get(current)==null)
			{
				map.put(current, 1);
				countRemaining++;
			}
			else
			{
				int count=map.get(current);
				map.put(current, count+1);
			}
		}
		
		for(int i=0;i<t.length();i++)
		{
			char current=s.charAt(i);
			
			if(map.get(current)!=null)
			{
				int count=map.get(current);
				if(count==1)
					countRemaining--;
				map.put(current, count-1);
			}
		}
		
		if(countRemaining==0)
			total++;

		int j=0;
		for(int i=t.length();i<s.length();i++)
		{
			if(map.get(s.charAt(j))!=null)
			{
				int count=map.get(s.charAt(j));
				if(count==0)
					countRemaining++;
				map.put(s.charAt(j), count+1);
			}
			j++;
			char current=s.charAt(i);
			
			if(map.get(current)!=null)
			{
				int count=map.get(current);
				if(count==1)
					countRemaining--;
				map.put(current, count-1);
			}
			
			if(countRemaining==0)
				total++;
		}
		return total;
	}

	public static void main(String[] args) {

		System.out.println(numberOfAnagramSubstrings("stesttest", "t"));
	}
}
