import java.util.HashMap;

public class DuplicateEmailAddress {

	public static int getDuplicateGroups(String[] emails) {
		if(emails.length<2)
			return emails.length;

		HashMap<String, Integer> groupCount=new HashMap<>();
		String local;
		String domain;
		String cleaned;

		for(String email: emails) {
			local=getLocal(email);
			domain=getDomain(email);
			cleaned=local+"@"+domain;

			if(!groupCount.containsKey(cleaned)) {
				groupCount.put(cleaned, 1);
			}else {
				groupCount.put(cleaned, groupCount.get(cleaned)+1);
			}
		}
		int ans=0;
		for(Integer num : groupCount.values()) {
			if(num>1)
				ans++;
		}

		return ans;
	}

	public static String getLocal(String email) {
		String local=email.substring(0,email.indexOf('@'));
		local=local.replace(".", "");
		int index=local.indexOf('+');
		System.out.println(local);
		if(index==-1)
			return local;
		System.out.println(local.substring(0, index));
		return local.substring(0, index);
	}

	public static String getDomain(String email) {
		String domain = email.substring(email.indexOf('@')+1,email.length());

		return domain;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String emails[]= {"a.b@example.com", "x+++++++++++@example.com", "x@example.com", "ab+1@example.com", "y@example.com", "y@example.com", "y@example.com"};

		System.out.println(getDuplicateGroups(emails));

	}

}
