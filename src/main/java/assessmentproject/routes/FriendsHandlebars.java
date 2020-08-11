package assessmentproject.routes;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.get;


public class FriendsHandlebars {


    public static void friendsPage(Map model){

        get("/friends", (req, res) -> {

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "friends.handlebars"));
        });

    }
}
