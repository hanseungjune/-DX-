import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class muskDream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int sellCount = 0;
            for (int j = 0; j < q; j++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                grid[r][c] = val;

                for(int k = 0; k < n; k++){
                    for(int l = 0; l < m; l++){
                        // 열
                        ArrayList<Integer> rowlst = new ArrayList<>();
                        for (int a = 0; a < n; a++){
                            rowlst.add(grid[a][l]);
                        }
                        // 행
                        ArrayList<Integer> collst = new ArrayList<>();
                        for (int b = 0; b < m; b++){
                            collst.add(grid[k][b]);
                        }
                        if (grid[k][l] >= Collections.max(rowlst) && grid[k][l] >= Collections.max(collst)){
                            sellCount++;
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+sellCount);
        }
    }
}
