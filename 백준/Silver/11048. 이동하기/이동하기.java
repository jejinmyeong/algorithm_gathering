import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y, s;

        Point(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N][M];

        dp[0][0] = map[0][0];

        for (int i = 1 ; i < N ; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        for (int i = 1 ; i < M ; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1 ; i < N ; i++) {
            for (int j = 1 ; j < M ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + map[i][j], Math.max(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]));
            }
        }
        
        System.out.println(dp[N - 1][M - 1]);

    }
}