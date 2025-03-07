/**
 *  문제 이름 : 제로
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 잘못된 수를 부를 때마다 0을 외침, 가장 최근에 쓴 수를 지우게 시킴
 *              모든 수를 받아 적은 후 그 수의 합을 알고 싶어 함
 * 
 *  해    설 : 0이 나오면 pop 시키면 끝
 *              Stack을 사용하면 된다.
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
import java.util.ArrayDeque;

public class B10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());
        ArrayDeque<Integer> list = new ArrayDeque<>();

        for(int i =0; i< repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            if(num > 0) {
                list.offer(num);
            } else {
                list.pollLast();
            }
        }

        int answer = 0;

        for(int num : list) 
            answer += num;

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
