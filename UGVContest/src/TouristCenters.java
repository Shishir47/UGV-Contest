import java.util.Scanner;

public class TouristCenters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 1; t <= cases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[][] graph = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u][v] = true;
                graph[v][u] = true;
            }
            int min = Integer.MAX_VALUE;
            int[] junctions = new int[n];
            for (int i = 0; i < n; i++) {
                boolean[] visited = new boolean[n];
                int count = 0;
                dfs(graph, visited, i);
                for (int j = 0; j < n; j++) {
                    if (!visited[j]) {
                        junctions[count++] = j;
                    }
                }
                min = Math.min(min, count);
            }
            System.out.println("Case #" + t + ": " + min);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    System.out.print(junctions[i] + " ");
                }
               
                System.out.println();
            }
            }
            }
    public static void dfs(boolean[][] graph, boolean[] visited, int u) {
        visited[u] = true;
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] && !visited[v]) {
                dfs(graph, visited, v);
            }
        }
    }
}