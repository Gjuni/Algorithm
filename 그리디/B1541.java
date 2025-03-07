/**
 *  문제 이름 : 잃어버린 괄호
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 양수와 +, -, () 를 가지고 식을 만들었다.    
 *              ()를 쳐서 식의 값을 최소가 되게 만들어야한다.
 * 
 *  해    설 : - 기준으로 파싱 한 후 그 안에 + 요소들을 더해주면 구할 수 있다.
 * 
 *              예를 들어 50-20+50+80
 *                  일반적으로 계산하면 양수 값인 160이 나오지만
 *                  -를 파싱하여 나타내면 50-(20+50+80) 이런식으로 계산하면
 *                  -100 이 나오는 결과가 나오게 된다.
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

public class B1541 {
    public static int solve(String plus_string) {

        String arr[] = plus_string.split("\\+");

        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            result += Integer.parseInt(arr[i]);
        }
        return result;
    }   

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = input.readLine();

        String[] array = string.split("\\-");

        int answer = 0;

        for(int i = 0; i < array.length; i++) {
            int temp = solve(array[i]);

            if(i > 0) {
                answer -= temp;
            } else {
                answer += temp;
            }
        }
        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
