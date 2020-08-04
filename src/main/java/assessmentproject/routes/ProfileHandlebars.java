package assessmentproject.routes;

import assessmentproject.User;
import assessmentproject.section2.loginpage.LogIn;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static assessmentproject.web.WebProcessor.myPasswords;
import static assessmentproject.web.WebProcessor.myUserTable;
import static spark.Spark.get;
import static spark.Spark.post;

public class ProfileHandlebars {

    /*TODO
     *  filters spark to authenticate secrete keys
     * */


    static Map<String, Object> map = new HashMap<>();

    public static void profilePage(Map model) {

        get("/profile", (req, res) -> {


            for (Map.Entry<String, LogIn> entry2 :myPasswords.entrySet()){
                String key2 = entry2.getKey();
                LogIn pass = entry2.getValue();


                if (key2.equals(req.session().attribute("user email"))) {


                    model.put("lSaltPassword", pass.salt);
                    model.put("lSecuredPassword", pass.securedPassword);
                }
            }

            for (Map.Entry<String, User> entry1 : myUserTable.entrySet()) {
                String key1 = entry1.getKey();
                User user1 = entry1.getValue();



                if (key1.equals(req.session().attribute("user email"))) {

                    model.put("lEmail", user1.email);
                    model.put("lFirstName", user1.firstName);
                    model.put("lSecondName", user1.secondName);
                    model.put("lSurName", user1.surName);

                }
            }

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "profile.handlebars"));
        });

        post("/profile", (req, res) -> {

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "profile.handlebars"));
        });
    }
}
