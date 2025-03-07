/**
 *  문제 이름 : 요세푸스 문제
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : K, N이 주어질 때 K번째   사람을 제거한다
 *            한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 게속한다.
 * 
 *  해    설 : (7,3)을 예로 들면
 *              <1,2,3,4,5,6,7>
 *              -> <3> [1,2,4,5,6,7]
 *              -> <3, 6> [1,2,4,5,7]
 *              -> <3, 6, 2> [1,4,5,7]
 *              -> <3, 6, 2, 7> [1,4,5]
 *              -> <3, 6, 2, 7, 5> [1,4]
 *              -> <3, 6, 2, 7, 5, 1> [4]
 *              -> <3, 6, 2, 7, 5, 1, 4>
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
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int input_num = Integer.parseInt(token.nextToken());
        int repeat_count = Integer.parseInt(token.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i =1; i<= input_num; i++) {
            q.offer(i);
        }

        int index = 1;
        while (!q.isEmpty()) {
            int pop = q.poll();

            if(index == repeat_count) {
                answer.add(pop);    
                index = 0;
            } else {
                q.offer(pop);
            }
            index++;
        }

        index = 0;
        output.write("<");
        for(int num : answer) {

            output.write(String.valueOf(num));        
            if(index < answer.size()-1) {
                output.write(", ");
            }
            index++;
        }
        output.write(">");


        input.close();
        output.close();
    }
}
