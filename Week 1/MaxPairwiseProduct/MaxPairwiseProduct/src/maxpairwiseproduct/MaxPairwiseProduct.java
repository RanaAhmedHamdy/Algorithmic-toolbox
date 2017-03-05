import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * numbers[j] > result) {
                    //multiplication should be forced to use long arthimetic, onlu casting result to long is not enough
                    result = (long)numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
    
    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        int firstmax = 0;
        int secondmax = 0;
        
        for (int i = 0; i < n; ++i) {
            if(firstmax < numbers[i]) {
                secondmax = firstmax;
                firstmax = numbers[i];
            } else if(secondmax < numbers[i]) {
                secondmax = numbers[i];
            }
        }
        
        result = (long)firstmax * secondmax;
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
         System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}