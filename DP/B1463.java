/**
 *  문제 번호 : 1463 (1로 만들기)
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : TOP Down 방식으로 재귀보다는 while문을 통한 풀이
 * 
 *  해    설 : 1은 무조건 빼고 시작한다.
 *              그 후 2로 나눌 수 있다면 나눈 뒤 min값을 취해줌
 *              또는 3으로 나눌 수 있다면 나누고 min 값을 취해준다.
 * 
 *              min값은 answer를 기준으로 한다.
 * 
 *  dp[8]을 예로 들면
 *  dp[7] = answer = 1
 *  dp[4] = answer = 1
 *              dp[7] => dp[6] = answer 2
 *              dp[4] => dp[3] = answer 2
 *              dp[4] => dp[2] = answer 2
 *                      dp[6] => dp[5] = answer 3
 *                      dp[6] => dp[2] = answer 3
 *                      dp[6] => dp[3] = answer 3
 *                      dp[3] => dp[1] = answer 3
 *                      dp[2] => dp[1] = answer 3
 * 
 *      dp[num] = dp[num-1] + 1
 *      dp[num] = dp[num/2] + 1
 *      dp[num] = dp[num/3] + 1
 *      min(dp[num-1], dp[num/2])
 *      min(dp[num-1], dp[num/3]) 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1463 {
    static int[] dp;

    // num = index 값
    // dp[x] = answer 값
    public static int solve(int num, int[] dp) {
        dp[1] = 0;
        
        for(int i = 2; i<= num; i++) {
            dp[i] = dp[i-1] +1; 

            if(i%2 == 0) {
                dp[i] = min(dp[i/2]+1, dp[i]);  
            }

            if(i%3 == 0) {
                dp[i] = min(dp[i/3]+1, dp[i]);  
            }
        }
        return dp[num];
    }

    public static int min(int num1, int num2) {
        return (num1 < num2) ? num1 : num2;
    }   

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(input.readLine()); // input num
            dp = new int[1000001];  

        output.write(String.valueOf(solve(num, dp)));

        input.close();
        output.close();
    }
}
