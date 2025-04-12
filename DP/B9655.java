/**
 *  문제 이름 : 돌 게임
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 탁자 위에 돌 N개가 있다.
 *            2명의 플래이어가 돌을 1개 또는 3개 가져갈 수 있다.
 *            마지막에 돌을 가져가는 사람이 게임을 이긴다.
 * 
 *            두 사람이 완벽하게 게임을 했을 때 이기는 사람을 구하시오. 상근이가 먼저 시작
 *            
 *            상근 : SK
 *            창영 : CY
 * 
 *  해    설 : 
 *              DP[1] = SK
 *              DP[2] = SK
 *              DP[3] = SK
 *              DP[4] = CY
 *              DP[5] = SK
 *              DP[6] = CY
 *              DP[7] = SK
 *              DP[8] = CY
 * 
 *              3 초과의 홀수는 SK가 이김
 *              3 초과의 짝수는 CY가 이김
 * 
 *              1이랑 3일 때는 SK가 2일 때는 CY가 이김
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B9655 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(input.readLine());

        if(num < 4) {
            if(num == 1 || num == 3) {
                output.write("SK");
            } else {
                output.write("CY");
            }
        } else {
            if(num%2 == 0) {
                output.write("CY");
            } else {
                output.write("SK");
            }
        }

        input.close();
        output.close();
    }
}
