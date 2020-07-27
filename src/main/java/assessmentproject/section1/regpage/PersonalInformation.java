package assessmentproject.section1.regpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInformation {

    public String capitaliseFirstLetter(String capitalise) {
        String[] splitting = capitalise.split(" ");
        capitalise = "";

        for (String S : splitting)
            capitalise += " " + S.substring(0, 1).toUpperCase() + S.substring(1).toLowerCase();

        return capitalise.trim();
    }

    public boolean makingSureThereAreNoUnWantedCharacters(String minimum) {

        boolean error = true;
        boolean isNoSpecialCharacter = true;
        boolean minLengthIsSix = false;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");

        char[] check = minimum.toCharArray();

        if (check.length >= 3)
            minLengthIsSix = true;

        for (char C : check) {
            Matcher matcher = pattern.matcher(String.valueOf(C));

            if (!matcher.matches()) {
                isNoSpecialCharacter = false;
            }

            if (isNoSpecialCharacter  && minLengthIsSix)
                error = false;
        }
        return error;
    }


    public String names(String firstName, String surname) {

        boolean isTrueFirstName = makingSureThereAreNoUnWantedCharacters(firstName);
        boolean isTrueSurname = makingSureThereAreNoUnWantedCharacters(surname);

        if (!isTrueFirstName && !isTrueSurname) {
            String _1stName = capitaliseFirstLetter(firstName);
            String familyName = capitaliseFirstLetter(surname);

            return _1stName.concat(" ").concat(familyName);
        } else {
            return "Error";
        }

    }

    public String names(String firstName, String secondName, String surname) {

        boolean isTrueFirstName = makingSureThereAreNoUnWantedCharacters(firstName);
        boolean isTrueSurname = makingSureThereAreNoUnWantedCharacters(surname);
        boolean isTrueSecondName = makingSureThereAreNoUnWantedCharacters(secondName);

        if (!isTrueFirstName && !isTrueSurname && !isTrueSecondName) {

            String _1stName = capitaliseFirstLetter(firstName);
            String familyName = capitaliseFirstLetter(surname);
            String _2ndName = capitaliseFirstLetter(secondName);

            return _1stName.concat(" ").concat(_2ndName + " ").concat(familyName);
        } else {
            return "Error";
        }
    }
}
