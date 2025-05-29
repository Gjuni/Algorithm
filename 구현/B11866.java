/**
 *  문제 이름 : 요세푸스 문제 0
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 
 *              K번째 순서대로 사람을 제거하게 되는데
 *              제거되는 순서를 배열로 나타내어라.
 * 
 *  해    설 : 
 *              1, 2, [3], 4, 5, 6, 7 --> 3 제거
 *              1, 2, [3], 4, 5, [6], 7 --> 6 제거(6이 제거된 다음 7이 첫번째가 됨)
 *              1, [2], [3], 4, 5, [6], 7 --> 2 제거
 *              1, [2], [3], 4, 5, [6], [7] --> 7 제거
 *              1, [2], [3], 4, [5], [6], [7] --> 5 제거
 *              [1], [2], [3], 4, [5], [6], [7] --> 1 제거
 *              [1], [2], [3], [4], [5], [6], [7] --> 4 제거
 *              <3, 6, 2, 7, 5, 1, 4> 순열이 요세푸스 순열을 의미한다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

public class B11866 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayDeque<Integer> init_deque = new ArrayDeque<>();
    static Queue<Integer> new_Queue = new ArrayDeque<>();


    static public void solve(int count_num) {
        int index = 0;


        while(!init_deque.isEmpty()) {
            index++;
            
            int current_num = init_deque.poll();

            if(index < count_num) {
                init_deque.addLast(current_num);
            } 

            if(index == count_num) {
                new_Queue.add(current_num);
                index = 0;
            }

        }
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int count_num = Integer.parseInt(token.nextToken());
        int add_count = Integer.parseInt(token.nextToken());

        for (int i = 1; i <= count_num; i++) {
            init_deque.add(i);
        }

        solve(add_count);

        StringBuilder build = new StringBuilder();

        build.append('<');

        for(int i = 0; i < count_num; i++) {
            build.append(new_Queue.poll());

            if(i < count_num-1) {
                build.append(',');
                build.append(' ');
            }
        }

        build.append('>');

        output.write(build.toString());

        input.close();
        output.close();
    }
}