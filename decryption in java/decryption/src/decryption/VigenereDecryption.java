package decryption;

import java.util.Scanner;

public class VigenereDecryption {

    // Function to generate extended key for Vigenere cipher
    public static String generateKey(String ciphertext, String key) {
        StringBuilder extendedKey = new StringBuilder(ciphertext.length());

        int keyLength = key.length();
        int j = 0;
        for (int i = 0; i < ciphertext.length(); ++i) {
            extendedKey.append(key.charAt(j));
            j = (j + 1) % keyLength;
        }

        return extendedKey.toString();
    }

    // Function to perform Vigenere cipher decryption
    public static String decryptText(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder(ciphertext.length());

        int keyLength = key.length();
        for (int i = 0; i < ciphertext.length(); ++i) {
            char c = ciphertext.charAt(i);
            char k = key.charAt(i);
            char x = (char) (((c - k + 26) % 26) + 'A');
            plaintext.append(x);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ciphertext: ");
        String ciphertext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        // Generate extended key and decrypt ciphertext
        String extendedKey = generateKey(ciphertext, key);
        String plaintext = decryptText(ciphertext, extendedKey);

        // Output the results
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Key: " + key);
        System.out.println("Extended Key: " + extendedKey);
        System.out.println("Plaintext: " + plaintext);

        scanner.close();
    }
}