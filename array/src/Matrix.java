import org.junit.Test;

public class Matrix {


    public void findNumberIn2DArray(){
        int num = 23;
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int count = 0;
        for (int i = 0; i < matrix.length ; i++) {
            int[] row = matrix[i];
            boolean exist = divide(row, 0, row.length - 1, num);

            if (exist == true) {
                System.out.println("找到了");
                return;
            }else {
                count ++;
                if (count == matrix.length){
                    System.out.println("no");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Matrix().findNumberIn2DArray();
    }
    //二分查找
    private boolean divide(int[] row, int start, int end, int target) {
        if (row == null || row.length < 1)
            return false;
        if (start <= end) {
            int mid = (start + end) / 2;
            //System.out.println(mid);
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

    @Test
    public void find(){
        int[] row = {5,6};
        boolean flag = divide(row, 0, row.length-1, 6);
        System.out.println(flag);
    }

}