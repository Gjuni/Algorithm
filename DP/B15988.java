/**
 *  문제 이름 : 1, 2, 3 더하기 3
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램
 *            단 최대 1000000 의 값이 들어가며
 *            1000000009로 나눈 나머지를 출력함.
 * 
 *  해    설 : 
 *              DP[1] = 1
 *              DP[2] = 2
 *              DP[3] = 4
 *              DP[4] = 7
 *              DP[5] = 12
 * 
 *              미리 num을 계산하는 것이 아닌.
 *              Memoization을 사용하여 미리 1000000을 계산 후 num이 들어오면 index값만큼 삽입하여 결과를 출력한다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;

public class B15988 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] DP = new long[1000001];

    public static void solve() {
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            DP[i] = (DP[i-1] + DP[i-2] + DP[i-3])%1000000009;
        }
    }   

    public static void main(String[] args) throws IOException{
        int repeat_num = Integer.parseInt(input.readLine());

        solve();

        for (int i = 0; i < repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            output.write(String.valueOf(DP[num])+"\n");
        }
        
        input.close();
        output.close();
    }
}