/**
 *  문제 이름 : 두수의 합
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 자연수들이 주어졌을 때 수열 ai + aj = x를 만족하는
 *              (ai, aj)를 구하여라
 * 
 *  해    설 : 두수의 합을 정렬 시켜
 *              작은 갑 부터 큰 값을 예측할 수 있게 만든다.
 *              두 수의 값이 x의 값보다 작다면 start 값을 크게 만들고
 *              두 수의 값이 x의 값보다 크다면 end 값을 줄여 x 값에 근접하게 만든다.
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
 
public class B3272 {
    public static int solve(int[] arr, int want_num) {

        int answer = 0;
        int start = 0;
        int end = arr.length-1;

        int result;

        while(start < end) {
            result = arr[start] + arr[end];

            if(result == want_num) {
                answer++;
                start++;
                end --;
            } else if(result < want_num) {
                start++;
            } else {
                end--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num_count = Integer.parseInt(input.readLine());

        int arr[] = new int[num_count];

        StringTokenizer token = new StringTokenizer(input.readLine());

        for(int i =0; i< num_count; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int want_num = Integer.parseInt(input.readLine());

        Arrays.sort(arr);
        output.write(String.valueOf(solve(arr, want_num)));

        input.close();
        output.close();
    }    
}
