package assessment;
//
public class ReverseAlgebraicExpression {

//	public static String reverse(String expression) {
//
//		StringBuilder sb=new StringBuilder("");
//		String[] nums= expression.split("[-+*/]");
////		String[] op=expression.split("[0-9]+[\\.]{0,1}[0-9]+");
//		char c;
//		int index=nums.length-1;
//		for(int i=0;i<expression.length();i++) {
//			c=expression.charAt(i);
//			if(c=='+'||c=='-'||c=='*'||c=='/') {
//				sb.append(nums[index]);
//				sb.append(c);
//				index--;
//			}
//		}
//		sb.append(nums[index]);
//
//		return sb.toString();
//
//	}


	public static String reverse(String expression) {

//		StringBuilder sb=new StringBuilder("");
		String ans="";
		char c;
		int start=0;
		boolean skip=false;

		for(int i=0;i<expression.length();i++) {
			c=expression.charAt(i);
			if((c=='+'||c=='-'||c=='*'||c=='/') && i!=0 && !skip) {

				ans=c+expression.substring(start, i)+ans;
				c=expression.charAt(i+1);
				if(c=='+'||c=='-'||c=='*'||c=='/')
				{
					skip=!skip;
				}
				start=i+1;
				continue;
			}
			if(skip)
				skip=!skip;

		}
		ans=expression.substring(start,expression.length() )+ans;
		return ans;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("-11*2+9-23"));
	}

}
