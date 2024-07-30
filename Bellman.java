import java.util.ArrayList;

public class Bellman{
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
    public static void BellmenFord(ArrayList<Edge>graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
            dist[i]=Integer.MAX_VALUE;}
        }
        for(int i=0;i<graph.length-1;i++){  // why fist loop in future you should look
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                int u=e.src;
                int v=e.des;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+e.wt<dist[v]){
                    dist[v]=dist[u]+e.wt;
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    } 
    public static void main(String[] args) {
        ArrayList<Edge>graph[]=new ArrayList[6];
        creategraph(graph);
        BellmenFord(graph, 0);

    }

}