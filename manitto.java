import java.io.*;
import java.util.*;
class Solution {
    static class Relation {
        int from;
        int to;
        int cost;

        public Relation(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static int minCost;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 학생 수
            int M = Integer.parseInt(st.nextToken()); // 마니또 관계 수

            List<Relation> relations = new ArrayList<>();

            // 마니또 관계 입력 받기
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                relations.add(new Relation(from, to, cost));
            }

            minCost = Integer.MAX_VALUE;
            visited = new boolean[N + 1];

            // 각 학생을 시작점으로 마니또 사이클 찾기
            for (int i = 1; i <= N; i++) {
                dfs(relations, i, i, 0);
            }
            System.out.println("#" + t + " " + (minCost == Integer.MAX_VALUE ? -1 : minCost));
        }
    }

    static void dfs(List<Relation> relations, int start, int current, int totalCost) {

        for (Relation relation : relations) {
            if (relation.from == current && !visited[relation.to]) {
                visited[relation.to] = true;
                dfs(relations, start, relation.to, totalCost + relation.cost);
            }
        }

        if (current == start && (totalCost != 0 && totalCost < minCost)) {
            minCost = totalCost;
        }

        visited[current] = false;
    }
}
