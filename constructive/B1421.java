package constructive;/**
 * ******* Created  on 19/10/20 2:49 AM*******
 */

import java.io.*;
import java.util.*;

public class B1421 implements Runnable {

    private static final int MAX = (int) (1E5 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);

    private void solve() throws IOException {
        int t = 1;
        t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            char[][] inp= new char[n][n];
            for(int i=0;i<n;i++){
                inp[i] = reader.next().toCharArray();
            }
            int c0 = (inp[0][1] =='0')?1:0;
            c0 += (inp[1][0] =='0')?1:0;
            c0 += (inp[n-1][n-2] =='1')?1:0;
            c0 += (inp[n-2][n-1] =='1')?1:0;

            if(c0>=2){
                writer.println(4-c0);
                check(inp, 0,1,'1');
                check(inp, 1,0,'1');
                check(inp, n-1,n-2,'0');
                check(inp, n-2,n-1,'0');
            }else{
                writer.println(c0);
                check(inp, 0,1,'0');
                check(inp, 1,0,'0');
                check(inp, n-1,n-2,'1');
                check(inp, n-2,n-1,'1');
            }
        }
    }

    private void check(char[][] inp, int i, int j, char c) {
        if(inp[i][j]==c){
            writer.println((i+1) +" "+(j+1));
        }
    }

    public static void main(String[] args) throws IOException {
        try (Input reader = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            new B1421().run();
        }
    }

    StandardInput reader;
    PrintWriter writer;

    @Override
    public void run() {
        try {
            reader = new StandardInput();
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    interface Input extends Closeable {
        String next() throws IOException;

        String nextLine() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }

        @Override
        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }

}
