/**
 *  문제 이름 : 절댓값 힙
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 음수의 숫자는 음수 큐에 삽입하고
 *             양수의 숫자는 양수 큐에 삽입
 * 
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
import java.util.PriorityQueue;


public class B11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> plus_q = new PriorityQueue<>();
        PriorityQueue<Integer> minus_q = new PriorityQueue<>();

        for(int i = 0; i < repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            if(num == 0) {
                
            } else if(num < 0) {
                num *= -1;
                minus_q.offer(num);
            } else {
                plus_q.offer(num);
            }
        }

        input.close();
        output.close();
    }
}
