import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
    static class Edge{
        int src;
        int des;
        public Edge(int s,int d){
            this.src=s;
            this.des=d;
        }
    }
    public static void create(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));

    }
    public static void topsort(ArrayList<Edge>graph[],int curr,boolean visi[],Stack<Integer>s){
        visi[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visi[e.des]){
                topsort(graph, e.des, visi, s);
            }
        }
        s.push(curr);
    }
    public static void Kosaraju(ArrayList<Edge>graph[],int V){
         Stack<Integer>s=new Stack<>();
         boolean visi[]=new boolean[V];
         for(int i=0;i<V;i++){                // STEP 1 DO TOPOLOGICAL SORTING AND STORE IN STACK
            if(!visi[i]){
                topsort(graph,i,visi,s);
            }
         }
         ArrayList<Edge>tran[]=new ArrayList[V];
         for (int i = 0; i < V; i++) {
             tran[i]=new ArrayList<>();         // MAKE TRANSPOSE OF THE GRAPH
             visi[i]=false ;
         }
         for (int i = 0; i < V; i++) {
            for(int j=0;j<graph[i].size();i++){
                Edge e=graph[i].get(j);
                tran[e.des].add(new Edge(e.des, e.src));
             }
         }
         while(!s.isEmpty()){
            int curr =s.pop();
            if(!visi[curr]){                   // PERFORM DFS FOR THE NEW GRAPH ACC TO STACK
                dfs(tran,curr,visi);
                System.out.println();
            }
         }

    }
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean visi[]){
        visi[curr]=true ;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visi[e.des]){
                dfs(graph, e.des, visi);
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>graph[]=new ArrayList[V];
        create(graph);
        Kosaraju(graph, V);
    }
}
