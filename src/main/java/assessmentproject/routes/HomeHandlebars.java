package assessmentproject.routes;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HomeHandlebars {

    public static void landingPage(Map model) {

        get("/", (req, res) -> {


            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "index.handlebars"));
        });


    }
}
