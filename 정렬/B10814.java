/**
 *  문제 이름 : 나이순 정렬
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 나이순으로 정렬, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬
 * 
 *  해    설 : 
 *              Class 생성 시 String 객체를 사용해야함. 일반 string은  Type 에러가 뜬다.
 *              
 *              Class간 정렬 시 Comparable 인터페이스를 사용하게 되는데 Class안에 순서 정의나 return을 적절히 사용하여 사용해야함.
 * 
 * 
 *              Class에 대한 이해와 Comparator의 개념 공부를 더 해야할 것 같다.
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

class info {
    int age;
    String name;
    int order;

    public info(int age, String name, int order) {  
        this.age = age;   
        this.name = name; 
        this.order = order; 
    }
}

public class B10814 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int repeat_num = Integer.parseInt(input.readLine());
        List<info> people_list = new ArrayList<>();

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int age = Integer.parseInt(token.nextToken());
            String name = token.nextToken();

            info peopleInfo = new info(age, name, i);

            people_list.add(peopleInfo);
        }

        people_list.sort(new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                if(o1.age == o2.age)  {
                    if(o1.order != o2.order) {
                        return (o1.order - o2.order);
                    }
                } else {
                    return (o1.age - o2.age);
                }
                return 0;
            }
        });

        for(info i : people_list) {
            output.write(String.valueOf(i.age)+" "+i.name+"\n");
        }


        input.close();
        output.close();
    }
}