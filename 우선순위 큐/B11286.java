/**
 *  문제 이름 : 절댓값 힙
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 음수의 숫자는 음수 큐에 삽입하고
 *             양수의 숫자는 양수 큐에 삽입
 * 
 *  해    설 : plus큐와 minus 큐가 비어있다면 0을 출력
 *              하지만 plus큐과 minus큐 둘 중 하나라도 비어있다면 존재하는 수를 출력
 *              둘 다 비어있지 않으면 그 중 작은 수를 비교하여 출력
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
    public static void solve(PriorityQueue<Integer> plus_q, PriorityQueue<Integer> minus_q, BufferedWriter output) throws IOException{
        if(plus_q.isEmpty() && minus_q.isEmpty()) {
            output.write(0+"\n");
            return;
        }

        if(plus_q.isEmpty()) {
            output.write(String.valueOf(-minus_q.poll())+"\n");
            return;
        }

        if(minus_q.isEmpty()) {
            output.write(String.valueOf(plus_q.poll())+"\n");
            return;
        }

        int plus_num = plus_q.peek();
        int minus_num = minus_q.peek();

        if(plus_num >= minus_num) {
            output.write(-minus_q.poll()+"\n");
        } else if(plus_num < minus_num ){
            output.write(plus_q.poll()+"\n");
        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> plus_q = new PriorityQueue<>();
        PriorityQueue<Integer> minus_q = new PriorityQueue<>();

        for(int i = 0; i < repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            if(num == 0) {
                solve(plus_q, minus_q, output);
            } else if(num < 0) {
                minus_q.offer(-num);
            } else {
                plus_q.offer(num);
            }
        }

        input.close();
        output.close();
    }
}
