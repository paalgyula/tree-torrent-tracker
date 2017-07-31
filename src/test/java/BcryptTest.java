import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RunWith(JUnit4.class)
public class BcryptTest {
    @Test
    public void testEncryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println( encoder.encode("asd123") );
    }
}
