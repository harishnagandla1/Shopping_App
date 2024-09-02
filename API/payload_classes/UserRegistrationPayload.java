public class UserRegistrationPayload {

	public static String getRegistrationPayload(String username, String password, String email) {
		return "{"username":"" + username + "","password":"" + password + "","email":"" + email + ""}";
	}

}