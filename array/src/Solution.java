class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1){
            return false;
        }
        for (int i = 0; i < matrix.length ; i++) {
            int[] row = matrix[i];
            if(row==null || row.length<1)
                return false;
            boolean exist = divide(row, 0, row.length - 1, target);
            int count = 0;
            if (exist == true)
                return true;
            else {
                count ++;
            }
            if (count == matrix.length){
                System.out.println("no");
            }
        }
        return false;           
    }
        
    private boolean divide(int[] row, int start, int end, int target) {
        if(row==null || row.length < 1)
            return false;
        if (start <= end) {
            int mid = (start + end) / 2;
            if (row[mid] == target)
                return true;
            else if (row[mid] > target) {
                return divide(row, start, mid - 1, target);
            }
            else{
                return divide(row, mid + 1, end, target);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5},
                {6}

        };
        boolean numberIn2DArray = new Solution().findNumberIn2DArray(matrix, 6);
        System.out.println(numberIn2DArray);
    }
}