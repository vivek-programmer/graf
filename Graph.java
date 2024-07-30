import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph{
     static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
     }
     public static void bfs(ArrayList<Edge>graph[],int V,boolean visi[],int start){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(visi[curr]==false){
                visi[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
     }
     public static void dfs(ArrayList<Edge>graph[],boolean visi[],int curr){
         System.out.println(curr+" ");
         visi[curr]=true;
         for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(visi[e.des]==false ){
                dfs(graph,visi,e.des);
            }
         }
     }
     public static boolean  isCylicic (ArrayList<Edge>graph[],boolean visi[],boolean rec[],int curr){
        visi[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.des]){
                return true;
            }else if(!visi[e.des]) {
                if(isCylicic(graph, visi, rec, e.des)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
     }
     public static void topsortUtil(ArrayList<Edge>graph[],int curr,boolean visi[],Stack<Integer>st){
        visi[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(visi[e.des]==false){
                topsortUtil(graph, e.des, visi, st);
            }
        }
        st.push(curr);
     }
     public static void topsort(ArrayList<Edge>graph[]){
        boolean visi[]=new boolean[graph.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<graph.length;i++){
           if(!visi[i]) topsortUtil(graph, i, visi, st);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
     }
     public static boolean isCylicicUndiredted(ArrayList<Edge>graph[],int curr,int par,boolean visi[]){
        visi[curr]=true;
        for(int i=0;i<graph[i].size();i++){
            Edge e=graph[curr].get(i);
            if(visi[e.des]&&e.des!=par){
                return true;
            }else if(!visi[e.des]){
                if(isCylicicUndiredted(graph,e.des,curr,visi)){
                    return true;
                }
            }
        }
        return false;
     }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>graph[]=new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
       
        boolean visi[]=new boolean[V];
         System.out.println( isCylicicUndiredted(graph, 0, -1, visi));
        // boolean rec[]=new boolean[V];
        // System.out.println(isCylicic(graph, visi, rec, 0));
        // for(int i=0;i<V;i++){
        //     if(visi[i]==false){
        //         dfs(graph, visi, i);
        //     }
        // }
        
        
    }
}