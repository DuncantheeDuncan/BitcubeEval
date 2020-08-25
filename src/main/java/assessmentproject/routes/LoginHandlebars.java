package assessmentproject.routes;

import assessmentproject.section2.loginpage.LogIn;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.section2.loginpage.VerifyUserPassword.verifyUserPassword;
import static assessmentproject.web.WebProcessor.myPasswords;
import static spark.Spark.get;
import static spark.Spark.post;

public class LoginHandlebars {


    public static void loginPage(Map model) {


        get("/login", (req, res) -> {
            return new HandlebarsTemplateEngine().render(new ModelAndView(model, "login.handlebars"));
        });


        post("/login", (req, res) -> {

            String email = req.queryParams("email");
            String providedPassword = req.queryParams("userPassword");

            boolean isEqual = false;


            for (Map.Entry<String, LogIn> entry2 : myPasswords.entrySet()) {


                model.remove("passwordError");
                model.remove("emailExist");

                LogIn logIn2 = entry2.getValue();
                String key2 = entry2.getKey();

                String securedPassword = logIn2.securedPassword;
                String salt = logIn2.salt;

                isEqual = key2.equals(email);

                if (isEqual) {

                    boolean isPassMatch = verifyUserPassword(providedPassword, securedPassword, salt);

                    if (isPassMatch) {

                        Session session = req.session(true);
                        session.isNew();
                        session.attribute("user email", email);

                        // TODO: 2020/08/24 use lastAccessible session for last seen

                        res.redirect("/profile");
                        break;

                    } else {

                        model.put("passwordError", "incorrect email or password");

                    }
                }
            }

            if (!isEqual)
                model.put("emailExist", "please register your email");// FIXME: 2020/08/25  control this part of scope


            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "login.handlebars"));
        });

    }
}
