package assessmentproject.web;

import assessmentproject.User;
import assessmentproject.section2.loginpage.LogIn;


import java.util.*;

public class WebProcessor {


    public List<String> firstNamesList = new ArrayList<>();
    public List<String> secondNamesList = new ArrayList<>();
    public List<String> surNamesList = new ArrayList<>();
    public List<String> emailsList = new ArrayList<>();
    public List<String> passwordsList = new ArrayList<>();
    public List<String> passwordsListSalted = new ArrayList<>();
    public List<String> counter = new ArrayList<>();
    public HashSet<String> emailChecker = new HashSet<>();
    public static Map<String, User> myUserTable = new Hashtable<>();
    public static Map<String, LogIn> myPasswords = new Hashtable<>();
}
