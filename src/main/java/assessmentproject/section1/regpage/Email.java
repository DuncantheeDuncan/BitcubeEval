package assessmentproject.section1.regpage;

import java.util.HashSet;

public class Email {

  public static HashSet<String> emailHashSet = new HashSet<>();

   public String validation(String validate) {
        boolean isTrue = validate.contains("@");
        if (isTrue) {
            String[] lengthMustBeTwo = validate.split("@");

            if (lengthMustBeTwo.length > 2)
                return "Error: email cannot contain two or more of '@' in your username";

            if (lengthMustBeTwo[0].length() < 3)
                return "Error: email is too short";

        } else {
            return "Error: email must have '@'";
        }
        return validate;
    }


    public String makeEmailUnique(String makeUnique) {

        // since phumlani@gmail.com  and phumlani@yahoo.com
        // are both unique they will be both added.

        if (!emailHashSet.contains(makeUnique.toLowerCase())) {
            if (!makeUnique.contains("Error: email")) {
                emailHashSet.add(makeUnique.toLowerCase());
                return makeUnique.toLowerCase();
            }
        }
//        else {
//            try {
//               throw  new Exception("email already exists " + makeUnique);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return "email already exists " + makeUnique;
//        }
        return makeUnique.toLowerCase();
    }
    public int count() {
        return emailHashSet.size();
    }
}
