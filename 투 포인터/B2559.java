/**
 *  문제 이름 : 수열
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 연속적인 며칠 동안의 온도의 합이 가낭 큰 값을 알아보자
 * 
 *  해    설 : 
 *              슬라이딩 윈도우 문제
 *              초기 temp 값을 연속된 일수 만큼 지정한 뒤
 *              첫 temp 값을 max_temp 값에 저장 시킨다 (초기 일수들이 max 값일 수 있기 때문)
 * 
 *              그 다음 end값을 증가 시킨 후 temp값에 더해주고 
 *              start값은 temp에서 빼준 후 start값을 증가 시켜준다.
 * 
 *              그 후 max_temp와 temp값을 비교함
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

public class B2559 {
    public static int solve(int arr[], int sequence_day) {
        int temp = 0;
        
        // 초기 값 설정
        for(int i =0; i< sequence_day; i++) {
            temp += arr[i];
        }
        
        int max_temp = temp;
        int start = 0;
        int end = sequence_day-1;
        
        while(end < arr.length-1) {
            temp += arr[++end];
            temp -= arr[start++];
            
            if(temp > max_temp) {
                max_temp = temp;
            }
        }
        return max_temp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int total_days = Integer.parseInt(token.nextToken());
        int sequence_day = Integer.parseInt(token.nextToken());

        int arr[] = new int[total_days];

        token = new StringTokenizer(input.readLine());

        for(int i =0; i< total_days; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        output.write(String.valueOf(solve(arr, sequence_day)));

        input.close();
        output.close();
    }
}
