/**
 *  문제 이름 : 집합
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 
 *              add x : S에 x 값 추가, 이미 존재하는 경우 연산 무시
 *              remove x : S에서 x를 제거한다, 이미 존재하는 경우 연산 무시
 *              check x : S에 x가 있으면 1을, 없으면 0을
 *              toggle x : S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다
 *              all : S를 {1,2,3,4,5....,20} 으로 바꾼다
 *              empty : S를 공집합으로 바꾼다다
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
import java.util.HashSet;
import java.util.StringTokenizer;

class Set {
    static HashSet<Integer> set;

    Set() {
        this.set = new HashSet<>();
    }

    public static void add(int x) {
        set.add(x);
    }

    public static void remove(int x) {
        set.remove(x);
    }

    public static int check(int x) {
        int lookup = 0;

        if(set.contains(x)) {
            lookup = 1;
        }

        return lookup;
    }

    public static void toggle(int x) {
        if(set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }
    

    public static void all() {
        for(int i = 1; i<= 20; i++) {
            set.add(i);
        }
    }

    public static void empty() {
        set.clear();
    }
}

public class B11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int commend_num = Integer.parseInt(input.readLine());

        Set commend_set = new Set();

        for(int i =0; i< commend_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String commend = token.nextToken();
            int num;

            switch (commend) {
                case "add":
                    num = Integer.parseInt(token.nextToken());

                    commend_set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(token.nextToken());

                    commend_set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(token.nextToken());

                    output.write(String.valueOf(commend_set.check(num))+"\n");
                    break;

                case "toggle":
                    num = Integer.parseInt(token.nextToken());

                    commend_set.toggle(num);
                    break;

                case "all":
                    commend_set.all();
                    break;
                case "empty":
                    commend_set.empty();
                default:
                    break;
            }
        }

        input.close();
        output.close();
    }
}
