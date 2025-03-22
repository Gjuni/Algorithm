/**
 *  문제 이름 : 카드
 * 
 *  난 이  도 : 카드를 N 장 가지고 있다.
 *              문제는 적힌 수가 -2^62에서 2^26이다..
 *              
 *              가지고 있는 카드가 주어졌을 때, 가지고 있는 정수를 구하는 프로그램을 작성하시오.
 *              만약 가장 많이 가지고 있는 정수가 여러 가지라면 작은 것을 출력하시오.
 * 
 *  아이디어 : 처음에 String값을 썼었는데
 *              Long값으로도 받을 수 있다. 그 이유는 Long은 2^63까지 받을 수 있기 때문에 가능했던 것.
 * 
 *              String값은 음수 값을 비교가 제대로 이루어지지 않기 떄문에 Long으로 이 문제를 해결하였다.
 * 
 * 
 *              또한 연산자 문제에서
 *              현재 수(key)가 그 다음 값 보다 작아야거나,
 *              현재 수의 Count가 그 다음 값의 Count보다 같고 현재 수가 그 다음 값보다 작으면
 * 
 *              현재 정답의 수와 값을 수정해야되는데
 * 
 *              Count는 같은데 수가 작을 시 갱신이 안되는 문제를 해결하였다.
 *              => 고려할 사항을 일일이 다 적고 문제를 해결하자..
 * 
 *  해    설 : 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.HashMap;

public class B11652 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException {
        
        int N = Integer.parseInt(input.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long s = Long.parseLong(input.readLine());

            int num = map.getOrDefault(s, 0);

            map.put(s, num+1);
        }

        int count = 0;
        Long answer = Long.MAX_VALUE;

        for(Long key : map.keySet()) {
            int current_num = map.get(key);

            if(count < current_num || (count == current_num && answer > key)) {
                    count = current_num;
                    answer = key;
            }
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }

}
