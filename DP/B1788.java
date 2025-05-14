/**
 *  문제 이름 : 피보나치 수의 확장
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 *              피보나치 수는 섬화식과 같이 귀납적으로 정의되는 수열이다.
 *              F(n)은 0 이상의 n에 대해서만 정의된다.
 * 
 *              하지만 피보나치 수 F(n)을 n이 음수인 경우로도 확장시킬 수 있다.
 *              n > 1에서만 성립하던 피보나치를 n <= 1 일때도 성립이 가능하게 정의하는 것이다.
 *          
 *              F(n) = F(n-1) + F(n-2)
 *              F(1) = F(0) + F(-1)이 성립되려면 
 *                  F(1) = 1
 *                  F(0) = 0 이므로 F(-1) = 1이 된다.
 * 
 *              절댓값은 1,000,000을 넘지 않는 정수이다.
 * 
 *  해    설 :   F(n) = F(n-1) + F(n-2)
 *              F(0) = F(-1) + F(-2) : 0 = 1 + (-1) : <F(-2) = -1>
 *              F(-1) = F(-2) + F(-3) : 1 = -1 + (2) : <F(-3) = 2>
 *              F(-2) = F(-3) + F(-4) : -1 = 2 + (-3) : <F(-4) = -3>
 *              F(-3) = F(-4) + F(-5) : 2 = -3 + (5) : <F(-5) = 5>
 *              F(-4) = F(-5) + F(-6) : -3 = 5 + (-8) : <F(-6) = -8>
 *              
 *              F(n-2) = F(n-1) - F(n)
 * 
 *              홀수는 양수
 *              짝수는 음수
 *              
 *              indexOutOfBound... 쉬발
 *                  Math.abs 사용하니 IndexOutOfBound가 해결이 되었다...
 * 
 *                  if(num < 0) num *= -1일 경우 조건문이기 때문에 예외가 생길 수 있음
 *                  Math.abs 항상 양수값을 return 하기 때문에 안전함.
 * 
 *                  arr[num*-1]에서 문제가 발생함.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B1788 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static int positive_arr[] = new int[1000001];

    static public void positiveFibo(int num) {
        num = Math.abs(num);

        for(int i = 2; i<= num; i++) {
            positive_arr[i] = (positive_arr[i-1] + positive_arr[i-2])%1000000000;
        }
    }

    public static void main(String[] args) throws IOException{
        int num = Integer.parseInt(input.readLine());

        positive_arr[0] = 0;
        positive_arr[1] = 1;

        positiveFibo(num);

        if(num > 1) {
            output.write(String.valueOf(1) + "\n" + String.valueOf(positive_arr[num]));
        } else if(num == 0) {
            output.write(String.valueOf(0) + "\n" + String.valueOf(positive_arr[0]));
        }else if(num <= 1){
            int checkSign = num%2 == 0 ? -1 : 1;
            num = Math.abs(num);
            output.write(String.valueOf(checkSign) + "\n" + String.valueOf(positive_arr[num]));
        } 
        

        input.close();
        output.close();
    }
}