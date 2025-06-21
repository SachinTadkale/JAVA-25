import java.security.MessageDigest;

public class HashCrypto {
    public static void main(String[] args) throws Exception {

        // 1. Define the input string you want to hash
        String input = "mypassword";

        // 2. Create a MessageDigest instance for SHA-256 hashing
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // 3. Convert input string to bytes and generate hash (digest)
        byte[] hash = md.digest(input.getBytes());

        // 4. Convert the byte array to a readable hexadecimal string
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            // Convert each byte to a 2-digit hex string (e.g., 0A, FF, 3E)
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-256 Hash: " +hex.toString());
    }
}
