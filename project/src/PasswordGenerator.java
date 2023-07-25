import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}\\|;:'\",.<>/?";

    public static void main(String[] args) {
        int length = 12; // Length of the generated password
        boolean includeLowercase = true; // Include lowercase characters
        boolean includeUppercase = true; // Include uppercase characters
        boolean includeNumbers = true; // Include numbers
        boolean includeSymbols = true; // Include symbols

        String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers, includeSymbols);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                          boolean includeNumbers, boolean includeSymbols) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random();

        String characters = "";
        if (includeLowercase) {
            characters += LOWERCASE;
        }
        if (includeUppercase) {
            characters += UPPERCASE;
        }
        if (includeNumbers) {
            characters += NUMBERS;
        }
        if (includeSymbols) {
            characters += SYMBOLS;
        }

        if (characters.isEmpty()) {
            throw new IllegalArgumentException("At least one character type must be included in the password.");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
