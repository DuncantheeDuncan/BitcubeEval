package assessmentproject.section5.friends;

import assessmentproject.User;
import assessmentproject.web.WebProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegisteredUsers {

    private static List<String> firstNames = new ArrayList<>();
    private static List<String> secondNames = new ArrayList<>();
    private static List<String> surNames = new ArrayList<>();
    private static List<String> emails = new ArrayList<>();

    // TODO: 2020/08/17  get all users that are registered
    //   when displaying make sure the current user does not see his/her name on that list


    Iterator<Map.Entry<String, User>> iterator = WebProcessor.myUserTable.entrySet().iterator();
    Map.Entry<String, User> entry = null;
    public void listOfUsers() {

        while (iterator.hasNext()) {
            entry = iterator.next();

            setEmails(entry.getValue().email);
            setFirstNames(entry.getValue().firstName);
            setSecondNames(entry.getValue().secondName);
            setSurNames(entry.getValue().surName);

        }
    }


    public void setSecondNames(String secondNames) {
        if (!secondNames.isEmpty()) {
            RegisteredUsers.secondNames.add(secondNames);
        }

    }

    public void setFirstNames(String firstNames) {
        if (!firstNames.isEmpty()) {
            RegisteredUsers.firstNames.add(firstNames);
        }
    }

    public void setSurNames(String surNames) {
        if (!surNames.isEmpty()) {
            RegisteredUsers.surNames.add(surNames);
        }
    }

    public void setEmails(String emails) {
        if (!emails.isEmpty()) {
            RegisteredUsers.emails.add(emails);

        }
    }


    public static List<String> getFirstNames() {
        return firstNames;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getSecondNames() {
        return secondNames;
    }

    public List<String> getSurNames() {
        return surNames;
    }

}
