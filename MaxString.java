import java.util.HashSet;
import java.util.Set;

public class MaxString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(max_prefix_suffix("abcdh"));

    }

    /**
     * Find the proper nesting of brackets
     * @param S
     * @return
     */
    public static int nesting(String S) {

        if (S == null)
            return 1;
        int count = 0;
        int size = S.length();
        for (int i = 0; i < size; i++) {
            if (S.charAt(i) == '(')
                count++;
            else if (S.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return 0;
                }
            }
        }
        if (count != 0) {
            return 0;
        } else {
            return 1;
        }

    }

    /**
     * Max string with is both a proper prefix of string S and a proper prefix of 
     * String S
     * @param S
     * @return
     */
    public static int max_prefix_suffix(String S) {

        if (S == null)
            return -1;
        Set<String> set = new HashSet<String>();
        int len = S.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            builder.append(S.charAt(i));
            set.add(builder.toString());
        }
        int max = 0;
        for (int i = 1; i < len; i++) {
            String suffix = S.substring(i, len);
            if (set.contains(suffix)) {
                int suffLen = suffix.length();
                if (suffLen > max)
                    max = suffLen;
            }
        }

        return max;
    }
}
