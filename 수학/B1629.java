/**
 *  문제 이름 : 곱셈
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 자연수 A와 B를 곱함 단 수가 너무 커서 C로 나눔
 *             C로 나눈 나머지 값을 구하라
 *             이때 int_max값 이하의 자연수임임
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
import java.util.StringTokenizer;

public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        

        input.close();
        output.close();
    }
}
