/**
 *  문제 번호 : 1463 (1로 만들기)
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 * 
 *  해    설 : 
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

    public static int solve(int num, int answer, int[] dp) {
        /** degenerate Case */
        if(num == 1) {
            return answer;
        }

        if(num%2 == 0) {
            return min(solve(num/2, answer+1, dp), solve(num-1, answer+1, dp));
        }

        if(num%3 == 0) {
            return min(solve(num/3, answer+1, dp), solve(num-1, answer+1, dp));
        }

        return num;
    }

    public static int min(int num1, int num2) {
        return (num1 < num2) ? num1 : num2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(input.readLine());
        int answer = 0;
        dp = new int[5001];

        output.write(String.valueOf(solve(num, answer, dp)));

        input.close();
        output.close();
    }
}
