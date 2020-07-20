package priv.yolo.chestnut.bloomfilter.java;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import redis.clients.jedis.util.MurmurHash;

// guava
public class MurmurHashTest {

    public static void main(String[] args) {
        // 一般hash算法对"abc"和"abd"的剧烈程度不如murmurHash大
        String s1 = "abc";
        String s2 = "abd";

        // redis提供
        int hash1 = MurmurHash.hash(s1.getBytes(), 10);
        int hash2 = MurmurHash.hash(s2.getBytes(), 10);

        System.out.println("murmurHash(redis)，" + hash1);
        System.out.println("一般hash算法(hashCode方法)，" + s1.hashCode());
        System.out.println("murmurHash(redis)，" + hash2);
        System.out.println("一般hash算法(hashCode方法)，" + s2.hashCode());

        HashCode hashCode1 = Hashing.murmur3_32(10).hashBytes(s1.getBytes());
        System.out.println("murmurHash(guava)，" + hashCode1.asInt());

        HashCode hashCode2 = Hashing.murmur3_32(10).hashBytes(s2.getBytes());
        System.out.println("murmurHash(guava)，" + hashCode2.asInt());
    }

}
