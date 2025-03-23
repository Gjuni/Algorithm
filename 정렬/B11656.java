/**
 *  문제 이름 : 접미사 배열
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
 * 
 *              baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 
 *              이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
 * 
 *  해    설 : StringBuilder를 통해서 더하고 list 에 더했더니 동일한 문자열만 list에 집어넣길래 봤더니
 *              최종 참조값이 완성된 String이었기 때문에 같은 값이 list에 들어갔던 것이다.
 * 
 *              하지만 자바 String 객체에는 subString이라는 method가 존재한다.
 *              즉 index 별로  string값을 자를 수 있는 것
 *              charAt은 index 마다 Charater형으로 값을 가져왔다면 subString은 값을 나누는 것이다.
 * 
 * 
 *              subString이라는 개념을 모르고 있어서 애를 먹었지만 개념을 잡고 나니 알 것 같다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B11656 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException{

        String s = input.readLine();

        char array[] = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i);
        }

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);

        for(String ne : list) {
            output.write(ne+"\n");
        }

        input.close();
        output.close();
    }
}
