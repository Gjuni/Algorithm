/**
 *  문제 이름 : 걸그룹 마스터 준석이
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 걸그룹을 구분하는 프로그램을 작성하려고 한다.
 *              1은 팀원이 주어졌을 때 그룹 이름을 알려주는 Method
 *              0은 팀이 주어졌을 때 그룹 아이돌 이름들을 사전순으로 출력하는 프로그램을 짜시오.
 * 
 *  해    설 : 
 *              팀원이 주어졌을 때 그룹 이름을 알려주는 건 문제되지 않는다.
 *              팀원이 Key로 팀이름이 Value로 들어가면 되기 때문에 일반 Hash와 다를 것이 없다.
 * 
 *              다만 팀 이름이 주어졌을 때 여러 팀원들이 매핑이 되어야하는 것이 문제이다.
 *              이 문제는 ArrayList를 Value로 넣음으로써 해결할 수 있다.
 *              
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;
import java.util.*;

public class B16165 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String argc[]) throws IOException{

        StringTokenizer token = new StringTokenizer(input.readLine());

        int team = Integer.parseInt(token.nextToken());
        int answer = Integer.parseInt(token.nextToken());

        HashMap<String, String> memberMap = new HashMap<>();
        HashMap<String, ArrayList<String>> teamMemeber = new HashMap<>(); 

        for (int i = 0; i < team; i++) {
            String team_name = input.readLine();
            int total_member = Integer.parseInt(input.readLine());

            teamMemeber.put(team_name, new ArrayList<>());

            for (int j = 0; j < total_member; j++) {
                String member_name = input.readLine();

                memberMap.put(member_name, team_name);
                teamMemeber.get(team_name).add(member_name);
            }

            Collections.sort(teamMemeber.get(team_name));
        }

        for(int i =0; i < answer; i++) {
            String name = input.readLine();
            int num = Integer.parseInt(input.readLine());

            if(num == 1) {
                output.write(memberMap.get(name)+"\n");
            } else if(num == 0) {
                for (int j = 0; j < teamMemeber.get(name).size(); j++) {
                    output.write(teamMemeber.get(name).get(j)+"\n");
                }
            }
        }

        input.close();
        output.close();
    }
}
