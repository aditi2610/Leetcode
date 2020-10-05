package JPMorgan;

public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = Integer.MIN_VALUE;
        while (j < prices.length) {
            if (prices[i] > prices[j]) {
                i++;
                j++;
            } else if (max < prices[i] - prices[j]) {
                max = prices[i] - prices[j];
                j++;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        BuyAndSellStock stock = new BuyAndSellStock();
        int[] stockPrice = { 7, 1, 4, 6, };
        System.out.println(stock.maxProfit(stockPrice));
    }
}
