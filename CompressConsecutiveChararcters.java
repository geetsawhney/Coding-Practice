
public class CompressConsecutiveChararcters {

	
	public static String met(String str) {
		
		if(str.length()==0)
			return str;
		int occ=1;
		
		String s=str.charAt(0)+"";
		
		for(int i=1;i<str.length();i++) {
			
			if(str.charAt(i)==str.charAt(i-1))
				occ++;
			
			else {
				if(occ!=1) {
					s=s+occ;
				}
				
				s+=str.charAt(i);
				occ=1;
			}
		}
		
		if(occ!=1)
			s+=occ;
		return s;
	}
	
	public static void main(String args[]) {
		
		System.out.println(met(""));
	}
}
