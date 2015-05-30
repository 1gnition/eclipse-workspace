package org.orip;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
	
	private Map<String, String> logins;
	
	public LoginService() {
		logins = new HashMap<String, String>();
		logins.put("orip", "1234");
		logins.put("johnd", "abcd");
		logins.put("janed", "qwer");
	}
	
	public boolean authenticate(String username, String password) {
		String pwd = logins.get(username);
		if (pwd != null) {
			return pwd.equals(password);
		} else {
			return false;
		}
	}
}
