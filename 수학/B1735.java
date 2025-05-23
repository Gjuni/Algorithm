/**
 *  문제 이름 : 분수 합
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 *              두 분수의 합이 주어졌을 때 
 *                  그 합을 기약분수의 형태로 구하는 프로그램
 * 
 *  해    설 : 
 *              분모와 분자의 최대공약수로 나누면 됨
 * 
 *              최대공약수는 유클리드 호재법을 참고하셈
 * 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B1735 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String solve(int top_num, int bottom_num) {
        String answer;

        int num = GCD(top_num, bottom_num);

        answer = top_num/num + " " + bottom_num/num;

        return answer;
    }

    public static int GCD(int top_num, int bottom_num) {

        if(top_num%bottom_num == 0) {
            return bottom_num;
        }

        return GCD(bottom_num, top_num%bottom_num);
    }


    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(input.readLine());
        int C = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());

        int numbertaor_1 = A * D;
        int numbertaor_2 = C * B;

        int top_num = numbertaor_1 + numbertaor_2;

        int bottom_num = B * D;

        output.write((solve(top_num, bottom_num)));

        input.close();
        output.close();
    }
}