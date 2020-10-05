class Solution122_buyAndSellStock{
    public static void main(String[] args){
        int[] arr  = {7,6,4,3,1};
        Solution122_buyAndSellStock sol = new Solution122_buyAndSellStock();
        System.out.println( " Maximum Profit is: "+sol.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
      int i =0; 
      int min = Integer.MAX_VALUE;
      int max = 0;
      int profit =0;
      //Find the first smallest value
      //Find the next highest value such that the value next to it is smaller.
      while(i< prices.length -1){
          while( prices[i] > prices[i + 1]) {
              i++;
          }
          if (i < prices.length) {
              min = prices[i];
          }

          int j = i + 1;
          while (j < prices.length - 1 && prices[j] < prices[j + 1])
              j++;

          if (j < prices.length)
              max = prices[j];

          profit += max - min;
          i = j+1;
      } 
    return profit;
    }
}