public class FrogJump {

    public static int frog(int i, int[] heights) {

        if (i == 0) {
            return 0;
        }

        int jump1 = frog(i - 1, heights) 
                + java.lang.Math.abs(heights[i] - heights[i - 1]);

        int jump2 = Integer.MAX_VALUE;

        if (i > 1) {
            jump2 = frog(i - 2, heights) 
                    + java.lang.Math.abs(heights[i] - heights[i - 2]);
        }

        return java.lang.Math.min(jump1, jump2);
    }

    public static void main(String[] args) {

        int[] heights = {10, 20, 30, 10};

        int n = heights.length;

        System.out.println(frog(n - 1, heights));
    }
}