package assessmentproject.section1.regpage;


public class PersonalInformation {

    public String capitaliseFirstLetter(String capitalise) {
        String[] splitting = capitalise.split(" ");
        capitalise = "";

        for (String S : splitting)
            capitalise += " " + S.substring(0, 1).toUpperCase() + S.substring(1).toLowerCase();

        return capitalise.trim();
    }


    public String names(String firstName, String surname) {

        if (!firstName.isEmpty() & !surname.isEmpty()) {
            String _1stName = capitaliseFirstLetter(firstName);
            String familyName = capitaliseFirstLetter(surname);

            return _1stName.concat(" ").concat(familyName);
        } else {
            return "Error";
        }
    }


    public String names(String firstName, String secondName, String surname) {

        if (!firstName.isEmpty() & !surname.isEmpty() & !secondName.isEmpty()) {

            String _1stName = capitaliseFirstLetter(firstName);
            String familyName = capitaliseFirstLetter(surname);
            String _2ndName = capitaliseFirstLetter(secondName);

            return _1stName.concat(" ").concat(_2ndName).concat(" ").concat(familyName);
        } else {
            return "Error";
        }
    }
}
