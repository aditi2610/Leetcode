package Facebook;

public class Solution121_Stock {
    public int maxProfit(int[] prices) {

        int min_Price = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min_Price) {
                min_Price = prices[i];
            } else if (prices[i] - min_Price > maxProfit) {
                maxProfit = prices[i] - min_Price;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution121_Stock stock = new Solution121_Stock();
        int prices[] = { 7, 5, 4, 3, 1 };
        System.out.println(stock.maxProfit(prices));
    }
}
