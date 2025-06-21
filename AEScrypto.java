
import java.util.Base64;
import javax.crypto.*;

public class AEScrypto {

    public static void main(String[] args) throws Exception {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); //AES - 128bit
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");

        String plainText = "Learning Cryptography";

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted : " + encryptedText);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted_bytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decrypted_bytes);
        System.out.println("Decrypted: " + decryptedText);
    }
}
