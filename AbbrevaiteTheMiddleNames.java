
public class AbbrevaiteTheMiddleNames {

	
	public static String answer(String name){
		
		
		String parts[]=name.split("\\s");
		
		if(parts.length<=2)
			return name;
		
		for(int i=1;i<parts.length-1;i++){
			parts[i]=" "+Character.toUpperCase(parts[i].charAt(0)) + ". ";
		}
		
		String answer="";
		for(String x:parts)
			answer+=x;
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(answer("Walter Heisenberg White"));
		
	}

}
