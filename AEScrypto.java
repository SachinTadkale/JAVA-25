import java.util.Base64;
import javax.crypto.*;

public class AEScrypto {

  public static void main(String[] args) throws Exception {

    // 1. Generate a Secret Key for AES encryption
    KeyGenerator keyGen = KeyGenerator.getInstance("AES"); // Create AES key generator
    keyGen.init(128); // Set key size to 128 bits (We can also use 192 or 256 if supported)
    SecretKey secretKey = keyGen.generateKey(); // Generate the secret key

    // 2. Create a Cipher instance for AES
    Cipher cipher = Cipher.getInstance("AES"); // Cipher will be used for both encryption and decryption

    // Original plain text message to be encrypted
    String plainText = "Learning Cryptography";

    // 3. Encrypt the Message
    cipher.init(Cipher.ENCRYPT_MODE, secretKey); // Initialize cipher for encryption using the secret key
    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes()); // Encrypt the plain text (convert to bytes first)
    
    // Encode the encrypted bytes to a Base64 string for readable output
    String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes); 
    System.out.println("Encrypted : " + encryptedText); 

    // 4. Decrypt the Message
    cipher.init(Cipher.DECRYPT_MODE, secretKey); // Reinitialize the cipher for decryption using the same key
    byte[] decrypted_bytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); // Decode Base64 and decrypt
    String decryptedText = new String(decrypted_bytes); // Convert decrypted bytes back to readable string
    System.out.println("Decrypted: " + decryptedText);
  }
}
