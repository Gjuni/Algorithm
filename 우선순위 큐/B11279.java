/**
 *  문제 이름 : 최대 힙
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              x에 0이 주어지면 숫자 poll
 *              x에 0이 아닌 다른 수를 주면 push 사용용
 * 
 * 
 *  해    설 : 우선 순위 큐 내림차순하려면 reverseOrder를 사용해야함 
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
import java.util.Collections;
import java.util.PriorityQueue;

public class B11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0; i< repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            if(num == 0) {
                if(max_q.isEmpty()) {
                    output.write(String.valueOf(0)+"\n");
                } else {
                    output.write(String.valueOf(max_q.poll())+"\n");
                }
            } else {
                max_q.offer(num);
            }

        }

        input.close();
        output.close();
    }
}
