package assessmentproject.section1.regpage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalInformationTest {

String expectedMessage;
String actualMessage;

    @DisplayName("must verify that names does not have unnecessary characters")
    @Test
    public void unnecessaryCharacters() {

        // TODO  ~ TRUE MEANS THERE IS AN ERROR
        //       ~ FALSE MEANS THERE ARE NO ERRORS

        PersonalInformation personal = new PersonalInformation();

        // should return false as there are errors

        expectedMessage ="false";
        actualMessage = String.valueOf(personal.makingSureThereAreNoUnWantedCharacters("phumlani"));

        assertEquals(expectedMessage, actualMessage);
        assertFalse(Boolean.parseBoolean(actualMessage));


        // error, there is a special character

        expectedMessage = String.valueOf(true);
        actualMessage = String.valueOf(personal.makingSureThereAreNoUnWantedCharacters("#phumlani"));

        assertEquals(expectedMessage, actualMessage);
        assertTrue(Boolean.parseBoolean(actualMessage));

        // error 'coz there are no numbers

        expectedMessage = String.valueOf(true);
        actualMessage = String.valueOf(personal.makingSureThereAreNoUnWantedCharacters("#phumlani"));

        assertEquals(expectedMessage, actualMessage);
        assertTrue(Boolean.parseBoolean(actualMessage));


        // error 'coz there  name is less than 3 chars

        expectedMessage = String.valueOf(true);
        actualMessage = String.valueOf(personal.makingSureThereAreNoUnWantedCharacters("tw"));

        assertEquals(expectedMessage, actualMessage);
        assertTrue(Boolean.parseBoolean(actualMessage));
    }

    @Test
    @DisplayName("should capitalise first letters of a word")
    public void capitaliseFirstLetter() {
        PersonalInformation ps = new PersonalInformation();

        expectedMessage = "Maverics";
        actualMessage = ps.capitaliseFirstLetter("maverics");


        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

        expectedMessage = "Jacobs";
        actualMessage = ps.capitaliseFirstLetter("jacobs");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

        expectedMessage = "Steven Joseph";
        actualMessage = ps.capitaliseFirstLetter("steven joseph");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

        expectedMessage = "Steven Joseph Mavundla";
        actualMessage = ps.capitaliseFirstLetter("steven joseph mavundla");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

    }

    @Test
    @DisplayName("adding names")
   public void shouldAddAName( ) {
        PersonalInformation personalInformation = new PersonalInformation();

        expectedMessage = "Phumlani Mthembu";
        actualMessage = personalInformation.names("phumlani","mthembu");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));


        expectedMessage = "Phumlani Duncan Mthembu";
        actualMessage = personalInformation.names("phumlani","duncan","mthembu");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

        expectedMessage = "Phumlani Duncan Mthembu";
        actualMessage = personalInformation.names("phumlani".toLowerCase(),"duncan".toLowerCase(),"Mthembu".toLowerCase());

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));




    }


}
