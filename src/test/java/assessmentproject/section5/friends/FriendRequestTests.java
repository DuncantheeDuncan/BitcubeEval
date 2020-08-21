package assessmentproject.section5.friends;

import assessmentproject.User;
import assessmentproject.web.WebProcessor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FriendRequestTests {


    private User expectedMessage;
    private User actualMessage;
    private String firstName;
    private String secondName;
    private String surName;
    private String emailId;
    private String sessionId;
    private String providedPassword;
    private String securedPassword;
    private String salt;


    @DisplayName("should send a friend request and the other user must  accept and increment number of friends")
    @Test
    public void sendingAndAcceptingFriendRequest() {

//        first lets get a users registered
        firstName = "Jack";
        secondName = "Joe";
        surName = "Jones";
        emailId = "jjjones@yahoo.com";

        User user1 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user1);

        actualMessage = user1;
        expectedMessage = WebProcessor.myUserTable.get(emailId);

        assertEquals(expectedMessage, actualMessage);


        firstName = "Phumlani";
        secondName = "Philani";
        surName = "drinkwater";
        emailId = "ppwater@email.com";

        User user2 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user2);

        actualMessage = user2;
        expectedMessage = WebProcessor.myUserTable.get(emailId);

        assertEquals(expectedMessage, actualMessage);

        firstName = "Mark";
        secondName = "uYabonga";
        surName = "Ndlovu";
        emailId = "yabonga@cue.cp";

        User user3 = new User
                (
                        emailId,
                        firstName,
                        secondName,
                        surName
                );

        WebProcessor.myUserTable.put(emailId, user3);

        actualMessage = user3;
        expectedMessage = WebProcessor.myUserTable.get(emailId);

        assertEquals(expectedMessage, actualMessage);

// user 1 is sending a friend requests to two people

        SendFriendRequest sendFriendRequest = new SendAcceptDecline();

        List<String> sendTo;
        sendTo = new ArrayList<>();

        sendTo.add("ppwater@email.com");
        sendTo.add("mve@email");

        Map<String, List<String>> actualMessage;
        actualMessage = sendFriendRequest.requestFriendship("jjjones@yahoo.com", sendTo);
        String expectedMessage = "{jjjones@yahoo.com=[ppwater@email.com, mve@email]}";

        assertEquals(expectedMessage, actualMessage.toString());


// user3 is also sending a friend request

        sendTo = new ArrayList<>();
        sendTo.add("ppwater@email.com");


        actualMessage = sendFriendRequest.requestFriendship("yabonga@cue.cp", sendTo);
        expectedMessage = "{jjjones@yahoo.com=[ppwater@email.com, mve@email], yabonga@cue.cp=[ppwater@email.com]}";
        assertEquals(expectedMessage, actualMessage.toString());

        // user2  and mve@email are checking for friend requests

        FriendRequests friendRequests = new SendAcceptDecline();

        friendRequests.checkFriendRequests("ppwater@email.com", "add");
        friendRequests.checkFriendRequests("mve@email", "add");


        // user 2 & mve@email accepted the invite, now user1={jjjones@yahoo.com} should have two friends

        ReturnUserFriends returnUserFriends1 = new SendAcceptDecline();
        returnUserFriends1.returnFriends("ppwater@email.com");

        // TODO: 2020/08/21  do a proper testing!!

// TODO: 2020/08/21 Last stop assertions
    }

}
