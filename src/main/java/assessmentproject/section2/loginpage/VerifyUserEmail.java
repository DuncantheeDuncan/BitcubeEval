package assessmentproject.section2.loginpage;

import assessmentproject.section1.regpage.EmailProcessor;

public class VerifyUserEmail extends EmailProcessor {

    public String verifyUserEmail(String email) {

        if (validation(email).equals(email)) {

            if (emailExist(email)) {
                for (String S : emailHashSet) {

                    if (S.equals(email))
                        return S;
                }

            } else {
                return String.valueOf(emailExist(email));
            }

            return "";
        } else {
            return validation(email);
        }
    }


    boolean emailExist(String emailCheck) {

        return emailHashSet.contains(emailCheck);
    }


}
