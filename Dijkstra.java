import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra{
    static class Edge {
        int src;
        int des;
        int wt;
        public Edge (int src,int des,int wt){
            this.src=src;
            this.des=des;
            this.wt=wt;
        }
    }
    public static void creategraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    public static class Pair implements Comparable <Pair>{
        int node;
        int dis;
        public Pair(int n,int d){
            this.node=n;
            this.dis=d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dis-p2.dis;
        }
    }
    public static void  Dijkstra(ArrayList<Edge>graph[],int src,int v){
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean visi[]=new boolean[v];
        pq.add(new Pair (0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visi[curr.node]){
                visi[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e= graph[curr.node].get(i);
                    int u=e.src;
                    int _v=e.des;
                    if(dist[u]+e.wt<dist[_v]){
                        dist[_v]=dist[u]+e.wt;
                        pq.add(new Pair(_v, dist[_v]));
                    }
                }
            }  // O(E+Elog(v)) time complexity of the code 
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }

    }
    public static void main(String[] args) {
        ArrayList<Edge>graph[]=new ArrayList[6];
         creategraph(graph);
         Dijkstra(graph, 0, 6);
    }
}