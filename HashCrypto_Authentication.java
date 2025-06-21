
import java.security.MessageDigest;
import java.util.*;

public class HashCrypto_Authentication {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String Stored_data = "MyPassword";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] LoginHashBytes = md.digest(Stored_data.getBytes());

        StringBuilder Stored_hex = new StringBuilder();

        for (byte b : LoginHashBytes) {
            Stored_hex.append(String.format("%02x", b));
        }
        String storedHashing = Stored_hex.toString();

        System.out.println("Enter Your Password");

        String input_data = sc.next();

        MessageDigest md2 = MessageDigest.getInstance("SHA-256");
        byte[] inputHashedBytes = md.digest(input_data.getBytes());

        StringBuilder input_hex = new StringBuilder();

        for (byte b : inputHashedBytes) {
            input_hex.append(String.format("%02x", b));
        }
        String inputHashing = input_hex.toString();

        if (storedHashing.equals(inputHashing)) {
            System.out.println("Login Verified");
        } else {
            System.out.println("Login Failed");
        }
        sc.close();
    }
}
