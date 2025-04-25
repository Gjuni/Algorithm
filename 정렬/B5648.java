/**
 *  문제 이름 : 역원소 정렬
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 모든 원소가 양의 정수인 집합이 있을 때, 원소를 거꾸로 뒤집고 그 원소를 오름차순으로 정렬하는 프로그램을 작성
 * 
 *  해    설 : ????? Number Format 에러가 뜨네..
 *              1000000000000
 *              2147483647
 * 
 *              타입을 Long을 써야됬음 10^12여서 int값을 벗어남..
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

public class B5648 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static List<Long> solve(List<Long> list) {
        List<Long> convert_list = new ArrayList<>();

        for(Long i : list) {
            convert_list.add(convertInt(i));
        }
        
        return convert_list;
    }

    public static Long convertInt(Long num) {
        long convert_int = 0;

        while(num > 0) {
            convert_int *= 10;
            convert_int += num%10;
            num /= 10;
        }
        
        return convert_int;
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        long repeat_num = Long.parseLong(token.nextToken());

        int count = 0;

        List<Long> list = new ArrayList<>();

        
        while (count < repeat_num) { 
            if(!token.hasMoreElements()) {
                token = new StringTokenizer(input.readLine());
            } else {
                list.add(Long.parseLong(token.nextToken()));
                count++;
            }
        }

        list = solve(list);

        Collections.sort(list);

        for(long i : list) {
            output.write(String.valueOf(i)+"\n");
        }


        input.close();
        output.close();
    }
}
