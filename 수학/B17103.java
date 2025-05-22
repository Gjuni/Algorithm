/**
 *  문제 이름 : 골드바흐 파티션
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              골드바흐의 추측 : 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
 *              
 *              짝수 N을 두 소수의 합으로 나타내는 표현을 골드하브 파티션이라고 한다.
 *              짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자.
 * 
 *              두 소수의 순서만 다른 것은 같은 파티션이다.
 * 
 *              tc = 100,
 *              N = 1,000,000
 * 
 *  해    설 : 
 * 
 *              에라스토테네스의 체를 이용하여 소수를 미리 구해놓는다.
 *              
 *              이후 Two Pointer를 사용하여 소수의 갯수들을 구하게 되는데
 *              while()을 돌려서 start <= end 까지 돌리는데
 *          
 *              primary_arr에서 true일 경우 소수가 아니기 때문에 while(primary_arr[start] == true || primary_arr[end] == true)를 하여
 *              true값을 전부 넘긴 이후 소수의 합을 갯수를 파악하게 만든다.
 * 
 *              만약 ( start + end < N ) 일 경우 start 값을 증가시키고
 *                   ( start + end > N ) 일 경우 end 값을 감소시킨다.
 *                   ( start + end == N ) 인 경우 start 값을 증가시키고 answer를 증가시킨다.
 * 
 *                  O(n)으로 끝내야하기 때문에 (정수론 공부)
 *                      start + end 값이 N과 같을 때 
 *                          start 값이 증가해야 N보다 커지기 때문에
 *                              end 값을 다시 start +1 값으로 옮길 필요가 없기 떄문이다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B17103 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] primary_arr = new boolean[1000001];

    public static void primary_count() {
        for(int i = 2; i < 1000000/2; i++) {
            for(int j = i*2; j < 1000000; j += i) {
                primary_arr[j] = true; 
            }
        }
    }

    public static int solve(int t) {
        int answer = 0;
        int start = 2;
        int end = 1000000;

        while (start <= end) { 
            while(primary_arr[start] == true || primary_arr[end] == true) {
                if(primary_arr[start] == true || primary_arr[end] == true) {
                    if(primary_arr[start] == true) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            if((start + end) == t) {
                answer++;
                start++;
            } else if((start+end) < t) {
                start++;
            } else if((start + end) > t) {
                end--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(input.readLine());

        primary_count();

        for (int i = 0; i < tc; i++) {
            int t = Integer.parseInt(input.readLine());

            output.write(String.valueOf(solve(t))+"\n");
        }

        input.close();
        output.close();
    }
}