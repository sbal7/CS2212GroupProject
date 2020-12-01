import java.util.HashMap;

public class IDandPass {
	
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	IDandPass(){
		
		loginInfo.put("sunny","cs2212");
		loginInfo.put("matt","123");
		loginInfo.put("bro","abc123");
	}
	
	public HashMap getLoginInfo(){
		return loginInfo;
	}
}
