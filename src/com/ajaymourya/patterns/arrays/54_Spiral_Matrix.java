class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return list;
        }
        int rowBegin = 0, rowEnd = matrix.length-1, colBegin = 0, colEnd = matrix[0].length-1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i=colBegin; i<=colEnd; i++){
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i=rowBegin; i<=rowEnd; i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){
                for(int i=colEnd; i>=colBegin; i--){
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int i=rowEnd; i>=rowBegin; i--){
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return list;
    }
}