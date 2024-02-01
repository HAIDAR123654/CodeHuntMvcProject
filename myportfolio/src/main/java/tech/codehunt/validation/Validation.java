package tech.codehunt.validation;

public class Validation {
	
	private String result;
	
	public String validateMessage(String name, String email, String message) {
		
		int namelen = name.length();
		int emaillen = email.length();
		int messagelen = message.length();
		
		if(namelen<2 || namelen>30) {
			result = "invalid name";
		}
		else if(emaillen<10 || emaillen>50) {
			result = "invalid email";
		}
		else if(messagelen<2 || messagelen>1000) {
			result = "invalid message";
		}
		else {
			result = "valid";
		}
		return result;
	}

}
