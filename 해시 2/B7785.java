/**
 *  문제 이름 : 회사에 있는 사람
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : enter인 경우 회사에 있는 사람이다.
 *              역순으로 출력해라.
 * 
 *  해    설 : 
 *                 Collections.reverse와 Collections.reverseOrder의 차이를 제대로 알지 못 함
 *                  reverse는 현재 list의 역순으로 정렬하는 것이고
 *                  reverseOrder는 현재 list를 사전순의 역순으로 정렬하는 method임
 * 
 *                  TreeSet은 이진Tree로 만들어진 Set임
 *                  그리고 자동 정렬이되기 때문에 알아서 내림차순으로 정렬이 된다.
 * 
 *                  => reverseOrder를 사용하여 자동 정렬을 하게 만든다.
 * 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.*;

public class B7785 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException{
        int repeat_num = Integer.parseInt(input.readLine());

        TreeSet<String> tree = new TreeSet<>(Collections.reverseOrder()); // 역순 정렬

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String name = token.nextToken();
            String is_in = token.nextToken();
            
            if(is_in.equals("enter")) {
                tree.add(name);
            } else if(is_in.equals("leave")) {
                tree.remove(name);
            }

        }        

        for(String s : tree) {
            output.write(s+"\n");
        }

        input.close();
        output.close();
    }    
}
