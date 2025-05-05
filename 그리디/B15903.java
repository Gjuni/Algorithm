/**
 *  문제 이름 : 카드 합체 놀이
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 
 *              카드 N 장을 가지고 있다.
 *              1. x 번째 카드와 y 번째 카드를 골라 두 장에 쓰여진 수를 더한다.
 *              2. 계산한 값을 x와 y에 덮어씌운다.
 * 
 *              이 것을 m 번 한다. 
 *              가장 작은 점수를 만드는 경우는?
 * 
 *  해    설 : 그리디라고 쓰고 우선순위 큐라고 읽는다.
 *              
 *              x와 y를 가장 작게 만드는 방법은 x와 y가 가장 작은 값으로 더한 후 덮어씌우는 것이다.
 *              우선순위 큐를 사용하여 작은 값을 먼저 뽑고 다시 우선순위 큐에 2개를 삽입해준다.
 * 
 *              끝이다.
 * 
 *              다만 왜 틀렸을까? 라는 생각을 지울 수 없었다.
 *              카드 수의 크기가 다름 아닌 1,000,000 이고 카드의 갯수가 1,000개라면
 * 
 *              1,000,000,000
 *              2,147,483,647 이 될 텐데 여기서 m 번을 반복하니 int값을 훌쩍 넘게 되는 것이다.
 *              즉 Long으로 바꾼 후 정답이 맞게 처리가 되었다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


 import java.io.*;
import java.util.*;
 
 public class B15903 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

     public static long solve(PriorityQueue<Long> card, int m) {
        long answer = 0;

        for (int i = 0; i < m; i++) {
            long card_1 = card.poll();
            long card_2 = card.poll();

            long new_card = card_1+card_2;

            card.add(new_card);
            card.add(new_card);
        }

        for(long num : card) {
            answer += num;
        }

        return answer;
     }
     public static void main(String[] args) throws IOException{
         StringTokenizer token = new StringTokenizer(input.readLine());

         int n = Integer.parseInt(token.nextToken());
         int m = Integer.parseInt(token.nextToken());

         PriorityQueue<Long> card = new PriorityQueue<>();

         token = new StringTokenizer(input.readLine());

         for (int i = 0; i < n; i++) {
            card.add(Long.parseLong(token.nextToken()));
         }
 
         output.write(String.valueOf(solve(card, m)));

         input.close();
         output.close();
     }
 }