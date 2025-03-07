/**
 *  문제 이름 : 한수
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 양의 정수 X의 각 자리가 등차수열을 이룬다면, 한 수 하고 한다.
 *              135를 예를 들면
 *              각 자리가 1 -> 3 -> 5 등차는 2로 커지고 있기 때문에 한수 라고 한다.
 *              
 *              생각해본다면 1의 자리와 10의 자리 수들은 전부 한수 인 셈
 * 
 *  해    설 : 
 * 
 *  시간 복잡도 : O(n^2)
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1065 {
    public static boolean solve(int num) {
        int arr[] = new int[4];

        int index = 0;
        
        if(num == 1000) {
            return false;
        }

        while(num > 0) {
            arr[index++] = num%10;
            num /= 10;
        }

        int dist = arr[0] - arr[1];

        if(arr[1] - arr[2] == dist) {
            return true;
        } else {
            return false;
        }
    }   

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());
        int answer = 0;

        if(num < 100) {
            answer = num;
        } else {
            answer = 99; // 두자리 수까지는 무조건 한수

            for(int i = 100; i<= num; i++) {
                if(solve(i)) {
                    answer++;
                }
                
            }
        }
        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
