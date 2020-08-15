package assessmentproject.routes;

import assessmentproject.User;
import assessmentproject.section1.regpage.EmailProcessor;
import assessmentproject.section1.regpage.PasswordProcessor;
import assessmentproject.section1.regpage.PersonalInformation;
import assessmentproject.section2.loginpage.LogIn;
import assessmentproject.web.WebProcessor;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.web.WebProcessor.myPasswords;
import static assessmentproject.web.WebProcessor.myUserTable;
import static spark.Spark.*;

public class RegistrationHandlebars {


    public static void registrationPage(Map model) {

        EmailProcessor em = new EmailProcessor();
        PasswordProcessor pass = new PasswordProcessor();
        WebProcessor wpr = new WebProcessor();
        PersonalInformation ps = new PersonalInformation();


        get("/registration", (req, res) -> {


            model.remove("emailError");
            model.remove("regSuccess");
            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "registration.handlebars"));
        });


        post("/registration", (req, res) -> {


            // FIXME: 2020/08/13  must try and remove duplicate

            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String surName = req.queryParams("surName");
            String emailInput = req.queryParams("email");
            String passwordInput = req.queryParams("new-password");
            model.remove("emailError");
            model.remove("regSuccess");


            String names = ps.names(firstName, secondName, surName);
            String email = em.addEmail(emailInput);
            String password = pass.password(passwordInput);


            if (wpr.emailChecker.contains(email)) {

                model.put("emailError", "email must be unique, this one is already taken");
            } else {

                wpr.emailsList.add(email);
                model.put("email", wpr.emailsList);
                wpr.emailChecker.add(email);

                if (!password.isEmpty()) {
                    wpr.passwordsList.add(password);
                    wpr.passwordsListSalted.add(pass.salt);
                    model.put("password", wpr.passwordsList);
                    model.put("saltedPassword",wpr.passwordsListSalted);
                }

                if (!firstName.isEmpty() & !secondName.isEmpty() & !surName.isEmpty()) {

                    String[] splitNames = names.split(" ");

                    wpr.firstNamesList.add(splitNames[0]);
                    wpr.secondNamesList.add(splitNames[1]);
                    wpr.surNamesList.add(splitNames[2]);

                    firstName = splitNames[0];
                    secondName = splitNames[1];
                    surName = splitNames[2];

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

                    firstName = splitNames[0];
                    secondName = "N/A";
                    surName = splitNames[1];

                    model.put("firstName", wpr.firstNamesList);
                    model.put("secondName", wpr.secondNamesList);
                    model.put("surName", wpr.surNamesList);

                    wpr.counter.add(splitNames[0]);
                    model.put("counter", wpr.counter.size());
                    model.put("regSuccess","Successfully registered, now please sign in");

                } else if ("Error".equals(names)) {

                    //FIXME model.put("error", er.emailError.add("something is wrong the names you provided"));
                }
            }


            if (!model.containsKey("emailError") & model.containsKey("regSuccess")) {
                User user = new User(email, firstName, secondName, surName, password);
                LogIn passwords = new LogIn(email,password,pass.securePassword,pass.salt);
                myUserTable.put(email, user);
                myPasswords.put(email,passwords);

                res.redirect("/");
            }


            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "registration.handlebars"));
        });

    }
}
