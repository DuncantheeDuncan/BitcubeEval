package assessmentproject.web;


import assessmentproject.routes.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Web extends WebProcessor {

    public static void main(String[] args) {


        staticFiles.location("/public");
        port(8080);
        Map<String, Object> model = new HashMap<>();


        HomeHandlebars.landingPage(model);

        RegistrationHandlebars.registrationPage(model);

        LoginHandlebars.loginPage(model);

        ProfileHandlebars.profilePage(model);

        FriendsHandlebars.friendsPage(model);

        RegisteredHandlebars.registeredPage(model); // FIXME: 2020/08/13 the page is not redirecting if second name input is not empty

        LogoutHandlebars.logout(model);

    }
}
