package assessmentproject.routes;

import assessmentproject.User;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.web.WebProcessor.myUserTable;
import static spark.Spark.get;

public class LogoutHandlebars {


    public static void logout(Map model) {

        get("/logout", (req, res) -> {

            model.remove("regSuccess");

            for (Map.Entry<String, User> entry1 : myUserTable.entrySet()) {
                String key1 = entry1.getKey();
//                User user1 = entry1.getValue();

                if (req.session().attribute("user email").equals(key1)) {

                    req.session().removeAttribute("user email");
//                    myUserTable.remove(key1,user1);
                }
            }

            res.redirect("/");
            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "logout.handlebars"));
        });

//        post("/logout", (req, res) -> {
//
//            return new HandlebarsTemplateEngine()
//                    .render(new ModelAndView(model, "logout.handlebars"));
//        });
    }
}
