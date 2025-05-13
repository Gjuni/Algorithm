/**
 *  문제 이름 : 겹치는 건 싫어
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 
 *             수열에 같은 원소가 여러 개 들어있는 수열을 싫어한다.
 *              K개 이하로 들어있는 최장 연속 부분 수열의 길이를 구하려고 한다.
 * 
 *  해    설 : 
 *              O(n^2)으로 시초가 떴다...
 *              그렇기 때문에 e의 경우 for문을 사용하여 배열 끝까지 이동하게 만들었고
 *              만약에 arr[index_arr[e]] 가 K(나타나야하는 수)보다 많다면 s값을 움직이게 만들어
 * 
 *              O(n) 으로 마무리가 되었다..
 *              GPT를 썼기 떄문에 좀 더 생각의 확장이 필요해보인다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


 import java.io.*;
import java.util.StringTokenizer;
 
 public class B20922 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solve(int[] arr, int[] index_arr, int K) {
        int answer = 0;
        int s = 0;
        int[] count = new int[200001];

        for(int e = 0; e< arr.length; e++) {
            int index = arr[e];
            count[index]++;

            while(count[index] > K) {
                int new_index = arr[s];

                count[new_index]--;

                if(s == arr.length-1) {
                   break;
                }
                s++;
            }
            
                if(s == arr.length-1) {
                   break;
                }

            answer = Math.max(answer, e - s +1);

        }
        
        return answer;
    }

     public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(input.readLine());
        
        int N = Integer.parseInt(token.nextToken());

        int K = Integer.parseInt(token.nextToken());

        int arr[] = new int[N];
        int index_arr[] = new int[200001];

        token = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        output.write(String.valueOf(solve(arr, index_arr, K)));
 
         input.close();
         output.close();
     }
 }