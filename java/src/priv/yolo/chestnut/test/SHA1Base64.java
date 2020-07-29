package priv.yolo.chestnut.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

// zookeeper 用户密码 需要sha-1加密，再由base64编码
public class SHA1Base64 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String usernameAndPassword = "solr:solr";
        byte[] digest = MessageDigest.getInstance("SHA-1").digest(usernameAndPassword.getBytes());
        String str = Base64.getEncoder().encodeToString(digest);
        System.out.println(str);
    }

}
