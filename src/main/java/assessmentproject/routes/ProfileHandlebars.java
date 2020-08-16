package assessmentproject.routes;

import assessmentproject.User;
import assessmentproject.section2.loginpage.LogIn;
import assessmentproject.section4.profilepage.Crud;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static assessmentproject.web.WebProcessor.myPasswords;
import static assessmentproject.web.WebProcessor.myUserTable;
import static spark.Spark.get;
import static spark.Spark.post;

public class ProfileHandlebars {

    /*TODO
     *  filters spark to authenticate secrete keys
     * */


    public static void profilePage(Map model) {


        get("/profile", (req, res) -> {

            for (Map.Entry<String, LogIn> entry2 : myPasswords.entrySet()) {
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


        Crud crud = new Crud();
        ObjectMapper ob = new ObjectMapper();

        /*updating user information*/
        post("/profile", (req, res) -> {
            String emailId = req.queryParams("emailId");

            // TODO: 2020/08/15 message if information has been successesfly changed
            User user = crud.findByUserId(emailId);

            if (user != null) {

                String firstName = req.queryParams("firstName");
                String secondName = req.queryParams("secondName");
                String surName = req.queryParams("surName");
                String email = req.queryParams("email");

                if (firstName.isEmpty())
                    firstName = crud.findByUserId(emailId).firstName;

                if (secondName.isEmpty())
                    secondName = crud.findByUserId(emailId).secondName;

                if (surName.isEmpty())
                    surName = crud.findByUserId(emailId).surName;

                if (email.isEmpty())
                    email = crud.findByUserId(emailId).email;

                String isExist = String.valueOf(crud.checkEmailDuplicates(email));

                if (isExist.equals("!exist")) {
                    crud.update(emailId, firstName, secondName, surName, email);

                    res.redirect("http://0.0.0.0:8080/profile");
                    model.remove("duplicate");
                } else {

                    // FIXME: 2020/08/16  update this key
                    model.put("duplicate", "Oops email is already taken");
                }

            } else {

                try {
                    // TODO: 2020/08/15 have custom exception classes
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return ob.writeValueAsString("Oops email is already taken");
        });



        /*updating user password*/
        assessmentproject.section4.password.Crud crud1 = new assessmentproject.section4.password.Crud();
        ObjectMapper ob1 = new ObjectMapper();
        post("/updateProfile", (req, res) -> {

            String emailIdPassword = req.queryParams("emailIdPassword");
            LogIn logIn = crud1.findByUserId(emailIdPassword);

            if (logIn != null) {

                String currentPassword = req.queryParams("currentPassword");
                String newPassword = req.queryParams("newPassword");
                String confirmPassword = req.queryParams("confirmPassword");

                if (newPassword.equals(confirmPassword)) {

                    crud1.update(emailIdPassword, currentPassword, newPassword);

                    res.redirect("http://0.0.0.0:8080/login");
                    model.put("reLogIn", "you have successfully updated your password please log in again");
                }

                return ob1.writeValueAsString("");

            } else {

                // TODO: 2020/08/15 have custom exception classes
                return ob1.writeValueAsString("user not found");
            }
        });

        post("/profile", (req, res) -> {

            return new HandlebarsTemplateEngine()
                    .render(new ModelAndView(model, "profile.handlebars"));
        });
    }

}
