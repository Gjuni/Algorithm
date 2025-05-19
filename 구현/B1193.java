/**
 *  문제 이름 : 분수 찾기
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 
 *              1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> 1/3 . . .
 *              지그재그 순서로 차례대로 진행된다.
 * 
 *              num이 주어졌을 때, num 번째 분수를 구하는 프로그램을 작성해라.
 * 
 *  해    설 : 
 *              1: 1/1
 *              2: 1/2 2/1
 *              3: 3/1 2/2 1/3
 *              4: 1/4 2/3 3/2 4/1
 *              5: 5/1 4/2 3/3 2/4 1/5
 *  
 *              홀수 : 분자 -1, 분모 +1
 *              짝수 : 분자 +1, 분모 -1
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B1193 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int num = Integer.parseInt(input.readLine());

        int line = 0;
        
        while(num > line) { // line당 숫자가 갯수만큼 빠지니
            num -= line;
            line++; // 숫자를 증가시킴 (line 당 분수들의 갯수가 빠지기 때문)
        }

        int a = num;
        int b = line - num +1;

        if(line%2 == 0) {
            output.write(String.valueOf(a)+"/"+String.valueOf(b));
        } else {
            output.write(String.valueOf(b)+"/"+String.valueOf(a));
        }
        

        input.close();
        output.close();
    }
}
