import java.util.*;
public class Tarzens {
    static class Edge {
        int src;
        int des;
        public Edge(int s,int d){
            this.src=s;
            this.des=d;
        }
    }
    public static void tarzensbridge(ArrayList<Edge>graph,int V){
        int dt[]=new int[V];
        int low[]=new int [V];
        boolean visi[]=new boolean[V];
        int time =0;
        for(int i=0;i<V;i++){
            if(!visi[i]){
                dfs(graph,i,-1,visi,dt,low,time);
            }
        }
    }
    public static void dfs(ArrayList<Edge>graph,int curr,int par,boolean visi[],int dt[],int low[],int time){
        visi[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int 0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);          // bit complicate but we will go through
            int neigh=e.des;
            if(neigh==par){
                continue;
            }else if(!visi[neigh]){
                dfs(graph,neigh,curr,visi,dt,low,time);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(low[curr]<dt[neigh]){
                    System.out.println("Bridge is there and between"+curr+"-------"+neigh);
                }
            } else {
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
