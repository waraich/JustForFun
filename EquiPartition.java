public class EquiPartition {

    /**
     * Partition an int array in two halves with equal sum and return the index
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {5, 6 };
        int[] B = {2, 4 };

        // System.out.println(falling_disks(A, B));

    }

    public static int equi(int[] A) {
        if (A == null)
            return -1;
        int total = 0;
        for (int a : A) {
            total = total + a;
        }
        int size = A.length;
        int lhsSum = 0;
        for (int i = 0; i < size; i++) {
            if (lhsSum == (total - A[i] - lhsSum)) {
                return i;
            }
            lhsSum = lhsSum + A[i];
        }

        return -1;
    }

}
