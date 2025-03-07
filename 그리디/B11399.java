/**
 *  문제 이름 : ATM
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : ATM 돈을 뽑은 시간을 최소화한 시간을 출력해라라
 * 
 *  해    설 : 배열을 선언 한 후 정렬을 시도한다. 작은 수가 반복해서 더해지는 것이 이득이기 때문이다.
 *              그 후 index 1번 부터 시작하여 이전 수를 더해 나가면서 각 걸리는 시간을 누적으로 더한다.
 *              마무리로 총 걸리는 시간을 더해 출력해준다.
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

public class B11399 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        int[] array = new int[num];
        StringTokenizer token = new StringTokenizer(input.readLine());

        for(int i =0; i< num; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        for(int i =1; i < num; i++) {
            array[i] += array[i-1];
        }

        int answer = 0;

        for(int i =0; i< num; i++) {
            answer += array[i];
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
