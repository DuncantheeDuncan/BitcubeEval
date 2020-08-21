package assessmentproject.section5.friends;

import assessmentproject.User;
import assessmentproject.section3.profile.Friends;
import assessmentproject.web.WebProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendAcceptDecline implements FriendRequests, ReturnUserFriends, SendFriendRequest {


    @Override
    public String addFriend(String accept) {

        if ("add".equals(accept)) {
            return accept;
        } else {
            return "ignore";
        }
    }


    @Override
    public User checkFriendRequests(String userEmailId, String acceptOrDecline) {

        Map<String, User> acceptedFriendRequest = new HashMap<>();
        List<String> listOfFriends = new ArrayList<>();

        if (!WebProcessor.poolOfFriedRequests.isEmpty()) {

            for (Map.Entry<String, List<String>> x : WebProcessor.poolOfFriedRequests.entrySet()) {

                for (String xx : x.getValue()) {

                    if (xx.equals(userEmailId)) {

                        if ("add".equals(addFriend(acceptOrDecline))) {

                            if (WebProcessor.myUserTable.get(x.getKey()) != null) {

                                User getUser = WebProcessor.myUserTable.get(x.getKey());

                                User friend = new Friends(getUser.email, getUser.firstName, getUser.secondName, getUser.surName);

                                acceptedFriendRequest.put(userEmailId, friend);

                                listOfFriends.add(x.getKey());
                            }
                        } // todo: 2020/08/20 I will take care of my else in with js and css if invitation is declined !!
                    }

                }

            }

        }

        // TODO: 2020/08/20 all friends will be mapped together, all i had to do is populate them..
        WebProcessor.friends.put(userEmailId, listOfFriends);

        return acceptedFriendRequest.get(userEmailId);
    }


    @Override
    public Map<String, List<String>> returnFriends(String myEmailId) {
        Map<String, List<String>> mappingFriends = new HashMap<>();
        List<String> mappingList = new ArrayList<>();
        Map<String, List<String>> getOnlyMyFriends = new HashMap<>();

        if (!WebProcessor.friends.get(myEmailId).isEmpty()) {

            for (Map.Entry<String, List<String>> x : WebProcessor.friends.entrySet()) {

                if (x.getKey().equals(myEmailId)) {

                    getOnlyMyFriends.put(x.getKey(), x.getValue());

                    for (String xx : x.getValue()) {

                        if (!mappingList.contains(x.getKey()))
                            mappingList.add(x.getKey());


                        mappingFriends.put(xx, mappingList);

                    }

                }

            }
        }


        WebProcessor.friends.putAll(mappingFriends);

//        System.out.println("my friends only " + getOnlyMyFriends);
//        System.out.println("mapped friends " + mappingFriends);
//        System.out.println("friends after " + WebProcessor.friends);
//
        return getOnlyMyFriends;
    }


    @Override
    public Map<String, List<String>> requestFriendship(String accountOwner, List<String> receivers) {

        List<String> otherUsers = new ArrayList<>(receivers);

        WebProcessor.poolOfFriedRequests.put(accountOwner, otherUsers);

        return SendFriendRequest.clonePool(WebProcessor.poolOfFriedRequests);

    }
}
