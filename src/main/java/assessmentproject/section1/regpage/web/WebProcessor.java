package assessmentproject.section1.regpage.web;

import java.util.HashMap;
import java.util.Map;

public class WebProcessor {

   Map<String,Object> firstName = new HashMap<>();
    Map<String,Object> secondName = new HashMap<>();
    Map<String,Object> surName = new HashMap<>();
    Map<String,Object>error = new HashMap<>();


    public Map<String, Object> getError() {
        return error;
    }

    public  Map<String, Object> getFirstName() {
        return firstName;
    }

    public Map<String, Object> getSecondName() {
        return secondName;
    }

    public Map<String, Object> getSurName() {
        return surName;
    }

    public static void main(String[] args) {
        String x = "ppml";

        System.out.println(x.contentEquals("p"));
    }
}
