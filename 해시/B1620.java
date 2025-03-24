/**
 *  문제 이름 : 나는야 포켓몬 마스터 이다솜
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 번호가 1번 부터인 포켓몬 이름이 주어진다.    
 *             도감이니 이름이나 도감 번호를 알려주면 그 포켓몬을 알려준다.
 * 
 *  해    설 : 
 *              HashMap을 2개 만들어서 한 개는 이름만 저장하는 Hash
 *              한 개는 도감 번호를 저장하는 Hash를 놓은 뒤
 *              
 *              그 어떤 값이 들어와도 return 할 수 있게 만들었다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.*;

public class B1620 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException{
        
        StringTokenizer token = new StringTokenizer(input.readLine());

        int repeat_num = Integer.parseInt(token.nextToken());
        int answer_num = Integer.parseInt(token.nextToken());

        HashMap<String,Integer> name_hash = new HashMap<>();
        HashMap<String, String> number_hash = new HashMap<>();


        for(int i = 1; i<= repeat_num; i++) {
            String name = input.readLine();

            name_hash.put(name, i);
            number_hash.put(String.valueOf(i), name);
        }

        for (int i = 0; i < answer_num; i++) {
            String answer = input.readLine();

            if(name_hash.containsKey(answer)) {
                output.write(name_hash.get(answer)+"\n");
                continue;
            } else {
                output.write(number_hash.get(answer)+"\n");
                continue;
            }
        }

        input.close();
        output.close();
    }
}
