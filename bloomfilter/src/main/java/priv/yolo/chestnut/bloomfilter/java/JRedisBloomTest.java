package priv.yolo.chestnut.bloomfilter.java;

import io.rebloom.client.Client;

// redis
// 参考链接：https://github.com/RedisBloom/JRedisBloom
public class JRedisBloomTest {

    public static void main(String[] args) {
        // 需要单机运行装有bloom filter插件的redis
        Client bloomFilter = new Client("localhost", 6379);
        bloomFilter.add("丑黄", "真丑");
        bloomFilter.addMulti("超丑黄", "真丑x1", "真丑x2", "真丑x3");

        System.out.println(bloomFilter.exists("丑黄", "帅？"));
        System.out.println(bloomFilter.exists("丑黄", "真丑"));

        boolean[] results = bloomFilter.existsMulti("超丑黄", "帅？", "真丑x1", "真丑x4", "真丑x2");
        for (boolean result : results) {
            System.out.println(result);
        }

        // 还有redis集群模式
    }

}
