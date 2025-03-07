/**
 *  문제 이름 : 카드 2
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 1부터 N까지의 번호가 붙어있는 카드가 존재한다.
 *              이때 1이 제일 위에 있고 N이 제일 밑에 존재한다.
 * 
 *             1. 제일 위에 있는 카드를 바닥에 버린다.
 *             2. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 
 *              제일 마지막에 남는 카드를 구하는 프로그램을 작성하시오.
 * 
 *  해    설 : index를 기준으로 홀수이면 q.poll으로 원소를 빼고
 *              index가 짝수라면 다시 q에 삽입해준다.
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
import java.util.Queue;

public class B2164 {
    public static int solve(int number_card, Queue<Integer> q) {
        int answer = 0;
        int index = 1;

        while(q.size() > 1) {
            int current_num = q.poll();

            if(index%2== 1) {
                
            } else if(index%2 ==0) {
                q.add(current_num);
            }

            index++;
        }

        answer = q.poll();

        return answer;
    }   

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int number_card = Integer.parseInt(input.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for(int i =1; i<= number_card; i++) {
            q.add(i);
        }

        output.write(String.valueOf(solve(number_card, q)));

        input.close();
        output.close();
    }
}
