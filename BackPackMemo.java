import java.util.Arrays;

public class BackPackMemo{

public static int knapsack1(int capacity,int[] weight,int[] value,int index,int[][] dp){

    if(index==0 || capacity==0){
        if(weight[0]<=capacity)
            return value[0];
        return 0;
    }

    if(dp[index][capacity] != -1){
        return dp[index][capacity];
    }

    int notTake = knapsack1(capacity,weight,value,index-1,dp);

    int take = Integer.MIN_VALUE;

    if(weight[index] <= capacity){
        take = value[index] + knapsack1(capacity-weight[index],weight,value,index-1,dp);
    }

    dp[index][capacity] = java.lang.Math.max(take,notTake);

    return dp[index][capacity];
}

public static void main(String[] args){

    int capacity=5;

    int[] weight={2,3,4,2};

    int[] value={40,50,70,120};

    int index=value.length-1;

    int[][] dp=new int[value.length][capacity+1];

    for(int i=0;i<value.length;i++){
        Arrays.fill(dp[i],-1);
    }

    System.out.println(knapsack1(capacity,weight,value,index,dp));

}

}