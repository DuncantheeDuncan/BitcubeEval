

import static assessmentproject.section1.regpage.Password.generateSecurePassword;

public class VerfyPassword {
    static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }
    void verify(String v){

        String securedPassword = "hQAXUwVX+kmD5SPYjKn3gQ==";
        String salt = "ZlY6nEwdhS62RHV1NIq1";

        boolean isPassMatch = verifyUserPassword(v,securedPassword,salt);

        if (isPassMatch){
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
