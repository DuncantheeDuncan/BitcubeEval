package assessmentproject.web;

import assessmentproject.routes.ProfileHandlebars;
import assessmentproject.routes.HomeHandlebars;
import assessmentproject.routes.LoginHandlebars;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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


        get("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));

        post("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));
    }
}
