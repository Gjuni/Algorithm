/**
 *  문제 이름 : 단어 정렬
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 
 *              1. 길이가 짧은 것부터
 *              2. 길이가 같으면 사전 순으로 정렬
 *              3. 중복된 단어는 하나만 남기고 제거
 * 
 *  해    설 : 
 *              HashMap을 사용하여 정렬을 시도하였다.
 *              compareTo와 Collections.sort를 사용함
 * 
 *              이때 길이가 동일 할 시 사전 순으로 정렬하는 매소드에서
 *              map.get(o1).compareTo(map.get(o2)) 를 사용하여 정렬하였지만
 *              그 다음 값만 정렬되는 모습이 보여져 일부 정렬이 제대로 이루어지지 않았다.
 * 
 *              그 해결책으로 o1.compareTo(o2)를 사용하였다.
 * 
 *              위의 차이는
 *                  1. map.get(o1)은 사전 순이 아닌 길이 값을 비교하는 정렬을 수행하게 된다
 *                  2. 반면 o1.compareTo(o2)는 문자열 그 자체를 정렬하게 된다.
 * 
 *                  간단히 말하면 1번은 정수 값 비교
 *                  2번은 문자열 자체 비교....
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class B1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());
        HashMap<String, Integer> word_set = new HashMap<>();

        for(int i =0; i< repeat_num; i++) {
            String word = input.readLine();

            word_set.put(word, word.length());
        }

        List<String> word_list = new ArrayList<>(word_set.keySet());

        // word_list.sort(new Comparator<String>() {
        //     public int compare(String o1, String o2) {
        //         if (word_set.get(o1) > word_set.get(o2)) {
        //             return 1;
        //         } else if(word_set.get(o1) < word_set.get(o2)) {
        //             return -1; 
        //         } else {
        //             return word_set.get(o1).compareTo(word_set.get(o2));
        //         }
        //     }
        // });

        Collections.sort(word_list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(word_set.get(o1) > word_set.get(o2)) {
                    return 1;
                } else if(word_set.get(o1) < word_set.get(o2)) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for(String word_sort : word_list) {
            output.write(word_sort+"\n");
        }


        input.close();
        output.close();
    }  
}
