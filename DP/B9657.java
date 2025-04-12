/**
 *  문제 이름 : 돌 게임 3
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 돌을 가져가며 1,3,4 개씩 가져갈 수 있다.
 *            SK부터 시작한다.
 * 
 *  해    설 : 
 *              DP[i] = DP[i-1] + DP[i-3] + DP[i-4] 가 3이하라면 SK가 이기고
 *              아니라면 CY가 이긴다...
 * 
 *              질문게시판을 참고하고 직접 세어보고 풀었다...
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B9657 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException{

        int num = Integer.parseInt(input.readLine());

        int[] DP = new int[1002];

        DP[1] = 1;
        DP[2] = 0;
        DP[3] = 1;
        DP[4] = 1;
        DP[5] = 1;
        DP[6] = 1;

        if(num >= 7) {
            for(int i = 7; i <= num; i++) {
                if(DP[i-1] + DP[i-3] + DP[i-4] < 3) {
                    DP[i] = 1;
                } else {
                    DP[i] = 0;
                }
            }
        }

        if(DP[num] == 1) {
            output.write("SK");
        } else {
            output.write("CY");
        }

        input.close();
        output.close();
    }
}
