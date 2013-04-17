
public class LagestIncreasingSubsequnce {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int A[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println(longest(A));

    }

    /**
     * let L[j] be the largest non-contiguous subsequence that ends at j , so by defination
     * L[j]=L[i]+i , for some i<j and A[i]<A[j]
     * so L[j]=max(L(i) for all i<j )+1. Looping from j=0 to j=A.length and return L[j]
     * 
     * @param A
     * @return
     */
    public static int longest(int[] A) {
        if (A == null)
            return 0;
        int len = A.length;
        int[] L = new int[len];
        L[0] = 1;
        for (int j = 0; j < len; j++) {
            int maxn = 0;
            for (int i = 0; i < j; i++) {
                if (A[i] < A[j] && L[i] > maxn) {
                    maxn = L[i];
                }

            }
            L[j] = maxn + 1;
        }
        int max = 0;
        for (int l : L) {
            if (l > max)
                max = l;
        }
        return max;
    }

}
