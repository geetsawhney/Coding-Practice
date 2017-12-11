public class ReverseWordsInSentence {
	 
	public static String reverseWords(String str){
	     String[] words=str.split(" ");
	     StringBuilder sb=new StringBuilder("");
	     for(int i=words.length-1;i>=0;i--){
	    	 sb.append(words[i]+" ");
	     }
	     
	     return sb.toString();
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ReverseWordsInSentence.reverseWords("I like eating"));
	}

}
