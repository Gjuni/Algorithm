/**
 *  문제 이름 : 통계학
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 * 
 *  해    설 : 
 *              산술 평균 : N개 수들의 합을 N으로 나눈 값 -> 중간에 Math.round 사용시 int값만을 사용하면 중간 연산에서 데이터 손실이 발생함
 *                                                        방지로 answer(총합)을 double 8byte로 변환 후 계산
 * 
 *              중앙 값 : N개의 수들을 증가하는 순서로 나열 했을 때 중앙에 위치한 값
 * 
 *              최빈 값 : N개 수 들 중 가장 많이 나타난 값
 * 
 *              범 위 : N개의 수들 중 최댓값과 최솟값의 차이이
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class B2108 {
    public static int average(int array[]) {
        int answer = 0;

        for(int i =0; i< array.length; i++) {
            answer += array[i];
        }

        answer = (int)Math.round((double)answer/array.length);

        return answer;
    }

    public static int middle(int array[]) {

        int mid_value = array.length/2;

        int answer = array[mid_value];

        return answer;
    }

    public static int frequent(int array[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        

        for(int i = 0; i< array.length; i++) {
            int index = map.getOrDefault(array[i], 0);

            map.put(array[i], index+1);
        }   

        int answer = 0;

        int max_fre = Collections.max(map.values()); // 빈도수에 대한 max값

        for(int key : map.keySet()) {
            if(max_fre == map.get(key)) {
                num2.add(key);
            }
        }

        Collections.sort(num2);

        if(num2.size() > 1) {
            return num2.get(1);
        } else {
            return num2.get(0);
        }
   }

    public static int range(int array[]) {
        int min = array[0];
        int max = array[array.length-1];

        int answer = max - min;

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        int array[] = new int[repeat_num];

        for(int i =0; i< repeat_num; i++) {
            array[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(array);


        output.write(String.valueOf(average(array))+"\n");
        output.write(String.valueOf(middle(array))+"\n");
        output.write(String.valueOf(frequent(array))+"\n");
        output.write(String.valueOf(range(array)));

        input.close();
        output.close();
    }
}
