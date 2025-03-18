/**
 *  문제 이름 : 링
 * 
 *  난 이  도 : 첫 번째링을 돌렸을 때 나머지 링도 같이 돌아간다는 사실을 발견하였다.
 *              나머지 링은 첫 번째 링보다 빠르거나 느리게 돌아간다.
 *              나머지 링이 몇 바퀴 도는지 확인하는 코드를 작성하라.
 * 
 *  아이디어 : 
 *              첫 번째 링과 나머지 링의 최대 공약수를 구한 뒤 나누준 후 StringBuild에 추가해주었다.
 *              StringBuild는 / 이거 때문에 추가함
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

public class B3036 {
    public static int GCD (int a, int b) {
        int temp = 0;

        while(b > 0) {
            temp = a%b;
            a = b;
            b = temp;
        }

        return a;
    }
    public static StringBuilder solve(int a, int b) {
        StringBuilder string = new StringBuilder();

        int divide = GCD(a, b);

        int result1 = a/divide;
        int result2 = b/divide;
        string.append(result2);
        string.append("/");
        string.append(result1);

        
        return string;
    }
    public static void main(String argc[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int total_num = Integer.parseInt(input.readLine());

        StringTokenizer token = new StringTokenizer(input.readLine());
        int big_wheel = Integer.parseInt(token.nextToken());

        // 최대 공약수를 통해서 나눠 주면 됨
        for(int i = 0; i < total_num-1; i++) {
            int small_wheel = Integer.parseInt(token.nextToken());

            output.write(String.valueOf(solve(small_wheel, big_wheel))+"\n");
        }

        input.close();
        output.close();
    }
}
