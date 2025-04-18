/**
 *  문제 이름 : 국영수
 * 
 *  난 이  도 : 
 *              1. 국어 점수가 감소하는 순
 *              2. 국어 점수가 같다면 영어 점수가 증가하는 순
 *              3. 국, 영이 동일하다면 수학 점수가 감소
 *              4. 모든 점수가 같다면 이름이 사전 순으로 증가하는 순
 * 
 * 
 *  아이디어 : sort에서 양수라면 내림차순
 *              음수라면 오름차순
 * 
 *  해    설 : 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

 class grade {
    String name;
    int korean;
    int english;
    int math;

    public grade(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
 }

 public class B10825 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{
         int repeat_num = Integer.parseInt(input.readLine());
         List<grade> list = new ArrayList<>();

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String name = token.nextToken();
            int korean = Integer.parseInt(token.nextToken());
            int english = Integer.parseInt(token.nextToken());
            int math = Integer.parseInt(token.nextToken());

            grade pp = new grade(name, korean, english, math);

            list.add(pp);
        }
        
        list.sort(new Comparator<grade>() {
            @Override
            public int compare(grade o1, grade o2) {
                if(o1.korean == o2.korean) {
                    if(o1.english == o2.english) {
                        if(o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.english - o2.english;
                }
                return o2.korean - o1.korean; // 감소하는 순
            }
        });

        for(grade i : list) {
            output.write(i.name+"\n");
        }

         input.close();
         output.close();
     }
 }