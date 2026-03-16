public class BackPackTab {

    public static int knapsackTab(int capacity, int[] weight, int[] value){

        int n = value.length;

        int[][] dp = new int[n][capacity + 1];

        for(int w = weight[0]; w <= capacity; w++){
            dp[0][w] = value[0];
        }

        for(int i = 1; i < n; i++){

            for(int w = 0; w <= capacity; w++){

                int notTake = dp[i-1][w];

                int take = Integer.MIN_VALUE;

                if(weight[i] <= w){
                    take = value[i] + dp[i-1][w - weight[i]];
                }

                dp[i][w] = java.lang.Math.max(take, notTake);

            }
        }

        return dp[n-1][capacity];
    }

    public static void main(String[] args){

        int capacity = 5;

        int[] weight = {2,3,4,2};

        int[] value = {40,50,70,120};

        System.out.println(knapsackTab(capacity, weight, value));

    }
}