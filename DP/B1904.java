/**
 *  문제 이름 : 01타일
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 1 하나만 이루어져있는 타일과 00으로 이루어져있는 타일만 존재
 *            N = 2일때 00, 11만 만들 수 있다. 01, 10 불가능
 * 
 *            N의 길이가 주어졌을 때 2진 수열의 갯수를 구하시오.
 * 
 *  해    설 : 
 *             1 = 1
 *             2 = 2
 *             3 = 3  001 100 111
 *             4 = 5  0011 1100 1001 0000 1111
 *             5 = 8  00001 00100 10000 11001 11100 00111 10011 11111
 *             6 = 13 000000 110000 001100 000011 100001 100100 001001 111100 110011 001111 111111
 *             7 = 21
 *             8 = 34
 *             9 = 55
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B1904 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int DP[];

    public static int solve(int num) {
        if(num == 1)  {
            return 1;
        } else if(num == 2) {
            return 2;
        } 

        DP[1] = 1;
        DP[2] = 2;
        
        for(int i = 3; i <= num; i++) {
            DP[i] = (DP[i-1] + DP[i-2])%15746;
        }
        return DP[num];
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(input.readLine());
        
        DP = new int[num+1];

        output.write(String.valueOf(solve(num)));

        input.close();
        output.close();
    }
}
