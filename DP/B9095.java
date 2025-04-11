/**
 *  문제 이름 : 1,2,3 더하기
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 정수를 1,2,3의 합으로 나타내는 가시의 수를 계산하라
 *            수를 1개 이상 사용해야한다. (1개도 가능)
 * 
 *  해    설 : 
 *                  n = 1 count = 1
 *                  n = 2 count = 2 
 *                  n = 3 count = 4 
 *                  n = 4 count = 7 
 *                  n = 5 count = 13 
 *                  n = 6 count = 24               
 *                  n = 7 count = 44 
 * 
 *                  이렇게 보니... 규칙이 보인다. (시발 해설을 보고 20분 동안 지랄해서 얻었다.)
 *                  결국 DP[i] = DP[i-1] + DP[i-2] + DP[i-3] 이 된다.
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;

public class B9095 {
    public static int[] DP = new int[12];

    public static int solve(int num) {
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        if(num > 3) {
            for(int i = 4; i<= num; i++) {
                DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
            }
        }

        return DP[num];
    }


    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(input.readLine());

        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(input.readLine());

            int answer = solve(num);

            output.write(String.valueOf(answer)+'\n');
        }

        input.close();
        output.close();
    }
}
