/**
 *  문제 이름 : 이상 계수 2
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              자연수 N과 K가 주어진다.
 *              (1 <= N <= 1,000, 0 <= K <= N)
 * 
 *              10007 로 나눈 나머지를 출력
 * 
 *              (N, K) = N! / K!(N-K)!
 * 
 *              1000이라 팩토리얼은 불가능함..
 * 
 *  해    설 : 
 * 
 *              1. N!/K! = for(int i = N; i >= (N-K); i--) answer *= i
 *              2. (N-K)! = for(int i = 1; i <= (N-K); i++) devide *= i
 * 
 *              3. answer / devide
 * 
 *              => 바로 틀림 알고리즘이 틀렸음
 *                  DP로 풀어야하는 듯?
 * 
 *              n C r
 *              n*n 배열을 선언 후 푼다. 1,000 * 1,000
 *              
 *              파스칼 삼각형을 기억하고 풀면됨.
 * 
 *              DP[x][y] = DP[x-1][y-1] + DP[x-1][y] 를 놓고 풀면됨
 *              하지만 y가 0이거나 y가 x와의 값이 같을 경우 1 로 놓는다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B11051 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        long DP[][] = new long[1001][1001];

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        DP[0][0] = 1;
        DP[1][0] = 1;
        DP[1][1] = 1;

        for(int x = 2; x <= 1000; x ++) {
            for(int y = 0; y <= x; y++) {
                if(y == 0 || y == x) {
                    DP[x][y] = 1;
                } else {
                    DP[x][y] = (DP[x-1][y-1] + DP[x-1][y])%10007;
                }
            }   

            if(x == N) {
                break;
            }
        }

        output.write(String.valueOf(DP[N][K]));

        input.close();
        output.close();
    }
}