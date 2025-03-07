/**
 *  문제 이름 : 최소 힙
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 우선순위 큐 중 최소 힙 즉 오름차순 정렬렬
 *              x가 0이라면 배열에서 가장 작은 값을 출력
 *              후 그 값 제거
 *              
 *           
 *  해    설 : 자바 Priority 큐에서는 기본 값이 오름차순 정렬렬
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

public class B1927 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> min_q = new PriorityQueue<>();

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0; i< repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            if(num == 0) {
                if(min_q.isEmpty()) {
                    output.write(String.valueOf(0)+"\n"); 
                } else {
                    int result = min_q.poll();
                    output.write(String.valueOf(result)+"\n");
                }
            } else {
                min_q.offer(num);
            }
        }

        input.close();
        output.close();
    }
}
