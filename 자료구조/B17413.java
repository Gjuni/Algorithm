/**
 *  문제 이름 : 단어 뒤집기 2
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : <> 안에 값은 그대로 출력 나머지는 역으로 출력
 * 
 *  해    설 : 
 * 
 *          < 가 존재하면 check값을 true로 설정 한 후 이미 Stack에 값이 있는지 확인 후 존재하면 그대로 출력해줘서 stack을 비워줌
 *          > 가 끝나면 check값을 false로 설정해서 역으로 출력하게 만듬
 * 
 *          ' '가 나오면 check값에 따라 판별 true라면 스택에는 아무 것도 없으니 그냥 ' '만 출력
 *              check 값이 false라면 reverse_stack에 값이 존재하기에 역으로 출력
 * 
 *          그 외 문자라면 check 가 true일 때는 그냥 출력하면 됨
 *                       check 가 false일 때는 reverse_stack에 넣어서 < 나 ' '가 나오면 역으로 출력되게 설정
 * 
 * 
 *          마지막 값들은 ' '나 >의 값을 받지 않기 때문에 비워줘야한다. <- 이거 때문에 틀림 ㅅㅂ
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.Stack;

public class B17413 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException {
        Stack<Character> reverse_stack = new Stack<>();

        String string = input.readLine();
        boolean check = false;

        for (int i = 0; i < string.length(); i++) {
            char current_char = string.charAt(i);

            if(current_char == '<') {
                while(!reverse_stack.isEmpty()) {
                    output.write(reverse_stack.pop());
                }

                check = true;
                output.write(current_char);
            } else if(current_char == '>') {
                check = false;
                output.write(current_char);
            } else if(current_char == ' ') {
                if(check) {
                    output.write(current_char);
                } else {
                    while(!reverse_stack.isEmpty()) {
                        output.write(reverse_stack.pop());
                    }

                    output.write(current_char);
                }
            } else {
                if(check) {
                    output.write(current_char);
                } else {
                    reverse_stack.add(current_char);
                }
            }
        }

        while(!reverse_stack.isEmpty()) {
            output.write(reverse_stack.pop());
        }

        input.close();
        output.close();
    }   
}
