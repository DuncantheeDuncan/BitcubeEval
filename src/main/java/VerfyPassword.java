import assessmentproject.section1.regpage.Password;

import static assessmentproject.section1.regpage.Password.generateSecurePassword;

public class VerfyPassword {
    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }
    public void verify(String v){

        String securedPassword = "hQAXUwVX+kmD5SPYjKn3gQ==";
        String salt = "ZlY6nEwdhS62RHV1NIq1";

        boolean passMatch = verifyUserPassword(v,securedPassword,salt);

        if (passMatch){
            System.out.println("provided pass : "+ v+" is correct");
        }else {
            System.out.println("provided pass is incorrect");
        }
    }
    public static void main(String[] args) {
        VerfyPassword verfyPassword = new VerfyPassword();

        verfyPassword.verify("JacksonMabso%45");

    }
}
