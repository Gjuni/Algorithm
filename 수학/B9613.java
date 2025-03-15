/**
 *  문제 이름 : GCD 합
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성
 *              GCD는 최대 공약수이다.
 * 
 *  해    설 : 유클리드 호재법을 이욯하여 풀었다.
 * 
 *              예를 들어) 2009와 246의 최대 공약수를 구하라고 함은
 *                      2009%246 = 8 ... 41이다.
 *                      246%41 = 6 ... 0
 * 
 *                      즉 A와 B가 존재할 때    
 *                      A는 B값으로 대체
 *                      B는 A%B (나머지 값) 으로 수식을 세워 푼다면 풀린다.
 *  
 *                      재귀식으로 세웠으나 60%에서 틀렸다고 뜨길래 While으로 바꿔서 풀었더니 맞았다...
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
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9613 {
    // public static int GCD(int a, int b) {
    //     if (b == 0) {
    //         return a;
    //     }
    //     return GCD(b, a%b);
    // }

    public static long GCD(long a, long b) {
        while(b > 0) {
            long temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static long solve(int[] arr) {
        long answer = 0;

        for (int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                answer += GCD(arr[i], arr[j]);
            }
        }

        return answer;
    }

    public static void main(String argc[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());
            
            int total_num = Integer.parseInt(token.nextToken());

            int arr[] = new int[total_num];

            for(int j = 0; j < total_num; j++) {
                arr[j] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(arr);
            output.write(String.valueOf(solve(arr))+"\n");
        }


        

        input.close();
        output.close();
    }
}
