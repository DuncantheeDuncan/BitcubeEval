package assessmentproject.section1.regpage;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {


    static final Random RANDOM = new SecureRandom();
    static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static final int ITERATIONS = 50000;
    static final int KEY_LENGTH = 128;

    public static boolean checkMinimumReq(String minimum) {

        boolean error = true;
        boolean upperCaseCharacter = false;
        boolean specialCharacter = false;
        boolean lowerCaseCharacter = false;
        boolean numberExists = false;
        boolean minLengthIsSix = false;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");

        char[] check = minimum.toCharArray();

        if (check.length >= 6)
            minLengthIsSix = true;

        for (char C : check) {
            Matcher matcher = pattern.matcher(String.valueOf(C));

            if (Character.isUpperCase(C)) {
                upperCaseCharacter = true;
            } else if (!matcher.matches()) {
                specialCharacter = true;
            } else if (Character.isLowerCase(C)) {
                lowerCaseCharacter = true;
            } else if (Character.isDigit(C)) {
                numberExists = true;
            }

            if (upperCaseCharacter && specialCharacter && lowerCaseCharacter && numberExists && minLengthIsSix)
                error = false;
        }
        return error;
    }

    public static String generateSecurePassword(String password, String salt) {

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

        return Base64.getEncoder().encodeToString(securePassword);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return secretKeyFactory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String getSalt(int length) {
        StringBuilder salt = new StringBuilder(length);

        int i = 0;
        while (i < length) {
            salt.append(ALPHABETS.charAt(RANDOM.nextInt(ALPHABETS.length())));
            i++;
        }
        return String.valueOf(salt);
    }


    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }

}
