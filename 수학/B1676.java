/**
 *  문제 이름 : 팩토리얼 0의 개수
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : N!의 0의 갯수를 구하여라
 * 
 *  해    설 : x0이나 x00의 갯수를 세는 줄 알았으나
 *              10은 2와 5로 만들어짐 즉 2나 5의 갯수를 세면 되지만
 *              2는 무조건 5보다 많기 때문에 5의 갯수를 세면 된다.
 *          -> 틀림
 * 
 *              예를 들어 235를 예를 들어보자
 *              틀린 코드에서는 5로 나누어지는지 확인을 한 후 while문으로 5의 갯수를 세게 만들었지만
 *              47에서 47/5 는 결과가 9가 나오게 되기 때문에 정답보다 수가 많이 나오게 된다.
 * 
 *              그래서 while문으로 5의 갯수를 나눈 뒤 그 후에도 5로 나누어떨어지는지 확인 한 후 5의 개수를 세게 만들었다.
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

public class B1676 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());
        int answer = 0;

        for(int i = 1; i<= num; i++) {
            int index = 0;
            int temp = i;

            while (temp >= 5) {
                if(temp %5 == 0) {
                    temp /= 5;
                    index++;
                } else {
                    break;
                }
            }

            answer += index;
        }
        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
