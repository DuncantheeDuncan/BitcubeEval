package assessmentproject.section1.regpage;

public class EmailProcessor extends Email{

    public String addEmail(String email) {
        if ("".equals(email) || email == null) {
            return "email is required";
        } else {

            String validate = validation(email).toLowerCase();
            String addEmail = makeEmailUnique(validate).toLowerCase();

            if (validate.equals(email.toLowerCase()) && addEmail.equals(email.toLowerCase())) {

                return email;
            } else {
                return !validate.equals(email) ? validate : !addEmail.equals(email) ? addEmail : null;
            }
        }
    }
}
