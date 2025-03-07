/**
 *  문제 이름 : 수들의 합
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 서로 다른 N개의 자연수의 합을 S라고 함
 *              S를 알 때, 자연수 N의 최댓값은?
 * 
 *  해    설 : 
 *              N개를 많게 즉 더하는 수가 큰 것이 아닌 더하는 갯수가 많아야한다.
 *              그렇다면 1부터 더해가면 되는데
 *              에를 들어 40이라는 숫자는
 *              1 + 2 + 3 + 4 + 5 + 6 + 7 + 9 = 45 이지만 5를 빼면 되는 식으로 나아가면 된다.
 *              즉 40보다 큰 수이거나 같으면 반복문을 멈추고 수를 1개 빼주면 되는 식으로 넘어가면 된다.
 *    
 *              다만 S의 수가 int값을 넘어가기에 long으로 입력을 받아주었다.
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

public class B1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        long num = Long.parseLong(input.readLine());

        int idx = 0;
        long added_num = 0;

        while(added_num <= num) {
            ++idx;
            added_num += idx;
        }

        if(added_num == num) {
            output.write(String.valueOf(idx));
        } else {
            output.write(String.valueOf(idx-1));
        }


        input.close();
        output.close();
    }
}
