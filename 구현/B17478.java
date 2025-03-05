/**
 *  문제 이름 : 재귀함수가 뭔가요?
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 
 * 
 *  해    설 : 
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

public class B17478 {
    public static String recursive(int num, BufferedWriter output) throws IOException{
        if(num == 0) {
            return "라고 답변하였지.\n";
        }

        output.write("\"재귀함수가 뭔가요?\"");

        output.write("재귀함수가 뭔가요?\n");

        return recursive(num-1, output);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        output.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(num, output);

        input.close();
        output.close();
    }
}
