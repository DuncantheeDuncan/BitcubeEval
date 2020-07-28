package assessmentproject.section1.regpage.web;

import assessmentproject.section1.regpage.EmailProcessor;
import assessmentproject.section1.regpage.PasswordProcessor;
import assessmentproject.section1.regpage.PersonalInformation;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Web extends WebProcessor {

    public static void main(String[] args) {


        PersonalInformation ps = new PersonalInformation();
        EmailProcessor em = new EmailProcessor();
        PasswordProcessor pass = new PasswordProcessor();
        WebProcessor wpr = new WebProcessor();

        staticFiles.location("/public");
        port(8080);

        Map<String, Object> model = new HashMap<>();
        WebProcessor er = new WebProcessor();


        er.emailError.clear();


        get("/", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "index.handlebars")));


        get("/registration", (req, res) -> {

            model.remove("emailError", er.emailError);
            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "registration.handlebars"));
        });


        post("/registration", (req, res) -> {

            notFound("<html><body><h1>Page not found</h1></body></html>");


            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String surName = req.queryParams("surName");
            String emailInput = req.queryParams("email");
            String passwordInput = req.queryParams("password");
            model.remove("emailError", er.emailError);

            String names = ps.names(firstName, secondName, surName);
            String email = em.addEmail(emailInput);
            String password = pass.password(passwordInput);
            er.emailError.clear();

            if (wpr.emailChecker.contains(email)) {


                er.emailError.add("email must be unique, this one is already taken");
                model.put("emailError", er.emailError);
            } else {

                wpr.emailsList.add(email);
                model.put("email", wpr.emailsList);
                wpr.emailChecker.add(email);

                if (!password.isEmpty()) {
                    wpr.passwordsList.add(password);
                    model.put("password", wpr.passwordsList);
                }

                if (!firstName.isEmpty() & !secondName.isEmpty() & !surName.isEmpty()) {

                    String[] splitNames = names.split(" ");

                    wpr.firstNamesList.add(splitNames[0]);
                    wpr.secondNamesList.add(splitNames[1]);
                    wpr.surNamesList.add(splitNames[2]);

                    wpr.counter.add(splitNames[0]);
                    model.put("counter", wpr.counter.size());

                    model.put("firstName", wpr.firstNamesList);
                    model.put("secondName", wpr.secondNamesList);
                    model.put("surName", wpr.surNamesList);

                } else if (secondName.isEmpty()) {

                    names = ps.names(firstName, surName);

                    String[] splitNames = names.split(" ");

                    wpr.firstNamesList.add(splitNames[0]);
                    wpr.secondNamesList.add("N/A");
                    wpr.surNamesList.add(splitNames[1]);


                    model.put("firstName", wpr.firstNamesList);
                    model.put("secondName", wpr.secondNamesList);
                    model.put("surName", wpr.surNamesList);

                    wpr.counter.add(splitNames[0]);
                    model.put("counter", wpr.counter.size());

                } else if ("Error".equals(names)) {

                    model.put("error", er.emailError.add("something is wrong the names you provided"));
                }
            }

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "registration.handlebars"));
        });


        get("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));

        post("/registered", (req, res) -> new HandlebarsTemplateEngine()
                .render(new ModelAndView(model, "registered.handlebars")));
    }
}
