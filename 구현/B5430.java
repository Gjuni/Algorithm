/**
 *  문제 이름 : AC
 * 
 *  난 이  도 : 골드 5
 * 
 *  아이디어 : 
 *              두 함수 R과 D가 있다. 
 *                  R : 뒤집기
 *                      순서를 뒤집는 함수
 *                  D : 버리기
 *                      첫 번째 수를 버리는 함수
 *                      배열이 비어있는데 D를 사용한 경우 에러가 발생한다.
 *              
 *              배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성  
 * 
 *  해    설 : 
 * 
 *              R이 나왔을 경우 index값을 arr_lenght -1 로 설정
 *              D가 나왔을 경우 index값을 따라 삭제 요청
 * 
 *              RR이 나왔을 경우에는 index를 다시 0으로 설정하면 됨.
 *              D가 나왔을 경우 index값에 따라 삭제 요청
 * 
 *              단 D를 할 경우 arr.lenght를 확인 후 arr.lenght가 0일 경우 error 처리
 * 
 * 
 *              + String + String 은 O(n^2) 연산이 걸리니 StringBuilder를 써라 O(n)
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.ArrayDeque;

public class B5430 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String solve(String commend, int arr_num, ArrayDeque<Integer> num_arr) {
        StringBuilder answer = new StringBuilder();

        boolean indexing_By_R = false; // 배열의 앞과 끝을 구분 짓는 역할 // R이 홀수번 나왔다면 true, R이 짝수번 나왔다면 false

        for(int i = 0; i < commend.length(); i++) {
            char curr_commend = commend.charAt(i);

            if(curr_commend == 'R') {
                indexing_By_R = indexing_By_R == false ? true : false;
            } else if(curr_commend == 'D') {
                if(num_arr.size() == 0) {
                    return "error";
                } else {
                    if(indexing_By_R) { // true이면
                        num_arr.removeLast();
                    } else {
                        num_arr.removeFirst();
                    }
                }
            }
        }

        answer.append("[");

        int size = num_arr.size();

        if(indexing_By_R) {
            for(int i = size; i > 0; i--) {
                if(i > 1) {
                    answer.append(num_arr.removeLast() + ",");
                } else {
                    answer.append(num_arr.removeLast());
                }
            }
        } else {
            for(int i =0; i< size; i++) {
                if(i < size-1) {
                    answer.append(num_arr.removeFirst() + ",");
                } else {
                    answer.append(num_arr.removeFirst());
                }
            }
        }

        

        answer.append("]");

        return answer.toString();
    }

    public static ArrayDeque<Integer> arr_parser(String arr, int arr_num) {
        ArrayDeque<Integer> cmp_arr = new ArrayDeque<Integer>();

        arr = arr.replaceAll("\\[|\\]", "");

        if(arr_num == 0 || arr.isEmpty()) {
            return cmp_arr;
        }

        String[] temp = arr.split(",");

        for(int i = 0; i < arr_num; i++) {
            cmp_arr.add(Integer.parseInt(temp[i].trim()));
        }

        return cmp_arr;
    }

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(input.readLine());

        for (int i = 0; i < tc; i++) {
            String commend = input.readLine();

            int arr_num = Integer.parseInt(input.readLine());

            String arr = input.readLine();

            ArrayDeque<Integer> num_arr = arr_parser(arr, arr_num);

            output.write(solve(commend, arr_num, num_arr)+"\n");
        }

        input.close();
        output.close();
    }
}
