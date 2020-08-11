package assessmentproject.routes;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class RegisteredHandlebars {

    public static void registeredPage(Map model){

        get("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));

        post("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));
    }
}
