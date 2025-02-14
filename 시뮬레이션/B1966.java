
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class B1966 {
    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());


        for(int i =0; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            Queue<Integer> original_q = new ArrayDeque<>();
            Queue<Integer> index_q = new ArrayDeque<>();
            PriorityQueue<Integer> sorted_q = new PriorityQueue<>(Collections.reverseOrder());

            int array_len = Integer.parseInt(token.nextToken());
            int select_num = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(input.readLine());


            for(int d =0; d < array_len; d++) {
                int input_num = Integer.parseInt(token.nextToken());

                original_q.offer(input_num);
                sorted_q.offer(input_num);
                
                if(d == select_num) {
                    index_q.offer(1);
                } else {
                    index_q.offer(0);
                }
            }

            int outCount = 0;

            while(!original_q.isEmpty()) {
                int check_num = original_q.poll();
                int sorted_num = sorted_q.peek();
                int index = index_q.poll();

                if(check_num == sorted_num && index == 1) {
                    outCount++;
                    output.write(String.valueOf(outCount)+"\n");
                    break;
                } else if(check_num == sorted_num && index == 0) {
                    outCount++;
                    sorted_q.poll();
                } else if(check_num != sorted_num) {
                    original_q.offer(check_num);
                    index_q.offer(index);
                }
            }
        }

        input.close();
        output.close();
    }
}
