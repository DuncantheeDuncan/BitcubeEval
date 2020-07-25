package assessmentproject.section1.regpage;

public class PasswordProcessor extends Password{

    public String password(String password) {

        boolean hasError = Password.checkMinimumReq(password);

        if (!hasError) {

            String salt = Password.getSalt(20);
            String SecurePassword = Password.generateSecurePassword(password, salt);
            System.out.println();
            System.out.println("My secure password = " + SecurePassword);
            System.out.println("Salt value = " + salt);
            return SecurePassword;
        }
        throw new AssertionError("Error double check your password please");
    }
}
