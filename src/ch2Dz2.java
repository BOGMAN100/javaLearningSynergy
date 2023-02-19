
class LoginValidator {
    private static final int MAX_LOGIN_LENGTH = 20;

    public static boolean isLoginValid(String login) {
        try {
            validateLogin(login);
            return true;
        } catch (LoginValidationException e) {
            return false;
        }
    }

    private static void validateLogin(String login) throws LoginValidationException {
        if (login.length() > MAX_LOGIN_LENGTH) {
            throw new LoginValidationException("Login is too long");
        }

        if (!login.matches("[A-Za-z0-9_]+")) {
            throw new LoginValidationException("Login contains invalid characters");
        }

        if (!login.matches(".*[a-z]+.*")) {
            throw new LoginValidationException("Login must contain at least one lowercase letter");
        }

        if (!login.matches(".*[A-Z]+.*")) {
            throw new LoginValidationException("Login must contain at least one uppercase letter");
        }

        if (!login.matches(".*\\d+.*")) {
            throw new LoginValidationException("Login must contain at least one digit");
        }

        if (!login.matches(".*_+.*")) {
            throw new LoginValidationException("Login must contain at least one underscore");
        }
    }

    public static class LoginValidationException extends Exception {
        public LoginValidationException(String message) {
            super(message);
        }
    }
}
public class ch2Dz2 {
    public static void main(String[] args) {
        String[] logins = {"user123", "User_1", "MY_LOGIN"};
        for (String login : logins) {
            if (LoginValidator.isLoginValid(login)) {
                System.out.println("Login " + login + " is valid");
            } else {
                System.out.println("Login " + login + " is invalid");
            }
        }
    }
}