package assessmentproject.section5.friends;

import assessmentproject.User;
import assessmentproject.web.WebProcessor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisteredUsersTest {

    private String expectedMessage;
    private String actualMessage;
    private String firstName;
    private String secondName;
    private String surName;
    private String emailId;


    @DisplayName("should return all registered users")
    @Test
    public void returnRegisteredUsers() {

        WebProcessor wp = new WebProcessor();

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


        firstName = "Jacob";
        secondName = "hamir";
        surName = "Ellies";
        emailId = "jh@hamir.ifo";

        User user2 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user2);


        new RegisteredUsers().listOfUsers();

        expectedMessage = "[Jacob, Damian]";
        actualMessage = String.valueOf(RegisteredUsers.getFirstNames());

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

    }
}
