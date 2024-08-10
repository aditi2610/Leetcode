class Solution {
    int res = 0;
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        /***
             [10,20,20], tastiness = [5,8,8], maxAmount = 20, maxCoupons = 1
             take: (10, 1, 1 ) + 5
                take: (-10, 2, 1) + 8  -> INVALID

                disc_take: (0, 2, 0) + 8
                    take: (-20, 3, 0) + 8 -> Invalid
                    disc_take: (-10, 3, -1) -> Invalid
                    not_take: (0, 3, 0) +
                not_take: (10, 2, 1)
             disc: (15, 1, 0) + 5
                take: (-5, 2, 0) + 8;
                disc_take: (-5, 2, -1);
                not_take(15, 2, 0);
             not_take: (20, 1, 1)
                take : (0, 2, 1) + 8
                disc_take : (10, 2, 0) + 8
                not_take: (20, 2, 1)

        Space Complexity: O(N* MAXAMOUNT* MAX_COUPON)
        Time Complexity:
        */
        int[][][] cache = new int[price.length][maxAmount+1][maxCoupons+1];
        for (int[][] layer : cache) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(price, tastiness, maxAmount, maxCoupons, 0, 0, cache);
    }

    private int dfs(int[] price, int[] taste, int maxAmount, int coup, int index, int depth, int[][][] cache){
        System.out.println(indent(depth)+ "index: " + index+ " maxAmount: "+ maxAmount+ " coup: "+ coup);
        if(index == price.length){
            return 0;
        }
        if(cache[index][maxAmount][coup] != -1) return cache[index][maxAmount][coup];
        // Not taking the current at all
        int not_take = dfs(price, taste, maxAmount, coup, index+1, depth+1,cache);
        int take = 0, disc_take = 0;
        if(price[index] <= maxAmount)
            take = dfs(price, taste, maxAmount - price[index], coup, index+1, depth+1, cache) + taste[index];
        if(coup > 0 && maxAmount >= price[index]/2)
            disc_take = dfs(price, taste, maxAmount - (price[index]/2), coup-1, index+1, depth+1, cache ) + taste[index];
        cache[index][maxAmount][coup] = Math.max(not_take , Math.max(take, disc_take));
        return cache[index][maxAmount][coup];
    }
    // For visualizaiton
    private String indent(int depth){
        StringBuilder space = new StringBuilder();
        for(int i = 0; i< depth; i++){
            space.append("  ");
        }
        return space.toString();
    }
}