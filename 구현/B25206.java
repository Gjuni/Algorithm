/**
 *  문제 이름 : 너의 평점은
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : (학점 * 과목평점)의 합을 학점의 총합으로 나눈 값
 *              P/F에서 P인 과목은 계산에 포함 X
 * 
 *  해    설 : 과목 수를 나누면 되는 줄 알았는데 평점을 나눴어야했다;;;
 *              Math.round(값 * 1000<자리수>) / 1000.0 자리수 하면 그 수 만큼 소수 점을 나타낼 수 있다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B25206 {
    public static double score(String sc) {
        double answer = 0;

        switch (sc) {
            case "A+":
                answer = 4.5;
                break;
            case "A0":
                answer = 4.0;
                break;
            case "B+":
                answer = 3.5;
                break;
            case "B0":
                answer = 3.0;
                break;
            case "C+":
                answer = 2.5;
                break;  
            case "C0":
                answer = 2.0;
                break;
            case "D+":
                answer = 1.5;
                break;  
            case "D0":
                answer = 1.0;
                break;
            case "F":
                answer = 0.0;
                break;
            default:
                answer = 0.0;
                break;
        }

        return answer;
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        double answer = 0;
        int count_divide = 0;

        for(int i =0; i< 20; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String subject = token.nextToken();
            float rating = Float.parseFloat(token.nextToken());
            String sc = token.nextToken();

            if( !sc.equals("P")) {
                answer += score(sc)*rating;
                count_divide += rating;
            }
        }

        double quotient = Math.round(answer/count_divide * 1000000) / 1000000.0;

        output.write(String.valueOf(quotient));


        input.close();
        output.close();
    }
}
