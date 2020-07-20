package priv.yolo.chestnut.bloomfilter.java;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

// guava
public class BloomFilterTest {

    private static int size = 1000000;      // 预计数据量

    private static double fpp = 0.000001;   // 期望的误判率

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
        int count = 0;
        int fppCount = 0;
        for (int i = size; i < 2 * size; i++) {
            if (bloomFilter.mightContain(i)) {
                fppCount++;
                System.out.println(i + " 误判了！");
            } else {
                count++;
            }
        }
        System.out.println("判定不存在的数量：" + count);
        System.out.println("误判的数量：     " + fppCount);
    }

}
