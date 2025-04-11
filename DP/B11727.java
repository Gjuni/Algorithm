/**
 *  문제 이름 : 2xn 타일링 2
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 1x2, 2x1, 2x2 타일로 채우는 방법의 수
 * 
 *  해    설 : 
 *             2x1 = 1
 *             2x2 = 3
 *             2x3 = 5
 *             2x4 = 11
 *             2x5 = 21
 * 
 *             DP[i] = DP[i-1] + 2*DP[i-2]
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;

public class B11727 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] DP = new int[1001];

    public static int solve(int num) {
        DP[1] = 1;
        DP[2] = 3;
        DP[3] = 5;

        if(num > 3) {
            for(int i = 4; i <= num; i++) {
                DP[i] = (DP[i-1] + 2*DP[i-2])%10007;
            }
        }
        return DP[num]; 
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(input.readLine());

        output.write(String.valueOf(solve(num)));

        input.close();
        output.close();
    }
}