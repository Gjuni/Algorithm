/**
 *  문제 이름 : 수들의 합 2
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : N개의 수로 된 수열 A[N]이 존재한다. 
 *              A[i]부터 A[j]까지 합이 M이 되는 경우의 수를 구하는 프로그램을 작성하라
 * 
 *  해    설 : 존나 오래 걸린 문제다.
 *              투 포인터를 오랜만에 해서 그런가..
 * 
 *              암튼 temp값은 현재 더해진 값들
 *                  start는 시작 점
 *                  end는 달리는 점이다.
 * 
 *                  여기서 만약 temp가 목표 수에 도달하지 않았다면 end값을 먼저 ++ 해준 뒤 더해준다. (temp < wants_num)
 *                  temp가 목표 수보다 크다면? start값을 빼준 뒤 start++를 해준다. (temp < wants_num)
 * 
 *                  같을 때에서 로직이 꼬인 것 같다.
 *                  만약 시작했을 때 이미 목표 수에 도달 했다면 end가 start보다 뒤에 있을 때가 존재한다.
 *                  그것을 방지하기 위해 
 *                  목표 수에 도달을 하였다면 정답(answer++)를 증가시킨 뒤 start값을 증가 시켜주고 (start++)
 *                  temp값을 증가된 start값으로 초기화 시켜주면서 end도 start 지점으로 땡겨오게 만들었다.
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

public class B2003 {
    public static int solve(int[] arr, int wants_num) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int temp = arr[0];

        while(end < arr.length) {
            if(temp < wants_num) {
                if(end+1 < arr.length)
                    temp += arr[++end];
                else
                    break;
            } else if(temp > wants_num) {
                temp -= arr[start++];
            } else {
                answer++;
                
                if(start+1 < arr.length) { 
                    start++;
                    end = start;
                } else {
                    break;
                }
                temp = arr[start];
            }
        }
        return answer;
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int arr_lenght = Integer.parseInt(token.nextToken());
        int wants_num = Integer.parseInt(token.nextToken());

        int arr[] = new int[arr_lenght];

        token = new StringTokenizer(input.readLine());

        for(int i =0; i< arr_lenght; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        output.write(String.valueOf(solve(arr, wants_num)));

        input.close();
        output.close();
    }
}
