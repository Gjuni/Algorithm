
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
    public static int solve(Queue<Integer> q, PriorityQueue<Integer> pq, Queue<Integer> check) {
        int print_cnt = 0;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            int num = q.poll();
            int priority = pq.poll();
            int checking = check.poll();

            if(num == priority) {
                print_cnt++;    
                
                if(checking == 1) {
                    break;
                }
                
            } else {    
                q.offer(num);
                pq.offer(priority);
                check.offer(checking);
            }
        }

        return print_cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(input.readLine());

        for(int i = 0; i < test_case; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int queue_size = Integer.parseInt(token.nextToken());
            int index = Integer.parseInt(token.nextToken());

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> check = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            token = new StringTokenizer(input.readLine());

            for(int t = 0; t < queue_size; t++) {
                int num = Integer.parseInt(token.nextToken());
                q.offer(num);
                pq.offer(num);

                if(index == t) {
                    check.offer(1);
                } else {
                    check.offer(0);
                }
            }

            output.write(String.valueOf(solve(q, pq, check)));
            output.newLine();
        }

        input.close();
        output.close();
    }
}
