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

    public User findByUserId(String emailId){

        return myUserTable.get(emailId);
    }

    // TODO: 2020/08/13  if user update the emil, i must check if
    //  the email exist or not.
}
