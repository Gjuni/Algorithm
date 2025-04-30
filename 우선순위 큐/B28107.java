/**
 *  문제 이름 : 회전초밥
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 회전 초밥 가게에는 N명의 손님이 있고, M 개의 초밥을 순서대로 만든다.
 *              요리사가 초밥을 만들 경우, 1번 손님부터 N번 손님의 순서대로 그 초밥을 받게 된다.
 *              
 *              먼저 초밥을 받는 손님이 초밥을 먹을 경우, 뒤의 손님들은 해당 초밥을 먹을 수 없다. 만약 아무도 초밥을 먹지 않는다면, 초밥은 버려진다.
 * 
 *              N 명의 손님은 각자 먹고 싶은 초밥이 적힌 주문 목록을 가지고 있다.
 *              
 *              목록에 적힌 초밥의 순서에 상관 없이 만약 목록에 적혀있는 초밥이 앞에 오면 반드시 먹는다. 
 *              -> 목록에 적혀있지 않는 초밥을 받는다면 그 초밥은 먹지 않는다.
 * 
 *              손님들은 다양한 초밥을 먹고 싶어하기 때문에 각 종류의 초밥은 최대 한 번만 먹는다.
 *              
 *              각 손님의 주문 목록과 순서대로 만들어지는 M개의 초밥이 주어질 때, 각 손님이 먹게 되는 초밥의 갯수.
 * 
 *  해    설 : 
 *              처음에는 HashMap을 사용하여 사용자가 원하는 초밥을 (초밥값, 손님 ID)로 나눠서 저장하였다. 하지만 5%에서 틀렸다 나왔고
 *              알고리즘을 보니.. 우선순위 큐였다. 왜 우선순위 큐였는지 이해가 안됬지만.
 * 
 *              손님이 원하는 초밥 번호가 존재하고 C0, C1, C2 순서대로 초밥을 먹는다. 하지만 이때 어느 순서대로든 C0가 먼저 먹을게 뻔하니 초밥이 나오는 순서는 상관이 없다.
 *              그렇기 때문에 초밥이 나오는 수도 오름차순으로 정렬한 후.
 *              
 *              손님의 경우 Class를 만들어서 정렬을 시도하였다. (손님 번호, 초밥 번호)로 만든 뒤 compareTo를 활용하여 초밥 순서대로 정렬한 후 초밥 번호가 동일하면 손님 번호를 오름차순으로 정렬시켜
 *              해당 정렬 초밥을 원하는 손님이 먼저 집어먹을 수 있게 만들었다.
 *              
 *              그렇게 해서 
 *                  현재 나오는 초밥 번호 == 손님이 원하는 초밥 번호 라면 '초밥 큐와 손님 큐를 둘 다 poll 시키고 arr[customer_number]++를 증가시켜 초밥을 먹었다고 표기했다'.
 *                  현재 나오는 초밥 번호 > 손님이 원하는 초밥 번호 라면 '그 초밥을 원하는 손님이 없으니 손님의 초밥을 poll 시켜 손님의 초밥 값을 증가시키는 방향으로 만들었다'.
 *                  현재 나오는 초밥 번호 < 손님이 원하는 초밥 번호 라면 '초밥의 값이 작으니 그 초밥을 원하는 손님이 없어 초밥 큐 poll 시켜 초밥의 수를 증가 시켜 손님이 원하는 초밥으로 만들었다'.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

class Customer implements Comparable<Customer> {
    int sushi;
    int cusNum;

    Customer(int sushi, int cusNum) {
        this.sushi = sushi;
        this.cusNum = cusNum;
    }

    @Override
    public int compareTo(Customer customer) {
        if (this.sushi == customer.sushi) {
            return this.cusNum - customer.cusNum;
        }

        return this.sushi - customer.sushi;
    }
}
 
 public class B28107 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        PriorityQueue<Customer> person_q = new PriorityQueue<>();
        PriorityQueue<Integer> sushi_q = new PriorityQueue<>();

        
        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(input.readLine());
            
            int person_repeat_num = Integer.parseInt(token.nextToken());

            for (int j = 0; j < person_repeat_num; j++) {

                int sushi_value = Integer.parseInt(token.nextToken());

                person_q.add(new Customer(sushi_value, i));
            }
        }

        token = new StringTokenizer(input.readLine());

        for (int i = 0; i < M; i++) {
            sushi_q.add(Integer.parseInt(token.nextToken()));
        }

        int[] arr = new int[N+1];

        while(!sushi_q.isEmpty() && !person_q.isEmpty()) {
            Customer q = person_q.peek();
            int sushi = sushi_q.peek();

            int cusNum = q.cusNum;
            int sushiNum = q.sushi;


            if(sushi == sushiNum) {
                arr[cusNum]++;
                sushi_q.poll();
                person_q.poll();
            } else if(sushi < sushiNum) {
                sushi_q.poll();
            } else if(sushi > sushiNum) {
                person_q.poll();
            }
        }

        for(int i =1; i<=N; i++) {
            output.write(String.valueOf(arr[i])+" ");
        }

        input.close();
        output.close();
     }
 }