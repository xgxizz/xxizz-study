import org.junit.Test;

public class Matrix {


    public void findNumberIn2DArray(){
        int num = 20;
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        for (int i = 0; i < matrix.length ; i++) {
            int[] row = matrix[i];
            //if ((row[0]<=num) && (row[row.length-1]>=num)){
                for (int j = 0; j < row.length; j++) {
                    boolean exist = divide(row, 1, row.length - 2, num);
                    System.out.println(exist);
                    int count = 0;
                    if (exist == true)
                        return ;
                    else {
                        count ++;
                        if (count == matrix.length){
                            System.out.println("no");
                        }
                    }
                }
//            }else {
//                return;
//            }
        }
    }

    public static void main(String[] args) {
        new Matrix().findNumberIn2DArray();
    }
    //二分查找
    private boolean divide(int[] row, int start, int end, int num) {
        if (row.length < 1) {
            return false;
        }
            if (row[0] > num) {
                return false;
            }
            if (row[row.length - 1] < num) {
                return false;
            }
            if (start <= end) {
                int mid = (start + end) / 2;
                System.out.println(mid);
                if (row[mid] == num)
                    return true;
                if (row[mid] > num) {
                    return divide(row, start, mid, num);
                }
                if (row[mid] < num) {
                    return divide(row, num + 1, end, num);
                }
                return false;
            } else {
                return false;
            }
        }

}