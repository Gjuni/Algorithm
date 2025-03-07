/**
 *  문제 이름 : 듣보잡
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 듣도 못한 사람의 명단과 보도 못한 사람의 명단이 주어질 때
 *              듣도 보도 못한 사람의 명단을 구하는 프로그램
 * 
 *              듣도 못한 사람의 수 N 과 보도 못한 사람의 수 M이 주어진다.
 * 
 *  해    설 : HashMap 사용해서 중복이면 <String, Integer> 값 중 Integer값 증가 시킴
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer token = new StringTokenizer(input.readLine());

        int listened = Integer.parseInt(token.nextToken());
        int shaw = Integer.parseInt(token.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i =0; i< (listened + shaw); i++) {
            String name = input.readLine();

            // map.getOrDefault값은 int형으로 반환됨 즉 변수 값에 그 값을 저장해야됨
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        ArrayList<String> list = new ArrayList<>();
        int answer_count = 0;

        for(String name : map.keySet()) {

            int count_num = map.get(name);

            if(count_num > 1) {
                answer_count++;
                list.add(name);
            }
        }
        
        output.write(String.valueOf(answer_count)+"\n");

        Collections.sort(list);

        for(String name : list)
            output.write(name+"\n");

        input.close();
        output.close();
    }
}
