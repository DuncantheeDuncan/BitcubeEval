package assessmentproject.section1.regpage;

import java.util.HashSet;

public class Email {

    HashSet<String> emailHashSet = new HashSet<>();

    String validation(String validate) {
        boolean isTrue = validate.contains("@");
        if (isTrue) {
            String[] lengthMustBeTwo = validate.split("@");
            if (lengthMustBeTwo.length > 2)
                return "email cannot contain two or more of '@' in your username";
            if (lengthMustBeTwo[0].length() < 3)
                return "email is too short";
        } else {
            return "email must have '@'";
        }
        return validate;
    }


    String makeEmailUnique(String makeUnique) {

        // since phumlani@gmail.com  and phumlani@yahoo.com
        // are both unique they will be both added.

        if (!emailHashSet.contains(makeUnique.toLowerCase())) {
            if (!makeUnique.contains("email")) {
                emailHashSet.add(makeUnique.toLowerCase());
                return makeUnique.toLowerCase();
            }
        } else {
            return "email already exists " + makeUnique;
        }
        return makeUnique;
    }

    public int count() {
        return emailHashSet.size();
    }
}
