import assessmentproject.section1.regpage.Password;

public class VerfyPassword {

    public void verify(String v){

        String securedPassword = "hQAXUwVX+kmD5SPYjKn3gQ==";
        String salt = "ZlY6nEwdhS62RHV1NIq1";

        boolean passMatch = Password.verifyUserPassword(v,securedPassword,salt);

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
