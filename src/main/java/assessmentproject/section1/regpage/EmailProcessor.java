package assessmentproject.section1.regpage;

import java.util.HashMap;
import java.util.Map;

public class EmailProcessor {

    Email em = new Email();
    Map<String, String> emailsMap = new HashMap<>();// TODO !!

    public String addEmail(String email) {
        System.out.println(" email " + em.emailHashSet);
        if ("".equals(email) || email == null) {
            return "email is required";
        } else {

            String validate = em.validation(email).toLowerCase();
            String addEmail = em.makeEmailUnique(validate).toLowerCase();

            if (validate.equals(email.toLowerCase()) && addEmail.equals(email.toLowerCase())) {
                //FIXME  not sure if i must add to thee map here of some
                //TODO delete !!
                return email;
            } else {
                return !validate.equals(email) ? validate : !addEmail.equals(email) ? addEmail : null;
            }
        }
    }
}
