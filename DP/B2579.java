/**
 *  문제 이름 : 계단 오르기
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 1. 계단은 1칸 또는 2칸을 오를 수 있다.
 *            2. 연속된 세 개의 계단을 모두 밟아서는 안 된다.
 *            3. 마지막 도착 계단은 반드시 밟아야한다.
 * 
 *  해    설 : 
 *              현재 상태에서 계단 i 에 도착하는 방법은 2가지 1칸을 올라가거나 2칸을 올라가는 방법이다.
 *              
 *              1번째 계단은 반드시 밟아야하기 때문에
 *              
 *              dp[0] = stairs[0];
 *              dp[1] = stairs[0] + stairs[1];
 *              dp[2] = Math.max(stairs[1] + stairs[2], stairs[0] + stairs[2]); // 첫번째를 건너뛰고 두번째, 세번째를 밟을거냐 아님 첫 번째를 밟고 세번째로 건너뛰냐
 * 
 *              계단의 크기가 1이라면 그대로 return 
 *              계단의 크기가 2개라면 stairs[0]과 stairs[1]을 더한 뒤 return 해주면 된다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;

public class B2579 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] stairs;

    static int dp[] = new int[305];

    public static void main(String argc[]) throws IOException {
        int repeat_num = Integer.parseInt(input.readLine());

        stairs = new int[repeat_num];

        for(int i = 0; i < repeat_num; i++) {
            stairs[i] = Integer.parseInt(input.readLine());
        }


        // 계단이 1개 일 때 예외 처리
        if(repeat_num == 1) {
            output.write(String.valueOf(stairs[0]));
            output.close();
            return;
        } else if(repeat_num == 2) {
            output.write(String.valueOf(stairs[0] + stairs[1]));
            output.close();
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];

        if(repeat_num > 2) {
            dp[2] = Math.max(stairs[1] + stairs[2], stairs[0] + stairs[2]);
        }

        /**
            첫 번째 계단을 밟고 세 번째 계단으로 건너 뛰는 경우
            두 번째 계단과 세 번째 계단을 연속으로 밟는 경우
         */

        for(int i = 3; i< repeat_num; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
            
        output.write(String.valueOf(dp[repeat_num-1]));
        input.close();
        output.close();
    }
}
