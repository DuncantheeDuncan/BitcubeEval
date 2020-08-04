package assessmentproject.section2.loginpage;


public class LogIn {

    public String email;
    public String providedPassword;
    public String securedPassword;
    public String salt;

    public LogIn(
            String email,
            String providedPassword,
            String securedPassword,
            String salt
    ) {

        this.email = email;
        this.providedPassword = providedPassword;
        this.securedPassword = securedPassword;
        this.salt = salt;
    }
}
