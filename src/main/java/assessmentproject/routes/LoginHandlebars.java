package assessmentproject.routes;

import assessmentproject.section2.loginpage.LogIn;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.section1.regpage.Password.generateSecurePassword;
import static assessmentproject.web.WebProcessor.myPasswords;
import static spark.Spark.get;
import static spark.Spark.post;

public class LoginHandlebars {

    static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }


    public static void loginPage(Map model) {


        get("/login", (req, res) -> {

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "login.handlebars"));
        });


        post("/login", (req, res) -> {

            String email = req.queryParams("email");
            String providedPassword = req.queryParams("current-password");


            for (Map.Entry<String, LogIn> entry2 : myPasswords.entrySet()) {

                LogIn logIn2 = entry2.getValue();
                String key2 = entry2.getKey();

                String securedPassword = logIn2.securedPassword;
                String salt = logIn2.salt;

                if (key2.equals(email)) {

                    boolean isPassMatch = verifyUserPassword(providedPassword, securedPassword, salt);

                    if (isPassMatch) {

                        req.session(true);
                        req.session().attribute("user email", email);
                        req.session().id();
                        model.put("securedPassword", securedPassword);


                        System.out.println("provided pass : " + providedPassword + " is correct");

                        res.redirect("/profile");

                    } else {

                        // TODO redirect to login page or custom message
                        System.out.println("provided pass is incorrect");
                    }

                }
            }


            System.out.println(email + " nothing");//todo <-----

            model.put("hello", "hello world");
            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "login.handlebars"));
        });

    }
}
