/**
 *  문제 이름 : 회전 초밥
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 초밥을 연속으로 먹는데 가장 많은 종류의 초밥을 먹는 갯수
 * 
 *  해    설 : 
 *              배열을 2개를 선언한다.
 *              초밥이 돌아가는 배열과 그 초밥의 가지수를 저장하는 배열을 선언한다.
 * 
 *              초밥이 돌아가는 배열은 Two Pointer로 움직이면서 확인하고
 *              가지수를 저장하는 배열은 내가 같은 종류의 초밥을 몇 개 먹었는지 확인한다.
 * 
 *              이때 새로운 종류의 초밥을 먹게 되면 가지수를 저장한 배열의 값이 0 -> 1로 변하는데 
 *              이때 가지수 Count +1을 해주고
 * 
 *              만약 start에서 빠지게 되면 가지수를 저장한 배열의 값이 1 -> 0이 되기 때문에
 *              가지수 Count -1을 해주면 된다.
 * 
 *              반대로 같은 종류의 초밥을 2개 이상 먹었다면 빠질 때도 가지수 Count를 변화시킬 필요가 없다.
 * 
 *              쿠폰의 경우 내가 그 종류의 초밥을 먹지 않았다면 쿠폰을 적용하여 가지수 +1을 해주고
 *              만약 그 종류의 초밥을 이미 먹었다면 쿠폰을 적용하지 않게 만든다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;
 
 public class B2531 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solve(int arr[], int[] check, int N, int k, int c) {
        int answer = 0; // 쿠폰 사용
        int real_answer = 0;

        for(int i = 0; i< k; i++) {
            int current_num = arr[i];

            check[current_num]++;

            if(check[current_num] == 1) {
                answer++;
            }
        }

        int start = 0;
        int end = k-1;
        boolean cupon = false;

        while(start < N) {
            if(cupon) {
                answer--;
            }
            cupon = false;


            int current_start = arr[start++];
            --check[current_start];

            if(check[current_start] == 0) {
                answer--;
            }

            end = (end+1)%N;
            int current_end = arr[end];
            ++check[current_end];

            if(check[current_end] == 1) {
                answer++;
            }

            if(!(check[c] > 0)) {
                cupon = true;
            }

            if(cupon) {
                answer++;
            }

            real_answer = Math.max(real_answer, answer);
        }
        

        return real_answer;
    }   

     public static void main(String[] args) throws IOException {
         StringTokenizer token = new StringTokenizer(input.readLine());

         int N = Integer.parseInt(token.nextToken()); // 배열의 크기
         int d = Integer.parseInt(token.nextToken()); // 초밥의 가지 수
         int k = Integer.parseInt(token.nextToken()); // 연속해서 먹는 접시의 수
         int c = Integer.parseInt(token.nextToken()); // 쿠폰 번호
 

        int arr[] = new int[N];
        int check[] = new int[d+1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        output.write(String.valueOf(solve(arr, check, N, k, c)));

        input.close();
        output.close();
     }
 }