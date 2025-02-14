/**
 *  문제 번호 : 1003
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 재귀를 사용하지 않고 0과 1이 사용하는 패턴을 파악하면 풀 수 있는 문제
 * 
 *  해    설 :                       0  1
 *              0의 0과 1 사용 갯수 : 1, 0
 *              1의 0과 1 사용 갯수 : 0, 1
 *              2의 0과 1 사용 갯수 : 1, 1
 *              3의 0과 1 사용 갯수 : 1. 2
 *              4의 0과 1 사용 갯수 : 2, 3
 * 
 *          => arr_zero[current] = arr_zero[current-1] + arr_zero[current-2]
 * 
 *  시간 복잡도 : O(n)
 * 
 *  공간 복잡도 : O(2n)
 *    
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1003 {
    static int[] array_zero = new int[41];
    static int[] array_one = new int[41];

    public static void fibo(int start) {
        array_zero[0] = 1;
        array_one[0] = 0;
        array_zero[1] = 0;   
        array_one[1] = 1;

        for(int i = 2; i <= start; i++) {
            if(start > 1 && array_one[start] > 0 && array_zero[start] > 0) {
                break;
            }
            array_one[i] = array_one[i-1] + array_one[i-2];
            array_zero[i] = array_zero[i-1] + array_zero[i-2];
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0; i< repeat_num; i++) {
            int fibo_start_num = Integer.parseInt(input.readLine());

            fibo(fibo_start_num);

            output.write(String.valueOf(array_zero[fibo_start_num])+" "+String.valueOf(array_one[fibo_start_num])+"\n");
        }

        input.close();
        output.close();
    }
}
