/**
 *  문제 이름 : 주식
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              1. 주식 하나를 산다.
 *              2. 원하는 만큼 가지고 있는 주식을 판다.
 *              3. 아무것도 안한다.
 * 
 *  해    설 : 
 *              faild solution
 *                  : 처음에는 2번 째 값을 보고 그 전 값과 비교하여 구했다. 
 *                     예를 들어 check = arr[i] - arr[j-1]; 
 * 
 *                      check > 0  : answer += ++stock * check
 *                      check < 0 : stock = 0;
 *                      check == 0 : stock++
 * 
 *                      이렇게 진행하였다. Test Case는 맞지만 3 5 9 일 때 최대의 이익이 되는 경우는 3에서 사고 9에서 파는 경우지만
 *                      내가 짠 코드는 3에서 사서 5에서 팔게 된다는 문제점이 존재했다.
 * 
 *                success solution
 *                   : 두 번째 값이 아닌 마지막 값을 보고 판별하는 것이다. 
 *                      최대 max_stock을 보고 그 이전 값을 보고 max_stock > arr[i] 라면 
 *                      answer += max_stock - arr[i]를 해준 뒤 최대 이윤을 남기는 것
 * 
 *                     만약 max_stock이 arr[i] 보다 크거나 같다면 max_stock을 arr[i]로 갱신해준다.
 * 
 *                  
 *                 문제점 : 답은 부호있는 64bit 정수형으로 표현 가능하다..
 *                          int의 경우 32bit기 때문에 long으로 바꿔서 사용해야한다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


 import java.io.*;
import java.util.StringTokenizer;
 
 public class B11501 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

     public static long solve(long[] arr) {
        long answer = 0;
        long max_stock = 0;

        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] >= max_stock) {
                max_stock = arr[i];
            } else {
                answer += max_stock - arr[i];
            }
        }


        return answer;
     }
     public static void main(String[] args) throws IOException{
         
        int tc = Integer.parseInt(input.readLine());

        for (int i = 0; i < tc; i++) {
            int repeat_num = Integer.parseInt(input.readLine());

            StringTokenizer token = new StringTokenizer(input.readLine());
            long arr[] = new long[repeat_num];

            for (int j = 0; j < repeat_num; j++) {
                arr[j] = Long.parseLong(token.nextToken());
            }
            output.write(String.valueOf(solve(arr))+"\n");
        }

         input.close();
         output.close();
     }
 }