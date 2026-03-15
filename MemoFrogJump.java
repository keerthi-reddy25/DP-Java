import java.util.Arrays;
public class MemoFrogJump{
    public static int frog(int i,int[] heights,int[] dp ){
        if(i==0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int jump1=frog(i-1,heights,dp)+java.lang.Math.abs(heights[i]-heights[i-1]);
        int jump2=Integer.MAX_VALUE;
        if(i>1){
           jump2=frog(i-2,heights,dp)+java.lang.Math.abs(heights[i]-heights[i-2]);
        }
        dp[i]=java.lang.Math.min(jump1,jump2);
        return dp[i];
    }


    public static void main(String[] args){
        int[] heights={10,20,30,10};
        int n=heights.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(frog(n-1,heights,dp));

    }
}