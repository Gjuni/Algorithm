/**
 *  문제 이름 : 숫자 카드 2
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 내가 가지고 있는 카드 M개와 비교할 카드 N개를 가지고 있다.
 *              이때 배열 N에서 비교할 떄 나는 몇개의 카드를 가지고 있는가?
 * 
 *  해    설 : 그냥 HashMap 써서 O(N)으로 풀었다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

 public class B10816 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

     public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(input.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer token = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(token.nextToken());

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int M = Integer.parseInt(input.readLine());

        int[] count_arr = new int[M];

        token = new StringTokenizer(input.readLine());

        for (int i = 0; i < M; i++) {
            count_arr[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int value = map.getOrDefault(count_arr[i], 0);
           
            output.write(String.valueOf(value));

            if(i < M-1) {
                output.write(' ');
            }
        }

    
         input.close();
         output.close();
     }
 }