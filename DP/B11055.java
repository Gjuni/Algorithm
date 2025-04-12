/**
 *  문제 이름 : 가장 큰  증가하는 부분 수열
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하시오
 * 
 *            즉 전조증가하되 연속되야하며 합이 가장 큰 값을 고르는 문제이다.
 * 
 *            예를 들어 A = { 1, 100, 2, 50, 60} 일 때
 *            answer 값을 1 + 100 으로 하게 되면 이후 값들이 전조 증가가 아니기에 합이 이게 끝이 된다. 
 *            하지만 100을 건너 뛰게 되면 113으로 값이 가장 크게 된다.
 * 
 *            이렇게 만들 수 있는 수 중에서 가장 합이 큰 수를 구하는 것이 이 문제의 목적이다.
 * 
 *  해    설 : 시발 모르겠다
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B11055 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = 0;
    static int[] DP;
    static int[] arry;
    static int index = 0;

    public static int solve(int answer) {
        for(int i = 0; i< arry.length; i++) {
            DP[i] = arry[i];

            for(int j = 1; j < arry.length; j++) { 
                if(arry[i] < arry[j]) {
                    DP[i] = Math.max(DP[i], DP[i] + arry[j]);
                    answer = DP[i];
                }
            }
        }

        return answer;
    }


    public static void main(String argc[]) throws IOException {
        int repeat_num = Integer.parseInt(input.readLine());
        DP = new int[repeat_num];
        arry = new int[repeat_num];
        index = repeat_num-1;


        StringTokenizer token = new StringTokenizer(input.readLine());
        
        for (int i = 0; i < repeat_num; i++) {
            int insert_num = Integer.parseInt(token.nextToken());

            arry[i] = insert_num;
        }

        output.write(String.valueOf(solve(0)));

        input.close();
        output.close();
    }
}