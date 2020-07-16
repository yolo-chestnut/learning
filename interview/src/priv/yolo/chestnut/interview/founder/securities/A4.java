package priv.yolo.chestnut.interview.founder.securities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4. List<Double> prices 中存有某只股票n个连续交易日的收盘价，写程序计算在哪个价格买入和卖出能获得最大收益，返回最大收益值。
 * ps: 有问题，没有要求出现相同最大收益（但是间隔天数不同），
 */
public class A4 {

    public static void main(String[] args) {
        Double[] temp = {19.0, 1.0, 2.0, 3.0, 4.0, 21.0, 4.0, 3.0, 2.0, 1.0, 20.0, 20.0};
        List<Double> prices = new ArrayList<>(Arrays.asList(temp));
        method(prices);
    }

    private static void method(List<Double> prices) {
        List<Profit> result = new ArrayList<>();
        int size = prices.size();
        double currentProfit = 0.0;

        double tempProfit;
        // 计算当天之后的日期减去当天的收益，取最大收益
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                tempProfit = prices.get(j) - prices.get(i);
                // 如果临时收益（新计算的）大于等于当前最大收益
                if (tempProfit >= currentProfit) {
                    Profit profit = new Profit();
                    profit.start = i;
                    profit.end = j;
                    profit.profit = tempProfit;
                    // 如果临时收益（新计算的）大于当前最大收益
                    // 等于的情况，不需要更新当前最大收益，不需要清空旧结果
                    if (tempProfit > currentProfit) {
                        // 更新当前最大收益
                        currentProfit = tempProfit;
                        // 清空结果
                        result.clear();
                    }
                    // 将结果放入
                    result.add(profit);
                }
            }
        }

        if (!result.isEmpty()) {
            for (Profit p : result) {
                // start、end是角标，第几个数字需要加1
                System.out.println("开始日期：" + ++p.start + " 结束日期：" + ++p.end + " 最大收益为：" + p.profit);
            }
        } else {
            System.out.println("不赚钱咧！！！");
        }

    }

}

class Profit {
    // 买入日期
    int start;
    // 卖出日期
    int end;
    // 收益
    double profit;
}
