/**
 *  문제 이름 : 한 줄로 서기기
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : N명의 사람이 아침에 한 줄로 선다.
 *              사람들이 자기보다 큰 사람이 왼쪽에 몇 명 있는지만 기억한다.
 *              키는 1 ~ N까지 다양하다.
 * 
 *  해    설 : 
 *              가짜 index를 생성해야한다.
 *              
 *              0 1 2 3 으로 배열이 생긴다면 1 2 3 4 순이면 그의 따른 index는
 *                                        2 1 1 0 으로 주어진다.
 * 
 *              1번이 2번 index에 삽입하게 되면
 *          
 *              0 0 1 0 (new_arr)
 *              0 1   2 (index)
 * 
 *              2번이 1번 index에 삽입하게 되면
 *          
 *              0 2 1 0 (new_arr) 
 *              0     1 (index)
 * 
 *              3번이 1번 index에 삽입하게 되면
 *  
 *              0 2 1 3 (new_arr)
 *              0       (index)
 * 
 *              4번이 0번 index에 삽입하게 되면
 *          
 *              4 2 1 3 (new_arr)
 *              
 * 
 *              이런 식으로 채워지게 된다.
 *              for문의 j값은 arr를 훑으면서 index값을 가져오고 new_arr는 그 index에 맞게 들어가게 된다.
 *              
 *              이때 new_index는 new_arr가 비어있다면 (0이라면) new_index++를 하게 되고 그게 아니라면 증가시키지 않는다.
 *              
 *              new_arr가 0이라면 index와 new_index를 비교해 동일하다면 num을 삽입 후 break를 걸어준다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


 import java.io.*;
import java.util.StringTokenizer;
 
 public class B1138 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{
         int n = Integer.parseInt(input.readLine());

         int[] arr = new int[n];

         StringTokenizer token = new StringTokenizer(input.readLine());

         for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
         }

         int num = 1;
         
         int new_arr[] = new int[n];
         
         for (int i = 0; i < n; i++) {
             int index = arr[i];
             int next_index = 0;

            for(int j = 0; j < n; j++) {
                if((next_index == index) && new_arr[j] == 0) {
                    new_arr[j] = num;
                    break;
                } else if(!(next_index == index) && new_arr[j] == 0) {
                    next_index++;
                }
            }
            num++;
         }

         for(int i =0 ; i< n; i++) {
             output.write(String.valueOf(new_arr[i])+" ");
         }
 
         input.close();
         output.close();
     }
 }