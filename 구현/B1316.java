/**
 *  문제 이름 : 그룹 단어 체커
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 각 문자가 연속해서 나타나는 경우만 그룹 단어라고 지치한다.
 *              cczbcd는 모두 연속해서 나타난 문자열이지만
 *              cbcccbc는 연속해서 나타나지 않았기 때문에 그룹 단어가 아니다.
 * 
 *  해    설 : 
 *              단순 indexing문제이다.
 *              
 *              현재 위치의 알파뱃과 다음 위치의 알파뱃을 본 뒤 
 *              Class에 정의해놓은 Count값이 0이라면 그냥 그 값을 증가시킨다.
 * 
 *              curr_alpha와 next_alpha가 다르다면 
 *                  next_alpha를 확인 후 그 값이 0이라면 curr_alpha Count값을 증가시키고
 *             
 *                  next_alpha의 값이 0 이상이라면 이미 전에 나왔다는 뜻이기 때문에 return시킨다.
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


class Count {
    char alphabet;
    int count;

    Count(char alphabet, int count) {
        this.alphabet = alphabet;
        this.count = count;
    }
}

public class B1316 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static Count alpha[] = new Count[26];
    static int answer = 0;

    public static void solve(String word) {
        if (word.length() == 1) {
            answer++;
            return;
        }


        for (int i = 0; i < word.length()-1; i++) {
            int curr_alpha_index = word.charAt(i) - 'a';
            int next_alpga_index = word.charAt(i+1)- 'a';


            if(alpha[curr_alpha_index].alphabet == alpha[next_alpga_index].alphabet) {
                alpha[curr_alpha_index].count++;
            } else if (alpha[curr_alpha_index].alphabet != alpha[next_alpga_index].alphabet) {
                
                if(alpha[next_alpga_index].count == 0) {
                    alpha[curr_alpha_index].count++;
                } else if (alpha[next_alpga_index].count > 0) {
                    return;
                }
            }
        }

        int curr_alpha_index = word.charAt(word.length()-2) - 'a';
        int next_alpga_index = word.charAt(word.length()-1) - 'a';


            if(alpha[curr_alpha_index].alphabet == alpha[next_alpga_index].alphabet) {
                alpha[next_alpga_index].count++;
            } else if (alpha[curr_alpha_index].alphabet != alpha[next_alpga_index].alphabet) {
                
                if(alpha[next_alpga_index].count == 0) {
                    alpha[next_alpga_index].count++;
                } else if (alpha[next_alpga_index].count > 0) {
                    return;
                }
            }

        answer++;
        return;
    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(input.readLine());

        for (int g = 0; g < tc; g++) {

            for (int i = 0; i < 26; i++) {            
                alpha[i] = new Count((char)('a'+i), 0);
            }

            String word = input.readLine();

            solve(word);
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
