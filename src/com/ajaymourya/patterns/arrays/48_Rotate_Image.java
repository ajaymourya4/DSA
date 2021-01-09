/*
 * clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each row
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
 * 
 * anti-clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each col
*/
class Solution {
    public void rotate(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        int[] temp;
        
        while (start < end) {
            temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        
        transpose(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}