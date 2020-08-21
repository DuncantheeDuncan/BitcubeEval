package assessmentproject.section5.friends;

import assessmentproject.User;

public interface FriendRequests {

    String addFriend(String accept);

    User checkFriendRequests(String userEmailId, String acceptOrDecline);
}
