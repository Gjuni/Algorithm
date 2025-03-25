/**
 *  문제 이름 : 서로 다른 부분 문자열의 갯수
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
 * 
 *              abc라면 a, b, c, ab, bc, abc
 * 
 *  해    설 : subString의 개념을 잘 모르고 있었다.
 *              Java에서 SubString의 개념은 슬라이딩 윈도우 처럼 특정 index를 지정해 그 문자열을 가져올 수 있는 기능이 존재한다.
 *          
 *              즉 subString(start, end)라면 start 문자열 + end-1 문자열을 가져오게 되는 것이다.
 * 
 *              이 부분을 몰라서 StringBuilder로 구현하려고 했으나 index관련 문제들이 얽혀서 찾아보았다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.HashSet;

class B11478 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException {

        String s = input.readLine();

        HashSet<String> set = new HashSet<>();


        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                set.add(s.substring(i, j)); // endIndex는 index값에서 포함되지 않음
            }
        }
        
        output.write(String.valueOf(set.size()));

        input.close();
        output.close();
    }
}