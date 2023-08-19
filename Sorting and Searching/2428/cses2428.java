import java.io.*;
import java.util.*;

public class cses2428 {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int N = br.nextInt();
        int K = br.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.nextInt();
        }

        int l = 0, r = 0;
        long ans = 0;
        int distinct = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        while (l < N) {
            while (r < N && (distinct + (freq.containsKey(A[r]) ? 0 : 1) <= K)) {
                // Put the new array element in the map.
                if (!freq.containsKey(A[r])) {
                    freq.put(A[r], 1);
                    distinct++;
                } else {
                    freq.put(A[r], freq.get(A[r]) + 1);
                }
                r++;
            }
            // Add the new subarrays.
            ans += (r - l);

            // Slide the window rightwards.
            if (freq.get(A[l]) == 1) {
                distinct--;
                freq.remove(A[l]);
            }
            else {
                freq.put(A[l], freq.get(A[l]) - 1);
            }
            l++;
        }

        System.out.println(ans);

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
