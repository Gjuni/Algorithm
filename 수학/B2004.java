/**
 *  문제 이름 : 조합 0의 개수
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              (n , m)의 끝자리 0의 개수를 출력
 *  
 *              n, m (0 <= m <= n <= 2,000,000,000)이 들어온다.
 *                                   2,147,483,647 int로 가능
 * 
 *  해    설 : 
 *              5와 2의 갯수를 구한 후 그 갯수가 적은 것을 고르면 된다.
 *              
 *              10의 경우 5와 2의 모임이기 때문에 0이 반드시 생긴다.
 *              
 *              nCr의 경우
 *                  n! / (m! * (n-m)!) 이기 때문에
 *          
 *                  5와 2의 승수 값을 구한 후
 *                  5를 예로 들면 n - m - (n-m) 의 승수를 구하면 된다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B2004 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int five_count(int num) {
        int count = 0;

        while(num > 4) {
            count += num/5;
            num /= 5;
        }

        return count;
    }

    public static int two_count(int num) {
        int count = 0;

        while(num > 1) {
            count += num/2;
            num /= 2;
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int five = five_count(n) - five_count(m) - five_count(n-m);
        int two = two_count(n) - two_count(m) - two_count(n-m);

        output.write(String.valueOf(Math.min(five, two)));

        input.close();
        output.close();
    }
}
