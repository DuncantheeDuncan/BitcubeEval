package assessmentproject.routes;

import assessmentproject.section2.loginpage.LogIn;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;


import static assessmentproject.section2.loginpage.VerifyUserPassword.verifyUserPassword;
import static assessmentproject.web.WebProcessor.myPasswords;
import static spark.Spark.get;
import static spark.Spark.post;

public class LoginHandlebars {

    public static void loginPage(Map model) {


        get("/login", (req, res) -> {

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "login.handlebars"));
        });


        post("/login", (req, res) -> {

            String email = req.queryParams("email");
            String providedPassword = req.queryParams("userPassword");
            model.remove("passwordError");
            model.remove("emailExist");


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

                        res.redirect("/profile");

                    } else {

                        model.put("passwordError", "incorrect email or password");
                        res.redirect("/login");
                    }

                } else {

                    model.put("emailExist", "please register your email");
                    res.redirect("/login");
                }

            }

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "login.handlebars"));
        });

    }
}
