package assessmentproject.section4.profilepage;

import assessmentproject.User;

import static assessmentproject.web.WebProcessor.myUserTable;

public class Crud {

    public User update(String emailId, String firstName, String secondName, String surName, String email) {

        User user = myUserTable.get(emailId);

        if (email != null)
            user.email = email;

        if (surName != null)
            user.surName = surName;

        if (secondName != null)
            user.secondName = secondName;

        if (firstName != null)
            user.firstName = firstName;

        return user;
    }


}
