package assessmentproject.web;

import assessmentproject.User;
import assessmentproject.section2.loginpage.LogIn;

import java.util.*;

public class WebProcessor {


    List<String> firstNamesList = new ArrayList<>();
    List<String> secondNamesList = new ArrayList<>();
    List<String> surNamesList = new ArrayList<>();
    List<String> emailsList = new ArrayList<>();
    List<String> passwordsList = new ArrayList<>();
    List<String> passwordsListSalted = new ArrayList<>();
    List<String> counter = new ArrayList<>();
    HashSet<String> emailChecker = new HashSet<>();
   public static Map<String, User> myUserTable = new Hashtable<>();
   public static Map<String, LogIn> myPasswords = new Hashtable<>();
}
