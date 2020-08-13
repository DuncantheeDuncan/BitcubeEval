package assessmentproject.section4.profilepage;

import assessmentproject.User;
import assessmentproject.web.WebProcessor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CrudTests {

    private User expectedMessage;
    private User actualMessage;
    private String firstName;
    private String secondName;
    private String surName;
    private String emailId;
    private String password;


    @DisplayName("should update the users email address")
    @Test
    public void updateUserEmail() {
        Crud crud = new Crud();

        firstName = "Jack";
        secondName = "Joe";
        surName = "Jones";
        emailId = "jj.jones@yahoo.com";

        User user1 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user1);

        // changing email to jackjones@gmail.com
        expectedMessage = crud.update
                (
                        emailId,
                        firstName,
                        secondName,
                        surName,
                        "jackjones@gmail.com"
                );
        actualMessage = user1;
        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());
    }


    @DisplayName("should update the users sur name")
    @Test
    public void updateUsersSurname() {
        Crud crud = new Crud();

        firstName = "Sthembiso";
        secondName = "MuziOmuhle";
        surName = "Muzi";
        emailId = "mthetwasm@xcv.com";

        User user1 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user1);

        expectedMessage = crud.update
                (
                        emailId,
                        firstName,
                        secondName,
                        "Mthethwa",
                        emailId
                );
        actualMessage = user1;

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());

    }


    @DisplayName("should update the users second name")
    @Test
    public void updateUsersSecondName() {
        Crud crud = new Crud();

        firstName = "Damian";
        secondName = "Fabio";
        surName = "Ellies";
        emailId = "damfab@bit.info";

        User user1 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user1);


        expectedMessage = crud.update
                (
                        emailId,
                        firstName,
                        "Jessie",
                        surName,
                        emailId
                );
        actualMessage = user1;

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());


    }


    @DisplayName("should update the users first name")
    @Test
    public void updateUsersFirstName() {
        Crud crud = new Crud();

        firstName = "Duncan";
        secondName = "Mthobisi";
        surName = "Mvelase";
        emailId = "mve@mxo.capetown";

        User user1 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user1);

        expectedMessage = crud.update
                (
                        emailId,
                        "Phumlani",
                        secondName,
                        surName,
                        emailId
                );
        actualMessage = user1;

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());
    }
}
