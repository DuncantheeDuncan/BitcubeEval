package assessmentproject.section1.regpage;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalInformationTest {

    String expectedMessage;
    String actualMessage;

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
    public void shouldAddAName() {
        PersonalInformation personalInformation = new PersonalInformation();

        expectedMessage = "Phumlani Mthembu";
        actualMessage = personalInformation.names("phumlani", "mthembu");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));


        expectedMessage = "Phumlani Duncan Mthembu";
        actualMessage = personalInformation.names("phumlani", "duncan", "mthembu");

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));

        expectedMessage = "Phumlani Duncan Mthembu";
        actualMessage = personalInformation.names("phumlani".toLowerCase(), "duncan".toLowerCase(), "Mthembu".toLowerCase());

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedMessage.contains(actualMessage));
    }
}
