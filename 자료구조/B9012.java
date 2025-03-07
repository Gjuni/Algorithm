/**
 *  문제 이름 : 괄호
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : () 가 짝을 이루면 YES 아니라면 NO
 * 
 *  해    설 : Stack을 활용하여 ( 는 stack.add
 *              ) 는 바로 전 괄호를 확인하여 비어있다면 바로 NO를 출력하고
 *              ( 괄호라면 stack.pop을 하여 스택을 비워준다.
 *              
 *              이때 전체적으로 스택이 비어있다면 YES, 아니라면 NO를 출력해준다.
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
import java.util.Stack;

public class B9012 {
    public static String solved(String parthenes) {

        Stack<Character> stack = new Stack<>();

        for(int i =0; i< parthenes.length(); i++) {
            char sepaerate = parthenes.charAt(i);

            if(sepaerate == '(') {
                stack.add(sepaerate);
            } else if (sepaerate == ')') {
                
                if(stack.isEmpty()) {
                    return "NO";
                } else {
                    char temp_char = stack.peek();

                    if(temp_char == '(') {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        for(int i =0; i< num; i++) {
            String parthenes = input.readLine();

            output.write(solved(parthenes)+"\n");
        }

        input.close();
        output.close();
    }
}
