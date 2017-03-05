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
    
    static void stressTest() {
        Random rand = new Random();
        while (true) {
            int n = rand.nextInt(11) + 2;
            System.out.println(n);
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
              a[i] = rand.nextInt(100000);
            }
            for (int i = 0; i < n; ++i) {
                System.out.println(a[i]);
            }
            
            long res1 = getMaxPairwiseProduct(a);
            long res2 = getMaxPairwiseProductFast(a);
            if (res1 != res2) {
                System.out.println("Wrong answer: " + res1 + " " + res2);
              break;
            }
            else {
                System.out.println("OK");
            }
        }
    }

    public static void main(String[] args) {
        /*FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));*/
        
        //stress test
        stressTest();
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