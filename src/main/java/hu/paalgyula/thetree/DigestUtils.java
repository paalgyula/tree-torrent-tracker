package hu.paalgyula.thetree;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by paalgyula on 2016.10.27..
 */
public class DigestUtils {
    public static String md5Hex(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.reset();
            md5.update(password.getBytes());
            byte[] digest = md5.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            String hashtext = bigInt.toString(16);

            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
