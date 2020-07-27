package assessmentproject.section1.regpage.web;

import assessmentproject.section1.regpage.PersonalInformation;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Web extends WebProcessor {

    public static void main(String[] args) {

        WebProcessor wbp = new WebProcessor();
        PersonalInformation ps = new PersonalInformation();

        staticFiles.location("/public");
        port(8080);

        Map<String, Object> model = new HashMap<>();//FIXME results might differ since the map is outside


        get("/", (req, res) -> {

            int count = 0;
            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String surName = req.queryParams("surName");

            if (!firstName.isEmpty() && !secondName.isEmpty() && !surName.isEmpty()) {
                count++;
                String names = ps.names(firstName, secondName, surName);

                if (names.equals("Error"))
                    wbp.error.put("error "+count, "names cannot contain special characters and be less tha 3 letters");

                String[] splitNames = names.split(" ");

                wbp.firstName.put("id " + count, splitNames[0]);
                wbp.secondName.put("id " + count, splitNames[1]);
                wbp.surName.put("id " + count, splitNames[2]);

            } else if (secondName.isEmpty()) {
                count++;
                String names = ps.names(firstName, surName);
                String[] splitNames = names.split(" ");

                if (names.equals("Error"))
                    wbp.error.put("error "+count, "names cannot contain special characters and be less tha 3 letters");

                wbp.firstName.put("id " + count, splitNames[0]);
                wbp.surName.put("id " + count, splitNames[1]);
            }

//            rendering
            model.put("firstName", wbp.getFirstName());
            model.put("secondName", wbp.getSecondName());
            model.put("surName", wbp.getSurName());


            model.put("hello", "HELLO WORLD");


            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "index.handlebars"));
        });
    }
}
