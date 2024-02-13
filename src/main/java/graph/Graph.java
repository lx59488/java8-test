package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 */
public class Graph {

    // 全局变量
    boolean found = false;

    private int v; // 顶点数

    private LinkedList<Integer> adj[]; // 邻接表 一个链表数组


    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>(); // 每个顶点对应一个链表
        }
    }

    /**
     * 添加边
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先算法
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        // visited用来记录已经被访问的节点，避免重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue是一个队列，用来记录已经被访问，但是相连节点还未被访问的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev用来记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            Integer w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                // w的相邻节点
                Integer q = adj[w].get(i);
                if (!visited[q]) {
                    // 记录p的前一个w
                    prev[q] = w;
                    if(q == t){
                        // 打印路径
                        print(prev, s, t);
                        return;
                    }
                    // 标记q为已访问
                    visited[q] = true;
                    // 将q放进队列，访问其相邻节点
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] prev, int s, int t){
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public void dfs(int s, int t){
        // 每次搜索前，先将found初始化为false
        found = false;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 用于记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) return;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            Integer q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(w, t, visited, prev);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        // 广度优先
        graph.bfs(0,6);

        // 深度优先
//        graph.dfs(0, 6);

    }
}
