class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length - 1;j++){
                if(matrix[i-1][j] != matrix[i][j+1]) return false;
            }
        }
        return true;
    }
}