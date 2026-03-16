class FallingSum{
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        // first row
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }

        // fill remaining rows
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiag = matrix[i][j] + (j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE);

                int rightDiag = matrix[i][j] + (j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE);

                dp[i][j] = Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            min = Math.min(min, dp[n-1][j]);
        }

        return min;
    }
}