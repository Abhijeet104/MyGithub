/** 322. Coin Change

https://leetcode.com/problems/coin-change/description/

**/



class coinChange{
    

public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 1)
            return 0;
        Arrays.sort(coins);
        int[][] a = new int[coins.length+1][amount+1];
        for(int i = 0; i<coins.length+1;i++)
            Arrays.fill(a[i], Integer.MAX_VALUE);
        for(int i = 0; i<coins.length+1;i++)
            a[i][0]= 0;

        int x = 1;
        for(int j = coins[0]; j<amount+1; j = j +coins[0])
            a[0][j] =  x++;
        
        
        for(int i = 1; i<coins.length+1;i++){
            for(int j = 1; j<amount+1; j++){
                if(j<coins[i-1])
                    a[i][j] = a[i-1][j];
                else{
                   int val = 0;
                		if( a[i][j-coins[i-1]] == Integer.MAX_VALUE)
                			val = Integer.MAX_VALUE;
                		else
                			val = 1+a[i][j-coins[i-1]];
                    a[i][j] = Math.min(val, a[i-1][j]);
                }
            }
        }
        if (a[coins.length][amount] > Integer.MAX_VALUE-100000 || a[coins.length][amount] < 1)
            return -1;
        else
            return a[coins.length][amount];
    }
}