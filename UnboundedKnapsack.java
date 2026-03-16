class UnboundedKnapsack {

    static int knapsack(int i, int W, int[] weight, int[] value) {

        if (i == 0) {
            return (W / weight[0]) * value[0];
        }

        int notTake = knapsack(i - 1, W, weight, value);

        int take = Integer.MIN_VALUE;
        if (weight[i] <= W) {
            take = value[i] + knapsack(i, W - weight[i], weight, value);
        }

        return java.lang.Math.max(take, notTake);
    }

    public static void main(String[] args) {

        int[] weight = {2, 3, 5};
        int[] value = {10, 15, 25};
        int W = 7;
        int n = weight.length;

        System.out.println(knapsack(n - 1, W, weight, value));
    }
}