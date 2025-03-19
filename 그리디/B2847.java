/**
 *  문제 이름 : 게임을 만든 동준이
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 실수로 레벨이 낮은 점수가 레벨이 어려운 점수보다 높게 측정되었다.
 *             그렇기 때문에 난이도에 주는 레벨을 조절하려고 한다.
 *          
 *             절대로 낮은 레벨의 점수가 높은 레벨의 점수를 추월할 수 없다.
 * 
 *              점수 조정은 -1로 고정이다. 몇 번 줄여야하는지 계산해라.
 * 
 *  해    설 : 밑에서 보지 말고 높은 난이도 순으로 점수를 깎아 내리면 된다.
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

public class B2847 {
    public static int solve(int[] arr) {
        int answer = 0;

        for (int i = arr.length-1; i > 0; i--) {
            while (arr[i] <= arr[i-1]) { 
                arr[i-1] --;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String argc[]) throws  IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        int[] arr = new int[repeat_num];

        for(int i =0; i< repeat_num; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        output.write(String.valueOf(solve(arr)));

        input.close();
        output.close();
    }
}
