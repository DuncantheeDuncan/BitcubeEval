package assessmentproject.section1.regpage.web;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Web {

    public static void main(String[] args) {

        staticFiles.location("/public");
        port(8080);

        get("/", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

//            rendering

            model.put("hello", "HELLO WORLD");



            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "index.handlebars"));
        });
    }
    }
