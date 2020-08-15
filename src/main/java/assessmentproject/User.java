package assessmentproject;

import assessmentproject.section4.profilepage.Crud;

public class User  {
    public String email;
    public String firstName;
    public String secondName;
    public String surName;
    public String password;

    public User(
            String email,
            String firstName,
            String secondName,
            String surName,
            String password
    ) {

        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.password = password;
    }

    public User(
            String email,
            String firstName,
            String secondName,
            String surName
    ) {

        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;

    }
}
