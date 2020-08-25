package assessmentproject.routes;

import assessmentproject.User;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.web.WebProcessor.myUserTable;
import static spark.Spark.get;
import static spark.Spark.post;

public class LogoutHandlebars {


    public static void logout(Map model) {

        get("/logout", (req, res) -> {

            if (req.session().attribute("user email") == null)
                res.redirect("/login");


            for (Map.Entry<String, User> entry1 : myUserTable.entrySet()) {
                model.remove("regSuccess");
                String key1 = entry1.getKey();
//                User user1 = entry1.getValue();

                if (req.session().attribute("user email").equals(key1)) {

                    Session session = req.session();
                    session.attribute("user email");
                    session.invalidate();
                    session = req.session(false);

                    break;
                }

            }

            res.redirect("/login");

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "logout.handlebars"));
        });

        post("/logout", (req, res) -> {
            res.redirect("/");
            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "logout.handlebars"));
        });
    }
}
