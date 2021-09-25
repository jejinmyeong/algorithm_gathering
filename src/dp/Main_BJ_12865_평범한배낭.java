package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭 {
	static class Product {
		int w, v;

		public Product(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Product [] ps = new Product[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			ps[i] = new Product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int [][] dp = new int [N+1][K+1];
		
		for (int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j <=K ; j++) {
				if (j < ps[i].w) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - ps[i].w] + ps[i].v);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}