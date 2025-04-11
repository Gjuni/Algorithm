/**
 *  문제 이름 : 2xn 타일링
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램
 * 
 *  해    설 :  2x1 = 1
 *             2x2 = 2
 *             2x3 = 3
 *             2x4 = 5
 *             2x5 = 8
 * 
 *              DP[i] = DP[i-1] + DP[i-2];
 * 
 *              2x1000개의 타일을 채운다..
 *              INT값을 초과할까봐 long으로 타입 변환을 진행했지만 그래도 틀렸다.
 * 
 *              해결법 : DP[i] = (DP[i-1] + DP[i-2])%10007 이렇게 해결했다.
 *                      return DP[num]%10007 로 했더니 DP 계산 시 수가 커지면 그 값이 오버플로우되는 현상이 존재함.
 *                      그렇기 때문에 계산할 때마다 그 값을 나눠줘서 계산해야함.
 *                      
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B11726 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] DP = new int[1001];

    public static int solve(int num) {
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;

        if(num > 3) {
            for(int i = 4; i <= num; i++) {
                DP[i] = (DP[i-1] + DP[i-2])%10007;
            }
        }
        return (DP[num]);
    }

    public static void main(String argc[]) throws IOException{

        int num = Integer.parseInt(input.readLine());

        output.write(String.valueOf(solve(num)));
        input.close();
        output.close();
    }
}
