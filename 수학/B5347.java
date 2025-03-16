/**
 *  문제 이름 : LCM
 * 
 *  난 이  도 : 최소 공배수를 구하시오.
 * 
 *  아이디어 : 백만... 오버플로우에서 틀린 것이다.
 * 
 *              최대 공약수는 answer = (a*b)/GCD(a,b)이다.
 *              이때 OverFlow 때문에 a와 GCD를 먼저 나눠주고 b를 곱해주어 OverFlow를 막았다.
 * 
 *              GCD는 B9613을 사용하도록 하자.
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
 
 public class B5347 {
    public static int GCD(int a, int b) {
        while (b > 0) {  
            int temp = a%b;   

            a = b;
            b = temp;
        }

        return a;
    }

    public static long solve(int a, int b) {
        long answer = (long) a/GCD(a, b) * b;

        return answer;
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        for(int i =0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            int temp_a = a > b ? a : b; // a가 큰수
            int temp_b = a > b ? b : a;

            output.write(String.valueOf(solve(temp_a, temp_b))+"\n");
        }

        input.close();
        output.close();
    }
}